
import java.util.ArrayList;

public class Scheduler {
     ArrayList<Process> processes;
     ArrayList<Process> finishedProcesses;
     ArrayList<Event> eventsList;
     int quantum;
     int currentTime;
     int idles;
     Process currentProcess;
     float avgWaitingTime;
     float avgTurnTime;
     //OutputDesign outDes;
     
     
    public Scheduler(ArrayList<Process> processes, int quantum) {
        this.processes = processes;
        this.quantum = quantum;
        //this.outDes=outDes;
    }
public Process getProcess(ArrayList<Process> processes){
    
    for(Process p:processes)
    {
        if(p.arrivalTime<=this.currentTime){
                processes.remove(p);
                return p;
            }
    }
    return null;

}

public void addProcess(ArrayList<Process> processes,Process process){
    processes.add(process);

}
public void increaseTime(ArrayList<Process> processes){
   for(Process p:this.processes){
       if(p.arrivalTime<currentTime){
    p.turnTime+=1;
    p.waitingTime+=1;
   }
   }
}

public void printProcessList(){
    for (Process p : processes){
        System.out.println(p.id);
    }
}
    

public ArrayList<Process> runProcesses()
{
    finishedProcesses=new ArrayList<>();
    eventsList=new ArrayList<>();
    currentTime=0;
    idles=0;
    int startTime;
    int endTime;

    while(!processes.isEmpty()){
        currentProcess=getProcess(processes);
        if(currentProcess==null){
            startTime=currentTime;
            //System.out.println("Idle");
            currentTime+=1;
            endTime=currentTime;
            eventsList.add(new Event("Idle",startTime,endTime));
            
        }
        else{
            
            if(currentProcess.burstTime>quantum){
                startTime=currentTime;
                for(int q=0;q<quantum;q++){
                    //currentProcess.run();
                    currentProcess.burstTime-=1;
                    currentTime+=1;
                    increaseTime(processes);
                }
                endTime=currentTime;
                eventsList.add(new Event(currentProcess.id,startTime,endTime));
                
                addProcess(processes,currentProcess);
                
            }
            else{
                startTime=currentTime;
                for(int b=0;b<currentProcess.burstTime;b++){
                    //currentProcess.run();
                    currentTime+=1;
                    increaseTime(processes);
                }
                endTime=currentTime;
                eventsList.add(new Event(currentProcess.id,startTime,endTime));
                addProcess(finishedProcesses,currentProcess);
                
            }
        }
    
}
    return finishedProcesses;
    
    
}
public ArrayList<Event> getEvents(){
    return eventsList;
}

public float calcAvgWaiting(ArrayList<Process> afterprocesses,int num){
    avgWaitingTime=0;
    for (Process p:finishedProcesses){
        avgWaitingTime+=p.waitingTime;   
    }
    avgWaitingTime=avgWaitingTime/num;
    return avgWaitingTime;
}

public float calcAvgTurn(ArrayList<Process> afterprocesses,int num){
    avgWaitingTime=0;
    for (Process p:finishedProcesses){
        avgTurnTime+=p.turnTime;   
    }
    avgTurnTime=avgTurnTime/num;
    return avgTurnTime;
}
}





















































































