/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main_ElCorona;

//import project.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;

/**
 *
 * https://www.codejava.net/java-se/swing/redirect-standard-output-streams-to-jtextarea
 * https://www.codejava.net/java-se/swing/redirect-standard-output-streams-to-jtextarea
 */
public class TextAreaLogProgram extends JFrame{
    private JTextArea textArea;
     
    private JButton buttonStart = new JButton("Start");
//    private JButton buttonClear = new JButton("Exit");
     
    private PrintStream standardOut;
     
    public TextAreaLogProgram() {
        super("Contact Tracer");
        
        final JFrame parent = new JFrame();
//        JButton button = new JButton();

        parent.pack();
        parent.setLocationRelativeTo(null);    // centers on screen
        parent.setVisible(true);


        
        int slot = Integer.parseInt(JOptionPane.showInputDialog(parent,
                        "What is starting slot ? (In numbers, 1 - 10)", null));
        int startDay = Integer.parseInt(JOptionPane.showInputDialog(parent,
                        "What is start day ? (In numbers)", null));
        int endDay = Integer.parseInt(JOptionPane.showInputDialog(parent,
                        "What is end day ? (In numbers)", null));
        int find = Integer.parseInt(JOptionPane.showInputDialog(parent,
                        "What is human ID to be searched ? (In numbers)", null));
        int depth = Integer.parseInt(JOptionPane.showInputDialog(parent,
                        "What is depth of desired tree ? (In numbers, starts from 0)", null));
        
        
        this.slot=slot;
        this.startDay=startDay;
         this.endDay=endDay;
         this.find=find;
         this.depth=depth;
         
        textArea = new JTextArea(50, 10);
        textArea.setEditable(false);
        PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));
         
        // keeps reference of standard output stream
        standardOut = System.out;
         
        // re-assigns standard output stream and error output stream
        System.setOut(printStream);
        System.setErr(printStream);
 
        // creates the GUI
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.anchor = GridBagConstraints.WEST;
         
        add(buttonStart, constraints);
         
        constraints.gridx = 1;
//        add(buttonClear, constraints);
         
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
         
        
        add(new JScrollPane(textArea), constraints);
         
        // adds event handler for button Start
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                printLog();
            }
        });

        //sets the Default window size 
        
        setSize(600, 800);
        setLocationRelativeTo(null);    // centers on screen
//        setSize(480, 320);
        this.setVisible(true);
    }
     
    
    
    int slot;
    int startDay;
    int endDay;
    int depth;
    
    public void printLog() {
        Thread thread = new Thread(new Runnable() {
            @Override
            
            public void run() {
                
//                while (true) {
//                    System.out.println("Time now is hello " + (new Date()));
                    
//            int slot=1;
//            int startDay=1;
//            int endDay=3;
//            //is a st
//            find=1;
//            int depth=8;
            
            // Used to run the contact tracer
            runTracer(find,depth,slot,startDay,endDay);
            
                    
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException ex) {
//                        ex.printStackTrace();
//                    }
//                }
            }
        });
        thread.start();
    }
     
    /**
     * Runs the program
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TextAreaLogProgram().setVisible(true);
            }
        });
    }
    
    
//    static Graph<String, Integer> graph = new Graph<>();

    static ArrayList<String> houseNum=new ArrayList<>();
    static ArrayList<String> ID=new ArrayList<>();
    static ArrayList<String> age=new ArrayList<>();
    static ArrayList<String> role=new ArrayList<>();
    static ArrayList<String> occ=new ArrayList<>();
    static ArrayList<String> gender=new ArrayList<>();
    static ArrayList<String> family=new ArrayList<>();
    static ArrayList<String> slot1=new ArrayList<>();
    static ArrayList<String> slot2=new ArrayList<>();
    static ArrayList<String> slot3=new ArrayList<>();
    static ArrayList<String> slot4=new ArrayList<>();
    static ArrayList<String> slot5=new ArrayList<>();
    static ArrayList<String> slot6=new ArrayList<>();
    static ArrayList<String> slot7=new ArrayList<>();
    static ArrayList<String> slot8=new ArrayList<>();
    static ArrayList<String> slot9=new ArrayList<>();
    static ArrayList<String> slot10=new ArrayList<>();
    //used to add people who has visited the same place, ex flat
    static ArrayList<String> addedPeople=new ArrayList<>();
    public static int humanCount=0;
    
    public static int find=0;
    
//    public static int slot;
//    public static int startDay;
//    public static int endDay;
//    public static int depth;
    
    
    
   
    static ArrayList<String[]> dayStore=new ArrayList<>();
    
    
    // change the forgetness value here
    static int forget=50;
    public static int humanAdded=0;
    
    public static void runTracer(int find, int depth,int startSlot, int startDay, int endDay){
        System.out.println("Run Contact tracer...");
        System.out.println("Tracing contact for HumanID "+find+" with DEPTH of "+depth+" from SLOT "+startSlot+" of DAY "+startDay+" to DAY "+endDay+" : ");
        System.out.println(find + "  "+Math.pow(0.9, 0));  
        readLog();      //read the general human info - has an error(not yet identified)
        sameHome();     // adds the people from the same home to an ArrayList

        
        
        for (int i = startDay; i <= endDay; i++) {
            if(i!=startDay){
                startSlot=1;
            }
            readActivityLog(i);
//            findLog(find);
            
            
            ArrayList<String> prev=new ArrayList<>();
            System.out.println("Day : "+ i);
            contactTracer(find,depth,1,prev,startSlot,i);
            
            clearSlots();
        }
        System.out.println("\nThe number of POSSIBLY INFECTED people : "+addedPeople.size());
        addedPeople.clear();
        // User giving out their data of visited places 
        
        System.out.println("\n--------------Information given the human--------------\n");
        System.out.println("Human ID : "+ID.get(find-1));
        System.out.println("House : "+houseNum.get(find-1));
        System.out.println("Age: "+age.get(find-1));
        System.out.println("Role: "+role.get(find-1));
        System.out.println("Occupation: "+occ.get(find-1));
        System.out.println("Gender: "+gender.get(find-1));
        System.out.println("Forgetness : "+forget);
        System.out.println("Family Members: "+family);
        
        
        for (int i = startDay; i <= endDay; i++) {
            System.out.println("\nLog Day : " + i);
            findLog(find, forget, i);
            clearSlots();
        }
//        findLog(find);
            
//        addedPeople.sort(c);
        
//        System.out.println(slot10.size());
        
    }
    
//    private PrintStream standardOut;
    public static void clearSlots(){
            slot1.clear();
            slot2.clear();
            slot3.clear();
            slot4.clear();
            slot5.clear();
            slot6.clear();
            slot7.clear();
            slot8.clear();
            slot9.clear();
            slot10.clear();
    }
    
    public static void readLog(){
        try{
           FileInputStream fstream = new FileInputStream("Household.log");
           BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
           
           //Initialise arrays to temporary hold the values
           String strLine;
           String house[];
           String id[];
           String Age[];
           String Role[];
           String Occ[];
           String Gender[];
           String temp[];
           /* read log line by line */
           
           // Reads the first 2 line
           strLine = br.readLine();         // Reads the info of the log, datem timem etc
           strLine = br.readLine();         // Reads the "INFO:" line
           String setHouse="";
           int count=0;
           while ((strLine = br.readLine()) != null)   {        //reads the first line
             /* Read house number, ID, age, role, occupation, gender */

                house=strLine.split(" ");
                houseNum.add(house[1]);
                humanCount++;
                  
                    
                strLine = br.readLine();
                id=strLine.split(" ");
                ID.add(id[1]);
//                graph.addVertice(id[1]);
                
                strLine = br.readLine();
                Age=strLine.split(" ");
                age.add(Age[1]);
                
                strLine = br.readLine();
                Role=strLine.split(" ");
                role.add(Role[1]);
                
                strLine = br.readLine();
                Occ=strLine.split(": ");
                occ.add(Occ[1]);
                
                strLine = br.readLine();
                Gender=strLine.split(" ");
                gender.add(Gender[1]);
                
                //reads the line -----------
                count++;
                strLine = br.readLine();        
                
           }
           fstream.close();
        } catch (Exception e) {
             System.err.println("Error: " + e.getMessage());
        }
    }
    
    
    public static void findLog(int id){
        
        System.out.println("-------Information from the log file-------\n");
        System.out.println("Human ID : "+ID.get(id-1));
        System.out.println("House : "+houseNum.get(id-1));
        System.out.println("Age: "+age.get(id-1));
        System.out.println("Role: "+role.get(id-1));
        System.out.println("Occupation: "+occ.get(id-1));
        System.out.println("Gender: "+gender.get(id-1));
        System.out.println("\n-------The activities done along the day-------");
        System.out.println("Slot 1 = "+slot1.get(id-1));
        System.out.println("Slot 2 = "+slot2.get(id-1));
        System.out.println("Slot 3 = "+slot3.get(id-1));
        System.out.println("Slot 4 = "+slot4.get(id-1));
        System.out.println("Slot 5 = "+slot5.get(id-1));
        System.out.println("Slot 6 = "+slot6.get(id-1));
        System.out.println("Slot 7 = "+slot7.get(id-1));
        System.out.println("Slot 8 = "+slot8.get(id-1));
        System.out.println("Slot 9 = "+slot9.get(id-1));
        System.out.println("Slot 10 = "+slot10.get(id-1));
        
    }
    
    //the higher the forget level the lower the forgetness
    public static void findLog(int id, int forget,int day){
        
//        graphMAIN.forget=5-forget;
        readActivityLog(day);
        Random rand=new Random();
        
        System.out.println("\n-------The activities done along the day (ACTUAL DATA)-------");
        System.out.println("Slot 1 = "+slot1.get(id-1));
        System.out.println("Slot 2 = "+slot2.get(id-1));
        System.out.println("Slot 3 = "+slot3.get(id-1));
        System.out.println("Slot 4 = "+slot4.get(id-1));
        System.out.println("Slot 5 = "+slot5.get(id-1));
        System.out.println("Slot 6 = "+slot6.get(id-1));
        System.out.println("Slot 7 = "+slot7.get(id-1));
        System.out.println("Slot 8 = "+slot8.get(id-1));
        System.out.println("Slot 9 = "+slot9.get(id-1));
        System.out.println("Slot 10 = "+slot10.get(id-1));
        
        System.out.println("\n-------The activities done along the day (USER DATA)-------");
        
        
        
        
        for (int i = 1; i <= 10; i++) {            
            int remember=rand.nextInt(forget)+1;
//            System.out.println("Forgetness : "+remember);
            
            if(remember>=25){
                String str="-";
                switch(i){
                    case 1:
                        slot1.set(find-1, str);
                        break;
                    case 2:
                        slot2.set(find-1, str);
                        break;
                    case 3:
                        slot3.set(find-1, str);
                        break;
                    case 4:
                        slot4.set(find-1, str);
                        break;
                    case 5:
                        slot5.set(find-1, str);
                        break;
                    case 6:
                        slot6.set(find-1, str);
                        break;
                    case 7:
                        slot7.set(find-1, str);
                        break;
                    case 8:
                        slot8.set(find-1, str);
                        break;
                    case 9:
                        slot9.set(find-1, str);
                        break;
                    case 10:
                        slot10.set(find-1, str);
                        break;
                }
                
            }
            
        }
        int countRemember=0;
        for (int i = 1; i <=10 ; i++) {
            boolean hold=false;
            switch(i){
                    case 1:
                        hold=checkPlace(slot1.get(id-1));
                        if(slot1.get(id-1).equals("Home")){
                            hold=true;
                        }
                        break;
                    case 2:
                        hold=checkPlace(slot2.get(id-1));
                        if(slot2.get(id-1).equals("Home")){
                            hold=true;
                        }
                        break;
                    case 3:
                        hold=checkPlace(slot3.get(id-1));
                        if(slot3.get(id-1).equals("Home")){
                            hold=true;
                        }
                        break;
                    case 4:
                        hold=checkPlace(slot4.get(id-1));
                        if(slot4.get(id-1).equals("Home")){
                            hold=true;
                        }
                        break;
                    case 5:
                        hold=checkPlace(slot5.get(id-1));
                        if(slot5.get(id-1).equals("Home")){
                            hold=true;
                        }
                        break;
                    case 6:
                        hold=checkPlace(slot6.get(id-1));
                        if(slot6.get(id-1).equals("Home")){
                            hold=true;
                        }
                        break;
                    case 7:
                        hold=checkPlace(slot7.get(id-1));
                        if(slot7.get(id-1).equals("Home")){
                            hold=true;
                        }
                        break;
                    case 8:
                        hold=checkPlace(slot8.get(id-1));
                        if(slot8.get(id-1).equals("Home")){
                            hold=true;
                        }
                        break;
                    case 9:
                        hold=checkPlace(slot9.get(id-1));
                        if(slot9.get(id-1).equals("Home")){
                            hold=true;
                        }
                        break;
                    case 10:
                        hold=checkPlace(slot10.get(id-1));
                        if(slot10.get(id-1).equals("Home")){
                            hold=true;
                        }
                        break;
                }
            if(hold==true){
                countRemember=countRemember+1;
            }
        }
        
        double calcForgot=100 - countRemember/10.0*100;
        
        System.out.println("Slot 1 = "+slot1.get(id-1));
        System.out.println("Slot 2 = "+slot2.get(id-1));
        System.out.println("Slot 3 = "+slot3.get(id-1));
        System.out.println("Slot 4 = "+slot4.get(id-1));
        System.out.println("Slot 5 = "+slot5.get(id-1));
        System.out.println("Slot 6 = "+slot6.get(id-1));
        System.out.println("Slot 7 = "+slot7.get(id-1));
        System.out.println("Slot 8 = "+slot8.get(id-1));
        System.out.println("Slot 9 = "+slot9.get(id-1));
        System.out.println("Slot 10 = "+slot10.get(id-1));
        System.out.println();
        System.out.println(calcForgot+" % information FORGOTTEN in DAY "+day);
    }

    
    public static void readActivityLog(int dayCount){
        try{
//            System.out.println("-------Reading the activity Log File-------");
            String file="Activity.log."+Integer.toString(dayCount); 
//            String file="Activity.log.2"; 
//            String file="Activity."+Integer.toString(dayCount)+".log"; 
//            System.out.println("File : " +file);
//            String file="Activity.log.1"; 
           FileInputStream fstream = new FileInputStream(file);
           BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
           String strLine;
           String id[];
           String slot[];
           int lineCount=0;
           /* read log line by line */
           
//            for (int i = 0; i < dayCount; i++) {
                
               while ((strLine = br.readLine()) != null)   {        //reads the first line

               // Reads the first 2 line
    //               strLine = br.readLine();         // Reads the info of the log, datem timem etc
                   strLine = br.readLine();         // Reads the "INFO:" line
                   strLine = br.readLine();         // Reads the Human ID


                   // Adds each of the slot and put it into its respective arrayList

                   slot1.add(br.readLine().split("=")[1]);
                   slot2.add(br.readLine().split("=")[1]);
                   slot3.add(br.readLine().split("=")[1]);
                   slot4.add(br.readLine().split("=")[1]);
                   slot5.add(br.readLine().split("=")[1]);
                   slot6.add(br.readLine().split("=")[1]);
                   slot7.add(br.readLine().split("=")[1]);
                   slot8.add(br.readLine().split("=")[1]);
                   slot9.add(br.readLine().split("=")[1]);
                   slot10.add(br.readLine().split("=")[1]);
                    
            

                    //reads the empty line 
                    strLine = br.readLine();        
                    lineCount++;
               }
               
               
               

//            }
//            System.out.println("Total human count: "+humanCount);
//            System.out.println("Line Count: "+lineCount);
//            System.out.println("Day Count: "+(lineCount/humanCount)+"\n");
           fstream.close();
        } catch (Exception e) {
             System.err.println("Error: " + e.getMessage());
        }
        

        
        
        
    }
    
    public static void readLogOut(String file){
        try{
//           FileInputStream fstream = new FileInputStream("Activity.1.log");
           FileInputStream fstream = new FileInputStream(file);
           BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
           String strLine;
           /* read log line by line */
           while ((strLine = br.readLine()) != null)   {
             /* parse strLine to obtain what you want */
             System.out.println (strLine);
           }
           fstream.close();
        } catch (Exception e) {
             System.err.println("Error: " + e.getMessage());
        }
    }
    
    
    
    
    static boolean firstRun=true;
    public static ArrayList<String> readPlace(String search,int slot,int day){
       ArrayList<String> holdPeople=new ArrayList<>();
        try{
//            System.out.println("test");
//           String file="Place."+Integer.toString(day)+".log";
//            System.out.println("File : "+file);
           String file="Place.log."+Integer.toString(day);
//           readLogOut(file);
//           String file="Place.log.1";
           FileInputStream fstream = new FileInputStream(file);
           BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
           String strLine;
           /* read log line by line */
           String temp[];
           strLine = br.readLine();
           strLine = br.readLine();
           boolean test=false;
           while ((strLine = br.readLine()) != null)   {
             if(strLine.equals(search)){            //reads the places from the log file,ex petrol station
                 for (int i = 0; i < 10; i++) {
                     strLine = br.readLine();
                     temp=br.readLine().split("\\|");
                     if(strLine.equals("Slot "+Integer.toString(slot)+":") || test==true){
                         test=true;
//                         System.out.println(search+",Slot "+ (i+1));
                            
                        //Adds the people to the array to check if they have been listed before 
                         for (int j = 0; j < temp.length; j++) {
                             if(!addedPeople.contains(temp[j])){
                                 holdPeople.add(temp[j]);
//                                 addedPeople.add(temp[j]);
                             }

                         }
                     }
                 } 
                 break;
             }
//             System.out.println (strLine);
           }
           fstream.close();
           return holdPeople;
        } catch (Exception e) {
             System.err.println("Error: " + e.getMessage());
        }
        return null;
    }
        
    
    
  //insert the person according to the slot, ex 10 and day, ex day 2  
    //starts the recursive metod which will add the other people to the similar place a person went
    public static ArrayList<String> startLocation(int id, int slot, int day,ArrayList<String> holdPerson){
        //add from the day the person is infected to the last day of simulation
        if(!addedPeople.contains(Integer.toString(id))){
            addedPeople.add(Integer.toString(id));
        }
        //base case of the recursive method
        //used to store the places in the slot
        ArrayList<String> hold=new ArrayList<>();
        String temp="";
        int setSlot=((day-1)*10+slot)%10;        
        //ex, day 2 slot 3 is 13%10=slot 3
        //run the reading at the max of 1 daysif
        int defDay=day;
        if(slot==11){
            day=day+1;
//            System.out.println("Next day");
        }
        if(defDay!=day){
            return holdPerson;
//            return false;
        } 
      //Get the places the person goes to during the slot and check if its listed in the placesLog, if yes, get all the human id for places log for 7 days
//        System.out.println("test");
        switch(setSlot){
            case 1:
                temp=slot1.get(id-1);
                break;
            case 2:
                temp=slot2.get(id-1);
                break;
            case 3:
                temp=slot3.get(id-1);
                break;
            case 4:
                temp=slot4.get(id-1);
                break;
            case 5:
                temp=slot5.get(id-1);
                break;
            case 6:
                temp=slot6.get(id-1);
                break;
            case 7:
                temp=slot7.get(id-1);
                break;
            case 8:
                temp=slot8.get(id-1);
                break;
            case 9:
                temp=slot9.get(id-1);
                break;
            case 0:
                temp=slot10.get(id-1);
//                day++;
                break;
            
        }

            if(temp.equals("Home")&& firstRun){
                for (int i = 0; i < family.size() ; i++) {
                    holdPerson.add(family.get(i));
                }
                firstRun=false;
            }
            if(checkPlace(temp)){
//                System.out.println("Temp: "+temp);
                hold=readPlace(temp,slot,day);
            }
            //Adds their family members 
//            sameHome();
            for (int i = 0; i < hold.size() && checkPlace(temp); i++) {
                if(!hold.get(i).equals("")&&!holdPerson.contains(hold.get(i))){
                    holdPerson.add(hold.get(i));
                    if(!addedPeople.contains(hold.get(i))){
                        addedPeople.add(hold.get(i));
                    }
                        
//                    System.out.println("Added : "+hold.get(i)+" ,Place :" +temp+" ,Slot "+ slot);
                }
            
            }
//        System.out.println(holdPerson);
//        System.out.println("Slot : "+slot+",day : "+day);
        startLocation(id,slot+1,day,holdPerson);

        return holdPerson;
    }
    
    public static ArrayList sameHome(){
        String sameHouse=houseNum.get(find-1);
//        System.out.println("same house "+sameHouse);
        int index=sameHouse.indexOf(sameHouse);
//        System.out.println("Index : "+index);
        for (int i = 0; i < houseNum.size(); i++) {
            if(sameHouse.equals(houseNum.get(i)) ){
//                System.out.println("Same house : "+(i+1));
                family.add(Integer.toString(i+1));
//                holdPerson.add(Integer.toString(i+1));
                addedPeople.add(Integer.toString(i+1));
            }

        }
            return family;
    }
    
    public static boolean checkPlace(String place){
        ArrayList<String> places=new ArrayList<>();
        places.add("Flat");
        places.add("House A");
        places.add("House B");
        places.add("House C");
        places.add("Playground");
        places.add("Bus Stop");
        places.add("Train Station");
        places.add("Petrol Station");
        places.add("Primary School");
        places.add("Secondary School");
        places.add("Kindergarten");
        places.add("Food Court");
        places.add("Mall");
        places.add("Shop Lot");
        places.add("Field");
        places.add("Police Station");
        places.add("Mosque");
        places.add("Healthcare Centre");
        places.add("Bank");
        places.add("Market");
        places.add("Factory");
//        boolean test=false;
        for (int i = 0; i < places.size(); i++) {
            if(place.equals(places.get(i))){
//                System.out.println("True");
                return true;
            }
            
        }
        return false;
    }
    public static String storeOutput=""; 
    
    
    public static boolean contactTracer(Integer humanID,Integer depth,Integer count, ArrayList prev,int slot, int day){
            if(count>depth){
                return false;
            } 
            prev.add(Integer.toString(humanID));
//            ArrayList<String> a=graph.getAdjacent(Integer.toString(humanID));
            ArrayList<String> a=new ArrayList<>();
            ArrayList<String> holdPerson=new ArrayList<>();
//            System.out.println("Size : "+a.size());
            a=startLocation(humanID, slot, day,holdPerson);
//            System.out.println("Size : "+a.size());
//             System.out.println("HOLDPERSON"+holdPerson);
            a.remove(humanID);
            //remove the find node from the get adjcent list 
            for (int i = 0; i < prev.size(); i++) {
                for (int j = 0; j < a.size(); j++) {
                    if(a.get(j).equals(prev.get(i))){
                        a.remove(prev.get(i));
                    }
                }
            }
            
            // add tab to the start of the string to show the depth of graph
            String s="";
            for (int j = 0; j < count; j++) {
                s+="\t";
            }
            DecimalFormat df=new DecimalFormat("#.###");
            for (int i = 0; i < a.size(); i++) {
                 System.out.println(s+a.get(i) + "  "+df.format(Math.pow(0.9, count))+"  Day "+day);
//                 storeOutput+=s+a.get(i) + "  "+df.format(Math.pow(0.9, count))+"  Day "+day;
                 // Shows the risk of infecting another person THE FIRST TIME when they visited the same the same place
//                 addedPeople.add(a.get(i));
                 contactTracer(Integer.parseInt(a.get(i)),depth,count+1,prev,slot,day);
               
            }
            
            
            return true;
        
    }
}