/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyectoed_g1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author isabella
 */
public class InicioController implements Initializable {
    
    
    
    @FXML
    private ImageView imgLogo;
    @FXML
    private ImageView imgBuscarVehiculos;
    @FXML
    private ImageView imgVenderVehiculo;
    @FXML
    private ImageView imgVerMisVehiculos;
    @FXML
    private Button botonBuscarVehiculos;
    @FXML
    private Button botonVenderVehiculo;
    @FXML
    private Button botonVerMisVehiculos;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image img1 = new Image("/imagenes/logo.png");
        imgLogo.setImage(img1);
        
        Image img2 = new Image("/imagenes/carrod.png");
        imgBuscarVehiculos.setImage(img2);
        
        
        Image img3 = new Image("/imagenes/wheel.png");
        imgVenderVehiculo.setImage(img3);
        
        
        Image img4 = new Image("/imagenes/carro.png");
        imgVerMisVehiculos.setImage(img4);
    }    

    @FXML
    private void clickEnBuscarVehiculos(ActionEvent event) {
        try{
            App.setRoot("buscarVehiculos");
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void clickEnVenderVehiculo(ActionEvent event) {
        try{
            App.setRoot("crearVehiculo");
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void clickEnVerMisVehiculos(ActionEvent event) {
        try{
            App.setRoot("editarVehiculo");
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
