package com.arq2.ubicacion;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

public class MainActivity extends AppCompatActivity {

    private TextView tllocation;

    private FusedLocationProviderClient fusedLocationProviderClient;

    private static final int REQUEST_LOCATION_PERMISSION = 1;


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

        tllocation = findViewById(R.id.tllocation);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        getCurrentLocation();
    }

    //Metodo para verificar los servicios
    private void getCurrentLocation(){
        if (PackageManager.PERMISSION_GRANTED != ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)) {
            if (PackageManager.PERMISSION_GRANTED != ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)) {
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION}
                        , REQUEST_LOCATION_PERMISSION);
                return;
            }
        }
        fusedLocationProviderClient.getLastLocation().addOnSuccessListener(this,location -> {
            if(location != null){
                tllocation.setText("latitud: " + location.getLatitude() + "\n" + "Longitud" + location.getLongitude());
            }else
            {
                tllocation.setText("No se pudo obtener la ubicacion");
            }
        });
    }

    public void onRequestPermissionsResult(int RequestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        super.onRequestPermissionsResult(RequestCode, permissions, grantResults);
        //preguntar si dieron los permisos
        if(RequestCode == REQUEST_LOCATION_PERMISSION && grantResults.length > 0)
        {
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                getCurrentLocation();
            }else
            {
                tllocation.setText("Permiso de ubicacion Denegado");
            }

        }
    }
}