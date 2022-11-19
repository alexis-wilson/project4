package com.pizza_group.project4;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class MainController {

    private int uniqueOrderNumber = 0;
    private final StoreOrder storeOrders = new StoreOrder();
    private final Order pizzaOrders = new Order();
    private Order totalOrder = new Order();
    @FXML
    private Button newYorkPizzaSelection;
    @FXML
    private Button chicagoPizzaSelection;
    @FXML
    private Button storeOrdersSelection;
    @FXML
    private Button myOrderSelection;
    protected void showCurrentOrders() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Current Order View.fxml"));
            Parent root1 = fxmlLoader.load();
            CurrentOrderController currentOrderController = fxmlLoader.getController();
            currentOrderController.createMainController(this);
            Stage stage = new Stage();
            stage.setTitle("Current Orders");
            stage.setScene(new Scene(root1));
          //  disableAllButtons();
            stage.show();
          //  stage.setOnCloseRequest(eventCalled -> enableAllButtons());
        } catch (Exception e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Error");
            errorAlert.setContentText(e.getMessage());
            errorAlert.showAndWait();
        }
    }
    @FXML
    protected void openNewPizza() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("NYStylePizzaOrderingView.fxml"));
            Parent root1 = fxmlLoader.load();
            NYStylePizzaController nyPizzaController = fxmlLoader.getController();
            nyPizzaController.createMainController(this);
            Stage stage = new Stage();
            stage.setTitle("NY Style Pizza Order");
            stage.setScene(new Scene(root1));
         //   disableAllButtons();
            stage.show();
         //   stage.setOnCloseRequest(eventCalled -> enableAllButtons());
        } catch (Exception e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Error");
            errorAlert.setContentText(e.getMessage());
            errorAlert.showAndWait();
            System.out.print(e.toString());
        }
    }
    public ObservableList<Pizza> getOrderObservableList() {
        totalOrder = new Order();
        totalOrder.getOrder().addAll(pizzaOrders.getOrder());
        return this.totalOrder.getOrder();
    }
/*
    public void enableAllButtons() {
        newYorkPizzaSelection.setDisable(false);
        chicagoPizzaSelection.setDisable(false);
        storeOrdersSelection.setDisable(false);
        myOrderSelection.setDisable(false);
    }

    public void disableAllButtons() {
       newYorkPizzaSelection.setDisable(true);
        chicagoPizzaSelection.setDisable(true);
        storeOrdersSelection.setDisable(true);
        myOrderSelection.setDisable(true);
    }

 */


}