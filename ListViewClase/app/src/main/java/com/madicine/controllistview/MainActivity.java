package com.madicine.controllistview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView tlPrincipal;
    private ListView lvDatos;
    private String nombres [] = {"Sebastian","Marelvi","Caroline","Daniel","Valentina","Brayan","Alberto","Camilo"};
    private String edades [] = {"12","18","19","15","18","23","29","30"};

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

        tlPrincipal = (TextView) findViewById(R.id.tlPrincipal);
        lvDatos = (ListView) findViewById(R.id.lvDatos);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.layoutarq2,nombres);
        lvDatos.setAdapter(adapter);

        lvDatos.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterview, View v,int i,long l){
                tlPrincipal.setText("La edad de " +lvDatos.getItemAtPosition(i) +" es "+ edades[i] + " Años");
            }
        });
    }
}