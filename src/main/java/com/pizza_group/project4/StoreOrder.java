package com.pizza_group.project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StoreOrder implements Customizable {
    private final ObservableList<Order> orderList;

    public StoreOrder() {
        orderList = FXCollections.observableArrayList();
    }

}
