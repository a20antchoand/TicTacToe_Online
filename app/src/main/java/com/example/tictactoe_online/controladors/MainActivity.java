package com.example.tictactoe_online.controladors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tictactoe_online.R;
import com.example.tictactoe_online.commons.ReadData;
import com.example.tictactoe_online.commons.WriteData;
import com.example.tictactoe_online.clases.Partida;
import com.example.tictactoe_online.recyclerView.ListAdapterPartidas;
import com.example.tictactoe_online.recyclerView.ListElementPartidas;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.io.Serializable;
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

            EditText et = findViewById(R.id.editTextTextPersonName);

            if (!et.getText().toString().equals("")) {
                Partida partida = new Partida(et.getText().toString());
                writeOneDocument(FirebaseFirestore.getInstance().collection("partidas").document("Partida_" + Math.random()), partida, this::actualizarPartidas);
            } else {
                Toast.makeText(this, "Has d'introduir un nom de jugador", Toast.LENGTH_SHORT).show();
            }

        });

        listAdapter = new ListAdapterPartidas(listElements, this, this::showName);
        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);

    }

    private void showName(ListElementPartidas listElementPartidas) {

        EditText et = findViewById(R.id.editTextTextPersonName);

        if (!et.getText().toString().equals("")) {

            System.out.println("AQUI ESTIC");

            Partida partida = listElementPartidas.getPartida();
            partida.getJugadors().add(et.getText().toString());

            writeOneDocument(FirebaseFirestore.getInstance().collection("partidas").document(listElementPartidas.getDocref()), partida, null);

            Intent intent = new Intent(this, PartidaControlador.class);
            intent.putExtra("partida", listElementPartidas.getDocref());
            intent.putExtra("usuari", et.getText().toString());
            startActivity(intent);
        } else {
            Toast.makeText(this, "Has d'introduir un nom de jugador", Toast.LENGTH_SHORT).show();
        }
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

        listElements.add(new ListElementPartidas(
                document.getId() ,
                partida));


        listAdapter.notifyDataSetChanged();

    }
}