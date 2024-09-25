package com.arq2.navegaciom;

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

    private EditText txtUrl;
    private Button btnIr;

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

        txtUrl = (EditText) findViewById(R.id.txtUrl);
        btnIr = (Button) findViewById(R.id.btnIr);

        setUp();
    }

    private void setUp(){
        btnIr.setOnClickListener(view -> {
            Intent i = new Intent(this,Navegador.class);
            i.putExtra("url",txtUrl.getText().toString());
            startActivity(i);
        });
    }
}