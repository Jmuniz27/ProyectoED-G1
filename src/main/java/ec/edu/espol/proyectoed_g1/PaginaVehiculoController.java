/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyectoed_g1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author jmuni
 */
public class PaginaVehiculoController implements Initializable {

    @FXML
    private Text carroNombre;
    @FXML
    private Text carroPrecio;
    @FXML
    private Label anioAuto;
    @FXML
    private Label kmAuto;
    @FXML
    private ImageView imgPrin;
    @FXML
    private ScrollPane carImgs;
    @FXML
    private Button preBoton;
    @FXML
    private Button nextBoton;
    @FXML
    private GridPane resumGrid;
    @FXML
    private VBox vBoxResu;
    @FXML
    private Text tipo;
    @FXML
    private Text descr;
    @FXML
    private Text usrName;
    @FXML
    private ImageView heartIcon;
    @FXML
    private Text heartText;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void pagPrincipalClick(MouseEvent event) {
    }

    @FXML
    private void heartClick(MouseEvent event) {
    }
    
}
