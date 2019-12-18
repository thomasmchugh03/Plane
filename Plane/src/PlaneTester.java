import java.util.Random;
import java.util.Scanner;

public class PlaneTester 
{
	public static void main(String[] args)
	{
		FirstClass<Passanger> waitingList = new FirstClass<Passanger>(100);
		Passanger[] coachStation1 = new Passanger[1];
		Passanger[] coachStation2 = new Passanger[1];
		Passanger[] coachStation3 = new Passanger[1];

		
		Passanger placeholder = new Passanger();
		Random rand = new Random();
		
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please give total run time");
		int totalRunTime = input.nextInt();
		
		System.out.println("Please give average arrival rate");
		int averageArrivalTime = input.nextInt();
		
		System.out.println("Please give average service rate");
		int averageServiceRate = input.nextInt();
		
		//People arriving to first class
		for(int i = 0; i <= totalRunTime; )
		{
			//Ranadomize arrival rate for first class
			int R1 = rand.nextInt(averageArrivalTime) + averageArrivalTime/2;
			//randomize service rate for stations
			int S1 = rand.nextInt(averageServiceRate) + 1;
			//increment time by arrival time of next passanger
			i = i + R1;
			//print out the timer interval that passed
			System.out.println(i);
			//add person to waiting list
			waitingList.enqueue(placeholder);
			//send to service station if available
			waitingList.sendToStation(placeholder);
			//if the service station takes less time than the arrival time for the next passenger, make a station available
			if(i + S1 <= i + R1)
			{
				if(waitingList.firstClassStation1[0] == placeholder)
				{
					//0 to make station 1 available
					waitingList.freeStation(0);
				}
				else if(waitingList.firstClassStation2[0] == placeholder)
				{
					//1 to make station 2 available
					waitingList.freeStation(1);
				}
			}
			
		}
		
	}
}
