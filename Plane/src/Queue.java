
public class Queue<E>
{

	private E[] data;
	private int f = 0;
	private int sz = 0;
	
	public Queue()
	{
		data = (E[]) new Object[10];
	}
	public Queue(int capacity)
	{
		data = (E[]) new Object[capacity];
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

	public E first() 
	{
		if(this.isEmpty())
		{
			return null;
		}
		else
		{
			return data[f];
		}
		
	}

	public void enqueue(E e) throws IllegalStateException
	{
		if(sz == data.length)
		{
			throw new IllegalStateException ("Queue is full");
		}
		
		System.out.println("Adding " + e);
		
		int avail = (f+sz) % data.length;
		
		data[avail] = e;
		
		sz++;
		
		this.print();
		
	}

	public E dequeue() 
	{
		if(this.isEmpty())
		{
			return null;
		}
		
		E answer = data[f];
		data[f] = null;
		f = (f+1)% data.length;
		sz--;
		this.print();
		return answer;
		
	}
	
	public void print() 
	{
		for(int i = 0; i < data.length; i++)
		{
			System.out.println(data[i]);
		}
		System.out.println("\n");
	}

}
