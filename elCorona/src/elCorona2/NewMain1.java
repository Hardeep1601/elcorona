/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elCorona2;

import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author USER
 */
public class NewMain1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    JFrame frame = new JFrame("Test");
    JPanel panel = new JPanel();
    JLabel label = new JLabel("CenteredJLabel");

    panel.setLayout(new GridBagLayout());
    panel.add(label);
    panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.add(panel);
    frame.setSize(400, 300);
    frame.setVisible(true);

  }
    
}
