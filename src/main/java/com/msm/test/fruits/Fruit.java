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

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public Fruit setColor(String color) {
        this.color = color;
        return this;
    }

    /**
     * @return the weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public Fruit setWeight(int weight) {
        this.weight = weight;
        return this;
    }

    /**
     * @return the taste
     */
    public int getTaste() {
        return taste;
    }

    /**
     * @param taste the taste to set
     */
    public Fruit setTaste(int taste) {
        this.taste = taste;
        return this;
    }
}
