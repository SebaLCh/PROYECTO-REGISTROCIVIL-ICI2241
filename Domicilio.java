public class Domicilio // Aquí reunimos los datos y funciones de Domicilio.
{
    private boolean extranjero; // Para guardar si el domicilio está en el extranjero.
    private String region; // Para guardar la región.
    private String comuna; // Para guardar la comuna.

    public Domicilio(boolean extranjero) // Para crear un objeto Domicilio con sus datos iniciales.
    {
        this.extranjero = extranjero; // Guardamos aquí si el domicilio está en el extranjero recibido.
        this.region = "Extranjero"; // Guardamos aquí la región recibido.
        this.comuna = "Extranjero"; // Guardamos aquí la comuna recibido.
    }

    public Domicilio(String r, String c) // Para crear un objeto Domicilio con sus datos iniciales.
    {
        this.extranjero = false; // Guardamos aquí si el domicilio está en el extranjero recibido.
        this.region = r; // Guardamos aquí la región recibido.
        this.comuna = c; // Guardamos aquí la comuna recibido.
    }

    public boolean isExtranjero() // Para saber si el domicilio está en el extranjero.
    {
        return extranjero; // Devolvemos si el domicilio está en el extranjero.
    }

    public void setExtranjero(boolean extranjero) // Para cambiar si el domicilio está en el extranjero.
    {
        this.extranjero = extranjero; // Guardamos aquí si el domicilio está en el extranjero recibido.
    }

    public String getRegion() // Para obtener la región.
    {
        return region; // Devolvemos la región.
    }

    public void setRegion(String region) // Para cambiar la región.
    {
        this.region = region; // Guardamos aquí la región recibido.
    }

    public String getComuna() // Para obtener la comuna.
    {
        return comuna; // Devolvemos la comuna.
    }

    public void setComuna(String comuna) // Para cambiar la comuna.
    {
        this.comuna = comuna; // Guardamos aquí la comuna recibido.
    }

    public void cambioDomicilio(String r, String c) // Para cambiar el domicilio de una persona.
    {
        System.out.println("Su region fué cambiada a :" + r);
        this.region = r; // Guardamos aquí la región recibido.
        System.out.println("Su comuna fue cambiada a :" + c);
        this.comuna = c; // Guardamos aquí la comuna recibido.
    }

    public void cambioDomicilio(boolean extranjero) // Para cambiar el domicilio de una persona.
    {
        this.extranjero = extranjero; // Guardamos aquí si el domicilio está en el extranjero recibido.
        if(extranjero) // Comprobamos esta condición antes de continuar.
        {
            this.region = "Extranjero"; // Guardamos aquí la región recibido.
            this.comuna = "Extranjero"; // Guardamos aquí la comuna recibido.
        }
    }
}
