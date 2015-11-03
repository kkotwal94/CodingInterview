import java.util.*;

/**
Write code to partition a linked list around a value x, such that all nodes less than
x come before all nodes greater than or equal to x.
**/


class partitionedLinkedList {

//Class SLL
public class SinglyLinkedList {
	
	Node head; //our start
	
	public SinglyLinkedList() {
		this.head = null;
	}
	
	public void addFront(Object data) {
		Node cache = this.head; //our new node cache points to the start, which is null
		this.head = new Node(data, cache); //point to our old start and assign to our new one
	}
	
	public void addRear(Object newData) {
		Node cache = head;
		Node current = null;
		while((current = cache.next) != null) {
			cache = cache.next;
		}
		cache.next = new Node(newData, null);
	}

	public void printLinkedList() {
		Node cache = head;
		Node current = null;
		while((current = cache) != null) {
			System.out.println(cache.data);
			cache = cache.next;
		}
	}

	public Object getFront() {
		return this.head.data;
	}

	public String toString() {
		String result = "[";
		Node cache = head;
		Node current = null;
		while((current = cache) != null) {
			result  =  result + current.data + ", ";
			cache = cache.next;
			
		}
		System.out.println(result + "]");
		return result + "]";
	}


}


//class node
public class Node {
	public Object data;
	public Node next;

	public Node(Object data,  Node next) {
 		this.data = data;
 		this.next = next;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object d) {
		data = d;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node n) {
		next = n;
	}

}


	LinkedList linkedlist = new LinkedList();
	SinglyLinkedList linked = new SinglyLinkedList(); 
	
public Node partitionLL(SinglyLinkedList linkedlist, int pivot) {
		//System.out.println(linkedlist);
		SinglyLinkedList lesserPart = new SinglyLinkedList();
		SinglyLinkedList morePart = new SinglyLinkedList();
		
		Node lesserPartTracker = null;
		Node morePartTracker = null;

		Node cache = linked.head;
		//System.out.println(linked.head.data);
		Node current = null;
		while((current = cache) !=null) {
			if( (int)current.data < pivot) {
				if(lesserPart.head == null) {
					lesserPart.addFront(current.data);
					lesserPartTracker = lesserPart.head;
				}
				else {
					lesserPartTracker.next = current;
					lesserPartTracker = lesserPartTracker.next;
				}
			} 
			else {
				if((int)current.data >= pivot) {
					if(morePart.head == null) {
						morePart.addFront(current.data);
						morePartTracker = morePart.head;
					}
					else {
						morePartTracker.next = current;
						morePartTracker = morePartTracker.next;
					}
				} 
			}
			cache = cache.next;
		}
		System.out.println(lesserPart);
		System.out.println(morePart);
		lesserPartTracker.next = morePart.head;
		System.out.println(lesserPart);
		return lesserPartTracker;
	}
	
	public static void main(String[] args) {

		partitionedLinkedList ll = new partitionedLinkedList();
		ll.linkedlist.add(5);
		ll.linkedlist.add(3);
		ll.linkedlist.add(2);
		ll.linkedlist.add(6);
		ll.linkedlist.add(9);
		ll.linkedlist.add(12);
		ll.linkedlist.add(8);
		//System.out.println(ll.linkedlist);
		//ll.partitionLL(ll.linkedlist, 3);
		ll.linked.addFront(8);
		ll.linked.addRear(5);
		ll.linked.addRear(3);
		ll.linked.addRear(2);
		ll.linked.addRear(6);
		ll.linked.addRear(9);
		ll.linked.addRear(12);
		ll.linked.addRear(8);
		//ll.linked.toString();
		//ll.linked.printLinkedList();

		ll.partitionLL(ll.linked, 6);

	}

}


