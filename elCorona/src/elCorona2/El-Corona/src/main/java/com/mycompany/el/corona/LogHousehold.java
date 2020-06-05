/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.el.corona;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author pavin
 */
public class LogHousehold {
    
    public void logHouseHold(String s){
        
        Logger log = Logger.getLogger("MyLog");
        FileHandler fh;
        
        try{
            fh = new FileHandler("C:\\Users\\pavin\\OneDrive\\Desktop\\DS\\Household.log");
            log.addHandler(fh);
            SimpleFormatter format = new SimpleFormatter();
            fh.setFormatter(format);
            log.info(s);
        }catch(SecurityException | IOException e){
            System.out.println("Error Ocurred");
        }
        
    }
    
}
