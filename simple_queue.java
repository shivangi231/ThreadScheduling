package lab1;

import java.util.Scanner;
public static void main(String[] args)
{
	int N;
	double serviceRate, arrivalRate;
	Scanner s = new Scanner(System.in);
	System.out.println("Enter the number of time steps: ");
	N = s.nextInt();
//	System.out.println("Enter the arrival rate: ");
//	arrivalRate = s.nextInt();
	System.out.println("Enter the service rate: ");
	serviceRate = s.nextDouble();
	System.out.println("Enter the balking length: ");
	balkLength = s.nextInt();
	System.out.println("Enter the preemption count: ");
	preemptionCount = s.nextInt();
	
	for(int k = 1 ; k <= 19 ; k ++)
	{
		arrivalRate = (k/20.0)*serviceRate;
		queueLength = new int[N];
		arrivals = new int[N];
		services = new int[N];
		simpleQueue(serviceRate, arrivalRate, N);
		double average = avg();
		System.out.println("Details for arrival rate = " + arrivalRate + " service rate = " + serviceRate + " N = " + N + " are: ");
		System.out.println("Mean Queue Length is: " + average);
		double lambda = arrivalRate/serviceRate;
		System.out.println("lambda is: " + lambda);
		double theoreticalQueueLength = lambda/(1-lambda);
		System.out.println("Theoretical Queue Length is: " + theoreticalQueueLength);
		System.out.println("\n\n");
		System.out.println("Arrivals:");
		for(int i = 0 ; i < N ; i ++)
		{
			System.out.print(arrivals[i] + " ");
		}
		System.out.println("\nServices:");
		for(int i = 0 ; i < N ; i ++)
		{
			System.out.print(services[i] + " ");
		}
		
		System.out.println("\n<---------------------->\n");
	}
}

public class simple_queue {
    int N;
    double q_len_log[];
    double prev_q_len;
    int arrival_time[],depart_time[],last_arrived,last_departed;
    int time;
   
    public simple_queue(int n) {
        // TODO Auto-generated constructor stub
        this.N=n;
        q_len_log=new double[N];
        prev_q_len = 0;
        time=0;
        arrival_time=new int[N];
        depart_time=new int[N];
        last_arrived=0;last_departed=0;
    }
   
    public double mean_len(double arrival_rate,double service_rate){
        int arrive, depart;
        double next_q_len;
        double avg=0;
        for(int i=0;i<N;i++){
            arrive = eprob(arrival_rate);
            time++;
            if(arrive==1) arrival_time[last_arrived++]=time;
            depart = eprob(service_rate);
            if(last_departed<last_arrived) time++;
            if(depart==1 && last_departed<last_arrived) depart_time[last_departed++]=time;
           
            next_q_len = Math.max(0, prev_q_len+arrive-depart);
            q_len_log[i] = next_q_len;
            avg+=next_q_len;
            prev_q_len= next_q_len;
        }
        avg = avg/N;
        return avg;
    }
    public void trackProcess(){
        for(int id=0;id<last_arrived;id++){
            System.out.println("Id "+id+" Arrived at:"+arrival_time[id]);
            System.out.println("Id "+id+" Departed at:"+depart_time[id]);
        }
    }
    public int eprob(double x){
        double t = Math.random();
        if(t<=x)
            return 1;
        else return 0;
    }
}
