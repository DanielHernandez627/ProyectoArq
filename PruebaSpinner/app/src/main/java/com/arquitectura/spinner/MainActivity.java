package com.arquitectura.spinner;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText txt_1, txt_2;
    private TextView txt_result;
    private Spinner spinner;
    private Button btn_calcular;

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

        txt_1 = (EditText) findViewById(R.id.txt_1);
        txt_2 = (EditText) findViewById(R.id.txt_2);
        txt_result = (TextView) findViewById(R.id.txt_result);
        spinner = (Spinner) findViewById(R.id.spinner);

        String [] opciones = {"Sumar","Restar","Multiplicar","Dividir"};
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,opciones);
        spinner.setAdapter(adapter);
    }

    public void Calcular(View v){
        float n1,n2,result = 0;
        String seleccion;

        n1 = Float.parseFloat(txt_1.getText().toString());
        n2 = Float.parseFloat(txt_2.getText().toString());

        seleccion = spinner.getSelectedItem().toString();

        if (seleccion.equals("Sumar")){
            result = n1 + n2;
            txt_result.setText(String.valueOf(result));
        } else if (seleccion.equals("Restar")) {
            result = n1 - n2;
            txt_result.setText(String.valueOf(result));
        } else if (seleccion.equals("Multiplicar")) {
            result = n1 * n2;
            txt_result.setText(String.valueOf(result));
        } else if (seleccion.equals("Dividir")) {
            if (n2 != 0){
                result = n1 / n2;
                txt_result.setText(String.valueOf(result));
            }else{
                Toast.makeText(this,"Division entre 0, No Definada",Toast.LENGTH_LONG).show();
                txt_result.setText("0");
            }
        }else {
            txt_result.setText("Seleccione un valor");
        }
    }
}