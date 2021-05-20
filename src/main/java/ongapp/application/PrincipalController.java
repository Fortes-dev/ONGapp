package ongapp.application;

import java.io.IOException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
/**
 * Controlador de la escena principal
 * @author carlos.fortes.medina & marco.testa.moreno
 *
 */

public class PrincipalController {

	/**
	 * Elementos de la escena
	 */
	@FXML
	private Button back;
	@FXML
	private Button ongManager;
	@FXML
	private Button buttonHealth;
	@FXML
	private SceneController escena = new SceneController();
	@FXML
	private LoginController rol = new LoginController();

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
