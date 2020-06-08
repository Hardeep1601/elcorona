/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elcoronaGUI;

import elCorona2.*;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author pavin
 */
public class PlaceLog {
    
    private String [] slot = new String[10];
    
    Logger log = Logger.getLogger("PLog");
    FileHandler fh;
    
    public void initialise(){
        for(int i=0;i<slot.length;i++){
            slot[i]="";
        }
    }
    
    public void place(String data,int index){
        switch(data){
            case "Police":
                slot[index]+="Police Station\n";
                break;
            case "Bank Officer":
                slot[index]+="Bank\n";
                break;
            case "Health Instructor":
                slot[index]+="Healthcare Centre\n";
                break;
            case "Bus Driver":
                slot[index]+="Bus Stop\n";
                break;
            case "Railway Worker":
                slot[index]+="Train Station\n";
                break;
            case "Mall Worker":
                slot[index]+="Mall\n";
                break;
            case "School Janitor":
                slot[index]+="School\n";
                break;
            case "Teacher":
                slot[index]+="School\n";
                break;
            case "Taxi Driver":
                slot[index]+="Bus Stop\n";
                break;
            case "Priest":
                slot[index]+="Mosque\n";
                break;
            case "Restaurant Worker":
                slot[index]+="Food Court\n";
                break;
            case "Outstation":
                slot[index]+="Train Station\n";
                break;
            case "Petrol Station Worker":
                slot[index]+="Petrol Station\n";
                break;
            default:
                slot[index]+=data+"\n";
                break;
        }
    }
    
    public void activatePlaceLog(){
        try{
            fh = new FileHandler("Place.log");
            log.addHandler(fh);
            SimpleFormatter format = new SimpleFormatter();
            fh.setFormatter(format);
            String info="-------------------\n";
            int count=1;
            for(int i=0;i<slot.length;i++){
                info+="Slot "+count+": \n"+slot[i];
                count++;
            }
            log.info(info);
        }catch(SecurityException | IOException e){
            System.out.println("Error Ocurred");
        }
    }
    
}
