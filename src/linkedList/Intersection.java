package linkedList;

public class Intersection {

	Result getSizeAndTail(SinglyLinkedList list){
		Node temp = list.head;
		int size = 0;
		
		while(temp.next!=null){
			temp = temp.next;
			size++;
		}
		
		return new Result(temp,size);
	}
	
	Node checkIntersection(SinglyLinkedList list1, SinglyLinkedList list2){
		Result result1 = getSizeAndTail(list1);
		Result result2 = getSizeAndTail(list2);
		
		//If tails are different by reference then no intersection for sure.
		if(result1.tail!=result2.tail)
			return null;
		
		//Pointers to lists.
		Node longer = result1.size>=result2.size ? list1.head : list2.head;
		Node shorter = result1.size<result2.size ? list1.head : list2.head;
		
		//Advance the pointers on longer list by difference of nodes.
		int k = Math.abs(result1.size - result2.size);
		
		while(k>0){
			longer = longer.next;
			k--;
		}
		
		//Check for intersection while advancing both pointers simultaneously.
		while(longer!=shorter){
			longer = longer.next;
			shorter = shorter.next;
		}
		
		//Return any one of them.
		return longer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}

class Result{
	Node tail = null;
	int size = 0;
	
	Result(Node tail, int size){
		this.tail = tail;
		this.size = size;
	}
}