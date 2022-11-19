package com.pizza_group.project4;

import java.util.ArrayList;
import java.util.Arrays;

public class Deluxe extends Pizza {
    private double deluxePrice;
    private static final ArrayList<Topping> toppings = new ArrayList<>(Arrays.asList(Topping.SAUSAGE, Topping.PEPPERONI, Topping.GREEN_PEPPER, Topping.ONION, Topping.MUSHROOM));
    public Deluxe(Crust crust) { //default constructor; can change size later. for purposing of making a pizza w/o info
        super(toppings, crust, Size.SMALL);
        this.deluxePrice = setDeluxePrice(Size.SMALL);
    }

    public double setDeluxePrice(Size size) {
        if (size.equals(Size.SMALL))  {
            return 14.99;
        }
        else if (size.equals(Size.MEDIUM)) {
            return 16.99;
        } else if(size.equals(Size.LARGE)) {
            return 18.99;
        }
        return 0;
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
        deluxePrice = setDeluxePrice(getSize());
        return deluxePrice;
    }
}
