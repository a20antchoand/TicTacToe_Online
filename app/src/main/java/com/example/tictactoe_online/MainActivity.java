package com.example.tictactoe_online;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

public class MainActivity extends AppCompatActivity implements ReadData, WriteData {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        setup();
        
    }
    
    public void setup() {

        getListenerDocument(FirebaseFirestore.getInstance().collection("partidas"), this::actualizarPartidas);

        Button button = findViewById(R.id.button);

        button.setOnClickListener(l -> {

            Partida partida = new Partida();

            writeOneDocument(FirebaseFirestore.getInstance().collection("partidas").document("Partida_" + Math.random()), partida, this::actualizarPartidas);

        });

        
    }

    private void actualizarPartidas(Task<Void> voidTask) {

        Toast.makeText(this, "S'HA CREAT UNA NOVA PARTIDA", Toast.LENGTH_SHORT).show();

    }

    private void actualizarPartidas(QuerySnapshot queryDocumentSnapshots, FirebaseFirestoreException e) {

        LinearLayout linearLayout = findViewById(R.id.linearPartidas);
        linearLayout.removeAllViews();

        for (DocumentSnapshot document : queryDocumentSnapshots) {

            Partida temporal = document.toObject(Partida.class);

            TextView tv = new TextView(this);

            tv.setText("Partida creada per: " + temporal.getCreador() + "\n");

            linearLayout.addView(tv);

        }

    }

}