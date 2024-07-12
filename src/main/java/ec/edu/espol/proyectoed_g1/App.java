package ec.edu.espol.proyectoed_g1;

import ec.edu.espol.proyectoed_g1.modelo.clases.*;
import ec.edu.espol.proyectoed_g1.modelo.Listas.CircularDoublyLinkedList;
import ec.edu.espol.proyectoed_g1.modelo.Listas.DoublyLinkedList;
import ec.edu.espol.proyectoed_g1.modelo.Listas.LinkedList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Comparator;
import javafx.scene.image.Image;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
        

    @Override
    public void start(Stage stage) throws IOException {
        StageUtils.setStageIcon(stage);
        
        scene = new Scene(loadFXML("inicio"), 1280, 800);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}