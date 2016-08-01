package com.msm.test.fruits;

/**
 * Created by asbhui on 01/08/2016.
 */
public class Fruit {
    private String color;
    private int weight;
    private int taste;

    public Fruit() {

    }

    public Fruit(String color, int weight, int taste) {
        this.color = color;
        this.weight = weight;
        this.taste = taste;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getTaste() {
        return taste;
    }

    public void setTaste(int taste) {
        this.taste = taste;
    }
}
