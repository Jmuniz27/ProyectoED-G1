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
import java.nio.file.Paths;
import java.nio.file.Path;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author zahid
 */
public class CrearVehiculoController implements Initializable {

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
    
    
    private LinkedList<AccidenteServicios> reparaciones = new LinkedList<>();
    private LinkedList<AccidenteServicios> mantenimientos = new LinkedList<>();
    
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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imagenes.clear();
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
        return new Usuario(tfNombre.getText(),tfApellido.getText(),tfTelefono.getText(), tfCorreo.getText());
    }
    
    
    @FXML
    private void clickEnPonerVenta(ActionEvent event) {
        try{
            //Creando Precio
            Precio precio = crearPrecio();
            Utilitaria.verificarComboBox(cbMarca);
            
            //Creando datos de ComboBoxes
            Marca marca = cbMarca.getValue();
            Utilitaria.verificarComboBox(cbModelo);
            String modelo = cbModelo.getValue();
            Utilitaria.verificarComboBox(cbAnio);
            int year = cbAnio.getValue();
            Utilitaria.verificarComboBox(cbKilo);
            int km = cbKilo.getValue();
            Utilitaria.verificarComboBox(cbTransmision);
            String transmisión = cbTransmision.getValue();
            Utilitaria.verificarComboBox(cbTransmision);
            String motor = cbMotor.getValue();
            Utilitaria.verificarComboBox(cbPeso);
            double peso = cbPeso.getValue();
            Utilitaria.verificarComboBox(cbCiudad);
            String ubiAct = cbCiudad.getValue();
            
            //Creando Usuario
            Usuario dueno = crearUsuario();
            boolean esVendido = false;
            
            //Creando Historial
            Historial histReparacion = new Historial(reparaciones,mantenimientos);
            System.out.println(imagenes);
            if(imagenes.isEmpty()){
                throw new NoHayImagenes();
            }
            Vehicle vehiculo = new Vehicle(precio,marca,modelo,year,km,transmisión,peso,ubiAct,motor,dueno,esVendido,histReparacion,imagenes);
            Utilitaria.vehiculos.addLast(vehiculo);
            try{
                App.setRoot("inicio");
            } catch(IOException e){
                e.printStackTrace();
            }
           
        } catch(StringVacio s){
            Utilitaria.mostrarAlerta2("No puede dejar campos vacíos.", Alert.AlertType.ERROR);
        } catch(NoEsNumero n){
            Utilitaria.mostrarAlerta2("El precio ingresado no es un número.", Alert.AlertType.ERROR);
        } catch(ComboBoxSinEleccion co){
            Utilitaria.mostrarAlerta2("Por favor escoja una opción en todos los campos.", Alert.AlertType.ERROR);
        } catch(NoHayImagenes nhi){
            Utilitaria.mostrarAlerta2("Debe subir al menos una imagen.", Alert.AlertType.ERROR);
        }
        
    }

    @FXML
    private void clickEnSubirImagen(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Imágenes", "*.png", "*.jpg","*.jpeg"));
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
    
    public void mostrarImagenes(){
        fpImagenes.getChildren().clear();
        for(String imageURL: imagenes){
            Image image = new Image(imageURL);
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(85);
            imageView.setFitHeight(85);
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
}
