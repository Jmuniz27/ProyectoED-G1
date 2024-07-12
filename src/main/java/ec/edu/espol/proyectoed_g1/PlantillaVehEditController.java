/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyectoed_g1;

import java.net.URL;
import java.util.ResourceBundle;

import ec.edu.espol.proyectoed_g1.modelo.clases.Vehicle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author jmuni
 */
public class PlantillaVehEditController implements Initializable {

    @FXML
    private ImageView imgVeh;
    @FXML
    private Text vehTitle;
    @FXML
    private Text txtAnio;
    @FXML
    private Text txtCiu;
    @FXML
    private Text txtKm;
    @FXML
    private Text txtPrecio;
    @FXML
    private Button btnEditar;

    public static Vehicle vehiculoEscogido;
    @FXML
    private Button btnEliminar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickEditar(MouseEvent event) {
        System.out.println("click en editar");
        try{
            App.setRoot("crearVehiculo");
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void clickEliminar(MouseEvent event) {
    }
}
