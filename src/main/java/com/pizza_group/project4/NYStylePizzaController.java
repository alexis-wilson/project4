package com.pizza_group.project4;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * A controller class that handles all GUI operations in order to allow users to fully create a NY Style Pizza and
 * add it to their order.
 * @author Alexis Wilson, James Alba
 */
public class NYStylePizzaController {
    private MainController mainController;
    private static final int MAX_TOPPING = 7;
    @FXML
    private ToggleGroup pizzaSizeSelection;
    @FXML
    private ComboBox pizzaFlavors;
    @FXML
    private RadioButton smallPizza;
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
    private ImageView pizzaImage;
    private PizzaFactory pizzaFactory = new NYPizza();
    private Pizza pizza;
    private ObservableList<String> toppingList = FXCollections.observableArrayList();
    private int counter = 0;
    /**
     * The initialize method populates flavors into combo box and automatically picks "Build Your Own" flavor.
     */
    public void initialize() {
        ObservableList<String> list = FXCollections.observableArrayList("Build Your Own", "BBQ Chicken", "Meatzza", "Deluxe");
        pizzaFlavors.setItems(list);
        pizzaFlavors.setValue("Build Your Own");
        changeFlavorToBuildYourOwn();
        updatePriceOutput();
        changeImage();
    }
    /**
     *  createMainController makes the current controller as the main one for the user. Also, invokes the initialize
     *  method to populate window with appropriate information.
     * @param mainController passed in object to set controller as main
     */
    public void createMainController(MainController mainController){
        this.mainController = mainController;
        initialize();
    }
    /**
     * Changes the image displayed to the image of the flavor picked
     */
    public void changeImage(){
        if (pizzaFlavors.getValue() == "Build Your Own") {
            pizzaImage.setImage(new Image(NYStylePizzaController.class.getResource("assets/new-york-pizza-build-your-own.jpg").
                    toString()));
        } else if (pizzaFlavors.getValue() == "BBQ Chicken") {
            pizzaImage.setImage(new Image(NYStylePizzaController.class.getResource("assets/ny-style-bbq-chicken.jpg").
                    toString()));
        } else if (pizzaFlavors.getValue() == "Meatzza") {
            pizzaImage.setImage(new Image(NYStylePizzaController.class.getResource("assets/ny-style-meatzza.jpg").
                    toString()));
        } else if (pizzaFlavors.getValue() == "Deluxe") {
            pizzaImage.setImage(new Image(NYStylePizzaController.class.getResource("assets/deluxe-ny-pizza.jpg").
                    toString()));
        } else {
            pizzaImage.setImage(new Image(NYStylePizzaController.class.getResource("assets/new-york-style-pizza" +
                            "-default-view.jpg").toString()));
        }
    }
    /**
     * switchFlavors() gets the value of the flavor selection and invokes the appropiate methods for each flavor. Also,
     * depending on the flavor, invokes a method to set disable/enable elements
     */
    public void switchFlavors() {
        if(pizzaFlavors.getValue() == "Build Your Own") {
           changeFlavorToBuildYourOwn();
        }else if(pizzaFlavors.getValue() == "BBQ Chicken") {
            defaultSettings();
           changeFlavorToBBQChicken();
        }else if(pizzaFlavors.getValue() == "Meatzza") {
            defaultSettings();
           changeFlavorToMeatzza();
        }else if(pizzaFlavors.getValue() == "Deluxe") {
            defaultSettings();
           changeFlavorToDeluxe();
        }
    }
    /**
     * Sets certain elements to appropriate state for flavors BBQChicken, Meatzza, and Deluxe.
     */
    public void defaultSettings() {
        selectedToppings.getItems().clear();
        addToppingButton.setDisable(true);
        removeSelectedTopping.setDisable(true);
        availableToppings.setDisable(true);
        pizzaSizeSelection.selectToggle(smallPizza);
    }
    /**
     * changeFlavorToBuildYourOwn() sets settings for specific build your own functions, creates pizza, and populates list view of toppings.
     *  Also changes image and updates price
     */
    public void changeFlavorToBuildYourOwn() {
        addToppingButton.setDisable(false);
        removeSelectedTopping.setDisable(false);
        availableToppings.setDisable(false);
        pizzaSizeSelection.selectToggle(smallPizza);
        crustOutput.setText(Crust.HANDTOSSED.name());
         pizza = pizzaFactory.createBuildYourOwn();
        Topping obj = Topping.SPINACH; //random topping to access topping class
        availableToppings.setItems(obj.getAllToppings());
        updatePriceOutput();
        changeImage();
    }
    /**
     * changeFlavorToBBQChicken() sets up information in the topping view and crust output, and creates the pizza. Also,
     * changes images and updates price output.
     */
    public void changeFlavorToBBQChicken() {
        crustOutput.setText(Crust.THIN.name());
        pizza = pizzaFactory.createBBQChicken();
        ObservableList<String> items =FXCollections.observableArrayList(Topping.BBQ_CHICKEN.toString(),
                Topping.GREEN_PEPPER.toString(), Topping.PROVOLONE.toString(), Topping.CHEDDAR.toString());
        availableToppings.setItems(items);
        updatePriceOutput();
        changeImage();
    }
    /**
     * changeFlavorToMeatzza() sets up information in the topping view and crust output, and creates the pizza. Also,
     * changes images and updates price output.
     */
    public void changeFlavorToMeatzza(){
        crustOutput.setText(Crust.HANDTOSSED.name());
        pizza = pizzaFactory.createMeatzza();
        ObservableList<String> items =FXCollections.observableArrayList(Topping.SAUSAGE.toString(),
                Topping.PEPPERONI.toString(), Topping.BEEF.toString(), Topping.HAM.toString());
        availableToppings.setItems(items);
        updatePriceOutput();
        changeImage();
    }
    /**
     * changeFlavorToDeluxe() sets up information in the topping view and crust output, and creates the pizza. Also,
     * changes images and updates price output.
     */
    public void changeFlavorToDeluxe() {
        crustOutput.setText(Crust.BROOKLYN.name()); //set crust names
        pizza = pizzaFactory.createDeluxe(); //create pizza
        ObservableList<String> items =FXCollections.observableArrayList(Topping.SAUSAGE.toString(),
                Topping.PEPPERONI.toString(), Topping.GREEN_PEPPER.toString(), Topping.ONION.toString(),
                Topping.MUSHROOM.toString());
        availableToppings.setItems(items);
        updatePriceOutput();
        changeImage();
    }
    /**
     * Sets the size of the pizza to medium if the medium toggle is picked. Also, updates price.
     */
    public void changeSizeToMedium() {
            pizza.setSizeToMedium();
            updatePriceOutput();}
    /**
     * Sets the size of the pizza to large if the large toggle is picked. Also, updates price.
     */
    public void changeSizeToLarge() {
            pizza.setSizeToLarge();
            updatePriceOutput();
    }
    /**
     * Sets the size of the pizza to small if the large toggle is picked. Also, updates price.
     */
    public void changeSizeToSmall(){
            pizza.setSizeToSmall();
           updatePriceOutput();
    }
    /**
     * Calls pizza method to get the price of the current pizza and displays it in the price display text field.
     */
    public void updatePriceOutput() {pizzaPriceOutput.setText(String.format("%.2f", pizza.price()));}
    /**
     * addToppings() allows the selected topping be added to the selected toppings list view if user has less than 7 toppings.
     * Otherwise, locks button to add topping.
     */
    public void addToppings() { //for use with build your own ONLY
        if(counter < MAX_TOPPING && availableToppings.getSelectionModel().getSelectedItem() != null) {
            String selectedTopping = availableToppings.getSelectionModel().getSelectedItem().toString();
            int index = availableToppings.getSelectionModel().getSelectedIndex();
            availableToppings.getItems().remove(index);
            toppingList.add(selectedTopping);
            selectedToppings.setItems(toppingList);
            Topping top = Topping.valueOf(selectedTopping);
            pizza.add(top);
            updatePriceOutput();
            counter++;
        }else if(availableToppings.getSelectionModel().getSelectedItem() == null && counter < MAX_TOPPING) {
            Alert a = new Alert(Alert.AlertType.ERROR,"You must select a topping to add!");
            a.show();
        }else {
            Alert a = new Alert(Alert.AlertType.ERROR,"You have reached a max of 7 toppings!");
            a.show();
        }
    }
    /**
     * Removes a topping if there is available toppings to remove. Then, updates counter of toppings and price.
     */
    public void removeTopping() {
        if(selectedToppings.getItems().size() == 0) {
            Alert a = new Alert(Alert.AlertType.ERROR,"There are no toppings to remove.");
            a.show();
        }else if (selectedToppings.getSelectionModel().getSelectedItem() == null) {
            Alert a = new Alert(Alert.AlertType.ERROR,"You must select a topping to remove!");
            a.show();
        } else {
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
    /**
     * Calls order list from main controller method and add pizza to running order. Then, displays an alert that says
     * order was successfully added.
     */
    public void addToOrder() {
        mainController.getTotalOrder().add(pizza);
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Pizza added to order!");
        a.show();
    }

}
