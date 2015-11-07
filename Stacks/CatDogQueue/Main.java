package CatDogQueue;

import java.util.*;

class Main {

	public static void main(String[] args) {
		CatDogQueue animals = new CatDogQueue();
		animals.enqueue(new Cat("Callie", 3));
		animals.enqueue(new Cat("Kiki", 2));
		animals.enqueue(new Dog("Fido", 1));
		animals.enqueue(new Dog("Dora", 3));
		animals.enqueue(new Cat("Kari", 4));
		animals.enqueue(new Dog("Dexter", 7));
		animals.enqueue(new Dog("Dobo", 0));
		animals.enqueue(new Cat("Copa", 3));
		
		System.out.println(animals.dequeueAny().getName());	
		System.out.println(animals.dequeueAny().getName());	
		System.out.println(animals.dequeueAny().getName());	
		
		animals.enqueue(new Dog("Dapa", 2));
		animals.enqueue(new Cat("Kilo", 3));
		
		while (animals.size() != 0) {
			System.out.println(animals.dequeueAny().getName());	
		}
	}
}
