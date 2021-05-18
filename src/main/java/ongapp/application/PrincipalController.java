package ongapp.application;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

public class PrincipalController {

	// Botones para el men� principal
	@FXML
	Button back;
	@FXML
	Button ongManager;
	@FXML
	Button buttonHealth;
	@FXML
	SceneController escena = new SceneController();

	/**
	 * Bot�n de acceso a las sedes.
	 */
	@FXML
	public void handleButtonBack(ActionEvent event) throws IOException {
		if (event.getSource() == back) {
		escena.switchToSceneLogin(event);
		}
	}
	

	/**
	 * Bot�n de acceso al buscador de ONGs.
	 */
	@FXML
	public void handleButtonHealth(ActionEvent event) throws IOException {
		if (event.getSource() == buttonHealth) {
			escena.switchToHealth(event);
		}
	}
	
	public void handleButtonOngManager(ActionEvent event) throws IOException {
		if (event.getSource() == ongManager) {
			escena.switchToOngAdmin(event);
		}
	}


}
