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
    DoublyLinkedList<Vehicle> vehiculos = new DoublyLinkedList<>();
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
        vehiculos.addLast(new Vehicle(new Precio(20000, false), "Chevrolet", "Spark", 2012, 200000, "Manual", 10000, "Zaruma", new Usuario("Maria Mendez", "0987654321", "mail@mail.com", new DoublyLinkedList<>()), false, new Historial(new LinkedList<>(), new LinkedList<>()), tipoVehiculo.SEDAN, new CircularDoublyLinkedList<>()));
        vehiculos.addLast(new Vehicle(new Precio(15000, true), "Ford", "Fiesta", 2015, 150000, "Automatic", 8000, "Guayaquil", new Usuario("Juan Perez", "0987654321", "juanperez@mail.com", new DoublyLinkedList<>()), true, new Historial(new LinkedList<>(), new LinkedList<>()), tipoVehiculo.HATCHBACK, new CircularDoublyLinkedList<>()));
        vehiculos.addLast(new Vehicle(new Precio(30000, false), "Toyota", "Corolla", 2018, 100000, "Automatic", 12000, "Quito", new Usuario("Luisa Gomez", "0987654321", "luisagomez@mail.com", new DoublyLinkedList<>()), false, new Historial(new LinkedList<>(), new LinkedList<>()), tipoVehiculo.SEDAN, new CircularDoublyLinkedList<>()));
        vehiculos.addLast(new Vehicle(new Precio(25000, true), "Honda", "Civic", 2016, 180000, "Manual", 9000, "Cuenca", new Usuario("Pedro Rodriguez", "0987654321", "pedrorodriguez@mail.com", new DoublyLinkedList<>()), true, new Historial(new LinkedList<>(), new LinkedList<>()), tipoVehiculo.SEDAN, new CircularDoublyLinkedList<>()));
        vehiculos.addLast(new Vehicle(new Precio(18000, false), "Nissan", "Sentra", 2014, 160000, "Automatic", 10000, "Manta", new Usuario("Ana Sanchez", "0987654321", "anasanchez@mail.com", new DoublyLinkedList<>()), false, new Historial(new LinkedList<>(), new LinkedList<>()), tipoVehiculo.SEDAN, new CircularDoublyLinkedList<>()));
        vehiculos.addLast(new Vehicle(new Precio(22000, true), "Mazda", "3", 2017, 120000, "Manual", 11000, "Ambato", new Usuario("Carlos Castro", "0987654321", "carloscastro@mail.com", new DoublyLinkedList<>()), true, new Historial(new LinkedList<>(), new LinkedList<>()), tipoVehiculo.HATCHBACK, new CircularDoublyLinkedList<>()));
        vehiculos.addLast(new Vehicle(new Precio(28000, false), "Volkswagen", "Golf", 2019, 90000, "Automatic", 13000, "Loja", new Usuario("Laura Torres", "0987654321", "lauratorres@mail.com", new DoublyLinkedList<>()), false, new Historial(new LinkedList<>(), new LinkedList<>()), tipoVehiculo.HATCHBACK, new CircularDoublyLinkedList<>()));
        vehiculos.addLast(new Vehicle(new Precio(19000, true), "Hyundai", "Accent", 2013, 140000, "Manual", 9500, "Santo Domingo", new Usuario("Roberto Andrade", "0987654321", "robertoandrade@mail.com", new DoublyLinkedList<>()), true, new Historial(new LinkedList<>(), new LinkedList<>()), tipoVehiculo.SEDAN, new CircularDoublyLinkedList<>()));
        vehiculos.addLast(new Vehicle(new Precio(32000, false), "Kia", "Rio", 2020, 80000, "Automatic", 14000, "Portoviejo", new Usuario("Elena Vargas", "0987654321", "elenavargas@mail.com", new DoublyLinkedList<>()), false, new Historial(new LinkedList<>(), new LinkedList<>()), tipoVehiculo.HATCHBACK, new CircularDoublyLinkedList<>()));
        vehiculos.addLast(new Vehicle(new Precio(26000, true), "Subaru", "Impreza", 2016, 170000, "Manual", 10000, "Ibarra", new Usuario("Diego Alvarado", "0987654321", "diegoalvarado@mail.com", new DoublyLinkedList<>()), true, new Historial(new LinkedList<>(), new LinkedList<>()), tipoVehiculo.SEDAN, new CircularDoublyLinkedList<>()));
        currentNode = vehiculos.getHead();
        System.out.println(currentNode.toString());
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
            for(int j = 0; j < 2; j++){
                System.out.println(i + " " + j);
                VBox auto = plantillaAuto(tempNode.getContent());
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
