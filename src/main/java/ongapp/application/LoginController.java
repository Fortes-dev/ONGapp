package ongapp.application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import ongapp.conector.Conector;
import ongapp.manager.UsuarioManager;

/**
 * @author carlos.fortes.medina && marco.testa.moreno
 *	Controlador de la ventana de Login
 */
public class LoginController {
/**
 * Elementos de la escena
 */
	@FXML
	Button buttonLogin;
	@FXML
	Button buttonRegister;
	@FXML
	TextField username;
	@FXML
	PasswordField password;
	@FXML
	SceneController escena = new SceneController();
	
	/**
	 * Dirige a la escena de registro
	 * @param event
	 * @throws Exception
	 */
	@FXML
	public void handleRegister(ActionEvent event) throws Exception {
		if (event.getSource() == buttonRegister) {

			escena.switchToSceneRegister(event);
		}
	}
	/**
	 * Confirma que el usuario existe y cambia a la escena principal.
	 * @param event
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	@FXML
	public void handleLogin(ActionEvent event) throws SQLException, ClassNotFoundException {
		Connection con = new Conector().getMySQLConnection();
		if (username.getText().equals
				(new UsuarioManager().findLoginUser(con, username.getText()))
				&& password.getText().equals
				(new UsuarioManager().findLoginPassword(con, password.getText()))) {
			try {
				escena.switchToPrincipal(event);
				con.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			AlertType type = AlertType.WARNING;
			Alert alert = new Alert(type, "");
			alert.getDialogPane().setHeaderText("Login error");
			alert.getDialogPane().setContentText("Insert a valid username and password");
			alert.showAndWait();
		}
	}
}
