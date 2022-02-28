package com.rodrigo.cinema;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.rodrigo.cinema.Entidades.Usuarios;

public class SignupActivity extends AppCompatActivity {
    private EditText email, pass, nombre, apellidos;
    private Button registrar;
    private DaoUsuarios dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        email = findViewById(R.id.edtRegisterEmail);
        pass = findViewById(R.id.edtRegisterPassword);
        nombre = findViewById(R.id.edtNombre);
        apellidos = findViewById(R.id.edtApellidos);
        dao = new DaoUsuarios(this);

        registrar = findViewById(R.id.btnRegistrarse);

        //Este método nos permite registrar un usuario siempre y cuando no este registrado previamente o se introduzcan mal los datos en los campos
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuarios u = new Usuarios();
                u.setNombre(nombre.getText().toString());
                u.setApellidos(apellidos.getText().toString());
                u.setEmail(email.getText().toString());
                u.setPassword(pass.getText().toString());
                if (!u.isNull()) {
                    Toast.makeText(SignupActivity.this, "Error: campos vacios", Toast.LENGTH_LONG).show();
                } else if (dao.insertUsuario(u)) {
                    Toast.makeText(SignupActivity.this, "Usuario registrado con exito", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(SignupActivity.this, "Usuario ya registrado", Toast.LENGTH_LONG).show();
                }
            }
        });
        //Animación de la imagen del ticket
        ImageView mTicket = findViewById(R.id.imageViewRegister);
        Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.animacion_login);
        mTicket.startAnimation(myAnim);
    }
}