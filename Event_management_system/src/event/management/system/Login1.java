package event.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login1 extends JFrame implements ActionListener{ 
    JLabel label,l1,pin,text;
    JButton login,signup,back;
    JTextField tf1;
    JPasswordField pf1;
    Login1(){
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
        
        
        text = new JLabel("Admin Login");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,20,400,40);
        add(text);
        
        l1 = new JLabel("Admin ID : ");
        l1.setFont(new Font("Raleway",Font.BOLD,28));
        l1.setBounds(100,150,200,40);
        add(l1);
        
        tf1 = new JTextField();
        tf1.setBounds(300,155,230,30);
        tf1.setFont(new Font("Arial", Font.BOLD, 24));
        add(tf1);
        
        pin = new JLabel("Password : ");
        pin.setFont(new Font("Osward",Font.BOLD,28));
        pin.setBounds(100,200,200,40);
        add(pin);
        
        pf1 = new JPasswordField();
        pf1.setBounds(300,205,230,30);
        pf1.setFont(new Font("Arial", Font.BOLD, 24));
        add(pf1);
        
        login = new JButton("LOGIN");
        login.setBounds(200,280,100,30);
        login.setFont(new Font("Arial",Font.BOLD,14));
        login.addActionListener(this);
        add(login);
        
        back = new JButton("Back");
        back.setBounds(350,280,100,30);
        back.setFont(new Font("Arial",Font.BOLD,14));
        back.addActionListener(this);
        add(back);
        
        setUndecorated(true);
        setSize(600,450);
        setLocation(350,200);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Home().setVisible(true);
        }else if(ae.getSource()==login){
            Conn c = new Conn();
            int prn = Integer.parseInt(tf1.getText());
            String pin = pf1.getText();
            String query = "SELECT *from  admin WHERE id= '"+prn+"'and password = '"+pin+"'";
            try{
                ResultSet rs = c.s.executeQuery(query);
                String pass="";
                if(rs.next()){
                     pass= rs.getString("Password");
                }
                if(pass.equals(pin)){
                    setVisible(false);
                    new Admin().setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect ID or Password");
                }
            }catch (Exception e){
                System.out.println(e);
            }
            
        }
            
    }
    public static void main(String args[]){
        new Login1();
             }
}
