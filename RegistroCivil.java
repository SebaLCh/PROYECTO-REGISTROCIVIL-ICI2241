import java.util.ArrayList; // Para poder usar ArrayList en esta clase.
import java.util.List; // Para poder usar List en esta clase.

public class RegistroCivil // Aquí reunimos los datos y funciones de RegistroCivil.
{
    private List<Region> regiones; // Para guardar la lista de regiones.

    public RegistroCivil() // Para crear un objeto RegistroCivil con sus datos iniciales.
    {
        regiones = new ArrayList<>(); // Guardamos el nuevo valor en la lista de regiones.
        cargarRegiones(); // Llamamos a cargarRegiones para continuar el proceso.
        cargarDatosIniciales(); // Llamamos a cargarDatosIniciales para continuar el proceso.
    }

    private void cargarRegiones() // Para cargar las regiones iniciales.
    {
        String[] nombres = // Guardamos los nombres de las regiones para usarlo después.
        {
            "Arica y Parinacota", "Tarapaca", "Antofagasta", "Atacama", // Añadimos estos datos a la instrucción anterior.
            "Coquimbo", "Valparaiso", "Metropolitana", "O'Higgins", // Añadimos estos datos a la instrucción anterior.
            "Maule", "Nuble", "Biobio", "La Araucania", "Los Rios", // Añadimos estos datos a la instrucción anterior.
            "Los Lagos", "Aysen", "Magallanes" // Añadimos estos datos a la instrucción anterior.
        };
        for (String nombre : nombres) // Recorremos los elementos uno por uno.
        {
            regiones.add(new Region(nombre)); // Llamamos a regiones.add para continuar el proceso.
        }
    }

    private void cargarDatosIniciales() // Para crear los datos de ejemplo.
    {
        try // Intentamos esta operación porque podría fallar.
        {
            Domicilio domicilio = new Domicilio("Valparaiso", "Vina del Mar"); // Creamos y guardamos el domicilio para usarlo después.
            Vivo vivo = new Vivo(new Fecha(15, 5, 1990), domicilio); // Creamos y guardamos un vivo para usarlo después.
            Persona persona = new Persona("Camila Vasquez", "11111111-7", "Soltera", "Vina del Mar", vivo); // Creamos y guardamos la persona para usarlo después.
            agregarPersona(5, persona); // Agregamos a la persona.
            Domicilio domicilioseba = new Domicilio("Metropolitana", "Santiago"); // Creamos y guardamos un domicilio seba para usarlo después.
            Vivo vivoseba = new Vivo(new Fecha(21, 9, 1988), domicilioseba); // Creamos y guardamos un vivo seba para usarlo después.
            Persona seba = new Persona("Sebastian Levicoy", "33333333-3", "Soltero","Estacion Central",vivoseba); // Llamamos a agregarPersona para continuar el proceso.
            agregarPersona(6, seba); // Agregamos a la persona.
            Domicilio lugar = new Domicilio("Biobio", "Concepcion"); // Creamos y guardamos el lugar para usarlo después.
            Estado estadoBase = new Estado(new Fecha(4, 8, 1940), lugar); // Creamos y guardamos un estado base para usarlo después.
            Fallecido fallecido = new Fallecido(estadoBase, new Fecha(12, 3, 2020), // Creamos y guardamos un fallecido para usarlo después.
            "Causa natural"); // Usamos este dato para continuar el proceso.
            Persona personaFallecida = new Persona("Ho-Lee Sheet", "22222222-2", "Viudo", "Concepcion", fallecido); // Usamos este dato para continuar el proceso.
            agregarPersona(10, personaFallecida); // Agregamos a la persona.
        }
        catch (InvalidDateException e) // Manejamos aquí el error si llega a ocurrir.
        {
            System.out.println("No se pudieron cargar los datos iniciales.");
        }
    }

    public List<Region> getRegiones() // Para obtener la lista de regiones.
    {
        return regiones; // Devolvemos la lista de regiones.
    }

    public void setRegiones(List<Region> regiones) // Para cambiar la lista de regiones.
    {
        this.regiones = regiones; // Guardamos aquí la lista de regiones recibido.
    }

    public boolean agregarRegion(String nombre) // Para agregar una región nueva.
    {
        if (buscarRegion(nombre) != null) // Comprobamos si el dato existe antes de usarlo.
        {
            return false; // Indicamos que la operación no se pudo realizar.
        }
        regiones.add(new Region(nombre)); // Llamamos a regiones.add para continuar el proceso.
        return true; // Indicamos que la operación resultó correctamente.
    }

    public Region buscarRegion(String nombre) // Para encontrar una región por su nombre.
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

    public boolean editarRegion(int indice, String nuevoNombre) // Para cambiar el nombre de una región.
    {
        if (!indiceValido(indice)) // Comprobamos esta condición antes de continuar.
        {
            return false; // Indicamos que la operación no se pudo realizar.
        }
        regiones.get(indice).setNombre(nuevoNombre); // Llamamos a regiones.get para continuar el proceso.
        return true; // Indicamos que la operación resultó correctamente.
    }

    public boolean eliminarRegion(int indice) // Para eliminar una región.
    {
        if (!indiceValido(indice)) // Comprobamos esta condición antes de continuar.
        {
            return false; // Indicamos que la operación no se pudo realizar.
        }
        regiones.remove(indice); // Llamamos a regiones.remove para continuar el proceso.
        return true; // Indicamos que la operación resultó correctamente.
    }

    public String nombreRegion(int indice) // Para obtener el nombre de una región por su posición.
    {
        if (!indiceValido(indice)) // Comprobamos esta condición antes de continuar.
        {
            return "Region no valida"; // Devolvemos el valor de "region no valida".
        }
        return regiones.get(indice).getNombre(); // Devolvemos el valor de regiones.get(indice).get nombre().
    }

    public boolean agregarPersona(int indiceRegion, Persona persona) // Para agregar una persona a una región.
    {
        if (!indiceValido(indiceRegion)) // Comprobamos esta condición antes de continuar.
        {
            return false; // Indicamos que la operación no se pudo realizar.
        }
        Region region = regiones.get(indiceRegion); // Guardamos la región para usarlo después.
        if (region.getPersonas().containsKey(persona.getRut())) // Comprobamos si ese RUT ya está registrado.
        {
            return false; // Indicamos que la operación no se pudo realizar.
        }
        region.getPersonas().put(persona.getRut(), persona); // Llamamos a region.getPersonas para continuar el proceso.
        return true; // Indicamos que la operación resultó correctamente.
    }

    public Persona buscarPorRut(String rut) // Para encontrar una persona por su RUT.
    {
        for (Region region : regiones) // Recorremos los elementos uno por uno.
        {
            Persona persona = region.getPersonas().get(rut); // Guardamos la persona para usarlo después.
            if (persona != null) // Comprobamos si el dato existe antes de usarlo.
            {
                return persona; // Devolvemos la persona.
            }
        }
        return null; // Indicamos que no encontramos ningún resultado.
    }

    public Persona buscarPorRut(int indiceRegion, String rut) // Para encontrar una persona por su RUT.
    {
        if (!indiceValido(indiceRegion)) // Comprobamos esta condición antes de continuar.
        {
            return null; // Indicamos que no encontramos ningún resultado.
        }
        return regiones.get(indiceRegion).getPersonas().get(rut); // Devolvemos el valor de regiones.get(indice region).get personas().get(rut).
    }

    public boolean editarPersona(int indiceRegion, String rut, String nombre, // Añadimos estos datos a la instrucción anterior.
    String estadoCivil, String comuna) // Añadimos estos datos a la instrucción anterior.
    {
        Persona persona = buscarPorRut(indiceRegion, rut); // Guardamos la persona para usarlo después.
        if (persona == null) // Comprobamos si el dato existe antes de usarlo.
        {
            return false; // Indicamos que la operación no se pudo realizar.
        }
        persona.setNombre(nombre); // Llamamos a persona.setNombre para continuar el proceso.
        persona.setEstadoCivil(estadoCivil); // Llamamos a persona.setEstadoCivil para continuar el proceso.
        persona.setComuna(comuna); // Llamamos a persona.setComuna para continuar el proceso.
        return true; // Indicamos que la operación resultó correctamente.
    }

    public boolean eliminarPersona(int indiceRegion, String rut) // Para eliminar una persona.
    {
        if (!indiceValido(indiceRegion)) // Comprobamos esta condición antes de continuar.
        {
            return false; // Indicamos que la operación no se pudo realizar.
        }
        return regiones.get(indiceRegion).getPersonas().remove(rut) != null; // Devolvemos el valor de regiones.get(indice region).get personas().remove(rut) != null.
    }

    public void imprimirCertificado(String rut) // Para mostrar los datos del certificado.
    {
        Persona persona = buscarPorRut(rut); // Guardamos la persona para usarlo después.
        if (persona == null) // Comprobamos si el dato existe antes de usarlo.
        {
            System.out.println("No se encontro una persona con ese RUT.");
            return; // Devolvemos el valor de return.
        }
        persona.getDatosPer().imprimirCertificado(); // Llamamos a persona.getDatosPer para continuar el proceso.
    }

    public void acreditarMatrimonio(String primerRut, String segundoRut) // Para comprobar y registrar un matrimonio.
    throws MatrimonioNoPermitidoException // Añadimos estos datos a la instrucción anterior.
    {
        if (primerRut.equalsIgnoreCase(segundoRut)) // Comparamos los valores para saber si representan lo mismo.
        {
            throw new MatrimonioNoPermitidoException( // Detenemos la operación y avisamos el problema.
            "Se deben ingresar dos personas distintas."); // Usamos este dato para continuar el proceso.
        }

        Persona primeraRegistrada = buscarPorRut(primerRut); // Guardamos el valor de primera registrada para usarlo después.
        Persona segundaRegistrada = buscarPorRut(segundoRut); // Guardamos la segunda persona registrada para usarlo después.
        if (primeraRegistrada == null || segundaRegistrada == null) // Comprobamos si el dato existe antes de usarlo.
        {
            throw new MatrimonioNoPermitidoException( // Detenemos la operación y avisamos el problema.
            "Una de las personas no se encuentra registrada."); // Usamos este dato para continuar el proceso.
        }

        List<Persona> habilitados = personasHabilitadasParaMatrimonio(); // Guardamos las personas habilitadas para usarlo después.
        Persona primeraPersona = buscarEnLista(habilitados, primerRut); // Guardamos el valor de primera persona para usarlo después.
        Persona segundaPersona = buscarEnLista(habilitados, segundoRut); // Guardamos la segunda persona para usarlo después.

        if (primeraPersona == null || segundaPersona == null) // Comprobamos si el dato existe antes de usarlo.
        {
            throw new MatrimonioNoPermitidoException( // Detenemos la operación y avisamos el problema.
            "Ambas personas deben estar vivas y solteras."); // Usamos este dato para continuar el proceso.
        }

        primeraPersona.setEstadoCivil("Casado/a"); // Llamamos a primeraPersona.setEstadoCivil para continuar el proceso.
        segundaPersona.setEstadoCivil("Casado/a"); // Llamamos a segundaPersona.setEstadoCivil para continuar el proceso.
    }

    private List<Persona> personasHabilitadasParaMatrimonio() // Para reunir a las personas vivas y solteras.
    {
        List<Persona> habilitados = new ArrayList<>(); // Creamos y guardamos las personas habilitadas para usarlo después.
        for (Region region : regiones) // Recorremos los elementos uno por uno.
        {
            for (Persona persona : region.getPersonas().values()) // Recorremos los elementos uno por uno.
            {
                boolean estaViva = !persona.getDatosPer().isFallecido(); // Guardamos el valor de esta viva para usarlo después.
                boolean estaSoltera = persona.getEstadoCivil().toLowerCase().startsWith("solter"); // Guardamos el valor de esta soltera para usarlo después.
                if (estaViva && estaSoltera) // Comprobamos esta condición antes de continuar.
                {
                    habilitados.add(persona); // Llamamos a habilitados.add para continuar el proceso.
                }
            }
        }
        return habilitados; // Devolvemos las personas habilitadas.
    }

    private Persona buscarEnLista(List<Persona> personas, String rut) // Para buscar una persona dentro de una lista.
    {
        for (Persona persona : personas) // Recorremos los elementos uno por uno.
        {
            if (persona.getRut().equalsIgnoreCase(rut)) // Comparamos los valores para saber si representan lo mismo.
            {
                return persona; // Devolvemos la persona.
            }
        }
        return null; // Indicamos que no encontramos ningún resultado.
    }

    private boolean indiceValido(int indice) // Para comprobar que una posición exista en la lista.
    {
        return indice >= 0 && indice < regiones.size(); // Devolvemos el valor de indice >= 0 && indice < regiones.size().
    }
}
