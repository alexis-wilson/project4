package com.pizza_group.project4;
import java.util.ArrayList;
/**
 * BuildYourOwn class handles all BuildYourOwn pizza specific operations in relation to setting the size price,
 * add/removing toppings, and calculating price.
 * @author Alexis Wilson, James Alba
 */
public class BuildYourOwn extends Pizza implements Customizable {
    private double BYOPrice;
    private static ArrayList<Topping> toppings = new ArrayList<>();
    /**
     * Constructor that sets toppings, crust, and size from superclass Pizza. Also, sets price with default size SMALL.
     * @param crust crust enum to create a pizza for different styles
     */
    public BuildYourOwn(Crust crust) {
        super(toppings, crust,Size.SMALL);
        this.BYOPrice  = setBYOPrice(Size.SMALL);
    }
    /**
     * Calculates the price of a Deluxe pizza given a size. Returns 0 if no size is picked.
     * @param size the chosen size of the pizza
     * @return price of pizza according to size
     */
    public double setBYOPrice(Size size) {
        if (size.equals(Size.SMALL))  {
           return 8.99;
        }else if (size.equals(Size.MEDIUM)) {
            return 10.99;
        }else if (size.equals(Size.LARGE)) {
            return 12.99;
        }
        return 0;
    }

    /**
     * toppingsPrice() calculates the total price of all toppings based on the size of the toppings arraylist.
     * @return price of all toppings added
     */
    private double toppingsPrice() {
        double total = 0;
        int counter = 0;
        while (counter < toppings.size()) {
            total += 1.59;
            counter++;
        }
        return total;
    }

    /**
     * Adds a topping to the pizza.
     * @param obj object to be added to the pizza
     * @return returns true if object is of class Topping. Otherwise, return false.
     */
    @Override
    public boolean add(Object obj) {
        if(obj instanceof Topping) {
            Topping top = (Topping)obj;
            toppings.add(top);
            return true;
        }
        return false;
    }
    /**
     * Removes a topping to the pizza.
     * @param obj object to be removed from the pizza
     * @return returns true if object is of class Topping. Otherwise, return false.
     */
    @Override
    public boolean remove(Object obj) {
        if (obj instanceof Topping) {
            Topping removedTop = (Topping) obj;
            toppings.remove(removedTop);
            return true;
        }
        return false;
    }
    /**
     * Calculates the price of the pizza based off the chosen size and amount of toppings and returns the total price.
     * @return pizza price
     */
    @Override
    public double price() {
        double toppingsTotal = toppingsPrice();
        double sizeTotal = setBYOPrice(getSize());
        BYOPrice = toppingsTotal + sizeTotal;
        return BYOPrice;
    }

    /**
     * Returns a string representation of the pizza object displaying all the information.
     * @return String representing the build your own pizza object displaying the name, toppings, and price.
     */
    @Override
    public String toString() {
        return "Build your own (" + getCrust().getPizzaStyle() + " Style - " + getCrust().toString() + "), " + getToppings() + " " + getSize().toString() + " $" + price();
    }
}
