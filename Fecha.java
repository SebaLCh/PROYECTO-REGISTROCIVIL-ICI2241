import java.time.DateTimeException; // Para poder usar DateTimeException en esta clase.
import java.time.LocalDate; // Para poder usar LocalDate en esta clase.

public class Fecha // Aquí reunimos los datos y funciones de Fecha.
{
    private int dia; // Para guardar el día.
    private int mes; // Para guardar el mes.
    private int ano; // Para guardar el año.

    public Fecha(int d, int m, int a) throws InvalidDateException // Para crear un objeto Fecha con sus datos iniciales.
    {
        try // Intentamos esta operación porque podría fallar.
        {
            LocalDate.of(a, m, d); // Llamamos a LocalDate.of para continuar el proceso.
        }
        catch (DateTimeException e) // Manejamos aquí el error si llega a ocurrir.
        {
            throw new InvalidDateException(d, m, a); // Detenemos la operación y avisamos el problema.
        }

        this.dia = d; // Guardamos aquí el día recibido.
        this.mes = m; // Guardamos aquí el mes recibido.
        this.ano = a; // Guardamos aquí el año recibido.
    }

    public int getDia() // Para obtener el día.
    {
        return dia; // Devolvemos el día.
    }

    public void setDia(int dia) throws InvalidDateException // Para cambiar el día.
    {
        validarFecha(dia, mes, ano); // Llamamos a validarFecha para continuar el proceso.
        this.dia = dia; // Guardamos aquí el día recibido.
    }

    public int getMes() // Para obtener el mes.
    {
        return mes; // Devolvemos el mes.
    }

    public void setMes(int mes) throws InvalidDateException // Para cambiar el mes.
    {
        validarFecha(dia, mes, ano); // Llamamos a validarFecha para continuar el proceso.
        this.mes = mes; // Guardamos aquí el mes recibido.
    }

    public int getAno() // Para obtener el año.
    {
        return ano; // Devolvemos el año.
    }

    public void setAno(int ano) throws InvalidDateException // Para cambiar el año.
    {
        validarFecha(dia, mes, ano); // Llamamos a validarFecha para continuar el proceso.
        this.ano = ano; // Guardamos aquí el año recibido.
    }

    private void validarFecha(int dia, int mes, int ano) throws InvalidDateException // Para comprobar que la fecha sea válida.
    {
        try // Intentamos esta operación porque podría fallar.
        {
            LocalDate.of(ano, mes, dia); // Llamamos a LocalDate.of para continuar el proceso.
        }
        catch (DateTimeException e) // Manejamos aquí el error si llega a ocurrir.
        {
            throw new InvalidDateException(dia, mes, ano); // Detenemos la operación y avisamos el problema.
        }
    }

    @Override // Usamos nuestra propia versión del método heredado.
    public String toString() // Para mostrar la fecha como texto.
    {
        return dia + "/" + mes + "/" + ano; // Devolvemos el valor de dia + "/" + mes + "/" + ano.
    }
}
