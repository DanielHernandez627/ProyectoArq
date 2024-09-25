package com.arq2.pasodatos;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {

    private EditText txtDatos1;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtDatos1 = findViewById(R.id.txtDato1);
        btnEnviar = findViewById(R.id.btnEnviar);
        setUp();
    }

    private void setUp(){
        btnEnviar.setOnClickListener(view -> {
            Intent i = new Intent(this,RecibeDatos.class);
            i.putExtra("nombre", txtDatos1.getText().toString());
            startActivity(i);
        });
    }
}