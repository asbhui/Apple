package com.msm.test.utensils;

import com.msm.test.enums.PeelerType;
import com.msm.test.fruits.Apple;

/**
 * Created by asbhui on 01/08/2016.
 */
public class Peeler {
    private PeelerType peelerType;

    public Peeler(){
        peelerType = PeelerType.STEEL;
    }

    public Peeler(PeelerType peelerType) {
        this.peelerType = peelerType;
    }

    public PeelerType getPeelerType() {
        return peelerType;
    }

    public void peel(Apple apple) {
        apple.setPeeled(true);
    }
}

