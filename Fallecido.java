public class Fallecido extends Estado // Aquí representamos Fallecido usando como base la clase Estado.
{
    private Fecha fechaDefuncion; // Para guardar la fecha de defunción.
    private String causaFallecimiento; // Para guardar la causa de fallecimiento.

    public Fallecido(Estado estado, Fecha fechaDefuncion, String causaFallecimiento) // Para crear un objeto Fallecido con sus datos iniciales.
    {
        super(estado.getNacimiento(), estado.getLugarNacimiento()); // Enviamos los datos iniciales a la clase padre.
        this.fechaDefuncion = fechaDefuncion; // Guardamos aquí la fecha de defunción recibido.
        this.causaFallecimiento = causaFallecimiento; // Guardamos aquí la causa de fallecimiento recibido.
        setFallecido(true); // Llamamos a setFallecido para continuar el proceso.
    }

    public Fecha getFechaDefuncion() // Para obtener la fecha de defunción.
    {
        return fechaDefuncion; // Devolvemos la fecha de defunción.
    }

    public void setFechaDefuncion(Fecha fechaDefuncion) // Para cambiar la fecha de defunción.
    {
        this.fechaDefuncion = fechaDefuncion; // Guardamos aquí la fecha de defunción recibido.
    }

    public String getCausaFallecimiento() // Para obtener la causa de fallecimiento.
    {
        return causaFallecimiento; // Devolvemos la causa de fallecimiento.
    }

    public void setCausaFallecimiento(String causaFallecimiento) // Para cambiar la causa de fallecimiento.
    {
        this.causaFallecimiento = causaFallecimiento; // Guardamos aquí la causa de fallecimiento recibido.
    }

    @Override // Usamos nuestra propia versión del método heredado.
    public void imprimirCertificado() // Para mostrar los datos del certificado.
    {
        System.out.println("Certificado de Defuncion");
        super.imprimirCertificado(); // Reutilizamos el método de la clase padre.
        System.out.println("Fecha de defuncion: " + fechaDefuncion);
        System.out.println("Causa de fallecimiento: " + causaFallecimiento);
    }
}
