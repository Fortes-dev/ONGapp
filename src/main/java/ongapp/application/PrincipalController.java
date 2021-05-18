package ongapp.application;

import java.io.IOException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
/**
 * Controlador de la escena principal
 * @author carlos.fortes.medina
 *
 */

public class PrincipalController {

	/**
	 * Elementos de la escena
	 */
	@FXML
	Button back;
	@FXML
	Button ongManager;
	@FXML
	Button buttonHealth;
	@FXML
	SceneController escena = new SceneController();
	@FXML
	LoginController rol = new LoginController();

	/**
	 * Nos devuelve a la escena anterior
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void handleButtonBack(ActionEvent event) throws IOException {
		if (event.getSource() == back) {
			escena.switchToSceneLogin(event);
		}
	}

	/**
	 * Accede a la escena del controlador de lista de ongs
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void handleButtonHealth(ActionEvent event) throws IOException {
		if (event.getSource() == buttonHealth) {
			escena.switchToOngFinderTable(event);
		}
	}
	/**
	 * Accede a la escena del controlador CRUD de ongs
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void handleButtonOngManager(ActionEvent event) throws IOException {
		if (event.getSource() == ongManager) {
			escena.switchToOngAdmin(event);
		}

	}
}
