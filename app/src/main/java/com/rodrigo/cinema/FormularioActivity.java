package com.rodrigo.cinema;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;

public class FormularioActivity extends AppCompatActivity {
    private Spinner spinnerCine;
    private EditText etNumEntradas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        spinnerCine = findViewById(R.id.spinnerCine);
        etNumEntradas = findViewById(R.id.editTextNumber);

        ArrayList<String> cines = new ArrayList<>();
        cines.add("Rivas H2O");
        cines.add("Ideal");
        cines.add("Islazul");
        cines.add("Plenilunio");
        cines.add("Tres Aguas");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, cines);
        spinnerCine.setAdapter(adapter);
    }

    public void elegirAsiento(View view) {
        ImageView iv = findViewById(view.getId());
        iv.setImageDrawable(getDrawable(R.drawable.asientoocupado));
    }

}

