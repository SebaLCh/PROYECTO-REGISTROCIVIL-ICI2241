public class Persona // Aquí reunimos los datos y funciones de Persona.
{
    private String nombre; // Para guardar el nombre.
    private String rut; // Para guardar el RUT.
    private String estadoCivil; // Para guardar el estado civil.
    private String comuna; // Para guardar la comuna.
    private Estado datosPer; // Para guardar los datos personales.

    public Persona(String nombre, String rut, String estadoCivil, String comuna, Estado datosPer) // Para crear un objeto Persona con sus datos iniciales.
    {
        this.nombre = nombre; // Guardamos aquí el nombre recibido.
        this.rut = rut; // Guardamos aquí el RUT recibido.
        this.estadoCivil = estadoCivil; // Guardamos aquí el estado civil recibido.
        this.comuna = comuna; // Guardamos aquí la comuna recibido.
        this.datosPer = datosPer; // Guardamos aquí los datos personales recibido.
    }

    public String getNombre() // Para obtener el nombre.
    {
        return nombre; // Devolvemos el nombre.
    }

    public void setNombre(String nombre) // Para cambiar el nombre.
    {
        this.nombre = nombre; // Guardamos aquí el nombre recibido.
    }

    public String getRut() // Para obtener el RUT.
    {
        return rut; // Devolvemos el RUT.
    }

    public void setRut(String r) // Para cambiar el RUT.
    {
        this.rut = r; // Guardamos aquí el RUT recibido.
    }

    public void setEstadoCivil(String e) // Para cambiar el estado civil.
    {
        this.estadoCivil = e; // Guardamos aquí el estado civil recibido.
    }

    public void setComuna(String c) // Para cambiar la comuna.
    {
        this.comuna = c; // Guardamos aquí la comuna recibido.
    }

    public String getEstadoCivil() // Para obtener el estado civil.
    {
        return estadoCivil; // Devolvemos el estado civil.
    }

    public String getComuna() // Para obtener la comuna.
    {
        return comuna; // Devolvemos la comuna.
    }

    public Estado getDatosPer() // Para obtener los datos personales.
    {
        return datosPer; // Devolvemos los datos personales.
    }

    public void setDatosPer(Estado datosPer) // Para cambiar los datos personales.
    {
        this.datosPer = datosPer; // Guardamos aquí los datos personales recibido.
    }
}
