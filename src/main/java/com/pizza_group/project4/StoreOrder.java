package com.pizza_group.project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class StoreOrder implements Customizable {
    private final ObservableList<Order> orderList;

    public StoreOrder() {
        orderList = FXCollections.observableArrayList();
    }

    @Override
    public boolean add(Object obj) {
        if (obj instanceof Order order) {
            orderList.add(order);
            return true;
        }
        return false;
    }

    public boolean remove(Object obj) {
        if (obj instanceof Order order) {
            orderList.remove(order);
            return true;
        }
        return false;
    }

    public ObservableList<Order> getStoreOrderList() {
        return this.orderList;
    }

    public Order getOrder(int orderNumber) {
        for (Order p : orderList) {
            if (p.getOrderNumber() == orderNumber) return p;
        }
        return null;
    }

    public boolean export(File file) {
        try {
            FileWriter writeOrder = new FileWriter(file);
            for (Order order : orderList) {
                writeOrder.write(order.toString());
                writeOrder.write("\n");
            }
            writeOrder.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public int size() {
        return orderList.size();
    }

}
