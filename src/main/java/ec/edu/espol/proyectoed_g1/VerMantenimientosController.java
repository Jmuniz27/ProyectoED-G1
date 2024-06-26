/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyectoed_g1;
import ec.edu.espol.proyectoed_g1.modelo.clases.*;
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
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author isabella
 */
public class VerMantenimientosController implements Initializable {

    @FXML
    private VBox vbMantenimientos;
    @FXML
    private Button btnSalir;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        vbMantenimientos.getChildren().clear();
        LinkedList<AccidenteServicios> mantenimientos = BuscarVehiculosController.vehiculoEscogido.getHistorial().getMantenimiento();
        Comparator<AccidenteServicios> cmp1 = new Comparator<>(){
            @Override
            public int compare(AccidenteServicios a1, AccidenteServicios a2){
                return a1.getFecha().compareTo(a2.getFecha());
            }
        };
        mantenimientos.sort(cmp1);
        HBox hbIni = new HBox();
        hbIni.setPrefWidth(100);
        hbIni.setPrefHeight(10);
        vbMantenimientos.getChildren().add(hbIni);
        for(AccidenteServicios man: mantenimientos){
            HBox hbMan = plantillaMantenimiento(man);
            vbMantenimientos.getChildren().add(hbMan);
        }
        HBox hbFin = new HBox();
        hbFin.setPrefWidth(100);
        hbFin.setPrefHeight(10);
        vbMantenimientos.getChildren().add(hbFin);
    }    

    @FXML
    private void closePopup(ActionEvent event) {
        Stage stage = (Stage) btnSalir.getScene().getWindow();
        stage.close();
    }
    
    private HBox plantillaMantenimiento(AccidenteServicios mante) {
        try {
            // Cargar la plantilla de celda desde el archivo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("plantillaServicios.fxml"));
            HBox mantenimiento = loader.load();

            // Actualizar el contenido de la celda
            Button btnFecha = (Button) mantenimiento.lookup("#btnFecha");
            Label lblDescri = (Label) mantenimiento.lookup("#lblDescri");
                 
            btnFecha.setText(mante.getFecha().toString());
            lblDescri.setText(mante.getDescrip());
            return mantenimiento;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
