package ongapp.application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;


public class HealthController {

	
	@FXML
	ObservableList<String> items = FXCollections.observableArrayList();



	@FXML
	ComboBox<String> cbx = new ComboBox<>(items);
	
}
