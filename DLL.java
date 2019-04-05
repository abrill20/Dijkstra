/** 
 *
 * DLL.java
 *
 * DLL class (with basic DLL functionality)
 *
 * @author  Aaron Brill
 * Date:    May 11, 2018
 *
 */
public class DLL<T> {
	
	private DLLNode<T> head;
	private DLLNode<T> tail;
	
	public DLL()
	{
		head = null;
		tail = null;
	}

	public DLLNode<T> getHead()
	{
		return head;
	}
	
	public boolean isEmpty()
	{
		return (head == null);
		// if head is null, tail will also be null
	}
	
	// assume that DLL is NOT empty
		public T removeFromEnd()
		{
			T returnVal = tail.getData();
			tail = tail.prev;
			// check if the list was more than 1 element
			if (tail != null)
			{
				// since the list will still contain at least 1 element
				// was can do the following
				tail.next = null;
			}
			else
			{
				// since tail is null, this means the list should be empty
				// so we set head to null as well
				head = null;
			}
			return returnVal;
		}
	
	public void addToBeginning(T d)
	{
		DLLNode<T> nodeToAdd = new DLLNode<T>(d);
		
		if (isEmpty())
		{
			head = nodeToAdd;
			tail = head;
		}
		else
		{
			nodeToAdd.next = head;
			head.prev = nodeToAdd;
			head = nodeToAdd;
		}
	}

	public void addToEnd(T d)
	{
		DLLNode<T> nodeToAdd = new DLLNode<T>(d);
		
		if (isEmpty())
		{
			head = nodeToAdd;
			tail = head;
		}
		else
		{
			tail.next = nodeToAdd;
			nodeToAdd.prev = tail;
			tail = nodeToAdd;
		}
	}

	// boolean return false if not found, true if found and deleted
	public boolean delete(T dataToDelete)
	{
		DLLNode<T> nodeToDelete = search(dataToDelete);
		
		if (nodeToDelete == null) // means didn't find it
		{
			return false;
		}
		
		if ((nodeToDelete == head) && (nodeToDelete == tail))
		{
			head = null;
			tail = null;
		}
		else
		{
			if (nodeToDelete == head)
			{
				head = head.next;
				head.prev = null;
			}
			else
			{
				if (nodeToDelete == tail)
				{
					tail = tail.prev;
					tail.next = null;
				}
				else
				{
					nodeToDelete.prev.next = nodeToDelete.next;
					nodeToDelete.next.prev = nodeToDelete.prev;
				}
			}
		}	
		
		return true;
	}
	
	public DLLNode<T> search(T lookFor)
	{
		DLLNode<T> temp = head;
		/*
		while (temp != null && !temp.getData().equals(lookFor))
		{
			temp = temp.next;
		}
		*/
		
		while (temp != null)
		{	
			if (temp.getData().equals(lookFor))
				return temp; // returns the DLLNode that was found
			temp = temp.next;
		}

		return null; // get here when lookFor is NOT found
	}
	
	public String toString()
	{
		String listStr = "";
		
		DLLNode<T> temp = head;
		while (temp != null)
		{
			listStr += temp.getData().toString() + "\n";
			temp = temp.next;
		}

		return listStr;
	}

	public String toStringReverse()
	{
		String listStr = "";
		
		DLLNode<T> temp = tail;
		while (temp != null)
		{
			listStr += temp.getData().toString() + "\n";
			temp = temp.prev;
		}

		return listStr;
	}

	
}