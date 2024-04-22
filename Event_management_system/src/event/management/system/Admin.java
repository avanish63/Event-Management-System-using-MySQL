package event.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Admin extends JFrame implements ActionListener{
   JLabel l1;
    JButton addevent, delete, delevent, display,exit;
    Admin(){
        setLayout(null);
        
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/back.jpg"));
        Image i2=i1.getImage().getScaledInstance(1000, 600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(0,0,1000,600);
        add(label);
        
        JLabel text = new JLabel("ADMIN");
        text.setFont(new Font("Osward",Font.BOLD,30));
        text.setForeground(Color.green);
        text.setBounds(200,20,400,40);
        label.add(text);
        
        addevent = new JButton("Add Event");
        addevent.setBounds(150,100,200,30);
        addevent.setFont(new Font("Arial",Font.BOLD,14));
        addevent.addActionListener(this);
        label.add(addevent);
        
        delevent = new JButton("Delete Event");
        delevent.setBounds(150,140,200,30);
        delevent.setFont(new Font("Arial",Font.BOLD,14));
        delevent.addActionListener(this);
        label.add(delevent);
        
       
        
        delete = new JButton("Display Cood");
        delete.setBounds(150,180,200,30);
        delete.setFont(new Font("Arial",Font.BOLD,14));
        delete.addActionListener(this);
        label.add(delete);
        
        display = new JButton("Display Events");
        display.setBounds(150,220,200,30);
        display.setFont(new Font("Arial",Font.BOLD,14));
        display.addActionListener(this);
        label.add(display);
        
        exit = new JButton("Exit");
        exit.setBounds(150,260,200,30);
        exit.setFont(new Font("Arial",Font.BOLD,14));
        exit.addActionListener(this);
        label.add(exit);
        setSize(500,400);
        setLocation(400,200);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==delevent){
            setVisible(false);
            new DelEvent().setVisible(true);
        }else if(ae.getSource()==addevent){
            setVisible(false);
            new AddEvent().setVisible(true);
        }else if(ae.getSource()==display){
           new DisplayEvents().f.setVisible(true);
        }else if(ae.getSource()==exit){
            System.exit(0);
        }
    }
    
    public static void main(String args[]){
        new Admin();
    }
    
}


