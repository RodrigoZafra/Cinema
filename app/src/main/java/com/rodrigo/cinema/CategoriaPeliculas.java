package com.rodrigo.cinema;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.rodrigo.cinema.ui.main.SectionsPagerAdapter;
import com.rodrigo.cinema.databinding.ActivityCategoriaPeliculasBinding;

public class CategoriaPeliculas extends AppCompatActivity {

    private ActivityCategoriaPeliculasBinding binding;
    private CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCategoriaPeliculasBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);

        cardView = findViewById(R.id.cardview);


    }


    public boolean onCreateOptionsMenu(Menu menu) {//Aparece el menu en la barra de arriba
        getMenuInflater().inflate(R.menu.top_menu, menu);
        return true;
    }

    //Define las opciones de los objetos de la barra
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {//Gestiona las acciones sobre los botones
        int id = item.getItemId();
        if (id == R.id.signOut) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
        if (id == R.id.preferences) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

}