/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class MenuConsola {
    private RegistroCivil registro;
    private PersistenciaTexto persistencia;
    private Scanner scan;

    public MenuConsola(RegistroCivil r, PersistenciaTexto p){
        registro = r;
        persistencia = p;
        this.scan = new Scanner(System.in);
    }
    
    public void iniciar(){
        boolean salir = false;
        while(!salir){
            mostrarMenu();
            String opcion = scan.nextLine().trim();
            try{
                switch(opcion){
                    case "1": agregarPersona(); break;
                    case "2": editarPersona(); break;
                    case "3": eliminarPersona(); break;
                    case "4": agregarFamiliar(); break;
                    case "5": acreditarDivorcio(); break;
                    case "6": acreditarMatrimonio(); break;
                    case "7": acreditarFallecimiento(); break;
                    case "8": emitirCertificado(); break;
                    case "0":
                        guardarSalir();
                        salir = true;
                        break;
                    default:
                        System.out.printl("opcion no valida\n");
                }
            } catch(InvalidDateException){
                System.out.printl("e");
              }
        }
    }

    private void mostrarMenu(){
        System.out.println("===== SISTEMA DE REGISTRO CIVIL =====");
        System.out.println("1.  Ingresar persona");
        System.out.println("2.  Editar persona");
        System.out.println("3.  Eliminar persona");
        System.out.println("4.  Agregar familiar a una persona");
        System.out.println("5.  Acreditar divorcio");
        System.out.println("6.  Acreditar matrimonio");
        System.out.println("7. Acreditar fallecimiento");
        System.out.println("8. Emitir certificado");
        System.out.print("Opcion: ");
        
    }
    
    private void mostrarRegiones(){
        for(int i = 0; i < 15; i++){
            System.out.println(i + "." + registro.nombreRegion(i));
        }
    }
    
    private int pedirRegion(){
        mostrarRegiones();
        System.out.print("Ingrese el índice de la región: ");
        int indice = Integer.parseInt(scan.nextLine().trim());
        return indice;
    }
    
    private Fecha pedirFecha(){
        System.out.print("Dia: ");
        int dia  = Integer.parseInt(scan.nextLine().trim());
        System.out.print("Mes: ");
        int mes = Integer.parseInt(scan.nextLine().trim());
        System.out.print("Año: ");
        int ano = Integer.parseInt(scan.nextLine().trim());
        return new Fecha(dia, mes, ano);
    }
    

    private void ingresarPersona(){  
        System.out.print("Ingrese nombre de la persona: ");
        String nombre = scan.nextLine().trim();
        System.out.print("Ingrese rut de la persona (formato: 12345678-9): ");
        String rut = scan.nextLine().trim();
        System.out.print("La persona es extranjera? (s/n)");
        boolean esExtranjero = scan.nextLine().trim().equals("s");
       
        Domicilio zonaGeo;
        int region;
        if(esExtranjero){   
            zonaGeo = new Domicilio(true);
            region = pedirRegion();
            
        }else{
            region = pedirRegion();
            System.out.print("Ingrese la comuna: ");
            String comuna = scan.nextLine().trim();
            zonaGeo = new Domicilio(registro.nombreRegion(region), comuna);
        }
        Fecha fechaNacimiento = pedirFecha();
        Estado estado = new Estado(fechaNacimiento, zonaGeo);
        Persona persona  = new Persona(nombre, rut, zonaGeo, estado);
        registro.agregarPersona(region, persona);
       
        System.out.println("Persona ingresada con éxito\n");
    }
    private void editarPersona(){
    }
    
    private void e(){
    }
    private void e(){
    }
    private void e(){
    }
    private void e(){
    }
    private void e(){
    }
    private void e(){
    }
    private void guardarSalir(){
        try{
            persistencia.guardar(registro);
            System.out.println("datos guardados");
        } catch(IOException e){
            System.out.println("error");
        }
    }
}
