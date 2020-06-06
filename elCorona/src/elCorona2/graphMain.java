package elCorona2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class graphMain {

    public static void main(String[] args) {
        // Example 1
        graphMain m=new graphMain();
        Graph<String, Integer> graph = new Graph<>();
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
            graph.addVertice(arr[i] + "");
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
        System.out.println("Creating a graph with "+verticeNum+" vertices");
        graph.showGraph();

        
        
        
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
            


        // Calling log file 
            readLog();
            findLog(15);
    }
    
    
    //Contact Tracing Method
    
    //NEED TO INSERT TIME FACTOR 

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
    

    static ArrayList<String> houseNum=new ArrayList<>();
    static ArrayList<String> ID=new ArrayList<>();
    static ArrayList<String> age=new ArrayList<>();
    static ArrayList<String> role=new ArrayList<>();
    static ArrayList<String> occ=new ArrayList<>();
    static ArrayList<String> gender=new ArrayList<>();

    
    public static void findLog(int id){
        System.out.println("Human ID : "+ID.get(id-1));
        System.out.println("House : "+houseNum.get(id-1));
        System.out.println("Age: "+age.get(id-1));
        System.out.println("Role: "+role.get(id-1));
        System.out.println("Occupation: "+occ.get(id-1));
        System.out.println("Gender: "+gender.get(id-1));
        
    }

    
    public static void readLog(){
        try{
           FileInputStream fstream = new FileInputStream("Household.log");
           BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
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
                
                strLine = br.readLine();
                id=strLine.split(" ");
                ID.add(id[1]);
                
                strLine = br.readLine();
                Age=strLine.split(" ");
                age.add(Age[1]);
                
                strLine = br.readLine();
                Role=strLine.split(" ");
                role.add(Role[1]);
                
                strLine = br.readLine();
                Occ=strLine.split(" ");
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
    
}
