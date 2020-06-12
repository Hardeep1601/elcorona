/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elCorona2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author USER
 */
public class NewMain2 {

     public static void main(String[] args){
    // Create JComponents and add them to containers.
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    panel.setLayout(new BorderLayout());

    JTextArea jta = new JTextArea("Hello world!");
    panel.add(jta);
    frame.add(panel);

    // Modify some properties.
//    jta.setRows(10);
//    jta.setColumns(10);
    jta.setBackground(Color.WHITE);
    panel.setBorder(new EtchedBorder());

    // Display the Swing application.
    frame.setSize(800, 600);
    frame.setVisible(true);
  }
}
