package com.rodrigo.cinema;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResumenCompra extends AppCompatActivity {
    private TextView nombreCine;
    private TextView numeroEntradas;
    private TextView asientoElegido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen_compra);
        nombreCine = findViewById(R.id.tvMostrarCine);
        numeroEntradas = findViewById(R.id.tvMostrarEntradas);
        asientoElegido = findViewById(R.id.tvMostrarAsientos);

        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null) {
            nombreCine.setText(bundle.getString("nombreCine"));
            asientoElegido.setText(bundle.getString("asientoElegido"));
        }
    }
}