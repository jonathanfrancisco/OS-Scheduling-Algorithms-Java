import java.util.*;
public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);	
		
		
		ArrayList<Process> processList = new ArrayList<Process>(); 
		Memory memory = new Memory();
		
		/////////////GET ARRIVAL TIME and BURST TIME for each PROCESS /////////////////////
		
		for(int i = 0;i<4;i++) {
			System.out.print("Enter ARRIVAL TIME for P"+i+": ");
			int arrivalTime = input.nextInt();
			System.out.print("Enter BURST TIME for P"+i+": ");
			int burstTime = input.nextInt();
			System.out.println("------------------------------");
			
			Process process = new Process("P"+i, arrivalTime, burstTime);
			processList.add(process);
				
		}

		//////////SORT THE LIST OF PROCESSES BY THEIR BURST TIME. DESCENDING TO ASSCENDING////////////
		
		for(int i = 0;i<processList.size();i++) {
			for(int j = 0;j<processList.size()-1;j++){
				if(processList.get(j).getBurstTime()>processList.get(j+1).getBurstTime()) {
					Process temp = processList.get(j);
					processList.set(j, processList.get(j+1));
					processList.set(j+1, temp);
				}
			}
		} 
		
		
		
		
		//////// FIND THE ONE WHO ARRIVE FIRST and set it first to be executed /////////
		
		int indexOfFirst = 0;
		int currentMin = processList.get(0).getArrivalTime();
		
		for(int i = 1;i<processList.size();i++) {
			
			if(currentMin>processList.get(i).getArrivalTime()) {
				currentMin = processList.get(i).getArrivalTime();
				indexOfFirst = i;
			}
			
		}
		
																																	  // AT
		Process firstExecute  = processList.remove(indexOfFirst); // removes and retrieve the element who arrive first in the ArrayList (ex. 5 0 2 3, retrieve 0 and remove, now we have 5 2 3)
		processList.add(0,firstExecute); // put the the element we previously removed and retrieved as first in the arraylist (ex. 5 2 3, put the 0 as first, now we have 0 5 2 3)
		
		

		///////// Execute a process in the processList  //////
		
		for(int i = 0;i<processList.size();i++) {
			memory.executeProcess(processList.get(i));
		}
		
		
		
		
		/////////////Print the list of processes with their corresponding waitingTime////////////
		System.out.println("ID				arrivalTime			burstTime		waitTime");
		System.out.println("----------------------------------------------");
		
		for(Process i: processList) {
			System.out.println(i.getProcessId()+"				   "+i.getArrivalTime()+"				   "+i.getBurstTime()+"			"+i.getWaitTime());
		}
		
		////////////// PRINT THE AVERAGE WAITING TIME
		System.out.println("Average waiting time is: "+memory.getAverageWaitingTime()+"s"); 
		
		
	}
}




