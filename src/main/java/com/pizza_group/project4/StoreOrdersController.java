package com.pizza_group.project4;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class StoreOrdersController {

    @FXML
    TextField orderTotal;

    @FXML
    ObservableList orderList;

    @FXML
    ComboBox<Integer> orderNumber;

    @FXML
    ListView<Pizza> storeOrderOutput;

    private MainController mainController;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
        setComboBox();
        orderTotal.appendText("$0.00");
    }


    private void setComboBox() {
        orderList = FXCollections.observableArrayList();
        for (int i = 0; i < mainController.getStoreOrders().getSize(); i++) {
            orderList.add(mainController.getStoreOrders().getOrder(i).getOrderNumber());
        }
        orderNumber.setItems(orderList);
    }

    @FXML
    protected void selectOrderNumber() {
        if(orderNumber.getValue() != null) {
            int currentOrderID = orderNumber.getSelectionModel().getSelectedIndex();
            if (currentOrderID != -1) displayOrderInfo(currentOrderID);
        }
    }

    private void displayOrderInfo(int orderID) {
        ObservableList<Pizza> currentOrder = FXCollections.observableArrayList();
        currentOrder.setAll(mainController.getStoreOrders().getOrder(orderID).getOrderList());
        storeOrderOutput.setItems(currentOrder);
        orderTotal.clear();
        orderTotal.appendText(String.format("$%,.2f", mainController.getStoreOrders().getOrder(orderID).orderTotalPrice()));
    }

    @FXML
    protected void exportStoreOrders() {
        if (!mainController.getStoreOrderObservableList().isEmpty()) {
            FileChooser chooseExport = new FileChooser();
            chooseExport.setTitle("Choose where to export to");
            chooseExport.getExtensionFilters().add(new FileChooser.ExtensionFilter("ExportOrder", "*.txt"));
            Stage stage = new Stage();
            File file = chooseExport.showSaveDialog(stage);
            showExportResult(file);
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Cannot export no orders.");
            alert.showAndWait();
        }
    }

    @FXML
    protected void storeCancelOrders() {
        if(orderNumber.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("No order selected, cannot remove.");
            alert.showAndWait();
        }
        else {
            removeOrder();
        }
    }

    private void removeOrder() {
        orderTotal.clear();
        orderTotal.appendText("$0.00");
        int selectedOrderID = orderNumber.getSelectionModel().getSelectedItem();
        mainController.getStoreOrders().remove(mainController.getStoreOrders().getID(selectedOrderID));
        storeOrderOutput.getItems().clear();
        orderNumber.getItems().clear();
        setComboBox();
    }

    private void showExportResult(File file){
        Alert result = new Alert(Alert.AlertType.INFORMATION);
        if (mainController.getStoreOrders().export(file)) {
            result.setHeaderText("Export Order Success");
            result.setContentText("Successfully exported orders.");
        }
        else {
            result.setHeaderText("Error");
            result.setContentText("There was a problem exporting orders.");
        }
        result.show();
    }


}
