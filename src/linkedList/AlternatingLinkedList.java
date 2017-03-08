package linkedList;

public class AlternatingLinkedList {

	/*This method will take a linked list and arrange its elements in alternating order.
	 * The length of linked list is unknown but it is given that it is even.
	 * */
	
	boolean arrangeAlternatively(SinglyLinkedList list){
		//Empty List Nothing to return.
		if(list.head == null)
			return false;
		
		Node slowRunner = list.head;
		Node fastRunner = list.head;
		
		
		//Loop to advance slow runner to middle of list.
		while(slowRunner.next!=null){
			slowRunner = slowRunner.next;
			if(fastRunner.next.next!=null){
				fastRunner = fastRunner.next.next;
			}
			else{
				fastRunner = fastRunner.next;
				break;
			}
		}
		
		
		//Reset the fast runner position to head of list.
		fastRunner = list.head;
		
		//Now start moving fastRunner and slowRunner with same pace while rearranging the nodes.
		while(slowRunner.next!=null){
			
			Node nextFR = fastRunner.next; // Keep track of next node of list.
			
			Node nextSR = slowRunner.next; // Keep track of next of slow runners next node.
	
			fastRunner.next = slowRunner; // Shift the slow Runner to second position in linked list. 
			
			slowRunner.next = nextFR; // Make the second node of list next node of slow runner.
						
			fastRunner = nextFR; // Advance the fast Runner to next position.

			slowRunner = nextSR; // Advance the slow Runner to next position.
			
			if(slowRunner.next==null)
				fastRunner.next = slowRunner;
		}
	
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinkedList list = new SinglyLinkedList();
		AlternatingLinkedList alternateSeq = new AlternatingLinkedList();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		list.add("F");
		list.add("G");
		list.add("H"); 
		list.add("I");
		list.add("J");
		list.add("K");
		list.add("L");
			
		alternateSeq.arrangeAlternatively(list);
			
	}

}
