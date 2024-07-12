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
import ec.edu.espol.proyectoed_g1.modelo.Nodos.DoublyNode;
import java.util.Comparator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    DoublyLinkedList<Vehicle> vehiculos;
    DoublyLinkedList<Vehicle> old = Utilitaria.vehiculos;
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
    @FXML
    private ComboBox<String> cbRelev;
    @FXML
    private CheckBox FavsBtn;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Crear comentarios
        Tooltip.install(botonBuscar, Utilitaria.crearComents("Se implementa DoublyLinkedList<Vehicle>", "Me devuelve una lista por marca y modelo; otra por km y otra por precio. Al final se hace intersecciones entre las 3 listas y se presenta al usuario"));
        Tooltip.install(cbRelev, Utilitaria.crearComents("Se usa comparator", "Para establecer prioridad en precio o km"));
        Tooltip.install(FavsBtn, Utilitaria.crearComents("Usa una DoublyLinkedList<Vehicle>", "Filtra los vehiculos isLiked"));
        Tooltip.install(gridCarros, Utilitaria.crearComents("Se implemento DoublyLinkedList<Vehicle>",
                "Porque  La navegación debe poder realizarse en dos sentidos (hacia adelante y hacia atrás) mirando páginas de vehículos."));
        // relevancia
        vehiculos = Utilitaria.vehiculos.copy();
        cbRelev.getItems().add("Menor Precio");
        cbRelev.setValue("Menor Precio");
        vehiculos.sort((v1, v2) -> (int) (v1.getPrecio().getCant() - v2.getPrecio().getCant()));
        cbRelev.getItems().add("Mayor Precio");
        cbRelev.getItems().add("Menor Recorrido");
        cbRelev.getItems().add("Mayor Recorrido");
        vehiculoEscogido = null;
        //cbox marca
        cbMarca.getItems().add(new Marca("Marca"));
        cbMarca.setValue(new Marca("Marca"));
        cbModelo.setValue("Modelo");
        for(Marca m: Utilitaria.marcas){
            System.out.println(m.getNombre());
            //cbMarca.getItems().add(new Marca("Marca"));
            cbMarca.getItems().add(m);
        }
        listaMostrada = vehiculos;
        
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
//filtros
    @FXML
    private void buscarFiltros(ActionEvent event) {
        // Obtener valores de los filtros
        Marca marca = (Marca) cbMarca.getValue();
        String modelo = (String) cbModelo.getValue();
        if(marca.getNombre().equals("Marca")){
            marca = null;
        }
        if (modelo.equals("Modelo")) {
            modelo = null;
        }
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
        currentPage = 1;
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
    
// paginacion
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
                gridCarros.add(auto, j, i);
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

            CircularDoublyLinkedList<String> imagsCarro = vehiculo.getImagsCarro();
            if(!imagsCarro.isEmpty()){
                Image image = new Image(imagsCarro.get(0));
                planImg.setImage(image);
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
        cbModelo.getItems().add("Modelo");
        cbModelo.setValue("Modelo");
        for(String modelo: marca.getModelos()){
            cbModelo.getItems().add(modelo);
        }
    }

    @FXML
    private void cbModeloClick(ActionEvent event) {
        
    }

    @FXML
    private void cbRelevClicked(ActionEvent event) {
        System.out.println(cbRelev.getValue());
        // Aplicar filtros y obtener resultados
        DoublyLinkedList<Vehicle> resultados = listaMostrada;
        if(cbRelev.getValue().equals("Menor Precio")){
            resultados.sort((v1, v2) -> (int) (v1.getPrecio().getCant() - v2.getPrecio().getCant()));
        } else if (cbRelev.getValue().equals("Mayor Precio")){
            resultados.sort((v1, v2) -> (int) (v2.getPrecio().getCant() - v1.getPrecio().getCant()));
        } else if (cbRelev.getValue().equals("Menor Recorrido")){
            resultados.sort((v1, v2) -> (int) (v1.getKm() - v2.getKm()));
        } else if (cbRelev.getValue().equals("Mayor Recorrido")){
            resultados.sort((v1, v2) -> (int) (v2.getKm() - v1.getKm()));
        }
        listaMostrada = resultados;
        updateGrid();
        updatePagination();
    }

    @FXML
    private void clickFavs(ActionEvent event) {
        if(FavsBtn.isSelected()){
            listaMostrada = filtrarLiked();
        } else {
            listaMostrada = Utilitaria.vehiculos;
        }
        updateGrid();
        updatePagination();
    }
    public DoublyLinkedList<Vehicle> filtrarLiked(){
        DoublyLinkedList<Vehicle> liked = new DoublyLinkedList<>();
        for(Vehicle v: Utilitaria.vehiculos){
            if(v.isEsLiked()){
                liked.addLast(v);
            }
        }
        return liked;
    }
}
