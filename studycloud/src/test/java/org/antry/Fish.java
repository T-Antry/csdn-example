package org.antry;

public class Fish implements Food ,Animal{
    @Override
    public String getFoodName() {
        return "鱼";
    }

    @Override
    public void eat(Food food) {

    }
}
