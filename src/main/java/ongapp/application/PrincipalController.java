package ongapp.application;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.*;
import javafx.stage.Stage;

public class PrincipalController {

	@FXML
	Button buttonSedes;
	@FXML
	Button buttonRegister;
	@FXML
	SceneController escena = new SceneController();

	/**
	 * Botón de registo, nos lleva a la ventana Register
	 */
	@FXML
	public void handlePrincipal(ActionEvent event) throws Exception {
		
		escena.switchToSedes(event);

	}
}
