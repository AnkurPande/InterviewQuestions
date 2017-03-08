package linkedList;

/*Given a linked list determine if it has a loop.
 * Given a circular linked list determine the beginning of the loop.
 * */

public class LoopDetection {

	Node detectLoop(SinglyLinkedList list){
		Node slow = list.head;
		Node fast = list.head;
		
		//Advance the pointers until they meet.
		while(fast!= null && fast.next != null){
			
			//Error no meeting point.Hence, no loop exist.
			slow = slow.next;
			fast = fast.next.next;
			if(fast==slow)
				break;
		}
		
		//Check for condition and return null if no loop exist.
		if(fast==null || fast.next == null)
			return null;
		
		//Make slow point to head of list while keeping fast at same node
		slow = list.head;
		
		//Advance the two pointers at same pace until they meet again at start of loop.
		while(slow!=fast){
			slow = slow.next;
			fast = fast.next;
		}
		
		//Return any one of them.
		return fast;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinkedList list = new SinglyLinkedList();
		LoopDetection detect = new LoopDetection();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		list.add("F");
		list.add("G");
		list.add("H");
		list.add("I");
		
		Node temp = list.head.next.next;
		Node temp2 = list.head;
		
		while(temp2.next != null){
			temp2 = temp2.next;
		}
		temp2.next = temp;
		System.out.print(detect.detectLoop(list).data);
	}

}
