package com.pizza_group.project4;
import java.util.ArrayList;

public abstract class Pizza implements Customizable {
    private ArrayList<Topping> toppings;
    private Crust crust;
    private Size size;
    public abstract double price();

    public Pizza(ArrayList<Topping> toppings, Crust crust, Size size) {
        this.toppings = toppings;
        this.size = size;
        this.crust = crust;
    }
    public void setSizeToMedium() {
        size = Size.MEDIUM;
    }
    public void setSizeToLarge() {
        size = Size.LARGE;
    }
    public void setSizeToSmall() {
        size = Size.SMALL;
    }
    public Size getSize(){
        return size;
    }
}