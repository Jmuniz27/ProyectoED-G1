package ec.edu.espol.proyectoed_g1;

import ec.edu.espol.proyectoed_g1.modelo.clases.Marca;
import ec.edu.espol.proyectoed_g1.modelo.clases.Historial;
import ec.edu.espol.proyectoed_g1.modelo.clases.Usuario;
import ec.edu.espol.proyectoed_g1.modelo.clases.Vehicle;
import ec.edu.espol.proyectoed_g1.modelo.clases.Precio;
import ec.edu.espol.proyectoed_g1.modelo.Listas.CircularDoublyLinkedList;
import ec.edu.espol.proyectoed_g1.modelo.Listas.DoublyLinkedList;
import ec.edu.espol.proyectoed_g1.modelo.Listas.LinkedList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.image.Image;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;


    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("inicio"), 1280, 800);
        stage.setScene(scene);
        stage.show();
        //Creando Marcas
        LinkedList<String> mToyota = new LinkedList<>();
        mToyota.addLast("Corolla");
        mToyota.addLast("Camry");
        mToyota.addLast("RAV4");
        mToyota.addLast("Highlander");
        mToyota.addLast("Prius");
        Utilitaria.marcas.addLast(new Marca("Toyota",mToyota));
        
        LinkedList<String> mHonda = new LinkedList<>();
        mHonda.addLast("Civic");
        mHonda.addLast("Accord");
        mHonda.addLast("CR-V");
        mHonda.addLast("Pilot");
        mHonda.addLast("Fit");
        Utilitaria.marcas.addLast(new Marca("Honda",mHonda));
        
        LinkedList<String> mFord = new LinkedList<>();
        mFord.addLast("F-150");
        mFord.addLast("Mustang");
        mFord.addLast("Explorer");
        mFord.addLast("Escape");
        mFord.addLast("Fusion");
        Utilitaria.marcas.addLast(new Marca("Ford",mFord));
        
        LinkedList<String> mChevrolet = new LinkedList<>();
        mChevrolet.addLast("Silverado");
        mChevrolet.addLast("Malibu");
        mChevrolet.addLast("Equinox");
        mChevrolet.addLast("Camaro");
        mChevrolet.addLast("Tahoe");
        Utilitaria.marcas.addLast(new Marca("Chevrolet",mChevrolet));
        
        LinkedList<String> mBMW = new LinkedList<>();
        mBMW.addLast("3 Series");
        mBMW.addLast("5 Series");
        mBMW.addLast("X5");
        mBMW.addLast("X3");
        mBMW.addLast("7 Series");
        Utilitaria.marcas.addLast(new Marca("BMW",mBMW));
        
        LinkedList<String> mMercedes = new LinkedList<>();
        mMercedes.addLast("C-Class");
        mMercedes.addLast("E-Class");
        mMercedes.addLast("GLC");
        mMercedes.addLast("GLE");
        mMercedes.addLast("S-Class");
        Utilitaria.marcas.addLast(new Marca("Mercedes-Benz",mMercedes));
        
        LinkedList<String> mAudi = new LinkedList<>();
        mAudi.addLast("A3");
        mAudi.addLast("A4");
        mAudi.addLast("Q5");
        mAudi.addLast("Q7");
        mAudi.addLast("A6");
        Utilitaria.marcas.addLast(new Marca("Audi",mAudi));
        
        LinkedList<String> mNissan = new LinkedList<>();
        mNissan.addLast("Altima");
        mNissan.addLast("Sentra");
        mNissan.addLast("Rogue");
        mNissan.addLast("Pathfinder");
        mNissan.addLast("Murano");
        Utilitaria.marcas.addLast(new Marca("Nissan",mNissan));
        
        //Creando lista anios
        for(int i = 2024; i>=1990; i--){
            Utilitaria.anios.addLast(i);
        }
        /*
        InicioController.anios.addLast(2024);
        InicioController.anios.addLast(2023);
        InicioController.anios.addLast(2022);
        InicioController.anios.addLast(2021);
        InicioController.anios.addLast(2020);
        InicioController.anios.addLast(2019);
        InicioController.anios.addLast(2018);
        InicioController.anios.addLast(2017);
        InicioController.anios.addLast(2016);
        InicioController.anios.addLast(2015);
        InicioController.anios.addLast(2014);
        InicioController.anios.addLast(2013);
        InicioController.anios.addLast(2012);
        InicioController.anios.addLast(2011);
        InicioController.anios.addLast(2010);
        InicioController.anios.addLast(2009);
        InicioController.anios.addLast(2008);
        InicioController.anios.addLast(2007);
        InicioController.anios.addLast(2006);
        InicioController.anios.addLast(2005);
        InicioController.anios.addLast(2004);
        InicioController.anios.addLast(2003);
        InicioController.anios.addLast(2002);
        InicioController.anios.addLast(2001);
        InicioController.anios.addLast(2000);*/
        
        //Creando lista kilometrajes
        for(int i = 0; i<=300000; i+=10000){
            Utilitaria.kilometrajes.addLast(i);
        }
        /*
        InicioController.kilometrajes.addLast(0);
        InicioController.kilometrajes.addLast(10000);
        InicioController.kilometrajes.addLast(20000);
        InicioController.kilometrajes.addLast(30000);
        InicioController.kilometrajes.addLast(40000);
        InicioController.kilometrajes.addLast(50000);
        InicioController.kilometrajes.addLast(60000);
        InicioController.kilometrajes.addLast(70000);
        InicioController.kilometrajes.addLast(80000);
        InicioController.kilometrajes.addLast(90000);
        InicioController.kilometrajes.addLast(100000);
        InicioController.kilometrajes.addLast(150000);
        InicioController.kilometrajes.addLast(200000);
        */
        
        //Creando lista motores
        Utilitaria.motores.addLast("Gasolina");
        Utilitaria.motores.addLast("Diésel");
        Utilitaria.motores.addLast("Híbrido");
        Utilitaria.motores.addLast("Eléctrico");
        
        //Creando lista transmisiones
        Utilitaria.transmisiones.addLast("Manual");
        Utilitaria.transmisiones.addLast("Automática");
        Utilitaria.transmisiones.addLast("Semiautomática");
        Utilitaria.transmisiones.addLast("CVT");
        
        //Creando lista pesos
        for(int i = 1000; i<=3000; i+=100){
            Utilitaria.pesos.addLast(i);
        }
        /*
        InicioController.pesos.addLast(1000);
        InicioController.pesos.addLast(1100);
        InicioController.pesos.addLast(1200);
        InicioController.pesos.addLast(1300);
        InicioController.pesos.addLast(1400);
        InicioController.pesos.addLast(1500);
        InicioController.pesos.addLast(1600);
        InicioController.pesos.addLast(1700);
        InicioController.pesos.addLast(1800);
        InicioController.pesos.addLast(1900);
        InicioController.pesos.addLast(2000);*/
        
        //Creando lista ciudades ec
        Utilitaria.ciudades.addLast("Quito");
        Utilitaria.ciudades.addLast("Guayaquil");
        Utilitaria.ciudades.addLast("Cuenca");
        Utilitaria.ciudades.addLast("Santo Domingo");
        Utilitaria.ciudades.addLast("Machala");
        Utilitaria.ciudades.addLast("Durán");
        Utilitaria.ciudades.addLast("Manta");
        Utilitaria.ciudades.addLast("Portoviejo");
        Utilitaria.ciudades.addLast("Loja");
        Utilitaria.ciudades.addLast("Ambato");
        Utilitaria.ciudades.addLast("Riobamba");
        Utilitaria.ciudades.addLast("Esmeraldas");
        Utilitaria.ciudades.addLast("Ibarra");
        Utilitaria.ciudades.addLast("Quevedo");
        Utilitaria.ciudades.addLast("Babahoyo");
        Utilitaria.ciudades.addLast("Zaruma");
        
        CircularDoublyLinkedList<Image> imgSpark = new CircularDoublyLinkedList<>();
        imgSpark.addLast(new Image("/imagenes/spark1.jpeg"));
        imgSpark.addLast(new Image("/imagenes/spark2.jpeg"));
        
        CircularDoublyLinkedList<Image> imgCivic = new CircularDoublyLinkedList<>();
        imgCivic.addLast(new Image("/imagenes/civic1.jpeg"));
        //instancias vehiculos
        Utilitaria.vehiculos.addLast(new Vehicle(new Precio(12000, false), new Marca("Chevrolet",mChevrolet), "Spark", 2020, 80000, "Manual", 900, "Duran", "Diésel",new Usuario("Juan", "0987654321", "juan@mail.co"), false, new Historial(null, null), imgSpark));
        Utilitaria.vehiculos.addLast(new Vehicle(new Precio(15000, false), new Marca("Toyota",mToyota), "Corolla", 2018, 60000, "Automática", 1100, "Quito", "Gasolina", new Usuario("Maria", "0987654321", "maria@mail.co"), true, new Historial(null, null), new CircularDoublyLinkedList<>()));
        Utilitaria.vehiculos.addLast(new Vehicle(new Precio(18000, false), new Marca("Honda",mHonda), "Civic", 2019, 70000, "Manual", 1000, "Guayaquil", "Híbrido",new Usuario("Pedro", "0987654321", "pedro@mail.co"), false, new Historial(null, null), imgCivic));
        Utilitaria.vehiculos.addLast(new Vehicle(new Precio(20000, false), new Marca("Ford",mFord), "Mustang", 2017, 50000, "Automática", 1300, "Cuenca","Eléctrico", new Usuario("Laura", "0987654321", "laura@mail.co"), true, new Historial(null, null), new CircularDoublyLinkedList<>()));
        Utilitaria.vehiculos.addLast(new Vehicle(new Precio(22000, false), new Marca("Nissan",mNissan), "Sentra", 2021, 40000, "Manual", 1200, "Santo Domingo", "Diésel",new Usuario("Carlos", "0987654321", "carlos@mail.co"), false, new Historial(null, null), new CircularDoublyLinkedList<>()));
        Utilitaria.vehiculos.addLast(new Vehicle(new Precio(25000, false), new Marca("BMW",mBMW), "X5", 2016, 90000, "Automática", 1500, "Machala", "Gasolina", new Usuario("Ana", "0987654321", "ana@mail.co"), true, new Historial(null, null), new CircularDoublyLinkedList<>()));
        Utilitaria.vehiculos.addLast(new Vehicle(new Precio(28000, false), new Marca("Mercedes-Benz",mMercedes), "GLC", 2020, 80000, "Manual", 1400, "Durán", "Híbrido",new Usuario("David", "0987654321", "david@mail.co"), false, new Historial(null, null), new CircularDoublyLinkedList<>()));
        Utilitaria.vehiculos.addLast(new Vehicle(new Precio(30000, false), new Marca("Audi",mAudi), "Q5", 2019, 70000, "Automática", 1600, "Manta", "Eléctrico",new Usuario("Sofia", "0987654321", "sofia@mail.co"), true, new Historial(null, null), new CircularDoublyLinkedList<>()));
        Utilitaria.vehiculos.addLast(new Vehicle(new Precio(32000, false), new Marca("Chevrolet",mChevrolet), "Malibu", 2018, 60000, "Manual", 1800, "Portoviejo", "Diésel", new Usuario("Diego", "0987654321", "diego@mail.co"), false, new Historial(null, null), new CircularDoublyLinkedList<>()));
        Utilitaria.vehiculos.addLast(new Vehicle(new Precio(35000, false), new Marca("Toyota",mToyota), "Camry", 2017, 50000, "Automática", 1700, "Loja","Gasolina",  new Usuario("Isabella", "0987654321", "isabella@mail.co"), true, new Historial(null, null), new CircularDoublyLinkedList<>()));
        Utilitaria.vehiculos.addLast(new Vehicle(new Precio(38000, false), new Marca("Honda",mHonda), "Accord", 2021, 40000, "Manual", 1900, "Ambato", "Híbrido",new Usuario("Andres", "0987654321", "andres@mail.co"), false, new Historial(null, null), new CircularDoublyLinkedList<>()));
        Utilitaria.vehiculos.addLast(new Vehicle(new Precio(40000, false), new Marca("Ford",mFord), "Explorer", 2016, 90000, "Automática", 2000, "Riobamba", "Eléctrico",new Usuario("Valeria", "0987654321", "valeria@mail.co"), true, new Historial(null, null), new CircularDoublyLinkedList<>()));
        Utilitaria.vehiculos.addLast(new Vehicle(new Precio(42000, false), new Marca("Nissan",mNissan), "Rogue", 2020, 80000, "Manual", 2200, "Esmeraldas","Diésel", new Usuario("Gabriel", "0987654321", "gabriel@mail.co"), false, new Historial(null, null), new CircularDoublyLinkedList<>()));
        Utilitaria.vehiculos.addLast(new Vehicle(new Precio(45000, false), new Marca("BMW",mBMW), "3 Series", 2019, 70000, "Automática", 2400, "Ibarra", "Gasolina", new Usuario("Valentina", "0987654321", "valentina@mail.co"), true, new Historial(null, null), new CircularDoublyLinkedList<>()));
        Utilitaria.vehiculos.addLast(new Vehicle(new Precio(48000, false), new Marca("Mercedes-Benz",mMercedes), "E-Class", 2018, 60000, "Manual", 2600, "Quevedo","Híbrido", new Usuario("Javier", "0987654321", "javier@mail.co"), false, new Historial(null, null), new CircularDoublyLinkedList<>()));
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}