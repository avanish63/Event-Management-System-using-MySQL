package event.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class RegisterEvent extends JFrame implements ActionListener{
    JLabel l1;
    JComboBox type,event;
    String prn;
    JButton b1,b2;
    RegisterEvent(String prn){
        this.prn=prn;
        
        setTitle("Event Registration page");
        setLayout(null);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/back.jpg"));
        Image i2=i1.getImage().getScaledInstance(1000, 600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(0,0,1000,600);
        add(label);
        
        
        l1 = new JLabel("Select Type");
        l1.setFont(new Font("Osward",Font.BOLD,28));
        l1.setForeground(Color.GREEN);
        l1.setBounds(200,100,200,30);
        label.add(l1); 
        
        
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
            }
        
        type = new JComboBox(val_type);
        type.setBounds(180,140,220,50);
        type.setFont(new Font("Raleway",Font.BOLD,26));
        type.setBackground(Color.BLACK);
        type.setForeground(Color.white);
        label.add(type);
        
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
            new StudHome(prn).setVisible(true);
        }else if(ae.getSource()==b2){
            String tp = (String)type.getSelectedItem();
            setVisible(false);
            new RegisterEvent2(prn,tp).setVisible(true);
        }
    }
    public static void main(String args[]){
        new RegisterEvent("");
    }
}



