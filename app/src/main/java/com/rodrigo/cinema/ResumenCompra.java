package com.rodrigo.cinema;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
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
        totalCompra.setText(Integer.parseInt(bundle.getString("numEntradas")) * 9 + "€");

    }

    public void abrirPaypal(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.paypal.com/signin"));
        startActivity(i);
    }
}