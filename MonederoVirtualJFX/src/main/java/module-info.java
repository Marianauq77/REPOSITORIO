module co.edu.uniquindio.poo.monederovirtualjfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.logging;

    opens co.edu.uniquindio.poo.monederovirtualjfx to javafx.fxml;
    exports co.edu.uniquindio.poo.monederovirtualjfx.model;
    exports co.edu.uniquindio.poo.monederovirtualjfx.app;
    exports co.edu.uniquindio.poo.monederovirtualjfx.viewController;
    exports co.edu.uniquindio.poo.monederovirtualjfx.controller;
    opens co.edu.uniquindio.poo.monederovirtualjfx.viewController to javafx.fxml;
}
