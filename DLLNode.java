/** 
 *
 * DLLNode.java
 *
 * DLLNode class (with basic DLLNode functionality)
 *
 * @author  Aaron Brill
 * Date:    May 11, 2018
 *
 */
public class DLLNode<T> {

	private T data;
	public DLLNode<T> next;
	public DLLNode<T> prev;
	
	public DLLNode(T d)
	{
		data = d;
		next = null;
		prev = null;
	}
	
	public T getData()
	{
		return data;
	}
	
}