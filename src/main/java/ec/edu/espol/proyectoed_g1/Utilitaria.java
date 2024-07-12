/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectoed_g1;

import ec.edu.espol.proyectoed_g1.modelo.clases.Marca;
import ec.edu.espol.proyectoed_g1.modelo.clases.Vehicle;
import ec.edu.espol.proyectoed_g1.modelo.Listas.DoublyLinkedList;
import excepciones.ComboBoxSinEleccion;
import excepciones.NoEsNumero;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.Duration;
import java.util.Comparator;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;

/**
 *
 * @author isabella
 */
public class Utilitaria implements Serializable {
   
    public static DoublyLinkedList<Vehicle> vehiculos = readListFromFile("vehiculos.dat", Vehicle.class);
    public static DoublyLinkedList<Marca> marcas = readListFromFile("marcas.dat", Marca.class);
    public static DoublyLinkedList<Integer> anios = readListFromFile("anios.dat", Integer.class);
    public static DoublyLinkedList<Integer> kilometrajes = readListFromFile("kilometrajes.dat", Integer.class);
    public static DoublyLinkedList<String> motores = readListFromFile("motores.dat", String.class);
    public static DoublyLinkedList<String> transmisiones = readListFromFile("transmisiones.dat", String.class);
    public static DoublyLinkedList<Integer> pesos = readListFromFile("pesos.dat", Integer.class);
    public static DoublyLinkedList<String> ciudades = readListFromFile("ciudades.dat", String.class);
    
    
    public static void mostrarAlerta(String msg, Alert.AlertType a, String fxml) {
        Alert alert = new Alert(a);

        alert.setTitle(null);
        alert.setHeaderText(a + "");
        alert.setContentText(msg);
        Button okButton = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
        okButton.setOnAction(event -> {
            try{
                App.setRoot(fxml);
            } catch(IOException e){
                e.printStackTrace();
            }
        });
        alert.showAndWait();
    }
    
    public static void mostrarAlerta2(String msg, Alert.AlertType a) {
        Alert alert = new Alert(a);

        alert.setTitle(null);
        alert.setHeaderText(a + "");
        alert.setContentText(msg);
        Button okButton = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
        alert.showAndWait();
    }
    
    public static void verificarComboBox(ComboBox cb) throws ComboBoxSinEleccion{
        if(cb.getValue() == null){
            throw new ComboBoxSinEleccion();
        }
    }
    
    public static double obtenerTFNumero(TextField tf) throws NoEsNumero{
        String str = tf.getText();
        try {
            double d = Double.parseDouble(str);
            return d;
        } catch (NumberFormatException e) {
            throw new NoEsNumero();
        }
    }

    public static Tooltip crearComents(String title, String msj){
        Tooltip tooltip = new Tooltip(title+ "\n" + msj);
        tooltip.setStyle("-fx-font-size: 16px; -fx-background-color: lightgray; -fx-text-fill: black;");
        tooltip.setShowDelay(javafx.util.Duration.millis(0));
        tooltip.setShowDuration(javafx.util.Duration.INDEFINITE);
        return tooltip;
    }
    
    //Para serializar las listas
    
    public static <T> DoublyLinkedList<T> readListFromFile(String filename, Class<T> clazz) {
        DoublyLinkedList<T> list = new DoublyLinkedList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            list = (DoublyLinkedList<T>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public static <T> void saveListToFile(String filename, DoublyLinkedList<T> list) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static <T> void addToFile(String filename, T item, Class<T> clazz) {
        if (item != null) {
            DoublyLinkedList<T> list = readListFromFile(filename, clazz);
            list.addLast(item);
            saveListToFile(filename, list);
        }
    }
    
}
