
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class RoundRobin {
    
    
    public static void main(String ar[]){
        ArrayList<Process> processList=new ArrayList<>();
        ArrayList<Process> finished=new ArrayList<>();
        Scheduler scheduler;
    
    
        Scanner input=new Scanner(System.in);
        System.out.println("Enter quantum time:");
        int quantum=input.nextInt();
        System.out.println("Enter number of processes:");
        int proNum=input.nextInt();
        
        String pID;
        int Atime,Btime;
        for(int n=1;n<=proNum;n++){
            pID="p"+Integer.toString(n);
            System.out.println("process "+pID);
            System.out.println("Enter arrival time of first process:");
            Atime=input.nextInt();
            System.out.println("Enter burst time of first process:");
            Btime=input.nextInt();
            processList.add(new Process(pID,Atime,Btime));
            
            
        }
        scheduler=new Scheduler(processList,quantum);
        scheduler.printProcessList();
        finished=scheduler.runProcesses();
        scheduler.calcAvgWaiting(finished, proNum);
        scheduler.calcAvgTurn(finished,proNum);
    }
        
}
