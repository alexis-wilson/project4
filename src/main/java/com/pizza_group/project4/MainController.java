package com.pizza_group.project4;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainController {
    @FXML
    private Label welcomeText;

    private int uniqueOrderNumber = 0;
    private final StoreOrder storeOrders = new StoreOrder();
    private final Order pizzaOrders = new Order();
    private Order totalOrder = new Order();

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void showCurrentOrders() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Current Order View.fxml"));
            Parent root1 = fxmlLoader.load();
            CurrentOrderController currentOrderController = fxmlLoader.getController();
            currentOrderController.createMainController(this);
            Stage stage = new Stage();
            stage.setTitle("Current Orders");
            stage.setScene(new Scene(root1));
            disableAllButtons();
            stage.show();
            stage.setOnCloseRequest(eventCalled -> enableAllButtons());
        } catch (Exception e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Error");
            errorAlert.setContentText(e.getMessage());
            errorAlert.showAndWait();
        }
    }

    public ObservableList<Pizza> getOrderObservableList() {
        totalOrder = new Order();
        totalOrder.getOrder().addAll(pizzaOrders.getOrder());
        return this.totalOrder.getOrder();
    }

    public void enableAllButtons() {
        orderNY.setDisable(false);
        orderChicago.setDisable(false);
        showStoreOrders.setDisable(false);
        showCurrentOrders.setDisable(false);
    }

    public void disableAllButtons() {
        orderNY.setDisable(true);
        orderChicago.setDisable(true);
        showStoreOrders.setDisable(true);
        showCurrentOrders.setDisable(true);
    }
}