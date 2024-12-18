package com.pmdm.notas.NotasAdapter.Entities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.pmdm.notas.NotasAdapter.Activities.NotasActivity;
import com.pmdm.notas.R;

import java.util.List;

public class NotaAmpliada extends AppCompatActivity {

    private EditText etTitulo;
    private EditText etData;
    private EditText etModulo;
    private Button btGardar;
    private Button btCancelar;

    int position = 0;

    private List<Nota> lNotas;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.nota_ampliada);

        etTitulo = (EditText) findViewById(R.id.cambiarTitulo);
        etData = (EditText) findViewById(R.id.cambiarData);
        etModulo = (EditText) findViewById(R.id.cambiarModulo);
        btGardar = (Button) findViewById(R.id.btGardar);
        btCancelar = (Button) findViewById(R.id.btCancelar);

        Intent intent = getIntent(); //recibir os datos
        position = intent.getExtras().getInt(NotasActivity.position);
    }

    public void gardarClick(){
        Intent datos_volta = new Intent();
        if(etTitulo.getText() != null){
            NotasActivity.notasList.get(position).getTitulo() = etTitulo.getText();
            datos_volta.putExtra()
        } else {
            Toast.makeText(getContext(), "O campo non pode estar vacío", Toast.LENGTH_SHORT).show();
        }
    }
}
