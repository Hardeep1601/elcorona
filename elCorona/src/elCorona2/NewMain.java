/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//https://stackoverflow.com/questions/29798739/how-do-i-make-a-jtextarea-fill-up-a-jpanel-completely/29798873
package elCorona2;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author USER
 */
public class NewMain extends JFrame implements ActionListener{

      
    private static final long serialVersionUID = 1L;  
  
    private static void createAndShowGUI() {  
        graphMAIN g=new graphMAIN();
        // Create and set up the window.  
        final JFrame frame = new JFrame("Contact Tracer");  
  
        // Display the window.  
        frame.setSize(600, 900);  
        frame.setVisible(true);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
  
        // set flow layout for the frame  
        frame.getContentPane().setLayout(new FlowLayout());  
  
        JTextArea textArea = new JTextArea(50, 50);  
        String show="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\naaaaaaaaaaaaaaaaaaaaaaaaa\naaaaaaaa\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\naaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        
        textArea.setText(g.storeOutput);
        JScrollPane scrollableTextArea = new JScrollPane(textArea);  
  
        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
  
        frame.getContentPane().add(scrollableTextArea);  
    }  
    public static void main(String[] args) {  
  
  
        javax.swing.SwingUtilities.invokeLater(new Runnable() {  
  
            public void run() {  
                createAndShowGUI();  
            }  
        });  
    }  

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
