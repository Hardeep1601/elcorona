package elCorona2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class graphMain {
    static Graph<String, Integer> graph = new Graph<>();

    public static void main(String[] args) {
        // Example 1
        graphMain m=new graphMain();
        Graph<String, String> location = new Graph<>();
        
        Random rand=new Random();
//        int verticeNum=rand.nextInt(7);
        int verticeNum=100;
        
        
//        ArrayList<Integer> age=new ArrayList<>();
//        for (int i = 0; i < verticeNum; i++) {
            Integer []age=new Integer[verticeNum];
//            age[i]=rand.nextInt(100)+1;
//            System.out.println("Human ID: "+i+" Age: "+ age[i]);
//        }
            
            
        
        
        //CREATE AND ADD THE VERTICES TO THE GRAPH
        String arr[]=new String[verticeNum];
        
        
        // add the places that the person can go
        location.addVertice("home");
        location.addVertice("office");
        location.addVertice("market");
        location.addVertice("tuition");
        location.addVertice("home");
        
        
                
        
        
        for (int i = 0; i < verticeNum; i++) {
            arr[i]=Integer.toString(i);
//            graph.addVertice(arr[i] + "");
//            location.addVertice(arr[i] + "");
        }
//        location.showGraph();



        //GENERATE AND ADD THE RANDOM EDGES/HUMAN CONTACT 
        
        int IDrange=0;          // TO GENERATE BETWEEN A SPECIFIC RANGE OF HUMAN ID'S
        int maxFriend=10;       // The max number of friends a person can have // The max number of friends a person can have
        for (int i = 0; i < verticeNum; i++) {
            int maxFamily=rand.nextInt(12);
            int randNum=rand.nextInt(maxFriend);        //num of friends
            int []num=new int[randNum];
            int check[]=new int[randNum];
            //GENERATE RANDOM NUMBER AND ADD THEM TO EDGE
            
            for (int j = 0; j < randNum; j++) {
                int randEdg=rand.nextInt(verticeNum)+IDrange;
                for (int k = 0; k < j; k++) {
                    int l = check[k];
                    
                }
                while(randEdg==i){  //prevent adding the same number again
                    randEdg=rand.nextInt(verticeNum)+IDrange;
                }
                
                // ADD TO THE OTHER EDGE ALSO 
                    graph.addEge( Integer.toString( i ), Integer.toString( randEdg ));
                // GENERATE NUMBER, STORE IT IN A ARRAY AND CHECK FOR REPEATING NUMBER
                    graph.addEge( Integer.toString( randEdg ), Integer.toString( i ));
                
              }
        }
        
        // To print out the graph of Human ID formed
//        System.out.println("Creating a graph with "+verticeNum+" vertices");
//        graph.showGraph();

        
        
        
        // COntact Tracing 
        // Define the depth and human ID to be searched
        
        int find=99;
        int depth=3;
        
        // Contact tracer is called
//        System.out.println("\nContact tracer");
//        System.out.println("Trace the contact for HumanID "+find+" with depth of "+depth+": ");
//        System.out.println(find + "  "+Math.pow(0.9, 0));  
//        ArrayList<String> prev=new ArrayList<>();
//        m.contactTracer2(graph,find,depth-1,1,prev);
            


        // Reading log file based on human ID
            readLogOut();
            readLog();
            readActivityLog(2);
            findLog(1);
            sameHouse();
    }
    
    static ArrayList<String> houseNum=new ArrayList<>();
    static ArrayList<String> ID=new ArrayList<>();
    static ArrayList<String> age=new ArrayList<>();
    static ArrayList<String> role=new ArrayList<>();
    static ArrayList<String> occ=new ArrayList<>();
    static ArrayList<String> gender=new ArrayList<>();
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
    public static int humanCount=0;

    

    
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
           
           while ((strLine = br.readLine()) != null)   {        //reads the first line
             /* Read house number, ID, age, role, occupation, gender */
//                temp=strLine.split(" ");
//                if(!temp[0].equals("HOUSE")){
//                    strLine = br.readLine();
//                }
                house=strLine.split(" ");
                houseNum.add(house[1]);
//                if(house)
                humanCount++;
                strLine = br.readLine();
                id=strLine.split(" ");
                ID.add(id[1]);
                graph.addVertice(id[1]);
                
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
    
    public static void readActivityLog(int dayCount){
        try{
            System.out.println("-------Reading the activity Log File-------");
           FileInputStream fstream = new FileInputStream("Activity.log");
           BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
           String strLine;
           String id[];
           String slot[];
           int lineCount=0;
           /* read log line by line */
           
            for (int i = 0; i < dayCount; i++) {
                
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
                
            }
            System.out.println("Total human count: "+humanCount);
            System.out.println("Line Count: "+lineCount);
            System.out.println("Day Count: "+(lineCount/humanCount)+"\n");
           fstream.close();
        } catch (Exception e) {
             System.err.println("Error: " + e.getMessage());
        }
    }
    
    public static void readLogOut(){
        try{
           FileInputStream fstream = new FileInputStream("Household.log");
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
     //Contact Tracing Method
    
    //NEED TO INSERT TIME FACTOR 
    
    
    public static void sameHouse(){
        System.out.println("\n-------People of the same family-------");
        for (int i = 0; i < humanCount; i++) {
            for (int j = 0; j !=i; j++) {
                if(houseNum.get(i).equals(houseNum.get(j))){
                    
                // ADD TO THE OTHER EDGE ALSO 
                    graph.addEge( Integer.toString( i+1 ), Integer.toString( j+1 ));
                // GENERATE NUMBER, STORE IT IN A ARRAY AND CHECK FOR REPEATING NUMBER
                    graph.addEge( Integer.toString( j+1 ), Integer.toString( i+1 ));
                    
                }
                
            }
            
        }
        graph.showGraph();
    }
    
    public static void samePlace(){
        
    }
        
    public static boolean startLocation(int slot, int day){
        //base case of the recursive method
        if(day==4){
            System.out.println("End of tracking");  
            return false;
        }
        int setSlot;
        switch(slot){
            case 1:
                
        }
        return true;
    }

    public boolean contactTracer2(Graph graph,Integer humanID,Integer depth,Integer count, ArrayList prev){
            if(count>depth){
                return false;
            } 
            prev.add(Integer.toString(humanID));
            ArrayList<String> a=graph.getAdjacent(Integer.toString(humanID));
            a.remove(humanID);
            
            
            //remove the find node from the get adjcent list 
            for (int i = 0; i < prev.size(); i++) {
                for (int j = 0; j < a.size(); j++) {
                    if(a.get(j).equals(prev.get(i))){
                        a.remove(prev.get(i));
                    }
                }
            }
            
            String s="";
            for (int j = 0; j < count; j++) {
                s+="\t";
            }

            int j=0;
            while(count<=depth && j<a.size() ){
                if(count>depth){
                    return false;
                } 
                DecimalFormat df=new DecimalFormat("#.###");
                System.out.println(s+a.get(j) + "  "+df.format(Math.pow(0.9, count)));
                contactTracer2(graph, Integer.parseInt(a.get(j)),depth,count+1,prev);
                j++;
            }
   
            return true;
        
    }
    
}
