package com.msm.test.fruits;

import com.msm.test.enums.Color;
import com.msm.test.exceptions.BadFruitException;
import com.msm.test.service.FiveADay;
import org.junit.Before;
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
    private FiveADay fiveADay;

    @BeforeClass
    public static void setupBeforeClass() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Before
    public void setupFiveADay()
    {
        fiveADay = new FiveADay();
    }

    @Test
    public void createApple(){

        Apple apple = new Apple(Color.RED, 50, 3);

        assertThat(apple,
                    allOf(
                            hasProperty("color", is(equalTo(Color.RED))),
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
        Apple apple = new Apple(Color.RED, 100, 3);
        Set<ConstraintViolation<Apple>> validate = validator.validate(apple);
        assertEquals(0, validate.size());
    }

    @Test
    public void appleObject_RedWeight200Taste0_ReturnsValidationErrors() {
        Apple apple = new Apple(Color.RED, 200, 0);
        Set<ConstraintViolation<Apple>> validate = validator.validate(apple);

        for (ConstraintViolation<Apple> constraintViolation : validate) {
            assertThat(constraintViolation.getMessage(), anyOf(equalTo("must be less than or equal to 100"),
                    equalTo("must be greater than or equal to 1")));
        }
    }

    @Test
    public void appleObject_RedWeight2Taste5_ReturnsValidationErrors() {
        Apple apple = new Apple(Color.RED, 2, 5);
        Set<ConstraintViolation<Apple>> validate = validator.validate(apple);

        for (ConstraintViolation<Apple> constraintViolation : validate) {
            assertThat(constraintViolation.getMessage(), anyOf(equalTo("must be less than or equal to 4"),
                    equalTo("must be greater than or equal to 10")));
        }
    }


    @Test
    public void apple_createUnpeeledRedAppleWithNoWormAndTasteAbove2_ReturnApple() throws BadFruitException {
        Apple apple = new Apple(Color.RED, 20, 2);
        assertThat(fiveADay.eatApple(apple),
                allOf(hasProperty("eaten", is(false)),
                        hasProperty("peeled", is(false)),
                        hasProperty("worm", is(false))
                ));
    }


    @Test(expected=BadFruitException.class)
    public void apple_createBadApple_throwException() throws BadFruitException{
        Apple apple = new Apple(Color.RED, 2, 5);
        fiveADay.eatApple(apple);
    }


    @Test
    public void apple_createUnpeeledRedAppleWithNoWormAndTaste4_ReturnApplePeeled() throws BadFruitException{
        Apple apple = new Apple(Color.RED, 60, 4);
        assertThat(fiveADay.eatApple(apple),
                allOf(hasProperty("eaten", is(true)),
                        hasProperty("peeled", is(true)),
                        hasProperty("worm", is(false))
                ));
    }

    @Test
    public void apple_createUnpeeledGreenAppleWithNoWormAndTaste4_ReturnApplePeeledAndEaten() throws BadFruitException{
        Apple apple = new Apple(Color.GREEN, 60, 4);
        assertThat(fiveADay.eatApple(apple),
                allOf(hasProperty("eaten", is(true)),
                        hasProperty("peeled", is(true)),
                        hasProperty("worm", is(false))
                ));
    }

    @Test
    public void apple_createUnpeeledRedAppleWithNoWormAndTasteAbove3_ReturnApplePeeledAndEaten() throws BadFruitException{
        Apple apple = new Apple(Color.RED, 20, 3);
        assertThat(fiveADay.eatApple(apple),
                allOf(hasProperty("eaten", is(true)),
                        hasProperty("peeled", is(true)),
                        hasProperty("worm", is(false))
                ));
    }


    @Test
    public void apple_createUnpeeledBlueAppleWithWormAndTasteAbove4_ReturnAppleWorm() throws BadFruitException{
        Apple apple = new Apple(Color.BLUE, 50, 4,true);
        assertThat(fiveADay.eatApple(apple),
                allOf(hasProperty("eaten", is(false)),
                        hasProperty("peeled", is(false)),
                        hasProperty("worm", is(true))
                ));
    }

    @Test
    public void apple_createPeeledBlueAppleWithNoWormAndTasteAbove4_ReturnApplePeeledAndEaten() throws BadFruitException{
        Apple apple = new Apple(Color.BLUE, 50, 4);
        apple.setPeeled(true);
        assertThat(fiveADay.eatApple(apple),
                allOf(hasProperty("eaten", is(true)),
                        hasProperty("peeled", is(true)),
                        hasProperty("worm", is(false))
                ));
    }


}
