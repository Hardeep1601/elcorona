/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elCorona2;

import java.util.Random;

/**
 *
 * @author pavin
 */
public class Person {
    
    private int id;
    private int age;
    private String role;
    private String occupation;
    private int forgetfullness;
    private int imunity;
    private String gender;
    
    Random r = new Random();
    
    public void person(){
        int randNum = r.nextInt(4);
        switch(randNum){
            case 0:
                age = r.nextInt(6)+1;
                role = "Toddler";
                occupation = "Kindergarten";
                gender = gender();
                trait();
                break;
            case 1:
                age = r.nextInt(11)+7;
                role = "Student";
                occupation = "School";
                gender = gender();
                trait();
                break;
            case 2:
                age = r.nextInt(23)+18;
                role = "Adult";
                occupation = theirWork();
                gender = gender();
                trait();
                break;
            case 3:
                age = r.nextInt(30)+41;
                role = "Elderly";
                occupation = theirWork();
                gender = gender();
                trait();
                break;
        }
    }
    
    public void setId(int x){
        id = x;
    }
    
    public int getId(){
        return id;
    }
    
    public String getRole(){
        return role;
    }
    
    public String getOccupation(){
        return occupation;
    }
    
    public String gender(){
        int randNum = r.nextInt(2);
        if(randNum==0){
            return "Male";
        }else{
            return "Female";
        }
    }
    
    public void trait(){
        if(role=="Elderly" || role=="Toddler"){
            forgetfullness = r.nextInt(51)+50;
            imunity = r.nextInt(51)+10;
        }else{
            forgetfullness = r.nextInt(100)+1;
            imunity = r.nextInt(71)+20;
        }
    }
    
    public String theirWork(){
        int randnum = r.nextInt(14);
        if(age>=60){
            return "Retired";
        }
        switch(randnum){
            case 0:
                return "Police";
            case 1:
                return "Bank Officer";
            case 2:
                return "Health Instructor";
            case 3:
                return "Bus Driver";
            case 4:
                return "Railway Worker";
            case 5:
                return "Mall Worker";
            case 6:
                return "School Janitor";
            case 7:
                return "Teacher";
            case 8:
                return "Taxi Driver";
            case 9:
                return "Priest";
            case 10:
                return "Restaurant Worker";
            case 11:
                return "Unemployed";
            case 12:
                return "Outstation";
            case 13:
                return "Petrol Station Worker";
        }
        return "";
    }
    
    public String toString(){
        return "ID: "+id+"\nAge: "+age+"\nRole: "+role+"\nOccupation: "+occupation+"\nGender: "+gender;
    }
}
