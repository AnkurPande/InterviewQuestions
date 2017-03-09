package linkedList;

import java.util.HashSet;

public class SinglyLinkedList{
	Node head = null;
	Node current = null;
	static int index;
	static int k =0;
	boolean add(String data){
		
		//Initialize new temp node.
		Node temp = new Node(data, null);
		
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
	
	
	boolean remove(String data){
		boolean removed = false;
		current = head;
		while(current.next!=null){
			if(current.next.getData().equals(data)){
				current.next= current.next.next;
				removed = true;
			}
			current = current.next;
		}
		return removed;
	}
	
	void print(){
		current = head;
		while(current!=null){
			System.out.println(current.getData());
			current = current.next;
		}
	}
	
	void reverseWithRecursion(Node prev, Node ptrOne, Node ptrTwo){
		if(ptrTwo!=null){
			if(ptrTwo.next!=null){
				Node t1 = ptrTwo;
				Node t2 = ptrTwo.next;
				ptrOne.next = prev;
				prev = ptrOne;
				reverseWithRecursion(prev,t1,t2);
			}else {
				ptrOne.next = prev;
				ptrTwo.next = ptrOne;
				head = ptrTwo;
				print();
			}
		}else if(ptrOne!=null){
			print();
		}else{
			System.out.print("Empty linked list");
		}
	}
	
	void reverseWithoutRecursion(){
		 current = head;
		 Node prev = null;
		 Node next = null;
		 while(current.next!=null){
			 next = current.next;
			 current.next = prev;
			 prev = current;
			 current = next;
		 }
		 current.next = prev;
		 head = current;
	}
	
	boolean removeDuplicate(){
		if(head == null)
			return false;
		
		HashSet<String> set = new HashSet<String>();
		boolean hasDuplicates = false;
		Node prev = null;
		current =  head;
		
		while(current.next!=null){
			if(!set.add(current.getData())){
				hasDuplicates = true;
				prev.next = current.getNext();				
			}else{
				prev = current;
			}
			current = current.getNext();
		}
		
		return hasDuplicates;
	}
	
	boolean removeDuplicateWithoutSets(){
		if(head ==null)
			return false;
		
		Node runner = null;
		Node prev =  null;
		boolean hasDuplicate = false;
		current  = head;
	
		while(current.getNext()!= null){
			runner = current.getNext();
	
			while(runner!=null){
			
				if(runner.getData().equals(current.getData())){
					hasDuplicate = true;
					break;
				}
				
				runner = runner.getNext();
			}
			
			if(hasDuplicate){
				
				if(prev!=null)
					prev.next = current.next;
				else
					head = head.next;
				hasDuplicate = false;
			
			}
			else{
				prev = current;
			}
			
			current = current.getNext();
		}
		
		return true;
	}
	
	int printKthToLastRecursion(Node node, int k){
		if(node==null)
			return 0;
		
		int index = printKthToLastRecursion(node.next,k)+1;
		
		if(index ==k)
			System.out.println("Kth node from last is: "+node.data);
		
		return index;
		
	}
	
	
	boolean deleteMiddleNode(Node node){
		if(node==null)
			return false;

		Node next = node.next;
		//Case 1. When node is middle node
		if(next!=null){
			String temp = next.data;
			
			//Copy the data into current node from next node.
			node.setData(temp);
			
			//advance the pointer to third node from current node
			next = next.next;
			
			//Make the third node to be the next node of current node.
			node.next = next;
		}
		//Case 2.  When the node is the last node. Make it dummy
		else{
			node.setData(null);
			node.setNext(null);
		}
		
		return true;
	}
	
	int printKthToLastIterative(int k){
		if(head==null)
			return 0;
	
		Node ptrOne = head;
		Node ptrTwo = head;
		
		for(int i=1;i<k;i++){
			if(ptrTwo==null) 
				System.out.println("...Out Of Bounds..");
			ptrTwo = ptrTwo.next;
		}
		
		while(ptrTwo.next != null){
			ptrOne = ptrOne.next;
			ptrTwo = ptrTwo.next;
		}
		
		System.out.println("The Kth to Last Node is: "+ptrOne.data);
		
		return k;
	}
	
	//partition a linked list into two by given value.
	Node partition(int data){
		if(head == null)
			return null;
		
		Node beforeStart = null;
		Node beforeEnd = null;
		Node afterStart = null;
		Node afterEnd = null;
		
		current = head;
		
		while(current!=null){
			Node next = current.next;
			current.next = null;
			
			if(Integer.parseInt(current.data)<data){
				if(beforeStart == null){
					beforeStart = current;
					beforeEnd = current;
				}else{
					beforeEnd.next = current;
					beforeEnd = current;
				}
			}else{
				if(afterStart == null){
					afterStart = current;
					afterEnd = current;
				}else{
					afterEnd.next = current;
					afterEnd = current;
				}
			}			
			current = next;
		}
		
		if(beforeStart == null)
			return afterStart;
		
		beforeEnd.next = afterStart;
		return beforeStart;
	}
	
	Node partition2(int data){
		if(head == null){
			return null;
		}
		
		Node start = head;
		Node end = head;
		
		while(current!=null){
			Node next = current.next;
			current.next = null;
			
			if(Integer.parseInt(current.data)<data){
					current.next = start;
					start = current;					
			}else{
					end.next = current;
					end = current;
			}
			
			end.next = null;
			current = next;
		}
		
		return start;
	}
	
	public static void main(String[] args){
		SinglyLinkedList list = new SinglyLinkedList();
		list.add("3");
		list.add("5");
		list.add("8");
		list.add("5");
		list.add("10");
		list.add("2");
		list.add("1");
				
		index = 5;
		list.printKthToLastRecursion(list.head,5);
		list.printKthToLastIterative(5);
		
		list.current = list.head;
		while(list.current!=null){
			if(list.current.getData().equals("the"))
				break;
			list.current = list.current.next;
		}
		
		list.deleteMiddleNode(list.current);
		list.head = list.partition2(5);
		list.print();
	}
}