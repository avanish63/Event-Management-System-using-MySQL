package event.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{ 
    JLabel label,l1,pin,text;
    JButton login,signup,back;
    JTextField tf1;
    JPasswordField pf1;
    Login(){
        setTitle("Login page");
        setLayout(null);
        getContentPane().setBackground(Color.white);
        //Icon
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));
        Image i2=i1.getImage().getScaledInstance(80, 80,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        label=new JLabel(i3);
        label.setBounds(80,5,100,100);
        add(label);
        
        
        text = new JLabel("Vishwakarandak-23");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);
        
        l1 = new JLabel("  PRN  No. : ");
        l1.setFont(new Font("Raleway",Font.BOLD,28));
        l1.setBounds(118,180,200,40);
        add(l1);
        
        tf1 = new JTextField();
        tf1.setBounds(300,185,230,30);
        tf1.setFont(new Font("Arial", Font.BOLD, 24));
        add(tf1);
        
        pin = new JLabel("Password : ");
        pin.setFont(new Font("Osward",Font.BOLD,28));
        pin.setBounds(120,230,200,40);
        add(pin);
        
        pf1 = new JPasswordField();
        pf1.setBounds(300,235,230,30);
        pf1.setFont(new Font("Arial", Font.BOLD, 24));
        add(pf1);
        
        login = new JButton("LOGIN");
        login.setBounds(300,320,100,30);
        login.setFont(new Font("Arial",Font.BOLD,14));
        login.addActionListener(this);
        add(login);
        
        back = new JButton("Back");
        back.setBounds(430,320,100,30);
        back.setFont(new Font("Arial",Font.BOLD,14));
        back.addActionListener(this);
        add(back);
        
        signup = new JButton("Register");
        signup.setBounds(300,370,230,30);
        signup.setFont(new Font("Arial",Font.BOLD,14));
        signup.addActionListener(this);
        add(signup);
        
        setSize(800,480);
        setLocation(350,200);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Home().setVisible(true);
        }else if(ae.getSource()==signup){
            setVisible(false);
            new Signup().setVisible(true);
        }else if(ae.getSource()==login){
            Conn c = new Conn();
            int prn = Integer.parseInt(tf1.getText());
            String pin = pf1.getText();
            String query = "SELECT *from  login WHERE id= '"+prn+"'and password = '"+pin+"'";
            try{
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new StudHome(""+prn).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect ID or Password");
                }
            }catch (Exception e){
                System.out.println(e);
            }
            
        }
            
    }
    public static void main(String args[]){
        new Login();
             }
}
