import java.util.*;
import java.io.*;

public class RR
{
	public static void main(String []args)
	{
		//Assumption: All the processes arrive at the same time
		int quantum=4;
		double cs_time=0.2;
		int[] et=new int[]{4,5,6,7};
		int time=0;
		Queue<Integer> q=new LinkedList<Integer>();
		double[] rt=new double[et.length];
		double[] wt=new double[et.length];
		double[] tat=new double[et.length];
		int[]e=new int[et.length];
		double tat_sum=0;
		double rt_sum=0;
		double wt_sum=0;
		
		int curr;
		rt[0]=0;
		q.add(0);
		wt[0]=0;
		e[0]=et[0];
		for(int i=1;i<et.length;i++)
		{
			e[i]=et[i];
			wt[i]=0;
			rt[i]=rt[i-1]+quantum + cs_time;
			q.add(i);
		}
		
		while(!q.isEmpty())
		{
			time++;
			curr=q.peek();
			//System.out.println("curr-"+curr);
			et[curr]--;
		
			if(et[curr]==0)
			{
				q.remove();
			}
			else if(time%quantum==0)
			{
				q.remove();
				q.add(curr);
			}
			
			for(int j=0;j<et.length;j++)
			{
				if(j!=curr && et[j]!=0)
				{
					wt[j]+=1;
					if(time%quantum==0)
					{
						wt[j]+=cs_time;
					}
				}
			}
		}
		
			
		for(int k=0;k<et.length;k++)
		{
			tat[k]=wt[k]+e[k];
			tat_sum+=tat[k];
			rt_sum+=rt[k];
			wt_sum+=wt[k];
		}
		
		System.out.println("Avg TAT="+(tat_sum/et.length));
		System.out.println("Avg Response time="+(rt_sum/et.length));
		System.out.println("Avg Waiting time="+(wt_sum/et.length));
		
	}
}