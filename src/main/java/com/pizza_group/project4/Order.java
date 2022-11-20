package com.pizza_group.project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Order implements Customizable {

    public static final double SALES_TAX = 0.06625;

    private ObservableList<Pizza> orderListView;

    private int orderNumber;
    public Order() { orderListView = FXCollections.observableArrayList();}

    @Override
    public boolean add(Object obj) {
        if (obj instanceof Pizza item) {
            orderListView.add(item);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object obj) {
        if (obj instanceof Pizza item) {
            orderListView.remove(item);
            return true;
        }
        return false;
    }

    public double orderTotalPrice() {
        double total = 0;
        for (Pizza item : orderListView) total += item.price();
        return total;
    }

    public ObservableList<Pizza> getOrder() {
        return orderListView;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getOrderNumber() {
        return orderNumber;
    }
    public String toString() {
        return "Order number: " + orderNumber + " Pizza(s) ordered: " + orderListView.toString();
    }

    public ObservableList<Pizza> getOrderList() {
        return this.orderListView;
    }
}
