package com.pmdm.notas.NotasAdapter.Entities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.pmdm.notas.NotasAdapter.Activities.NotasActivity;
import com.pmdm.notas.R;

import java.util.List;

public class NotaAmpliada extends AppCompatActivity {

    private EditText etTitulo;
    private EditText etData;
    private EditText etModulo;

    int position = 0;

    private List<Nota> lNotas;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.nota_ampliada);

        etTitulo = (EditText) findViewById(R.id.cambiarTitulo);
        etData = (EditText) findViewById(R.id.cambiarData);
        etModulo = (EditText) findViewById(R.id.cambiarModulo);

        Intent intent = getIntent();
       // position = intent.getExtras().getInt(NotasActivity.position);
       // etTitulo.setText(intent.getExtras()
       //         .getString(NotasActivity.notasList.get(position).getTitulo()));
    }
}
