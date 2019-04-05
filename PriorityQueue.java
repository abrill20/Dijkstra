/** 
 *
 * PriorityQueue.java
 *
 * Minimum priority queue
 *
 * @author  Aaron Brill
 * Date:    May 11, 2018
 *
 */
public class PriorityQueue 
{
	public static final int MAXIMUM_PRIORITY = 100;
	private Queue pq[];
	private int lowestCurrentPriority; // the priority of the lowest priority item
	private int currentSize; // # of elements currently in the pq

	public PriorityQueue()
	{
		currentSize = 0;
		lowestCurrentPriority = MAXIMUM_PRIORITY+1;
		pq = new Queue[MAXIMUM_PRIORITY + 1];
		for (int i=0; i<pq.length; i++)
		{
			pq[i] = new Queue();
		}
	}

	public int size()
	{
		return currentSize;
	}
	
	// priority is assumed to be within valid range of array
	public void enqueue(int item, int priority)
	{
		pq[priority].enqueue(item);
		if (priority < lowestCurrentPriority)
		{
			lowestCurrentPriority = priority;
		}
		currentSize++;
	}
	
	public int dequeue()
	{
		int dequeuedInt;
	
		if (empty())
		{
			dequeuedInt = -1;
		}
		else
		{
			dequeuedInt = pq[lowestCurrentPriority].dequeue();
			currentSize--;
			if (currentSize > 0)
			{
				while (pq[lowestCurrentPriority].empty())
				{
					lowestCurrentPriority++;
				}
			}
			else
			{
				lowestCurrentPriority = MAXIMUM_PRIORITY;
			}
		}
		
		return dequeuedInt;
	}
	
	
	public boolean empty()
	{
		return (currentSize == 0);
	}
}