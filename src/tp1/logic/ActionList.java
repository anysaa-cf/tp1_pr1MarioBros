package tp1.logic;

public class ActionList {
	
	private Action[] actionList;
	private int first;
	private int end;
	private int size;
	public static final int maxActions = 14;
	
	public ActionList() {
		actionList = new Action[20];
        first = 0;
        end = -1;
        size = 0;
	}
	
	 public boolean isEmpty() {
	        return size == 0;
	    }
	 
	 public boolean isFull() {
	        return size == actionList.length;
	    }
	
	 public void addAction(Action action) {
	        if (isFull()) {
	            System.out.println("Full list");
	            return;
	        }
	        
	        end = (end + 1) % actionList.length;  //cycle path of indexes (from 0 to last index, and then, again 0)
	        actionList[end] = action;
	        size++;	
	 }
	 
	 public Action getAction() {
	        if (isEmpty()) {
	            throw new IllegalStateException("Empty list");
	        }

	        Action action = actionList[first];
	        first = (first + 1) % actionList.length;  //cycle path of indexes
	        size--;
	        return action;
	    }
	 
	 public int size() {
		 return size;
	 }
}
