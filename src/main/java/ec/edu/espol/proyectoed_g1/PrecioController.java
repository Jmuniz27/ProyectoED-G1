/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyectoed_g1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author zahid
 */
public class PrecioController implements Initializable {

    @FXML
    private CheckBox botonNegociable;
    @FXML
    private TextArea txt_precioVehiculo;
    @FXML
    private Button botonContinuar;
    @FXML
    private Button botonRegresar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Select(ActionEvent event) {
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
    }
    
}
