package event.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class RegisterEvent2 extends JFrame implements ActionListener{
    JLabel l1;
    JComboBox event;
    String type,prn;
    JButton b1,b2;
    RegisterEvent2(String prn,String type){
        this.type = type ;
        this.prn = prn;
        System.out.println(prn);
        setTitle("Event Registration page2");
        setLayout(null);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/back.jpg"));
        Image i2=i1.getImage().getScaledInstance(1000, 600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(0,0,1000,600);
        add(label);
        
        l1 = new JLabel("Select Event");
        l1.setFont(new Font("Osward",Font.BOLD,28));
        l1.setForeground(Color.GREEN);
        l1.setBounds(200,100,200,30);
        label.add(l1);
        
        int i=0;
        try{
            Conn c = new Conn();
                ResultSet rs =c.s.executeQuery("SELECT count(name) from events where type='"+type+"'");
                if(rs.next()){
                    i = Integer.parseInt(rs.getString("count(name)"));
                }
        }catch(Exception e){
            System.out.println(e);
        }
        String val_event[] = new String[i];
        
        try{
                i=0;
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("SELECT *from events where type='"+type+"'");         
                 while(rs.next()){
                 val_event[i]=rs.getString("name");
                 i++;
                 }
            }catch(Exception e){
                    System.out.println(e);
                    System.out.println("place2");
            }
        event = new JComboBox(val_event);
        event.setBounds(180,140,220,50);
        event.setFont(new Font("Raleway",Font.BOLD,26));
        event.setBackground(Color.BLACK);
        event.setForeground(Color.white);
        label.add(event);
        
        b1 = new JButton("Back");
        b1.setFont(new Font("Railway",Font.BOLD,16));
        b1.addActionListener(this);
        b1.setBounds(100,400,100,30);
        label.add(b1);
        
        b2 = new JButton("Next");
        b2.setBounds(450,400,100,30);
        b2.setFont(new Font("Railway",Font.BOLD,16));
        b2.addActionListener(this);
        label.add(b2);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,500);
        setLocation(250,150);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            setVisible(false);
            new RegisterEvent(prn).setVisible(true);
        }else if(ae.getSource()==b2){
            String tp = (String)event.getSelectedItem();
            setVisible(false);
            new Payment(prn,tp).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new RegisterEvent2("","");
    }
}
