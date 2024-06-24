package ec.edu.espol.proyectoed_g1;

import ec.edu.espol.proyectoed_g1.modelo.Listas.LinkedList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

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
        InicioController.marcas.addLast(new Marca("Toyota",mToyota));
        
        LinkedList<String> mHonda = new LinkedList<>();
        mHonda.addLast("Civic");
        mHonda.addLast("Accord");
        mHonda.addLast("CR-V");
        mHonda.addLast("Pilot");
        mHonda.addLast("Fit");
        InicioController.marcas.addLast(new Marca("Honda",mHonda));
        
        LinkedList<String> mFord = new LinkedList<>();
        mFord.addLast("F-150");
        mFord.addLast("Mustang");
        mFord.addLast("Explorer");
        mFord.addLast("Escape");
        mFord.addLast("Fusion");
        InicioController.marcas.addLast(new Marca("Ford",mFord));
        
        LinkedList<String> mChevrolet = new LinkedList<>();
        mChevrolet.addLast("Silverado");
        mChevrolet.addLast("Malibu");
        mChevrolet.addLast("Equinox");
        mChevrolet.addLast("Camaro");
        mChevrolet.addLast("Tahoe");
        InicioController.marcas.addLast(new Marca("Chevrolet",mChevrolet));
        
        LinkedList<String> mBMW = new LinkedList<>();
        mBMW.addLast("3 Series");
        mBMW.addLast("5 Series");
        mBMW.addLast("X5");
        mBMW.addLast("X3");
        mBMW.addLast("7 Series");
        InicioController.marcas.addLast(new Marca("BMW",mBMW));
        
        LinkedList<String> mMercedes = new LinkedList<>();
        mMercedes.addLast("C-Class");
        mMercedes.addLast("E-Class");
        mMercedes.addLast("GLC");
        mMercedes.addLast("GLE");
        mMercedes.addLast("S-Class");
        InicioController.marcas.addLast(new Marca("Mercedes-Benz",mMercedes));
        
        LinkedList<String> mAudi = new LinkedList<>();
        mAudi.addLast("A3");
        mAudi.addLast("A4");
        mAudi.addLast("Q5");
        mAudi.addLast("Q7");
        mAudi.addLast("A6");
        InicioController.marcas.addLast(new Marca("Audi",mAudi));
        
        LinkedList<String> mNissan = new LinkedList<>();
        mNissan.addLast("Altima");
        mNissan.addLast("Sentra");
        mNissan.addLast("Rogue");
        mNissan.addLast("Pathfinder");
        mNissan.addLast("Murano");
        InicioController.marcas.addLast(new Marca("Nissan",mNissan));
        
        //Creando lista anios
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
        InicioController.anios.addLast(2000);
        
        //Creando lista kilometrajes
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
        
        //Creando lista motores
        InicioController.motores.addLast("Gasolina");
        InicioController.motores.addLast("Diésel");
        InicioController.motores.addLast("Híbrido");
        InicioController.motores.addLast("Eléctrico");
        
        //Creando lista transmisiones
        InicioController.transmisiones.addLast("Manual");
        InicioController.transmisiones.addLast("Automática");
        InicioController.transmisiones.addLast("Semiautomática");
        InicioController.transmisiones.addLast("CVT");
        
        //Creando lista pesos
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
        InicioController.pesos.addLast(2000);
        
        //Creando lista ciudades ec
        InicioController.ciudades.addLast("Quito");
        InicioController.ciudades.addLast("Guayaquil");
        InicioController.ciudades.addLast("Cuenca");
        InicioController.ciudades.addLast("Santo Domingo");
        InicioController.ciudades.addLast("Machala");
        InicioController.ciudades.addLast("Durán");
        InicioController.ciudades.addLast("Manta");
        InicioController.ciudades.addLast("Portoviejo");
        InicioController.ciudades.addLast("Loja");
        InicioController.ciudades.addLast("Ambato");
        InicioController.ciudades.addLast("Riobamba");
        InicioController.ciudades.addLast("Esmeraldas");
        InicioController.ciudades.addLast("Ibarra");
        InicioController.ciudades.addLast("Quevedo");
        InicioController.ciudades.addLast("Babahoyo");
        InicioController.ciudades.addLast("Zaruma");
       
        
        //InicioController.vehiculos.addLast(new Vehicle(new Precio()))
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