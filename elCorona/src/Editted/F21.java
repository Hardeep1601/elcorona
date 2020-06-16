/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Editted;

//import elcorona.Places;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.Timer;
//import pkgnew.DPerson;
//import pkgnew.ActivityLog;
//import pkgnew.DPerson;
//import pkgnew.Household;
//import pkgnew.LogHousehold;
//import pkgnew.Places;

/**
 *
 * @author koghu
 */
public class F21 extends JPanel implements ActionListener {

    JFrame frame = new JFrame();
    JFrame frame2 = new JFrame();
    JLabel label = new JLabel();
    JLabel labe2 = new JLabel();
    JLabel day = new JLabel("Day");
    JLabel Sspeed = new JLabel();
    JPanel p = new JPanel();
    JButton b;
    JButton contact;
    JButton infc = new JButton("Infect");
    JButton pSpeed = new JButton("+");
    JButton mSpeed = new JButton("-");
    JButton info = new JButton("Information");
    JButton map = new JButton("Map");
    private int speed = 5;
    private int c = 1;
    private static int population;
    boolean pause = false;
    Data d = new Data();
    JTextArea jt = new JTextArea();
    JScrollPane sp = new JScrollPane();
    private ArrayList<DPerson> people = new ArrayList<>();
    String s;

    private static ArrayList<String[]> list;

    public static void main(String[] args) {
//        Data d= new Data();

        F21 f = new F21(2);
    }

    public F21(int a) {
        population = a;
        jt.setEditable(true);
//        frame = new JFrame();
//        frame2 = new JFrame();
        frame.setSize(1380, 728);
        b = new JButton("Start");
        contact = new JButton("Contact Tracer");
        contact.setBounds(50, 0, 100, 30);
        b.setBounds(50, 0, 100, 30);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame2.setSize(800, 600);
        jt.setBounds(200, 200, 150, 100);
//        sp.setBounds(100, 200, 100, 100);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (pause == false) {
                    pause = true;
                    b.setText("Start");
                } else {
                    pause = false;
                    b.setText("Pause");
                }
            }
        });
        contact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                frame2.setVisible(true);
                TextAreaLogProgram tx = new TextAreaLogProgram();
            }
        });
        infc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                infcM();
            }
        });
        pSpeed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (speed < 9) {
                    speed++;
                }
                Sspeed.setText(Integer.toString(speed));
            }
        });
        mSpeed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (speed > 1) {
                    speed--;
                }
                Sspeed.setText(Integer.toString(speed));

            }
        });
        map.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame m = new JFrame("Map");
                m.setContentPane(new JLabel(new ImageIcon("map.png")));
                m.setSize(1062,700);
m.setVisible(true);
            }
        });

            label.setFont(new Font("Serif", Font.PLAIN, 16));
            labe2.setFont(new Font("Serif", Font.PLAIN, 16));
            day.setFont(new Font("Serif", Font.PLAIN, 16));
        Timer t = new Timer(60, this);
        t.restart();
        label.setText("Day");
        labe2.setText("Population: ");
        p.add(map);
        p.add(Sspeed);
        p.add(day);
        p.add(label);
        p.add(b);
        p.add(contact);
        p.add(labe2);
        p.add(infc);
        p.add(pSpeed);
        p.add(mSpeed);
        p.setLayout(null);
//        sp.add(jt);
        sp.setViewportView(jt);
        p.add(sp);
//        p.add(jt);
        p.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));

        p.setBackground(Color.lightGray);
        p.setPreferredSize(new Dimension(300, 720));
        frame.add(p, BorderLayout.EAST);
        frame.add(this);
        frame.setVisible(true);

        for (int i = 0; i < 10; i++) {
            people.add(new DPerson(i + 1));

        }
        jt.setText(d.getInfected());
        label.setText("Day: " + d.getSDay());
        labe2.setText("Population: " + population);
        String s = d.getDay();
        day.setText(s);
        Sspeed.setText(Integer.toString(speed));
    }

    public void paint(Graphics g) {
        c++;
        super.paintComponent(g);
        Places p1 = new Places(g);
        for (DPerson p : people) {
            p.paint(g, speed);
        }

    }

    public void infcM() {
        JFrame parent = new JFrame();

        int slot = Integer.parseInt(JOptionPane.showInputDialog(parent,
                "Enter the Human ID to be infected", null));
        people.get(slot - 1).infect();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (pause == false) {
            b.setText("Pause");
            repaint();
            jt.setText(d.getInfected());
            label.setText("Day: " + d.getSDay());
//            labe2.setText("Population: " + population);
//            jt.setText(d.getInfected());
            String s = d.getDay();
            day.setText(s);
        } else {
            b.setText("Start");
        }
        Sspeed.setBounds(150, 250, 50, 50);
        pSpeed.setBounds(190, 250, 50, 50);
        mSpeed.setBounds(80, 250, 50, 50);
        map.setBounds(120, 320, 70, 30);
        infc.setBounds(90, 200, 130, 30);
        labe2.setBounds(110, 40, 100, 100);
        label.setBounds(130, 30, 50, 30);
        day.setBounds(125, 45, 300, 50);
        b.setBounds(90, 120, 130, 30);
        contact.setBounds(90, 160, 130, 30);
        sp.setBounds(60, 400, 200, 250);

    }

}
