package ongapp.application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import ongapp.conector.Conector;
import ongapp.manager.UsuarioManager;
/**
 * @author carlos.fortes.medina
 * Controlador de la ventana Register
 */

public class RegisterController {
	/**
	 * Elementos de la escena
	 */
	@FXML
	Button buttonSubmit;
	@FXML
	Button back;
	@FXML
	TextField email;
	@FXML
	TextField username;
	@FXML
	PasswordField password;
	@FXML
	PasswordField passwordRepeat;
	@FXML
	SceneController escena = new SceneController();
	/**
	 * Constante final de error
	 */
	private static final String ERROR = "Register error";
	
	/**
	 * Registra un nuevo usuario
	 * @param event
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	@FXML
	public void handleSubmit(ActionEvent event) throws SQLException, ClassNotFoundException {
		Connection con = new Conector().getMySQLConnection();
		if(email.getText().length()!=0&&email.getText().endsWith("@gmail.com")
				||email.getText().endsWith("@outlook.com")) {
			if(username.getText().length()!=0) {
				if(password.getText().length()!=0&&password.getText().equals(passwordRepeat.getText())) {
					try {
						new UsuarioManager().createUsuario(con, email.getText(), username.getText(), password.getText());
						escena.switchToSceneLogin(event);
						con.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					AlertType type = AlertType.WARNING;
					Alert alert = new Alert(type, "");
					alert.getDialogPane().setHeaderText(ERROR);
					alert.getDialogPane().setContentText("Password confirmation does not match");
					alert.showAndWait();
				}
			} else {
				AlertType type = AlertType.WARNING;
				Alert alert = new Alert(type, "");
				alert.getDialogPane().setHeaderText(ERROR);
				alert.getDialogPane().setContentText("Insert a valid username");
				alert.showAndWait();
			}
		} else {
			AlertType type = AlertType.WARNING;
			Alert alert = new Alert(type, "");
			alert.getDialogPane().setHeaderText(ERROR);
			alert.getDialogPane().setContentText("Insert a valid email");
			alert.showAndWait();
		}
	}
	/**
	 * Nos devuelve a la escena anterior
	 * @param event
	 * @throws IOException
	 */
	public void handleBack(ActionEvent event) throws IOException {
		if(event.getSource()==back) {
			escena.switchToSceneLogin(event);
		}
	}
}
