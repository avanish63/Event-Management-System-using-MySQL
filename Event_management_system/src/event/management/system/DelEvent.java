package event.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class DelEvent extends JFrame implements ActionListener{
     JLabel text,l1;
     JButton add,back;
     JTextField f1;
    DelEvent(){
        setLayout(null);
        text = new JLabel("Delete Event");
        text.setFont(new Font("Osward",Font.BOLD,25));
        text.setBounds(170,10,400,40);
        add(text);
        
        l1 = new JLabel(" Event Id :");
        l1.setBounds(50,80,120,30);
        l1.setFont(new Font("Osward",Font.BOLD,16));
        add(l1);
        
        f1 = new JTextField();
        f1.setBounds(200,80,230,30);
        f1.setFont(new Font("Arial", Font.BOLD, 14));
        add(f1);
        
        
        add = new JButton("Delete");
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
          String event_id = f1.getText();

            try{
                Conn c = new Conn();
                String query = "DELETE FROM events where event_id ='"+event_id+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Event delted Successfully");
                }catch(Exception e){
                    System.out.println(e);
                }
                setVisible(false);
                new Admin().setVisible(true);
        }
    }   
    
    public static void main(String args[]){
        new DelEvent();
    }
}
