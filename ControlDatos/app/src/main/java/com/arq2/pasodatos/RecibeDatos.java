package com.arq2.pasodatos;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RecibeDatos extends AppCompatActivity {

    private TextView txtSaludo;
    private Button btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recibe_datos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtSaludo = findViewById(R.id.txtSaludo);
        btnRegresar = findViewById(R.id.btnRegresar);

        setUp();
    }

    private void setUp(){
        String dato = "";
        dato = "Buenas noches "+getIntent().getStringExtra("nombre");
        txtSaludo.setText(dato);

        btnRegresar.setOnClickListener(view -> {
            finish();
        });
    }
}