package com.pizza_group.project4;

public class ChicagoPizza implements PizzaFactory{

    public Pizza createDeluxe() {
        Pizza deluxePizza = new Deluxe(Crust.DEEPDISH);
        return deluxePizza;
    }
    public Pizza createBBQChicken() {
        Pizza bbqPizza = new BBQChicken(Crust.PAN);
        return bbqPizza;
    }
    public Pizza createMeatzza() {
        Pizza meatPizza = new Meatzza(Crust.STUFFED);
        return meatPizza;
    }

    public Pizza createBuildYourOwn() {
        Pizza byoPizza = new BuildYourOwn(Crust.PAN);
        return byoPizza;
    }

}
