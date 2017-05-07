import java.util.*;
public class FirstComeFirstServe {

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
		
		
		//////////SORT THE LIST OF PROCESSES BY THEIR ARRIVAL TIME. DESCENDING TO ASSCENDING////////////
		
		for(int i = 0;i<processList.size();i++) {
			for(int j = 0;j<processList.size()-1;j++){
				if(processList.get(j).getArrivalTime()>processList.get(j+1).getArrivalTime()) {
					Process temp = processList.get(j);
					processList.set(j, processList.get(j+1));
					processList.set(j+1, temp);
				}
			}
		} 
		

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




