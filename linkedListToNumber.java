class linkedListToNumber {

	NodeLinkedList links = new NodeLinkedList();
	NodeLinkedList links2 = new NodeLinkedList(); 

	
class NodeLinkedList {
	
	Node head = null;
	int sizeCount = 0;

	public NodeLinkedList() {
		this.head = null;
		this.sizeCount = 0;
	}

	public void addFront(Object d) {
		Node cache = head;
		head = new Node(d, cache);
		sizeCount++;
	}

	public void addRear(Object d) {
		Node current = head;
		Node newNode = new Node(d);
		while(current.getNext() != null) {
			//System.out.println(current.data);
			current = current.getNext();
			//System.out.println(current.data);
		}
		current.setNext(newNode);
		sizeCount++;
	}

	public boolean add(Object d, int index) {
		Node current = head;
		if (index > sizeCount) {
			System.out.println("Index is larger than array size, sure you just don't want to add to the rear?");
			return false;
		}
		for(int i = 0; i < index-1 && current.getNext()!=null; i++) {
			current = current.getNext();
		}
		Node temp = current.getNext();
		//System.out.println(temp.data);
		Node newNode = new Node(d, temp);
		current.setNext(newNode);
		System.out.println(current.data);
		sizeCount++;
		return true;
	}

	public void removeFront() {
		Node cache = head.getNext();
		head = cache;
		sizeCount--;
	}

	public void removeRear() {
		Node cache = head;
		while(cache.getNext().getNext() != null) {
			cache = cache.getNext();
		}
		cache.setNext(null);
		sizeCount--;
	}

	public boolean remove(int index) {
		Node cache = head;
		if(index >= sizeCount) {
			System.out.println("Are you sure you don't want to call remove from rear function?");
			return false;
		}
		for(int i = 0; i < index-1; i++) {
			cache = cache.getNext();
		}
		Node hop = cache.getNext().getNext();
		cache.setNext(hop);
		sizeCount--;
		return true;
	}

	public int size() {
		return sizeCount;
	}

	public String toString() {
		Node current = head;
		String output = "";
		while(current != null) {
			output += " [" + current.getData().toString() + "]";
			current = current.getNext();
		}
		return output;
	}



}

class Node {
	
	Object data;
	Node next;

	public Node(Object data) {
		this.data = data;
		this.next = null;
	}

	public Node(Object data, Node next) {
		this.data = data;
		this.next = next;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node n) {
		next = n;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object d) {
		data = d;
	}

}	

public int reverseInteger(int number) {
	int newNum = 0;
	while(number > 0) {
		newNum = newNum * 10 + (number%10);
		number = number / 10;
	}
	return newNum;
}

public void addLinkedLists(NodeLinkedList one, NodeLinkedList two) {
		NodeLinkedList link3 = new NodeLinkedList(); //reversed linked list
		NodeLinkedList link4 = new NodeLinkedList(); //straight linked list
		Node cache1 = one.head;
		Node cache2 = two.head;
		int number1 = 0;
		int number2 = 0;
		while(cache1 != null) {
			number1 = (number1 * 10) + ((int)cache1.data);
			System.out.println(number1);
			cache1 = cache1.getNext();
			
		}

		while(cache2 != null) {
			number2 = (number2 * (10) + ((int)cache2.data));
			System.out.println(number2);
			cache2 = cache2.getNext();
	
		}
		int total = number1 + number2;
		int reversedNumber1 = reverseInteger(number1); //get its reverse
		int reversedNumber2 = reverseInteger(number2); //get its reverse

		int reversedTotal = reversedNumber2 + reversedNumber1;

		while(reversedTotal>0) {
			if(link3.head == null) {
				int digit = reversedTotal % 10;
				link3.addFront(digit);
			}
			else {
				int digit = reversedTotal % 10;
				link3.addRear(digit);
			}
			reversedTotal = reversedTotal / 10;
		}
		
		while(total>0) {
			int digit = total % 10;
			link4.addFront(digit);
			total = total / 10;
		}

		System.out.println("Reversed: " + link3.toString());
		//return link3;
		System.out.println("Regular: " + link4.toString());

	}

public static void main(String[] args) {
	linkedListToNumber link = new linkedListToNumber();
	//NodeLinkedList linked = new NodeLinkedList();
	link.links.addFront(7);
	link.links.addRear(1);
	link.links.addRear(6);

	link.links2.addFront(5);
	link.links2.addRear(9);
	link.links2.addRear(2);

	System.out.println(link.links.toString());
	System.out.println(link.links2.toString());

	link.addLinkedLists(link.links, link.links2);

}

}