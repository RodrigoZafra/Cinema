package com.rodrigo.cinema;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class FormularioActivity extends AppCompatActivity {
    private Spinner spinnerCine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        spinnerCine = findViewById(R.id.spinnerCine);

        ArrayList<String> cines = new ArrayList<>();
        cines.add("Rivas H2O");
        cines.add("Ideal");
        cines.add("Islazul");
        cines.add("Plenilunio");
        cines.add("Tres Aguas");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, cines);
        spinnerCine.setAdapter(adapter);
    }
}