package ongapp.application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

/**
 * Main de la app
 * @author carlos.fortes.medina
 *
 */

public class Main extends Application {
	
	/**
	 * Inicia el stage y lo mantiene durante toda la ejecucion de la app
	 */
	@Override
	public void start(Stage stage) {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/SceneLogin.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			stage.setTitle("Inmigrapp");
			stage.getIcons().add(new Image("images/kisspng-hand-drawing-6515307621006106.png"));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	public static void main (String[]args) {
		launch(args);
	}	
}
