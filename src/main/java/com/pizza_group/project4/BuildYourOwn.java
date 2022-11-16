package com.pizza_group.project4;

import java.util.ArrayList;

public class BuildYourOwn extends Pizza implements Customizable {
    private final double BYOPrice;
    private static ArrayList<Topping> toppings = new ArrayList<>();
    public BuildYourOwn(Size size, Crust crust) {
        super(toppings, crust, size);
        this.BYOPrice = setBYOPrice(size);
    }
    public BuildYourOwn(Crust crust) {
        super(toppings, crust, Size.SMALL);
        this.BYOPrice = setBYOPrice(Size.SMALL);
    }

    public double setBYOPrice(Size size) {
        if (size.equals(Size.SMALL))  {
            return 8.99 + toppingsPrice();
        }
        if (size.equals(Size.MEDIUM)) {
            return 10.99 + toppingsPrice();
        }
        return 12.99 + toppingsPrice();
    }

    private double toppingsPrice() {
        double total = 0;
        while (toppings.iterator().hasNext()) total += 1.59;
        return total;
    }

    @Override
    public boolean add(Object obj) {
        if (obj instanceof Topping) {
            toppings.add((Topping) obj);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object obj) {
        if (obj instanceof Topping) {
            toppings.remove(obj);
            return true;
        }
        return false;
    }


    @Override
    public double price() {
        return this.BYOPrice;
    }
}
