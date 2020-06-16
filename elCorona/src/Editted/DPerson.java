/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Editted;

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
public class DPerson extends Data {

    int x, y, cx, cy, p = 0;
    int vx = 0, vy = 0;
    int infection = 0;
    int time = 0;
    String[] cP;
    int[] nP = new int[2];
    Random rand = new Random();
    Places pl = new Places();
    String[] list;
    private int humanID;

    public DPerson(int a) {
        Random rand = new Random();

        humanID = a;
        cP = getAct(a);
//        genPlace();

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
        cx = x;
        cy = y;
        p = 0;
        nextP();
    }

    public void paint(Graphics g, int a) {
        time++;

        if (infection == 0) {
            g.setColor(Color.blue);
        } else if (infection == 1) {
            g.setColor(Color.red);
        }
        int set;

        if (a < 3) {
            set = 500;
        } else if (a < 6) {
            set = 200;
        } else {
            set = 80;
        }

        if (time % set == 0) {
            p++;
            nextP();
        }

        if (cx <= nP[0] + 10 && cx >= nP[0] - 10) {
            cx = nP[0];
            vx = 0;

        } else if (cx > nP[0]) {
            vx = -(a);
        } else {
            vx = a;
        }
        if (cy <= nP[1] + 10 && cy >= nP[1] - 10) {
            cy = nP[1];
            vy = 0;
        } else if (cy > nP[1]) {
            vy = -a;
        } else {
            vy = a;
        }
        cx += vx;
        cy += vy;
        g.fillOval(cx, cy, 5, 5);
        if (p + 1 == cP.length && humanID == 1) {

            nextSDay();
            cP = getAct(humanID);
            p = 0;
        }

        if (p + 1 == cP.length) {
            cP = getAct(humanID);
            p = 0;
        }

    }

    public void nextP() {
        Random rand = new Random();

        if (p > cP.length) {
            p = -1;
        }

        if (p + 1 != cP.length) {

            pl.Location(cP[p + 1]);
            nP[0] = pl.getX();
            nP[1] = pl.getY();

        }

    }

    public void infect() {
        infection = 1;
        setInfected(humanID);
    }

}
