/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.el.corona;

/**
 *
 * @author pavin
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Household h = new Household();
        LogHousehold logh = new LogHousehold();
        ActivityLog loga = new ActivityLog();
        h.generate(5);
        logh.logHouseHold(h.showAll());
        loga.activityLog(h.getHouse());
        
        //System.out.println(h.showAll());
        //h.showId(4);
        
    }
    
}
