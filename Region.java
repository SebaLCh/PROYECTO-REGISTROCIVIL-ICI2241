import java.util.HashMap; // Para poder usar HashMap en esta clase.
import java.util.Map; // Para poder usar Map en esta clase.

public class Region // Aquí reunimos los datos y funciones de Region.
{
    private String nombre; // Para guardar el nombre.
    private Map<String, Persona> personas; // Para guardar las personas.

    public Region(String nombre) // Para crear un objeto Region con sus datos iniciales.
    {
        this.nombre = nombre; // Guardamos aquí el nombre recibido.
        this.personas = new HashMap<>(); // Guardamos aquí las personas recibido.
    }

    public String getNombre() // Para obtener el nombre.
    {
        return nombre; // Devolvemos el nombre.
    }

    public void setNombre(String nombre) // Para cambiar el nombre.
    {
        this.nombre = nombre; // Guardamos aquí el nombre recibido.
    }

    public int cantidadPersonas() // Para saber cuántas personas tiene la región.
    {
        return personas.size(); // Devolvemos la cantidad de personas.
    }

    public boolean estaVacia() // Para saber si la región no tiene personas.
    {
        return personas.isEmpty(); // Indicamos si no hay personas registradas.
    }

    public Persona buscarPersona(String rut) // Para buscar una persona por su RUT.
    {
        return personas.get(rut); // Devolvemos la persona encontrada.
    }

    public boolean contienePersona(String rut) // Para saber si un RUT ya está registrado.
    {
        return personas.containsKey(rut); // Indicamos si el RUT existe en la región.
    }

    public boolean agregarPersona(Persona persona) // Para agregar una persona sin exponer el mapa.
    {
        if (contienePersona(persona.getRut())) // Comprobamos si el RUT ya existe.
        {
            return false; // Indicamos que no se pudo agregar.
        }
        guardarPersona(persona); // Guardamos la persona usando su RUT.
        return true; // Indicamos que se agregó correctamente.
    }

    void guardarPersona(Persona persona) // Para cargar una persona y reemplazar un RUT repetido en el archivo.
    {
        personas.put(persona.getRut(), persona); // Conservamos la última persona registrada para ese RUT.
    }

    public boolean eliminarPersona(String rut) // Para eliminar una persona por su RUT.
    {
        return personas.remove(rut) != null; // Indicamos si se encontró y eliminó la persona.
    }

    public Persona obtenerPersona(int indice) // Para obtener una persona individual por su posición.
    {
        if (indice < 0 || indice >= personas.size()) // Comprobamos que la posición sea válida.
        {
            return null; // Indicamos que la posición no existe.
        }

        int posicion = 0; // Guardamos la posición que estamos recorriendo.
        for (Persona persona : personas.values()) // Recorremos las personas una por una.
        {
            if (posicion == indice) // Comprobamos si llegamos a la posición solicitada.
            {
                return persona; // Devolvemos solamente la persona encontrada.
            }
            posicion++; // Avanzamos a la siguiente posición.
        }
        return null; // Indicamos que no se encontró una persona.
    }
}
