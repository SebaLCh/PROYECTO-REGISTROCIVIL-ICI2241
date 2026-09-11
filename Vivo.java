public class Vivo extends Estado // Aquí representamos Vivo usando como base la clase Estado.
{

    public Vivo(Fecha nacimiento, Domicilio lugarNacimiento) // Para crear un objeto Vivo con sus datos iniciales.
    {
        super(nacimiento, lugarNacimiento); // Enviamos los datos iniciales a la clase padre.
    }

    @Override // Usamos nuestra propia versión del método heredado.
    public void imprimirCertificado() // Para mostrar los datos del certificado.
    {
        System.out.println("Certificado de nacimiento");
        super.imprimirCertificado(); // Reutilizamos el método de la clase padre.
        System.out.println("Estado: Vivo");
    }
}
