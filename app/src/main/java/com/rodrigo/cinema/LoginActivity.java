package com.rodrigo.cinema;

import androidx.appcompat.app.AppCompatActivity;

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

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText email, pass;
    private Button btnLogin, btnRegister;
    private DaoUsuarios dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.edtEmail);
        pass = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.buttonLogin);
        btnRegister = findViewById(R.id.buttonRegister);

        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);

        dao = new DaoUsuarios(this);

        ImageView mTicket = findViewById(R.id.imageViewLogin);
        Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.animacion_login);
        mTicket.startAnimation(myAnim);
    }

    /*En este método vamos a decirle que si pulsa el botón de login y el usuario esta registrado que acceda a la cartelera para ver las películas
    y en el caso de que pulses el botón registrar que te lleve a la ventana de signup para proceder a registrar el usuario
    */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonLogin:
                String u = email.getText().toString();
                String p = pass.getText().toString();
                System.out.println(email.getText().toString());
                System.out.println(pass.getText().toString());
                if (u.equals("") && p.equals("")) {
                    Toast.makeText(this, "Error: Campos vacios", Toast.LENGTH_LONG).show();
                } else if (dao.login(u, p) == 1) {
                    Usuarios us = dao.getUsuario(u, p);
                    Toast.makeText(this, "Datos correctos", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(this, CategoriaPeliculas.class);
                    intent.putExtra("Id", us.getId());
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "Email o contraseña incorrectos", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.buttonRegister:
                Intent intent = new Intent(this, SignupActivity.class);
                startActivity(intent);
                break;
        }
    }
}