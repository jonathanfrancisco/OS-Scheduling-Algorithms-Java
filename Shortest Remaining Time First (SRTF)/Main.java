import java.util.*;
public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList<Process> processList = new ArrayList<Process>();
        int totalTime = 0;

        /////////////GET ARRIVAL TIME and BURST TIME for each PROCESS /////////////////////

        for (int i = 0; i < 4; i++) {

            System.out.print("Enter ARRIVAL TIME for P" + i + ": ");
            int arrivalTime = input.nextInt();

            System.out.print("Enter BURST TIME for   P" + i + ": ");
            int burstTime = input.nextInt();

            totalTime += burstTime;

            System.out.println("------------------------------");

            Process process = new Process("P" + i, arrivalTime, burstTime);
            process.originalarrivalTime = arrivalTime;
            process.originalBurstTime  = burstTime;
            processList.add(process);

        }

        int timer; // TICK TOCK TICK TOCK hahahaha orasan ganu

        for(timer = 0;timer < totalTime; timer++) { // START OF TIMER LOOP

            int selectedProcess = 0;
            int min = 12345789;

            for(int i = 0;i<processList.size();i++) {

                Process process = processList.get(i);

                if(!process.isDone) {
                    process.completionTime++;
                }

            }

            for(int j = 0;j <processList.size();j++ ){ // START OF SELECTING A PROCESS LOOP

                Process process = processList.get(j);

                if(process.arrivalTime <= timer) {

                    if(process.burstTime < min && process.burstTime != 0) {
                        min = process.burstTime;
                        selectedProcess = j;
                    }

                }

            } // END OF SELECTING A PROCESS LOOP

            processList.get(selectedProcess).burstTime--;

            for(int i = 0;i< processList.size();i++) { // START OF CALCULATING waitingTime

                Process process = processList.get(i);

                if(process.arrivalTime<=timer) {

                    if(process.burstTime != 0) {

                        if(i != selectedProcess) {
                            process.waitTime++;
                        }

                    }

                    else if (i == selectedProcess) {
                        process.isDone = true;
                    }

                }

            } // END OF CALCULATING waitingTime

        } // END OF TIMER LOOP


        // CALCULATE TURN AROUND TIME FOR EACH PROCESS

        for(int i = 0;i<processList.size();i++) {

            Process process = processList.get(i);
            process.turnAroundTime = process.completionTime - process.originalarrivalTime; // TAT = CT - AT

        }

        System.out.println("PROCESS     arrivalTime     burstTime       cTime       waitTime        turnAroundTime");
        System.out.println("---------------------------------------------------------------------------------------");

        double waitTimeSum = 0;
        double turnAroundTimeSum = 0;

        for(int i = 0;i<processList.size(); i++) {

            Process process = processList.get(i);

            System.out.println(process.processId+"              "
                               +process.originalarrivalTime+"              "
                               +process.originalBurstTime+"              "
                               +process.completionTime+"          "
                               +process.waitTime+"              "+process.turnAroundTime);

            waitTimeSum += process.waitTime;
            turnAroundTimeSum += process.turnAroundTime;

        }

        System.out.println("Average waiting time is: "+waitTimeSum/processList.size());
        System.out.println("Average turn around time is: "+turnAroundTimeSum/processList.size());

    }
}




