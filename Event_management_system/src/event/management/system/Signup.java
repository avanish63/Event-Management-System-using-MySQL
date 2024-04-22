package event.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Signup extends JFrame implements ActionListener{
    JLabel register,name,lname,id,email,contact,l1,l2;
    JComboBox branch,year;
    JTextField f1,f2,f3,f4,f5;
     JButton submit;
    Signup(){
        setLayout(null);
        setTitle("Sign Up page");
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        register = new JLabel("Register");
        register.setFont(new Font("Raleway",Font.BOLD,30));
        register.setBounds(250,20,400,50);
        add(register);
        
        name = new JLabel("First Name");
        name.setFont(new Font("Raleway",Font.BOLD,18));
        name.setBounds(80,100,150,20);
        add(name);
        
        f1 = new JTextField();
        f1.setBounds(80,125,200,30);
        f1.setFont(new Font("Raleway",Font.BOLD,16));
        add(f1);
        
        lname = new JLabel("Last Name");
        lname.setFont(new Font("Raleway",Font.BOLD,18));
        lname.setBounds(350,100,150,20);
        add(lname);
        
        f2 = new JTextField();
        f2.setBounds(350,125,200,30);
        f2.setFont(new Font("Raleway",Font.BOLD,16));
        add(f2);
        
        email = new JLabel("E-mail");
        email.setFont(new Font("Raleway",Font.BOLD,18));
        email.setBounds(80,180,150,20);
        add(email);
        
        f3 = new JTextField();
        f3.setBounds(80,205,200,30);
        f3.setFont(new Font("Raleway",Font.BOLD,16));
        add(f3);
        
        contact = new JLabel("Contact");
        contact.setFont(new Font("Raleway",Font.BOLD,18));
        contact.setBounds(350,180,150,20);
        add(contact);
        
        f4 = new JTextField();
        f4.setBounds(350,205,200,30);
        f4.setFont(new Font("Raleway",Font.BOLD,16));
        add(f4);
        
        l1 = new JLabel("Branch");
        l1.setFont(new Font("Raleway",Font.BOLD,18));
        l1.setBounds(80,260,150,20);
        add(l1);
        
        String val_branch[] = {"CS","IT","AI&DS","Mech","Instru","Chem","Indus-prod"};
        branch = new JComboBox(val_branch);
        branch.setBounds(80,285,200,30);
        branch.setFont(new Font("Raleway",Font.BOLD,16));
        branch.setBackground(Color.white);
        add(branch);
        
        l2 = new JLabel("Year");
        l2.setFont(new Font("Raleway",Font.BOLD,18));
        l2.setBounds(350,260,150,20);
        add(l2);
        
        String val_year[] = {"FY","SY","TY","B.Tech"};
        year = new JComboBox(val_year);
        year.setBounds(350,285,200,30);
        year.setFont(new Font("Raleway",Font.BOLD,16));
        year.setBackground(Color.white);
        add(year);
        
        id = new JLabel("PRN");
        id.setFont(new Font("Raleway",Font.BOLD,22));
        id.setBounds(150,380,50,20);
        add(id);
        
        f5 = new JTextField();
        f5.setBounds(220,380,200,30);
        f5.setFont(new Font("Raleway",Font.BOLD,20));
        add(f5);
        
        JLabel note = new JLabel("*Please fill all the above mentioned fields.");
        note.setBounds(200,440,400,20);
        add(note);
        
        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway",Font.BOLD,16));
        submit.setBounds(250,500,100,30);
        submit.addActionListener(this);
        add(submit);
        
        setSize(650,600);
        setLocation(400,200);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String i =f5.getText();
            
            if(i.equals("")){
                JOptionPane.showMessageDialog(null, "PRN no. is Required!!!");
            }else{
                int prn = Integer.parseInt(i);
                String pass = null;
                String full_name = f1.getText()+" "+f2.getText();
                String e_mail = f3.getText();
                long num = Long.parseLong(f4.getText());
                String br = (String)branch.getSelectedItem();
                String yr = (String)year.getSelectedItem();
            try{
                Conn c = new Conn();
                String query = "INSERT INTO student VALUES"+ "('"+prn+"','"+full_name+"','"+br+"','"+yr+"','"+num+"','"+e_mail+"','"+pass+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new Password(""+prn).setVisible(true);
        }catch(Exception e){
           System.out.println(e);
        }
            }
            
        }
    }
    
    public static void main(String args[]){
        new Signup();
    }
}
