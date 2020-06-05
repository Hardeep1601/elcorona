package elcorona;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import  java.io.*;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class CatSound extends javax.swing.JFrame {
    public String file()
            
    { String str="";
        try{
        Scanner sc=new Scanner(new FileInputStream("active.txt"));
        while(sc.hasNext())
        {
          str=sc.next();
        }
         sc.close();
    }
    catch(Exception e){}
        return str;
    }
    public void close(){
       WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
 Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
   }
        public cat readobj()
    {  
         try {
 
            FileInputStream fileOut = new FileInputStream(file());
            ObjectInputStream objectOut = new ObjectInputStream(fileOut);
            cat c = (cat) objectOut.readObject();
            objectOut.close();
            return c;
        } catch (Exception ex) {
         return null;
        }
    }
    public void write(String s,int i){
        try{
            switch(i)
            {
                case 1: {
                             PrintWriter p= new PrintWriter(new FileOutputStream("src\\talk.txt",true));
                            p.print(s+"\n");
                            p.close();
                            break;
                          }
                case 2: {
                    PrintWriter p= new PrintWriter(new FileOutputStream("src\\talk.txt"));
                System.out.println("Clearing chat ");
                p.print(s);
                p.close();
                break;
                }
            }
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null,"Didnt record that");
        }
            
    }
    public void read(){
        String s="";
        try{
            Scanner in= new Scanner(new FileInputStream("src\\talk.txt"));
            while(in.hasNextLine()){
                s+=in.nextLine()+"\n";
                userDisplay.setText(s);
            }
            in.close();
        }catch(FileNotFoundException e){}
    }

    public CatSound() {
        initComponents();
    }

 cat c=readobj();
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userDisplay = new javax.swing.JTextPane();
        userInput = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        talkButton = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        userDisplay.setEditable(false);
        userDisplay.setBackground(new java.awt.Color(153, 153, 255));
        userDisplay.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        userDisplay.setForeground(new java.awt.Color(0, 0, 0));
        userDisplay.setSelectedTextColor(new java.awt.Color(102, 102, 102));
        userDisplay.setSelectionColor(new java.awt.Color(255, 255, 204));
        jScrollPane1.setViewportView(userDisplay);

        userInput.setBackground(new java.awt.Color(153, 153, 255));
        userInput.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        userInput.setForeground(new java.awt.Color(0, 0, 0));

        jButton1.setText(" CLOSE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        talkButton.setText("TALK");
        talkButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                talkButtonMouseClicked(evt);
            }
        });
        talkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                talkButtonActionPerformed(evt);
            }
        });
        talkButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                talkButtonKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(talkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(253, 253, 253))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userInput, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userInput, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(talkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void talkButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        if(userInput.getText().trim().isEmpty())
        JOptionPane.showMessageDialog(null, "Empty chat ");
        else
        {
            String s =userInput.getText().trim();
        write(s,1);
        write(c.name+" : Meow",1);
        int catLvl=c.level;
        
        sound(soundFile(catLvl));//put filename
        
        read();
        userInput.setText("\0");
        }
    }                                          

    private void talkButtonMouseClicked(java.awt.event.MouseEvent evt) {                                        

    }                                       

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
 int test =JOptionPane.showConfirmDialog(
            null,
            "Do you want to close ?",
            "CONFIRM",
            JOptionPane.YES_NO_OPTION);
       if(test==0)
       {  
           write("\0",2);
           c.happiness+=15;
           new Home().setVisible(true);
       close();
       }
    }                                        

    private void talkButtonKeyPressed(java.awt.event.KeyEvent evt) {                                      

    }                                     
    

private  void sound(String filename){
//** add this into your application code as appropriate
// Open an input stream  to the audio file.

  try {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filename).getAbsoluteFile());
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
    } catch(Exception ex) {
        System.out.println("Error with playing sound.");
        ex.printStackTrace();
    }
}
private String soundFile(int catLevel){
    
    
    Random r= new Random();
    int rand=r.nextInt(catLevel);
    
    
    switch(catLevel){
        
        case 1:
            
          return "src\\Meow\\kitten-meow-1.wav";  
        case 2:
           
           return "src\\Meow\\kitten-meow-1.wav";
            
            
        case 3:
            if(rand==0){
           return "src\\Meow\\Cat-meow-1.wav";
            }
            else if(rand==1){
                return"src\\Meow\\Cat-meow-2.wav";
            }
            
        case 4:
            if(rand==0){
           return "src\\Meow\\Cat-meow-1.wav";
            }
            else if(rand==1){
                return"src\\Meow\\Cat-meow-2.wav";
            }
            else{
                return "src\\Meow\\Cat-meow-3.wav";
            }
            
        case 5:
            if(rand==0){
           return "src\\Meow\\Cat-meow-1.wav";
            }
            else if(rand==1){
                return"src\\Meow\\Cat-meow-2.wav";
            }
            else if(rand==2){
                return "src\\Meow\\Cat-meow-3.wav";
            }
            else if(rand==3)
            return "src\\Meow\\Cat-meow-4.wav";
            else
            return "src\\Meow\\Cat-meow-5.wav";
        case 6 :
            if(rand==0){
           return "src\\Meow\\Cat-meow-1.wav";
            }
            else if(rand==1){
                return"src\\Meow\\Cat-meow-2.wav";
            }
            else if(rand==2){
                return "src\\Meow\\Cat-meow-3.wav";
            }
            else if(rand==3)
            return "src\\Meow\\Cat-meow-4.wav";
            else
            return "src\\Meow\\Cat-meow-5.wav";
        case 7:
            if(rand==0){
           return "src\\Meow\\Cat-meow-1.wav";
            }
            else if(rand==1){
                return"src\\Meow\\Cat-meow-2.wav";
            }
            else if(rand==2){
                return "src\\Meow\\Cat-meow-3.wav";
            }
            else if(rand==3)
            return "src\\Meow\\Cat-meow-4.wav";
            else if(rand==4)
            return "src\\Meow\\Cat-meow-5.wav";
            else
            return "src\\Meow\\Cat-meow-6.wav";
            
        case 8:    
            if(rand==0){
           return "src\\Meow\\Cat-meow-1.wav";
            }
            else if(rand==1){
                return"src\\Meow\\Cat-meow-2.wav";
            }
            else if(rand==2)
                return "src\\Meow\\Cat-meow-3.wav";
            else if(rand==3)
            return "src\\Meow\\Cat-meow-4.wav";
            else if(rand==4)
            return "src\\Meow\\Cat-meow-5.wav";
            else if(rand==5)
            return "src\\Meow\\Cat-meow-6.wav";
            else 
            return "src\\Meow\\Cat-meow-7.wav";    
            
            
        case 9:  
            if(rand==0){
           return "src\\Meow\\Cat-meow-1.wav";
            }
            else if(rand==1){
                return"src\\Meow\\Cat-meow-2.wav";
            }
            else if(rand==2)
                return "src\\Meow\\Cat-meow-3.wav";
            else if(rand==3)
            return "src\\Meow\\Cat-meow-4.wav";
            else if(rand==4)
            return "src\\Meow\\Cat-meow-5.wav";
            else if(rand==5)
            return "src\\Meow\\Cat-meow-6.wav";
            else if(rand==6) 
            return "src\\Meow\\Cat-meow-7.wav"; 
            else
            return "src\\Meow\\Cat-meow-8.wav";   
            
        case 10: 
            if(rand==0){
           return "src\\Meow\\Cat-meow-1.wav";
            }
            else if(rand==1){
                return"src\\Meow\\Cat-meow-2.wav";
            }
            else if(rand==2)
                return "src\\Meow\\Cat-meow-3.wav";
            else if(rand==3)
            return "src\\Meow\\Cat-meow-4.wav";
            else if(rand==4)
            return "src\\Meow\\Cat-meow-5.wav";
            else if(rand==5)
            return "src\\Meow\\Cat-meow-6.wav";
            else if(rand==6) 
            return "src\\Meow\\Cat-meow-7.wav"; 
            else if(rand==7)
            return "src\\Meow\\Cat-meow-8.wav"; 
            else
            return "src\\Meow\\Cat-meow-9.wav";    
        case 11:
            if(rand==0){
           return "src\\Meow\\Cat-meow-1.wav";
            }
            else if(rand==1){
                return"src\\Meow\\Cat-meow-2.wav";
            }
            else if(rand==2)
                return "src\\Meow\\Cat-meow-3.wav";
            else if(rand==3)
            return "src\\Meow\\Cat-meow-4.wav";
            else if(rand==4)
            return "src\\Meow\\Cat-meow-5.wav";
            else if(rand==5)
            return "src\\Meow\\Cat-meow-6.wav";
            else if(rand==6) 
            return "src\\Meow\\Cat-meow-7.wav"; 
            else if(rand==7)
            return "src\\Meow\\Cat-meow-8.wav"; 
            else
            return "src\\Meow\\Cat-meow-9.wav";   
            
        case 12:
            if(rand==0){
           return "src\\Meow\\Cat-meow-1.wav";
            }
            else if(rand==1||rand==11){
                return"src\\Meow\\Cat-meow-2.wav";
            }
            else if(rand==2||rand==10)
                return "src\\Meow\\Cat-meow-3.wav";
            else if(rand==3||rand==9)
            return "src\\Meow\\Cat-meow-4.wav";
            else if(rand==4)
            return "src\\Meow\\Cat-meow-5.wav";
            else if(rand==5)
            return "src\\Meow\\Cat-meow-6.wav";
            else if(rand==6||rand==8) 
            return "src\\Meow\\Cat-meow-7.wav"; 
            else if(rand==7)
            return "src\\Meow\\Cat-meow-8.wav"; 
            else
            return "src\\Meow\\Cat-meow-9.wav";   
            
        case 13 :
            if(rand==0||rand==9){
           return "src\\Meow\\Cat-meow-1.wav";
            }
            else if(rand==1){
                return"src\\Meow\\Cat-meow-2.wav";
            }
            else if(rand==2||rand==12)
                return "src\\Meow\\Cat-meow-3.wav";
            else if(rand==3)
            return "src\\Meow\\Cat-meow-4.wav";
            else if(rand==4||rand==10)
            return "src\\Meow\\Cat-meow-5.wav";
            else if(rand==5)
            return "src\\Meow\\Cat-meow-6.wav";
            else if(rand==6||rand==8) 
            return "src\\Meow\\Cat-meow-7.wav"; 
            else if(rand==7)
            return "src\\Meow\\Cat-meow-8.wav"; 
            else
            return "src\\Meow\\Cat-meow-9.wav";   
        case 14:
            if(rand==0){
           return "src\\Meow\\Cat-meow-1.wav";
            }
            else if(rand==1||rand==13){
                return"src\\Meow\\Cat-meow-2.wav";
            }
            else if(rand==2)
                return "src\\Meow\\Cat-meow-3.wav";
            else if(rand==3||rand==11)
            return "src\\Meow\\Cat-meow-4.wav";
            else if(rand==4||rand==10)
            return "src\\Meow\\Cat-meow-5.wav";
            else if(rand==5||rand==9)
            return "src\\Meow\\Cat-meow-6.wav";
            else if(rand==6||rand==8) 
            return "src\\Meow\\Cat-meow-7.wav"; 
            else if(rand==7)
            return "src\\Meow\\Cat-meow-8.wav"; 
            else
            return "src\\Meow\\Cat-meow-9.wav"; 
            
        case 15:
            if(rand==0){
           return "src\\Meow\\Cat-meow-1.wav";
            }
            else if(rand==1||rand==13){
                return"src\\Meow\\Cat-meow-2.wav";
            }
            else if(rand==2||rand ==14)
                return "src\\Meow\\Cat-meow-3.wav";
            else if(rand==3||rand==11)
            return "src\\Meow\\Cat-meow-4.wav";
            else if(rand==4||rand==10)
            return "src\\Meow\\Cat-meow-5.wav";
            else if(rand==5||rand==9)
            return "src\\Meow\\Cat-meow-6.wav";
            else if(rand==6||rand==8) 
            return "src\\Meow\\Cat-meow-7.wav"; 
            else if(rand==7)
            return "src\\Meow\\Cat-meow-8.wav"; 
            else
            return "src\\Meow\\Cat-meow-9.wav";   
            
    }
        return null;
    
   
}
    
    
     
    /**
     * @param args the command line arguments
     */
       public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CatSound.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CatSound.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CatSound.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CatSound.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CatSound().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton talkButton;
    private javax.swing.JTextPane userDisplay;
    private javax.swing.JTextField userInput;
    // End of variables declaration                   
}