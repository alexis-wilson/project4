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
    ObservableList currentOrder;

    @FXML
    ObservableList orderIDList;

    @FXML
    ComboBox orderID;

    @FXML
    private ListView<Order> currentOrderOutput;


    private MainController mainController;

    @FXML
    void initialize()
    {
        //Initialize combo box with number of orders dynamically
        setComboBox();
        orderTotal.appendText("$0.00");
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    private void setComboBox() {
        if (!(orderID.getValue() == null)) {
            orderIDList = FXCollections.observableArrayList();
            for (int i = 0; i < mainController.getStoreOrders().size(); i++) {
                orderIDList.add(mainController.getStoreOrders().getOrder(i).getOrderNumber());
            }
            orderID.setItems(orderIDList);
        }
    }

    @FXML
    protected void selectOrderNumber(ActionEvent event) {
        if(!(orderID.getValue() == null)) {
            int currentOrderID = orderID.getSelectionModel().getSelectedIndex();
            if(currentOrderID == -1) {
                return;
            }
            setThisOrderContentField(currentOrderID);
        }
    }

    private void setThisOrderContentField(int cOrderID) {
        currentOrder = FXCollections.observableArrayList();
        currentOrderOutput.setItems(currentOrder);
        currentOrder.add(mainController.getStoreOrders().getOrder(cOrderID).toString());
        orderTotal.clear();
        orderTotal.appendText(String.format("$%,.2f", mainController.getStoreOrders().getOrder(cOrderID).orderTotalPrice()));
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
        if(orderID.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("No order selected, cannot remove.");
            alert.showAndWait();
        }
        else {

        }
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
