public class Process  {
	
	private String processId;
	private int arrivalTime;
	private int burstTime;
	private int waitTime;

	public Process(String processId, int arrivalTime, int burstTime) {
		
		this.processId = processId;
		
		this.arrivalTime = arrivalTime;
		this.burstTime = burstTime;
	}
	
	public String getProcessId() {
		return processId;
	}
	
	public int getArrivalTime() {
		return arrivalTime;
	}
	
	public int getBurstTime() {
		return burstTime;
	}
	
	public int getWaitTime() {
		return waitTime;
	}
	
	public void setWaitTime(int waitTime) {
		this.waitTime = waitTime;
	}
	
	

}
