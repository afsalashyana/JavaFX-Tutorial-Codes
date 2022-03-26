module com.genuinecoder.javafxtask {
  requires javafx.controls;
  requires javafx.fxml;

  opens com.genuinecoder.javafxtask to javafx.fxml;
  exports com.genuinecoder.javafxtask;
}