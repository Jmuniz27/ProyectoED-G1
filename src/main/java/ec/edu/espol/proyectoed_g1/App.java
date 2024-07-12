package ec.edu.espol.proyectoed_g1;

import ec.edu.espol.proyectoed_g1.modelo.clases.*;
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
import java.time.LocalDate;
import java.time.Month;
import java.util.Comparator;
import javafx.scene.image.Image;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
        

    @Override
    public void start(Stage stage) throws IOException {
        StageUtils.setStageIcon(stage);
        
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
        mChevrolet.addLast("Spark4");
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
        
        Utilitaria.saveListToFile("marcas.dat",Utilitaria.marcas);
        
        //Creando lista anios
        for(int i = 2024; i>=1990; i--){
            Utilitaria.anios.addLast(i);
        }
        Utilitaria.saveListToFile("anios.dat",Utilitaria.anios);
        
        //Creando lista kilometrajes
        for(int i = 0; i<=300000; i+=10000){
            Utilitaria.kilometrajes.addLast(i);
        }
        Utilitaria.saveListToFile("kilometrajes.dat",Utilitaria.kilometrajes);
        
        
        //Creando lista motores
        Utilitaria.motores.addLast("Gasolina");
        Utilitaria.motores.addLast("Diésel");
        Utilitaria.motores.addLast("Híbrido");
        Utilitaria.motores.addLast("Eléctrico");
        Utilitaria.saveListToFile("motores.dat",Utilitaria.motores);
        
        //Creando lista transmisiones
        Utilitaria.transmisiones.addLast("Manual");
        Utilitaria.transmisiones.addLast("Automática");
        Utilitaria.transmisiones.addLast("Semiautomática");
        Utilitaria.transmisiones.addLast("CVT");
        Utilitaria.saveListToFile("transmisiones.dat",Utilitaria.transmisiones);
        
        //Creando lista pesos
        for(int i = 1000; i<=3000; i+=100){
            Utilitaria.pesos.addLast(i);
        }
        Utilitaria.saveListToFile("pesos.dat",Utilitaria.pesos);
        
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
        Utilitaria.saveListToFile("ciudades.dat",Utilitaria.ciudades);
        
        //Historial de los vehiculos
        // Chevrolet Spark
        LinkedList<AccidenteServicios> accidentesSpark = new LinkedList<>();
        LinkedList<AccidenteServicios> mantenimientosSpark = new LinkedList<>();
        accidentesSpark.addLast(new AccidenteServicios(LocalDate.of(2020, 5, 15), "Impacto lateral en cruce. Puerta y panel lateral derecho reparados."));
        accidentesSpark.addLast(new AccidenteServicios(LocalDate.of(2021, 3, 8), "Arañazo en parachoques trasero durante aparcamiento. Parachoques repintado."));
        mantenimientosSpark.addLast(new AccidenteServicios(LocalDate.of(2020, 4, 10), "Cambio de aceite y filtros."));
        mantenimientosSpark.addLast(new AccidenteServicios(LocalDate.of(2020, 9, 20), "Revisión del sistema de frenos."));
        mantenimientosSpark.addLast(new AccidenteServicios(LocalDate.of(2021, 1, 15), "Reemplazo de la batería."));
        mantenimientosSpark.addLast(new AccidenteServicios(LocalDate.of(2021, 6, 22), "Cambio de llantas."));
        mantenimientosSpark.addLast(new AccidenteServicios(LocalDate.of(2022, 1, 10), "Servicio de alineación y balanceo."));
        Historial historialSpark = new Historial(accidentesSpark, mantenimientosSpark);

        // Toyota Corolla
        LinkedList<AccidenteServicios> accidentesCorolla = new LinkedList<>();
        LinkedList<AccidenteServicios> mantenimientosCorolla = new LinkedList<>();
        accidentesCorolla.addLast(new AccidenteServicios(LocalDate.of(2018, 11, 5), "Daño por colisión trasera en semáforo. Sustitución de parachoques y arreglo de maletero."));
        accidentesCorolla.addLast(new AccidenteServicios(LocalDate.of(2019, 8, 22), "Rotura del espejo lateral por impacto. Espejo reemplazado y ajustado."));
        mantenimientosCorolla.addLast(new AccidenteServicios(LocalDate.of(2018, 12, 10), "Cambio de aceite y revisión de fluidos."));
        mantenimientosCorolla.addLast(new AccidenteServicios(LocalDate.of(2019, 5, 19), "Servicio de frenos y cambio de pastillas."));
        mantenimientosCorolla.addLast(new AccidenteServicios(LocalDate.of(2020, 2, 14), "Cambio de filtros de aire y aceite."));
        mantenimientosCorolla.addLast(new AccidenteServicios(LocalDate.of(2020, 10, 30), "Cambio de correas y revisión de tensores."));
        mantenimientosCorolla.addLast(new AccidenteServicios(LocalDate.of(2021, 7, 5), "Servicio completo de aire acondicionado."));
        Historial historialCorolla = new Historial(accidentesCorolla, mantenimientosCorolla);

        // Honda Civic
        LinkedList<AccidenteServicios> accidentesCivic = new LinkedList<>();
        LinkedList<AccidenteServicios> mantenimientosCivic = new LinkedList<>();
        accidentesCivic.addLast(new AccidenteServicios(LocalDate.of(2019, 3, 10), "Impacto en el capó por objeto volador. Capó reparado y pintado."));
        accidentesCivic.addLast(new AccidenteServicios(LocalDate.of(2020, 7, 25), "Colisión lateral en estacionamiento. Reparación de puertas y pintura."));
        mantenimientosCivic.addLast(new AccidenteServicios(LocalDate.of(2019, 4, 25), "Mantenimiento general y cambio de aceite."));
        mantenimientosCivic.addLast(new AccidenteServicios(LocalDate.of(2020, 1, 20), "Revisión y cambio de la suspensión delantera."));
        mantenimientosCivic.addLast(new AccidenteServicios(LocalDate.of(2020, 6, 15), "Cambio de llantas y alineación."));
        mantenimientosCivic.addLast(new AccidenteServicios(LocalDate.of(2021, 2, 18), "Revisión del sistema eléctrico y batería."));
        mantenimientosCivic.addLast(new AccidenteServicios(LocalDate.of(2021, 8, 30), "Cambio de filtros y fluidos."));
        Historial historialCivic = new Historial(accidentesCivic, mantenimientosCivic);

        // Ford Mustang
        LinkedList<AccidenteServicios> accidentesMustang = new LinkedList<>();
        LinkedList<AccidenteServicios> mantenimientosMustang = new LinkedList<>();
        accidentesMustang.addLast(new AccidenteServicios(LocalDate.of(2017, 9, 5), "Rayón profundo en la puerta derecha en área de estacionamiento. Puerta repintada."));
        accidentesMustang.addLast(new AccidenteServicios(LocalDate.of(2018, 4, 20), "Choque frontal leve. Cambio de parachoques y reparación del sistema de refrigeración."));
        mantenimientosMustang.addLast(new AccidenteServicios(LocalDate.of(2017, 11, 10), "Cambio de aceite y revisión general."));
        mantenimientosMustang.addLast(new AccidenteServicios(LocalDate.of(2018, 5, 22), "Servicio de frenos y cambio de discos."));
        mantenimientosMustang.addLast(new AccidenteServicios(LocalDate.of(2019, 3, 15), "Revisión y mantenimiento del sistema de escape."));
        mantenimientosMustang.addLast(new AccidenteServicios(LocalDate.of(2019, 10, 5), "Cambio de llantas y servicio de alineación."));
        mantenimientosMustang.addLast(new AccidenteServicios(LocalDate.of(2020, 6, 30), "Servicio completo de aire acondicionado y cambio de filtro de cabina."));
        Historial historialMustang = new Historial(accidentesMustang, mantenimientosMustang);
        
        // Nissan Sentra
        LinkedList<AccidenteServicios> accidentesSentra = new LinkedList<>();
        LinkedList<AccidenteServicios> mantenimientosSentra = new LinkedList<>();
        accidentesSentra.addLast(new AccidenteServicios(LocalDate.of(2022, 2, 17), "Impacto en parachoques trasero en tráfico. Reemplazo completo del parachoques."));
        accidentesSentra.addLast(new AccidenteServicios(LocalDate.of(2023, 1, 12), "Daño en la aleta delantera derecha por roce. Reparación y pintura."));
        mantenimientosSentra.addLast(new AccidenteServicios(LocalDate.of(2021, 5, 10), "Cambio de aceite y filtros."));
        mantenimientosSentra.addLast(new AccidenteServicios(LocalDate.of(2021, 10, 25), "Revisión del sistema de frenos y cambio de pastillas."));
        mantenimientosSentra.addLast(new AccidenteServicios(LocalDate.of(2022, 3, 15), "Mantenimiento del sistema de aire acondicionado."));
        mantenimientosSentra.addLast(new AccidenteServicios(LocalDate.of(2022, 8, 20), "Cambio de llantas y alineación."));
        mantenimientosSentra.addLast(new AccidenteServicios(LocalDate.of(2023, 2, 5), "Servicio de suspensión y amortiguadores."));
        Historial historialSentra = new Historial(accidentesSentra, mantenimientosSentra);

        // BMW X5
        LinkedList<AccidenteServicios> accidentesX5 = new LinkedList<>();
        LinkedList<AccidenteServicios> mantenimientosX5 = new LinkedList<>();
        accidentesX5.addLast(new AccidenteServicios(LocalDate.of(2017, 6, 22), "Choque frontal menor en intersección. Reemplazo del parachoques y faros."));
        accidentesX5.addLast(new AccidenteServicios(LocalDate.of(2018, 11, 5), "Arañazos en la puerta del pasajero. Repintado de la puerta."));
        mantenimientosX5.addLast(new AccidenteServicios(LocalDate.of(2017, 12, 10), "Cambio de aceite y revisión general."));
        mantenimientosX5.addLast(new AccidenteServicios(LocalDate.of(2018, 4, 18), "Revisión y cambio de pastillas de freno."));
        mantenimientosX5.addLast(new AccidenteServicios(LocalDate.of(2019, 3, 7), "Cambio de llantas y alineación."));
        mantenimientosX5.addLast(new AccidenteServicios(LocalDate.of(2019, 11, 15), "Servicio del sistema de navegación y electrónica del vehículo."));
        mantenimientosX5.addLast(new AccidenteServicios(LocalDate.of(2020, 5, 20), "Cambio de batería y revisión del sistema eléctrico."));
        Historial historialX5 = new Historial(accidentesX5, mantenimientosX5);
        
        // Mercedes-Benz GLC
        LinkedList<AccidenteServicios> accidentesGLC = new LinkedList<>();
        LinkedList<AccidenteServicios> mantenimientosGLC = new LinkedList<>();
        accidentesGLC.addLast(new AccidenteServicios(LocalDate.of(2021, 4, 9), "Impacto por colisión trasera en autopista. Reemplazo de parachoques y maletero."));
        accidentesGLC.addLast(new AccidenteServicios(LocalDate.of(2022, 5, 30), "Rayón en el capó por vandalismo. Repintado del capó."));
        mantenimientosGLC.addLast(new AccidenteServicios(LocalDate.of(2020, 6, 25), "Servicio de 80,000 km, incluyendo cambio de aceite y revisión del motor."));
        mantenimientosGLC.addLast(new AccidenteServicios(LocalDate.of(2021, 1, 20), "Cambio de filtros y fluidos."));
        mantenimientosGLC.addLast(new AccidenteServicios(LocalDate.of(2021, 7, 15), "Revisión del sistema de frenos y cambio de discos."));
        mantenimientosGLC.addLast(new AccidenteServicios(LocalDate.of(2022, 2, 10), "Cambio de llantas y revisión de suspensión."));
        mantenimientosGLC.addLast(new AccidenteServicios(LocalDate.of(2022, 9, 5), "Servicio completo del sistema de aire acondicionado."));
        Historial historialGLC = new Historial(accidentesGLC, mantenimientosGLC);

        // Audi Q5
        LinkedList<AccidenteServicios> accidentesQ5 = new LinkedList<>();
        LinkedList<AccidenteServicios> mantenimientosQ5 = new LinkedList<>();
        accidentesQ5.addLast(new AccidenteServicios(LocalDate.of(2020, 3, 11), "Daño en el parachoques delantero por atropello de animal. Parachoques reemplazado."));
        accidentesQ5.addLast(new AccidenteServicios(LocalDate.of(2021, 6, 18), "Colisión lateral en cruce. Puertas del lado izquierdo reparadas y repintadas."));
        mantenimientosQ5.addLast(new AccidenteServicios(LocalDate.of(2019, 9, 30), "Revisión de 60,000 km incluyendo cambio de aceite y revisión de frenos."));
        mantenimientosQ5.addLast(new AccidenteServicios(LocalDate.of(2020, 5, 14), "Cambio de batería y revisión del sistema eléctrico."));
        mantenimientosQ5.addLast(new AccidenteServicios(LocalDate.of(2021, 2, 22), "Servicio del sistema de aire acondicionado y cambio de filtro de cabina."));
        mantenimientosQ5.addLast(new AccidenteServicios(LocalDate.of(2021, 10, 5), "Cambio de llantas y alineación."));
        mantenimientosQ5.addLast(new AccidenteServicios(LocalDate.of(2022, 4, 7), "Mantenimiento del sistema de tracción y revisión del sistema híbrido."));
        Historial historialQ5 = new Historial(accidentesQ5, mantenimientosQ5);

        // Chevrolet Malibu
        LinkedList<AccidenteServicios> accidentesMalibu = new LinkedList<>();
        LinkedList<AccidenteServicios> mantenimientosMalibu = new LinkedList<>();
        accidentesMalibu.addLast(new AccidenteServicios(LocalDate.of(2019, 7, 22), "Impacto con objeto en la carretera. Daño en el parachoques y la suspensión delantera."));
        accidentesMalibu.addLast(new AccidenteServicios(LocalDate.of(2020, 12, 15), "Colisión menor en parking. Rayón y abolladura en puerta trasera."));
        mantenimientosMalibu.addLast(new AccidenteServicios(LocalDate.of(2018, 11, 10), "Cambio de aceite y filtros."));
        mantenimientosMalibu.addLast(new AccidenteServicios(LocalDate.of(2019, 6, 19), "Servicio de frenos y cambio de pastillas."));
        mantenimientosMalibu.addLast(new AccidenteServicios(LocalDate.of(2020, 3, 14), "Cambio de filtros de aire y aceite."));
        mantenimientosMalibu.addLast(new AccidenteServicios(LocalDate.of(2021, 1, 30), "Cambio de correas y revisión de tensores."));
        mantenimientosMalibu.addLast(new AccidenteServicios(LocalDate.of(2021, 8, 5), "Servicio completo de aire acondicionado."));
        Historial historialMalibu = new Historial(accidentesMalibu, mantenimientosMalibu);

        // Toyota Camry
        LinkedList<AccidenteServicios> accidentesCamry = new LinkedList<>();
        LinkedList<AccidenteServicios> mantenimientosCamry = new LinkedList<>();
        accidentesCamry.addLast(new AccidenteServicios(LocalDate.of(2018, 4, 9), "Daño en parachoques trasero por colisión en tráfico. Parachoques reemplazado."));
        accidentesCamry.addLast(new AccidenteServicios(LocalDate.of(2019, 11, 30), "Daño en el capó por granizo. Capó reparado y repintado."));
        mantenimientosCamry.addLast(new AccidenteServicios(LocalDate.of(2017, 10, 25), "Servicio de 50,000 km, incluyendo cambio de aceite y revisión del motor."));
        mantenimientosCamry.addLast(new AccidenteServicios(LocalDate.of(2018, 6, 20), "Cambio de filtros y fluidos."));
        mantenimientosCamry.addLast(new AccidenteServicios(LocalDate.of(2019, 3, 15), "Revisión del sistema de frenos y cambio de discos."));
        mantenimientosCamry.addLast(new AccidenteServicios(LocalDate.of(2019, 12, 10), "Cambio de llantas y revisión de suspensión."));
        mantenimientosCamry.addLast(new AccidenteServicios(LocalDate.of(2020, 7, 5), "Servicio completo del sistema de aire acondicionado."));
        Historial historialCamry = new Historial(accidentesCamry, mantenimientosCamry);
        
        // Honda Accord
        LinkedList<AccidenteServicios> accidentesAccord = new LinkedList<>();
        LinkedList<AccidenteServicios> mantenimientosAccord = new LinkedList<>();
        accidentesAccord.addLast(new AccidenteServicios(LocalDate.of(2022, 1, 17), "Impacto trasero en autopista. Reemplazo de parachoques y reparación de luces traseras."));
        accidentesAccord.addLast(new AccidenteServicios(LocalDate.of(2023, 3, 12), "Rayón en el lateral por roce con barrera. Lateral repintado."));
        mantenimientosAccord.addLast(new AccidenteServicios(LocalDate.of(2021, 6, 10), "Cambio de aceite y filtros."));
        mantenimientosAccord.addLast(new AccidenteServicios(LocalDate.of(2022, 1, 25), "Revisión del sistema de frenos y cambio de pastillas."));
        mantenimientosAccord.addLast(new AccidenteServicios(LocalDate.of(2022, 6, 15), "Mantenimiento del sistema de aire acondicionado."));
        mantenimientosAccord.addLast(new AccidenteServicios(LocalDate.of(2022, 11, 20), "Cambio de llantas y alineación."));
        mantenimientosAccord.addLast(new AccidenteServicios(LocalDate.of(2023, 4, 5), "Servicio de suspensión y amortiguadores."));
        Historial historialAccord = new Historial(accidentesAccord, mantenimientosAccord);

        // Ford Explorer
        LinkedList<AccidenteServicios> accidentesExplorer = new LinkedList<>();
        LinkedList<AccidenteServicios> mantenimientosExplorer = new LinkedList<>();
        accidentesExplorer.addLast(new AccidenteServicios(LocalDate.of(2017, 8, 5), "Colisión frontal en carretera. Daños significativos en el frente, incluyendo radiador y sistema de enfriamiento."));
        accidentesExplorer.addLast(new AccidenteServicios(LocalDate.of(2018, 12, 20), "Impacto trasero en parking. Parachoques trasero reemplazado y sistema de sensores reparado."));
        mantenimientosExplorer.addLast(new AccidenteServicios(LocalDate.of(2017, 11, 15), "Cambio de aceite y revisión general del motor."));
        mantenimientosExplorer.addLast(new AccidenteServicios(LocalDate.of(2018, 5, 10), "Servicio de frenos y cambio de discos."));
        mantenimientosExplorer.addLast(new AccidenteServicios(LocalDate.of(2019, 2, 14), "Revisión y mantenimiento del sistema de escape."));
        mantenimientosExplorer.addLast(new AccidenteServicios(LocalDate.of(2019, 9, 25), "Cambio de llantas y servicio de alineación."));
        mantenimientosExplorer.addLast(new AccidenteServicios(LocalDate.of(2020, 4, 20), "Servicio completo de aire acondicionado y cambio de filtro de cabina."));
        Historial historialExplorer = new Historial(accidentesExplorer, mantenimientosExplorer);

        // Nissan Rogue
        LinkedList<AccidenteServicios> accidentesRogue = new LinkedList<>();
        LinkedList<AccidenteServicios> mantenimientosRogue = new LinkedList<>();
        accidentesRogue.addLast(new AccidenteServicios(LocalDate.of(2021, 2, 11), "Choque lateral en cruce. Puertas y panel lateral izquierdo reparados y repintados."));
        accidentesRogue.addLast(new AccidenteServicios(LocalDate.of(2022, 6, 19), "Rasguño en parachoques trasero en parking. Área afectada repintada."));
        mantenimientosRogue.addLast(new AccidenteServicios(LocalDate.of(2020, 10, 30), "Cambio de aceite y revisión general."));
        mantenimientosRogue.addLast(new AccidenteServicios(LocalDate.of(2021, 5, 14), "Revisión del sistema de frenos y cambio de discos."));
        mantenimientosRogue.addLast(new AccidenteServicios(LocalDate.of(2021, 11, 5), "Cambio de llantas y alineación."));
        mantenimientosRogue.addLast(new AccidenteServicios(LocalDate.of(2022, 3, 22), "Servicio del sistema de navegación y electrónica del vehículo."));
        mantenimientosRogue.addLast(new AccidenteServicios(LocalDate.of(2022, 10, 17), "Revisión del sistema eléctrico y cambio de batería."));
        Historial historialRogue = new Historial(accidentesRogue, mantenimientosRogue);

        // BMW 3 Series
        LinkedList<AccidenteServicios> accidentes3Series = new LinkedList<>();
        LinkedList<AccidenteServicios> mantenimientos3Series = new LinkedList<>();
        accidentes3Series.addLast(new AccidenteServicios(LocalDate.of(2020, 4, 3), "Colisión trasera en tráfico. Parachoques y luces traseras reemplazados."));
        accidentes3Series.addLast(new AccidenteServicios(LocalDate.of(2021, 7, 29), "Daño en la carrocería por granizo. Reparación de múltiples abolladuras y repintado completo."));
        mantenimientos3Series.addLast(new AccidenteServicios(LocalDate.of(2020, 2, 20), "Cambio de aceite y filtros."));
        mantenimientos3Series.addLast(new AccidenteServicios(LocalDate.of(2020, 8, 15), "Servicio de frenos y cambio de pastillas."));
        mantenimientos3Series.addLast(new AccidenteServicios(LocalDate.of(2021, 1, 25), "Cambio de llantas y revisión de suspensión."));
        mantenimientos3Series.addLast(new AccidenteServicios(LocalDate.of(2021, 6, 10), "Revisión del sistema de aire acondicionado."));
        mantenimientos3Series.addLast(new AccidenteServicios(LocalDate.of(2021, 12, 5), "Servicio del sistema eléctrico y cambio de batería."));
        Historial historial3Series = new Historial(accidentes3Series, mantenimientos3Series);
        
        // Mercedes-Benz E-Class
        LinkedList<AccidenteServicios> accidentesEClass = new LinkedList<>();
        LinkedList<AccidenteServicios> mantenimientosEClass = new LinkedList<>();
        accidentesEClass.addLast(new AccidenteServicios(LocalDate.of(2019, 5, 11), "Impacto lateral en intersección. Puerta del conductor y panel lateral izquierdo reparados."));
        accidentesEClass.addLast(new AccidenteServicios(LocalDate.of(2020, 11, 28), "Rayón en parachoques delantero por contacto con barrera de parking. Área afectada repintada."));
        mantenimientosEClass.addLast(new AccidenteServicios(LocalDate.of(2019, 3, 30), "Cambio de aceite y revisión general del motor."));
        mantenimientosEClass.addLast(new AccidenteServicios(LocalDate.of(2019, 10, 22), "Revisión y cambio de pastillas de freno."));
        mantenimientosEClass.addLast(new AccidenteServicios(LocalDate.of(2020, 6, 7), "Cambio de llantas y alineación."));
        mantenimientosEClass.addLast(new AccidenteServicios(LocalDate.of(2020, 12, 15), "Servicio del sistema de navegación y electrónica del vehículo."));
        mantenimientosEClass.addLast(new AccidenteServicios(LocalDate.of(2021, 5, 20), "Cambio de batería y revisión del sistema eléctrico."));
        Historial historialEClass = new Historial(accidentesEClass, mantenimientosEClass);

        
        //Imagenes de los vehiculos
        //Chevrolet Spark
        CircularDoublyLinkedList<String> imgSpark = new CircularDoublyLinkedList<>();
        imgSpark.addLast("/imagenes/spark1.jpeg");
        imgSpark.addLast("/imagenes/spark2.jpeg");
        
        //Toyota Corolla
        CircularDoublyLinkedList<String> imgCorolla = new CircularDoublyLinkedList<>();
        imgCorolla.addLast("/imagenes/Toyota_Corolla_1.jpg");
        imgCorolla.addLast("/imagenes/Toyota_Corolla_2.jpg");
        imgCorolla.addLast("/imagenes/Toyota_Corolla_3.jpg");
        imgCorolla.addLast("/imagenes/Toyota_Corolla_4.jpg");
        
        //Honda Civic
        CircularDoublyLinkedList<String> imgCivic = new CircularDoublyLinkedList<>();
        imgCivic.addLast("/imagenes/Honda_Civic_1.png");
        imgCivic.addLast("/imagenes/Honda_Civic_2.png");
        imgCivic.addLast("/imagenes/Honda_Civic_3.png");
        
        //FordMustang
        CircularDoublyLinkedList<String> imgMustang = new CircularDoublyLinkedList<>();
        imgMustang.addLast("/imagenes/Ford_Mustang_1.jpeg");
        imgMustang.addLast("/imagenes/Ford_Mustang_2.jpeg");
        imgMustang.addLast("/imagenes/Ford_Mustang_3.jpeg");
        imgMustang.addLast("/imagenes/Ford_Mustang_4.jpeg");
        
        //Audi Q5
        CircularDoublyLinkedList<String> imgQ5 = new CircularDoublyLinkedList<>();
        imgQ5.addLast("/imagenes/audi_q5_1.jpeg");
        imgQ5.addLast("/imagenes/audi_q5_2.jpeg");
        
        //BMW X5
        CircularDoublyLinkedList<String> imgX5 = new CircularDoublyLinkedList<>();
        imgX5.addLast("/imagenes/BMW_X5_1.jpg");
        imgX5.addLast("/imagenes/BMW_X5_2.jpg");
        imgX5.addLast("/imagenes/BMW_X5_3.jpg");
        imgX5.addLast("/imagenes/BMW_X5_4.jpg");
        
        //Mercedes GLC
        CircularDoublyLinkedList<String> imgGLC = new CircularDoublyLinkedList<>();
        imgGLC.addLast("/imagenes/Mercedes_GLC_1.jpeg");
        imgGLC.addLast("/imagenes/Mercedes_GLC_2.jpeg");
        imgGLC.addLast("/imagenes/Mercedes_GLC_3.jpeg");
        imgGLC.addLast("/imagenes/Mercedes_GLC_4.jpeg");
        
        //Nissan Sentra
        CircularDoublyLinkedList<String> imgSentra = new CircularDoublyLinkedList<>();
        imgSentra.addLast("/imagenes/nissan_sentra_1.jpeg");
        imgSentra.addLast("/imagenes/nissan_sentra_2.jpg");
        
        //Chevrolet Malubu
        CircularDoublyLinkedList<String> imgMalibu = new CircularDoublyLinkedList<>();
        imgMalibu.addLast("/imagenes/chevrolet_malibu1.jpeg");
        imgMalibu.addLast("/imagenes/chevrolet_malibu2.jpg");
        
        //Toyota Camry
        CircularDoublyLinkedList<String> imgCamry = new CircularDoublyLinkedList<>();
        imgCamry.addLast("/imagenes/Toyota_Camry_1.jpeg");
        imgCamry.addLast("/imagenes/Toyota_Camry_2.jpeg");
        imgCamry.addLast("/imagenes/Toyota_Camry_3.jpeg");
        imgCamry.addLast("/imagenes/Toyota_Camry_4.jpeg");
        
        //Honda Accord
        CircularDoublyLinkedList<String> imgAccord = new CircularDoublyLinkedList<>();
        imgAccord.addLast("/imagenes/honda_accord_1.jpeg");
        imgAccord.addLast("/imagenes/honda_accord_2.jpeg");
        
        //Ford Explorer
        CircularDoublyLinkedList<String> imgExplorer = new CircularDoublyLinkedList<>();
        imgExplorer.addLast("/imagenes/Ford_Explorer_1.jpg");
        imgExplorer.addLast("/imagenes/Ford_Explorer_2.jpg");
        imgExplorer.addLast("/imagenes/Ford_Explorer_3.jpg");
        imgExplorer.addLast("/imagenes/Ford_Explorer_4.jpg");
        
        //Nissan Rogue
        CircularDoublyLinkedList<String> imgRogue = new CircularDoublyLinkedList<>();
        imgRogue.addLast("/imagenes/Nissan_Rogue_1.jpeg");
        imgRogue.addLast("/imagenes/Nissan_Rogue_2.jpeg");
        imgRogue.addLast("/imagenes/Nissan_Rogue_3.jpeg");
        imgRogue.addLast("/imagenes/Nissan_Rogue_4.jpeg");
        
        //BMW 3 Series
        CircularDoublyLinkedList<String> img3Series = new CircularDoublyLinkedList<>();
        img3Series.addLast("/imagenes/BMW_3SERIES_1.jpeg");
        img3Series.addLast("/imagenes/BMW_3SERIES_2.jpeg");
        img3Series.addLast("/imagenes/BMW_3SERIES_3.jpeg");
        img3Series.addLast("/imagenes/BMW_3SERIES_4.jpeg");
        
        //Mercedes-Benz E-Class
        CircularDoublyLinkedList<String> imgEClass = new CircularDoublyLinkedList<>();
        imgEClass.addLast("/imagenes/MercedesBenz_EClass_1.jpeg");
        imgEClass.addLast("/imagenes/MercedesBenz_EClass_2.jpeg");
        imgEClass.addLast("/imagenes/MercedesBenz_EClass_3.jpeg");
        imgEClass.addLast("/imagenes/MercedesBenz_EClass_4.jpeg");
        
        
        
        
        //Instancias vehiculos
        Utilitaria.vehiculos.addLast(new Vehicle(new Precio(12000, false), new Marca("Chevrolet",mChevrolet), "Spark", 2020, 80000, "Manual", 900, "Duran", "Diésel",new Usuario("Juan", "Munizaga", "0987654321", "juan@mail.co"), false, historialSpark, imgSpark));
        Utilitaria.vehiculos.addLast(new Vehicle(new Precio(15000, false), new Marca("Toyota",mToyota), "Corolla", 2018, 60000, "Automática", 1100, "Quito", "Gasolina", new Usuario("Maria","Layedra", "0987654321", "maria@mail.co"), true, historialCorolla, imgCorolla));
        Utilitaria.vehiculos.addLast(new Vehicle(new Precio(18000, false), new Marca("Honda",mHonda), "Civic", 2019, 70000, "Manual", 1000, "Guayaquil", "Híbrido",new Usuario("Pedro","Fonsi", "0987654321", "pedro@mail.co"), false,historialCivic, imgCivic));
        Utilitaria.vehiculos.addLast(new Vehicle(new Precio(20000, false), new Marca("Ford",mFord), "Mustang", 2017, 50000, "Automática", 1300, "Cuenca","Eléctrico", new Usuario("Laura","Pausini","0987654321", "laura@mail.co"), true, historialMustang, imgMustang));
        Utilitaria.vehiculos.addLast(new Vehicle(new Precio(22000, false), new Marca("Nissan",mNissan), "Sentra", 2021, 40000, "Manual", 1200, "Santo Domingo", "Diésel",new Usuario("Carlos","Mendoza", "0987654321", "carlos@mail.co"), false, historialSentra, imgSentra));
        Utilitaria.vehiculos.addLast(new Vehicle(new Precio(25000, false), new Marca("BMW",mBMW), "X5", 2016, 90000, "Automática", 1500, "Machala", "Gasolina", new Usuario("Annabella", "Sanchez", "0987654321", "ana@mail.co"), true, historialX5, imgX5));
        Utilitaria.vehiculos.addLast(new Vehicle(new Precio(28000, false), new Marca("Mercedes-Benz",mMercedes), "GLC", 2020, 80000, "Manual", 1400, "Durán", "Híbrido",new Usuario("David","Iglesias", "0987654321", "david@mail.co"), false, historialGLC, imgGLC));
        Utilitaria.vehiculos.addLast(new Vehicle(new Precio(30000, false), new Marca("Audi",mAudi), "Q5", 2019, 70000, "Automática", 1600, "Manta", "Eléctrico",new Usuario("Sofia","Castro", "0987654321", "sofia@mail.co"), true, historialQ5, imgQ5));
        Utilitaria.vehiculos.addLast(new Vehicle(new Precio(32000, false), new Marca("Chevrolet",mChevrolet), "Malibu", 2018, 60000, "Manual", 1800, "Portoviejo", "Diésel", new Usuario("Diego","Pascal", "0987654321", "diego@mail.co"), false, historialMalibu, imgMalibu));
        Utilitaria.vehiculos.addLast(new Vehicle(new Precio(35000, false), new Marca("Toyota",mToyota), "Camry", 2017, 50000, "Automática", 1700, "Loja","Gasolina",  new Usuario("Isabella", "Martin","0987654321", "isabella@mail.co"), true,historialCamry, imgCamry));
        Utilitaria.vehiculos.addLast(new Vehicle(new Precio(38000, false), new Marca("Honda",mHonda), "Accord", 2021, 40000, "Manual", 1900, "Ambato", "Híbrido",new Usuario("Andres", "Salazar", "0987654321", "andres@mail.co"), false, historialAccord, imgAccord));
        Utilitaria.vehiculos.addLast(new Vehicle(new Precio(40000, false), new Marca("Ford",mFord), "Explorer", 2016, 90000, "Automática", 2000, "Riobamba", "Eléctrico",new Usuario("Valeria", "Rodriguez", "0987654321", "valeria@mail.co"), true, historialExplorer, imgExplorer));
        Utilitaria.vehiculos.addLast(new Vehicle(new Precio(42000, false), new Marca("Nissan",mNissan), "Rogue", 2020, 80000, "Manual", 2200, "Esmeraldas","Diésel", new Usuario("Gabriel", "Flores","0987654321", "gabriel@mail.co"), false, historialRogue, imgRogue));
        Utilitaria.vehiculos.addLast(new Vehicle(new Precio(45000, false), new Marca("BMW",mBMW), "3 Series", 2019, 70000, "Automática", 2400, "Ibarra", "Gasolina", new Usuario("Valentina", "Cajas", "0987654321", "valentina@mail.co"), true, historial3Series,img3Series));
        Utilitaria.vehiculos.addLast(new Vehicle(new Precio(48000, false), new Marca("Mercedes-Benz",mMercedes), "E-Class", 2018, 60000, "Manual", 2600, "Quevedo","Híbrido", new Usuario("Javier", "Romero","0987654321", "javier@mail.co"), false, historialEClass, imgEClass));
        Utilitaria.saveListToFile("vehiculos.dat",Utilitaria.vehiculos);
        
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