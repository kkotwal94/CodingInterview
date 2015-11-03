import java.util.*;

class duplicateLinkedList {

/**
Write code to remove duplicates from an unsorted linked list.
FOLLOW UP
How would you solve this problem if a temporary buffer is not allowed?
**/

LinkedList test = new LinkedList();

//O(n) time O(n) space
public LinkedList duplicateChecker(LinkedList ll) {
	HashSet linkedSet = new HashSet();
	int length = ll.size();
	System.out.println("Size: " + length);
	if(length == 0) {
		System.out.println("We have a empty linked list");
		return ll;	
	}
	for(int i =0; i < length; i++) {
		if(!(linkedSet.contains(ll.get(i)))) {
			System.out.println("Adding: " + ll.get(i));
			linkedSet.add(ll.get(i));
		}
		else {
			System.out.println("Removing: " + ll.get(i));
			ll.remove(i);
			length = length - 1;
			i = i - 1;
		}
	}
	System.out.println(ll);
	return ll;
}

//O(n^2) time O(1) space
public LinkedList duplicateCheckerNoBuffer(LinkedList ll) {
	int length = ll.size();
	if(length == 0) {
		System.out.println("We have a empty linked list");
		return ll;
	}

	for(int i = 0; i < length; i++){
		Object node = ll.get(i);
		for(int j = i+1; j < length; j++) {
			if(node == ll.get(j)) {
				System.out.println("Removing: " + ll.get(j));
				ll.remove(j);
				j--;
				length--;
			}
		}
	}
	System.out.println(ll);
	return ll;
}


public static void main(String[] args){
	duplicateLinkedList linkedList = new duplicateLinkedList();
	linkedList.test.add("F");
	linkedList.test.add("B");
	linkedList.test.add("A");
	linkedList.test.add("F");
	linkedList.test.add("F");
	linkedList.test.add("F");
	linkedList.test.add("A");
	linkedList.test.add("B");
	linkedList.test.add(4);
	linkedList.test.add(3);
	linkedList.test.add(4);

	System.out.println("Original contents of ll: " + linkedList.test);
	//linkedList.duplicateChecker(linkedList.test);
	linkedList.duplicateCheckerNoBuffer(linkedList.test);
	
}

}