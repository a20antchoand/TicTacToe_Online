package com.example.tictactoe_online.controladors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tictactoe_online.R;

public class inici extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inici);
    }

    public void onClickJugar(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }
}


