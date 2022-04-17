package application;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXML;


public class EditController {
	Chapitre data;
	
	void init(Chapitre data) {
		this.data = data;
		texte.setText(data.toString());
	}
	
	@FXML
	private TextField texte;
	
	@FXML
	private void ok() {
		
		data.setNom(texte.getText());
		Stage stage = (Stage) texte.getScene().getWindow();
		stage.close();
		
	}
	
	@FXML
	private void fermer() {
		Stage stage = (Stage) texte.getScene().getWindow();
		stage.close();
	}

}
