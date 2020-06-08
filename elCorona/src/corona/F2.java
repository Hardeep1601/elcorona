/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corona;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author koghu
 */
public class F2 extends JPanel implements ActionListener {

    JFrame frame = new JFrame();
    JFrame frame2 = new JFrame();
    JLabel label = new JLabel();
    JLabel labe2 = new JLabel();
    JPanel p = new JPanel();
    JButton b;
    JButton contact;
    private int j = 2;
    private int c = 1;
    private static int population;
    boolean pause = false;

    private ArrayList<DPerson> people = new ArrayList<>();
    
    private static ArrayList<String[]> list;
    
    public static void main(String[] args) {
        Household h = new Household();
        LogHousehold logh = new LogHousehold();
        ActivityLog loga = new ActivityLog();
        h.generate(100);
        population=h.getTotalPopulation();
        logh.logHouseHold(h.showAll());
        loga.activityLog(h.getHouse());
        list = loga.getList();
        F2 f = new F2();
    }

    public F2() {
        j++;
        frame = new JFrame();
        frame2 = new JFrame();
        frame.setSize(1380, 728);
        b = new JButton("Pause");
        contact = new JButton ("Contact Tracer");
        contact.setBounds(50, 0, 100, 30);
        b.setBounds(50, 0, 100, 30);
//        frame2.setSize(200, 728);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Timer t = new Timer(20, this);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (pause == false) {
                    pause = true;
                } else {
                    pause = false;
                }
            }
        });
        contact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame2.setVisible(true);
            }
        });
        t.restart();
        label.setText("LOL" + j);
        labe2.setText("fun");
//        label.setSize(new Dimension(400,400));
//        label.setBounds(400, 400, 50, 50);
//        label.setLocation(400, 400);
//        label.setVisible(true);
//        add(label);
        p.add(label);
        p.add(b);
        p.add(contact);
        p.add(labe2);
        p.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
//        p.add(this);
//        add(label);

//        p.setBackground(Color.red);
        p.setBackground(Color.lightGray);
        p.setPreferredSize(new Dimension(300, 720));

//frame.pack();
        frame.add(p, BorderLayout.EAST);
        frame.add(this);
        frame.setVisible(true);
//        frame2.setVisible(true);
//        frame.set

        for (int i = 0; i < population; i++) {
            people.add(new DPerson(i+1));
            
        }
        for(DPerson d: people){
            d.setActList(list);
        }
    }

    public void paint(Graphics g) {
        j++;
        super.paintComponent(g);
//        g.setColor(Color.red);
        Places p1 = new Places(g);
        
        for (DPerson p : people) {
            p.paint(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (pause == false) {
            repaint();
        }

        if (j % 1200 == 0) {
            c++;
        }
//        label.setLocation(500,700);
        label.setText("Day " + c);
        labe2.setText("Population " + population);
        label.setBounds(100, 10, 50, 50);
        labe2.setBounds(100, 30, 200, 50);
        b.setBounds(100, 70, 100, 20);
        contact.setBounds(100, 110, 100, 20);
    }

}
