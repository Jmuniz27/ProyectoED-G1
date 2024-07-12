/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyectoed_g1;

import ec.edu.espol.proyectoed_g1.modelo.clases.AccidenteServicios;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author isabella
 */
public class ReparacionController implements Initializable {

    @FXML
    private DatePicker datePicker;
    @FXML
    private TextArea textAreaDescripcion;
    @FXML
    private Button closeButton;
    @FXML
    private Button saveButton;
    
    private AccidenteServicios reparacion;
    private boolean isSaved = false;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void guardarAccidente(ActionEvent event) {
        
    }

    @FXML
    private void closePopup(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
    
    public AccidenteServicios getReparacion() {
        return reparacion;
    }

    public boolean isSaved() {
        return isSaved;
    }

    @FXML
    private void guardarReparacion(ActionEvent event){
        LocalDate fecha = datePicker.getValue();
        String descripcion = textAreaDescripcion.getText();

        if (fecha != null && !descripcion.isEmpty()) {
            reparacion = new AccidenteServicios(fecha, descripcion);
            isSaved = true;
        }

        closePopup(event);
    }
}
