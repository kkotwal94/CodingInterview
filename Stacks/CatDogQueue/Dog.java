package CatDogQueue;
import java.util.*;

public class Dog extends Animal {

public Dog(String name, int age) {
	super(name, age);
}

public String getName() {
	return "Dog: " + name;
}
}