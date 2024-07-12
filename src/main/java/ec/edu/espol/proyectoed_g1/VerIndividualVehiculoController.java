/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyectoed_g1;

import ec.edu.espol.proyectoed_g1.modelo.clases.Vehicle;
import ec.edu.espol.proyectoed_g1.modelo.Listas.CircularDoublyLinkedList;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author isabella
 */
public class VerIndividualVehiculoController implements Initializable {

    @FXML
    private ImageView imgLogo;
    @FXML
    private Button botonInicio;
    @FXML
    private Label lblTitulo;
    @FXML
    private Text carroPrecio;
    @FXML
    private Label lblPrecio;
    @FXML
    private Label lblAnio;
    @FXML
    private Label lblKm;
    @FXML
    private Label lblCiudad;
    @FXML
    private ImageView ivPrincipal;
    @FXML
    private Button btnAntesImagen;
    @FXML
    private Label lblImageNumber;
    @FXML
    private Button btnDespuesImagen;
    @FXML
    private Label lblMarcaR;
    @FXML
    private Label lblAnioR;
    @FXML
    private Label lblModeloR;
    @FXML
    private Label lblKiloR;
    @FXML
    private Label lblMotorR;
    @FXML
    private Label lblTransmisionR;
    @FXML
    private Label lblPesoR;
    @FXML
    private Label lblCiudadR;
    @FXML
    private Button btnReparaciones;
    @FXML
    private Button btnMantenimientos;
    @FXML
    private ImageView ivUsuario;
    @FXML
    private Label lblNombreUsuario;
    @FXML
    private Button btnTelefono;
    @FXML
    private Button btnCorreo;
    
    private Vehicle vehiculo;
    
    private CircularDoublyLinkedList<String> imagenes;
    
    private int index;
    @FXML
    private ImageView imgHeart;
    @FXML
    private Text favTxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Tooltip.install(ivPrincipal, Utilitaria.crearComents("Uso de CircularDoublyLinkedList", "Para recorrer de manera circular de ambos lados"));
        Tooltip.install(btnDespuesImagen, Utilitaria.crearComents("Uso de CircularDoublyLinkedList", "Para recorrer de manera circular de ambos lados"));
        Tooltip.install(btnAntesImagen, Utilitaria.crearComents("Uso de CircularDoublyLinkedList", "Para recorrer de manera circular de ambos lados"));
        vehiculo = BuscarVehiculosController.vehiculoEscogido;
        index = 0;
        imagenes = vehiculo.getImagsCarro();
        Image img1 = new Image("/imagenes/logo.png");
        imgLogo.setImage(img1);
        Image img2 = new Image("/imagenes/usuario.png");
        ivUsuario.setImage(img2);
        lblTitulo.setText(vehiculo.getMarca() + " " + vehiculo.getModelo());
        lblPrecio.setText(vehiculo.getPrecio()+"");
        lblAnio.setText(vehiculo.getYear()+"");
        lblKm.setText(vehiculo.getKm()+"");
        lblCiudad.setText(vehiculo.getUbiAct()+"");
        lblMarcaR.setText(vehiculo.getMarca()+"");
        lblAnioR.setText(vehiculo.getYear()+"");
        lblModeloR.setText(vehiculo.getModelo()+"");
        lblKiloR.setText(vehiculo.getKm()+"");
        lblMotorR.setText(vehiculo.getMotor()+"");
        lblTransmisionR.setText(vehiculo.getTransmision()+"");
        lblPesoR.setText(vehiculo.getPeso()+"");
        lblCiudadR.setText(vehiculo.getUbiAct()+"");
        lblNombreUsuario.setText(vehiculo.getDueno().getName());
        btnTelefono.setText(vehiculo.getDueno().getNumber());
        btnCorreo.setText(vehiculo.getDueno().getMail());
        ivPrincipal.setImage(new Image(imagenes.get(0)));
        lblImageNumber.setText((index+1)+"");
        if(vehiculo.isEsLiked()){
            Image img3 = new Image("/imagenes/corazonLleno.png");
            imgHeart.setImage(img3);
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
    private void verReparaciones(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("verReparaciones.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Ver Reparaciones");

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.showAndWait();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void verMantenimientos(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("verMantenimientos.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Ver Mantenimientos");

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.showAndWait();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void verPreviousImg(ActionEvent event) {
        if (!imagenes.isEmpty()) {
            index--;
            if (index < 0) {
                index = imagenes.size() - 1; // Volvemos al final de la lista circular
            }
            ivPrincipal.setImage(new Image(imagenes.get(index)));
            lblImageNumber.setText((index+1)+"");
        }
    }

    @FXML
    private void verNextImg(ActionEvent event) {
        if (!imagenes.isEmpty()) {
            index++;
            if (index >= imagenes.size()) {
                index = 0; // Volvemos al inicio de la lista circular
            }
            ivPrincipal.setImage(new Image(imagenes.get(index)));
            lblImageNumber.setText((index+1)+"");
        }
    }

    @FXML
    private void clickFavs(MouseEvent event) {
        System.out.println("click en favs");
        if(!vehiculo.isEsLiked()){
            System.out.println("vehiculo no es liked");
            vehiculo.setEsLiked(true);
            Image img4 = new Image("/imagenes/corazonLleno.png");
            imgHeart.setImage(img4);
            favTxt.setText("Quitar de Favoritos");
            Utilitaria.saveListToFile("vehiculos.dat",Utilitaria.vehiculos);
        } else{
            System.out.println("vehiculo es liked");
            vehiculo.setEsLiked(false);
            Image img4 = new Image("/imagenes/corazon.png");
            imgHeart.setImage(img4);
            favTxt.setText("Agregar a Favoritos");
            Utilitaria.saveListToFile("vehiculos.dat",Utilitaria.vehiculos);
        }
    }
    
}
