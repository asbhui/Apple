package com.msm.test.service;

import com.msm.test.exceptions.BadFruitException;
import com.msm.test.fruits.Apple;
import com.msm.test.utensils.Peeler;
import com.msm.test.utensils.PeelerFactory;
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

        //Check apple doesnt have any worms and taste should be better than 3
        if(!apple.isWorm() && apple.getTaste() >= 3){

            //Check if apple is peeled or not
            peelApple(apple);
        }

        //It was not clear in the instructions what this method has to return and what would be the final status of apple.
        //Assumption apple has to return with eaten state true.
        if(apple.isPeeled() && apple.isEaten()==false)
            apple.setEaten(true);

        return apple;
    }

    private void peelApple(Apple apple) {

        //Check if apple is not peeled before than get a peeler and peel the apple.
        if(apple.isPeeled() == false)
        {
            //Get the peeler
            final Peeler peeler = getPeeler(apple);
            peeler.peel(apple);
        }
    }

    public Peeler getPeeler(Apple apple){
        //Used factory to determine which peeler is required.
        return PeelerFactory.getPeeler(apple.getColor());
    }
}
