module com.example._24card {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example._24card to javafx.fxml;
    exports com.example._24card;
}