/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyectoed_g1;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import ec.edu.espol.proyectoed_g1.modelo.Listas.CircularDoublyLinkedList;
import ec.edu.espol.proyectoed_g1.modelo.Listas.DoublyLinkedList;
import ec.edu.espol.proyectoed_g1.modelo.Listas.LinkedList;
import ec.edu.espol.proyectoed_g1.modelo.Nodos.DoublyNode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author isabella
 */
public class BuscarVehiculosController implements Initializable {

    @FXML
    private Button botonInicio;
    @FXML
    private ComboBox<?> cbModelo;
    @FXML
    private ComboBox<?> cbMarca;
    @FXML
    private Button botonBuscar;
    @FXML
    private Label lblNumPagina;
    @FXML
    private ImageView imgLogo;
    @FXML
    private GridPane gridCarros;
    @FXML
    private HBox pestanias;
    @FXML
    private TextField precioDesde;
    @FXML
    private TextField precioHasta;
    @FXML
    private TextField kmDesde;

    //Asumiendo que tengo una DoubleLinkedList de vehiculos
    DoublyLinkedList<Vehicle> vehiculos = Utilitaria.vehiculos;
    DoublyNode<Vehicle> currentNode;
    @FXML
    private VBox plantillaAutos;
    @FXML
    private ImageView planImg;
    @FXML
    private Text plantVehName;
    @FXML
    private Label planVehAnio;
    @FXML
    private Text planVehKm;
    @FXML
    private Text planVehCiu;
    @FXML
    private Text planVehNego;
    @FXML
    private Text planVehPrecio;
    
    public static Vehicle vehiculoEscogido;

    //para paginacion
    private static final int ITEMS_PER_PAGE = 4;
    private int currentPage = 1;
    private int totalPages;
    @FXML
    private HBox pagesInd;
    @FXML
    private Label lblNumPagina1;
    @FXML
    private Label lblNumPagina2;
    @FXML
    private VBox containerFAuto;
    @FXML
    private VBox filtroAuto;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        vehiculoEscogido = null;
        currentNode = vehiculos.getHead();
        totalPages = (int) Math.ceil((double) vehiculos.size() / ITEMS_PER_PAGE);
        System.out.println("paginas>> " + totalPages);
        updateGrid();
        updatePagination();
        //pruebaUpdate();
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
    private void buscarFiltros(ActionEvent event) {
        String modeloSelec = cbModelo.getSelectionModel().getSelectedItem() != null ? cbModelo.getSelectionModel().getSelectedItem().toString() : null;
        String marcaSelec = cbMarca.getSelectionModel().getSelectedItem() != null ? cbMarca.getSelectionModel().getSelectedItem().toString() : null;
        Integer precioMin = validarNumero(precioDesde.getText());
        Integer precioMax = validarNumero(precioHasta.getText());
        Integer kmMin = validarNumero(kmDesde.getText());
        Integer kmMax = validarNumero(kmDesde.getText());

        if(precioMin>precioMax){
            mostrarAlerta("Error", "El precio mínimo no puede ser mayor al precio máximo");
            return;
        }
        DoublyLinkedList<Vehicle> resultados = filtrarVehiculos(modeloSelec, marcaSelec, precioMin, precioMax, kmMin, kmMax);
        mostrarResultados(resultados);
        updatePagination();
    }
    private Integer validarNumero(String num) {
        if(num == null || num.isEmpty()) return null;
        try {
            return Integer.parseInt(num);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @FXML
    private void prevPag(ActionEvent event) {
        if (currentPage > 1) {
            currentPage--;
            goToPage(currentPage);
        }
    }

    @FXML
    private void nextPag(ActionEvent event) {
        if (currentPage < totalPages) {
            currentPage++;
            goToPage(currentPage);
        }
    }
    private void pruebaUpdate(){
        gridCarros.getChildren().clear();
        for (int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++){
                gridCarros.add(new Label(j+""), i, j);
                System.out.println(i + " " + j);
            }
        }
    }
    private void updateGrid() {
        gridCarros.getChildren().clear();

        DoublyNode<Vehicle> tempNode = currentNode;        
        for (int i = 0; i < 2 && tempNode != null; i++) {
            for(int j = 0; j < 2 && tempNode != null; j++){
                System.out.println(i + " " + j);
                VBox auto = plantillaAuto(tempNode.getContent());
                Vehicle v= tempNode.getContent();
                auto.setOnMouseClicked(event -> {
                    vehiculoEscogido = v;
                    try{
                        App.setRoot("verIndividualVehiculo");
                    } catch(IOException e){
                        e.printStackTrace();
                    }
                });
                gridCarros.add(auto, i, j);
                tempNode = tempNode.getNext();
            }
        }
    }

    //actualizar los vehiculos
    private VBox plantillaAuto(Vehicle vehiculo) {
        try {
            // Cargar la plantilla de celda desde el archivo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("plantillaAuto_busVehiculo.fxml"));
            VBox auto = loader.load();

            // Actualizar el contenido de la celda
            //ImageView planImg = (ImageView) auto.lookup("#planImg");
            Text plantVehName = (Text) auto.lookup("#plantVehName");
            Label planVehAnio = (Label) auto.lookup("#planVehAnio");
            Text planVehKm = (Text) auto.lookup("#planVehKm");
            Text planVehCiu = (Text) auto.lookup("#planVehCiu");
            Text planVehNego = (Text) auto.lookup("#planVehNego");
            Text planVehPrecio = (Text) auto.lookup("#planVehPrecio");

            //planImg.setImage(new Image(getClass().getResourceAsStream("/resources/default-car.png")));
            plantVehName.setText(vehiculo.getMarca() + " " + vehiculo.getModelo());
            planVehAnio.setText(String.valueOf(vehiculo.getYear()));
            planVehKm.setText(String.valueOf(vehiculo.getKm()));
            planVehCiu.setText(vehiculo.getUbiAct());
            planVehNego.setText(vehiculo.getPrecio().isEsNegociable() ? "Negociable" : "No negociable");
            planVehPrecio.setText("$" + vehiculo.getPrecio().getCant());

            return auto;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    //paginacion
    private void updatePagination() {
        pagesInd.getChildren().clear();

        for (int i = 1; i <= totalPages; i++) {
            Button pageButton = new Button(String.valueOf(i));
            pageButton.setCursor(javafx.scene.Cursor.HAND);
            pageButton.setStyle("-fx-background-radius: 40;");
            pageButton.setStyle("-fx-border-color:  #DADADA;");
            pageButton.setStyle("-fx-font-family: 'Arial Black';");
            pageButton.setStyle("-fx-background-color: #FFFFFF;");
            if (i == currentPage) {
                pageButton.setCursor(javafx.scene.Cursor.HAND);
                pageButton.setStyle("-fx-background-radius: 40;");
                pageButton.setStyle("-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.1), 20, 0.6, 0, 0);"); 
                pageButton.setStyle("-fx-background-color:#e0252d;"); // Estilo para la página activa
                pageButton.setTextFill(javafx.scene.paint.Color.WHITE);
            }
            final int pageIndex = i;
            pageButton.setOnAction(event -> goToPage(pageIndex));
            pagesInd.getChildren().add(pageButton);
        }
    }

    private void goToPage(int pageIndex) {
        currentPage = pageIndex;

        // Calcular el nodo inicial para la nueva página
        currentNode = vehiculos.getHead();
        for (int i = 0; i < (currentPage - 1) * ITEMS_PER_PAGE && currentNode != null; i++) {
            currentNode = currentNode.getNext();
        }

        updateGrid();
        updatePagination();
    }
    private void mostrarAlerta(String titulo, String mensaje) {
            Alert alerta = new Alert(AlertType.ERROR);
            alerta.setTitle(titulo);
            alerta.setHeaderText(null);
            alerta.setContentText(mensaje);
            alerta.showAndWait();
    }
    //filtros
        private DoublyLinkedList<Vehicle> filtrarVehiculos(String modelo, String marca, Integer precioMin, Integer precioMax, Integer kmMin, Integer kmMax) {
        DoublyLinkedList<Vehicle> resultados = new DoublyLinkedList<>();
        DoublyNode<Vehicle> nodo = vehiculos.getHead();

        while (nodo != null) {
            Vehicle vehiculo = nodo.getContent();

            boolean coincide = true;
            if (modelo != null && !modelo.equals(vehiculo.getModelo())) coincide = false;
            if (marca != null && !marca.equals(vehiculo.getMarca())) coincide = false;
            if (precioMin != null && vehiculo.getPrecio().getCant() < precioMin) coincide = false;
            if (precioMax != null && vehiculo.getPrecio().getCant() > precioMax) coincide = false;
            if (kmMin != null && vehiculo.getKm() < kmMin) coincide = false;
            if (kmMax != null && vehiculo.getKm() > kmMax) coincide = false;

            if (coincide) {
                resultados.addFirst(vehiculo);
            }
            nodo = nodo.getNext();
        }

        return resultados;
    }

    private void mostrarResultados(DoublyLinkedList<Vehicle> resultados) {
        gridCarros.getChildren().clear();
        DoublyNode<Vehicle> tempNode = resultados.getHead();
        for (int i = 0; i < 2 && tempNode != null; i++) {
            for(int j = 0; j < 2; j++){
                System.out.println(i + " " + j);
                VBox auto = plantillaAuto(tempNode.getContent());
                gridCarros.add(auto, i, j);
                tempNode = tempNode.getNext();
            }
        }
    }
}
