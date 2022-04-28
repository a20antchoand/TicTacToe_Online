package com.example.tictactoe_online;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.tictactoe_online.recyclerView.ListAdapterPartidas;
import com.example.tictactoe_online.recyclerView.ListElementPartidas;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ReadData, WriteData {

    List<ListElementPartidas> listElements = new ArrayList<>();
    ListAdapterPartidas listAdapter;

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

        listAdapter = new ListAdapterPartidas(listElements, this, this::showName);
        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);

    }

    private void showName(ListElementPartidas listElementPartidas, View view) {

        System.out.println(listElementPartidas.getNom());

    }

    private void actualizarPartidas(Task<Void> voidTask) {

        Toast.makeText(this, "S'HA CREAT UNA NOVA PARTIDA", Toast.LENGTH_SHORT).show();

    }

    private void actualizarPartidas(QuerySnapshot queryDocumentSnapshots, FirebaseFirestoreException e) {

        listElements.clear();

        for (DocumentSnapshot document : queryDocumentSnapshots) {

            Partida temporal = document.toObject(Partida.class);

            addListElementPartidas(temporal, document);

        }

    }

    private void addListElementPartidas(Partida partida, DocumentSnapshot document) {

        String nom = partida.getCreador().substring(0, 1).toUpperCase() + partida.getCreador().substring(1);
        String uid = document.getId();
        listElements.add(new ListElementPartidas(
                nom ,
                uid));


        listAdapter.notifyDataSetChanged();

    }
}