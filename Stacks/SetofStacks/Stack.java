package SetofStacks;

public class Stack {

	Node top;
	Node bottom;
	int capacity;
	int size = 0;

	public Stack(int capacity) {
		this.capacity = capacity; //setting size of our stack at most
	}

	public void join(Node above, Node below) { //keeping track of whats above and below each node
		if(below != null) {
			below.above = above;
		}

		if(above != null) {
			above.below = below;
		}
	}


	public boolean isFull() {
		return size == capacity;
	}

	public boolean push(int data) {
		if(size > capacity) {
			return false;
		}
		size++;
		Node n = new Node(data);
		if(size == 1) {
			bottom = n;
		}
		join(n, top);
		top = n;
		return true;
	}

	public int pop() {
		Node t = top;
		top = top.below;
		size--;
		return t.value;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int removeBottom() {
		Node b = bottom;
		bottom = bottom.above;
		if(bottom!=null){
			bottom.below = null;
		}
		size--;
		return b.value;
	}

}