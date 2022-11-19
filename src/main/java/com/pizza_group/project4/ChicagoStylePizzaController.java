package com.pizza_group.project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ChicagoStylePizzaController {
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
    PizzaFactory pizza = new ChicagoPizza();
    Pizza p;
    ObservableList<String> toppingList = FXCollections.observableArrayList();
    private int counter = 0;
    public void initialize() {
        ObservableList<String> list = FXCollections.observableArrayList("Build Your Own", "BBQ Chicken", "Meatzza", "Deluxe");
        pizzaFlavors.setItems(list);
        pizzaFlavors.setValue("Build Your Own");
        crustOutput.setText(Crust.PAN.name());
        p = pizza.createBuildYourOwn();
        Topping obj = Topping.SPINACH;
        availableToppings.setItems(obj.getAllToppings());
        availableToppings.setDisable(false);
        pizzaPriceOutput.setText(Double.toString(p.price()));
        addToppingButton.setDisable(false);
        removeSelectedTopping.setDisable(false);
    }
    public void createMainController(MainController mainController){
        this.mainController = mainController;
        initialize();
    }
    public void switchFlavors() { //break up later
        if(pizzaFlavors.getValue() == "Build Your Own") {
            addToppingButton.setDisable(false);
            removeSelectedTopping.setDisable(false);
            crustOutput.setText(Crust.PAN.name());
            p = pizza.createBuildYourOwn();
            pizzaSizeSelection.selectToggle(smallPizza);
            Topping obj = Topping.SPINACH;
            availableToppings.setItems(obj.getAllToppings());
            availableToppings.setDisable(false);
            updatePriceOutput();
            //FIX IMAGES + CHANGE IMAGES AFTER EVERY FLAVOR CHANGE
        }else if(pizzaFlavors.getValue() == "BBQ Chicken") {
            addToppingButton.setDisable(true);
            removeSelectedTopping.setDisable(true);
            crustOutput.setText(Crust.PAN.name());
            p = pizza.createBBQChicken();
            pizzaSizeSelection.selectToggle(smallPizza);
            ObservableList<String> items =FXCollections.observableArrayList(Topping.BBQ_CHICKEN.toString(),
                    Topping.GREEN_PEPPER.toString(), Topping.PROVOLONE.toString(), Topping.CHEDDAR.toString());
            availableToppings.setItems(items);
            availableToppings.setDisable(true);
            pizzaPriceOutput.setText(Double.toString(p.price()));
        }else if(pizzaFlavors.getValue() == "Meatzza") {
            addToppingButton.setDisable(true);
            removeSelectedTopping.setDisable(true);
            crustOutput.setText(Crust.STUFFED.name());
            pizzaSizeSelection.selectToggle(smallPizza);
            p = pizza.createMeatzza();
            ObservableList<String> items =FXCollections.observableArrayList(Topping.SAUSAGE.toString(), Topping.PEPPERONI.toString(),
                    Topping.BEEF.toString(), Topping.HAM.toString());
            availableToppings.setItems(items);
            availableToppings.setDisable(true);
            updatePriceOutput();
        }else if(pizzaFlavors.getValue() == "Deluxe") {
            addToppingButton.setDisable(true);
            removeSelectedTopping.setDisable(true);
            crustOutput.setText(Crust.DEEPDISH.name());
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
        if (counter < 7) {
            String selectedTopping = availableToppings.getSelectionModel().getSelectedItem().toString();
            int index = availableToppings.getSelectionModel().getSelectedIndex();
            availableToppings.getItems().remove(index);
            toppingList.add(selectedTopping);
            selectedToppings.setItems(toppingList);
            Topping top = Topping.valueOf(selectedTopping);
            p.add(top);
            updatePriceOutput();
            counter++;
        } else {
            addToppingButton.setDisable(true);
        }
    }
    public void removeTopping() {
        //update price
        //add item back to available toppings
        if(selectedToppings.getItems().size() == 0) { ;
        }else {
            String selectedRemovedTopping = selectedToppings.getSelectionModel().getSelectedItem().toString();
            int index = selectedToppings.getSelectionModel().getSelectedIndex();
            selectedToppings.getItems().remove(index);
            toppingList.remove(selectedRemovedTopping);
            ObservableList<String> temp = availableToppings.getItems();
            temp.add(selectedRemovedTopping);
            availableToppings.setItems(temp);
            Topping top = Topping.valueOf(selectedRemovedTopping);
            p.remove(top);
            updatePriceOutput();
            counter--;
        }
    }
    public void addToOrder() {
        Order order = new Order();
        order.add(p);
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Pizza added to order!");
        a.show();
    }
}
