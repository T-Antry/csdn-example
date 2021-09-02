package org.antry;

public class Feeder {
    void feed(Animal animal,Food food){
        animal.eat(food);
    };

    public static void main(String[] args) {
        Feeder feeder = new Feeder();
        feeder.feed(new Dog(),new Bone());
        feeder.feed(new Cat(),new Fish());
    }
}
