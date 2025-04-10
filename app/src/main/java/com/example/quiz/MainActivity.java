package com.example.quiz;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView txt_name_usuario;
    private Spinner operador;

    public static final String dataUserCache = "dataUser";
    private static final int modo_private = Context.MODE_PRIVATE;
    String usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        operador = findViewById(R.id.operador);


        String[] operadores = {"cine", "deporte", "musica"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, operadores);
        operador.setAdapter(adapter);

        txt_name_usuario = findViewById(R.id.txt_name_usuario);

        usuario = getApplicationContext().getSharedPreferences(dataUserCache,modo_private).getString("user","0");

        txt_name_usuario.setText(usuario);


    }
}