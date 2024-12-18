package com.pmdm.notas.NotasAdapter.Entities;

import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class NotaAmpliada extends AppCompatActivity {

    private EditText etTitulo;
    private EditText etData;
    private EditText etModulo;

    private List<Nota> lNotas;

        
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
}
