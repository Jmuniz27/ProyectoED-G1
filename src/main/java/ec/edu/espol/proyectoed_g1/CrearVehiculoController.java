/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyectoed_g1;

import ec.edu.espol.proyectoed_g1.modelo.Interfaces.List;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author zahid
 */
public class CrearVehiculoController implements Initializable {

    @FXML
    private Button botonInicio;
    @FXML
    private ComboBox<?> cbMarca;
    @FXML
    private ComboBox<?> cbModelo;
    @FXML
    private ComboBox<?> cbAnio;
    @FXML
    private ComboBox<?> cbKilo;
    @FXML
    private ComboBox<?> cbMotor;
    @FXML
    private ComboBox<?> cbTransmision;
    @FXML
    private ComboBox<?> cbPeso;
    @FXML
    private ComboBox<?> cbCiudad;
    @FXML
    private TextField tfPrecio;
    @FXML
    private CheckBox checkNegociable;
    @FXML
    private TextField tfNombre;
    @FXML
    private TextField tfApellido;
    @FXML
    private TextField tfTelefono;
    @FXML
    private TextField tfCorreo;
    @FXML
    private Button botonPonerVenta;
    @FXML
    private ImageView imgLogo;
    @FXML
    private CheckBox cCarroceria;
    @FXML
    private CheckBox cParachoques;
    @FXML
    private CheckBox cSuspension;
    @FXML
    private CheckBox cFarros;
    @FXML
    private CheckBox cEscape;
    @FXML
    private CheckBox cAceite;
    @FXML
    private CheckBox cFiltros;
    @FXML
    private CheckBox cBateria;
    @FXML
    private CheckBox cFrenos;
    @FXML
    private CheckBox cNeumaticos;
    @FXML
    private Button botonSubirImagen;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void irInicio(ActionEvent event) {
    }


    @FXML
    private void clickEnPonerVenta(ActionEvent event) {
    }

    @FXML
    private void clickEnCCarroceria(ActionEvent event) {
    }

    @FXML
    private void clickEnCParachoques(ActionEvent event) {
    }

    @FXML
    private void clickEnCSuspension(ActionEvent event) {
    }

    @FXML
    private void clickEnCFaros(ActionEvent event) {
    }

    @FXML
    private void clickEnCbEscape(ActionEvent event) {
    }

    @FXML
    private void clickEnCAceite(ActionEvent event) {
    }

    @FXML
    private void clickEnCFiltros(ActionEvent event) {
    }

    @FXML
    private void clickEnCBateria(ActionEvent event) {
    }

    @FXML
    private void clickEnCFrenos(ActionEvent event) {
    }

    @FXML
    private void clickEnCNeumaticos(ActionEvent event) {
    }

    @FXML
    private void clickEnSubirImagen(ActionEvent event) {
        
    }
    
}
