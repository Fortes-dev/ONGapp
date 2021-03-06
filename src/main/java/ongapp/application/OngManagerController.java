package ongapp.application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import ongapp.conector.Conector;
import ongapp.manager.OngManager;
/**
 * Controlador del CRUD de ongs
 * @author carlos.fortes.medina & marco.testa.moreno
 *
 */
public class OngManagerController {
	/**
	 * Elementos de la escena
	 */
	@FXML
	private Button submit;
	@FXML
	private Button delete;
	@FXML
	private Button back;
	@FXML
	private Button modify;
	@FXML
	private TextField nameRegister;
	@FXML
	private TextField typeRegister;
	@FXML
	private TextField webRegister;
	@FXML
	private TextField cityRegister;
	@FXML
	private TextField addressRegister;
	@FXML
	private TextField nameDelete;
	@FXML
	private TextField nameModify;
	@FXML
	private TextField newNameModify;
	@FXML
	private TextField typeModify;
	@FXML
	private TextField webModify;
	@FXML
	private TextField cityModify;
	@FXML
	private TextField addressModify;
	@FXML
	private SceneController escena = new SceneController();
	/**
	 * Nos devuelve a la escena anterior
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void handleBack(ActionEvent event) throws IOException {
		if(event.getSource()==back) {
			escena.switchToPrincipal(event);
		}
	}
	/**
	 * Inserta una nueva ong
	 * @param event
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@FXML
	public void handleSubmit(ActionEvent event) throws ClassNotFoundException, SQLException {
		Connection con = new Conector().getMySQLConnection();
		if(nameRegister.getText().length()!=0&&typeRegister.getText().length()!=0
				&&cityRegister.getText().length()!=0) {
			try {
			new OngManager().createOng(con, nameRegister.getText(), 
					typeRegister.getText(), webRegister.getText(), 
					cityRegister.getText(), addressRegister.getText());
			con.close();
			AlertType type = AlertType.CONFIRMATION;
			Alert alert = new Alert(type, "");
			alert.getDialogPane().setHeaderText("Insert Completed!");
			alert.showAndWait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			AlertType type = AlertType.WARNING;
			Alert alert = new Alert(type, "");
			alert.getDialogPane().setHeaderText("Error");
			alert.getDialogPane().setContentText("Insert atleast a name");
			alert.showAndWait();
		}
	}
	/**
	 * Borra una ong
	 * @param event
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@FXML
	public void handleDelete(ActionEvent event) throws ClassNotFoundException, SQLException {
		
		if(nameDelete.getText().length()!=0) {
			try {
				Connection con = new Conector().getMySQLConnection();
			new OngManager().deleteOng(con, nameDelete.getText());
			con.close();
			AlertType type = AlertType.CONFIRMATION;
			Alert alert = new Alert(type, "");
			alert.getDialogPane().setHeaderText("Delete Completed!");
			alert.showAndWait();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			AlertType type = AlertType.WARNING;
			Alert alert = new Alert(type, "");
			alert.getDialogPane().setHeaderText("Error");
			alert.getDialogPane().setContentText("Insert a valid name of ONG to delete");
			alert.showAndWait();
		}
	}
	/**
	 * Modifica ong existente
	 * @param event
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@FXML
	public void handleModify(ActionEvent event) throws ClassNotFoundException, SQLException {
		
		if (nameModify.getText().length()!=0) {
			try {
				Connection con = new Conector().getMySQLConnection();
			new OngManager().modifyOng(con, newNameModify.getText(), typeModify.getText(), webModify.getText(), 
					cityModify.getText(), addressModify.getText(), nameModify.getText());
			con.close();
			AlertType type = AlertType.CONFIRMATION;
			Alert alert = new Alert(type, "");
			alert.getDialogPane().setHeaderText("Modification Completed!");
			alert.showAndWait();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			AlertType type = AlertType.WARNING;
			Alert alert = new Alert(type, "");
			alert.getDialogPane().setHeaderText("Error");
			alert.getDialogPane().setContentText("Insert a valid name of ONG to modify");
			alert.showAndWait();
		}
	}
}
