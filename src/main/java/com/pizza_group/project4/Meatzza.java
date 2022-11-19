package com.pizza_group.project4;

import java.util.ArrayList;
import java.util.Arrays;

public class Meatzza extends Pizza {
    private final double meatzzaPrice;
    private static final ArrayList<Topping> toppings = new ArrayList<>(Arrays.asList(Topping.SAUSAGE, Topping.PEPPERONI, Topping.BEEF, Topping.HAM));
    public Meatzza(Size size, Crust crust) {
        super(toppings, crust, size);
        this.meatzzaPrice = setMeatzzaPrice(size);
    }
    public Meatzza(Crust crust) {
        super(toppings, crust, Size.SMALL);
        this.meatzzaPrice = setMeatzzaPrice(Size.SMALL);
    }
    public double setMeatzzaPrice(Size size) {
        if (size.equals(Size.SMALL))  {
            return 15.99;
        }
        if (size.equals(Size.MEDIUM)) {
            return 17.99;
        }
        return 19.99;
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
        return this.meatzzaPrice;
    }
}
