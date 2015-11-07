package CatDogQueue;

import java.util.*;

class CatDogQueue {

	LinkedList<Dog> dogs = new LinkedList<Dog>();
	LinkedList<Cat> cats = new LinkedList<Cat>();
	private int order = 0;

	public void enqueue(Animal a) {

		if(a instanceof Dog) {
			dogs.addLast((Dog)a);
			order++;
			a.setOrder(order);
		}

		if(a instanceof Cat) {
			cats.addLast((Cat)a);
			order++;
			a.setOrder(order);
		}

	}


	public Animal dequeueAny() {

		if (dogs.size() == 0) {
			return dequeueCats();
		} else if (cats.size() == 0) {
			return dequeueDogs();
		}

		if(dogs.peek().getOrder() < cats.peek().getOrder()) {
			return dogs.poll();
		}

		else {
			return cats.poll();
		}
	}

	public Dog dequeueDogs() {
		return dogs.poll();
	}

	public Cat dequeueCats() {
		return cats.poll();
	}

	public int size() {
		return dogs.size() + cats.size();
	}

	public Dog peekDogs() {
		return dogs.peek();
	}

	public Cat peekCats() {
		return cats.peek();
	}

}