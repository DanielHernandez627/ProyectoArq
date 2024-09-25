package com.arq2.navegaciom;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Navegador extends AppCompatActivity {

    private WebView wvNavegador;
    private Button btnCerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_navegador);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        wvNavegador = findViewById(R.id.wvNavegador);
        btnCerrar = findViewById(R.id.btnCerrar);

        String url = getIntent().getStringExtra("url");

        wvNavegador.setWebViewClient(new WebViewClient());

        wvNavegador.loadUrl("https://"+url);

        btnCerrar.setOnClickListener(view -> {
            finish();
        });
    }
}