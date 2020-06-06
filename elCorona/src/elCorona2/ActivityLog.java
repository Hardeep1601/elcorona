/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elCorona2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author pavin
 */
public class ActivityLog {
    
    private String [] slot = new String [10];
    private String day = "Weekday";
    
    public void activityLog(ArrayList<ArrayList> house){
        
        PlaceLog logp = new PlaceLog();
        logp.initialise();
        
        Logger log = Logger.getLogger("ALog");
        FileHandler fh;
        
        try{
                fh = new FileHandler("C:\\Users\\pavin\\OneDrive\\Desktop\\DS\\Activity.log");
                log.addHandler(fh);
                SimpleFormatter format = new SimpleFormatter();
                fh.setFormatter(format);
                
        for(int i=0;i<(house.size());i++){
            for(int j=0;j<house.get(i).size();j++){
                
                Person p = (Person)house.get(i).get(j);
                Random r = new Random();
                int randnum;
                String work = p.getOccupation();
                
                if(day=="Weekday"){
                    if(p.getOccupation()!="Unemployed" || p.getOccupation()!="Retired"){
                        slot[0]="Home";
                        
                        randnum = r.nextInt(3);
                        switch(randnum){
                            case 0:
                                slot[1]="Home";
                                break;
                            case 1:
                                slot[1]="Food Court";
                                break;
                            case 2:
                                slot[1]="Shop Lot";
                                break;
                        }
                            
                        slot[2]=work;
                        slot[3]=work;
                        
                        randnum = r.nextInt(4);
                        switch(randnum){
                            case 0:
                                slot[4]="Home";
                                break;
                            case 1:
                                slot[4]="Food Court";
                                break;
                            case 2:
                                slot[4]="Shop Lot";
                                break;
                            case 3:
                                slot[4]="Mall";
                                break;
                        }
                        
                        // can be modified
                        slot[5]="Random Place";
                        if(p.getRole()=="Student"){
                            randnum = r.nextInt(4);
                            switch(randnum){
                                case 0:
                                    slot[6]="Home";
                                    slot[7]="Home";
                                    break;
                                case 1:
                                    slot[6]="Field";
                                    slot[7]="Field";
                                    break;
                                case 2:
                                    slot[6]="Playground";
                                    slot[7]="Playground";
                                    break;
                                case 3:
                                    slot[6]="Mall";
                                    slot[7]="Mall";
                                    break;
                            }
                        }else{
                            randnum = r.nextInt(5);
                            switch(randnum){
                                case 0:
                                    slot[6]="Home";
                                    slot[7]="Home";
                                    break;
                                case 1:
                                    slot[6]="Mall";
                                    slot[7]="Mall";
                                    break;
                                case 2:
                                    slot[6]="Playground";
                                    slot[7]="Playground";
                                    break;
                                case 3:
                                    slot[6]="Home";
                                    slot[7]="Train";
                                    break;
                                case 4:
                                    slot[6]="Petrol Station";
                                    slot[7]="Home";
                                    break;
                            }
                        }
                        
                        randnum=r.nextInt(3);
                        switch(randnum){
                            case 0:
                                slot[8]="Home";
                                break;
                            case 1:
                                slot[8]="Shop Lot";
                                break;
                            case 2:
                                slot[8]="Food Court";
                                break;
                        }
                        
                        slot[9]="Home";
                        // work = true
                    }
                // End of weekday 
                }
                
                //log file
                String info="------------------------\n";
                info+="Human id="+p.getId()+"\n";
                int count=1;
                for(int k=0;k<slot.length;k++){
                    info+="Slot "+count+"="+slot[k]+"\n";
                    logp.place(slot[k], k);
                    count++;
                }
                log.info(info);
                
            }
            
        }
        //place
        logp.activatePlaceLog();
        
        }catch(SecurityException | IOException e){
                        System.out.println("Error Ocurred");
                    }
    }
}
