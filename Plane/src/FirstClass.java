

public class FirstClass <E>
{
	private int f = 0;
	private int sz = 0;
	private Passanger[] waiting;
	Passanger[] firstClassStation1 = new Passanger[1];
	Passanger[] firstClassStation2 = new Passanger[1];

	
	public FirstClass()
	{
		waiting = new Passanger[10];
	}
	public FirstClass(int capacity)
	{
		waiting = new Passanger[capacity];
	}
	
	public int size() 
	{
		
		return sz;
	}

	public boolean isEmpty() 
	{
		if(sz == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

	public Passanger first() 
	{
		if(this.isEmpty())
		{
			return null;
		}
		else
		{
			return waiting[f];
		}
		
	}

	public void enqueue(Passanger e) throws IllegalStateException
	{
		if(sz == waiting.length)
		{
			throw new IllegalStateException ("Queue is full");
		}
		
		System.out.println("Adding " + e);
		
		int avail = (f+sz) % waiting.length;
		
		waiting[avail] = e;
		
		sz++;
		
		
		
		this.print();
		
	}

	public Passanger dequeue() 
	{
		if(this.isEmpty())
		{
			return null;
		}
		
		Passanger answer = waiting[f];
		waiting[f] = null;
		f = (f+1)% waiting.length;
		sz--;
		this.print();
		return answer;
		
	}
	
	public void print() 
	{
		for(int i = 0; i < waiting.length; i++)
		{
			if(waiting[i] == null)
			{
				
			}
			else
			{
				System.out.println(waiting[i]);
			}
		}
		System.out.println("\n");
	}
	
	//send to one of the stations if available
	public void sendToStation(Passanger e)
	{
		if(firstClassStation1[0] == null)
		{
			System.out.println("Sending to service Station 1");
			firstClassStation1[0] = e;
			this.dequeue();
		}
		else if(firstClassStation2[0] == null)
		{
			System.out.println("Sending to service Station 2");
			firstClassStation2[0] = e;
			this.dequeue();
		}
	}
	
	//Empty station to make room for another passanger
	public void freeStation(int e)
	{
		if(e == 0)
		{
			firstClassStation1[0] = null;
			System.out.println("Service Station 1 now avilable");
		}
		else if(e == 1)
		{
			firstClassStation2[0] = null;
			System.out.println("Service Station 2 now available");
		}
	}
	
	
}
