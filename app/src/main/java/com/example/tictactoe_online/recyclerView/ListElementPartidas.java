package com.example.tictactoe_online.recyclerView;

import android.graphics.Bitmap;

import java.io.Serializable;

public class ListElementPartidas implements Serializable {

    String uid;
    String nom;

    public ListElementPartidas(String nom, String uid) {
        this.nom = nom;
        this.uid = uid;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }


}