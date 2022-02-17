package com.rodrigo.cinema;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

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
}