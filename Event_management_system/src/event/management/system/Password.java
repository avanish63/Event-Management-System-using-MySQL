package event.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Password extends JFrame implements ActionListener{
    String prn;
    JLabel id,spw,cpw;
    JPasswordField f1,f2;
    JButton next;
    Password(String prn){
        this.prn = prn;
        setLayout(null);
        setTitle("Sign Up page");
        getContentPane().setBackground(Color.WHITE);
        
        id = new JLabel("Studend ID:  "+prn);
        id.setFont(new Font("Raleway",Font.BOLD,22));
        id.setBounds(180,80,400,20);
        add(id);
        
        spw = new JLabel("Set Password:");
        spw.setBounds(80,150,200,20);
        spw.setFont(new Font("Raleway",Font.BOLD,18));
        add(spw);
        
        cpw = new JLabel("Confirm Password:");
        cpw.setBounds(60,200,200,20);
        cpw.setFont(new Font("Raleway",Font.BOLD,18));
        add(cpw);
        
        f1 = new JPasswordField();
        f1.setBounds(240,150,200,30);
        f1.setFont(new Font("Raleway",Font.BOLD,16));
        add(f1);
        
        f2 = new JPasswordField();
        f2.setBounds(240,200,200,30);
        f2.setFont(new Font("Raleway",Font.BOLD,16));
        add(f2);
        
        next = new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD,16));
        next.setBounds(230,280,100,30);
        next.addActionListener(this);
        add(next);
        
        setSize(600,400);
        setLocation(400,200);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String p1 = f1.getText();
        String p2 = f2.getText();
        int var = Integer.parseInt(prn);
        if(ae.getSource()==next){
           if(p1.equals(p2)){
                 try{
                    Conn c = new Conn();
                    String query = "UPDATE  login set password='"+p1+"'where id ='"+var+"'";
                    c.s.executeUpdate(query);
                    
                    JOptionPane.showMessageDialog(null,"Student ID "+prn+"\nPassword "+p1);
                }
            catch(Exception e){
                System.out.println(e);
            }
            setVisible(false);
            new Login().setVisible(true);   
        }else{
            JOptionPane.showMessageDialog(null, "Password doesn't match!!!");
        }    
    }
        
    }
    
    
    public static void main(String args[]){
        new Password("");
    }
}
