/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyectoed_g1;
import ec.edu.espol.proyectoed_g1.modelo.clases.*;
import ec.edu.espol.proyectoed_g1.modelo.Listas.CircularDoublyLinkedList;
import ec.edu.espol.proyectoed_g1.modelo.Listas.LinkedList;
import java.io.IOException;
import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author isabella
 */
public class VerReparacionesController implements Initializable {

    @FXML
    private VBox vbReparaciones;
    @FXML
    private Button btnSalir;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        vbReparaciones.getChildren().clear();
        LinkedList<AccidenteServicios> reparaciones = BuscarVehiculosController.vehiculoEscogido.getHistorial().getAccidentes();
        Comparator<AccidenteServicios> cmp1 = new Comparator<>(){
            @Override
            public int compare(AccidenteServicios a1, AccidenteServicios a2){
                return a1.getFecha().compareTo(a2.getFecha());
            }
        };
        reparaciones.sort(cmp1);
        HBox hbIni = new HBox();
        hbIni.setPrefWidth(100);
        hbIni.setPrefHeight(10);
        vbReparaciones.getChildren().add(hbIni);
        for(AccidenteServicios rep: reparaciones){
            HBox hbRep = plantillaReparacion(rep);
            vbReparaciones.getChildren().add(hbRep);
        }
        HBox hbFin = new HBox();
        hbFin.setPrefWidth(100);
        hbFin.setPrefHeight(10);
        vbReparaciones.getChildren().add(hbFin);
    }    


    @FXML
    private void closePopup(ActionEvent event) {
        Stage stage = (Stage) btnSalir.getScene().getWindow();
        stage.close();
    }
    
    private HBox plantillaReparacion(AccidenteServicios reparacion) {
        try {
            // Cargar la plantilla de celda desde el archivo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("plantillaServicios.fxml"));
            HBox rep = loader.load();

            // Actualizar el contenido de la celda
            Button btnFecha = (Button) rep.lookup("#btnFecha");
            Label lblDescri = (Label) rep.lookup("#lblDescri");
                 
            btnFecha.setText(reparacion.getFecha().toString());
            lblDescri.setText(reparacion.getDescrip());
            return rep;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
