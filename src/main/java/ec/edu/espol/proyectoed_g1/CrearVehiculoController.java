/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyectoed_g1;

import ec.edu.espol.proyectoed_g1.modelo.Interfaces.List;
import ec.edu.espol.proyectoed_g1.modelo.Listas.LinkedList;
import java.io.File;
import java.io.IOException;
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
import javafx.scene.input.MouseEvent;
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
    private ComboBox<Marca> cbMarca;
    @FXML
    private ComboBox<String> cbModelo;
    @FXML
    private ComboBox<Integer> cbAnio;
    @FXML
    private ComboBox<Integer> cbKilo;
    @FXML
    private ComboBox<String> cbMotor;
    @FXML
    private ComboBox<String> cbTransmision;
    @FXML
    private ComboBox<Integer> cbPeso;
    @FXML
    private ComboBox<String> cbCiudad;
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
        Image img1 = new Image("/imagenes/logo.png");
        imgLogo.setImage(img1);;
        for(Marca m: InicioController.marcas){
            cbMarca.getItems().add(m);
        }
        for(Integer a: InicioController.anios){
            cbAnio.getItems().add(a);
        }
        for(Integer k: InicioController.kilometrajes){
            cbKilo.getItems().add(k);
        }
        for(String mo : InicioController.motores){
            cbMotor.getItems().add(mo);
        }
        for(String t: InicioController.transmisiones){
            cbTransmision.getItems().add(t);
        }
        for(Integer p: InicioController.pesos){
            cbPeso.getItems().add(p);
        }
        for(String c: InicioController.ciudades){
            cbCiudad.getItems().add(c);
        }
        
    }    

    @FXML
    private void irInicio(ActionEvent event) {
        try{
            App.setRoot("inicio");
        } catch(IOException e){
            e.printStackTrace();
        }
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

    @FXML
    private void clickEnModelo(MouseEvent event) {
        cbModelo.getItems().clear();
        Marca marca =  cbMarca.getValue();
        for(String modelo: marca.getModelos()){
            cbModelo.getItems().add(modelo);
        }
    }
    
}
