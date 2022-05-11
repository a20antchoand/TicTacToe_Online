package com.example.tictactoe_online.controladors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import com.example.tictactoe_online.R;
import com.example.tictactoe_online.clases.Partida;
import com.example.tictactoe_online.commons.ReadData;
import com.example.tictactoe_online.commons.WriteData;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class PartidaControlador extends AppCompatActivity implements ReadData, WriteData {

    String idPartida;
    String idUsuari;
    Partida partida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partida);

        idPartida = getIntent().getStringExtra("partida");
        idUsuari = getIntent().getStringExtra("usuari");

        getOneDocument(FirebaseFirestore.getInstance().collection("partidas").document(idPartida), this::guardarPartida);

        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

    }

    private void guardarPartida(Task<DocumentSnapshot> documentSnapshotTask) {

        if (documentSnapshotTask.isSuccessful()) {

            if (documentSnapshotTask.getResult() != null) {

                partida = documentSnapshotTask.getResult().toObject(Partida.class);

                System.out.println(partida.getJugadors().get(0));

            }

        }

    }

    @Override
    public boolean onSupportNavigateUp() {

        if (partida.getJugadors().get(0).equals(idUsuari)) {
            partida.getJugadors().remove(0);
        } else {
            partida.getJugadors().remove(1);
        }

        writeOneDocument(FirebaseFirestore.getInstance().collection("partidas").document(idPartida), partida);
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}