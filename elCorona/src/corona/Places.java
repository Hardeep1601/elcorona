/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corona;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author koghu
 */
public class Places {

    int x, y;
    Random rand = new Random();
        String s = "Flat."
                + "House A."
                + "House B."
                + "House C."
                + "Playground."
                + "Bus Stop."
                + "Train Station."
                + "Petrol Station."
                + "Primary School."
                + "Secondary School."
                + "Kindergarten."
                + "Food Court."
                + "Mall."
                + "Shop Lot."
                + "Field."
                + "Police Station."
                + "Mosque."
                + "Healthcare Centre."
                + "Bank."
                + "Market";
       

    public Places() {

    }

    public Places(Graphics g) {
       
//        Graphics g= new Graphics();
//        Graphics g = null;
//        System.out.println("paint");
//    Colour mycolour= (255,12,12);

        int alpha = 127; // 50% transparent
//Color myColour = new Color(51, 153, 255);
        g.setColor(Color.LIGHT_GRAY);
        //1
        g.fillRect(10, 10, 230, 130);
        //2
        g.fillRect(10, 250, 150, 180);
        //3
        g.fillRect(10, 550, 200, 130);
        //4
        g.fillRect(905, 400, 160, 110);
        //5
//      g.fillRect(800, 600, 120, 80);
        g.setColor(Color.ORANGE);
        //Field
        g.fillRect(950, 550, 150, 80);
        //FoodCourt
        g.fillRect(580, 600, 250, 80);
        //Shoplot
        g.fillRect(280, 600, 200, 180);
        //Tadika
        g.fillRect(230, 320, 60, 80);
        //Bus Stop
        g.fillRect(300, 10, 60, 40);
        //Market
        g.fillRect(770, 100, 80, 100);
        //Mosque
        g.fillRect(550, 460, 110, 60);
        //Police Station
        g.fillRect(630, 210, 70, 70);
        //P.Kesihatan
        g.fillRect(270, 210, 110, 80);
        //PetrolStation
//        g.setColor(Color.red);
        g.fillRect(300, 70, 40, 40);
        //Bank
        g.fillRect(490, 600, 40, 40);
        //Train
        g.setColor(Color.cyan);
        g.fillRect(970, 270, 110, 100);

        //Mall
        g.setColor(Color.MAGENTA);
        g.fillRect(900, 0, 300, 200);
        //PlayGround
        g.setColor(Color.GREEN);
        g.fillOval(450, 300, 150, 100);
        //SK
        g.setColor(Color.pink);
        g.fillRect(330, 440, 140, 80);
        //padangSK
        g.fillRect(700, 430, 100, 60);
        //Smk
        g.fillRect(700, 330, 110, 90);
        //Factory
        g.fillRect(470, 0, 200, 110);

    }

    public void Location(String s) {
        if (s.equalsIgnoreCase("Flat")) {
            x = rand.nextInt(230) + 10;
            y = rand.nextInt(130) + 10;

        } else if (s.equalsIgnoreCase("House A")) {
            x = rand.nextInt(150) + 10;
            y = rand.nextInt(180) + 250;
        } else if (s.equalsIgnoreCase("House B")) {
            x = rand.nextInt(180) + 10;
            y = rand.nextInt(120) + 550;
        } else if (s.equalsIgnoreCase("House c")) {
            x = rand.nextInt(160) + 905;
            y = rand.nextInt(110) + 400;

        } else if (s.equalsIgnoreCase("Field")) {
            x = rand.nextInt(145) + 950;
            y = rand.nextInt(170) + 550;

        } else if (s.equalsIgnoreCase("Playground")) {
            x = rand.nextInt(150) + 450;
            y = rand.nextInt(100) + 300;

        } else if (s.equalsIgnoreCase("Bus Stop")) {
            x = rand.nextInt(60) + 300;
            y = rand.nextInt(40) + 10;

        } else if (s.equalsIgnoreCase("Train Station")) {
            x = rand.nextInt(90) + 970;
            y = rand.nextInt(100) + 270;
        } else if (s.equalsIgnoreCase("Petrol Station")) {
            x = rand.nextInt(140) + 300;
            y = rand.nextInt(40) + 70;
        } else if (s.equalsIgnoreCase("Primary School")) {
            x = rand.nextInt(140) + 330;
            y = rand.nextInt(80) + 440;
        } else if (s.equalsIgnoreCase("Secondary School")) {
            x = rand.nextInt(810) + 700;
            y = rand.nextInt(90) + 330;
        } else if (s.equalsIgnoreCase("Mosque")) {
            x = rand.nextInt(110) + 550;
            y = rand.nextInt(60) + 460;
        } else if (s.equalsIgnoreCase("Food Court")) {
            x = rand.nextInt(250) + 580;
            y = rand.nextInt(80) + 600;
        } else if (s.equalsIgnoreCase("Mall")) {
            x = rand.nextInt(300) + 900;
            y = rand.nextInt(200) + 0;
        } else if (s.equalsIgnoreCase("Shop Lot")) {
            x = rand.nextInt(200) + 280;
            y = rand.nextInt(180) + 600;
        } else if (s.equalsIgnoreCase("Police Station")) {
            x = rand.nextInt(70) + 630;
            y = rand.nextInt(280) + 210;
        } else if (s.equalsIgnoreCase("Kindergarten")) {
            x = rand.nextInt(60) + 230;
            y = rand.nextInt(40) + 320;
        } else if (s.equalsIgnoreCase("Food Court")) {
            x = rand.nextInt(250) + 580;
            y = rand.nextInt(80) + 600;
        } else if (s.equalsIgnoreCase("Healthcare Centre")) {
            x = rand.nextInt(110) + 270;
            y = rand.nextInt(80) + 210;
        } else if (s.equalsIgnoreCase("Market")) {
            x = rand.nextInt(130) + 770;
            y = rand.nextInt(100) + 100;
        } else if (s.equalsIgnoreCase("Bank")) {
            x = rand.nextInt(40) + 490;
            y = rand.nextInt(40) + 600;

        }

    }
    
    public String getLocation(){
        return s;
    }

    public int getX() {

        return x;
    }

    public int getY() {

        return y;
    }

}

/*
Flat
House A
House B
House C
Playground
Bus Stop
Train Station
Petrol Station
Primary School
Secondary School
Kindergarten
Food Court
Mall
Shop Lot
Field
Police Station
Mosque
Healthcare Centre
Bank
Market

 */
