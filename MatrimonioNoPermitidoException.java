@SuppressWarnings("serial") // Ocultamos una advertencia de Java que no afecta el programa.
public class MatrimonioNoPermitidoException extends Exception // Aquí representamos MatrimonioNoPermitidoException usando como base la clase Exception.
{

    public MatrimonioNoPermitidoException(String mensaje) // Para crear un objeto MatrimonioNoPermitidoException con sus datos iniciales.
    {
        super(mensaje); // Enviamos los datos iniciales a la clase padre.
    }
}
