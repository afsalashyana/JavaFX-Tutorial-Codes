module com.genuinecoder.javafxcircularscenetransition {
  requires javafx.controls;
  requires javafx.fxml;

  opens com.genuinecoder.javafxcircularscenetransition to javafx.fxml;
  exports com.genuinecoder.javafxcircularscenetransition;
  exports com.genuinecoder.javafxcircularscenetransition.scene1;
  opens com.genuinecoder.javafxcircularscenetransition.scene1 to javafx.fxml;
  opens com.genuinecoder.javafxcircularscenetransition.scene2 to javafx.fxml;
}