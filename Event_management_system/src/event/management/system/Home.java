package event.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Home extends JFrame implements ActionListener{
    JToolBar tb;
    JButton b1,b2,b3,b4,b5,b6,b7;
    
    
    Home(){
        setTitle("Home page");
        setLayout(null);
        getContentPane().setBackground(Color.GRAY);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/back.jpg"));
        Image i2=i1.getImage().getScaledInstance(1000, 600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(0,0,1000,600);
        add(label);
        
        JLabel text = new JLabel("Viswakarandak-23");
        text.setFont(new Font("Osward",Font.BOLD,48));
        text.setForeground(Color.GREEN);
        text.setBounds(280,220,450,40);
        label.add(text);
        
        tb = new JToolBar();
        tb.setBounds(0,40,500,50);
        tb.setOpaque(false);
        tb.setBorderPainted(false);
        label.add(tb);
        
        b1 = new JButton("Events");
        b1.setContentAreaFilled(false);
        b1.setFont(new Font("Railway",Font.BOLD,16));
        b1.setBorderPainted(false);
        b1.addActionListener(this);
        b1.setForeground(Color.white);
        
        b2 = new JButton("Coods");
        b2.setContentAreaFilled(false);
        b2.setFont(new Font("Railway",Font.BOLD,16));
        b2.addActionListener(this);
        b2.setBorderPainted(false);
        b2.setForeground(Color.white);
        
        b3 = new JButton("About");
        b3.setContentAreaFilled(false);
        b3.addActionListener(this);
        b3.setFont(new Font("Railway",Font.BOLD,16));
        b3.setBorderPainted(false);
        b3.setForeground(Color.white);
        
        b4 = new JButton("SignUp");
        b4.setContentAreaFilled(false);
        b4.setFont(new Font("Railway",Font.BOLD,16));
        b4.addActionListener(this);
        b4.setBorderPainted(false);
        b4.setForeground(Color.white);
        
        tb.add(b1);
        tb.add(b2);
        tb.add(b3);
        tb.add(b4);
        
        b5 = new JButton("Student Login");
        b5.setContentAreaFilled(false);
        b5.setBounds(800,40,200,30);
        b5.setFont(new Font("Railway",Font.BOLD,16));
        b5.setBorderPainted(false);
        b5.addActionListener(this);
        b5.setForeground(Color.white);
        label.add(b5);
        
        b6 = new JButton("Co-od Login");
        b6.setContentAreaFilled(false);
        b6.setBounds(800,80,200,30);
        b6.setFont(new Font("Railway",Font.BOLD,16));
        b6.setBorderPainted(false);
        b6.addActionListener(this);
        b6.setForeground(Color.white);
        label.add(b6);
        
        b7 = new JButton("Admin Login");
        b7.setContentAreaFilled(false);
        b7.setBounds(800,120,200,30);
        b7.setFont(new Font("Railway",Font.BOLD,16));
        b7.setBorderPainted(false);
        b7.addActionListener(this);
        b7.setForeground(Color.white);
        label.add(b7);
    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,600);
        setLocation(250,150);
        setVisible(true);
    
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            new DisplayEvents().f.setVisible(true);
        }else if(ae.getSource()==b5){
            setVisible(false);
            new Login().setVisible(true);
        }else if(ae.getSource()==b2){
            new DisplayCoods().f.setVisible(true);
        }else if(ae.getSource()==b3){
            setVisible(false);
            new About().setVisible(true);
        }else if(ae.getSource()==b4){
            setVisible(false);
            new Signup().setVisible(true);
        }else if(ae.getSource()==b6){
            setVisible(false);
            new Login2().setVisible(true);
        }else if(ae.getSource()==b7){
            setVisible(false);
            new Login1().setVisible(true);
        }       
    }   
    public static void main(String args[]){
        new Home();
    }
}
