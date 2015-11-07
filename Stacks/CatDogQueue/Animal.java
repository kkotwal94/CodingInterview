package CatDogQueue;

public abstract class Animal {

public String name;
public int age;
public int order;

public Animal (String name, int age) {
this.name = name;
this.age = age;
}

public abstract String getName();

public void setOrder(int ord) {
	order = ord;
}

public int getOrder() {
	return order;
}

public boolean isOlderThan(Animal a) {
		return this.order < a.getOrder();
	}
}



