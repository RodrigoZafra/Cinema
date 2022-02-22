package com.rodrigo.cinema;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.rodrigo.cinema.Adapter.Peliculas;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerPeliculas;
    CarteleraAdapter carteleraAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarElementos();
    }

    private void inicializarElementos() {
        recyclerPeliculas = findViewById(R.id.recycler);
        recyclerPeliculas.setLayoutManager(new LinearLayoutManager(this));

        List<Peliculas> peliculasList = new ArrayList<>();

        peliculasList.add(new Peliculas("Doctor Strange", "Es una pelicula de marvel", "https://yelmocines.es/sinopsis/licorice-pizza"));

        carteleraAdapter = new CarteleraAdapter(peliculasList, this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {//Aparece el menu en la barra de arriba
        getMenuInflater().inflate(R.menu.top_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {//Gestiona las acciones sobre los botones
        int id = item.getItemId();

        if (id == R.id.signOut) {

        }

        if (id == R.id.preferences) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }
}