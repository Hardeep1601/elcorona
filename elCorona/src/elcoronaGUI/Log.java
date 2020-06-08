/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elcoronaGUI;

import elCorona2.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author pavin
 */
public class Log {
    
    public static void main(String[] args) throws IOException {

        Logger logger = Logger.getLogger("MyLog");
        FileHandler fh;

        try {
            LinkedList<String>[] log = new LinkedList[100];
            Random r = new Random();
            
            for (Integer i = 0; i < log.length; i++) {
                log[i] = new LinkedList<>();
                Integer place = r.nextInt(2);
                Integer HumanType = r.nextInt(3);
                Integer HumanEvo = r.nextInt(4);
                Integer gender = r.nextInt(2);
                Integer wocc = r.nextInt(2);
                Integer HouseAreaID = r.nextInt(3);
                Integer time = r.nextInt(4);

                log[i].add("The Human ID : " + i.toString());
                log[i].add("The House ID : " + HouseAreaID);

                if (HumanType == 0) { // for rural
                    //Morning
                    if (HouseAreaID == 0) {
                        if (HumanEvo == 0) { // child
                            log[i].add("Home");
                        }
                        if (HumanEvo == 1) {  // teen
                            log[i].add("Home");
                        }
                        if (HumanEvo == 2) {  //adult
                            if (gender == 0) { // Men
                                log[i].add("Home");
                            }
                            if (gender == 1) { //Women
                                if (wocc == 0) {  //housewife
                                    log[i].add("Home");
                                }
                                if (wocc == 1) { //working lady
                                    log[i].add("Home");
                                }
                            }
                        }
                        if (HumanEvo == 3) {  //elderly
                            log[i].add("Home");
                        }
                    }

                    if (HouseAreaID == 1) {
                        if (HumanEvo == 0) { // child
                            log[i].add("Home");
                        }
                        if (HumanEvo == 1) {  // teen
                            log[i].add("Home");
                        }
                        if (HumanEvo == 2) {  //adult
                            if (gender == 0) { // Men
                                log[i].add("Home");
                            }
                            if (gender == 1) { //Women
                                if (wocc == 0) {  //housewife
                                    log[i].add("Home");
                                }
                                if (wocc == 1) { //working lady
                                    log[i].add("Home");
                                }
                            }
                        }
                        if (HumanEvo == 3) {  //elderly
                            log[i].add("Home");
                        }
                    }
                    if (HouseAreaID == 2) {
                        if (HumanEvo == 0) { // child
                            log[i].add("Home");
                        }
                        if (HumanEvo == 1) {  // teen
                            log[i].add("Home");
                        }
                        if (HumanEvo == 2) {  //adult
                            if (gender == 0) { // Men
                                log[i].add("Home");
                            }
                            if (gender == 1) { //Women
                                if (wocc == 0) {  //housewife
                                    log[i].add("Home");
                                }
                                if (wocc == 1) { //working lady
                                    log[i].add("Home");
                                }
                            }
                        }
                        if (HumanEvo == 3) {  //elderly
                            log[i].add("Home");
                        }
                    }
                    //Afternoon
                    if (HouseAreaID == 0) {
                        if (HumanEvo == 0) { // child
                            log[i].add("Home");
                        }
                        if (HumanEvo == 1) {  // teen
                            log[i].add("Home");
                        }
                        if (HumanEvo == 2) {  //adult
                            if (gender == 0) { // Men
                                log[i].add("Home");
                            }
                            if (gender == 1) { //Women
                                if (wocc == 0) {  //housewife
                                    log[i].add("Home");
                                }
                                if (wocc == 1) { //working lady
                                    log[i].add("Home");
                                }
                            }
                        }
                        if (HumanEvo == 3) {  //elderly
                            log[i].add("Home");
                        }
                    }
                    if (HouseAreaID == 1) {
                        if (HumanEvo == 0) { // child
                            log[i].add("Home");
                        }
                        if (HumanEvo == 1) {  // teen
                            log[i].add("Home");
                        }
                        if (HumanEvo == 2) {  //adult
                            if (gender == 0) { // Men
                                log[i].add("Home");
                            }
                            if (gender == 1) { //Women
                                if (wocc == 0) {  //housewife
                                    log[i].add("Home");
                                }
                                if (wocc == 1) { //working lady
                                    log[i].add("Home");
                                }
                            }
                        }
                        if (HumanEvo == 3) {  //elderly
                            log[i].add("Home");
                        }
                    }
                    if (HouseAreaID == 2) {
                        if (HumanEvo == 0) { // child
                            log[i].add("Home");
                        }
                        if (HumanEvo == 1) {  // teen
                            log[i].add("Home");
                        }
                        if (HumanEvo == 2) {  //adult
                            if (gender == 0) { // Men
                                log[i].add("Home");
                            }
                            if (gender == 1) { //Women
                                if (wocc == 0) {  //housewife
                                    log[i].add("Home");
                                }
                                if (wocc == 1) { //working lady
                                    log[i].add("Home");
                                }
                            }
                        }
                        if (HumanEvo == 3) {  //elderly
                            log[i].add("Home");
                        }
                    }
                    //Evening
                    if (HouseAreaID == 0) {
                        if (HumanEvo == 0) { // child
                            log[i].add("Home");
                        }
                        if (HumanEvo == 1) {  // teen
                            log[i].add("Home");
                        }
                        if (HumanEvo == 2) {  //adult
                            if (gender == 0) { // Men
                                log[i].add("Home");
                            }
                            if (gender == 1) { //Women
                                if (wocc == 0) {  //housewife
                                    log[i].add("Home");
                                }
                                if (wocc == 1) { //working lady
                                    log[i].add("Home");
                                }
                            }
                        }
                        if (HumanEvo == 3) {  //elderly
                            log[i].add("Home");
                        }
                    }
                    if (HouseAreaID == 1) {
                        if (HumanEvo == 0) { // child
                            log[i].add("Home");
                        }
                        if (HumanEvo == 1) {  // teen
                            log[i].add("Home");
                        }
                        if (HumanEvo == 2) {  //adult
                            if (gender == 0) { // Men
                                log[i].add("Home");
                            }
                            if (gender == 1) { //Women
                                if (wocc == 0) {  //housewife
                                    log[i].add("Home");
                                }
                                if (wocc == 1) { //working lady
                                    log[i].add("Home");
                                }
                            }
                        }
                        if (HumanEvo == 3) {  //elderly
                            log[i].add("Home");
                        }
                    }
                    if (HouseAreaID == 2) {
                        if (HumanEvo == 0) { // child
                            log[i].add("Home");
                        }
                        if (HumanEvo == 1) {  // teen
                            log[i].add("Home");
                        }
                        if (HumanEvo == 2) {  //adult
                            if (gender == 0) { // Men
                                log[i].add("Home");
                            }
                            if (gender == 1) { //Women
                                if (wocc == 0) {  //housewife
                                    log[i].add("Home");
                                }
                                if (wocc == 1) { //working lady
                                    log[i].add("Home");
                                }
                            }
                        }
                        if (HumanEvo == 3) {  //elderly
                            log[i].add("Home");
                        }
                    }
                    //Night
                    if (HouseAreaID == 0) {
                        if (HumanEvo == 0) { // child
                            log[i].add("Home");
                        }
                        if (HumanEvo == 1) {  // teen
                            log[i].add("Home");
                        }
                        if (HumanEvo == 2) {  //adult
                            if (gender == 0) { // Men
                                log[i].add("Home");
                            }
                            if (gender == 1) { //Women
                                if (wocc == 0) {  //housewife
                                    log[i].add("Home");
                                }
                                if (wocc == 1) { //working lady
                                    log[i].add("Home");
                                }
                            }
                        }
                        if (HumanEvo == 3) {  //elderly
                            log[i].add("Home");
                        }
                    }
                    if (HouseAreaID == 1) {
                        if (HumanEvo == 0) { // child
                            log[i].add("Home");
                        }
                        if (HumanEvo == 1) {  // teen
                            log[i].add("Home");
                        }
                        if (HumanEvo == 2) {  //adult
                            if (gender == 0) { // Men
                                log[i].add("Home");
                            }
                            if (gender == 1) { //Women
                                if (wocc == 0) {  //housewife
                                    log[i].add("Home");
                                }
                                if (wocc == 1) { //working lady
                                    log[i].add("Home");
                                }
                            }
                        }
                        if (HumanEvo == 3) {  //elderly
                            log[i].add("Home");
                        }
                    }
                    if (HouseAreaID == 2) {
                        if (HumanEvo == 0) { // child
                            log[i].add("Home");
                        }
                        if (HumanEvo == 1) {  // teen
                            log[i].add("Home");
                        }
                        if (HumanEvo == 2) {  //adult
                            if (gender == 0) { // Men
                                log[i].add("Home");
                            }
                            if (gender == 1) { //Women
                                if (wocc == 0) {  //housewife
                                    log[i].add("Home");
                                }
                                if (wocc == 1) { //working lady
                                    log[i].add("Home");
                                }
                            }
                        }
                        if (HumanEvo == 3) {  //elderly
                            log[i].add("Home");
                        }
                    }

                }

                if (HumanType == 1) { // from train to rural
                    //Morning
			//time = 0 is morning arriving train
                    if (time == 0) {
                        if (HouseAreaID == 0) {
                          
                            if (HumanEvo == 1) {  //teen
                                log[i].add("Train");
                            }
                            if (HumanEvo == 2) {  ///adult
                                log[i].add("Train");
                            }
                            if (HumanEvo == 3) { //elderly
                                log[i].add("Train");
                            }
                        }
                        if (HouseAreaID == 1) {
                       
                            if (HumanEvo == 1) {  //teen
                                log[i].add("Train");
                            }
                            if (HumanEvo == 2) {  ///adult
                                log[i].add("Train");
                            }
                            if (HumanEvo == 3) { //elderly
                                log[i].add("Train");
                            }
                        }
                        if (HouseAreaID == 2) {
                          
                            if (HumanEvo == 1) {  //teen
                                log[i].add("Train");
                            }
                            if (HumanEvo == 2) {  ///adult
                                log[i].add("Train");
                            }
                            if (HumanEvo == 3) { //elderly
                                log[i].add("Train");
                            }
                        }
                    }
                    //Afternoon
                    if (time == 1) {
                        if (HouseAreaID == 0) {
                         
                            if (HumanEvo == 1) {  //teen
                                log[i].add("Train");
                            }
                            if (HumanEvo == 2) {  ///adult
                                log[i].add("Train");
                            }
                            if (HumanEvo == 3) { //elderly
                                log[i].add("Train");
                            }
                        }
                        if (HouseAreaID == 1) {
                            
                            if (HumanEvo == 1) {  //teen
                                log[i].add("Train");
                            }
                            if (HumanEvo == 2) {  ///adult
                                log[i].add("Train");
                            }
                            if (HumanEvo == 3) { //elderly
                                log[i].add("Train");
                            }
                        }
                        if (HouseAreaID == 2) {
                           
                            if (HumanEvo == 1) {  //teen
                                log[i].add("Train");
                            }
                            if (HumanEvo == 2) {  ///adult
                                log[i].add("Train");
                            }
                            if (HumanEvo == 3) { //elderly
                                log[i].add("Train");
                            }
                        }
                    }
                    //Evening
                    if (time == 2) {
                        if (HouseAreaID == 0) {
                        
                            if (HumanEvo == 1) {  //teen
                                log[i].add("Train");
                            }
                            if (HumanEvo == 2) {  ///adult
                                log[i].add("Train");
                            }
                            if (HumanEvo == 3) { //elderly
                                log[i].add("Train");
                            }
                        }
                        if (HouseAreaID == 1) {
                           
                            if (HumanEvo == 1) {  //teen
                                log[i].add("Train");
                            }
                            if (HumanEvo == 2) {  ///adult
                                log[i].add("Train");
                            }
                            if (HumanEvo == 3) { //elderly
                                log[i].add("Train");
                            }
                        }
                        if (HouseAreaID == 2) {
                          
                            if (HumanEvo == 1) {  //teen
                                log[i].add("Train");
                            }
                            if (HumanEvo == 2) {  ///adult
                                log[i].add("Train");
                            }
                            if (HumanEvo == 3) { //elderly
                                log[i].add("Train");
                            }
                        }
                    }
                    //Night
                    if (time == 3) {
                        if (HouseAreaID == 0) {
                           
                            if (HumanEvo == 1) {  //teen
                                log[i].add("Train");
                            }
                            if (HumanEvo == 2) {  ///adult
                                log[i].add("Train");
                            }
                            if (HumanEvo == 3) { //elderly
                                log[i].add("Train");
                            }
                        }
                        if (HouseAreaID == 1) {
                           
                            if (HumanEvo == 1) {  //teen
                                log[i].add("Train");
                            }
                            if (HumanEvo == 2) {  ///adult
                                log[i].add("Train");
                            }
                            if (HumanEvo == 3) { //elderly
                                log[i].add("Train");
                            }
                        }
                        if (HouseAreaID == 2) {
                           
                            if (HumanEvo == 1) {  //teen
                                log[i].add("Train");
                            }
                            if (HumanEvo == 2) {  ///adult
                                log[i].add("Train");
                            }
                            if (HumanEvo == 3) { //elderly
                                log[i].add("Train");
                            }
                        }
                    }
                }

                if (HumanType == 2) { // from rural to train
                    //Morning
                    if (HouseAreaID == 0) {
                        if (HumanEvo == 0) { // child
                            log[i].add("Home");
                        }
                        if (HumanEvo == 1) {  // teen
                            log[i].add("Home");
                        }
                        if (HumanEvo == 2) {  //adult
                            if (gender == 0) { // Men
                                log[i].add("Home");
                            }
                            if (gender == 1) { //Women
                                if (wocc == 0) {  //housewife
                                    log[i].add("Home");
                                }
                                if (wocc == 1) { //working lady
                                    log[i].add("Home");
                                }
                            }
                        }
                        if (HumanEvo == 3) {  //elderly
                            log[i].add("Home");
                        }
                    }
                    if (HouseAreaID == 1) {
                        if (HumanEvo == 0) { // child
                            log[i].add("Home");
                        }
                        if (HumanEvo == 1) {  // teen
                            log[i].add("Home");
                        }
                        if (HumanEvo == 2) {  //adult
                            if (gender == 0) { // Men
                                log[i].add("Home");
                            }
                            if (gender == 1) { //Women
                                if (wocc == 0) {  //housewife
                                    log[i].add("Home");
                                }
                                if (wocc == 1) { //working lady
                                    log[i].add("Home");
                                }
                            }
                        }
                        if (HumanEvo == 3) {  //elderly
                            log[i].add("Home");
                        }
                    }
                    if (HouseAreaID == 2) {
                        if (HumanEvo == 0) { // child
                            log[i].add("Home");
                        }
                        if (HumanEvo == 1) {  // teen
                            log[i].add("Home");
                        }
                        if (HumanEvo == 2) {  //adult
                            if (gender == 0) { // Men
                                log[i].add("Home");
                            }
                            if (gender == 1) { //Women
                                if (wocc == 0) {  //housewife
                                    log[i].add("Home");
                                }
                                if (wocc == 1) { //working lady
                                    log[i].add("Home");
                                }
                            }
                        }
                        if (HumanEvo == 3) {  //elderly
                            log[i].add("Home");
                        }
                    }
                    //Afternoon
                    if (HouseAreaID == 0) {
                        if (HumanEvo == 0) { // child
                            log[i].add("Home");
                        }
                        if (HumanEvo == 1) {  // teen
                            log[i].add("Home");
                        }
                        if (HumanEvo == 2) {  //adult
                            if (gender == 0) { // Men
                                log[i].add("Home");
                            }
                            if (gender == 1) { //Women
                                if (wocc == 0) {  //housewife
                                    log[i].add("Home");
                                }
                                if (wocc == 1) { //working lady
                                    log[i].add("Home");
                                }
                            }
                        }
                        if (HumanEvo == 3) {  //elderly
                            log[i].add("Home");
                        }
                    }
                    if (HouseAreaID == 1) {
                        if (HumanEvo == 0) { // child
                            log[i].add("Home");
                        }
                        if (HumanEvo == 1) {  // teen
                            log[i].add("Home");
                        }
                        if (HumanEvo == 2) {  //adult
                            if (gender == 0) { // Men
                                log[i].add("Home");
                            }
                            if (gender == 1) { //Women
                                if (wocc == 0) {  //housewife
                                    log[i].add("Home");
                                }
                                if (wocc == 1) { //working lady
                                    log[i].add("Home");
                                }
                            }
                        }
                        if (HumanEvo == 3) {  //elderly
                            log[i].add("Home");
                        }
                    }

                    if (HouseAreaID == 2) {
                        if (HumanEvo == 0) { // child
                            log[i].add("Home");
                        }
                        if (HumanEvo == 1) {  // teen
                            log[i].add("Home");
                        }
                        if (HumanEvo == 2) {  //adult
                            if (gender == 0) { // Men
                                log[i].add("Home");
                            }
                            if (gender == 1) { //Women
                                if (wocc == 0) {  //housewife
                                    log[i].add("Home");
                                }
                                if (wocc == 1) { //working lady
                                    log[i].add("Home");
                                }
                            }
                        }
                        if (HumanEvo == 3) {  //elderly
                            log[i].add("Home");
                        }
                    }
                    //Evening
                    if (HouseAreaID == 0) {
                        if (HumanEvo == 0) { // child
                            log[i].add("Home");
                        }
                        if (HumanEvo == 1) {  // teen
                            log[i].add("Home");
                        }
                        if (HumanEvo == 2) {  //adult
                            if (gender == 0) { // Men
                                log[i].add("Home");
                            }
                            if (gender == 1) { //Women
                                if (wocc == 0) {  //housewife
                                    log[i].add("Home");
                                }
                                if (wocc == 1) { //working lady
                                    log[i].add("Home");
                                }
                            }
                        }
                        if (HumanEvo == 3) {  //elderly
                            log[i].add("Home");
                        }
                    }
                    if (HouseAreaID == 1) {
                        if (HumanEvo == 0) { // child
                            log[i].add("Home");
                        }
                        if (HumanEvo == 1) {  // teen
                            log[i].add("Home");
                        }
                        if (HumanEvo == 2) {  //adult
                            if (gender == 0) { // Men
                                log[i].add("Home");
                            }
                            if (gender == 1) { //Women
                                if (wocc == 0) {  //housewife
                                    log[i].add("Home");
                                }
                                if (wocc == 1) { //working lady
                                    log[i].add("Home");
                                }
                            }
                        }
                        if (HumanEvo == 3) {  //elderly
                            log[i].add("Home");
                        }
                    }
                    if (HouseAreaID == 2) {
                        if (HumanEvo == 0) { // child
                            log[i].add("Home");
                        }
                        if (HumanEvo == 1) {  // teen
                            log[i].add("Home");
                        }
                        if (HumanEvo == 2) {  //adult
                            if (gender == 0) { // Men
                                log[i].add("Home");
                            }
                            if (gender == 1) { //Women
                                if (wocc == 0) {  //housewife
                                    log[i].add("Home");
                                }
                                if (wocc == 1) { //working lady
                                    log[i].add("Home");
                                }
                            }
                        }
                        if (HumanEvo == 3) {  //elderly
                            log[i].add("Home");
                        }
                    }
                    //Night
                    if (HouseAreaID == 0) {
                        if (HumanEvo == 0) { // child
                            log[i].add("Home");
                        }
                        if (HumanEvo == 1) {  // teen
                            log[i].add("Home");
                        }
                        if (HumanEvo == 2) {  //adult
                            if (gender == 0) { // Men
                                log[i].add("Home");
                            }
                            if (gender == 1) { //Women
                                if (wocc == 0) {  //housewife
                                    log[i].add("Home");
                                }
                                if (wocc == 1) { //working lady
                                    log[i].add("Home");
                                }
                            }
                        }
                        if (HumanEvo == 3) {  //elderly
                            log[i].add("Home");
                        }
                    }
                    if (HouseAreaID == 1) {
                        if (HumanEvo == 0) { // child
                            log[i].add("Home");
                        }
                        if (HumanEvo == 1) {  // teen
                            log[i].add("Home");
                        }
                        if (HumanEvo == 2) {  //adult
                            if (gender == 0) { // Men
                                log[i].add("Home");
                            }
                            if (gender == 1) { //Women
                                if (wocc == 0) {  //housewife
                                    log[i].add("Home");
                                }
                                if (wocc == 1) { //working lady
                                    log[i].add("Home");
                                }
                            }
                        }
                        if (HumanEvo == 3) {  //elderly
                            log[i].add("Home");
                        }
                    }
                    if (HouseAreaID == 2) {
                        if (HumanEvo == 0) { // child
                            log[i].add("Home");
                        }
                        if (HumanEvo == 1) {  // teen
                            log[i].add("Home");
                        }
                        if (HumanEvo == 2) {  //adult
                            if (gender == 0) { // Men
                                log[i].add("Home");
                            }
                            if (gender == 1) { //Women
                                if (wocc == 0) {  //housewife
                                    log[i].add("Home");
                                }
                                if (wocc == 1) { //working lady
                                    log[i].add("Home");
                                }
                            }
                        }
                        if (HumanEvo == 3) {  //elderly
                            log[i].add("Home");
                        }
                    }
                }

            }
            

            // This block configure the logger with handler and formatter  
            fh = new FileHandler("HumanActivity.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            // the following statement is used to log any messages
            for (LinkedList<String> log1 : log) {
                logger.info(log1.toString());
            }

        } catch (SecurityException | IOException e) {
        }

    }
}
