/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyectoed_g1;

import ec.edu.espol.proyectoed_g1.modelo.clases.Marca;
import ec.edu.espol.proyectoed_g1.modelo.clases.Historial;
import ec.edu.espol.proyectoed_g1.modelo.clases.Usuario;
import ec.edu.espol.proyectoed_g1.modelo.clases.Vehicle;
import ec.edu.espol.proyectoed_g1.modelo.clases.Precio;
import ec.edu.espol.proyectoed_g1.modelo.clases.AccidenteServicios;
import ec.edu.espol.proyectoed_g1.modelo.Interfaces.List;
import ec.edu.espol.proyectoed_g1.modelo.Listas.CircularDoublyLinkedList;
import ec.edu.espol.proyectoed_g1.modelo.Listas.LinkedList;
import excepciones.ComboBoxSinEleccion;
import excepciones.NoEsNumero;
import excepciones.NoHayImagenes;
import excepciones.NoSeCreoAccidenteServicio;
import excepciones.StringVacio;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ResourceBundle;
import java.util.UUID;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author jmuni
 */
public class EditarVehIndividualController implements Initializable {
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
    private Button botonSubirImagen;
    
    private CircularDoublyLinkedList<String> imagenes = new CircularDoublyLinkedList<>();
    
    
    public static LinkedList<AccidenteServicios> reparaciones;
    public static LinkedList<AccidenteServicios> mantenimientos;
    
    @FXML
    private Button btnAnadirMantenimiento;
    @FXML
    private Label lblCantMantenimientos;
    @FXML
    private Button btnAnadirReparacion;
    @FXML
    private Label lblCantReparaciones;
    @FXML
    private FlowPane fpImagenes;
    @FXML
    private Text txtTitle;
    private Vehicle vehSeleccionado;
    @FXML
    private Button btnVerReparaciones;
    @FXML
    private Button btnVerMantenimiento;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        vehSeleccionado = EditarVehiculoController.vehiculoEscogido;
        reparaciones = vehSeleccionado.getHistorial().getAccidentes().copy();
        mantenimientos = vehSeleccionado.getHistorial().getMantenimiento().copy();
        imagenes = vehSeleccionado.getImagsCarro().copy();
        mostrarImagenes();
        lblCantReparaciones.setText(reparaciones.size()+"");
        lblCantMantenimientos.setText(String.valueOf(mantenimientos.size()));
        System.out.println(vehSeleccionado.getMarca().getNombre() + " " + vehSeleccionado.getModelo() + " " + vehSeleccionado.getYear() + "en editarVehIndController");
        txtTitle.setText("Editar Vehiculo " + vehSeleccionado.getMarca().getNombre() + " " + vehSeleccionado.getModelo() + " " + vehSeleccionado.getYear());
        setNumericTextField(tfPrecio);
        setNumericTextField(tfTelefono);
        /*Image loadingCar = new Image("/imagenes/default.png");
        imagenes.addLast(loadingCar);
        ImageView ivLoadingCar = new ImageView(loadingCar);
        vbImagenes.getChildren().add(ivLoadingCar);*/
        //hayImagenes = false;
        Image img1 = new Image("/imagenes/logo.png");
        imgLogo.setImage(img1);
        //VBox.setVgrow(fpImagenes, Priority.ALWAYS);
        for(Marca m: Utilitaria.marcas){
            cbMarca.getItems().add(m);
        }
        for(Integer a: Utilitaria.anios){
            cbAnio.getItems().add(a);
        }
        for(Integer k: Utilitaria.kilometrajes){
            cbKilo.getItems().add(k);
        }
        for(String mo : Utilitaria.motores){
            cbMotor.getItems().add(mo);
        }
        for(String t: Utilitaria.transmisiones){
            cbTransmision.getItems().add(t);
        }
        for(Integer p: Utilitaria.pesos){
            cbPeso.getItems().add(p);
        }
        for(String c: Utilitaria.ciudades){
            cbCiudad.getItems().add(c);
        }
        
        //llenado campos con la info del vehiculo
        cbMarca.setValue(vehSeleccionado.getMarca());
        cbModelo.setValue(vehSeleccionado.getModelo());
        cbAnio.setValue(vehSeleccionado.getYear());
        cbKilo.setValue(vehSeleccionado.getKm());
        cbMotor.setValue(vehSeleccionado.getMotor());
        cbTransmision.setValue(vehSeleccionado.getTransmision());
        cbPeso.setValue((int)vehSeleccionado.getPeso());
        cbCiudad.setValue(vehSeleccionado.getUbiAct());
        tfPrecio.setText(String.valueOf((int)vehSeleccionado.getPrecio().getCant()));
        if(vehSeleccionado.getPrecio().isEsNegociable()){
            checkNegociable.setSelected(true);
        }
        tfNombre.setText(vehSeleccionado.getDueno().getName());
        tfApellido.setText(vehSeleccionado.getDueno().getLastName());
        tfTelefono.setText(vehSeleccionado.getDueno().getNumber());
        tfCorreo.setText(vehSeleccionado.getDueno().getMail());
        //Llenando los campos con la información del vehículo
        
    }    

    @FXML
    private void irInicio(ActionEvent event) {
        try{
            App.setRoot("inicio");
        } catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
    private static String verificarTFStringVacio(TextField tf) throws StringVacio{
        String str = tf.getText();
        if (str.equals("")){
            throw new StringVacio("Por favor coloque una cuenta válida.");
        }
        return str;
    }
    
    public Precio crearPrecio() throws StringVacio, NoEsNumero{
        verificarTFStringVacio(tfPrecio);
        double cant = Utilitaria.obtenerTFNumero(tfPrecio);
        boolean esNegociable = false;
        if(checkNegociable.isSelected()){
            esNegociable = true;
        }
        return new Precio(cant,esNegociable);
    }
    
    public Usuario crearUsuario() throws StringVacio, NoEsNumero{
        verificarTFStringVacio(tfNombre);
        verificarTFStringVacio(tfApellido);
        verificarTFStringVacio(tfTelefono);
        verificarTFStringVacio(tfCorreo);
        return new Usuario(tfNombre.getText(), tfApellido.getText(),tfTelefono.getText(), tfCorreo.getText());
    }
    
    
    @FXML
    private void clickEditarVehiculo(ActionEvent event) {
        try {
            // Asignación de nuevos valores desde los controles de la UI
            vehSeleccionado.setPrecio(crearPrecio());
            vehSeleccionado.setMarca(cbMarca.getValue());
            vehSeleccionado.setModelo(cbModelo.getValue());
            vehSeleccionado.setYear(cbAnio.getValue());
            vehSeleccionado.setKm(cbKilo.getValue());
            vehSeleccionado.setTransmision(cbTransmision.getValue());
            vehSeleccionado.setMotor(cbMotor.getValue());
            vehSeleccionado.setPeso(cbPeso.getValue());
            vehSeleccionado.setUbiAct(cbCiudad.getValue());
            vehSeleccionado.setDueno(crearUsuario());
            vehSeleccionado.setImagsCarro(imagenes);
            vehSeleccionado.setHistorial(new Historial(reparaciones,mantenimientos));
            
            // Solo añadir nuevas imágenes si se han cargado durante la sesión de edición
            
            Utilitaria.saveListToFile("vehiculos.dat",Utilitaria.vehiculos);
    
    
            Utilitaria.mostrarAlerta2("Vehículo actualizado con éxito.", Alert.AlertType.INFORMATION);
            App.setRoot("inicio");
    
        } catch (Exception e) { // Captura las excepciones más generales para simplificar
            Utilitaria.mostrarAlerta2("Error al actualizar el vehículo.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void clickEnSubirImagen(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Imágenes", "*.png", "*.jpg", "*.jpeg"));
        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {
            try {
                    // Guardar la imagen en la carpeta específica
                    String imageUrl = saveImage(file);
                    // Añadir la URL a la lista
                    imagenes.addLast(imageUrl);
                    mostrarImagenes();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
        }
    }
    
    private String saveImage(File file) throws IOException {
        String imageDirectory = "imagenesSubidas/";
        File directory = new File(imageDirectory);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        String uniqueFileName = UUID.randomUUID().toString() + "_" + file.getName();
        Path targetPath = Paths.get(imageDirectory + uniqueFileName);
        Files.copy(file.toPath(), targetPath, StandardCopyOption.REPLACE_EXISTING);
        return targetPath.toUri().toString();
    }
    
    public void mostrarImagenes() {
        fpImagenes.getChildren().clear();
        for (String imageURL : imagenes) {
            Image image = new Image(imageURL);
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(85);
            imageView.setFitHeight(85);
            imageView.setOnMouseClicked(event -> {
                if (event.getButton() == MouseButton.SECONDARY) {
                    imagenes.remove(imageURL);
                    mostrarImagenes();
                }
            });
            fpImagenes.getChildren().add(imageView);
        }
    }
    @FXML
    private void clickEnModelo(MouseEvent event) {
        cbModelo.getItems().clear();
        Marca marca =  cbMarca.getValue();
        for(String modelo: marca.getModelos()){
            cbModelo.getItems().add(modelo);
        }
    }


    @FXML
    private void clickEnAnadirMantenimiento(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mantenimiento.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Añadir Mantenimiento");

            Scene scene = new Scene(root);
            stage.setScene(scene);

            MantenimientoController mController = fxmlLoader.getController();
            stage.showAndWait();

            if (mController.isSaved()) {
                AccidenteServicios mantenimiento = mController.getMantenimiento();
                mantenimientos.addLast(mantenimiento);
                lblCantMantenimientos.setText(String.valueOf(mantenimientos.size()));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void clickEnAnadirReparacion(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("reparacion.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Añadir Reparación");

            Scene scene = new Scene(root);
            stage.setScene(scene);

            ReparacionController accidenteController = fxmlLoader.getController();
            stage.showAndWait();

            if (accidenteController.isSaved()) {
                AccidenteServicios reparacion = accidenteController.getReparacion();
                reparaciones.addLast(reparacion);
                lblCantReparaciones.setText(String.valueOf(reparaciones.size()));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //para que los textfields solo acepten numeros
    private void setNumericTextField(TextField textField) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                textField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }

    @FXML
    private void clickEnVerReparacion(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("editarReparaciones.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Ver Reparaciones");

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.showAndWait();
            EditarReparacionesController accidenteController = fxmlLoader.getController();
            reparaciones = accidenteController.getReparaciones();
            actualizarContadores();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void clickEnVerMantenimiento(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("editarMantenimientos.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Editar Mantenimientos");

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.showAndWait();
            EditarMantenimientosController accidenteController = fxmlLoader.getController();
            mantenimientos = accidenteController.getMantenimientos();
            actualizarContadores();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    //para actualizar el contador de mantenimientos y reparaciones si se elimina o se añade uno
    private void actualizarContadores() {
        lblCantMantenimientos.setText(String.valueOf(mantenimientos.size()));
        lblCantReparaciones.setText(String.valueOf(reparaciones.size()));
    }
}
