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
    int numEntradas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        spinnerCine = findViewById(R.id.spinnerCine);
        etNumEntradas = findViewById(R.id.editTextNumber);
        A1 = findViewById(R.id.A1);

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
        iv.setImageDrawable(getDrawable(R.drawable.asientoocupado));
    }

    public void informacionEntrada(View view) {

        Intent intent = new Intent(FormularioActivity.this, ResumenCompra.class);
        Bundle bundle = new Bundle();
        bundle.putString("nombreCine", nombreCine);

        if (A1.getDrawable() == getDrawable(R.drawable.asientoocupado)) {
            bundle.putString("asientoElegido", "A1");
        }
        intent.putExtras(bundle);
        startActivity(intent);
    }
}

