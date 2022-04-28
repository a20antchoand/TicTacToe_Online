package com.example.tictactoe_online;

public class Partida {

    String creador = "";
    String jugador = "";
    String ganador = "";
    String casella_1 = "";
    String casella_2 = "";
    String casella_3 = "";
    String casella_4 = "";
    String casella_5 = "";
    String casella_6 = "";
    String casella_7 = "";
    String casella_8 = "";
    String casella_9 = "";

    public Partida() {

    }

    public Partida(String creador) {
        this.creador = creador;
    }

    public Partida(String creador, String jugador, String ganador, String casella_1, String casella_2, String casella_3, String casella_4, String casella_5, String casella_6, String casella_7, String casella_8, String casella_9) {
        this.creador = creador;
        this.jugador = jugador;
        this.ganador = ganador;
        this.casella_1 = casella_1;
        this.casella_2 = casella_2;
        this.casella_3 = casella_3;
        this.casella_4 = casella_4;
        this.casella_5 = casella_5;
        this.casella_6 = casella_6;
        this.casella_7 = casella_7;
        this.casella_8 = casella_8;
        this.casella_9 = casella_9;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public String getGanador() {
        return ganador;
    }

    public void setGanador(String ganador) {
        this.ganador = ganador;
    }

    public String getCasella_1() {
        return casella_1;
    }

    public void setCasella_1(String casella_1) {
        this.casella_1 = casella_1;
    }

    public String getCasella_2() {
        return casella_2;
    }

    public void setCasella_2(String casella_2) {
        this.casella_2 = casella_2;
    }

    public String getCasella_3() {
        return casella_3;
    }

    public void setCasella_3(String casella_3) {
        this.casella_3 = casella_3;
    }

    public String getCasella_4() {
        return casella_4;
    }

    public void setCasella_4(String casella_4) {
        this.casella_4 = casella_4;
    }

    public String getCasella_5() {
        return casella_5;
    }

    public void setCasella_5(String casella_5) {
        this.casella_5 = casella_5;
    }

    public String getCasella_6() {
        return casella_6;
    }

    public void setCasella_6(String casella_6) {
        this.casella_6 = casella_6;
    }

    public String getCasella_7() {
        return casella_7;
    }

    public void setCasella_7(String casella_7) {
        this.casella_7 = casella_7;
    }

    public String getCasella_8() {
        return casella_8;
    }

    public void setCasella_8(String casella_8) {
        this.casella_8 = casella_8;
    }

    public String getCasella_9() {
        return casella_9;
    }

    public void setCasella_9(String casella_9) {
        this.casella_9 = casella_9;
    }
}
