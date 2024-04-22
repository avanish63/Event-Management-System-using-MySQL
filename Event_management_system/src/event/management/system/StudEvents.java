package event.management.system;

import javax.swing.*;
import java.sql.ResultSet;

public class StudEvents {
    JFrame f;
    JTable j;
    String prn;
    StudEvents(String prn){
        this.prn=prn;
        f = new JFrame();
        f.setTitle("MY Events");
        int i=0;
        try{
            Conn c = new Conn();
                ResultSet rs =c.s.executeQuery("SELECT count(event_id) from bill where prn ='"+prn+"'");
                if(rs.next()){
                    i = Integer.parseInt(rs.getString("count(event_id)"));
                }
        }catch(Exception e){
            System.out.println(e);
        }
 
        String[][] data =new String [i][5];
        String[] columnNames = {"Order ID","Evend ID", "Name", "Type", "Date", "Time"};      
        i=0;
        String oid,eid,name,type,date,time;
         try{
                
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("call studevents_display('"+prn+"')");         
                 while(rs.next()){
                     oid=rs.getString("order_id");
                 eid = rs.getString("event_id");
                 name =rs.getString("name");
                 type = rs.getString("type");
                 date = rs.getString("date");
                 time = rs.getString("time");
                 String[] d = {oid,eid,name,type,date,time};
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
        f.setSize(600, 400);
        f.setLocation(800,100);
        f.setVisible(true);
    }
    public static void main(String args[]){
     new  StudEvents("");
    }
}
