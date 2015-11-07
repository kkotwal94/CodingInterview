package Queues;
import java.util.*;

class Main {
	
	public static void main(String[] args) {
		Queue<Integer> mQueue = new Queue<Integer>();

		mQueue.add(6);
		mQueue.add(12);
		mQueue.add(16);
		mQueue.add(3);
		mQueue.add(7);
		System.out.println(mQueue.peek());
		mQueue.remove();
		mQueue.remove();
		System.out.println(mQueue.peek());
	}
}