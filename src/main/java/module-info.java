module com.pizza_group.project4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;


    opens com.pizza_group.project4 to javafx.fxml;
    exports com.pizza_group.project4;
}