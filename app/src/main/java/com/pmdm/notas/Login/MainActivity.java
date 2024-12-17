package com.pmdm.notas.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.pmdm.notas.Login.entities.Usuario;
import com.pmdm.notas.NotasAdapter.Activities.NotasActivity;
import com.pmdm.notas.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    // lista de la clase Usuario, para guardar los usuarios.
    private List<Usuario> usuariosList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login);

        Button button = findViewById(R.id.btAcceder);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NotasActivity.class);
                startActivity(intent);
            }
        });


        generarListaUsuarios();
       // anadirUsuarios();

        // revisar que los datos introducidos estén bien introducidos.
        // revisar si está registrado o no (mirar si está dentro de la lista)
        // si no está registrado sacar un toast y pedir que se registre.
        // si se registra sin querer y ya está registrado.


    }
    private void generarListaUsuarios(){
        usuariosList = new ArrayList<>();
        usuariosList.add(new Usuario("nadir","nadir1234"));
        usuariosList.add(new Usuario("aroa","abc123."));

    }

    public void anadirUsuario(){
        // Usuario nuevoUsuario = new Usuario
    }
}