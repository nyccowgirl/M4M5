module com.example.m4m5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.m4m5 to javafx.fxml;
    exports com.example.m4m5;
}