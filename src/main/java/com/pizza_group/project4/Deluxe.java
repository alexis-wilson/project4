package com.pizza_group.project4;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * Deluxe class handles all Deluxe pizza specific operations in relation to setting the size price and
 * calculating price.
 * @author Alexis Wilson, James Alba
 */
public class Deluxe extends Pizza {
    private double deluxePrice;
    private static final ArrayList<Topping> toppings = new ArrayList<>(Arrays.asList(Topping.SAUSAGE, Topping.PEPPERONI, Topping.GREEN_PEPPER, Topping.ONION, Topping.MUSHROOM));
    /**
     * Constructor that sets toppings, crust, and size from superclass Pizza. Also, sets price with default size SMALL.
     * @param crust crust enum to create a pizza for different styles
     */
    public Deluxe(Crust crust) {
        super(toppings, crust, Size.SMALL);
        this.deluxePrice = setDeluxePrice(Size.SMALL);
    }
    /**
     * Calculates the price of a Deluxe pizza given a size. Returns 0 if no size is picked.
     * @param size the chosen size of the pizza
     * @return price of pizza according to size
     */
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
    /**
     * Adds a topping to the pizza
     * @param obj object to add to pizza
     * @return returns boolean false, because pizza has preset toppings
     */
    @Override
    public boolean add(Object obj) {
        return false;
    }
    /**
     * Removes a topping to the pizza
     * @param obj object to remove to pizza
     * @return returns boolean false, because pizza has preset toppings
     */
    @Override
    public boolean remove(Object obj) {
        return false;
    }
    /**
     * Calculates the price of the pizza based off the chosen size and returns price.
     * @return pizza price
     */
    @Override
    public double price() {
        deluxePrice = setDeluxePrice(getSize());
        return deluxePrice;
    }
}
