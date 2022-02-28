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

import java.util.ArrayList;

public class FormularioActivity extends AppCompatActivity {
    private Spinner spinnerCine;
    private EditText etNumEntradas;
    private String nombreCine;
    private ImageView A1;
    private ImageView A2;
    private ImageView A3;
    private ImageView A4;
    private ImageView A5;
    private ImageView A6;
    private ImageView A7;
    private ImageView B1;
    private ImageView B2;
    private ImageView B3;
    private ImageView B4;
    private ImageView B5;
    private ImageView B6;
    private ImageView B7;
    private ImageView C1;
    private ImageView C2;
    private ImageView C3;
    private ImageView C4;
    private ImageView C5;
    private ImageView C6;
    private ImageView C7;
    private ImageView D1;
    private ImageView D2;
    private ImageView D3;
    private ImageView D4;
    private ImageView D5;
    private ImageView D6;
    private ImageView D7;
    int numEntradas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        spinnerCine = findViewById(R.id.spinnerCine);
        etNumEntradas = findViewById(R.id.editTextNumber);
        A1 = findViewById(R.id.A1);
        A2 = findViewById(R.id.A2);
        A3 = findViewById(R.id.A3);
        A4 = findViewById(R.id.A4);
        A5 = findViewById(R.id.A5);
        A6 = findViewById(R.id.A6);
        A7 = findViewById(R.id.A7);
        B1 = findViewById(R.id.B1);
        B2 = findViewById(R.id.B2);
        B3 = findViewById(R.id.B3);
        B4 = findViewById(R.id.B4);
        B5 = findViewById(R.id.B5);
        B6 = findViewById(R.id.B6);
        B7 = findViewById(R.id.B7);
        C1 = findViewById(R.id.C1);
        C2 = findViewById(R.id.C2);
        C3 = findViewById(R.id.C3);
        C4 = findViewById(R.id.C4);
        C5 = findViewById(R.id.C5);
        C6 = findViewById(R.id.C6);
        C7 = findViewById(R.id.C7);
        D1 = findViewById(R.id.D1);
        D2 = findViewById(R.id.D2);
        D3 = findViewById(R.id.D3);
        D4 = findViewById(R.id.D4);
        D5 = findViewById(R.id.D5);
        D6 = findViewById(R.id.D6);
        D7 = findViewById(R.id.D7);

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

    public void informacionEntrada(View view) {
        ImageView iv = findViewById(view.getId());
        Intent intent = new Intent(FormularioActivity.this, ResumenCompra.class);
        Bundle bundle = new Bundle();
        bundle.putString("nombreCine", nombreCine);

        if (A1.getDrawable().getConstantState().equals(getResources().getDrawable(R.drawable.asientoocupado).getConstantState())) {
            bundle.putString("asientoElegido", "A1,");
        }


        intent.putExtras(bundle);
        startActivity(intent);
    }
}

