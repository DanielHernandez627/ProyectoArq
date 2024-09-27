package com.arq2.sheredpreferenceclase;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText txtEmail;
    private Button btnGuardar;

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

        txtEmail = (EditText) findViewById(R.id.txtEmail);
        btnGuardar = (Button) findViewById(R.id.btnSave);

        SharedPreferences sharedPreferences = getSharedPreferences("emails", Context.MODE_PRIVATE);
        txtEmail.setText(sharedPreferences.getString("mail",""));

        setUp();
    }

    private void setUp(){
        btnGuardar.setOnClickListener(view -> {
            SharedPreferences sharedPreferences = getSharedPreferences("emails",Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("mail",txtEmail.getText().toString());
            editor.apply();
            finish();
        });
    }
}