/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corona;

/**
 *
 * @author pavin
 */
public class Test {

    
    public static void main(String[] args) {
        
        Household h = new Household();
        LogHousehold logh = new LogHousehold();
        ActivityLog loga = new ActivityLog();
        h.generate(100);
        logh.logHouseHold(h.showAll());
        
        int count=0;
        int days=7; // how many days you want
        for(int i=0;i<days;i++){
            count++;
            if(count==6 || count==7){
                loga.setDay("Weekend");
            }
            loga.activityLog(h.getHouse());
            if(count==7){
                loga.setDay("Weekday");
            }
        }
        //System.out.println(h.showAll());
        //h.showId(4);
        
    }
    
}
