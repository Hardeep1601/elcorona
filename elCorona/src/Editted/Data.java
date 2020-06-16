/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Editted;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;

/**
 *
 * @author pavin
 */
public class Data {

    static int pop;
    static int sday = 1;
    static Household h = new Household();
    static LogHousehold logh = new LogHousehold();
    static ActivityLog loga = new ActivityLog();
    static ArrayList<String[]> l = new ArrayList<>();
    static ArrayList<Integer> inf = new ArrayList();
    static int day = 0;
    static String sDay;
  

    public static void main(String[] args) {
        Home m= new Home();
        h.generate(m.input());
//h.generate(10);
        
        logh.logHouseHold(h.showAll());
        setDay();
        int count = 0;
        int days = 7;
        loga.activityLog(h.getHouse());
        loga.setDay("Weekday");
        l = loga.getList();
        pop = h.getTotalPopulation();
        F21 f = new F21(pop);

    }

    public Data() {

    }

    public int getP() {
        return pop;
    }

    public String[] getAct(int a) {
        return l.get(a - 1);

    }

    public void nextSDay() {
        sday++;
        setDay();
        loga.activityLog(h.getHouse());
        loga.setDay("Weekday");
    }

    public int getSDay() {
        return sday;
    }

    public void setInfected(int a) {
        inf.add(a);

    }

    public String getInfected() {
        String s = "List of Infected Person: \n\n";
        for (int i = 0; i < inf.size(); i++) {
            s += "Human ID: " + Integer.toString(inf.get(i)) + "\n";
        }
        return s;
    }
    
    public void showInfo(int a){
        h.showId(a);
    }
    

    public static void setDay() {
        day++;
        if (day == 8) {
            day = 1;
        }
        switch (day) {
            case 1:
                sDay = "Monday";
                break;
            case 2:
                sDay = "Tuesday";
                break;
            case 3:
                sDay = "Wednesday";
                break;
            case 4:
                sDay = "Thursday";
                break;
            case 5:
                sDay = "Friday";
                break;
            case 6:
                sDay = "Saturday";
                break;
            case 7:
                sDay = "Sunday";
                break;

        }

        if (day < 6) {
            loga.setDay("Weekday");
        } else {
            loga.setDay("Weekend");
        }
    }

    public String getDay() {
        return sDay;
    }


}
