import java.io.BufferedReader; // Para poder usar BufferedReader en esta clase.
import java.io.BufferedWriter; // Para poder usar BufferedWriter en esta clase.
import java.io.IOException; // Para poder usar IOException en esta clase.
import java.nio.charset.StandardCharsets; // Para poder usar StandardCharsets en esta clase.
import java.nio.file.Files; // Para poder usar Files en esta clase.
import java.nio.file.Path; // Para poder usar Path en esta clase.
import java.nio.file.Paths; // Para poder usar Paths en esta clase.
import java.util.ArrayList; // Para poder usar ArrayList en esta clase.
import java.util.List; // Para poder usar List en esta clase.

public class PersistenciaTexto // Aquí reunimos los datos y funciones de PersistenciaTexto.
{
    private String nombreArchivo; // Para guardar el nombre del archivo.

    public PersistenciaTexto(String nombreArchivo) // Para crear un objeto PersistenciaTexto con sus datos iniciales.
    {
        this.nombreArchivo = nombreArchivo; // Guardamos aquí el nombre del archivo recibido.
    }

    public String getNombreArchivo() // Para obtener el nombre del archivo.
    {
        return nombreArchivo; // Devolvemos el nombre del archivo.
    }

    public void setNombreArchivo(String nombreArchivo) // Para cambiar el nombre del archivo.
    {
        this.nombreArchivo = nombreArchivo; // Guardamos aquí el nombre del archivo recibido.
    }

    public boolean cargar(RegistroCivil registro) throws IOException // Para cargar los datos guardados en el archivo.
    {
        Path ruta = Paths.get(nombreArchivo); // Guardamos la ruta del archivo para usarlo después.
        if (!Files.exists(ruta)) // Comprobamos esta condición antes de continuar.
        {
            return false; // Indicamos que la operación no se pudo realizar.
        }

        List<Region> regionesCargadas = new ArrayList<>(); // Creamos y guardamos las regiones leídas desde el archivo para usarlo después.
        try (BufferedReader lector = Files.newBufferedReader(ruta, StandardCharsets.UTF_8)) // Intentamos esta operación porque podría fallar.
        {
            String linea; // Usamos este dato para continuar el proceso.
            int numeroLinea = 0; // Guardamos el número de línea para usarlo después.
            while ((linea = lector.readLine()) != null) // Repetimos el proceso mientras se cumpla la condición.
            {
                numeroLinea++; // Aumentamos el contador para avanzar a la línea siguiente.
                if (linea.trim().isEmpty() || linea.startsWith("#")) // Comprobamos si el texto o la lista está vacío.
                {
                    continue; // Saltamos al siguiente elemento del recorrido.
                }
                try // Intentamos esta operación porque podría fallar.
                {
                    cargarLinea(linea, regionesCargadas); // Llamamos a cargarLinea para continuar el proceso.
                }
                catch (InvalidDateException | NumberFormatException e) // Manejamos aquí el error si llega a ocurrir.
                {
                    throw new IOException("Error en la linea " + numeroLinea, e); // Detenemos la operación y avisamos el problema.
                }
            }
        }
        registro.setRegiones(regionesCargadas); // Llamamos a registro.setRegiones para continuar el proceso.
        return true; // Indicamos que la operación resultó correctamente.
    }

    private void cargarLinea(String linea, List<Region> regiones) // Para convertir una línea del archivo en datos del sistema.
    throws IOException, InvalidDateException // Añadimos estos datos a la instrucción anterior.
    {
        String[] datos = linea.split("\\|", -1); // Guardamos el valor de datos para usarlo después.
        if (datos[0].equals("R") && datos.length == 2) // Comparamos los valores para saber si representan lo mismo.
        {
            regiones.add(new Region(datos[1])); // Llamamos a regiones.add para continuar el proceso.
            return; // Devolvemos el valor de return.
        }
        if (!datos[0].equals("P") || datos.length != 17) // Comparamos los valores para saber si representan lo mismo.
        {
            throw new IOException("Formato de linea no valido"); // Detenemos la operación y avisamos el problema.
        }

        Region region = buscarRegion(regiones, datos[1]); // Guardamos la región para usarlo después.
        if (region == null) // Comprobamos si el dato existe antes de usarlo.
        {
            throw new IOException("La region de la persona no existe"); // Detenemos la operación y avisamos el problema.
        }

        Fecha nacimiento = new Fecha(numero(datos[6]), numero(datos[7]), numero(datos[8])); // Creamos y guardamos la fecha de nacimiento para usarlo después.
        Domicilio lugarNacimiento; // Usamos este dato para continuar el proceso.
        if (Boolean.parseBoolean(datos[11])) // Comprobamos esta condición antes de continuar.
        {
            lugarNacimiento = new Domicilio(true); // Guardamos el nuevo valor en el lugar de nacimiento.
        }
        else // Usamos esta alternativa cuando la condición anterior no se cumple.
        {
            lugarNacimiento = new Domicilio(datos[9], datos[10]); // Guardamos el nuevo valor en el lugar de nacimiento.
        }

        Estado estado; // Usamos este dato para continuar el proceso.
        if (datos[12].equals("FALLECIDO")) // Comparamos los valores para saber si representan lo mismo.
        {
            Fecha defuncion = new Fecha(numero(datos[13]), numero(datos[14]), numero(datos[15])); // Creamos y guardamos el valor de defuncion para usarlo después.
            estado = new Fallecido(new Estado(nacimiento, lugarNacimiento), defuncion, datos[16]); // Guardamos el nuevo valor en el estado de la persona.
        }
        else // Usamos esta alternativa cuando la condición anterior no se cumple.
        {
            estado = new Vivo(nacimiento, lugarNacimiento); // Guardamos el nuevo valor en el estado de la persona.
        }

        Persona persona = new Persona(datos[2], datos[3], datos[4], datos[5], estado); // Creamos y guardamos la persona para usarlo después.
        region.getPersonas().put(persona.getRut(), persona); // Llamamos a region.getPersonas para continuar el proceso.
    }

    public void guardar(RegistroCivil registro) throws IOException // Para guardar los datos en el archivo.
    {
        Path ruta = Paths.get(nombreArchivo); // Guardamos la ruta del archivo para usarlo después.
        try (BufferedWriter escritor = Files.newBufferedWriter(ruta, StandardCharsets.UTF_8)) // Intentamos esta operación porque podría fallar.
        {
            escritor.write("# Archivo de datos del Registro Civil"); // Llamamos a escritor.write para continuar el proceso.
            escritor.newLine(); // Llamamos a escritor.newLine para continuar el proceso.
            for (Region region : registro.getRegiones()) // Recorremos los elementos uno por uno.
            {
                escritor.write("R|" + limpiar(region.getNombre())); // Llamamos a escritor.write para continuar el proceso.
                escritor.newLine(); // Llamamos a escritor.newLine para continuar el proceso.
                for (Persona persona : region.getPersonas().values()) // Recorremos los elementos uno por uno.
                {
                    escritor.write(lineaPersona(region, persona)); // Llamamos a escritor.write para continuar el proceso.
                    escritor.newLine(); // Llamamos a escritor.newLine para continuar el proceso.
                }
            }
        }
    }

    private String lineaPersona(Region region, Persona persona) // Para convertir una persona en una línea de texto.
    {
        Estado estado = persona.getDatosPer(); // Guardamos el estado de la persona para usarlo después.
        Fecha nacimiento = estado.getNacimiento(); // Guardamos la fecha de nacimiento para usarlo después.
        Domicilio lugar = estado.getLugarNacimiento(); // Guardamos el lugar para usarlo después.
        String tipo = estado instanceof Fallecido ? "FALLECIDO" : "VIVO"; // Guardamos el tipo de estado de la persona para usarlo después.
        String diaDefuncion = ""; // Guardamos el valor de dia defuncion para usarlo después.
        String mesDefuncion = ""; // Guardamos el valor de mes defuncion para usarlo después.
        String anoDefuncion = ""; // Guardamos el valor de ano defuncion para usarlo después.
        String causa = ""; // Guardamos la causa de fallecimiento para usarlo después.

        if (estado instanceof Fallecido) // Comprobamos si la persona está fallecida.
        {
            Fallecido fallecido = (Fallecido) estado; // Guardamos el valor de fallecido para usarlo después.
            diaDefuncion = String.valueOf(fallecido.getFechaDefuncion().getDia()); // Guardamos el nuevo valor en el valor de dia defuncion.
            mesDefuncion = String.valueOf(fallecido.getFechaDefuncion().getMes()); // Guardamos el nuevo valor en el valor de mes defuncion.
            anoDefuncion = String.valueOf(fallecido.getFechaDefuncion().getAno()); // Guardamos el nuevo valor en el valor de ano defuncion.
            causa = fallecido.getCausaFallecimiento(); // Guardamos el nuevo valor en la causa de fallecimiento.
        }

        return "P|" + limpiar(region.getNombre()) // Devolvemos el valor de "p|" + limpiar(region.get nombre()).
            + "|" + limpiar(persona.getNombre()) // Añadimos esta parte al valor anterior.
            + "|" + limpiar(persona.getRut()) // Añadimos esta parte al valor anterior.
            + "|" + limpiar(persona.getEstadoCivil()) // Añadimos esta parte al valor anterior.
            + "|" + limpiar(persona.getComuna()) // Añadimos esta parte al valor anterior.
            + "|" + nacimiento.getDia() // Añadimos esta parte al valor anterior.
            + "|" + nacimiento.getMes() // Añadimos esta parte al valor anterior.
            + "|" + nacimiento.getAno() // Añadimos esta parte al valor anterior.
            + "|" + limpiar(lugar.getRegion()) // Añadimos esta parte al valor anterior.
            + "|" + limpiar(lugar.getComuna()) // Añadimos esta parte al valor anterior.
            + "|" + lugar.isExtranjero() // Añadimos esta parte al valor anterior.
            + "|" + tipo // Añadimos esta parte al valor anterior.
            + "|" + diaDefuncion // Añadimos esta parte al valor anterior.
            + "|" + mesDefuncion // Añadimos esta parte al valor anterior.
            + "|" + anoDefuncion // Añadimos esta parte al valor anterior.
            + "|" + limpiar(causa); // Añadimos esta parte al valor anterior.
    }

    private Region buscarRegion(List<Region> regiones, String nombre) // Para encontrar una región por su nombre.
    {
        for (Region region : regiones) // Recorremos los elementos uno por uno.
        {
            if (region.getNombre().equalsIgnoreCase(nombre)) // Comparamos los valores para saber si representan lo mismo.
            {
                return region; // Devolvemos la región.
            }
        }
        return null; // Indicamos que no encontramos ningún resultado.
    }

    private int numero(String valor) // Para convertir un texto en número.
    {
        return Integer.parseInt(valor); // Devolvemos el valor de integer.parse int(valor).
    }

    private String limpiar(String texto) // Para preparar un texto antes de guardarlo.
    {
        if (texto == null) // Comprobamos si el dato existe antes de usarlo.
        {
            return ""; // Devolvemos el valor de "".
        }
        return texto.replace('|', '/').replace('\n', ' ').replace('\r', ' '); // Devolvemos el valor de texto.replace('|', '/').replace('\n', ' ').replace('\r', ' ').
    }
}
