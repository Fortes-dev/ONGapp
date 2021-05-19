package ongapp.application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.*;
import javafx.stage.Stage;
/**
 * Controlador general de escenas
 * @author carlos.fortes.medina && marco.testa.moreno
 *
 */
public class SceneController {
	/**
	 * Elementos del controlador
	 */
	private Stage stage;
	private Scene scene;
	private Parent root;
	/**
	 * Nos lleva a la escena de login
	 * @param event
	 * @throws IOException
	 */
	public void switchToSceneLogin(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/SceneLogin.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * Nos lleva a la escena de registro
	 * @param event
	 * @throws IOException
	 */
	public void switchToSceneRegister(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/SceneRegister.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	/**
	 * Nos lleva a la escena principal
	 * @param event
	 * @throws IOException
	 */
	public void switchToPrincipal(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Principal.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	/**
	 * Nos lleva a la escena de crud de ongs
	 * @param event
	 * @throws IOException
	 */
	public void switchToOngAdmin(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/OngAdmin.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	/**
	 * Nos lleva a la escena de lista de ongs
	 * @param event
	 * @throws IOException
	 */
	public void switchToOngFinderTable(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/OngFinderTable.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	

}
