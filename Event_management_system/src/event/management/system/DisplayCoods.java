package event.management.system;

import javax.swing.*;
import java.sql.ResultSet;

public class DisplayCoods {
    JFrame f;
    JTable j;
    DisplayCoods(){
        f = new JFrame();
        f.setTitle("Events");
        int i=0;
        try{
            Conn c = new Conn();
                ResultSet rs =c.s.executeQuery("SELECT count(id) from coordinator");
                if(rs.next()){
                    i = Integer.parseInt(rs.getString("count(id)"));
                }
        }catch(Exception e){
            System.out.println(e);
        }
 
        String[][] data =new String [i][5];
        String[] columnNames = { "Name", "Branch", "Contact", "Email" };      
        i=0;
        String name,branch,contact,email;
         try{
                
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("SELECT *FROM coordinator ");         
                 while(rs.next()){
                 name =rs.getString("name");
                 branch = rs.getString("branch");
                 contact = rs.getString("contact");
                 email = rs.getString("email");
                 String[] d = {name,branch,contact,email};
                 data[i]=d;
                 i++;
                 }
            }catch(Exception e){
                    System.out.println(e);
            }
        j = new JTable(data, columnNames);
        j.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(j);
        f.add(sp);
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(600, 250);
        f.setLocation(800,100);
        f.setVisible(true);
    }
    public static void main(String args[]){
     new  DisplayCoods();
    }
}
