package ProperStack;

class SimpleStack<T> implements Stack<T> {

public class Node<T> { // Node implementation
	T data;
	Node next;

	public Node(T data) {
		this.data = data;
		this.next = null;
	}

	public Node(T data, Node next) {
		this.data = data;
		this.next = next;
	}

	public void setNext(Node d) {
		next = d;
	}

	public void setData(T d) {
		data = d;
	}

	public T getData() {
		return data;
	}

	public Node getNext() {
		return next;
	}

}

private Node<T> top = null;

public void push(T d) {
	if(top == null) {
		top = new Node<T>(d);	
	}

	else{
		Node<T> cache = top;
		Node<T> newNode = new Node<T>(d, cache);
		top = newNode;
	}
}

public T pop() {
	if(top != null) {
		Node<T> cache = top;
		top = top.next;
		return cache.getData();
	} else {
		return null;
	}
}

public T peek() {
	if(top!= null) {
		return top.getData();
	}
	else {
		return null;
	}
}


}