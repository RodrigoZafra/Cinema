package com.rodrigo.cinema;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResumenCompra extends AppCompatActivity {
    private TextView totalCompra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen_compra);
        TextView nombreCine = findViewById(R.id.tvMostrarCine);
        TextView numeroEntradas = findViewById(R.id.tvMostrarEntradas);
        TextView asientoElegido = findViewById(R.id.tvMostrarAsientos);
        totalCompra = findViewById(R.id.tvMostrarTotalCompra);

        Bundle bundle = this.getIntent().getExtras();

        nombreCine.setText(bundle.getString("nombreCine"));
        numeroEntradas.setText(bundle.getString("numEntradas"));
        asientoElegido.setText(bundle.getStringArrayList("arrayAsientos").toString());
        totalCompra.setText(Integer.parseInt(bundle.getString("numEntradas"))*9 + "€");

    }
}