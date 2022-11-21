package com.pizza_group.project4;
import java.util.ArrayList;

/**
 * Pizza class contains all general information shared among pizzas as well as functions to implement Customizable.
 * @author Alexis Wilson, James Alba
 */
public abstract class Pizza implements Customizable {
    private ArrayList<Topping> toppings;
    private Crust crust;
    private Size size;

    /**
     * An abstract function that subclasses must implement to calculate the price of the specific pizza.
     * @return price of the pizza
     */
    public abstract double price();

    /**
     * Constructor to create a pizza object with a given toppings, crust, and size
     * @param toppings arraylist of topping objects to hold toppings
     * @param crust crust of pizza
     * @param size size of pizza
     */
    public Pizza(ArrayList<Topping> toppings, Crust crust, Size size) {
        this.toppings = toppings;
        this.size = size;
        this.crust = crust;
    }

    /**
     * Sets the size of the pizza to medium
     */
    public void setSizeToMedium() {
        size = Size.MEDIUM;
    }
    /**
     * Sets the size of the pizza to large
     */
    public void setSizeToLarge() {
        size = Size.LARGE;
    }
    /**
     * Sets the size of the pizza to small
     */
    public void setSizeToSmall() {
        size = Size.SMALL;
    }

    /**
     * Gets the size of the pizza
     * @return size object containing the pizza
     */
    public Size getSize() {
        return size;
    }

    /**
     * Adds a topping to the pizza
     * @param obj object to be added to an object of the implemented class
     * @return returns true if topping added. Otherwise, returns false.
     */
    public boolean add(Object obj) {
        if (obj instanceof Topping) {
            Topping addedTop = (Topping) obj;
            toppings.add(addedTop);
            return true;
        }
        return false;
    }

    /**
     * Removes a topping the pizza
     * @param obj object to be removed to an object of the implemented class
     * @return returns true if topping removed. Otherwise, returns false.
     */
    public boolean remove(Object obj) {
        if (obj instanceof Topping) {
            Topping removedTop = (Topping) obj;
            toppings.remove(removedTop);
            return true;
        }
        return false;

    }
}