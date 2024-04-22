package event.management.system;

import java.sql.*;


public class Conn {
    Connection c;
    Statement s;
    
    public Conn(){
        try{
            
            c = DriverManager.getConnection("jdbc:mysql:///event_management" , "root" , "@asif786");
            s = c.createStatement();
            
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
}