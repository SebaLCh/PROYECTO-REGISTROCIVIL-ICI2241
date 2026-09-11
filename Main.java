import java.io.IOException; // Para poder usar IOException en esta clase.
import javax.swing.JOptionPane; // Para poder usar JOptionPane en esta clase.
import javax.swing.SwingUtilities; // Para poder usar SwingUtilities en esta clase.

public class Main // Aquí reunimos los datos y funciones de Main.
{
    private static String archivoDatos = "registroCivil.txt"; // Para guardar el nombre del archivo de datos.

    public static String getArchivoDatos() // Para obtener el nombre del archivo de datos.
    {
        return archivoDatos; // Devolvemos el nombre del archivo de datos.
    }

    public static void setArchivoDatos(String archivoDatos) // Para cambiar el nombre del archivo de datos.
    {
        Main.archivoDatos = archivoDatos; // Guardamos aquí el nombre del archivo de datos recibido.
    }

    public static void main(String[] args) // Este es el punto donde comienza el programa.
    {
        RegistroCivil registro = new RegistroCivil(); // Creamos y guardamos el registro civil para usarlo después.
        PersistenciaTexto persistencia = new PersistenciaTexto(archivoDatos); // Creamos y guardamos el objeto que lee y guarda los datos para usarlo después.

        try // Intentamos esta operación porque podría fallar.
        {
            if (persistencia.cargar(registro)) // Comprobamos esta condición antes de continuar.
            {
                System.out.println("Datos cargados desde " + archivoDatos);
            }
            else // Usamos esta alternativa cuando la condición anterior no se cumple.
            {
                System.out.println("Primera ejecucion: se usaran los datos iniciales.");
            }
        }
        catch (IOException e) // Manejamos aquí el error si llega a ocurrir.
        {
            System.out.println("No se pudieron cargar los datos: " + e.getMessage());
        }

        String[] opciones = // Guardamos las opciones disponibles para usarlo después.
        {"Consola", "Ventana"}; // Usamos este dato para continuar el proceso.
        int opcion = JOptionPane.showOptionDialog(null, "¿Como desea usar el sistema?", // Guardamos la opción elegida para usarlo después.
        "Registro Civil", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, // Añadimos estos datos a la instrucción anterior.
        null, opciones, opciones[0]); // Usamos este dato para continuar el proceso.

        if (opcion == 0) // Comprobamos cuál opción eligió el usuario.
        {
            MenuConsola menu = new MenuConsola(registro); // Creamos y guardamos el menú de consola para usarlo después.
            menu.iniciar(); // Llamamos a menu.iniciar para continuar el proceso.
            try // Intentamos esta operación porque podría fallar.
            {
                persistencia.guardar(registro); // Llamamos a persistencia.guardar para continuar el proceso.
                System.out.println("Datos guardados en " + archivoDatos);
            }
            catch (IOException e) // Manejamos aquí el error si llega a ocurrir.
            {
                System.out.println("No se pudieron guardar los datos: " + e.getMessage());
            }
        }
        else if (opcion == 1) // Comprobamos cuál opción eligió el usuario.
        {
            SwingUtilities.invokeLater(() -> // Añadimos estos datos a la instrucción anterior.
            {
                MenuVentana ventana = new MenuVentana(registro, persistencia); // Creamos y guardamos la ventana del programa para usarlo después.
                ventana.setVisible(true); // Llamamos a ventana.setVisible para continuar el proceso.
            });
        }
    }
}
