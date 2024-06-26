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
import java.io.IOException;
import java.io.Serializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 *
 * @author isabella
 */
public class Utilitaria implements Serializable {
    
    public static DoublyLinkedList<Vehicle> vehiculos = new DoublyLinkedList<>();
    public static DoublyLinkedList<Marca> marcas = new DoublyLinkedList<>();
    public static DoublyLinkedList<Integer> anios = new DoublyLinkedList<>();
    public static DoublyLinkedList<Integer> kilometrajes = new DoublyLinkedList<>();
    public static DoublyLinkedList<String> motores = new DoublyLinkedList<>();
    public static DoublyLinkedList<String> transmisiones = new DoublyLinkedList<>();
    public static DoublyLinkedList<Integer> pesos = new DoublyLinkedList<>();
    public static DoublyLinkedList<String> ciudades = new DoublyLinkedList<>();
    
    
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
    
    
}
