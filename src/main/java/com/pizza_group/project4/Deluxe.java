package com.pizza_group.project4;

import java.util.ArrayList;
import java.util.Arrays;

public class Deluxe extends Pizza {
    private final double deluxePrice;
    private static final ArrayList<Topping> toppings = new ArrayList<>(Arrays.asList(Topping.SAUSAGE, Topping.PEPPERONI, Topping.GREEN_PEPPER, Topping.ONION, Topping.MUSHROOM));
    public Deluxe(Size size, Crust crust) {
        super(toppings, crust, size);
        this.deluxePrice = setDeluxePrice(size);
    }
    public Deluxe(Crust crust) { //default constructor; can change size later. for purposing of making a pizza w/o info
        super(toppings, crust, Size.SMALL);
        this.deluxePrice = setDeluxePrice(Size.SMALL);
    }

    public double setDeluxePrice(Size size) {
        if (size.equals(Size.SMALL))  {
            return 14.99;
        }
        if (size.equals(Size.MEDIUM)) {
            return 16.99;
        }
        return 18.99;
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
        return this.deluxePrice;
    }
}
