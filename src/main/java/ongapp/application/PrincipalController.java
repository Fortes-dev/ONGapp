package ongapp.application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

public class PrincipalController {

	// Botones para el men� principal

	@FXML
	Button buttonEmbajada;
	@FXML
	Button buttonSedes;
	@FXML
	Button buttonHealth;
	@FXML
	Button buttonSchools;
	@FXML
	SceneController escena = new SceneController();

	/**
	 * Bot�n de acceso a las sedes.
	 */
	@FXML
	public void handleButtonSedes(ActionEvent event) throws Exception {

		escena.switchToSedes(event);
	}

	/**
	 * Bot�n de acceso a las embajadas.
	 */
	@FXML
	public void handleButtonEmbajadas(ActionEvent event) throws Exception {

		escena.switchToEmbajadas(event);
	}

	/**
	 * Bot�n de acceso a salud.
	 */
	@FXML
	public void handleButtonHealth(ActionEvent event) throws Exception {
		if (event.getSource() == buttonHealth) {
			escena.switchToHealth(event);
		}
	}

	/**
	 * Bot�n de acceso a educaci�n.
	 */
	@FXML
	public void handleButtonSchools(ActionEvent event) throws Exception {

		escena.switchToSchools(event);
	}
}
