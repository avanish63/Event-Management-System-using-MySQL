package event.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Payment extends JFrame implements ActionListener{
    JLabel l1,l2;
    JComboBox type;
    String event,prn,fee,id;
    JButton b1,b2;
  
    Payment(String prn,String event){
        this.event = event ;
        this.prn = prn;
        System.out.println(prn); 
        setTitle("Event Payment Page");
        setLayout(null);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/back.jpg"));
        Image i2=i1.getImage().getScaledInstance(1000, 600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(0,0,1000,600);
        add(label);
        
        l1 = new JLabel("Select Payment Mode");
        l1.setFont(new Font("Osward",Font.BOLD,28));
        l1.setForeground(Color.GREEN);
        l1.setBounds(100,40,300,30);
        label.add(l1);
        
        String[] val_type = {"PhonePe","GPay","PayTM","Debt card","Credit Card",};
        type = new JComboBox(val_type);
        type.setBounds(100,80,200,30);
        type.setFont(new Font("Raleway",Font.BOLD,20));
        type.setBackground(Color.BLACK);
        type.setForeground(Color.white);
        label.add(type);
        
         try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("SELECT *from events where name='"+event+"'");         
                 while(rs.next()){
                     fee=rs.getString("fee");
                     id = rs.getString("event_id");
                 }
            }catch(Exception e){
                    System.out.println(e);
                    System.out.println("place2");
            }
        
         l2 = new JLabel("Amount : "+fee);
         l2.setFont(new Font("Osward",Font.BOLD,26));
         l2.setForeground(Color.GREEN);
         l2.setBounds(100,140,400,30);
         label.add(l2);  
        
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
        if(ae.getSource()==b2){
            String mode = (String)type.getSelectedItem();
            try{
                int p = Integer.parseInt(prn);
                Conn c = new Conn();
                String query = "INSERT INTO bill(prn,event_id,event_name,payment_mode,amount,date) "
                        + "values('"+p+"','"+id+"','"+event+"','"+mode+"','"+fee+"',now())";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Event Regestered Successfully");
                }catch(Exception e){
                    System.out.println(e);
                }
                setVisible(false);
                new StudHome(prn).setVisible(true);
            
        }else if(ae.getSource()==b1){
            setVisible(false);
            new StudHome(prn).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new Payment("","");
    }
}
