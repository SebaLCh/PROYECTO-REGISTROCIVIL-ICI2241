@SuppressWarnings("serial") // Ocultamos una advertencia de Java que no afecta el programa.
public class InvalidDateException extends Exception // Aquí representamos InvalidDateException usando como base la clase Exception.
{
    public InvalidDateException(int dia, int mes, int ano) // Para crear un objeto InvalidDateException con sus datos iniciales.
    {
        super("La fecha ingresada no es valida: " + dia + "/" + mes + "/" + ano); // Enviamos los datos iniciales a la clase padre.
    }

}
