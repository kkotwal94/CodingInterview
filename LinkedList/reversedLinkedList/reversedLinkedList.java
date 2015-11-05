class reversedLinkedList {

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

public void reverse(NodeLinkedList link) {
	//System.out.println(link.toString());
	NodeLinkedList reversed = new NodeLinkedList();
	Node cache = link.head;
	Node prev = null;
	Node next;
	int size = 0;
	while(cache.getNext() != null) {
		next = cache.getNext(); //1
		//System.out.println(next.data);
		cache.setNext(prev); //7 points to null
		//System.out.println(cache.next);
		prev = cache;
		//System.out.println(prev.data);
		cache = next;
		size++;
	}
	//link.head = cache;
	link.head = cache;
	cache.setNext(prev);
	size++;
	System.out.println(link.head.data);
	System.out.println(link.toString());
	System.out.println(size);
}


public static void main(String[] args) {
	reversedLinkedList link = new reversedLinkedList();
	//NodeLinkedList linked = new NodeLinkedList();
	link.links.addFront(7);
	link.links.addRear(1);
	link.links.addRear(6);
	link.links.addRear(4);
	link.links.addRear(6);
	link.links.addRear(1);
	link.links.addRear(7);

	link.links2.addFront(5);
	link.links2.addRear(9);
	link.links2.addRear(2);

	//System.out.println(link.links.toString());
	//System.out.println(link.links2.toString());

	link.reverse(link.links);

}

}