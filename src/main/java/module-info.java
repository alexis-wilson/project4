module com.pizza_group.project4 {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.pizza_group.project4 to javafx.fxml;
    exports com.pizza_group.project4;
}