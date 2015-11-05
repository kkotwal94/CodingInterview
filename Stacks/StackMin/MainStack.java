package	minStack2;

public class MainStack {

	public static void main(String[] args) {
		StackWithMin stack = new StackWithMin();
		stack.push(3);
		stack.push(6);
		stack.push(12);
		stack.push(2);
		stack.push(49);
		stack.pop();
		System.out.println(stack.min());
	}
}