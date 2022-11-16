package com.pizza_group.project4;

public enum Topping {
    SAUSAGE,
    PEPPERONI,
    GREEN_PEPPER,
    ONION,
    MUSHROOM,
    BBQ_CHICKEN,
    PROVOLONE,
    CHEDDAR,
    BEEF,
    PINEAPPLE,
    BLACKOLIVES,
    SPINACH,
    BACON,
    HAM;

    public Topping getTopping(String topping) {
        for (Topping i : Topping.values()) {
            if (topping.equals(i.name())) {
                return i;
            }
        }
        return null;
    }
}
