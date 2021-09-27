package com.example.fxjava;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Configuracion implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        advertencia.setVisible(false);
    }



    @FXML
    private Button aceptar,cancelar;
    @FXML
    public TextField numero;

    @FXML
    private Label advertencia;

    @FXML
    public void Confirmar(ActionEvent event){
        Object objeto = event.getSource();

        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();

        if(objeto.equals(aceptar)){
            if (!numero.getText().equalsIgnoreCase(" "))stage.close();
            else advertencia.setVisible(true);
        }else if (objeto.equals(cancelar)){
            numero.setText(" ");
            stage.close();
        }
    }


}
