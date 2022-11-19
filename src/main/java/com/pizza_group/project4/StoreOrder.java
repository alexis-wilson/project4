package com.pizza_group.project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StoreOrder implements Customizable {
    private final ObservableList<Order> orderList;
    public StoreOrder() {
        orderList = FXCollections.observableArrayList();
    }
    @Override
    public boolean add(Object obj) {
        if(obj instanceof Order) {
            Order order = (Order)obj;
            orderList.add(order);
            return true;
        }
        return false;
    }
    @Override
    public boolean remove(Object obj) {
        if(obj instanceof Order) {
            Order order = (Order) obj;
            orderList.add(order);
            return true;
        }
        return false;
    }
}
