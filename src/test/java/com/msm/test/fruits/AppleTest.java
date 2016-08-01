package com.msm.test.fruits;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

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

    private static Validator validator;

    @BeforeClass
    public static void setupBeforeClass() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }


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

    /*
    Second Task is to validate bean
        weigh between 10g and 100g
     */

    @Test
    public void appleObject_WithNoErrors() {
        Apple apple = new Apple("Red", 100, 3);
        Set<ConstraintViolation<Apple>> validate = validator.validate(apple);
        assertEquals(0, validate.size());
    }

    @Test
    public void appleObject_RedWeight200Taste0_ReturnsValidationErrors() {
        Apple apple = new Apple("Red", 200, 0);
        Set<ConstraintViolation<Apple>> validate = validator.validate(apple);

        for (ConstraintViolation<Apple> constraintViolation : validate) {
            assertThat(constraintViolation.getMessage(), anyOf(equalTo("must be less than or equal to 100"),
                    equalTo("must be greater than or equal to 1")));
        }
    }

    @Test
    public void appleObject_RedWeight2Taste5_ReturnsValidationErrors() {
        Apple apple = new Apple("Red", 2, 5);
        Set<ConstraintViolation<Apple>> validate = validator.validate(apple);

        for (ConstraintViolation<Apple> constraintViolation : validate) {
            assertThat(constraintViolation.getMessage(), anyOf(equalTo("must be less than or equal to 4"),
                    equalTo("must be greater than or equal to 10")));
        }
    }
}
