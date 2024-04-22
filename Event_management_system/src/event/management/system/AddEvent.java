
package event.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddEvent  extends JFrame implements ActionListener {
     JLabel text,l1,l2,l3,l4,l5,l6;
     JTextField f1,f2,f4,f5,f6;
     JComboBox f3;
     JButton add,back;
    AddEvent(){
        setLayout(null);
        text = new JLabel("Add Event");
        text.setFont(new Font("Osward",Font.BOLD,25));
        text.setBounds(170,10,400,40);
        add(text);
        
        
        l1 = new JLabel("Event Name :");
        l1.setBounds(50,80,120,30);
        l1.setFont(new Font("Osward",Font.BOLD,16));
        add(l1);
        
        f1 = new JTextField();
        f1.setBounds(200,80,230,30);
        f1.setFont(new Font("Arial", Font.BOLD, 14));
        add(f1);
        
        l2 = new JLabel("Event Cood :");
        l2.setBounds(50,120,120,30);
        l2.setFont(new Font("Osward",Font.BOLD,16));
        add(l2);
        
        f2 = new JTextField();
        f2.setBounds(200,120,230,30);
        f2.setFont(new Font("Arial", Font.BOLD, 14));
        add(f2);
        
        l3 = new JLabel("Event Type :");
        l3.setBounds(50,160,120,30);
        l3.setFont(new Font("Osward",Font.BOLD,16));
        add(l3);
        int i=0;
        try{
            Conn c = new Conn();
                ResultSet rs =c.s.executeQuery("SELECT count(type) from type");
                if(rs.next()){
                    i = Integer.parseInt(rs.getString("count(type)"));
                }
        }catch(Exception e){
            System.out.println(e);
        }
        String val_type[] = new String[i];
        
        try{
                i=0;
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("SELECT *FROM type");         
                 while(rs.next()){
                 val_type[i]=rs.getString("type");
                 i++;
                 }
            }catch(Exception e){
                    System.out.println(e);
                    System.out.println("place1");
            }
        
        
        f3 = new JComboBox(val_type);
        f3.setBounds(200,160,230,30);
        f3.setBackground(Color.white);
        add(f3);
        
        
        l4 = new JLabel("Event Date :");
        l4.setBounds(50,200,120,30);
        l4.setFont(new Font("Osward",Font.BOLD,16));
        add(l4);
        
        f4 = new JTextField();
        f4.setBounds(200,200,230,30);
        f4.setFont(new Font("Arial", Font.BOLD, 14));
        add(f4);
        
        l5 = new JLabel("Event time :");
        l5.setBounds(50,240,120,30);
        l5.setFont(new Font("Osward",Font.BOLD,16));
        add(l5);
        
        f5 = new JTextField();
        f5.setBounds(200,240,230,30);
        f5.setFont(new Font("Arial", Font.BOLD, 14));
        add(f5);
        
        l6 = new JLabel("Event fee :");
        l6.setBounds(50,280,120,30);
        l6.setFont(new Font("Osward",Font.BOLD,16));
        add(l6);
        
        f6 = new JTextField();
        f6.setBounds(200,280,230,30);
        f6.setFont(new Font("Arial", Font.BOLD, 14));
        add(f6);
        
        
        add = new JButton("Add");
        add.setBounds(320,320,100,30);       
        add.setFont(new Font("Arial",Font.BOLD,14));
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(180,320,100,30);
        back.setFont(new Font("Arial",Font.BOLD,14));
        back.addActionListener(this);
        add(back);
        
        setSize(600,480);
        setLocation(350,200);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Admin().setVisible(true);
        }else if(ae.getSource()==add){
            String name = f1.getText();
            String cood = f2.getText();
            String type = (String)f3.getSelectedItem();
            String date = f4.getText();
            String time = f5.getText();
            String fee = f6.getText();
            try{
                Conn c = new Conn();
                String query = "INSERT INTO events(name,coordinator,type,date,time,fee) "
                        + "values('"+name+"','"+cood+"','"+type+"','"+date+"','"+time+"','"+fee+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Event Added Successfully");
                }catch(Exception e){
                    System.out.println(e);
                }
                setVisible(false);
                new Admin().setVisible(true);
        }
    }   
    
    public static void main(String[] args) {
        new AddEvent();
    }
    
}

