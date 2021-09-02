package org.antry;

public class Dog implements Animal {
    private String name = "Dog";
    @Override
    public void eat(Food food) {
        System.out.print(name+"的食物是"+food.getFoodName());
    }
}
