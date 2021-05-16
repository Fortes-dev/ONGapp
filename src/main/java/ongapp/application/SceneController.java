package ongapp.application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.*;
import javafx.stage.Stage;

public class SceneController {

	private Stage stage;
	private Scene scene;
	private Parent root;

	public void switchToSceneLogin(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/SceneLogin.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	
	public void switchToSceneRegister(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/SceneRegister.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void switchToPrincipal(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Principal.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToSedes(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Sedes.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToEmbajadas(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Embajadas.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToHealth(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Health.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToSchools(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Schools.fxml"));

		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
