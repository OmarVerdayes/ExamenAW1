package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DaoInformacion {

    public boolean savepersona(String nombre,String apellido1,String apellido2, String curp,String rfc,String fechaN) {
        boolean result = false;
        try
                (Connection con  = MySQLConnection.getConnection();
                 PreparedStatement pstm = con.prepareStatement("insert into informacion1(nombre,apellido1,apellido2,curp,rfc,fechaN)values(?,?,?,?,?,?);");
                )
        {
            pstm.setString(1, nombre);
            pstm.setString(2, apellido1);
            pstm.setString(3, apellido2);
            pstm.setString(4, curp);
            pstm.setString(5, rfc);
            pstm.setString(6, fechaN);

            result = pstm.executeUpdate() == 1;
            System.out.println("guardado");
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("no guardado");
        }

        return result;
    }

    public String busqueda(String curp) {

        try {
            Connection connection = MySQLConnection.getConnection();
            Statement statement = connection.createStatement();
            String sql="SELECT * FROM informacion1 where curp='"+curp+"'";
            ResultSet rs = statement.executeQuery(""+sql);

            while (rs.next()){
                System.out.print("|"+rs.getString("nombre")+" |");
                System.out.print(rs.getString("apellido1")+" |");
                System.out.print(rs.getString("apellido2")+" |");
                System.out.print(rs.getString("curp")+" |");
                System.out.print(rs.getString("rfc")+" |");
                System.out.print(rs.getString("fechaN")+" |");
                System.out.println();

            };
            rs.close();
            connection.close();
            statement.close();
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Error no tenemos registros con esa informacion");
        }
        return "todo bien";
    }

    public String consulta() {

        try {
            Connection connection = MySQLConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from informacion1");

            while (rs.next()){
                System.out.print("|"+rs.getString("nombre")+" |");
                System.out.print(rs.getString("apellido1")+" |");
                System.out.print(rs.getString("apellido2")+" |");
                System.out.print(rs.getString("curp")+" |");
                System.out.print(rs.getString("rfc")+" |");
                System.out.print(rs.getString("fechaN")+" |");
                System.out.println();

            };
            rs.close();
            connection.close();
            statement.close();
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Error no tenemos registros");
        }
        return "todo bien";
    }

    public boolean eliminar(String curp) {
        boolean result = false;
        try
                (Connection con  = MySQLConnection.getConnection();
                 PreparedStatement pstm = con.prepareStatement("DELETE FROM informacion1 WHERE curp='"+curp+"';");
                )
        {
            result = pstm.executeUpdate() == 1;
            System.out.println("eliminado correctamente");
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Error: indicacion erronea");
        }
        return result;
    }
        public boolean update(String nombre,String apellido1,String apellido2, String curp,String rfc,String fechaN,String curpV) {
        boolean result = false;
        try
                (Connection con  = MySQLConnection.getConnection();
                 PreparedStatement pstm = con.prepareStatement("UPDATE informacion1 SET nombre = '"+nombre+"', apellido1 = '"+apellido1+"', apellido2 = '"+apellido2+"',  curp = '"+curp+"',  rfc = '"+rfc+"',  fechaN = '"+fechaN+"' WHERE curp='"+curpV+"';");
                )
        {

            result = pstm.executeUpdate() == 1;
            System.out.println("actualizado");
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Eroro: no fue posible actualizar");
        }

        return result;
    }
}
