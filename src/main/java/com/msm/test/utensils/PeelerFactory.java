package com.msm.test.utensils;

import com.msm.test.enums.Color;
import org.apache.log4j.Logger;

/**
 * Created by asbhui on 01/08/2016.
 */
public class PeelerFactory {
    private static Logger log = Logger.getLogger(PeelerFactory.class);

    public static Peeler getPeeler(Color color) {

        if(color == Color.BLUE){
            log.info("Valyrain steel peeler is used");
            return new ValyrainPeeler();
        }

        log.info("Steel peeler is used");
        return new Peeler();
    }
}
