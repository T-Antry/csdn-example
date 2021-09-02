package org.antry;

public class Cat implements Animal {
    private String name = "Cat";
    @Override
    public void eat(Food food) {
        System.out.print(name+"的食物是"+food.getFoodName());
    }
}
