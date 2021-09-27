package com.example.fxjava;

import java.util.ArrayList;

public class Juego {

    private int numeroJugadores, nivelJuego,posicion;
    private ArrayList<Jugador> jugador;

    public Juego(int numeroJugadores, int nivel,int posicion) {
        this.numeroJugadores = numeroJugadores;
        jugador = nuevosJugadores();
        this.posicion = posicion;
        this.nivelJuego = nivel;
    }

    private ArrayList<Jugador> nuevosJugadores(){
        ArrayList<Jugador>play = new ArrayList<>();
        for(int i = 1; i<=numeroJugadores; i++){
            play.add(new Jugador(i + "" ,nivelJuego));
        }
        return play;
    }

    public void ronda(int avanzo1,int avanzo2){
        devolver(jugador.get(posicion).getPosAvanzadas()+(avanzo1+avanzo2));
        jugador.get(posicion).avanzar(avanzo1 + avanzo2);
        if(avanzo1 != avanzo2){
            if(posicion < numeroJugadores - 1)posicion++;
            else posicion = 0;
        }
    }
    public void devolver(int dev){
        for(int i = 0; i<jugador.size();i++){
            if( jugador.get(i).getPosAvanzadas() == dev)jugador.get(i).reiniciar();
        }
    }
    public void prueba(){
        System.out.println("****PRUEBA****");
        System.out.println("id -> "+jugador.get(posicion).getId());
        System.out.println("avanzadas -> "+jugador.get(posicion).getPosAvanzadas());
    }

    public boolean hayGanador(){
        boolean ganador = false;
        for(Jugador K: jugador){
            if(K.getPosAvanzadas() >= K.getNivel()){
                ganador = true;
            }
        }
        return ganador;
    }

    public int nombreGanador(){
        boolean ganador = false;
        for(Jugador a: jugador){
            if(a.getPosAvanzadas() >= a.getNivel()){
                return  Integer.parseInt(a.getId());
            }
        }
        return -1;
    }

    public ArrayList<Jugador> getJugador() {

        return jugador;
    }

    public void setJugador(ArrayList<Jugador> jugador) {

        this.jugador = jugador;
    }

    public int getNumeroDeJugadores() {

        return numeroJugadores;
    }

    public void setNumeroDeJugadores(int numeroDeJugadores) {

        this.numeroJugadores = numeroDeJugadores;
    }

    public int getNivelJuego() {

        return nivelJuego;
    }

    public void setNivelJuego(int nivelJuego) {

        this.nivelJuego = nivelJuego;
    }

    public int getPosicion() {

        return posicion;
    }

    public void setPosicion(int posicion) {

        this.posicion = posicion;
    }


}
