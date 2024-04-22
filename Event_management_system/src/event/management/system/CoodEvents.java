package event.management.system;

import javax.swing.*;
import java.sql.ResultSet;

public class CoodEvents {
    JFrame f;
    JTable j;
    String name;
    CoodEvents(String name){
        
  //      this.name = name;
      name = "Ajay";
        f = new JFrame();
        f.setTitle("Events Under Me");
        int i=0;
        try{
            Conn c = new Conn();
                ResultSet rs =c.s.executeQuery("SELECT count(event_id) from events where coordinator='"+name+"'");
                if(rs.next()){
                    i = Integer.parseInt(rs.getString("count(event_id)"));
                }
        }catch(Exception e){
            System.out.println(e);
        }
 
        String[][] data =new String [i][5];
        String[] columnNames = { "Evend ID", "Name", "Type", "Date", "Time","Fee" };      
        i=0;
        String id,event,type,date,time,fee;
         try{
                
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("SELECT *FROM events where coordinator='"+name+"'");         
                 while(rs.next()){
                 id = rs.getString("event_id");
                 event =rs.getString("name");
                 type = rs.getString("type");
                 date = rs.getString("date");
                 time = rs.getString("time");
                 fee = rs.getString("fee");
                 String[] d = {id,event,type,date,time,fee};
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
       // f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(600, 200);
        f.setLocation(100,100);
        f.setVisible(true);
    }
    public static void main(String args[]){
     new  CoodEvents("");
    }
}
