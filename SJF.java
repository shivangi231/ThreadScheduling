import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class SJF
{
public static void main(String[] args) throws NumberFormatException, IOException
{

	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Enter number of processes");
	int n=Integer.parseInt(br.readLine());
	int bt[]=new int[n];// burst time 
	for(int  i=0;i<n;i++)
	{
		System.out.println("Enter burst time for each process: p"+(i+1));
		bt[i]=Integer.parseInt(br.readLine());
	}
	int n1=n;
	int temp;
	float t=0;
	int turn[]=new int[n];
	int[] apw1=new int[n+1];
	apw1[0]=0;
	int[] p=new int[n];
	int sj[]=new int[n];
	float tu=0;

	for( int i=0;i<n;i++)
	{
		sj[i]=bt[i];
	}
for( int i=0;i<n;i++)
{
	for(int j=i+1;j<n;j++)
	{
		if(sj[i]>sj[j])
		{
			temp=sj[i];
			sj[i]=sj[j];
			sj[j]=temp;
		}
	}
}


	for( int i=0;i<n;i++)
	{
		for(int j=0;j<n;j++)
		{
			if(sj[i]==bt[j])
				p[i]=j+1;
		}
	}

	for(int i=0;i<n;i++)
	{
		apw1[i+1]=sj[i]+apw1[i];
	}
	
	for( int i=0;i<n;i++)
	{
		System.out.println("indivisual waiting time for process p"+p[i]+"is"+apw1[i]+" ");
	}

for( int i=0;i<n;i++)
{
	t+=apw1[i];
	float avg=t/n;
	System.out.println("average waiting time is:"+avg);
}
/*for( i=0;i<n;i++)
System.out.println("response for process p"+p[i]+"is"+apw1[i]+" ");*/

for(int i=0;i<n;i++)
{
int k=p[i];
turn[i]=bt[k-1]+apw1[i];
System.out.println("turnaround time for process p"+p[i]+"is"+turn[i]+" ");
}

for( int i=0;i<n;i++)
tu+=turn[i];

float avg1=tu/n;
System.out.println("average turn-around time is:"+avg1);




}
}


