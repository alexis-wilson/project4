package com.pizza_group.project4;

import java.util.ArrayList;

public class BuildYourOwn extends Pizza implements Customizable {
    private double BYOPrice;
    private static ArrayList<Topping> toppings = new ArrayList<>();
    public BuildYourOwn(Crust crust) {
        super(toppings, crust,Size.SMALL);
        this.BYOPrice  = setBYOPrice(Size.SMALL);
    }

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

    private double toppingsPrice() {
        double total = 0;
        int counter = 0;
        System.out.println(toppings.size());
        while (counter < toppings.size()) {
            total += 1.59;
            counter++;
        }
        return total;
    }

    @Override
    public boolean add(Object obj)
    {
        if(!(obj instanceof Topping))
        {
            return false;
        }

        Topping top = (Topping)obj;
        toppings.add(top);
        return true;
    }

    @Override
    public boolean remove(Object obj) {
        if (obj instanceof Topping) {
            Topping removedTop = (Topping) obj;
            toppings.remove(removedTop);
            return true;
        }
        return false;
    }
    @Override
    public double price() {
        double toppingsTotal = toppingsPrice();
        double sizeTotal = setBYOPrice(getSize());
        BYOPrice = toppingsTotal + sizeTotal;
        return BYOPrice;
    }
}
