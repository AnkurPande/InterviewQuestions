package linkedList;

public class LinkedList {

	NodeI head = null;
	NodeI current = null;
	
	//Add data to the list.
	boolean add(int data){
		
		//Initialize new temp NodeI.
		NodeI temp = new NodeI(data, null);
		
		//Empty list at start.
		if(head==null){
			head = temp;
			return true;
		}
		
		current = head;
		while(current.next!=null){
			current = current.next;
		}
		current.next = temp;
		return true;
	}
	
	/*This method add the digits represented by linked list in reverse order and displays the 
	 * answer. The answer is displayed in reverse order. 
	 * */
	NodeI add(NodeI head1, NodeI head2, int carry){
		
		int dummyVal = 0;
		int value = 0;
		if(head1 == null && head2 == null)
			return head;
		
		if(head1 == null)
			value = dummyVal + head2.data + carry;
		else if(head2 == null)
			value = head1.data + dummyVal + carry;
		else
			value = head1.data + head2.data + carry;
	
		carry = (value - value % 10)/10;
		int result = value % 10;
				
		NodeI resultNode = new NodeI(result);
		
		if(current == null){
			head = resultNode;
			current = resultNode;
		}
		else{
			current.next = resultNode;
			current = resultNode;
		}
		
		if(head1 == null)
			head = add(null,head2.next, carry);
		else if(head2 == null)
			head = add(head1.next,null, carry);
		else 
			head = add(head1.next,head2.next, carry);
		
		return head;
	}
	
	//Method to add the list in forward order. 
	int add(NodeI head1, NodeI head2){
		int carry = 0;
		int sum = 0;
		int result = 0;
		NodeI newNode = null;
		
		if(head1.next != null && head2.next != null){
			carry = add(head1.next,head2.next); 
			sum = head1.data + head2.data + carry;
			result = sum % 10;
			carry = ( sum - result) / 10;
			newNode = new NodeI(result,null);
			newNode.next = current;
			current = newNode;
		}else {
			
			current = null;
			sum = head1.data + head2.data;
			result = sum % 10;
			carry = ( sum - result) / 10;
			newNode = new NodeI(result,null);
			current = newNode;
		}
		return carry;
	}
	
	//Helper method to sum the two linked list data represented in the forward order.
	//Calls the method add recursively to generate the sum of the list. The answer is displayed in order of list.
	void addList(LinkedList list1, LinkedList list2, LinkedList result){
		
		int carry = result.add(list1.head, list2.head);
		
		if(carry!=0){
			NodeI node = new NodeI(carry);
			node.next= result.current;
			result.current = node;
		}
		result.head = result.current;
	}
	
	void print(){
		current = head;
		System.out.println();
		while(current!=null){
			System.out.print(current.data);
			current = current.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		LinkedList result = new LinkedList();
		
		list1.add(7);
		list1.add(1);
		list1.add(6);
		list1.print();
		
		list2.add(5);
		list2.add(9);
		list2.add(2);
		list2.print();
		
	//	result.current = result.head;
	//	result.head = result.add(list1.head, list2.head, 0);
	//	result.print();
		result.addList(list1, list2, result);
		result.print();
	}

}


class NodeI{
	int data;
	NodeI next;
	
	NodeI(int data, NodeI next){
		this.data = data;
		this.next = next;
	}
	
	NodeI(int data){
		this.data = data;
		this.next = null;
	}
	
}