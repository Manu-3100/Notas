package com.pmdm.notas.NotasAdapter.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pmdm.notas.Login.MainActivity;
import com.pmdm.notas.NotasAdapter.Adapter.NotasAdapter;
import com.pmdm.notas.NotasAdapter.Entities.Nota;
import com.pmdm.notas.NotasAdapter.Entities.NotaAmpliada;
import com.pmdm.notas.R;
import com.pmdm.notas.databinding.NotasReciclerBinding;

import java.util.ArrayList;
import java.util.List;

public class NotasActivity extends AppCompatActivity {

    private NotasReciclerBinding binding = null;
    // declaramos el Recycler view y lo inicializamos a null

    RecyclerView rvNota = null;
    // declaramos el adaptador de nuestro recyclerView
    private NotasAdapter adapter;

    // Almacen de notas
    List<Nota> notasList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.notas_recicler);

        // Asignamos la toolbar a la action bar
        setSupportActionBar(binding.toolbar);

        binding.rvNota.setLayoutManager(new LinearLayoutManager(this));

        notasList  = new ArrayList<Nota>();
        notasList.add(new Nota("A saber", "onte", "pmdm"));

        adapter = new NotasAdapter(notasList, getApplicationContext(), new NotasAdapter.OnItemClickListener(){
            int posicion;
            @Override
            public void onItemClick(int position) {
                posicion = position;
                Toast.makeText(NotasActivity.this, notasList.get(position).getTitulo(), Toast.LENGTH_SHORT).show();
                adapter.notifyItemChanged(position);

                // aqui ten que abrir a actividade nota Ampliada
                Intent intent = new Intent(NotasActivity.this, NotaAmpliada.class);
                startActivity(intent);
            }
        });

        binding.rvNota.setAdapter(adapter);
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
