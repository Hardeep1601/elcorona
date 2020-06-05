/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elcorona;

import static elcorona.textBox2.f;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/**
 *
 * @author USER
 */
public class textBox2  extends JFrame implements ActionListener{
      
    // JFrame 
    static JFrame f; 
  
    // JButton 
    static JButton b; 
  
    // label to display text 
    static JLabel l, l1; 
  
    // text area 
    static JTextArea jt; 
    
    // default constructor 
    textBox2() 
    { 
    } 
  
    // main class 
    public static void main(String[] args) 
    { 
        textBox2 te = new textBox2(); 
        // create a new frame to store text field and button 
        f = new JFrame("textfield"); 
  
        // create a label to display text 
        l = new JLabel("nothing entered", SwingConstants.CENTER); 
//        l.setText("Centered");
        l1 = new JLabel("0 lines"); 
        l1.setBounds(100, 100, 140, 40);
        // create a new buttons 
        b = new JButton("submit"); 
        
        
  
        // create a object of the text class 
  
        // addActionListener to button 
        b.addActionListener(te); 
  
        // create a text area, specifying the rows and columns 
        JScrollPane scrollPane = new JScrollPane(jt); 
        jt = new JTextArea("", 10, 50); 
        jt.setBounds(10, 110, 200, 100);

//        jt.setLocation(400, 400); 
  
        JPanel p = new JPanel(); 
  
        // add the text area and button to panel 
        p.add(jt); 
        p.add(b); 
        p.add(l); 
        p.add(l1); 
  
        f.add(p); 
        // set the size of frame 
        f.setSize(800, 600); 
  
        f.show(); 
    } 
  
    // if the button is pressed 
    public void actionPerformed(ActionEvent e) 
    { 
        String s = e.getActionCommand(); 
        if (s.equals("submit")) { 
            // set the text of the label to the text of the field 
            l.setText(jt.getText() + ", "); 
            l1.setText(jt.getLineCount() + " lines"); 
        } 

    }
}
