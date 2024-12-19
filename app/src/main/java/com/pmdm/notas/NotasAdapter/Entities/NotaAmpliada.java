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

import java.io.Serializable;
import java.util.ArrayList;

public class NotaAmpliada extends AppCompatActivity {

    private EditText etTitulo;
    private EditText etData;
    private EditText etModulo;
    private Button btGardar;
    private Button btCancelar;

    int position = 0;

    ArrayList<Nota> lNotas;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.nota_ampliada);

        etTitulo = (EditText) findViewById(R.id.cambiarTitulo);
        etData = (EditText) findViewById(R.id.cambiarData);
        etModulo = (EditText) findViewById(R.id.cambiarModulo);
        btGardar = (Button) findViewById(R.id.btGardar);
        btCancelar = (Button) findViewById(R.id.btCancelar);

        Intent intent = getIntent();
        // recibese o arrayLis
        lNotas = (ArrayList<Nota>) intent.getSerializableExtra("notasList");
        position = intent.getExtras().getInt("posicion");

//        for(int i = 0; i < lNotas.size(); i++){
//            Toast.makeText(this, lNotas.get(i).getTitulo(), Toast.LENGTH_SHORT).show();
//        }

        etTitulo.setText(lNotas.get(position).getTitulo());
        etData.setText(lNotas.get(position).getData());
        etModulo.setText(lNotas.get(position).getModulo());

        btGardar.setOnClickListener(view -> gardarClick(position));
        btCancelar.setOnClickListener(view -> cancelarClick());
    }

    public void gardarClick(int position){
        Intent datos_volta = new Intent(NotaAmpliada.this, NotasActivity.class);

        if(etTitulo.getText() != null && etData.getText() != null && etModulo.getText() != null){
            Toast.makeText(this, "Gardando cambios...", Toast.LENGTH_SHORT).show();

            lNotas.get(position).setTitulo(etTitulo.getText().toString());
            lNotas.get(position).setData(etData.getText().toString());
            lNotas.get(position).setModulo(etModulo.getText().toString());

            //devolver datos...
//            datos_volta.putExtra("notasList", (Serializable) lNotas);
//            datos_volta.putExtra("posicion", position);

//            setResult(RESULT_OK, datos_volta);

            startActivity(datos_volta);
            super.finish();
        } else {
            Toast.makeText(this, "Ningún campo non pode estar vacío", Toast.LENGTH_SHORT).show();
        }
    }

    public void cancelarClick(){
        Intent i = new Intent(NotaAmpliada.this, NotasActivity.class);
        startActivity(i);
        super.finish();
    }
}
