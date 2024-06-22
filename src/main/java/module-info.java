module ec.edu.espol.proyectoed_g1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens ec.edu.espol.proyectoed_g1 to javafx.fxml;
    exports ec.edu.espol.proyectoed_g1;
}
