package com.msm.test.service;

import com.msm.test.exceptions.BadFruitException;
import com.msm.test.fruits.Apple;
import org.apache.log4j.Logger;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * Created by asbhui on 01/08/2016.
 */
public class FiveADay {

    private Logger log = Logger.getLogger(FiveADay.class);
    private Validator validator;

    public FiveADay(){

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }


    public Apple eatApple(Apple apple) throws BadFruitException {
        log.info("In the method : eatApple");

        //Returns IllegalArgumentException is an argument apple is Null.
        if (null == apple){
            log.debug("apple not supplied");
            throw new IllegalArgumentException();
        }

        //Validate the apple object
        final Set<ConstraintViolation<Apple>> validate = validator.validate(apple);

        //Validate all the input fields.
        if(!validate.isEmpty())
        {
            throw new BadFruitException(validate.iterator().next().getMessage());
        }




        return apple;
    }
}
