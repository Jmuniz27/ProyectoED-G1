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
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author zahid
 */
public class CrearVehiculoController implements Initializable {

    @FXML
    private ComboBox<?> botonTipoVehiculo;
    @FXML
    private ComboBox<?> botonModeloVehiculo;
    @FXML
    private ComboBox<?> botonAñoVehiculo;
    @FXML
    private ComboBox<?> botonUbicacionVehiculo;
    @FXML
    private ComboBox<?> botonMarcaVehiculo;
    @FXML
    private ComboBox<?> botonSubtipoVehiculo;
    @FXML
    private ComboBox<?> botonKilometrajeVehiculo;
    @FXML
    private ComboBox<?> botonCiudadVehiculo;
    @FXML
    private Button botonContinuar;

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
    
}
