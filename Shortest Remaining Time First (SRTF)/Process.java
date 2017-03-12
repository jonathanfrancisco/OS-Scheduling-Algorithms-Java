public class Process  {

    String processId;

    int arrivalTime;
    int originalarrivalTime;


    int burstTime;
    int originalBurstTime;

    int waitTime;

    int completionTime;
    int turnAroundTime;

    boolean isDone = false;

    public Process(String processId, int arrivalTime, int burstTime) {

        this.processId = processId;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }


}
