module com.example._24card {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.compiler;


    opens com.example._24card to javafx.fxml;
    exports com.example._24card;
}