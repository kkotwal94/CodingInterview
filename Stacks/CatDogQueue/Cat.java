package CatDogQueue;
import java.util.*;

public class Cat extends Animal {

	public Cat(String name, int age) {
		super(name, age);
	}

	public String getName() {
		return "Cat: " + name; 
	}
}