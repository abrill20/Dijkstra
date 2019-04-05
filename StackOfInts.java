/** 
 *
 * StackOfInts.java
 *
 * Stack of integers
 *
 * @author  Aaron Brill
 * Date:    May 11, 2018
 *
 */
public class StackOfInts 
{
	private int stack[];
	private int top; 
	// top is the index to push to, and top-1 is the index to pop from
	
	public StackOfInts()
	{
		stack = new int[1000];
		top = 0;
	}

	public boolean empty()
	{
		return (top == 0);
	}
	
	public void push(int thingToPush)
	{
		stack[top++] = thingToPush;
	}
	
	public int pop()
	{
		return stack[--top];
	}
	
	public int peek()
	{
		return stack[top - 1];
	}

}