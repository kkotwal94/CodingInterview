package Queues;
import java.util.*;

public class Queue<T> {
	Stack<T> stackNewest;
	Stack<T> stackOldest;

	public Queue() {
		stackNewest  = new Stack<T>();
		stackOldest = new Stack<T>();
	}

	public int size() {
		return stackNewest.size() + stackOldest.size();
	}

	public void add(T value) {
		stackNewest.push(value);
	}

	private void shiftStacks() { //push all the newest elements into our old stack, in opposite order, so the newest element goes to the bottom of the oldest stack
		if(stackOldest.isEmpty()) {
			while(!stackNewest.isEmpty()) { 
				stackOldest.push(stackNewest.pop());
			}
		}
	}
	public T peek() {
		shiftStacks(); //make sure the first people in are occupying the oldest first stack
		return stackOldest.peek();
	}
	public T remove() {
		shiftStacks(); //make sure we are doing this FIFO
		return stackOldest.pop(); // pop it
	}
}
