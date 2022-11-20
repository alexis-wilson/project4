package com.pizza_group.project4;
/**
 * Chicago Pizza creates the different flavors of Chicago Pizza and returns each pizza.
 * @author Alexis Wilson, James Alba
 */
public class ChicagoPizza implements PizzaFactory{
    /**
     * Creates a deluxe Chicago Style pizza
     * @return pizza object of specified flavor
     */
    public Pizza createDeluxe() {
        Pizza deluxePizza = new Deluxe(Crust.DEEPDISH);
        return deluxePizza;
    }
    /**
     * Creates a BBQ Chicken Chicago Style pizza
     * @return pizza object of specified flavor
     */
    public Pizza createBBQChicken() {
        Pizza bbqPizza = new BBQChicken(Crust.PAN);
        return bbqPizza;
    }
    /**
     * Creates a Meatzza Chicago Style pizza
     * @return pizza object of specified flavor
     */
    public Pizza createMeatzza() {
        Pizza meatPizza = new Meatzza(Crust.STUFFED);
        return meatPizza;
    }
    /**
     * Creates a BuildYourOwn Chicago Style pizza
     * @return pizza object of specified flavor
     */
    public Pizza createBuildYourOwn() {
        Pizza byoPizza = new BuildYourOwn(Crust.PAN);
        return byoPizza;
    }

}
