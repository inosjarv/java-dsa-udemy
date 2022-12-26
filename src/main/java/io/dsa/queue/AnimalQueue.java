package io.dsa.queue;

import java.util.LinkedList;
import java.util.Queue;

abstract class Animal {
    protected String name;
    private int order;

    public Animal(String name) {
        this.name = name;
    }

    abstract String name();

    public int getOrder() {
        return this.order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isOlderThan(Animal other) {
        return this.order < other.getOrder();
    }
}

class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    public String name() {
        return "Cat: " + name;
    }
}

class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public String name() {
        return "Dog: " + name;
    }
}

public class AnimalQueue {
    Queue<Dog> dogs = new LinkedList<>();
    Queue<Cat> cats = new LinkedList<>();

    private int order = 0;

    public void enqueue(Animal animal) {
        animal.setOrder(order);
        this.order++;

        if (animal instanceof Dog)
            dogs.add((Dog) animal);
        else if (animal instanceof Cat)
            cats.add((Cat) animal);
    }

    public int size() {
        return dogs.size() + cats.size();
    }

    public Dog dequeueDogs() {
        return dogs.poll();
    }

    public Dog peekDogs() {
        return dogs.peek();
    }

    public Cat dequeueCats() {
        return cats.poll();
    }

    public Cat peekCats() {
        return cats.peek();
    }

    public Animal dequeueAny() {
        if (dogs.isEmpty()) return dequeueCats();
        if (cats.isEmpty()) return dequeueDogs();

        Dog dog = dogs.peek();
        Cat cat = cats.peek();

        return dog.isOlderThan(cat) ? dogs.poll() : cats.poll();
    }

    public Animal peek() {
        if (dogs.isEmpty()) return dequeueCats();
        if (cats.isEmpty()) return dequeueDogs();

        Dog dog = dogs.peek();
        Cat cat = cats.peek();

        return dog.isOlderThan(cat) ? dogs.peek() : cats.peek();
    }
}
