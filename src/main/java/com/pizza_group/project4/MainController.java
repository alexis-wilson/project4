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
import java.io.IOException;

/**
 * MainController creates the main menu, holds methods for navigating to different windows, and methods for managing
 *  orders and pizzas.
 * @author Alexis Wilson, James Alba
 */
public class MainController {
    private int uniqueOrderNumber = 1;
    private final StoreOrder storeOrders = new StoreOrder();
    private final Order totalOrder = new Order();
    @FXML
    private Button newYorkPizzaSelection;
    @FXML
    private Button chicagoPizzaSelection;
    @FXML
    private Button storeOrdersSelection;
    @FXML
    private Button myOrderSelection;

    /**
     * showCurrentOrders() creates a new stage and sets root to proper fxml file for Current Order window.
     * Catches exceptions if unable to open stage.
     */
    @FXML
    protected void showCurrentOrders() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Current Order View.fxml"));
            Parent root = fxmlLoader.load();
            CurrentOrderController currentOrderController = fxmlLoader.getController();
            currentOrderController.createMainController(this);
            Stage stage = new Stage();
            stage.setTitle("Current Orders");
            stage.setScene(new Scene(root));
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

    /**
     * showStoresOrders() creates a new stage and sets root to proper fxml file for Store Order window.
     * Catches exception if unable to open window.
     */
    @FXML
    protected void showStoreOrders() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Store orders View.fxml"));
            Parent root2 = fxmlLoader.load();
            StoreOrdersController storeOrdersController = fxmlLoader.getController();
            storeOrdersController.setMainController(this);
            Stage stage = new Stage();
            stage.setTitle("Store Orders");
            stage.setScene(new Scene(root2));
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

    /**
     * openNewYorkPizza() creates a new stage and sets root to proper fxml file for New York Style Pizza Ordering View
     * window. Catches exception if unable to open window.
     */
    @FXML
    protected void openNewYorkPizza() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("NYStylePizzaOrderingView.fxml"));
            Parent root1 = fxmlLoader.load();
            NYStylePizzaController nyPizzaController = fxmlLoader.getController();
            nyPizzaController.createMainController(this);
            Stage stage = new Stage();
            stage.setTitle("NY Style Pizza Order");
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

    /**
     * Gets Order object for current total order
     * @return
     */
    public Order getTotalOrder() {
        return totalOrder;
    }
    /**
     * openChicagoPizza() creates a new stage and sets root to proper fxml file for Chicago Style Pizza Ordering View
     * window. Catches exception if unable to open window.
     */
    @FXML
    protected void openChicagoPizza() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Chicago Style Pizza Ordering View.fxml"));
            Parent root1 = fxmlLoader.load();
            ChicagoStylePizzaController chicagoPizzaController = fxmlLoader.getController();
            chicagoPizzaController.createMainController(this);
            Stage stage = new Stage();
            stage.setTitle("Chicago Style Pizza Order");
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

    /**
     *
     * @return
     */
    public ObservableList<Pizza> getOrderObservableList() {
        return totalOrder.getOrder();
    }

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

    public int getOrderNumber() {
        return uniqueOrderNumber;
    }

    public void addOrderNumber() {
        uniqueOrderNumber++;
    }

    public StoreOrder getStoreOrders() {
        return storeOrders;
    }

    public ObservableList<Order> getStoreOrderObservableList() {
        return storeOrders.getStoreOrderList();
    }

    public ObservableList<Pizza> getPizzaOrdersObservableList() {
        return totalOrder.getOrderList();
    }
}