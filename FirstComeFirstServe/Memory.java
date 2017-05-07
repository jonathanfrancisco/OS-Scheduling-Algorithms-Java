public class Memory  {
	

	private int serviceTime = 0; // also known as executeTime
	private double averageWaitingTime = 0;
	
	
	public void executeProcess(Process process) {
		
		int waitTime;
		
		if(serviceTime - process.getArrivalTime()<0) {
			waitTime  = 0;
		}
		
		else {
			waitTime = serviceTime - process.getArrivalTime();
		}
		
		
		process.setWaitTime(waitTime); // sets the waiting time of the process
		averageWaitingTime += process.getWaitTime(); // adds the the current process's waiting time to the averageWT to be able to calculate the average WT later on...
		serviceTime += process.getBurstTime(); // adds the process's burst time to the service time *note serviceTime/executeTime will be use to calculate the waiting time for each process*
		
	}
	
	public double getAverageWaitingTime() {
		return averageWaitingTime/4;
	}
	
	
	
}
