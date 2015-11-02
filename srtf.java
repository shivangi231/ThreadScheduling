import java.util.*;
import java.io.*;

public class srtf
{
	
	public static void main(String []args)
	{
		int[] at=new int[]{0,1,2,3};
		int[] et=new int[]{6,2,8,4};
		int[] lt=new int[at.length];
		int[] wt=new int[at.length];
		int[] rt=new int[at.length];
		int[] tat=new int[at.length];
		int[] c_et=new int[at.length];
		
		
	
		
		int total_exec=0;
		int time=0;
		int current=0;
		
		for(int i=0;i<at.length;i++)
		{
			total_exec+=et[i];
			c_et[i]=et[i];
			rt[i]=-1;
			if(at[i]==0 && et[i]<et[current])
			{
				current=i;
			}
		}
		//System.out.println("current="+total_exec);
		rt[current]=0;
		lt[current]=0;
		time++;
		while(time<total_exec)
		{
			//System.out.println("current="+current+"  time="+time);
			//time++;
			et[current]--;
			
			if(et[current]==0)
			{
				//System.out.println("Over current="+current);
			//	exit[current]=time;
				et[current]=Integer.MAX_VALUE;
			}
			
			for(int j=0;j<at.length;j++)
			{
				if(at[j]<=time && j!=current)
				{
					if(et[j]>0 && et[j]<et[current])
					{
						current=j;
						lt[current]=time;
						if(rt[current]==-1)
						{
							rt[current]=time;
						}
					}
				}
			}
			
			
			time++;
		}	//end of while
		
		int wt_sum=0;
		int tat_sum=0;
		int rt_sum=0;
		
		for(int k=0;k<at.length;k++)
		{
			wt[k]=lt[k]-at[k];
			wt_sum+=wt[k];
			tat[k]=wt[k]+c_et[k];
			tat_sum+=tat[k];
			rt_sum+=rt[k];
		}
		
		System.out.println("Avg TAT="+(tat_sum/at.length));
		System.out.println("Avg Response time="+(rt_sum/at.length));
		System.out.println("Avg Waiting time="+(wt_sum/at.length));
		
		
		
	}
}

	
