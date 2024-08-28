module com.coba_oop_all {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.coba_oop_all to javafx.fxml;
    exports com.coba_oop_all;
}
