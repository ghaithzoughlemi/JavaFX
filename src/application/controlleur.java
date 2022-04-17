package application;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class controlleur {

	@FXML
	private ListView<Chapitre> lesDonnees;

	File createFile(File fichier) {

		fichier = new File("d:/Profiles/gzoughlemi/Desktop/Sesame/fichiers_d_exercice_essentiel_de_java_9/JavaFX");

		if (fichier.exists()) {

			System.out.println("Le fichier existe !");
		} else {
			System.out.println("Le fichier n'existe pas !");
			try {
				fichier.createNewFile();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		return fichier;

	}

	@FXML
	private void remplir() {

		File file = null;

		Chapitre pers1 = new Chapitre("Ghaith");
		Chapitre pers2 = new Chapitre("Sondes");
		Chapitre pers3 = new Chapitre("Houssam");
		Chapitre pers4 = new Chapitre("Rym");

		ArrayList<Chapitre> listdata = new ArrayList<>();
		listdata.add(pers1);
		listdata.add(pers2);
		listdata.add(pers3);
		listdata.add(pers4);

		ObservableList<Chapitre> data = FXCollections.observableArrayList(pers1, pers2, pers3, pers4);
		lesDonnees.setItems(data);

		try {
			FileOutputStream pw = new FileOutputStream(createFile(file));
			try {
				ObjectOutputStream oos = new ObjectOutputStream(pw);

				oos.writeObject(listdata);

				oos.close();

			} catch (IOException e) {

				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}

	@FXML
	private void modifier() {
		Parent root;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("edit.fxml"));
			root = loader.load();
			Chapitre donnee = lesDonnees.getSelectionModel().getSelectedItem();
			((EditController) loader.getController()).init(donnee);

			Stage stage = new Stage();
			stage.setTitle("Modification des données");
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.showAndWait();
			lesDonnees.getSelectionModel().clearSelection();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@FXML
	private void fermer() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Fermeture de l'apli");
		alert.setHeaderText("Fermer");
		alert.setContentText("Voulez vous fermer l'apli");
		Optional<ButtonType> rep = alert.showAndWait();
		if (rep.get() == ButtonType.OK) {
			System.exit(0);
		}
	}
}
