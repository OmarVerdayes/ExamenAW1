package Client;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import utils.DaoInformacion;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class RPCclient {
    public static void main(String[] args) throws MalformedURLException, XmlRpcException {
        Scanner scanner=new Scanner(System.in);
        DaoInformacion dao=new DaoInformacion();
        XmlRpcClientConfigImpl config=new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        XmlRpcClient client =new XmlRpcClient();
        client.setConfig(config);
        String nombre;
        String apellido1;
        String apellido2;
        String curp;
        String curpV;
        String año;
        String mes;
        String dia;
        String opcion="0";
        int opc=0;
        boolean correcto=true;
        do {
            dia="";
            mes="";
            año="";
            do {
                try {
                    System.out.println("Ingresa\n" +
                            "1.-Registrar datos de la persona \n" +
                            "2.-Consultar datos de una persona por medio de la CURP\n" +
                            "3.-Modificar los datos de la persona\n" +
                            "4.-Consultar a las personas\n" +
                            "5.-Eliminar a la persona\n" +
                            "6.-salir");
                    opcion=scanner.next();
                    opc=Integer.parseInt(opcion);
                    correcto= true;
                } catch (NumberFormatException nfe){
                    correcto= false;
                    System.out.println("Favor de ingresar un numero un numero");
                }
            }while (!correcto);



            switch (opc){
                case 1:
                    System.out.println("Ingresa el nombre");
                    nombre=scanner.next();
                    scanner.nextLine();
                    System.out.println("Ingresa el primer apellido");
                    apellido1=scanner.next();
                    scanner.nextLine();
                    System.out.println("Ingresa el segundo apellido");
                    apellido2=scanner.next();
                    scanner.nextLine();
                    System.out.println("Ingresa el curp");
                    curp=scanner.next();
                    scanner.nextLine();

                    do{
                        try {
                            System.out.println("Ingresa el año de nacimiento");
                            año=scanner.next();
                            scanner.nextLine();
                            Integer.parseInt(año);
                            correcto= true;
                        } catch (NumberFormatException nfe){
                            correcto= false;
                            System.out.println("Favor de imgresar un numero un numero");
                        }
                    }while (!correcto);
                    do{
                        try {
                            System.out.println("Ingresa el numero del mes de nacimiento");
                            mes=scanner.next();
                            scanner.nextLine();
                            Integer.parseInt(mes);
                            correcto= true;
                        } catch (NumberFormatException nfe){
                            correcto= false;
                            System.out.println("Favor de imgresar un numero un numero");
                        }
                    }while (!correcto);
                    do{
                        try {
                            System.out.println("Ingresa el dia de nacimiento");
                            dia=scanner.next();
                            scanner.nextLine();
                            Integer.parseInt(dia);
                            correcto= true;
                        } catch (NumberFormatException nfe){
                            correcto= false;
                            System.out.println("Favor de imgresar un numero un numero");
                        }
                    }while (!correcto);
                    try{
                        Object[] datos={apellido1,apellido2,nombre,curp,año,mes,dia};
                        String rfcS =(String) client.execute("RPCserver.RFC",datos);
                        System.out.println("El RFC es:"+rfcS);
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    break;
                case 2:
                    System.out.println("ingresa el CURP que desea buscar");
                    curp=scanner.next();
                    scanner.nextLine();
                    dao.busqueda(curp);
                    break;
                case 3:
                    System.out.println("ingresa el curp viejo");
                    curpV=scanner.next();
                    scanner.nextLine();
                    System.out.println("Ingresa el nuevo nombre");
                    nombre=scanner.next();
                    scanner.nextLine();
                    System.out.println("Ingresa el nuevo primer apellido");
                    apellido1=scanner.next();
                    scanner.nextLine();
                    System.out.println("Ingresa el nuevo segundo apellido");
                    apellido2=scanner.next();
                    scanner.nextLine();
                    System.out.println("Ingresa el nuevo curp");
                    curp=scanner.next();
                    scanner.nextLine();

                    do{
                        try {
                            System.out.println("Ingresa el nuevo año de nacimiento");
                            año=scanner.next();
                            scanner.nextLine();
                            Integer.parseInt(año);
                            correcto= true;
                        } catch (NumberFormatException nfe){
                            correcto= false;
                            System.out.println("Favor de imgresar un numero un numero");
                        }
                    }while (!correcto);
                    do{
                        try {
                            System.out.println("Ingresa el nuevo numero del mes de nacimiento");
                            mes=scanner.next();
                            scanner.nextLine();
                            Integer.parseInt(mes);
                            correcto= true;
                        } catch (NumberFormatException nfe){
                            correcto= false;
                            System.out.println("Favor de imgresar un numero un numero");
                        }
                    }while (!correcto);
                    do{
                        try {
                            System.out.println("Ingresa el nuevo dia de nacimiento");
                            dia=scanner.next();
                            scanner.nextLine();
                            Integer.parseInt(dia);
                            correcto= true;
                        } catch (NumberFormatException nfe){
                            correcto= false;
                            System.out.println("Favor de imgresar un numero un numero");
                        }
                    }while (!correcto);
                    try{
                        Object[] datos={apellido1,apellido2,nombre,curp,año,mes,dia,curpV};
                        String rfcS =(String) client.execute("RPCserver.NRFC",datos);
                        System.out.println("El nuevo RFC es:"+rfcS);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    System.out.println("Los registros son");
                    dao.consulta();
                    break;
                case 5:
                    System.out.println("ingresa el CURP que desea eliminar");
                    curp=scanner.next();
                    scanner.nextLine();
                    dao.eliminar(curp);
                    break;
                default:
                    System.out.println("opcion invalida");
            }
        }while (!opcion.equals("6"));
    }

}
