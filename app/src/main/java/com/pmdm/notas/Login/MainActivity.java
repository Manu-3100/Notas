package com.pmdm.notas.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

    // creamos las variables de nombre de usuario.
    private EditText user;
    private EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login);

        generarListaUsuarios();
        user = findViewById(R.id.etNome);
        pass = findViewById(R.id.etPassword);

        Button botonAcceder = findViewById(R.id.btAcceder);
        botonAcceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprobarUsuario();
            }
        });

        // evento al clicar en registrar:
        Button botonRegistrar = findViewById(R.id.btRexistrarse);
        botonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anadirUsuario();
            }
        });

        // revisar que los datos introducidos estén bien introducidos.
        // revisar si está registrado o no (mirar si está dentro de la lista)
        // si no está registrado sacar un toast y pedir que se registre.
        // si se registra sin querer y ya está registrado.
    }
    private void generarListaUsuarios(){
        usuariosList = new ArrayList<>();
        usuariosList.add(new Usuario("nadir","nadir1234"));
        usuariosList.add(new Usuario("Aroa","abc123."));
    }

    public void comprobarUsuario(){
        // cogemos la información que nos ha introducido el usuario.
        String usuario = user.getText().toString().trim();
        String contrasinal = pass.getText().toString().trim();

        // recorrer la lista para ver si usuario existe o no y contraseña existen
        for (Usuario persona : usuariosList){
            // este toast es por si no completa bien todos los campos.
            if (usuario.isEmpty() || contrasinal.isEmpty()){
                Toast.makeText(this, "COMPLETE TODOS OS CAMPOS", Toast.LENGTH_SHORT).show();
                break;
            }
            // comprobar si contraseña y usuario son correctos:
            else if (persona.getNome().equals(usuario) && !persona.getContrasinal().equals(contrasinal)) {
                Toast.makeText(this, "CONTRASINAL INCORRECTO", Toast.LENGTH_SHORT).show();
                break;
            }
            else if (!persona.getNome().equals(usuario) && persona.getContrasinal().equals(contrasinal)){
                Toast.makeText(this, "USUARIO INCORRECTO", Toast.LENGTH_SHORT).show();
                break;
            }

            // si el usuario y la contraseña son correctos tiene que iniciar la actividad.
            else if (persona.getNome().equals(usuario) && persona.getContrasinal().equals(contrasinal)){
                Intent intent = new Intent(MainActivity.this, NotasActivity.class);
                intent.putExtra("usuario", usuario);
                startActivity(intent);

                Toast.makeText(this, "ACCEDIENDO...", Toast.LENGTH_SHORT).show();
                break;
            }

            // si el usuario y la contraseña no coinciden decirle que usuario no existe.
            else if (!persona.getNome().equals(usuario) && !persona.getContrasinal().equals(contrasinal)){
                Toast.makeText(this, "USUARIO NON EXISTE", Toast.LENGTH_SHORT).show();
                break;
            }
            return;
        }

        // vaciar los campos de texto
        user.setText("");
        pass.setText("");

    }

    public void anadirUsuario(){
        // cogemos la información que nos ha introducido el usuario.
        String usuario = user.getText().toString().trim();
        String contrasinal = pass.getText().toString().trim();

        // recorremos la lista para comprobar que realmente ese usuario no existe:

        for (Usuario persona : usuariosList){
            if (usuario.isEmpty() || contrasinal.isEmpty()){
                Toast.makeText(this, "COMPLETE TODOS OS CAMPOS", Toast.LENGTH_SHORT).show();
                break;
            }
            else if (!persona.getNome().equals(usuario)){
                // añadir usuario nuevo a la lista
                usuariosList.add(new Usuario(usuario,contrasinal));

                // creamos nuestra actividad
                Intent intent2 = new Intent(MainActivity.this, NotasActivity.class);

                // para que aparezca el nombre del usuario que tenga la sesión iniciada.
                intent2.putExtra("usuario", usuario);

                // iniciar actividad:
                startActivity(intent2);

                Toast.makeText(this, "USUARIO NOVO AÑADIDO", Toast.LENGTH_SHORT).show();
                break;

            }
            else if (persona.getNome().equals(usuario)){
                Toast.makeText(this, "USUARIO XA EXISTENTE", Toast.LENGTH_SHORT).show();
                break;
            }
        }

        // vaciar los campos de texto
        user.setText("");
        pass.setText("");
    }
}