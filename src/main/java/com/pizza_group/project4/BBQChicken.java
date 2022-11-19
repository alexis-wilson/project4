package com.pizza_group.project4;

import java.util.ArrayList;
import java.util.Arrays;

public class BBQChicken extends Pizza {
    private double BBQPrice;
    private static final ArrayList<Topping> toppings = new ArrayList<>(Arrays.asList(Topping.BBQ_CHICKEN, Topping.GREEN_PEPPER, Topping.PROVOLONE, Topping.CHEDDAR));
    public BBQChicken(Crust crust) {
        super(toppings, crust, Size.SMALL);
        this.BBQPrice = setBBQPrice(Size.SMALL);
    }
    public double setBBQPrice(Size size) {
        if (size.equals(Size.SMALL)) {
            return 13.99;
        } else if (size.equals(Size.MEDIUM)) {
            return 15.99;
        } else if (size.equals(Size.LARGE)) {
            return 17.99;
        } return 0;
    }
    public ArrayList<Topping> getToppings(){
        return toppings;
    }

    @Override
    public boolean add(Object obj) {
        return false;
    }

    @Override
    public boolean remove(Object obj) {
        return false;
    }


    @Override
    public double price() {
       BBQPrice = setBBQPrice(getSize());
       return BBQPrice;
    }
}
