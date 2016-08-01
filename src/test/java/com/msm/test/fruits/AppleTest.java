package com.msm.test.fruits;

import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * Created by asbhui on 01/08/2016.
 */
public class AppleTest {

    /*
    *   First task given
    *   Create an Apple
    */

    @Test
    public void createApple(){

        Apple apple = new Apple("Red", 50, 3);

        assertThat(apple,
                    allOf(
                            hasProperty("color", is(equalTo("Red"))),
                            hasProperty("weight", is(equalTo(50))),
                            hasProperty("taste", is(equalTo(3))),
                            hasProperty("worm", is(false)),
                            hasProperty("peeled", is(false)),
                            hasProperty("eaten", is(false))
                    )
        );

    }

}
