package com.pizza_group.project4;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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
    PizzaFactory pizza = new NYPizza();
    Pizza p;
    ObservableList<String> toppingList = FXCollections.observableArrayList();
    int counter = 0;
    public void initialize() {
        ObservableList<String> list = FXCollections.observableArrayList("Build Your Own", "BBQ Chicken", "Meatzza", "Deluxe");
        pizzaFlavors.setItems(list);
        pizzaFlavors.setValue("Build Your Own");
        crustOutput.setText(Crust.HANDTOSSED.name());
        p = pizza.createBuildYourOwn();
        Topping obj = Topping.SPINACH;
        availableToppings.setItems(obj.getAllToppings());
        availableToppings.setDisable(false);
        pizzaPriceOutput.setText(Double.toString(p.price()));

    }
    public void createMainController(MainController mainController){
        this.mainController = mainController;
    }
    public void switchFlavors() {
        if(pizzaFlavors.getValue() == "Build Your Own") {
            crustOutput.setText(Crust.HANDTOSSED.name());
            p = pizza.createBuildYourOwn();
            pizzaSizeSelection.selectToggle(smallPizza);
            Topping obj = Topping.SPINACH;
            availableToppings.setItems(obj.getAllToppings());
            availableToppings.setDisable(false);
            updatePriceOutput();
            //also need to change image for every change of flavor
        }else if(pizzaFlavors.getValue() == "BBQ Chicken") {
            crustOutput.setText(Crust.THIN.name());
            p = pizza.createBBQChicken();
            pizzaSizeSelection.selectToggle(smallPizza);
            ObservableList<String> items =FXCollections.observableArrayList(Topping.BBQ_CHICKEN.toString(),
                    Topping.GREEN_PEPPER.toString(), Topping.PROVOLONE.toString(), Topping.CHEDDAR.toString());
            availableToppings.setItems(items);
            availableToppings.setDisable(true);
            pizzaPriceOutput.setText(Double.toString(p.price()));
        }else if(pizzaFlavors.getValue() == "Meatzza") {
            crustOutput.setText(Crust.HANDTOSSED.name());
            pizzaSizeSelection.selectToggle(smallPizza);
            p = pizza.createMeatzza();
            ObservableList<String> items =FXCollections.observableArrayList(Topping.SAUSAGE.toString(), Topping.PEPPERONI.toString(),
                    Topping.BEEF.toString(), Topping.HAM.toString());
            availableToppings.setItems(items);
            availableToppings.setDisable(true);
            updatePriceOutput();
        }else if(pizzaFlavors.getValue() == "Deluxe") {
            crustOutput.setText(Crust.BROOKLYN.name());
            pizzaSizeSelection.selectToggle(smallPizza);
            p = pizza.createDeluxe();
            ObservableList<String> items =FXCollections.observableArrayList(Topping.SAUSAGE.toString(), Topping.PEPPERONI.toString(),
                    Topping.GREEN_PEPPER.toString(), Topping.ONION.toString(), Topping.MUSHROOM.toString());
            availableToppings.setItems(items);
            availableToppings.setDisable(true);
           updatePriceOutput();
        }
    }
    public void changeSizeToMedium() {
            p.setSizeToMedium();
            updatePriceOutput();
        }
        public void changeSizeToLarge() {
            p.setSizeToLarge();
            updatePriceOutput();
        }
        public void changeSizeToSmall(){
            p.setSizeToSmall();
           updatePriceOutput();
        }
        public void updatePriceOutput() {
        pizzaPriceOutput.setText(Double.toString(p.price()));
        }

    public void addToppings() { //for use with build your own ONLY
        //addToppingButton.setDisable(false);
        if(counter < 7) {
            String selectedTopping = availableToppings.getSelectionModel().getSelectedItem().toString();

            int index = availableToppings.getSelectionModel().getSelectedIndex();
            availableToppings.getItems().remove(index);

            toppingList.add(selectedTopping);
            selectedToppings.setItems(toppingList);
           // System.out.println(selectedTopping);
            Topping top = Topping.valueOf(selectedTopping);
            //System.out.println(top);
            p.add(top); //freezing on use for no reason??
            updatePriceOutput();
            counter++;
        }else {
            addToppingButton.setDisable(true);
        }


    }
    public void removeTopping() {
        //update price
        //add item back to available toppings
    }
    public void addToOrder() {

    }


}
