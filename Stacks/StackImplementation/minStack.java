import java.util.*;

class minStack {

public class Stack {

	Node top;

	Object pop() {
		if(top != null) {
			Object item = top.getData();
			top = top.getNext();
			return item;
		}
		return null;
	}

	void push(Object item) {
		Node pushed = new Node(item, top);
		top = pushed;
	}

	Object peek() {
		if(top == null) {
			//System.out.println("Its null or stack is empty");
			return null;
		}	
		return top.getData();
	}

}

public class Node {
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

	public void setNext(Node n) {
		next = n;
	}

	public Node getNext() {
		return next;
	}

	public void setData(Object d) {
		data = d;
	}

	public Object getData() {
		return data;
	}
}

public class StackWithMin extends Stack {
	Stack s2;

	public StackWithMin() {
		s2 = new Stack();
	}

	public void push(Object value) {
		if((int)value <= (int)min()) {
			s2.push(value);
		}
		super.push(value);
	}

	public Object pop() {
		Object value = super.pop();
		if((int)value == (int)min()) {
			s2.pop();
		}
		return value;
	}

	public Object min() {
		if(s2.top == null) {
			return null;
		}
		else {
			return s2.peek();
		}
	}
}
	Stack testStack = new Stack();
	StackWithMin stackMin = new StackWithMin();
	
	public static void main(String[] args) {
		minStack mStack = new minStack();
		mStack.testStack.push(3);
		mStack.testStack.push(5);
		mStack.testStack.push(2);
		mStack.stackMin.push(3);
		mStack.stackMin.push(4);
		mStack.stackMin.push(2);
		System.out.println(mStack.testStack.peek());
		System.out.println(mStack.stackMin.min());
		mStack.testStack.pop();
		

	}

}