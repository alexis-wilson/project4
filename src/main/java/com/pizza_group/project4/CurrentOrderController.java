package com.pizza_group.project4;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class CurrentOrderController {


    @FXML
    private ListView<Pizza> totalOrderOutput;

    @FXML
    TextField subTotal;

    @FXML
    TextField salesTax;

    @FXML
    TextField orderTotal;

    @FXML
    TextField orderNumber;

    private MainController mainController;

    public void createMainController(MainController mainController){
        this.mainController = mainController;
        totalOrderOutput.setItems(mainController.getOrderObservableList());
        updateOrders();
    }

    public void updateOrders() {
        ObservableList<Pizza> newOrders = FXCollections.observableArrayList();
        newOrders.setAll(mainController.getOrderObservableList());
        totalOrderOutput.setItems(newOrders);
       // salesTax.setText((String.format("%.2f",)));
       // subTotal.setText((String.format("%.2f", )));
       // orderTotal.setText((String.format("%.2f", )));
    }

    @FXML
    protected void placeOrder() {

    }

    @FXML
    protected void clearOrder() {

    }

    @FXML
    protected void removePizza() {

    }

}
