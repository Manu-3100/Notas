package com.pmdm.notas.NotasAdapter.Activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import com.pmdm.notas.R;
import com.pmdm.notas.databinding.NotasReciclerBinding;

public class NotasActivity extends AppCompatActivity {

    private NotasReciclerBinding binding = null;
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.notas_recicler);
        toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.AñadirNota){
            Toast.makeText(this, "Añadir nota", Toast.LENGTH_SHORT).show();
            return true;
        }
        if(id == R.id.EliminarNota){
            Toast.makeText(this, "Eliminar nota",Toast.LENGTH_SHORT).show();
            return true;
        }
        if(id == R.id.CerrarSesion){
            Toast.makeText(this, "Cerrar sesión",Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
