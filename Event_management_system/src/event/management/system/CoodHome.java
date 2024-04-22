package event.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;


public class CoodHome extends JFrame implements ActionListener{
    JButton b1,b2;
    JLabel l,l1,l2,l3,l4;
    String prn,name;
    
    CoodHome(String prn){
       //this.prn = prn;
       prn=""+11002129;
        setTitle("Coodent_Home page");
        setLayout(null);
        
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/back.jpg"));
        Image i2=i1.getImage().getScaledInstance(1000, 600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(0,0,1000,600);
        add(label);
        
        l = new JLabel("Co-od Info");
        l.setFont(new Font("Osward",Font.BOLD,28));
        l.setForeground(Color.GREEN);
        l.setBounds(100,50,400,30);
        label.add(l);
        
        l1 = new JLabel("Co-od Id: "+prn);
        l1.setFont(new Font("Osward",Font.BOLD,28));
        l1.setForeground(Color.GREEN);
        l1.setBounds(100,100,400,30);
        label.add(l1);   
     String branch,contact;
     branch="";
     contact="";
     Conn c = new Conn();
     try{
         String query = "SELECT *FROM Coordinator WHERE id = '"+prn+"'";
         ResultSet rs = c.s.executeQuery(query);          
                 while(rs.next()){
                 name =rs.getString("name");
                 contact = rs.getString("contact");
                 branch = rs.getString("branch");
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
    
        b1 = new JButton("My Events");
        b1.setFont(new Font("Railway",Font.BOLD,16));
        b1.addActionListener(this);
        b1.setBounds(200,500,150,30);
        label.add(b1);
        
        b2 = new JButton("Logout");
        b2.setBounds(450,40,100,30);
        b2.setFont(new Font("Railway",Font.BOLD,16));
        b2.addActionListener(this);
        label.add(b2);
        
    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,600);
        setLocation(250,150);
        setVisible(true);
    
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b2){
            setVisible(false);
            new Home().setVisible(true);
        }else if(ae.getSource() == b1){
            new CoodEvents(name).f.setVisible(true);
        }
        
        
    }
    
    
    
    public static void main(String args[]){
        new CoodHome("");
    }
}
