public class Estado // Aquí reunimos los datos y funciones de Estado.
{
    private Fecha nacimiento; // Para guardar la fecha de nacimiento.
    private Domicilio lugarNacimiento; // Para guardar el lugar de nacimiento.
    private boolean fallecido; // Para guardar el valor de fallecido.

    public Estado(Fecha n, Domicilio l) // Para crear un objeto Estado con sus datos iniciales.
    {
        this.nacimiento = n; // Guardamos aquí la fecha de nacimiento recibido.
        this.lugarNacimiento = l; // Guardamos aquí el lugar de nacimiento recibido.
        this.fallecido = false; // Guardamos aquí el valor de fallecido recibido.
    }

    public Fecha getNacimiento() // Para obtener la fecha de nacimiento.
    {
        return nacimiento; // Devolvemos la fecha de nacimiento.
    }

    public void setNacimiento(Fecha nacimiento) // Para cambiar la fecha de nacimiento.
    {
        this.nacimiento = nacimiento; // Guardamos aquí la fecha de nacimiento recibido.
    }

    public Domicilio getLugarNacimiento() // Para obtener el lugar de nacimiento.
    {
        return lugarNacimiento; // Devolvemos el lugar de nacimiento.
    }

    public void setLugarNacimiento(Domicilio lugarNacimiento) // Para cambiar el lugar de nacimiento.
    {
        this.lugarNacimiento = lugarNacimiento; // Guardamos aquí el lugar de nacimiento recibido.
    }

    public boolean isFallecido() // Para saber el valor de fallecido.
    {
        return fallecido; // Devolvemos el valor de fallecido.
    }

    public void setFallecido(boolean fallecido) // Para cambiar el valor de fallecido.
    {
        this.fallecido = fallecido; // Guardamos aquí el valor de fallecido recibido.
    }

    public void imprimirCertificado() // Para mostrar los datos del certificado.
    {
        System.out.println("Fecha de nacimiento: " + nacimiento);
        System.out.println("Lugar de nacimiento: "
            + lugarNacimiento.getComuna() + ", " + lugarNacimiento.getRegion());
    }

}
