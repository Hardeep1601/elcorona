/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corona;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author koghu
 */
public class DPerson {

    int x, y, cx, cy, p = 0;
    int vx = 0, vy = 0;
    int infection = 0;
    int time = 0;
    String[] place = {"A", "B", "C", "D", "E", "F"};
    String[] cP = new String[10];
//    String[] cP = {"House C", "Bus Stop", "PlayGround", "Train Station"};
    int[] nP = new int[2];
    Random rand = new Random();
    Places pl = new Places();
    String[] list ;
    private int humanId;
    private ArrayList<String[]> actList;
    
    public void setActList(ArrayList<String[]> a){
        cP = a.get(humanId-1);
    }

    public void genPlace() {
        for (int i = 0; i < cP.length; i++) {
            cP[i] = place[rand.nextInt(6)];
             
        }
    }
    
    

    public DPerson(int a) {
        humanId = a;
        Random rand = new Random();
//        genPlace();

 Places p= new Places();
        String q=p.getLocation();
//        String[] = q.split("\\.");


        System.out.println("The current letter is:" + Arrays.toString(cP));
        String s = cP[0];
        if (s.equalsIgnoreCase("Flat")) {
            x = rand.nextInt(230) + 10;
            y = rand.nextInt(130) + 10;
        } else if (s.equalsIgnoreCase("House A")) {
            x = rand.nextInt(150) + 10;
            y = rand.nextInt(120) + 250;
        } else if (s.equalsIgnoreCase("House B")) {
            x = rand.nextInt(180) + 10;
            y = rand.nextInt(160) + 550;
        } else if (s.equalsIgnoreCase("House C")) {
            x = rand.nextInt(160) + 905;
            y = rand.nextInt(110) + 400;

        }

        if (a == 0) {
            cx = x;
            cy = y;
        }

        nextP();
    }

    public void paint(Graphics g) {
        time++;
        
        if (time % 300 == 0) {
            p++;

            if (p == 4) {
                resetP();
            }

//           
            nextP();

        }

        if (cx == nP[0] || cx == nP[0] + 2 || cx == nP[0] - 2) {
            vx = 0;

        } else if (cx > nP[0]) {
            vx = -4;
        } else {
            vx = 4;
        }
        if (cy == nP[1] || cy == nP[1] + 2 || cy == nP[1] - 2) {
            vy = 0;
        } else if (cy > nP[1]) {
            vy = -4;
        } else {
            vy = 4;
        }
        cx += vx;
        cy += vy;

        g.setColor(Color.blue);
        g.fillOval(cx, cy, 10, 10);
       
    }

    public void nextP() {

        if (p > 3) {
            p = -1;
        }

        if (p + 1 <= 3) {

pl.Location(cP[p+1]);
nP[0]=pl.getX();
nP[1]=pl.getY();

        }
    }

    public void resetP() {
        pl.Location(cP[0]);
        nP[0]=pl.getX();
        nP[1]=pl.getY();



    }

}
