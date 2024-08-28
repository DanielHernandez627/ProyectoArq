package com.example.appdos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView mensaje1;
    EditText txt1,txt2,txt3;
    Button btnc;

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

        mensaje1 = (TextView) findViewById(R.id.mensaje1);
        txt1 = (EditText) findViewById(R.id.txt1);
        txt2 = (EditText) findViewById(R.id.txt2);
        txt3 = (EditText) findViewById(R.id.txt3);
        btnc = (Button) findViewById(R.id.btnc);
    }

    public void calculo(View view){
        String c1 = txt1.getText().toString();
        String c2 = txt2.getText().toString();
        String c3 = txt3.getText().toString();

        float c1int = Float.parseFloat(c1);
        float c2int = Float.parseFloat(c2);
        float c3int = Float.parseFloat(c3);

        float result = (c1int + c2int + c3int)/3;

        mensaje1.setText(String.valueOf(result));
    }
}