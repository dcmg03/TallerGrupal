package com.example.fxjava;

public class Jugador {

    private String id;
    private int posAvanzadas, posRestantes,Retornos, nivel;

    public Jugador(String id, int nivel) {
        this.id = id;

        posRestantes = nivel;
        Retornos = 0;
        this.nivel = nivel;
        posAvanzadas = 0;
    }
/**posiciones que avanza un jugador*/
    public void avanzar(int posAvanzadas) {
        this.posAvanzadas += posAvanzadas;
        posRestantes -= posAvanzadas;
    }
/** metodo que realiza los retornos del jugador X cada vez q es alcanzado por otro jugador*/
    public void retornos() {
        posRestantes = posAvanzadas + posRestantes;
        posAvanzadas = 0;
        Retornos ++;
    }
/** reinicia el juego */
    public void reiniciar(){
        posAvanzadas = 0;
        posRestantes = nivel;
        Retornos++;
    }

    /**
     * @return the nivel
     */
    public int getNivel() {

        return nivel;
    }

    /**
     * @param nivel the nivel to set
     */
    public void setNivel(int nivel) {

        this.nivel = nivel;
    }

    /**
     * @return the id
     */
    public String getId() {

        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {

        this.id = id;
    }

    /**
     * @return the posAvanzadas
     */
    public int getPosAvanzadas() {
        return posAvanzadas;
    }

    /**
     * @param posAvanzadas the posAvanzadas to set
     */
    public void setPosAvanzadas(int posAvanzadas) {

        this.posAvanzadas = posAvanzadas;
    }

    /**
     * @return the posRestantes
     */
    public int getPosRestantes() {

        return posRestantes;
    }

    /**
     * @param posRestantes the posRestantes to set
     */
    public void setPosRestantes(int posRestantes) {

        this.posRestantes = posRestantes;
    }

    /**
     * @return the retornos
     */
    public int getRetornos() {

        return Retornos;
    }

    /**
     * @param retornos the retornos to set
     */
    public void setRetornos(int retornos) {

        Retornos = retornos;
    }

}
