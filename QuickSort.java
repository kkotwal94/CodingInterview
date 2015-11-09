class QuickSort {
	public int[] mainArr;

	public void swap(int arr[], int i, int j) {
		//System.out.println("I: " + i);
		//System.out.println("J: " + j);
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public int partition(int[] arr, int start, int end) {
		int pIndex = 0;
		int pivot = arr[end];
		for(int i = start; i < end; i++) {
			if(arr[i] <= pivot) {
				swap(arr, i, pIndex);
				pIndex++;
			}
		}
		//System.out.println("pIndex: " + pIndex);
		swap(arr, pIndex, end);
		return pIndex;
	}

	public void quickSort(int[] arr, int start, int end) {
		if(start > end) {
			return;
		}

		int pIndex = partition(arr, start, end);
		quickSort(arr, start, pIndex-1);
		quickSort(arr, pIndex+1, end);
	}

	public static void main(String[] args) {
		QuickSort qClass = new QuickSort();
		int[] arr =  { 1, 5, 3, 2, 6, 7, 8, 12, 3, 6, 33, 10};
		/*for(int i = 0; i< arr.length; i++) {
			System.out.println(arr[i]);
		}*/
		qClass.quickSort(arr, 0, arr.length-1);
	}
}