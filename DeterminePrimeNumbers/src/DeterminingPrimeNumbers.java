import java.util.Arrays;


public class DeterminingPrimeNumbers 
{
	public  static void determinePrime(long sp, long ep )
	{
		int count=0;
		int lastCount=0;
		double startTime =0;
		double endTime=0;
		double endTimeAtThousand=0;
		long[] lastFive= new long[5];
		startTime=System.nanoTime();
		System.out.println();
		System.out.println("the last five prime numbers in range of " + sp+"-"+ep+" are: ");
		
		for (long i=sp+1; i<=ep;i++)
		{
			for(long j=sp+1;j<=i;j++)
			{
				if(i==j)
				{
					count++;
					
					if(lastCount<5)
					{
							lastFive[lastCount]=i;
							lastCount++;
						
					}else
						{
							lastCount=0;
						}
						
					if(count==10000)
					{
						endTimeAtThousand=System.nanoTime();
						System.out.println("It takes : "+(endTimeAtThousand-startTime)/1000000000+" seconds to count 10000 numbers");
					}
				}
				if(i%j==0)
					break;
				}
			
			}
		
		endTime=System.nanoTime();
		Arrays.sort(lastFive);
		for(int i=0;i<5;i++)
		{
			if(i<4)
			System.out.print(lastFive[i]+",");
			else
				System.out.println(lastFive[i]);
		}
		
		System.out.print("the total prime numbers in range are: ");
		System.out.println(count);	
		System.out.println("the amount of time to find all prime numbers is: "+(double)((endTime-startTime)/1000000000)+" seconds");
		
	}
	
	public  static void bigRangePrime(long sp, long ep )
	{
		long count=0;
		int lastCount=0;
		double startTime =0;
		double endTime=0;
		double endTimeAtThousand=0;
		long[] lastFive= new long[5];
		startTime=System.nanoTime();
		System.out.println();
		System.out.println("the first five prime numbers in range of " + (sp+1)+"-"+ep+" are: ");
		
		for (long i=sp+1; i<=ep;i++)
		{
			for(long j=sp+1;j<=i;j++)
			{
				if(i==j)
				{
					count++;
					if(lastCount<5)
					{
							lastFive[lastCount]=i;
							lastCount++;
						
					}else
						{
							lastCount=0;
						}
					if(count<=5)
					{
						if(count<5)
							System.out.print(i+",");//prints the first 5 prime numbers
						else
							System.out.print(i);
					}
					if(count==1000)
					{
						endTimeAtThousand=System.nanoTime();
						System.out.println("It takes : "+(endTimeAtThousand-startTime)/1000000000+" seconds to count 10000 numbers");
					}
				}
				if(i%j==0)
					break;
			}
		}
		endTime=System.nanoTime();
		Arrays.sort(lastFive);
		for(int i=0;i<5;i++)
		{
			if(i<4)
			System.out.print(lastFive[i]+",");
			else
				System.out.println(lastFive[i]);
		}
		System.out.print("the total prime numbers in range are: ");
		System.out.println(count);	
		System.out.println((endTime-startTime)/1000000000+" seconds");
	}
	
	public static void main(String[] args) 
	{
		long endPoint= 100;
		long startingPoint=1;
		determinePrime(startingPoint,endPoint);
		endPoint =1000;
		determinePrime(startingPoint,endPoint);
		endPoint = 10000;
		determinePrime(startingPoint,endPoint);
		endPoint=100000;
		determinePrime(startingPoint,endPoint);
		endPoint=1000000;
		determinePrime(startingPoint,endPoint);
		endPoint=10000000;
		determinePrime(startingPoint,endPoint);
		startingPoint= 7869999999L;//L at the end of the number makes it fit into the long
		endPoint=7879999999L;
		bigRangePrime(startingPoint,endPoint);
		startingPoint=9389999999L;
		endPoint=9399999999L;
		bigRangePrime(startingPoint,endPoint);
	}
}