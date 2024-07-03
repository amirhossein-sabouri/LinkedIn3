module org.example.linkedin3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

opens org.example.linkedin3.Controller to javafx.fxml;
exports org.example.linkedin3.Controller;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires com.jfoenix;
    requires java.sql;

    opens org.example.linkedin3 to javafx.fxml;
    exports org.example.linkedin3;
    exports org.example.linkedin3.DataBase;
    opens org.example.linkedin3.DataBase to javafx.fxml;
    requires jdk.httpserver;

    requires com.google.gson;
    requires com.fasterxml.jackson.annotation;

}