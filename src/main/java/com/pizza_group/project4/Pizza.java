package com.pizza_group.project4;

public abstract class Pizza implements Customizable {
    private ArrayList<Topping> toppings;
    private Crust crust;
    private Size size;
    public abstract double price();
}