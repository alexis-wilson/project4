package com.pizza_group.project4;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.Enumeration;

public class NYStylePizzaController {
    private MainController mainController;
    @FXML
    private ToggleGroup pizzaSizeSelection;
    @FXML
    private ComboBox pizzaFlavors;
    @FXML
    private RadioButton smallPizza;
    @FXML
    private RadioButton mediumPizza;
    @FXML
    private RadioButton largePizza;
    @FXML
    private TextField crustOutput;
    @FXML
    private ListView availableToppings;
    @FXML
    private ListView selectedToppings;
    @FXML
    private TextField pizzaPriceOutput;
    @FXML
    private Button addToppingButton;
    @FXML
    private Button removeSelectedTopping;
    @FXML
    private Button addPizzaToOrder;
    PizzaFactory pizzaFactory = new NYPizza();
    Pizza pizza;
    ObservableList<String> toppingList = FXCollections.observableArrayList();
    private int counter = 0;
    public void initialize() {
        ObservableList<String> list = FXCollections.observableArrayList("Build Your Own", "BBQ Chicken", "Meatzza", "Deluxe");
        pizzaFlavors.setItems(list);
        pizzaFlavors.setValue("Build Your Own");
        crustOutput.setText(Crust.HANDTOSSED.name());
        pizza = pizzaFactory.createBuildYourOwn();
        Topping obj = Topping.SPINACH;
        availableToppings.setItems(obj.getAllToppings());
        availableToppings.setDisable(false);
        addToppingButton.setDisable(false);
        removeSelectedTopping.setDisable(false);
        pizzaPriceOutput.setText(Double.toString(pizza.price()));

    }
    public void createMainController(MainController mainController){
        this.mainController = mainController;
        initialize();
    }
    public void switchFlavors() { //break up later
        if(pizzaFlavors.getValue() == "Build Your Own") {
            addToppingButton.setDisable(false);
            removeSelectedTopping.setDisable(false);
            crustOutput.setText(Crust.HANDTOSSED.name());
            pizza = pizzaFactory.createBuildYourOwn();
            pizzaSizeSelection.selectToggle(smallPizza);
            Topping obj = Topping.SPINACH;
            availableToppings.setItems(obj.getAllToppings());
            availableToppings.setDisable(false);
            updatePriceOutput();
            //also need to change image for every change of flavor
        }else if(pizzaFlavors.getValue() == "BBQ Chicken") {
            addToppingButton.setDisable(true);
            removeSelectedTopping.setDisable(true);
            crustOutput.setText(Crust.THIN.name());
            pizza = pizzaFactory.createBBQChicken();
            pizzaSizeSelection.selectToggle(smallPizza);
            ObservableList<String> items =FXCollections.observableArrayList(Topping.BBQ_CHICKEN.toString(),
                    Topping.GREEN_PEPPER.toString(), Topping.PROVOLONE.toString(), Topping.CHEDDAR.toString());
            availableToppings.setItems(items);
            availableToppings.setDisable(true);
            pizzaPriceOutput.setText(Double.toString(pizza.price()));
        }else if(pizzaFlavors.getValue() == "Meatzza") {
            addToppingButton.setDisable(true);
            removeSelectedTopping.setDisable(true);
            crustOutput.setText(Crust.HANDTOSSED.name());
            pizzaSizeSelection.selectToggle(smallPizza);
            pizza = pizzaFactory.createMeatzza();
            ObservableList<String> items =FXCollections.observableArrayList(Topping.SAUSAGE.toString(), Topping.PEPPERONI.toString(),
                    Topping.BEEF.toString(), Topping.HAM.toString());
            availableToppings.setItems(items);
            availableToppings.setDisable(true);
            updatePriceOutput();
        }else if(pizzaFlavors.getValue() == "Deluxe") {
            addToppingButton.setDisable(true);
            removeSelectedTopping.setDisable(true);
            crustOutput.setText(Crust.BROOKLYN.name());
            pizzaSizeSelection.selectToggle(smallPizza);
            pizza = pizzaFactory.createDeluxe();
            ObservableList<String> items =FXCollections.observableArrayList(Topping.SAUSAGE.toString(), Topping.PEPPERONI.toString(),
                    Topping.GREEN_PEPPER.toString(), Topping.ONION.toString(), Topping.MUSHROOM.toString());
            availableToppings.setItems(items);
            availableToppings.setDisable(true);
           updatePriceOutput();
        }
    }
    public void changeSizeToMedium() {
            pizza.setSizeToMedium();
            updatePriceOutput();
        }
        public void changeSizeToLarge() {
            pizza.setSizeToLarge();
            updatePriceOutput();
        }
        public void changeSizeToSmall(){
            pizza.setSizeToSmall();
           updatePriceOutput();
        }
        public void updatePriceOutput() {
        pizzaPriceOutput.setText(Double.toString(pizza.price()));
        }

    public void addToppings() { //for use with build your own ONLY
        if(counter < 7) {
            String selectedTopping = availableToppings.getSelectionModel().getSelectedItem().toString();
            int index = availableToppings.getSelectionModel().getSelectedIndex();
            availableToppings.getItems().remove(index);
            toppingList.add(selectedTopping);
            selectedToppings.setItems(toppingList);
            Topping top = Topping.valueOf(selectedTopping);
            pizza.add(top);
            updatePriceOutput();
            counter++;
        }else {
            addToppingButton.setDisable(true);
        }
    }
    public void removeTopping() { //in theory, works. needs something to disable button when empty
        //update price
        //add item back to available toppings
        if (selectedToppings.getItems().size() != 0) {
            String selectedRemovedTopping = selectedToppings.getSelectionModel().getSelectedItem().toString();
            int index = selectedToppings.getSelectionModel().getSelectedIndex();
            selectedToppings.getItems().remove(index);
            toppingList.remove(selectedRemovedTopping);
            ObservableList<String> temp = availableToppings.getItems();
            temp.add(selectedRemovedTopping);
            availableToppings.setItems(temp);
            Topping top = Topping.valueOf(selectedRemovedTopping);
            pizza.remove(top);
            updatePriceOutput();
            counter--;
        }
    }
    public void addToOrder() {
        mainController.getTotalOrder().add(pizza);
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Pizza added to order!");
        a.show();
    }


}
