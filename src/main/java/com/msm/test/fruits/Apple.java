package com.msm.test.fruits;

import com.msm.test.enums.Color;

/**
 * Created by asbhui on 01/08/2016.
 */
public class Apple extends Fruit {

    private boolean worm;
    private boolean peeled;
    private boolean eaten;

    public Apple() {
    }

    public Apple(Color color, int weight, int taste) {
        super(color, weight, taste);
    }
    public Apple(Color color, int weight, int taste, boolean worm) {
        super(color, weight, taste);
        this.worm = worm;
    }

    /**
     * @return the worm
     */
    public boolean isWorm() {
        return worm;
    }

    /**
     * @param worm the worm to set
     */
    public Apple setWorm(boolean worm) {
        this.worm = worm;
        return this;
    }

    /**
     * @return the peeled
     */
    public boolean isPeeled() {
        return peeled;
    }

    /**
     * @param peeled the peeled to set
     */
    public Apple setPeeled(boolean peeled) {
        this.peeled = peeled;
        return this;
    }

    /**
     * @return the eaten
     */
    public boolean isEaten() {
        return eaten;
    }

    /**
     * @param eaten the eaten to set
     */
    public Apple setEaten(boolean eaten) {
        this.eaten = eaten;
        return this;
    }
}
