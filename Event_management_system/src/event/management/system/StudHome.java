package event.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;


public class StudHome extends JFrame implements ActionListener{
    JToolBar tb;
    JButton b1,b2,b3,b4,b5,b6;
    JLabel l0,l1,l2,l3,l4;
    String prn;
    int id ;
    StudHome(String prn){
        this.prn = prn;
        
        System.out.println(prn);
        id = Integer.parseInt(prn);
        setTitle("Student_Home page");
        setLayout(null);
        
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/back.jpg"));
        Image i2=i1.getImage().getScaledInstance(1000, 600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(0,0,1000,600);
        add(label);
        
        l0 = new JLabel("My Info ");
        l0.setFont(new Font("Osward",Font.BOLD,30));
        l0.setForeground(Color.GREEN);
        l0.setBounds(100,40,200,40);
        label.add(l0); 
        
        l1 = new JLabel("PRN: "+prn);
        l1.setFont(new Font("Osward",Font.BOLD,28));
        l1.setForeground(Color.GREEN);
        l1.setBounds(100,100,200,30);
        label.add(l1);   
     String name,branch,contact;
     name="";
     branch="";
     contact="";
     Conn c = new Conn();
     try{
         String query = "SELECT *FROM student WHERE id = '"+id+"'";
         ResultSet rs = c.s.executeQuery(query);          
                 while(rs.next()){
                 name +=rs.getString("name");
                 branch = rs.getString("branch");
                 contact = rs.getString("contact");
                 }
                
                
            }catch (Exception e){
                        System.out.print(e);
            }
         l2 = new JLabel("Name: "+name);
         l2.setFont(new Font("Osward",Font.BOLD,26));
         l2.setForeground(Color.GREEN);
         l2.setBounds(100,140,400,30);
         label.add(l2);
                
        l3 = new JLabel("Branch: "+branch);
        l3.setFont(new Font("Osward",Font.BOLD,26));
        l3.setForeground(Color.GREEN);
        l3.setBounds(100,180,400,30);
        label.add(l3);
                
        l4 = new JLabel("Contact: "+contact);
        l4.setFont(new Font("Osward",Font.BOLD,26));
        l4.setForeground(Color.GREEN);
        l4.setBounds(100,220,400,30);
        label.add(l4);     
        
        b1 = new JButton("Logout");
        b1.setContentAreaFilled(false);
        b1.setBounds(400,40,200,30);
        b1.setFont(new Font("Railway",Font.BOLD,16));
        b1.setBorderPainted(false);
        b1.addActionListener(this);
        b1.setForeground(Color.white);
        label.add(b1);
        
        b2 = new JButton("Register");
        b2.setBounds(100,300,200,30);
        b2.setFont(new Font("Railway",Font.BOLD,16));
        b2.addActionListener(this);
        label.add(b2);
        
        
        b3 = new JButton("My Events");
        b3.addActionListener(this);
        b3.setBounds(100,380,200,30);
        b3.setFont(new Font("Railway",Font.BOLD,16));
        b3.addActionListener(this);
        label.add(b3);
    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,600);
        setLocation(250,150);
        setVisible(true);
    
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            setVisible(false);
            new Home().setVisible(true);
        }else if(ae.getSource()==b2){
            setVisible(false);
            new RegisterEvent(""+id).setVisible(true);
        }else if(ae.getSource()==b3){
            new StudEvents(prn).f.setVisible(true);
        }
        
        
    }
    
    
    
    public static void main(String args[]){
        new StudHome("");
    }
}
