package SetofStacks;

class MainStack {


public static void main(String[] args) {

		int capacity = 6;
		SetofStacks set = new SetofStacks(capacity);
		for (int i = 0; i < 43; i++) {
			set.push(i);
		}
		for (int i = 0; i < 43; i++) {
			System.out.println("Popped " + set.pop());
		}		
	}

}


