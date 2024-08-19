package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

class Button1 implements ActionListener  {

    JFrame frame;
    Button1(JFrame f) {
        frame = f;
    }
    public void actionPerformed(ActionEvent e) {
        frame.setVisible(false);
        JFrame f1 = new JFrame();
        f1.setVisible(true);
        f1.setSize(400,400);
        f1.setLayout(new FlowLayout());
      System.out.println("button clicked");
        String column[]={"Driver","Team","Location","Points"};
        String[][] data = Formula1ChampionshipManager.getArray();
        System.out.println(Arrays.deepToString(data));
        JTable jt=new JTable(data,column);
        jt.setBounds(430,250,200,300);
        JScrollPane sp = new JScrollPane(jt);
        JButton back = new JButton("Back") ;
        f1.add(back);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               f1.setVisible(false);
               frame.setVisible(true);
            }
        });
        f1.add(sp);
    }
}


class Button2 implements ActionListener {
    JFrame frame;
    Button2(JFrame f) {frame = f;}
    public void actionPerformed(ActionEvent e){
        Formula1ChampionshipManager fm = new Formula1ChampionshipManager();
        fm.randomRace();
        System.out.println("Random race generated");
    }
}

class Button3 implements ActionListener {
    JFrame frame;
    Button3(JFrame f) {frame = f;}
    public void actionPerformed(ActionEvent e){
        frame.setVisible(false);
        JFrame f = new JFrame();
        f.setVisible(true);
        f.setSize(200,200);
        f.setLayout(new FlowLayout());
        Formula1ChampionshipManager fm = new Formula1ChampionshipManager();
        JLabel label = new JLabel("Table sorted");
        f.add(label);
        fm.sortByFirstPositions();
        JButton back = new JButton("Back") ;
        f.add(back);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                f.setVisible(false);
                frame.setVisible(true);
            }
        });
        System.out.println("Table sorted");
    }
}

class Button4 implements ActionListener {
    JFrame frame;
    Button4(JFrame f) {frame = f;}
    public void actionPerformed(ActionEvent e){
        frame.setVisible(false);
        JFrame f = new JFrame();
        f.setVisible(true);
        f.setSize(200,200);
        f.setLayout(new FlowLayout());
        Formula1ChampionshipManager fm = new Formula1ChampionshipManager();
        fm.randomStart();
        JLabel label = new JLabel("Starting points generated");
        f.add(label);
        fm.sortByFirstPositions();
        JButton back = new JButton("Back") ;
        f.add(back);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                f.setVisible(false);
                frame.setVisible(true);
            }
        });
        System.out.println("Table sorted");
    }
}

class Button5 implements ActionListener {
    JFrame frame;
    Button5(JFrame f) {frame = f;}
    public void actionPerformed(ActionEvent e){
        frame.setVisible(false);
        JFrame f = new JFrame();
        f.setVisible(true);
        f.setSize(400,400);
        f.setLayout(new FlowLayout());
        Formula1ChampionshipManager fm = new Formula1ChampionshipManager();
        fm.randomStart();
        JLabel label = new JLabel("Enter Driver Name: ");
        f.add(label);
        fm.sortByFirstPositions();
        JButton back = new JButton("Back") ;
        JButton b = new JButton("submit");
        f.add(back);
        f.add(b);
        JTextField text = new JTextField(20);
        f.add(text);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                f.setVisible(false);
                frame.setVisible(true);
            }
        });
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = text.getText();
                fm.checkStats(name);
            }
        });
        System.out.println("Table sorted");
    }
}

class Button6 implements ActionListener {
    JFrame frame;
    Button6(JFrame f) {frame = f;}
    public void actionPerformed(ActionEvent e){
        frame.setVisible(false);
        JFrame f = new JFrame();
        f.setVisible(true);
        f.setSize(200,200);
        f.setLayout(new FlowLayout());
        Formula1ChampionshipManager fm = new Formula1ChampionshipManager();
        JLabel label = new JLabel("Table sorted");
        f.add(label);
        fm.sortByPoints();
        JButton back = new JButton("Back") ;
        f.add(back);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                f.setVisible(false);
                frame.setVisible(true);
            }
        });
        System.out.println("Table sorted");
    }
}


public class Formula1Gui extends JFrame {
    JFrame frame = new JFrame();
    JLabel label = new JLabel();
    JButton button = new JButton("Table");
    JButton button1 = new JButton("Random race");
    JButton button2 = new JButton("Sort by 1st");
    JButton button3 = new JButton("Start points");
    JButton button4 = new JButton("Search driver");
    JButton button5 = new JButton("Sort by points");
    JButton button6 = new JButton("Sort by dates");


    Formula1Gui(){

        frame.setTitle("Formula 1 Race Manager");
        frame.setVisible(true);
        frame.setSize(1400,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout (new FlowLayout());
        frame.getContentPane().setBackground(new Color(123,50,250));

       label.setText("Formula 1 Race Manager");
       frame.add(label);
       //button to display table

//       button.setSize(100,50);
       button.setBounds(200,100,95,30);
       frame.add(button);
       button.addActionListener(new Button1(frame));



        //button to sort table in ascending order
//        button1.setSize(100,50);
        button1.setBounds(200,150,95,30);
        frame.add(button1);
        button1.addActionListener(new Button2(frame));


        button2.setBounds(200,200,95,30);
        frame.add(button2);
        button2.addActionListener(new Button3(frame));

        button3.setBounds(200,200,95,30);
        frame.add(button3);
        button3.addActionListener(new Button4(frame));

        button4.setBounds(200,200,95,30);
        frame.add(button4);
        button4.addActionListener(new Button5(frame));

        button5.setBounds(200,200,95,30);
        frame.add(button5);
        button4.addActionListener(new Button6(frame));

        button6.setBounds(200,200,95,30);
        frame.add(button6);
//        button4.addActionListener(new Button7(frame));
    }


}
