package org.marsstudio.learn.design.cuisine.impl;

import org.marsstudio.learn.design.cook.ICook;
import org.marsstudio.learn.design.cuisine.ICuisine;

public class SiChuanCuisine implements ICuisine {

    private ICook cook;

    public SiChuanCuisine(ICook cook) {
        this.cook = cook;
    }

    @Override
    public void cook() {
        cook.doCooking();
    }
}
