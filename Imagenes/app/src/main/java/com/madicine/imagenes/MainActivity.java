package com.madicine.imagenes;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ImageButton btnUcentral,btnMicro,btnDev;

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

        btnUcentral = (ImageButton) findViewById(R.id.btnUcentral);
        btnMicro = (ImageButton) findViewById(R.id.btnMicro);
        btnDev = (ImageButton) findViewById(R.id.btnDev);

        setUp();
    }

    private void setUp (){
        //Metodo btn ucentral
        btnUcentral.setOnClickListener(view -> {
            Toast.makeText(this,"Asignatura para crear App Android",Toast.LENGTH_LONG).show();
        });

        //Metodo btn MicroServicios
        try {
            btnMicro.setOnClickListener(view -> {
                Toast.makeText(this,"Gestion de micro servicios a traves de android",Toast.LENGTH_LONG).show();
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //Metodo btn Dev
        btnDev.setOnClickListener(view -> {
            Toast.makeText(this,"Creacion de codigo limpio de alta calidad",Toast.LENGTH_LONG).show();
        });
    }
}