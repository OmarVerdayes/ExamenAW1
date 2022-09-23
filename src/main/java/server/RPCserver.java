package server;


import utils.DaoInformacion;

import java.util.Random;

public class RPCserver {

    DaoInformacion dao=new DaoInformacion();

    public  String RFC(String apellido1, String apellido2,String nombre,String curp, String año, String mes, String dia){

        Random random = new Random();
        String rfc="";
        try{
            mes="0"+mes;
            dia="0"+dia;
            char l1=apellido1.charAt(0);
            char l2=apellido1.charAt(1);
            char l3=apellido2.charAt(0);
            char l4=nombre.charAt(0);
            l1 = Character.toUpperCase(l1);
            l2 = Character.toUpperCase(l2);
            l3 = Character.toUpperCase(l3);
            l4 = Character.toUpperCase(l4);
            char l5=año.charAt((año.length()-2));
            char l6=año.charAt((año.length()-1));
            char l7=mes.charAt((mes.length()-2));
            char l8=mes.charAt((mes.length()-1));
            char l9=dia.charAt((dia.length()-2));
            char l10=dia.charAt((dia.length()-1));

            String setOfCharacters = "QWERTYUIOPASDFGHJKLÑZXCVBNM1234567890";

            int r1 = random.nextInt(setOfCharacters.length());
            char l11 = setOfCharacters.charAt(r1);
            int r2 = random.nextInt(setOfCharacters.length());
            char l12 = setOfCharacters.charAt(r2);
            int r3 = random.nextInt(setOfCharacters.length());
            char l13 = setOfCharacters.charAt(r3);
            rfc=l1+""+l2+""+l3+""+l4+""+l5+""+l6+""+l7+""+l8+""+l9+""+l10+""+l11+""+l12+""+l13+"";
            String fechaN=año+"-"+l7+""+l8+"-"+l9+""+l10;
            dao.savepersona(nombre,apellido1,apellido2,curp,rfc,fechaN);
        }catch (Exception e){
            System.out.println("se rompio");
        }
        return rfc;
    }
    public  String NRFC(String apellido1, String apellido2,String nombre,String curp, String año, String mes, String dia,String curpV){

        Random random = new Random();
        String rfc="";
        try{
            mes="0"+mes;
            dia="0"+dia;
            char l1=apellido1.charAt(0);
            char l2=apellido1.charAt(1);
            char l3=apellido2.charAt(0);
            char l4=nombre.charAt(0);
            l1 = Character.toUpperCase(l1);
            l2 = Character.toUpperCase(l2);
            l3 = Character.toUpperCase(l3);
            l4 = Character.toUpperCase(l4);
            char l5=año.charAt((año.length()-2));
            char l6=año.charAt((año.length()-1));
            char l7=mes.charAt((mes.length()-2));
            char l8=mes.charAt((mes.length()-1));
            char l9=dia.charAt((dia.length()-2));
            char l10=dia.charAt((dia.length()-1));

            String setOfCharacters = "QWERTYUIOPASDFGHJKLÑZXCVBNM1234567890";

            int r1 = random.nextInt(setOfCharacters.length());
            char l11 = setOfCharacters.charAt(r1);
            int r2 = random.nextInt(setOfCharacters.length());
            char l12 = setOfCharacters.charAt(r2);
            int r3 = random.nextInt(setOfCharacters.length());
            char l13 = setOfCharacters.charAt(r3);
            rfc=l1+""+l2+""+l3+""+l4+""+l5+""+l6+""+l7+""+l8+""+l9+""+l10+""+l11+""+l12+""+l13+"";
            String fechaN=año+"-"+l7+""+l8+"-"+l9+""+l10;
            dao.update(nombre,apellido1,apellido2,curp,rfc,fechaN,curpV);
        }catch (Exception e){
            System.out.println("se rompio");
        }
        return rfc;
    }


}
