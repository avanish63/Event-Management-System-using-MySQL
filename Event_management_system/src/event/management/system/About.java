package event.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener{
    JButton b1;
    About(){
        setTitle("Home page");
        setLayout(null);
        getContentPane().setBackground(Color.GRAY);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/back.jpg"));
        Image i2=i1.getImage().getScaledInstance(1000, 600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(0,0,1000,600);
        add(label);
        
        JLabel text = new JLabel("Vishwakarandak");
        text.setFont(new Font("Osward",Font.BOLD,48));
        text.setForeground(Color.GREEN);
        text.setBounds(280,80,450,40);
        label.add(text);
        
        JLabel info = new JLabel("Vishwakarandak is a 4-day fest full of healthy competition");
        info.setFont(new Font("Osward",Font.BOLD,26));
        info.setForeground(Color.WHITE);
        info.setBounds(100,150,800,40);
        label.add(info);
        
        JLabel info2 = new JLabel(" and challenges all around, comprising sports, literature,");
        info2.setFont(new Font("Osward",Font.BOLD,26));
        info2.setForeground(Color.WHITE);
        info2.setBounds(100,180,800,40);
        label.add(info2);
        
        JLabel info3 = new JLabel("technical activities, arts, auctions and many more. While");
        info3.setFont(new Font("Osward",Font.BOLD,26));
        info3.setForeground(Color.WHITE);
        info3.setBounds(100,210,800,40);
        label.add(info3);
        
        JLabel info4 = new JLabel("every department puts on a show of exceptional talent and");
        info4.setFont(new Font("Osward",Font.BOLD,26));
        info4.setForeground(Color.WHITE);
        info4.setBounds(100,240,800,40);
        label.add(info4);
        
        JLabel info5 = new JLabel("persistence to rise to the top, amity and moral principles are");
        info5.setFont(new Font("Osward",Font.BOLD,26));
        info5.setForeground(Color.WHITE);
        info5.setBounds(100,270,800,40);
        label.add(info5);
        
        JLabel info6 = new JLabel("valued and nurtured. Vishwakarandak can be considered an");
        info6.setFont(new Font("Osward",Font.BOLD,26));
        info6.setForeground(Color.WHITE);
        info6.setBounds(100,300,800,40);
        label.add(info6);
        
        JLabel info7 = new JLabel("opportunity for the students to keep in touch with their");
        info7.setFont(new Font("Osward",Font.BOLD,26));
        info7.setForeground(Color.WHITE);
        info7.setBounds(100,330,800,40);
        label.add(info7);
        
        JLabel info8 = new JLabel("passions, paralleling academics.");
        info8.setFont(new Font("Osward",Font.BOLD,26));
        info8.setForeground(Color.WHITE);
        info8.setBounds(100,360,800,40);
        label.add(info8);
        
        
        b1 = new JButton("< Back");
        b1.setContentAreaFilled(false);
        b1.setFont(new Font("Railway",Font.BOLD,16));
        b1.setBorderPainted(false);
        b1.setBounds(50,40,100,40);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        label.add(b1);
    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,600);
        setLocation(250,150);
        setVisible(true);
        
    }
     public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            setVisible(false);
            new Home().setVisible(true);
        }
        
        
    }
    public static void main(String args[]){
        new About();
    }
}
