package com.example.quiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ejemploshared.MainActivity;

public class Login extends AppCompatActivity {

    EditText edt_usuario;
    Button btn_iniciar;
    //instancias de uso cache sharedpreferences
    public static final String dataUserCache = "dataUser";
    private static final int modo_private = Context.MODE_PRIVATE;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        edt_usuario = findViewById(R.id.edt_usuario);
        btn_iniciar = findViewById(R.id.btn_iniciar);

        sharedPreferences = getSharedPreferences(dataUserCache,modo_private);
        editor = sharedPreferences.edit();

        btn_iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!edt_usuario.getText().toString().isEmpty()){
                    //sharedpreferences
                    editor.putString("user",edt_usuario.getText().toString());
                    editor.commit();
                    Intent i = new Intent(com.example.quiz.Login.this, MainActivity.class);
                    startActivity(i);
                }else{
                    //toast con mensaje de error
                }
            }
        });

    }

}