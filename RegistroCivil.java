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

    public int cantidadRegiones() // Para saber cuántas regiones hay registradas.
    {
        return regiones.size(); // Devolvemos la cantidad de regiones.
    }

    public Region obtenerRegion(int indice) // Para obtener una región individual por su posición.
    {
        if (!indiceValido(indice)) // Comprobamos que la posición sea válida.
        {
            return null; // Indicamos que la región no existe.
        }
        return regiones.get(indice); // Devolvemos solamente la región solicitada.
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
        return region.agregarPersona(persona); // Agregamos la persona mediante la región.
    }

    public Persona buscarPorRut(String rut) // Para encontrar una persona por su RUT.
    {
        for (Region region : regiones) // Recorremos los elementos uno por uno.
        {
            Persona persona = region.buscarPersona(rut); // Buscamos la persona dentro de la región.
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
        return regiones.get(indiceRegion).buscarPersona(rut); // Devolvemos la persona encontrada en la región.
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
        return regiones.get(indiceRegion).eliminarPersona(rut); // Eliminamos la persona mediante la región.
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

        Persona primeraPersona = buscarPersonaHabilitadaParaMatrimonio(primerRut); // Buscamos la primera persona viva y soltera.
        Persona segundaPersona = buscarPersonaHabilitadaParaMatrimonio(segundoRut); // Buscamos la segunda persona viva y soltera.
        if (primeraPersona == null || segundaPersona == null) // Comprobamos si ambas personas pueden casarse.
        {
            throw new MatrimonioNoPermitidoException( // Detenemos la operación y avisamos el problema.
            "Ambas personas deben estar vivas y solteras."); // Usamos este dato para continuar el proceso.
        }

        primeraPersona.setEstadoCivil("Casado/a"); // Cambiamos el estado civil de la primera persona.
        segundaPersona.setEstadoCivil("Casado/a"); // Cambiamos el estado civil de la segunda persona.
    }

    private Persona buscarPersonaHabilitadaParaMatrimonio(String rut) // Para buscar sin construir ni devolver una colección.
    {
        for (Region region : regiones) // Recorremos las regiones en su orden original.
        {
            for (int i = 0; i < region.cantidadPersonas(); i++) // Recorremos las personas de la región.
            {
                Persona persona = region.obtenerPersona(i); // Obtenemos solamente una persona.
                if (estaHabilitadaParaMatrimonio(persona) && persona.getRut().equalsIgnoreCase(rut)) // Conservamos la primera coincidencia habilitada.
                {
                    return persona; // Devolvemos solamente la persona encontrada.
                }
            }
        }
        return null; // Indicamos que no hay una persona habilitada con ese RUT.
    }

    private boolean estaHabilitadaParaMatrimonio(Persona persona) // Para comprobar si una persona puede casarse.
    {
        boolean estaViva = !persona.getDatosPer().isFallecido(); // Guardamos si la persona está viva.
        boolean estaSoltera = persona.getEstadoCivil().toLowerCase().startsWith("solter"); // Guardamos si la persona está soltera.
        return estaViva && estaSoltera; // Indicamos si cumple ambas condiciones.
    }

    private boolean indiceValido(int indice) // Para comprobar que una posición exista en la lista.
    {
        return indice >= 0 && indice < regiones.size(); // Devolvemos el valor de indice >= 0 && indice < regiones.size().
    }
}
