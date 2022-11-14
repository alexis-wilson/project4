package com.pizza_group.project4;

public enum Crust {
    BROOKLYN("NEWYORK"),
    THIN("NEWYORK"),
    HANDTOSSED("NEWYORK"),
    DEEPDISH("CHICAGO"),
    PAN("CHICAGO"),
    STUFFED("CHICAGO");

    private final String pizzaStyle;

    Crust(String pizzaStyle) {
        this.pizzaStyle = pizzaStyle;
    }

    public String getPizzaStyle() {
        return pizzaStyle;
    }

}
