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
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author isabella
 */
public class BuscarVehiculosController implements Initializable {

    @FXML
    private Button botonInicio;
    @FXML
    private ComboBox<?> cbModelo;
    @FXML
    private ComboBox<?> cbMarca;
    @FXML
    private ComboBox<?> cbPrecioDesde;
    @FXML
    private ComboBox<?> cbPrecioHasta;
    @FXML
    private ComboBox<?> cbKiloDesde;
    @FXML
    private ComboBox<?> cbKiloHasta;
    @FXML
    private Button botonBuscar;
    @FXML
    private VBox gpCatalogo;
    @FXML
    private ImageView flechaAntes;
    @FXML
    private Label lblNumPagina;
    @FXML
    private ImageView flechaDespues;

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
    private void buscarFiltros(ActionEvent event) {
    }

    @FXML
    private void irPaginaAnterior(MouseEvent event) {
    }

    @FXML
    private void irPaginaDespues(MouseEvent event) {
    }
    
}
