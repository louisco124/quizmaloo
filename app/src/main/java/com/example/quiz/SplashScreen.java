package com.example.quiz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Splashscreen extends AppCompatActivity {

    public static final String dataUserCache = "dataUser";
    private static final int modo_private = Context.MODE_PRIVATE;
    String usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_SplashScreen);

        validarLogin();

    }

    private void validarLogin() {
        usuario = getApplicationContext().getSharedPreferences(dataUserCache,modo_private).getString("user","0");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (usuario.equalsIgnoreCase("0")){
                    Intent i = new Intent(Splashscreen.this,login.class);
                    startActivity(i);
                }else{
                    Intent i = new Intent(Splashscreen.this, MainActivity.class);
                    startActivity(i);
                }
            }
        },2000);

    }
}