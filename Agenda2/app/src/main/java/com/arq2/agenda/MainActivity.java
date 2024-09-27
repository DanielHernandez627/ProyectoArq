package com.arq2.agenda;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText txtNombre,txtDatos;
    private Button btnGuardar,btnBuscar;


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

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtDatos = (EditText) findViewById(R.id.txtDatos);
        btnBuscar = (Button) findViewById(R.id.btnBuscar);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);

        setUp();
    }

    private void setUp(){
        btnGuardar.setOnClickListener(view -> {
            String nombre = txtNombre.getText().toString();
            String datos = txtDatos.getText().toString();

            SharedPreferences sharedPreferences = getSharedPreferences("agenda", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(nombre,datos);
            editor.apply();
            Toast.makeText(this,"Exito",Toast.LENGTH_LONG).show();
        });

        btnBuscar.setOnClickListener(view -> {
            String nombre = txtNombre.getText().toString();
            String datos = "";
            SharedPreferences sharedPreferences = getSharedPreferences("agenda",Context.MODE_PRIVATE);
            datos = sharedPreferences.getString(nombre,"");
            if (datos.isEmpty()){
                txtDatos.setText("");
                Toast.makeText(this,"Contacto no encontrado",Toast.LENGTH_LONG).show();
            }else{
                txtDatos.setText(datos);
            }
        });
    }
}