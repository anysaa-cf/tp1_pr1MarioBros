package tp1.logic;

public class ActionList {
	
	private Action[] actionList;
	private int first;
	private int end;
	private int size;
	private boolean erase = false;
	private int R = 0, L = 0, U = 0, D = 0; 
	public static final int maxActions = 4;
	
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
	 
	 public boolean updateC(Action action) {
		 boolean ok = false;
		 switch(action) {
		 
		 	case RIGHT:
		 		if(L == 0 && R < maxActions && !erase) {
		 			ok = true;
		 			R++;
		 		}
		 		else if (erase)
		 			R--;
		 		break;
		 	
		 	case LEFT:
		 		if(R == 0 && L < maxActions  && !erase) {
		 			ok = true;
		 			L++;
		 		}
		 		else if(erase)
		 			L--;
				break;
			
		 	case UP:
		 		if(D == 0 && U < maxActions  && !erase) {
		 			ok = true;
		 			U++;
		 		}
		 		else if(erase)
		 			U--;
				break;
				 
		 	case DOWN:
		 		if(U == 0 && D < maxActions  && !erase) {
		 			ok = true;
		 			D++;
		 		}
		 		else if(erase)
		 			D--;
				break;
			
		 	case STOP:
		 		break;
				 
		 	default:
		 		break;
		 }
		 return ok;
	 }
	
	 public void addAction(Action action) {
	        if (isFull()) {
	            System.out.println("Full list");
	            return;
	        }
	        if(updateC(action)) {
		        end = (end + 1) % actionList.length; //cycle path of indexes (from 0 to last index, and then, again 0)
		        actionList[end] = action;
		        size++;	
	        }
	 }
	 
	 public Action getAction() {
	        if (isEmpty()) {
	        	System.out.println("Empty list");
	        }

	        Action action = actionList[first];
	        first = (first + 1) % actionList.length; //cycle path of indexes
	        erase = true;
	        updateC(action);
	        erase = false;
	        size--;
	        return action;
	}
	 
	 public int size() {
		 return size;
	 }
}
