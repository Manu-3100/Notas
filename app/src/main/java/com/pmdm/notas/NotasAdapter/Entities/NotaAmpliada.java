package com.pmdm.notas.NotasAdapter.Entities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.pmdm.notas.NotasAdapter.Activities.NotasActivity;
import com.pmdm.notas.R;

import java.util.ArrayList;

public class NotaAmpliada extends AppCompatActivity {

    private EditText etTitulo;
    private EditText etData;
    private EditText etModulo;

    int position = 0;

    private ArrayList<Nota> lNotas;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.nota_ampliada);

        etTitulo = (EditText) findViewById(R.id.cambiarTitulo);
        etData = (EditText) findViewById(R.id.cambiarData);
        etModulo = (EditText) findViewById(R.id.cambiarModulo);

        Intent intent = getIntent();
        // recibese o arrayLis
        lNotas = (ArrayList<Nota>) intent.getSerializableExtra("notasList");
        position = intent.getExtras().getInt("posicion");

        for(int i = 0; i < lNotas.size(); i++){
            Toast.makeText(this, lNotas.get(i).getTitulo(), Toast.LENGTH_SHORT).show();
        }
       // position = intent.getExtras().getInt(NotasActivity.position);
       // etTitulo.setText(intent.getExtras()
       //         .getString(NotasActivity.notasList.get(position).getTitulo()));
    }
}
