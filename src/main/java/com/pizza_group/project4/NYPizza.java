package com.pizza_group.project4;

public class NYPizza implements PizzaFactory{

    public Pizza createDeluxe() {
        Pizza deluxePizza = new Deluxe(Crust.BROOKLYN);
        return deluxePizza;
    }
    public Pizza createBBQChicken() {
        Pizza bbqPizza = new BBQChicken(Crust.THIN);
        return bbqPizza;
    }
    public Pizza createMeatzza() {
        Pizza meatPizza = new Meatzza(Crust.HANDTOSSED);
        return meatPizza;
    }
    public Pizza createBuildYourOwn() {
        Pizza byoPizza = new BuildYourOwn(Crust.HANDTOSSED);
        return byoPizza;
    }
}
