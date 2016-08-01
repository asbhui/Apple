package com.msm.test.service;

import com.msm.test.exceptions.BadFruitException;
import com.msm.test.fruits.Apple;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * Created by asbhui on 01/08/2016.
 */
public class FiveADay {

    private Validator validator;

    public FiveADay(){

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }


    public Apple eatApple(Apple apple) throws BadFruitException {


        final Set<ConstraintViolation<Apple>> validate = validator.validate(apple);

        //Validate all the input fields.
        if(!validate.isEmpty())
        {
            throw new BadFruitException(validate.iterator().next().getMessage());
        }

        return apple;
    }
}
