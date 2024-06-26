/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyectoed_g1;

import ec.edu.espol.proyectoed_g1.modelo.clases.Marca;
import ec.edu.espol.proyectoed_g1.modelo.clases.Vehicle;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ec.edu.espol.proyectoed_g1.modelo.Listas.CircularDoublyLinkedList;
import ec.edu.espol.proyectoed_g1.modelo.Listas.DoublyLinkedList;
import ec.edu.espol.proyectoed_g1.modelo.Listas.LinkedList;
import ec.edu.espol.proyectoed_g1.modelo.Nodos.DoublyNode;
import ec.edu.espol.proyectoed_g1.modelo.clases.AccidenteServicios;
import java.util.Comparator;
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
    private ComboBox<String> cbModelo;
    @FXML
    private ComboBox<Marca> cbMarca;
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
    @FXML
    private TextField kmHasta;

    private DoublyLinkedList<Vehicle> listaMostrada;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        vehiculoEscogido = null;
        //cbox marca
        for(Marca m: Utilitaria.marcas){
            System.out.println(m.getNombre());
            cbMarca.getItems().add(m);
        }
        listaMostrada = vehiculos;
        Comparator<Vehicle> cmp1 = new Comparator<>(){
            @Override
            public int compare(Vehicle v1, Vehicle v2){
                int resultado = (int) (v2.getPrecio().getCant()-v1.getPrecio().getCant());
                return resultado;
            }
        };
        listaMostrada.sort(cmp1);
        
        // Añadir listeners a los textfields para permitir solo números
        setNumericTextField(precioDesde);
        setNumericTextField(precioHasta);
        setNumericTextField(kmDesde);
        setNumericTextField(kmHasta); 
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
        // Obtener valores de los filtros
        Marca marca = (Marca) cbMarca.getValue();
        String modelo = (String) cbModelo.getValue();
        Integer precioMin = precioDesde.getText().isEmpty() ? null : Integer.parseInt(precioDesde.getText());
        Integer precioMax = precioHasta.getText().isEmpty() ? null : Integer.parseInt(precioHasta.getText());
        Integer kmMin = kmDesde.getText().isEmpty() ? null : Integer.parseInt(kmDesde.getText());
        Integer kmMax = kmHasta.getText().isEmpty() ? null : Integer.parseInt(kmHasta.getText());

          // Validar los rangos de precio y kilometraje
        if (!validarRangos(precioMin, precioMax, kmMin, kmMax)) {
            mostrarAlerta("Error de validación", "Los rangos de precio y kilometraje deben ser válidos.");
            return;
        }
        // Aplicar filtros y obtener resultados
        DoublyLinkedList<Vehicle> resultados = filtrarVehiculos(marca, modelo, precioMin, precioMax, kmMin, kmMax);
        listaMostrada = resultados;
        updateGrid();
        updatePagination();
    }

    private boolean validarRangos(Integer precioMin, Integer precioMax, Integer kmMin, Integer kmMax) {
        if ((precioMin == null && precioMax != null) || (precioMin != null && precioMax == null)) {
            return false;
        }
        if ((kmMin == null && kmMax != null) || (kmMin != null && kmMax == null)) {
            return false;
        }
        if (precioMin != null && precioMax != null && precioMax < precioMin) {
            return false;
        }
        if (kmMin != null && kmMax != null && kmMax < kmMin) {
            return false;
        }
        return true;
    }

    private DoublyLinkedList<Vehicle> filtrarVehiculos(Marca marca, String modelo, Integer precioMin, Integer precioMax, Integer kmMin, Integer kmMax) {
        DoublyLinkedList<Vehicle> filtradoPorMarcaYModelo = filtrarPorMarcaYModelo(marca, modelo);
        DoublyLinkedList<Vehicle> filtradoPorPrecio = filtrarPorRangoDePrecios(precioMin, precioMax);
        DoublyLinkedList<Vehicle> filtradoPorKilometraje = filtrarPorRangoDeKilometraje(kmMin, kmMax);

        // Intersección de listas para obtener los resultados finales
        DoublyLinkedList<Vehicle> comp1 = filtradoPorMarcaYModelo.findInterseccion(filtradoPorPrecio);
        DoublyLinkedList<Vehicle> comp2 = comp1.findInterseccion(filtradoPorKilometraje);
        return comp2;
    } 

    private DoublyLinkedList<Vehicle> filtrarPorMarcaYModelo(Marca marca, String modelo) {
        DoublyLinkedList<Vehicle> resultado = new DoublyLinkedList<>();
        
        Comparator<Vehicle> cmp1 = new Comparator<>(){
            @Override
            public int compare(Vehicle v1, Vehicle v2){
                int resultado = (int) (v2.getPrecio().getCant()-v1.getPrecio().getCant());
                return resultado;
            }
        };
        resultado.sort(cmp1);
        
        for (Vehicle vehiculo : vehiculos) {
            if ((marca == null || vehiculo.getMarca().getNombre().equals(marca.getNombre())) &&
                (modelo == null || vehiculo.getModelo().equals(modelo))) {
                resultado.addLast(vehiculo);
            }
        }
        return resultado;
    }

    private DoublyLinkedList<Vehicle> filtrarPorRangoDePrecios(Integer precioMin, Integer precioMax) {
        DoublyLinkedList<Vehicle> resultado = new DoublyLinkedList<>();
        for (Vehicle vehiculo : vehiculos) {
            if ((precioMin == null || vehiculo.getPrecio().getCant() >= precioMin) &&
                (precioMax == null || vehiculo.getPrecio().getCant() <= precioMax)) {
                resultado.addLast(vehiculo);
            }
        }
        return resultado;
    }

    private DoublyLinkedList<Vehicle> filtrarPorRangoDeKilometraje(Integer kmMin, Integer kmMax) {
        DoublyLinkedList<Vehicle> resultado = new DoublyLinkedList<>();
        for (Vehicle vehiculo : vehiculos) {
            if ((kmMin == null || vehiculo.getKm() >= kmMin) &&
                (kmMax == null || vehiculo.getKm() <= kmMax)) {
                resultado.addLast(vehiculo);
            }
        }
        return resultado;
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
        DoublyNode<Vehicle> tempNode = listaMostrada.getHead();
        int startIndex = (currentPage - 1) * ITEMS_PER_PAGE;
        for (int i = 0; i < startIndex && tempNode != null; i++) {
            tempNode = tempNode.getNext();
        }
        for (int i = 0; i < 2 && tempNode != null; i++) {
            for (int j = 0; j < 2 && tempNode != null; j++) {
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
            ImageView planImg = (ImageView) auto.lookup("#planImg");

            //planImg.setImage(new Image(getClass().getResourceAsStream("/resources/default-car.png")));

            CircularDoublyLinkedList<Image> imagsCarro = vehiculo.getImagsCarro();
            if(!imagsCarro.isEmpty()){
                planImg.setImage(imagsCarro.get(0));
            }
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
        totalPages = (int) Math.ceil((double) listaMostrada.size() / ITEMS_PER_PAGE);
        for (int i = 1; i <= totalPages; i++) {
            Button pageButton = new Button(String.valueOf(i));
            pageButton.setCursor(javafx.scene.Cursor.HAND);
            pageButton.setStyle("-fx-background-radius: 40;");
            pageButton.setStyle("-fx-border-color:  #DADADA;");
            pageButton.setStyle("-fx-font-family: 'Arial Black';");
            pageButton.setStyle("-fx-background-color: #FFFFFF;");
            if (i == currentPage) {
                pageButton.setCursor(javafx.scene.Cursor.DEFAULT);
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
        System.out.println("goToPage " + pageIndex);
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
    private void mostrarResultados(DoublyLinkedList<Vehicle> resultados) {
        gridCarros.getChildren().clear();
        DoublyNode<Vehicle> tempNode = resultados.getHead();
        for (int i = 0; i < 2 && tempNode != null; i++) {
            for(int j = 0; j < 2 && tempNode != null; j++){
                System.out.println(i + " " + j);
                VBox auto = plantillaAuto(tempNode.getContent());
                gridCarros.add(auto, i, j);
                tempNode = tempNode.getNext();
            }
        }
    }
    private void setNumericTextField(TextField textField) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                textField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }

    @FXML
    private void cbMarcaClicked(ActionEvent event) {
        cbModelo.getItems().clear();
        Marca marca =  cbMarca.getValue();
        for(String modelo: marca.getModelos()){
            cbModelo.getItems().add(modelo);
        }
    }

    @FXML
    private void cbModeloClick(ActionEvent event) {
        
    }
}
