package com.example.tictactoe_online.recyclerView;

import android.graphics.Bitmap;

import com.example.tictactoe_online.clases.Partida;
import com.google.firebase.firestore.DocumentReference;

import java.io.Serializable;

public class ListElementPartidas implements Serializable {

    String docref;
    Partida partida;

    public ListElementPartidas(String docRef, Partida partida) {
        this.docref = docRef;
        this.partida = partida;
    }

    public String getDocref() {
        return docref;
    }

    public void setDocref(String docref) {
        this.docref = docref;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }
}