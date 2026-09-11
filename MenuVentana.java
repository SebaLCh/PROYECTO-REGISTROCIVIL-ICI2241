// Usamos java swing para desplegar ventana.
import java.awt.BorderLayout; // Para poder usar BorderLayout en esta clase.
import java.awt.GridLayout; // Para poder usar GridLayout en esta clase.
import java.awt.event.WindowAdapter; // Para poder usar WindowAdapter en esta clase.
import java.awt.event.WindowEvent; // Para poder usar WindowEvent en esta clase.
import java.io.IOException; // Para poder usar IOException en esta clase.
import java.util.Map; // Para poder usar Map en esta clase.
import javax.swing.JButton; // Para poder usar JButton en esta clase.
import javax.swing.JFrame; // Para poder usar JFrame en esta clase.
import javax.swing.JOptionPane; // Para poder usar JOptionPane en esta clase.
import javax.swing.JPanel; // Para poder usar JPanel en esta clase.
import javax.swing.JScrollPane; // Para poder usar JScrollPane en esta clase.
import javax.swing.JTextArea; // Para poder usar JTextArea en esta clase.

@SuppressWarnings("serial") // Ocultamos una advertencia de Java que no afecta el programa.
public class MenuVentana extends JFrame // Aquí representamos MenuVentana usando como base la clase JFrame.
{
    private RegistroCivil registro; // Para guardar el registro civil.
    private PersistenciaTexto persistencia; // Para guardar el objeto que lee y guarda los datos.
    private JTextArea salida; // Para guardar el área donde mostramos los resultados.

    public MenuVentana(RegistroCivil registro, PersistenciaTexto persistencia) // Para crear un objeto MenuVentana con sus datos iniciales.
    {
        this.registro = registro; // Guardamos aquí el registro civil recibido.
        this.persistencia = persistencia; // Guardamos aquí el objeto que lee y guarda los datos recibido.
        prepararVentana(); // Llamamos a prepararVentana para continuar el proceso.
    }

    public RegistroCivil getRegistro() // Para obtener el registro civil.
    {
        return registro; // Devolvemos el registro civil.
    }

    public void setRegistro(RegistroCivil registro) // Para cambiar el registro civil.
    {
        this.registro = registro; // Guardamos aquí el registro civil recibido.
    }

    public PersistenciaTexto getPersistencia() // Para obtener el objeto que lee y guarda los datos.
    {
        return persistencia; // Devolvemos el objeto que lee y guarda los datos.
    }

    public void setPersistencia(PersistenciaTexto persistencia) // Para cambiar el objeto que lee y guarda los datos.
    {
        this.persistencia = persistencia; // Guardamos aquí el objeto que lee y guarda los datos recibido.
    }

    public JTextArea getSalida() // Para obtener el área donde mostramos los resultados.
    {
        return salida; // Devolvemos el área donde mostramos los resultados.
    }

    public void setSalida(JTextArea salida) // Para cambiar el área donde mostramos los resultados.
    {
        this.salida = salida; // Guardamos aquí el área donde mostramos los resultados recibido.
    }

    private void prepararVentana() // Para preparar la ventana y sus botones.
    {
        setTitle("Sistema de Registro Civil"); // Llamamos a setTitle para continuar el proceso.
        setSize(760, 500); // Llamamos a setSize para continuar el proceso.
        setLocationRelativeTo(null); // Llamamos a setLocationRelativeTo para continuar el proceso.
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); // Llamamos a setDefaultCloseOperation para continuar el proceso.

        salida = new JTextArea(); // Guardamos el nuevo valor en el área donde mostramos los resultados.
        salida.setEditable(false); // Llamamos a salida.setEditable para continuar el proceso.
        add(new JScrollPane(salida), BorderLayout.CENTER); // Llamamos a add para continuar el proceso.

        JPanel botones = new JPanel(new GridLayout(0, 2, 5, 5)); // Creamos y guardamos el valor de botones para usarlo después.
        agregarBoton(botones, "Agregar region", () -> agregarRegion()); // Llamamos a agregarBoton para continuar el proceso.
        agregarBoton(botones, "Listar regiones", () -> listarRegiones()); // Llamamos a agregarBoton para continuar el proceso.
        agregarBoton(botones, "Editar region", () -> editarRegion()); // Llamamos a agregarBoton para continuar el proceso.
        agregarBoton(botones, "Eliminar region", () -> eliminarRegion()); // Llamamos a agregarBoton para continuar el proceso.
        agregarBoton(botones, "Buscar region", () -> buscarRegion()); // Llamamos a agregarBoton para continuar el proceso.
        agregarBoton(botones, "Agregar persona", () -> agregarPersona()); // Llamamos a agregarBoton para continuar el proceso.
        agregarBoton(botones, "Listar personas", () -> listarPersonas()); // Llamamos a agregarBoton para continuar el proceso.
        agregarBoton(botones, "Editar persona", () -> editarPersona()); // Llamamos a agregarBoton para continuar el proceso.
        agregarBoton(botones, "Eliminar persona", () -> eliminarPersona()); // Llamamos a agregarBoton para continuar el proceso.
        agregarBoton(botones, "Buscar persona", () -> buscarPersona()); // Llamamos a agregarBoton para continuar el proceso.
        agregarBoton(botones, "Acreditar matrimonio", () -> acreditarMatrimonio()); // Llamamos a agregarBoton para continuar el proceso.
        add(botones, BorderLayout.WEST); // Llamamos a add para continuar el proceso.

        addWindowListener(new WindowAdapter() // Añadimos estos datos a la instrucción anterior.
        {
            @Override // Usamos nuestra propia versión del método heredado.
            public void windowClosing(WindowEvent e) // Para realizar la tarea windowClosing.
            {
                guardarYCerrar(); // Llamamos a guardarYCerrar para continuar el proceso.
            }
        });

        listarRegiones(); // Llamamos a listarRegiones para continuar el proceso.
    }

    private void agregarBoton(JPanel panel, String texto, Runnable accion) // Para crear un botón y conectarlo con su acción.
    {
        JButton boton = new JButton(texto); // Creamos y guardamos el valor de boton para usarlo después.
        boton.addActionListener(e -> accion.run()); // Llamamos a boton.addActionListener para continuar el proceso.
        panel.add(boton); // Llamamos a panel.add para continuar el proceso.
    }

    private void agregarRegion() // Para agregar una región nueva.
    {
        String nombre = pedirTexto("Nombre de la nueva region:"); // Guardamos el nombre para usarlo después.
        if (nombre == null) return; // Comprobamos si el dato existe antes de usarlo.
        if (nombre.isEmpty() || !registro.agregarRegion(nombre)) // Comprobamos si el texto o la lista está vacío.
        {
            mostrarError("No se pudo agregar la region."); // Llamamos a mostrarError para continuar el proceso.
            return; // Devolvemos el valor de return.
        }
        listarRegiones(); // Llamamos a listarRegiones para continuar el proceso.
    }

    private void listarRegiones() // Para mostrar todas las regiones.
    {
        StringBuilder texto = new StringBuilder("REGIONES\n\n"); // Creamos y guardamos el texto que mostraremos para usarlo después.
        for (int i = 0; i < registro.getRegiones().size(); i++) // Recorremos los elementos uno por uno.
        {
            Region region = registro.getRegiones().get(i); // Guardamos la región para usarlo después.
            texto.append(i).append(". ").append(region.getNombre()) // Añadimos estos datos a la instrucción anterior.
                .append(" - personas: ").append(region.getPersonas().size()) // Añadimos esta parte al texto que estamos armando.
                .append('\n'); // Añadimos esta parte al texto que estamos armando.
        }
        salida.setText(texto.toString()); // Llamamos a salida.setText para continuar el proceso.
    }

    private void editarRegion() // Para cambiar el nombre de una región.
    {
        int indice = pedirRegion(); // Guardamos la posición elegida para usarlo después.
        if (indice == -1) return; // Comprobamos esta condición antes de continuar.
        String nombre = pedirTexto("Nuevo nombre:"); // Guardamos el nombre para usarlo después.
        if (nombre == null) return; // Comprobamos si el dato existe antes de usarlo.
        if (!registro.editarRegion(indice, nombre)) // Comprobamos esta condición antes de continuar.
        {
            mostrarError("No se pudo editar la region."); // Llamamos a mostrarError para continuar el proceso.
            return; // Devolvemos el valor de return.
        }
        listarRegiones(); // Llamamos a listarRegiones para continuar el proceso.
    }

    private void eliminarRegion() // Para eliminar una región.
    {
        int indice = pedirRegion(); // Guardamos la posición elegida para usarlo después.
        if (indice == -1) return; // Comprobamos esta condición antes de continuar.
        int respuesta = JOptionPane.showConfirmDialog(this, // Guardamos la respuesta elegida para usarlo después.
        "Tambien se eliminaran las personas de esta region. ¿Continuar?", // Añadimos estos datos a la instrucción anterior.
        "Confirmar", JOptionPane.YES_NO_OPTION); // Usamos este dato para continuar el proceso.
        if (respuesta == JOptionPane.YES_OPTION) // Comprobamos esta condición antes de continuar.
        {
            registro.eliminarRegion(indice); // Llamamos a registro.eliminarRegion para continuar el proceso.
            listarRegiones(); // Llamamos a listarRegiones para continuar el proceso.
        }
    }

    private void buscarRegion() // Para encontrar una región por su nombre.
    {
        String nombre = pedirTexto("Nombre de la region:"); // Guardamos el nombre para usarlo después.
        if (nombre == null) return; // Comprobamos si el dato existe antes de usarlo.
        Region region = registro.buscarRegion(nombre); // Guardamos la región para usarlo después.
        if (region == null) // Comprobamos si el dato existe antes de usarlo.
        {
            mostrarError("Region no encontrada."); // Llamamos a mostrarError para continuar el proceso.
            return; // Devolvemos el valor de return.
        }
        salida.setText("Region: " + region.getNombre() // Añadimos estos datos a la instrucción anterior.
            + "\nPersonas registradas: " + region.getPersonas().size()); // Añadimos esta parte al valor anterior.
    }

    private void agregarPersona() // Para agregar una persona a una región.
    {
        int indice = pedirRegion(); // Guardamos la posición elegida para usarlo después.
        if (indice == -1) return; // Comprobamos esta condición antes de continuar.
        try // Intentamos esta operación porque podría fallar.
        {
            String nombre = pedirTexto("Nombre:"); // Guardamos el nombre para usarlo después.
            String rut = pedirTexto("RUT:"); // Guardamos el RUT para usarlo después.
            String estadoCivil = pedirTexto("Estado civil:"); // Guardamos el estado civil para usarlo después.
            String comuna = pedirTexto("Comuna:"); // Guardamos la comuna para usarlo después.
            if (nombre == null || rut == null || estadoCivil == null || comuna == null) return; // Comprobamos si el dato existe antes de usarlo.

            Fecha fecha = pedirFecha(); // Guardamos la fecha para usarlo después.
            if (fecha == null) return; // Comprobamos si el dato existe antes de usarlo.
            Domicilio domicilio = new Domicilio(registro.nombreRegion(indice), comuna); // Creamos y guardamos el domicilio para usarlo después.
            Persona persona = new Persona(nombre, rut, estadoCivil, comuna, // Creamos y guardamos la persona para usarlo después.
            new Vivo(fecha, domicilio)); // Usamos este dato para continuar el proceso.
            if (!registro.agregarPersona(indice, persona)) // Comprobamos esta condición antes de continuar.
            {
                mostrarError("No se pudo agregar. Revise el RUT."); // Llamamos a mostrarError para continuar el proceso.
                return; // Devolvemos el valor de return.
            }
            listarPersonas(indice); // Llamamos a listarPersonas para continuar el proceso.
        }
        catch (InvalidDateException e) // Manejamos aquí el error si llega a ocurrir.
        {
            mostrarError(e.getMessage()); // Llamamos a mostrarError para continuar el proceso.
        }
        catch (NumberFormatException e) // Manejamos aquí el error si llega a ocurrir.
        {
            mostrarError("La fecha debe contener numeros."); // Llamamos a mostrarError para continuar el proceso.
        }
    }

    private void listarPersonas() // Para mostrar las personas de una región.
    {
        int indice = pedirRegion(); // Guardamos la posición elegida para usarlo después.
        if (indice != -1) listarPersonas(indice); // Comprobamos esta condición antes de continuar.
    }

    private void listarPersonas(int indice) // Para mostrar las personas de una región.
    {
        Region region = registro.getRegiones().get(indice); // Guardamos la región para usarlo después.
        StringBuilder texto = new StringBuilder("PERSONAS DE ") // Creamos y guardamos el texto que mostraremos para usarlo después.
            .append(region.getNombre().toUpperCase()).append("\n\n"); // Añadimos esta parte al texto que estamos armando.
        for (Persona persona : region.getPersonas().values()) // Recorremos los elementos uno por uno.
        {
            texto.append(datosPersona(persona)).append('\n'); // Llamamos a texto.append para continuar el proceso.
        }
        if (region.getPersonas().isEmpty()) texto.append("No hay personas registradas."); // Comprobamos si el texto o la lista está vacío.
        salida.setText(texto.toString()); // Llamamos a salida.setText para continuar el proceso.
    }

    private void editarPersona() // Para modificar los datos de una persona.
    {
        int indice = pedirRegion(); // Guardamos la posición elegida para usarlo después.
        if (indice == -1) return; // Comprobamos esta condición antes de continuar.
        String rut = pedirTexto("RUT de la persona:"); // Guardamos el RUT para usarlo después.
        if (rut == null) return; // Comprobamos si el dato existe antes de usarlo.
        Persona persona = registro.buscarPorRut(indice, rut); // Guardamos la persona para usarlo después.
        if (persona == null) // Comprobamos si el dato existe antes de usarlo.
        {
            mostrarError("Persona no encontrada."); // Llamamos a mostrarError para continuar el proceso.
            return; // Devolvemos el valor de return.
        }

        String nombre = pedirTexto("Nombre:", persona.getNombre()); // Guardamos el nombre para usarlo después.
        String estadoCivil = pedirTexto("Estado civil:", persona.getEstadoCivil()); // Guardamos el estado civil para usarlo después.
        String comuna = pedirTexto("Comuna:", persona.getComuna()); // Guardamos la comuna para usarlo después.
        if (nombre == null || estadoCivil == null || comuna == null) return; // Comprobamos si el dato existe antes de usarlo.
        registro.editarPersona(indice, rut, nombre, estadoCivil, comuna); // Llamamos a registro.editarPersona para continuar el proceso.
        listarPersonas(indice); // Llamamos a listarPersonas para continuar el proceso.
    }

    private void eliminarPersona() // Para eliminar una persona.
    {
        int indice = pedirRegion(); // Guardamos la posición elegida para usarlo después.
        if (indice == -1) return; // Comprobamos esta condición antes de continuar.
        String rut = pedirTexto("RUT de la persona:"); // Guardamos el RUT para usarlo después.
        if (rut == null) return; // Comprobamos si el dato existe antes de usarlo.
        if (!registro.eliminarPersona(indice, rut)) // Comprobamos esta condición antes de continuar.
        {
            mostrarError("Persona no encontrada."); // Llamamos a mostrarError para continuar el proceso.
            return; // Devolvemos el valor de return.
        }
        listarPersonas(indice); // Llamamos a listarPersonas para continuar el proceso.
    }

    private void buscarPersona() // Para buscar una persona por su RUT.
    {
        String rut = pedirTexto("RUT de la persona:"); // Guardamos el RUT para usarlo después.
        if (rut == null) return; // Comprobamos si el dato existe antes de usarlo.
        Persona persona = registro.buscarPorRut(rut); // Guardamos la persona para usarlo después.
        if (persona == null) // Comprobamos si el dato existe antes de usarlo.
        {
            mostrarError("Persona no encontrada."); // Llamamos a mostrarError para continuar el proceso.
            return; // Devolvemos el valor de return.
        }
        salida.setText(datosPersona(persona)); // Llamamos a salida.setText para continuar el proceso.
    }

    private void acreditarMatrimonio() // Para comprobar y registrar un matrimonio.
    {
        String primerRut = pedirTexto("RUT de la primera persona:"); // Guardamos el RUT de la primera persona para usarlo después.
        String segundoRut = pedirTexto("RUT de la segunda persona:"); // Guardamos el RUT de la segunda persona para usarlo después.
        if (primerRut == null || segundoRut == null) return; // Comprobamos si el dato existe antes de usarlo.
        try // Intentamos esta operación porque podría fallar.
        {
            registro.acreditarMatrimonio(primerRut, segundoRut); // Llamamos a registro.acreditarMatrimonio para continuar el proceso.
            JOptionPane.showMessageDialog(this, "Matrimonio acreditado correctamente."); // Llamamos a JOptionPane.showMessageDialog para continuar el proceso.
        }
        catch (MatrimonioNoPermitidoException e) // Manejamos aquí el error si llega a ocurrir.
        {
            mostrarError(e.getMessage()); // Llamamos a mostrarError para continuar el proceso.
        }
    }

    private int pedirRegion() // Para pedir al usuario que elija una región.
    {
        if (registro.getRegiones().isEmpty()) // Comprobamos si el texto o la lista está vacío.
        {
            mostrarError("No hay regiones registradas."); // Llamamos a mostrarError para continuar el proceso.
            return -1; // Devolvemos el valor de -1.
        }
        String[] opciones = new String[registro.getRegiones().size()]; // Creamos y guardamos las opciones disponibles para usarlo después.
        for (int i = 0; i < opciones.length; i++) // Recorremos los elementos uno por uno.
        {
            opciones[i] = registro.getRegiones().get(i).getNombre(); // Usamos este dato para continuar el proceso.
        }
        String seleccion = (String) JOptionPane.showInputDialog(this, // Guardamos el valor de seleccion para usarlo después.
        "Seleccione una region:", "Regiones", JOptionPane.QUESTION_MESSAGE, // Añadimos estos datos a la instrucción anterior.
        null, opciones, opciones[0]); // Usamos este dato para continuar el proceso.
        if (seleccion == null) return -1; // Comprobamos si el dato existe antes de usarlo.
        for (int i = 0; i < opciones.length; i++) // Recorremos los elementos uno por uno.
        {
            if (opciones[i].equals(seleccion)) return i; // Comparamos los valores para saber si representan lo mismo.
        }
        return -1; // Devolvemos el valor de -1.
    }

    private Fecha pedirFecha() throws InvalidDateException, NumberFormatException // Para pedir los datos y crear una fecha.
    {
        String dia = pedirTexto("Dia de nacimiento:"); // Guardamos el día para usarlo después.
        String mes = pedirTexto("Mes de nacimiento:"); // Guardamos el mes para usarlo después.
        String ano = pedirTexto("Ano de nacimiento:"); // Guardamos el año para usarlo después.
        if (dia == null || mes == null || ano == null) return null; // Comprobamos si el dato existe antes de usarlo.
        return new Fecha(Integer.parseInt(dia), Integer.parseInt(mes), Integer.parseInt(ano)); // Devolvemos el valor de new fecha(integer.parse int(dia), integer.parse int(mes), integer.parse int(ano)).
    }

    private String pedirTexto(String mensaje) // Para pedir un texto al usuario.
    {
        String valor = JOptionPane.showInputDialog(this, mensaje); // Guardamos el valor ingresado para usarlo después.
        return valor == null ? null : valor.trim(); // Devolvemos el valor de valor == null ? null : valor.trim().
    }

    private String pedirTexto(String mensaje, String valorInicial) // Para pedir un texto al usuario.
    {
        String valor = JOptionPane.showInputDialog(this, mensaje, valorInicial); // Guardamos el valor ingresado para usarlo después.
        return valor == null ? null : valor.trim(); // Devolvemos el valor de valor == null ? null : valor.trim().
    }

    private String datosPersona(Persona persona) // Para preparar los datos de una persona como texto.
    {
        return persona.getRut() + " | " + persona.getNombre() + " | " // Devolvemos el valor de persona.get rut() + " | " + persona.get nombre() + " | ".
            + persona.getEstadoCivil() + " | " + persona.getComuna(); // Añadimos esta parte al valor anterior.
    }

    private void mostrarError(String mensaje) // Para mostrar un mensaje de error.
    {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE); // Llamamos a JOptionPane.showMessageDialog para continuar el proceso.
    }

    private void guardarYCerrar() // Para guardar los cambios antes de cerrar la ventana.
    {
        try // Intentamos esta operación porque podría fallar.
        {
            persistencia.guardar(registro); // Llamamos a persistencia.guardar para continuar el proceso.
            dispose(); // Llamamos a dispose para continuar el proceso.
        }
        catch (IOException e) // Manejamos aquí el error si llega a ocurrir.
        {
            mostrarError("No se pudieron guardar los datos: " + e.getMessage()); // Llamamos a mostrarError para continuar el proceso.
        }
    }
}
