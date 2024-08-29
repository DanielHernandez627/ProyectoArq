package com.arquitectura.calculadora;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

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
}