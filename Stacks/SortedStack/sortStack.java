//package SortedStack;

import java.util.*;




class sortStack {

	//function to sort stack in ascending order, so topmost stack must be the largest
	private int[] numbers;
	private int[] helper;

	private int size;

	public void sort(int[] values) {
		this.numbers = values;	 //setting our number array to values
		size = values.length; //setting a int for our values
		this.helper = new int[size];
		mergeSort(0, size - 1);
	}

	public void mergeSort(int low, int high) {
		//check if low is smaller than high
		if(low < high) {
			int mid = low + (high - low) / 2;

			//Sort the left
			mergeSort(low, mid);

			//Sort the right
			mergeSort(mid+1, high);

			//combine all these back up
			merge(low, mid, high);
		}
	}

	public void merge(int low, int mid, int high) {
		for(int i= low; i <= high; i++) {
			helper[i] = numbers[i]; //copy into helper
		}

		int i = low;
		int j = mid + 1;
		int k = low;

		//copy from left and right back to either side of orig array
		while(i<= mid && j <= high) {
		if (helper[i] <= helper[j]) {
			numbers[k] = helper[i];
			i++;
		} else {
			numbers[k] = helper[j];
			j++;
		}
		k++;
	}

	while(i <= mid) {
		numbers[k] = helper[i];
		k++;
		i++;
	}
}

	public void sortStacks(Stack<Integer> someStack) {
		int size = someStack.size();
		int jamba[] = new int[size];
		int i = 0;
		while(!someStack.isEmpty()) {
			jamba[i] = someStack.pop();
			i++;
		}
		for(int z = 0; z < jamba.length; z++) {
			System.out.println(jamba[z]);
		}
		sort(jamba);

		for(int y = 0; y < numbers.length; y++) {
			System.out.println(numbers[y]);
		}
	}

		Stack<Integer> mStack = new Stack<Integer>();
		
	
	public static void main(String[] args) {
		sortStack mStacks = new sortStack();
		mStacks.mStack.push(12);
		mStacks.mStack.push(3);
		mStacks.mStack.push(7);
		mStacks.mStack.push(1);
		mStacks.mStack.push(8);
		mStacks.sortStacks(mStacks.mStack);
	}
}