/** 
 *
 * Queue.java
 *
 * Queue class (with basic queue functionality)
 *
 * @author  Aaron Brill
 * Date:    May 11, 2018
 *
 */
public class Queue 
{
	private DLL<Integer> q;
	
	public Queue()
	{
		q = new DLL<Integer>();
	}

	public void enqueue(int num)
	{
		q.addToBeginning(num);
	}
	
	public int dequeue()
	{
		return q.removeFromEnd();
	}
	
	public boolean empty()
	{
		return q.isEmpty();
	}
}