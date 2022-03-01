package com.rodrigo.cinema;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class FormularioActivity extends AppCompatActivity {
    private Spinner spinnerCine;
    private EditText etNumEntradas;
    private String nombreCine;
    private ArrayList<ImageView> imagenesAsientos;
    int numEntradas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        spinnerCine = findViewById(R.id.spinnerCine);
        etNumEntradas = findViewById(R.id.editTextNumber);
        imagenesAsientos = new ArrayList<>();
        imagenesAsientos.add(findViewById(R.id.A1));
        imagenesAsientos.add(findViewById(R.id.A2));
        imagenesAsientos.add(findViewById(R.id.A3));
        imagenesAsientos.add(findViewById(R.id.A4));
        imagenesAsientos.add(findViewById(R.id.A5));
        imagenesAsientos.add(findViewById(R.id.A6));
        imagenesAsientos.add(findViewById(R.id.A7));
        imagenesAsientos.add(findViewById(R.id.B1));
        imagenesAsientos.add(findViewById(R.id.B2));
        imagenesAsientos.add(findViewById(R.id.B3));
        imagenesAsientos.add(findViewById(R.id.B4));
        imagenesAsientos.add(findViewById(R.id.B5));
        imagenesAsientos.add(findViewById(R.id.B6));
        imagenesAsientos.add(findViewById(R.id.B7));
        imagenesAsientos.add(findViewById(R.id.C1));
        imagenesAsientos.add(findViewById(R.id.C2));
        imagenesAsientos.add(findViewById(R.id.C3));
        imagenesAsientos.add(findViewById(R.id.C4));
        imagenesAsientos.add(findViewById(R.id.C5));
        imagenesAsientos.add(findViewById(R.id.C6));
        imagenesAsientos.add(findViewById(R.id.C7));
        imagenesAsientos.add(findViewById(R.id.D1));
        imagenesAsientos.add(findViewById(R.id.D2));
        imagenesAsientos.add(findViewById(R.id.D3));
        imagenesAsientos.add(findViewById(R.id.D4));
        imagenesAsientos.add(findViewById(R.id.D5));
        imagenesAsientos.add(findViewById(R.id.D6));
        imagenesAsientos.add(findViewById(R.id.D7));
        ArrayList<String> cines = new ArrayList<>();
        cines.add("Rivas H2O");
        cines.add("Ideal");
        cines.add("Islazul");
        cines.add("Plenilunio");
        cines.add("Tres Aguas");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, cines);
        spinnerCine.setAdapter(adapter);

        spinnerCine.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                nombreCine = spinnerCine.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    //Este método nos permite poner el asiento en verde cuando hacemos click en la posición donde queremos nuestro asiento
    public void elegirAsiento(View view) {
        ImageView iv = findViewById(view.getId());
        if (iv.getDrawable().getConstantState().equals(getResources().getDrawable(R.drawable.asientoocupado).getConstantState())) {
            iv.setImageDrawable(getDrawable(R.drawable.asiento));
        } else {
            iv.setImageDrawable(getDrawable(R.drawable.asientoocupado));
        }
    }

    public void comprobarDatos(View view) {
        if (Integer.parseInt(etNumEntradas.getText().toString()) > 28) {
            Toast.makeText(this, "El máximo de entradas son 28", Toast.LENGTH_SHORT).show();
        } else {
            informacionEntrada(view);
        }
    }

    private void informacionEntrada(View view) {
        ArrayList<String> asientos = new ArrayList<>();

        int contFila = 1;
        for (ImageView iva : imagenesAsientos) {
            if (iva.getDrawable().getConstantState().equals(getResources().getDrawable(R.drawable.asientoocupado).getConstantState())) {
                if (contFila < 8)
                    asientos.add("A" + contFila);
                if (contFila > 7 && contFila < 15)
                    asientos.add("B" + (contFila - 7));
                if (contFila > 14 && contFila < 21)
                    asientos.add("C" + (contFila - 14));
                if (contFila > 20 && contFila < 29)
                    asientos.add("D" + (contFila - 21));
            }
            contFila++;
        }

        if (Integer.parseInt(etNumEntradas.getText().toString()) != asientos.size()) {
            Toast.makeText(this, "Tienes que elegir tantos asientos como entradas", Toast.LENGTH_SHORT).show();
            asientos = new ArrayList<>();
        } else {
            Intent intent = new Intent(FormularioActivity.this, ResumenCompra.class);
            Bundle bundle = new Bundle();
            bundle.putString("nombreCine", nombreCine);
            bundle.putStringArrayList("arrayAsientos", asientos);
            bundle.putString("numEntradas", etNumEntradas.getText().toString());
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }
}


