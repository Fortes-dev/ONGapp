package ongapp.application;



import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import ongapp.conector.Conector;
import ongapp.dao.Ong;
import ongapp.manager.OngManager;

/**
 * @author carlos.fortes.medina
 *	Controlador de la lista de ongs
 */

public class OngFinderTableController {
	
	/**
	 * Elementos de la escena
	 */
	@FXML
	Button goBack;
	@FXML
	ChoiceBox<String> box = new ChoiceBox<String>();
	@FXML
	TextField searchBar;
	@FXML
	SceneController escena = new SceneController();
	@FXML
	TableView<Ong> tabla;
	@FXML
	private TableColumn<Ong, String> nameCol;
	@FXML
	private TableColumn<Ong, String> typeCol;
	@FXML
	private TableColumn<Ong, String> websiteCol;
	@FXML
	private TableColumn<Ong, String> cityCol;
	@FXML
	private TableColumn<Ong, String> locationCol;
	
	/**
	 * Rellena los campos de la TableView
	 * @param lista	Lista a partir de la que rellenar los campos de la tabla
	 */
	public void makeTable(List<Ong>lista) {
		ObservableList<Ong> listaObservable = FXCollections.observableArrayList(lista);
		tabla.setItems(listaObservable);
		
		nameCol.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getNombre()));
		typeCol.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getTipo()));
		websiteCol.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getWeb()));
		cityCol.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getCiudad()));
		locationCol.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getCalle()));
	}
	
	/**
	 * Método para inicializar la tabla en la escena
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@FXML
	public void initialize() throws ClassNotFoundException, SQLException {
		Connection con = new Conector().getMySQLConnection();
		List<Ong> lista = new OngManager().findAll(con);
		con.close();
		makeTable(lista);
		box.setItems(FXCollections.observableArrayList(
			    "All", "Name", "Type", "City"));
		box.setValue("All");
	}
	
	/**
	 * Busca en la barra de búsqueda
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@FXML
	public void searchBy() throws ClassNotFoundException, SQLException {
		if (box.getValue().equals("Name")) {
		Connection con = new Conector().getMySQLConnection();
		List<Ong> lista = new OngManager().findByNombre(con, searchBar.getText());
		con.close();
		makeTable(lista);
		} else if (box.getValue().equals("Type")) {
			Connection con = new Conector().getMySQLConnection();
			List<Ong> lista = new OngManager().findByTipo(con, searchBar.getText());
			con.close();
			makeTable(lista);
		} else if (box.getValue().equals("City")) {
			Connection con = new Conector().getMySQLConnection();
			List<Ong> lista = new OngManager().findByCiudad(con, searchBar.getText());
			con.close();
			makeTable(lista);
		} else if (box.getValue().equals("All")) {
			Connection con = new Conector().getMySQLConnection();
			List<Ong> lista = new OngManager().findAll(con);
			con.close();
			makeTable(lista);
		}
	}
	
	/**
	 * Nos devuelve a la escena anterior.
	 * @param event 
	 * @throws IOException
	 */
	@FXML
	public void handleGoBack(ActionEvent event) throws IOException {
		if(event.getSource()==goBack) {
			escena.switchToPrincipal(event);
		}
		
	}
}
