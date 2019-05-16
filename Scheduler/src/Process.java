
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Process {
     String id;
     int arrivalTime;
     int burstTime;
     int waitingTime;
     int turnTime;

    public Process(String id, int arrivalTime, int burstTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.waitingTime=0;
        this.turnTime=burstTime;
    }

    void run() {
        System.out.println(id+"running...");
         try {
             Thread.sleep(1000);
         } catch (InterruptedException ex) {
             ex.printStackTrace();
         }
    }
    
}

//https://www.youtube.com/watch?v=GwQ1WZESR48