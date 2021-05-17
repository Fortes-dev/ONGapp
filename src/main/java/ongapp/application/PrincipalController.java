package ongapp.application;


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
	public void handleButtonBack(ActionEvent event) throws Exception {
		if (event.getSource() == back) {
		escena.switchToSceneLogin(event);
		}
	}
	

	/**
	 * Bot�n de acceso al buscador de ONGs.
	 */
	@FXML
	public void handleButtonHealth(ActionEvent event) throws Exception {
		if (event.getSource() == buttonHealth) {
			escena.switchToHealth(event);
		}
	}


}
