package linkedList;

import java.util.Stack;

public class PallindromeList {

	boolean checkPallindrome(SinglyLinkedList list){
		Node fast = list.head;
		Node slow = list.head;
		Stack<String> stack = new Stack<String>();
	
		while(slow.next!=null){
					
			stack.add(slow.data);
			slow = slow.next;
			
			//Check if fast already reached the last node . Then slow already crossed the middle node and middle is already being pushed into stack.
			//Then the list must be of odd length. Hence, break the loop. 
			if(fast.next==null){
				//Skip the middle node.
				stack.pop();
				break;
			}
					
			//This condition check if pointer fast is at the second last node of list. List is even length.
			if(fast.next.next!=null)
				fast = fast.next.next;
			else
				break;
		}
		
		
		while(slow.next!=null){
				
			if(!slow.data.equals(stack.pop()))
				return false;
			slow = slow.next;
		}
		
		return true;
		
	}

	wrapper checkPallindromeRecursion(Node node, Node current){
		
		wrapper wrap = null;
			
		if(node.next != null){
			wrap = checkPallindromeRecursion(node.next, current);
		}
		else {
			wrap = new wrapper(node.data.equals(current.data),current);
		}
		
		if(!wrap.returnVal)
			wrap.returnVal = false;
		
		if(!node.data.equals(wrap.current.data))
			wrap.returnVal = false;
		
		wrap.current = wrap.current.next;
			
		return wrap;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinkedList list = new SinglyLinkedList();
		PallindromeList pal = new PallindromeList();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("G");
		list.add("D");
		list.add("C");
		list.add("B");
		list.add("A");
		
		if(pal.checkPallindrome(list))
			System.out.print("Pallindrome");
		else
			System.out.print("Not Pallindrome");
		
		wrapper wrap = pal.checkPallindromeRecursion(list.head, list.head);
		if(wrap.returnVal){
			System.out.println("Pallindrome");
		}else{
			System.out.println("Not Pallindrome");
		}
	}

}

class wrapper{
	boolean returnVal;
	Node current;
	
	wrapper(boolean returnVal, Node current){
		this.current = current;
		this.returnVal = returnVal;
	}
}
