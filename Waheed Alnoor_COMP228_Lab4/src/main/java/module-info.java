module Waheed_COMP228Lab4 {
    requires javafx.controls;
    requires javafx.fxml;

    opens exercise1 to javafx.fxml, javafx.graphics;
    exports exercise1;
}