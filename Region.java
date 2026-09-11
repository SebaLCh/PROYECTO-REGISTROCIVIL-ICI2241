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

    public Map<String, Persona> getPersonas() // Para obtener las personas.
    {
        return personas; // Devolvemos las personas.
    }

    public void setPersonas(Map<String, Persona> personas) // Para cambiar las personas.
    {
        this.personas = personas; // Guardamos aquí las personas recibido.
    }
}
