import java.util.*;
class KthLastElement {


/**
Implement an algorithm to find the kth to last element of a singly linked list.
**/



LinkedList test = new LinkedList();

	//If we know size
	public LinkedList kthElement(LinkedList ll, int k) {
		int length = ll.size();
		if(k > length) {
			System.out.println("K is greater than the size of the linked list");
		}
		int check = length - k;
			Object node = ll.get(check);
			System.out.println(node);

		return ll;
	}
		

	//if we don't know size
	public LinkedList kthElement2(LinkedList ll, int k) {
		k = k - 1;
		int i = 0;
		Object p2 = ll.get(k);
		Object p1 = ll.get(i);
		while(p2!=null) {
			if(ll.get(k+i) == null) {
				System.out.println(p1);
				return ll;
			}
			p2 = ll.get(k+i);
			p1 = ll.get(i);
			i++;
		} 

		System.out.println(p1);
		return ll;
	}

	public static void main(String[] args) {
		KthLastElement ktol = new KthLastElement();
		ktol.test.add("A1");
		ktol.test.add("B2");
		ktol.test.add("C3");
		ktol.test.add("D4");
		ktol.test.add("E5");
		ktol.test.add("F6");
		System.out.println(ktol.test);
		ktol.kthElement(ktol.test, 3);
		//ktol.kthElement2(ktol.test, 3);
	}
}