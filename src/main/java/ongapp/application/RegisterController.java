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
	@FXML
	Button buttonSubmit;
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
	 * Bot�n de submit, registra en la base de datos un nuevo usuario
	 */
	@FXML
	public void handleSubmit(ActionEvent event) throws SQLException, ClassNotFoundException {
		Connection con = new Conector().getMySQLConnection();
		if(email.getText()!=null&&email.getText().endsWith("@gmail.com")
				||email.getText().endsWith("@outlook.com")) {
			if(username.getText()!=null) {
				if(password.getText()!=null&&password.getText().equals(passwordRepeat.getText())) {
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
					alert.getDialogPane().setHeaderText("Register error");
					alert.getDialogPane().setContentText("Password confirmation does not match");
					alert.showAndWait();
				}
			} else {
				AlertType type = AlertType.WARNING;
				Alert alert = new Alert(type, "");
				alert.getDialogPane().setHeaderText("Register error");
				alert.getDialogPane().setContentText("Insert a valid username");
				alert.showAndWait();
			}
		} else {
			AlertType type = AlertType.WARNING;
			Alert alert = new Alert(type, "");
			alert.getDialogPane().setHeaderText("Register error");
			alert.getDialogPane().setContentText("Insert a valid email");
			alert.showAndWait();
		}
	}
}
