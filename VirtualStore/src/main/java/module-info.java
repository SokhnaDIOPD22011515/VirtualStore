module ticket_de_caisse {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens ticket_de_caisse to javafx.fxml;
    exports ticket_de_caisse;

}
