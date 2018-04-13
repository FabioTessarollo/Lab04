package it.polito.tdp.lab04.controller;

import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class SegreteriaStudentiController {
	
	private Model model;
	private List<Corso> corsi;

    @FXML
    private ResourceBundle resources;
    
    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCognome;
    
    @FXML
    private TextArea txtResult;
    
    @FXML
    private TextField txtMatricola;
    
    @FXML
    private ChoiceBox<Corso> ChoiseBox;

    @FXML
    private URL location;

    @FXML
    private Button btnCercaIscritti;

    @FXML
    private ImageView btnCompletamento;

    @FXML
    private Button btnCercaCorsi;

    @FXML
    private Button btnIscrivi;

    @FXML
    private Button btnReset;

    @FXML
    void doCercaCorsi(ActionEvent event) {
    	
    	int matricola = Integer.parseInt(txtMatricola.getText());
    	
    	try {
    		txtResult.appendText(model.cercaCorsiDatoStudente(model.getStudente(matricola)).toString());	
    	} catch (RuntimeException e) {
			txtResult.setText("ERRORE DI CONNESSIONE AL DATABASE!");
		}
    	
    	
    	
    }

    @FXML
    void doCercaIscritti(ActionEvent event) {
    	
		txtResult.clear();
		txtNome.clear();
		txtCognome.clear();

		try {

			Corso corso = ChoiseBox.getValue();
			if (corso == null) {
				txtResult.setText("Selezionare un corso.");
				return;
			}

			List<Studente> studenti = model.studentiIscrittiAlCorso(corso);

			StringBuilder sb = new StringBuilder();

			for (Studente studente : studenti) {

				sb.append(String.format("%-10s ", studente.getMatricola()));
				sb.append(String.format("%-20s ", studente.getCognome()));
				sb.append(String.format("%-20s ", studente.getNome()));
				sb.append(String.format("%-10s ", studente.getCDS()));
				sb.append("\n");
			}

			txtResult.appendText(sb.toString());

		} catch (RuntimeException e) {
			txtResult.setText("ERRORE DI CONNESSIONE AL DATABASE!");
		}
    	


    }

    @FXML
    void doCompletamento(MouseEvent event) {

    }

    @FXML
    void doIscrivi(ActionEvent event) {

    }

    @FXML
    void doReset(ActionEvent event) {

    }
    
    private void setItems() {
    	
    	corsi = model.getTuttiICorsi();
    	
    	Collections.sort(corsi);
    	ChoiseBox.getItems().addAll(corsi);
    	
    }

    @FXML
    void initialize() {
        assert btnCercaIscritti != null : "fx:id=\"btnCercaIscritti\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCompletamento != null : "fx:id=\"btnCompletamento\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";

    }

	public void setModel(Model model) {
		this.model = model;
		this.setItems();
	}
}
