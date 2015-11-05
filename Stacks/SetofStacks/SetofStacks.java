package SetofStacks;
import java.util.*;

public class SetofStacks {
	ArrayList<Stack> stacks = new ArrayList<Stack>();
	public int capacity;

	public SetofStacks(int capacity) {
		this.capacity = capacity;
	}

	public Stack getLastStack() {
		if(stacks.size() == 0) {
			return null;
		}

		return stacks.get(stacks.size()-1);
	}

	public void push(int data) {
		Stack last = getLastStack();
		if(last != null &&  !last.isFull()) {
			last.push(data);
		}
		else {
			Stack stack = new Stack(capacity);
			stack.push(data);
			stacks.add(stack);
		}
	}

	public int pop() {
		Stack last = getLastStack();
		int data = last.pop();
		if(last.size == 0) {
			stacks.remove(stacks.size() - 1);
		}
		return data;

	}

	public boolean isEmpty() {
		Stack last = getLastStack();
		return last.isEmpty();
	}
}