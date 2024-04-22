package event.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddCood  extends JFrame implements ActionListener {
     JLabel text,l1,l2,l3,l4,l5;
     JTextField f1,f2,f4,f5;
     JComboBox f3;
     JButton add,back;
    AddCood(){
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        text = new JLabel("Add Cood");
        text.setFont(new Font("Osward",Font.BOLD,25));
        text.setBounds(170,10,400,40);
        add(text);
        
        
        l1 = new JLabel("Enter ID :");
        l1.setBounds(50,80,120,30);
        l1.setFont(new Font("Osward",Font.BOLD,16));
        add(l1);
        
        f1 = new JTextField();
        f1.setBounds(200,80,230,30);
        f1.setFont(new Font("Arial", Font.BOLD, 14));
        add(f1);
        
        l2 = new JLabel("Enter Name :");
        l2.setBounds(50,120,120,30);
        l2.setFont(new Font("Osward",Font.BOLD,16));
        add(l2);
        
        f2 = new JTextField();
        f2.setBounds(200,120,230,30);
        f2.setFont(new Font("Arial", Font.BOLD, 14));
        add(f2);
        
        l3 = new JLabel("Select Branch :");
        l3.setBounds(50,160,120,30);
        l3.setFont(new Font("Osward",Font.BOLD,16));
        add(l3);
        
        String valreligion[] = {"CS","IT","ENTC","AIDS","Mech","Instru","Chem","Indus-prod"};
        f3 = new JComboBox(valreligion);
        f3.setBounds(200,160,230,30);
        f3.setBackground(Color.white);
        add(f3);
        
        
        l4 = new JLabel("Enter Contact :");
        l4.setBounds(50,200,120,30);
        l4.setFont(new Font("Osward",Font.BOLD,16));
        add(l4);
        
        f4 = new JTextField();
        f4.setBounds(200,200,230,30);
        f4.setFont(new Font("Arial", Font.BOLD, 14));
        add(f4);
        
        l5 = new JLabel("Enter e-mail :");
        l5.setBounds(50,240,120,30);
        l5.setFont(new Font("Osward",Font.BOLD,16));
        add(l5);
        
        f5 = new JTextField();
        f5.setBounds(200,240,230,30);
        f5.setFont(new Font("Arial", Font.BOLD, 14));
        add(f5);
        
        add = new JButton("Add");
        add.setBounds(320,300,100,30);       
        add.setFont(new Font("Arial",Font.BOLD,14));
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(180,300,100,30);
        back.setFont(new Font("Arial",Font.BOLD,14));
        back.addActionListener(this);
        add(back);
        
        setSize(600,480);
        setLocation(350,200);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Admin().setVisible(true);
        }else if(ae.getSource()==add){
             int roll= Integer.parseInt(f1.getText());
            String name = f2.getText();
            String branch = (String)f3.getSelectedItem();
            String contact = f4.getText();
            String email = f5.getText();
            String pass = name.toLowerCase()+"@123";
            try{
                Conn c = new Conn();
                String query = "INSERT INTO coordinator values('"+roll+"','"+name+"','"+branch+"','"+contact+"','"+email+"','"+pass+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Record Added Successfully");
                }catch(Exception e){
                    System.out.println(e);
                }
                setVisible(false);
                new Admin().setVisible(true);
        }
    }   
    
    public static void main(String[] args) {
        new AddCood();
    }
    
}
