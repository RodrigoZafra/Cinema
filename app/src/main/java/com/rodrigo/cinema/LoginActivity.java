package com.rodrigo.cinema;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImageView mTicket = findViewById(R.id.imageViewLogin);
        Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.animacion_login);
        mTicket.startAnimation(myAnim);
    }

    public void acceder(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void registrarse(View view) {
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }
}