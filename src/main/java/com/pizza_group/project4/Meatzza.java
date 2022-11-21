package com.pizza_group.project4;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * Meatzza class handles all Deluxe pizza specific operations in relation to setting the size price and
 * calculating price.
 * @author Alexis Wilson, James Alba
 */
public class Meatzza extends Pizza {
    private double meatzzaPrice;
    private static final ArrayList<Topping> toppings = new ArrayList<>(Arrays.asList(Topping.SAUSAGE, Topping.PEPPERONI, Topping.BEEF, Topping.HAM));
    /**
     * Constructor that sets toppings, crust, and size from superclass Pizza. Also, sets price with default size SMALL.
     * @param crust crust enum to create a pizza for different styles
     */
    public Meatzza(Crust crust) {
        super(toppings, crust, Size.SMALL);
        this.meatzzaPrice = setMeatzzaPrice(Size.SMALL);
    }
    /**
     * Calculates the price of a Meatzza pizza given a size. Returns 0 if no size is picked.
     * @param size the chosen size of the pizza
     * @return price of pizza according to size
     */
    public double setMeatzzaPrice(Size size) {
        if (size.equals(Size.SMALL))  {
            return 15.99;
        } else if (size.equals(Size.MEDIUM)) {
            return 17.99;
        }else if (size.equals(Size.LARGE)) {
            return 19.99;
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
        meatzzaPrice = setMeatzzaPrice(getSize());
        return meatzzaPrice;
    }

    @Override
    public String toString() {
        return "Meatzza (" + getCrust().getPizzaStyle() + " Style - " + getCrust().toString() + "), " + getToppings() + " " + getSize().toString() + " $" + price();
    }
}
