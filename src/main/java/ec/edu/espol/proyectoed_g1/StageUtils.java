package ec.edu.espol.proyectoed_g1;

import javafx.scene.image.Image;
import javafx.stage.Stage;

public class StageUtils {

    public static void setStageIcon(Stage stage) {
        Image applicationIcon = new Image(StageUtils.class.getResourceAsStream("/imagenes/logo.png"));
        stage.getIcons().add(applicationIcon);
    }
}