package com.example.fxjava;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

   // ArrayList<Integer> numJugadores = new ArrayList<Integer>();
   // ArrayList<String> nivel = new ArrayList<String>();
    private int play;
    private Juego juego;


    @FXML
    private ComboBox<String> numeroDeJugadores;

    @FXML
    private ComboBox<String> nivelJuego;

    @FXML
    private Button iniciarJuego;

    @FXML
    private Button acercaDe;

    @FXML
    private Button aceptarNumeroParametros;

    @FXML
    private Label nuevoGanador;
    @FXML
    private AnchorPane parametros;

    @FXML
    private TextField txtNjugadores;

    @FXML
    private Label turnoJugador;

    @FXML
    private Label posicionesAvanzadas;

    @FXML
    private Label posicionesRestantes;

    @FXML
    private Label retornos;

    @FXML
    private Label image;

    @FXML
    private Label parUno, parDos;
    @FXML
    private Button parametrosConfiguracion;

    @FXML
    private Button nuevoJuego;

    @FXML
    void comenzarJuego(ActionEvent event) {
        nuevoJuego.setDisable(false);
        acercaDe.setDisable(false);
        lanzarJugador.setDisable(false);

        iniciarJuego.setDisable(true);
        parametrosConfiguracion.setDisable(true);

        numeroDeJugadores.setDisable(true);
        nivelJuego.setDisable(true);

        play = (int) (Math.random() * Integer.parseInt(numeroDeJugadores.getValue() + 1));
        lanzarJugador.setText("Lanza Jugador # " + play);
        int level = 0;

        if (nivelJuego.getValue().equalsIgnoreCase("Basico")) level = 20;
        else if (nivelJuego.getValue().equalsIgnoreCase("Medio"))level = 30;
        else level = 50;

        juego = new Juego(Integer.parseInt(numeroDeJugadores.getValue()), level, play - 1);

        turnoJugador.setText(juego.getPosicion() + 1 + " ");
        posicionesAvanzadas.setText(juego.getJugador().get(juego.getPosicion()).getPosAvanzadas() + "");
        posicionesRestantes.setText(juego.getJugador().get(juego.getPosicion()).getPosRestantes() + "");
        retornos.setText(juego.getJugador().get(juego.getPosicion()).getRetornos() + "");
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comoboBoxs();

        acercaDe.setDisable(true);
        nuevoJuego.setDisable(true);
        lanzarJugador.setDisable(true);
        play = 0;
    }


    void comoboBoxs (){
        ArrayList<String> lista = new ArrayList<>();
        Collections.addAll(lista, "Basico", "Medio", "Alto");
        nivelJuego.getItems().addAll(lista);
        nivelJuego.getSelectionModel().select(0);

        ArrayList<String> listaUno = new ArrayList<>();
        Collections.addAll(listaUno, "1", "2", "3", "4", "5");
        numeroDeJugadores.getItems().addAll(listaUno);
        numeroDeJugadores.getSelectionModel().select(1);
    }

    @FXML
    private Label dadoNumUno;

    @FXML
    private Label dadoNumDos;

    @FXML
    private Button lanzarJugador;

    @FXML
    void jugar(ActionEvent event) {
       // numeroDeJugadores.getValue();
      //  nivelJuego.getValue();

        int dadoNum1 = (int)(Math.random()* 6+1);
        int dadoNum2 = (int)(Math.random()* 6+1);

        dadoNumUno.setText(dadoNum1 + " ");
        dadoNumDos.setText(dadoNum2 + " ");
        dadosIguales();

        turnoJugador.setText(juego.getPosicion() + 1 + " ");
        posicionesAvanzadas.setText(juego.getJugador().get(juego.getPosicion()).getPosAvanzadas() + " ");
        posicionesRestantes.setText(juego.getJugador().get(juego.getPosicion()).getPosRestantes() + " ");
        retornos.setText(juego.getJugador().get(juego.getPosicion()).getRetornos() + " ");

        juego.prueba();
        juego.ronda(dadoNum1,dadoNum2);
        if (juego.hayGanador()) {
            hayGanador();
        }
        lanzarJugador.setText("Lanza jugador # " + turnoJugador.getText() + " ");
    }



    void hayGanador(){

        nuevoGanador.setText("GANADOR: " + juego.nombreGanador());
        posicionesAvanzadas.setText("**");
        posicionesRestantes.setText("**");
        retornos.setText("**");
        lanzarJugador.setDisable(true);
    }



    @FXML
    void   dadosIguales(){
        if (dadoNumUno.getText().equalsIgnoreCase(dadoNumDos.getText())) {
            parUno.setText(dadoNumUno.getText());
            parDos.setText(dadoNumUno.getText());
        }else{
            parUno.setText("**");
            parDos.setText("**");
        }
    }

   Configuracion control;



    @FXML
    void configuracion(ActionEvent event) throws IOException {

        Stage stage2 = new Stage();
        FXMLLoader loader = new FXMLLoader();
        AnchorPane root = (AnchorPane)loader.load(getClass().getResource("configuracion.fxml").openStream());
        control =(Configuracion) loader.getController();

        Scene scene = new Scene(root);
        stage2.setScene(scene);
        stage2.alwaysOnTopProperty();
        stage2.initModality(Modality.APPLICATION_MODAL);
        stage2.showAndWait();
        if(!control.numero.getText().equalsIgnoreCase(""))jugadores();
    }

    public ArrayList<String> numero(){
        ArrayList<String> numeroJugadores = new ArrayList<>();
        int num = Integer.parseInt(control.numero.getText());
        for(int i = 1; i <= num; i++){
            numeroJugadores.add(i + " ");
        }
        return numeroJugadores;
    }

    public void jugadores(){
        ArrayList<String> listaUno = numero();
        numeroDeJugadores.getItems().setAll(listaUno);
        numeroDeJugadores.getSelectionModel().select(0);
    }

    @FXML
    void informacion(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("informacion.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Rapidos y furiosos");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void siguiente(ActionEvent event) {
        parametros.setVisible(true);
    }
    @FXML
    void recibirDatosParametros(ActionEvent event) {
       // int num=5;
       int num = Integer.parseInt(txtNjugadores.getText()) ;
        numeroDeJugadores.getItems().clear();
        for (int i = 1; i <= num; i++) {
            numeroDeJugadores.getItems().add(String.valueOf(1));

        }
        numeroDeJugadores.getSelectionModel().select(0);

        parametros.setVisible(false);
    }
}