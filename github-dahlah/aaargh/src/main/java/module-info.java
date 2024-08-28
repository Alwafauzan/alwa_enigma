module com.herooo {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.kalku to javafx.fxml;
    exports com.kalku;
}
