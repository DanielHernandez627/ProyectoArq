package com.arquitectura.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText txt_n1,txt_n2;
    TextView txt_result;
    RadioButton rbtn_suma,rbtn_resta,rbtn_multi,rbtn_divi;

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

        txt_n1 = (EditText) findViewById(R.id.txt_n1);
        txt_n2 = (EditText) findViewById(R.id.txt_n2);
        txt_result = (TextView) findViewById(R.id.txt_result);
        rbtn_suma = (RadioButton) findViewById(R.id.rbtn_suma);
        rbtn_resta = (RadioButton) findViewById(R.id.rbtn_resta);
        rbtn_multi = (RadioButton) findViewById(R.id.rbtn_multi);
        rbtn_divi = (RadioButton) findViewById(R.id.rbtn_divi);
    }

    //Metodo Calculadora
    public void calcular(View view){
        String sn1 = (txt_n1.getText().toString().equals("")) ? "0" : txt_n1.getText().toString();
        String sn2 = (txt_n2.getText().toString().equals("")) ? "0" : txt_n2.getText().toString();
        float numero1 = Float.parseFloat(sn1);
        float numero2 = Float.parseFloat(sn2);

        if (rbtn_suma.isChecked()){
            float suma = numero1 + numero2;
            txt_result.setText(String.valueOf(suma));
        }else if(rbtn_resta.isChecked()){
            float resta = numero1 - numero2;
            txt_result.setText(String.valueOf(resta));
        } else if (rbtn_multi.isChecked()) {
            float multi = numero1 * numero2;
            txt_result.setText(String.valueOf(multi));
        } else if (rbtn_divi.isChecked()) {
            if (numero2 == 0){
                System.out.println("XD");
            }else{
                float divi = numero1 / numero2;
                txt_result.setText(String.valueOf(divi));
            }
        }else{
            txt_result.setText("Seleccione un radio button");
        }
    }
}