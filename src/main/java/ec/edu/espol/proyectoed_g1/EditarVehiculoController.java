/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyectoed_g1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ec.edu.espol.proyectoed_g1.modelo.Listas.CircularDoublyLinkedList;
import ec.edu.espol.proyectoed_g1.modelo.Listas.DoublyLinkedList;
import ec.edu.espol.proyectoed_g1.modelo.clases.Vehicle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author jmuni
 */
public class EditarVehiculoController implements Initializable {

    @FXML
    private ImageView imgLogo;
    @FXML
    private Button botonInicio;
    @FXML
    private VBox vboxVeh;

    private DoublyLinkedList<Vehicle> vehiculos;
    public static Vehicle vehiculoEscogido;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        vehiculos = Utilitaria.vehiculos;
        for (Vehicle vehiculo : vehiculos) {
            HBox auto = plantillaAuto(vehiculo);
            vboxVeh.getChildren().add(auto);
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
    private HBox plantillaAuto(Vehicle vehiculo) {
        try {
            // Cargar la plantilla de celda desde el archivo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("plantillaVehEdit.fxml"));
            HBox auto = loader.load();

            // Actualizar el contenido de la celda
            //ImageView planImg = (ImageView) auto.lookup("#planImg");
            Text plantVehName = (Text) auto.lookup("#vehTitle");
            Text planVehAnio = (Text) auto.lookup("#txtAnio");
            Text planVehKm = (Text) auto.lookup("#txtKm");
            Text planVehCiu = (Text) auto.lookup("#txtCiu");
            Text planVehPrecio = (Text) auto.lookup("#txtPrecio");
            ImageView planImg = (ImageView) auto.lookup("#imgVeh");
            Button btnEditar = (Button) auto.lookup("#btnEditar");
            btnEditar.setOnMouseClicked(event -> {
                System.out.println("click en editar" + vehiculo.getMarca() + " " + vehiculo.getModelo());
                vehiculoEscogido = vehiculo;
                try{
                    App.setRoot("editarVehIndividual");
                } catch(Exception e){
                    e.printStackTrace();
                }
            });
            Button btnEliminar = (Button) auto.lookup("#btnEliminar");
            btnEliminar.setOnMouseClicked(event ->{
                try {
                    vehiculos.remove(vehiculos.indexOf(vehiculo));
                    Utilitaria.mostrarAlerta2("Vehículo eliminado con éxito.", Alert.AlertType.INFORMATION);
                    App.setRoot("editarVehiculo");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            });

            //planImg.setImage(new Image(getClass().getResourceAsStream("/resources/default-car.png")));

            CircularDoublyLinkedList<Image> imagsCarro = vehiculo.getImagsCarro();
            if(!imagsCarro.isEmpty()){
                planImg.setImage(imagsCarro.get(0));
            }
            plantVehName.setText(vehiculo.getMarca() + " " + vehiculo.getModelo());
            planVehAnio.setText(String.valueOf(vehiculo.getYear()));
            planVehKm.setText(String.valueOf(vehiculo.getKm()));
            planVehCiu.setText(vehiculo.getUbiAct());
            planVehPrecio.setText("$" + vehiculo.getPrecio().getCant());

            return auto;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
