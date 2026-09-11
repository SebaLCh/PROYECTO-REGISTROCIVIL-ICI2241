import java.util.Map; // Para poder usar Map en esta clase.
import java.util.Scanner; // Para poder usar Scanner en esta clase.

public class MenuConsola // Aquí reunimos los datos y funciones de MenuConsola.
{
    private RegistroCivil registro; // Para guardar el registro civil.
    private Scanner scan; // Para guardar el lector de datos de la consola.

    public MenuConsola(RegistroCivil registro) // Para crear un objeto MenuConsola con sus datos iniciales.
    {
        this.registro = registro; // Guardamos aquí el registro civil recibido.
        this.scan = new Scanner(System.in); // Guardamos aquí el lector de datos de la consola recibido.
    }

    public RegistroCivil getRegistro() // Para obtener el registro civil.
    {
        return registro; // Devolvemos el registro civil.
    }

    public void setRegistro(RegistroCivil registro) // Para cambiar el registro civil.
    {
        this.registro = registro; // Guardamos aquí el registro civil recibido.
    }

    public Scanner getScan() // Para obtener el lector de datos de la consola.
    {
        return scan; // Devolvemos el lector de datos de la consola.
    }

    public void setScan(Scanner scan) // Para cambiar el lector de datos de la consola.
    {
        this.scan = scan; // Guardamos aquí el lector de datos de la consola recibido.
    }

    public void iniciar() // Para iniciar el menú de consola.
    {
        String opcion = ""; // Guardamos la opción elegida para usarlo después.
        while (!opcion.equals("0")) // Repetimos el proceso mientras se cumpla la condición.
        {
            mostrarMenu(); // Llamamos a mostrarMenu para continuar el proceso.
            opcion = scan.nextLine().trim(); // Guardamos el nuevo valor en la opción elegida.
            try // Intentamos esta operación porque podría fallar.
            {
                ejecutarOpcion(opcion); // Llamamos a ejecutarOpcion para continuar el proceso.
            }
            catch (InvalidDateException e) // Manejamos aquí el error si llega a ocurrir.
            {
                System.out.println(e.getMessage());
            }
            catch (MatrimonioNoPermitidoException e) // Manejamos aquí el error si llega a ocurrir.
            {
                System.out.println("No se pudo acreditar el matrimonio.");
                System.out.println(e.getMessage());
            }
            catch (NumberFormatException e) // Manejamos aquí el error si llega a ocurrir.
            {
                System.out.println("Debe ingresar un numero valido.");
            }
        }
    }

    private void ejecutarOpcion(String opcion) // Para ejecutar la opción elegida en el menú.
    throws InvalidDateException, MatrimonioNoPermitidoException // Añadimos estos datos a la instrucción anterior.
    {
        switch (opcion) // Elegimos una acción según la opción recibida.
        {
            case "1": // Este caso corresponde a la opción indicada.
            agregarRegion(); // Llamamos a agregarRegion para continuar el proceso.
            break; // Terminamos este caso y evitamos pasar al siguiente.
            case "2": // Este caso corresponde a la opción indicada.
            listarRegiones(); // Llamamos a listarRegiones para continuar el proceso.
            break; // Terminamos este caso y evitamos pasar al siguiente.
            case "3": // Este caso corresponde a la opción indicada.
            editarRegion(); // Llamamos a editarRegion para continuar el proceso.
            break; // Terminamos este caso y evitamos pasar al siguiente.
            case "4": // Este caso corresponde a la opción indicada.
            eliminarRegion(); // Llamamos a eliminarRegion para continuar el proceso.
            break; // Terminamos este caso y evitamos pasar al siguiente.
            case "5": // Este caso corresponde a la opción indicada.
            buscarRegion(); // Llamamos a buscarRegion para continuar el proceso.
            break; // Terminamos este caso y evitamos pasar al siguiente.
            case "6": // Este caso corresponde a la opción indicada.
            agregarPersona(); // Llamamos a agregarPersona para continuar el proceso.
            break; // Terminamos este caso y evitamos pasar al siguiente.
            case "7": // Este caso corresponde a la opción indicada.
            listarPersonas(); // Llamamos a listarPersonas para continuar el proceso.
            break; // Terminamos este caso y evitamos pasar al siguiente.
            case "8": // Este caso corresponde a la opción indicada.
            editarPersona(); // Llamamos a editarPersona para continuar el proceso.
            break; // Terminamos este caso y evitamos pasar al siguiente.
            case "9": // Este caso corresponde a la opción indicada.
            eliminarPersona(); // Llamamos a eliminarPersona para continuar el proceso.
            break; // Terminamos este caso y evitamos pasar al siguiente.
            case "10": // Este caso corresponde a la opción indicada.
            buscarPersona(); // Llamamos a buscarPersona para continuar el proceso.
            break; // Terminamos este caso y evitamos pasar al siguiente.
            case "11": // Este caso corresponde a la opción indicada.
            acreditarMatrimonio(); // Llamamos a acreditarMatrimonio para continuar el proceso.
            break; // Terminamos este caso y evitamos pasar al siguiente.
            case "0": // Este caso corresponde a la opción indicada.
            System.out.println("Programa finalizado.");
            break; // Terminamos este caso y evitamos pasar al siguiente.
            default: // Este caso se usa cuando ninguna opción coincide.
            System.out.println("Opcion no valida.");
        }
    }

    private void mostrarMenu() // Para mostrar las opciones del menú.
    {
        System.out.println("==== SISTEMA DE REGISTRO CIVIL ====");
        System.out.println("--- Regiones ---");
        System.out.println("1. Agregar region");
        System.out.println("2. Listar regiones");
        System.out.println("3. Editar region");
        System.out.println("4. Eliminar region");
        System.out.println("5. Buscar region");
        System.out.println("--- Personas ---");
        System.out.println("6. Agregar persona");
        System.out.println("7. Listar personas de una region");
        System.out.println("8. Editar persona");
        System.out.println("9. Eliminar persona");
        System.out.println("10. Buscar persona por RUT");
        System.out.println("--- Tramites ---");
        System.out.println("11. Acreditar matrimonio");
        System.out.println("0. Salir");
        System.out.print("Opcion: ");
    }

    private void agregarRegion() // Para agregar una región nueva.
    {
        System.out.print("Nombre de la nueva region: ");
        String nombre = scan.nextLine().trim(); // Guardamos el nombre para usarlo después.
        if (nombre.isEmpty() || !registro.agregarRegion(nombre)) // Comprobamos si el texto o la lista está vacío.
        {
            System.out.println("No se pudo agregar la region.");
        }
        else // Usamos esta alternativa cuando la condición anterior no se cumple.
        {
            System.out.println("Region agregada.");
        }
    }

    private void listarRegiones() // Para mostrar todas las regiones.
    {
        for (int i = 0; i < registro.getRegiones().size(); i++) // Recorremos los elementos uno por uno.
        {
            Region region = registro.getRegiones().get(i); // Guardamos la región para usarlo después.
            System.out.println(i + ". " + region.getNombre()
                + " - personas: " + region.getPersonas().size());
        }
    }

    private void editarRegion() // Para cambiar el nombre de una región.
    {
        listarRegiones(); // Llamamos a listarRegiones para continuar el proceso.
        int indice = pedirIndiceRegion(); // Guardamos la posición elegida para usarlo después.
        System.out.print("Nuevo nombre: ");
        String nombre = scan.nextLine().trim(); // Guardamos el nombre para usarlo después.
        if (registro.editarRegion(indice, nombre)) // Comprobamos esta condición antes de continuar.
        {
            System.out.println("Region modificada.");
        }
        else // Usamos esta alternativa cuando la condición anterior no se cumple.
        {
            System.out.println("Indice de region no valido.");
        }
    }

    private void eliminarRegion() // Para eliminar una región.
    {
        listarRegiones(); // Llamamos a listarRegiones para continuar el proceso.
        int indice = pedirIndiceRegion(); // Guardamos la posición elegida para usarlo después.
        if (registro.eliminarRegion(indice)) // Comprobamos esta condición antes de continuar.
        {
            System.out.println("Region eliminada.");
        }
        else // Usamos esta alternativa cuando la condición anterior no se cumple.
        {
            System.out.println("Indice de region no valido.");
        }
    }

    private void buscarRegion() // Para encontrar una región por su nombre.
    {
        System.out.print("Nombre de la region: ");
        String nombre = scan.nextLine().trim(); // Guardamos el nombre para usarlo después.
        Region region = registro.buscarRegion(nombre); // Guardamos la región para usarlo después.
        if (region == null) // Comprobamos si el dato existe antes de usarlo.
        {
            System.out.println("Region no encontrada.");
        }
        else // Usamos esta alternativa cuando la condición anterior no se cumple.
        {
            System.out.println(region.getNombre() + " - personas: "
                + region.getPersonas().size());
        }
    }

    private void agregarPersona() throws InvalidDateException // Para agregar una persona a una región.
    {
        listarRegiones(); // Llamamos a listarRegiones para continuar el proceso.
        int indiceRegion = pedirIndiceRegion(); // Guardamos la posición de la región para usarlo después.
        if (indiceRegion < 0 || indiceRegion >= registro.getRegiones().size()) // Comprobamos que la posición pertenezca a una región existente.
        {
            System.out.println("Indice de region no valido.");
            return; // Devolvemos el valor de return.
        }

        System.out.print("Nombre: ");
        String nombre = scan.nextLine().trim(); // Guardamos el nombre para usarlo después.
        System.out.print("RUT: ");
        String rut = scan.nextLine().trim(); // Guardamos el RUT para usarlo después.
        System.out.print("Estado civil: ");
        String estadoCivil = scan.nextLine().trim(); // Guardamos el estado civil para usarlo después.
        System.out.print("Comuna: ");
        String comuna = scan.nextLine().trim(); // Guardamos la comuna para usarlo después.
        Fecha nacimiento = pedirFecha(); // Guardamos la fecha de nacimiento para usarlo después.

        String nombreRegion = registro.nombreRegion(indiceRegion); // Guardamos el nombre de la región para usarlo después.
        Domicilio domicilio = new Domicilio(nombreRegion, comuna); // Creamos y guardamos el domicilio para usarlo después.
        Vivo estado = new Vivo(nacimiento, domicilio); // Creamos y guardamos el estado de la persona para usarlo después.
        Persona persona = new Persona(nombre, rut, estadoCivil, comuna, estado); // Creamos y guardamos la persona para usarlo después.

        if (registro.agregarPersona(indiceRegion, persona)) // Comprobamos esta condición antes de continuar.
        {
            System.out.println("Persona agregada.");
        }
        else // Usamos esta alternativa cuando la condición anterior no se cumple.
        {
            System.out.println("No se pudo agregar. Revise el RUT.");
        }
    }

    private void listarPersonas() // Para mostrar las personas de una región.
    {
        listarRegiones(); // Llamamos a listarRegiones para continuar el proceso.
        int indice = pedirIndiceRegion(); // Guardamos la posición elegida para usarlo después.
        if (indice < 0 || indice >= registro.getRegiones().size()) // Comprobamos que la posición pertenezca a una región existente.
        {
            System.out.println("Indice de region no valido.");
            return; // Devolvemos el valor de return.
        }

        Map<String, Persona> personas = registro.getRegiones().get(indice).getPersonas(); // Guardamos las personas para usarlo después.
        if (personas.isEmpty()) // Comprobamos si el texto o la lista está vacío.
        {
            System.out.println("No hay personas en esta region.");
            return; // Devolvemos el valor de return.
        }
        for (Persona persona : personas.values()) // Recorremos los elementos uno por uno.
        {
            mostrarPersona(persona); // Llamamos a mostrarPersona para continuar el proceso.
        }
    }

    private void editarPersona() // Para modificar los datos de una persona.
    {
        listarRegiones(); // Llamamos a listarRegiones para continuar el proceso.
        int indice = pedirIndiceRegion(); // Guardamos la posición elegida para usarlo después.
        System.out.print("RUT de la persona: ");
        String rut = scan.nextLine().trim(); // Guardamos el RUT para usarlo después.
        System.out.print("Nombre: ");
        String nombre = scan.nextLine().trim(); // Guardamos el nombre para usarlo después.
        System.out.print("Estado civil: ");
        String estadoCivil = scan.nextLine().trim(); // Guardamos el estado civil para usarlo después.
        System.out.print("Comuna: ");
        String comuna = scan.nextLine().trim(); // Guardamos la comuna para usarlo después.

        if (registro.editarPersona(indice, rut, nombre, estadoCivil, comuna)) // Comprobamos esta condición antes de continuar.
        {
            System.out.println("Persona modificada.");
        }
        else // Usamos esta alternativa cuando la condición anterior no se cumple.
        {
            System.out.println("Persona no encontrada.");
        }
    }

    private void eliminarPersona() // Para eliminar una persona.
    {
        listarRegiones(); // Llamamos a listarRegiones para continuar el proceso.
        int indice = pedirIndiceRegion(); // Guardamos la posición elegida para usarlo después.
        System.out.print("RUT de la persona: ");
        String rut = scan.nextLine().trim(); // Guardamos el RUT para usarlo después.
        if (registro.eliminarPersona(indice, rut)) // Comprobamos esta condición antes de continuar.
        {
            System.out.println("Persona eliminada.");
        }
        else // Usamos esta alternativa cuando la condición anterior no se cumple.
        {
            System.out.println("Persona no encontrada.");
        }
    }

    private void buscarPersona() // Para buscar una persona por su RUT.
    {
        System.out.print("RUT de la persona: ");
        String rut = scan.nextLine().trim(); // Guardamos el RUT para usarlo después.
        Persona persona = registro.buscarPorRut(rut); // Guardamos la persona para usarlo después.
        if (persona == null) // Comprobamos si el dato existe antes de usarlo.
        {
            System.out.println("Persona no encontrada.");
        }
        else // Usamos esta alternativa cuando la condición anterior no se cumple.
        {
            mostrarPersona(persona); // Llamamos a mostrarPersona para continuar el proceso.
        }
    }

    private void acreditarMatrimonio() throws MatrimonioNoPermitidoException // Para comprobar y registrar un matrimonio.
    {
        System.out.print("RUT de la primera persona: ");
        String primerRut = scan.nextLine().trim(); // Guardamos el RUT de la primera persona para usarlo después.
        System.out.print("RUT de la segunda persona: ");
        String segundoRut = scan.nextLine().trim(); // Guardamos el RUT de la segunda persona para usarlo después.

        registro.acreditarMatrimonio(primerRut, segundoRut); // Llamamos a registro.acreditarMatrimonio para continuar el proceso.
        System.out.println("Matrimonio acreditado correctamente.");
    }

    private void mostrarPersona(Persona persona) // Para mostrar los datos de una persona.
    {
        System.out.println(persona.getRut() + " | " + persona.getNombre()
            + " | " + persona.getEstadoCivil() + " | " + persona.getComuna());
    }

    private int pedirIndiceRegion() // Para pedir la posición de una región.
    {
        System.out.print("Indice de region: ");
        return Integer.parseInt(scan.nextLine().trim()); // Devolvemos el valor de integer.parse int(scan.next line().trim()).
    }

    private Fecha pedirFecha() throws InvalidDateException // Para pedir los datos y crear una fecha.
    {
        System.out.println("Fecha de nacimiento");
        System.out.print("Dia: ");
        int dia = Integer.parseInt(scan.nextLine().trim()); // Guardamos el día para usarlo después.
        System.out.print("Mes: ");
        int mes = Integer.parseInt(scan.nextLine().trim()); // Guardamos el mes para usarlo después.
        System.out.print("Ano: ");
        int ano = Integer.parseInt(scan.nextLine().trim()); // Guardamos el año para usarlo después.
        return new Fecha(dia, mes, ano); // Devolvemos el valor de new fecha(dia, mes, ano).
    }
}
