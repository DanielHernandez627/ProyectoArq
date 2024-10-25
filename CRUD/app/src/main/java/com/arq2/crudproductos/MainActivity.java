package com.arq2.crudproductos;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
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

    EditText txtCod, txtNombre, txtPrecio;
    Button btnRegistrar, btnActualizar, btnEliminar, btnBuscar;

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

        txtCod = (EditText) findViewById(R.id.txtCod);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtPrecio = (EditText) findViewById(R.id.txtPrecio);

        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);
        btnActualizar = (Button) findViewById(R.id.btnActualizar);
        btnEliminar = (Button) findViewById(R.id.btnEliminar);
        btnBuscar = (Button) findViewById(R.id.btnBuscar);

        setUp();
    }

    public void setUp(){
        btnRegistrar.setOnClickListener(v -> {
            GestionSQLiteOpenHelper gestor = new GestionSQLiteOpenHelper(this, "bdProductos", null, 1);
            //Abrir la conexion en modo lectura o escritura
            SQLiteDatabase db = gestor.getWritableDatabase();
            //Datos digitados
            String cod = txtCod.getText().toString();
            String nombre = txtNombre.getText().toString();
            double val = Double.parseDouble(txtPrecio.getText().toString());

            if (!cod.isEmpty() && !nombre.isEmpty() && val != 0){
                //Generar el registro para la BD
                ContentValues registro = new ContentValues();
                registro.put("CODIGO", cod);
                registro.put("NOMBRE", nombre);
                registro.put("PRECIO", val);
                //Insertar el registro
                db.insert("T_ARTICULOS", null, registro);
                //Cerrar conexion BD
                db.close();
                //Limpiar campos
                txtCod.setText("");
                txtNombre.setText("");
                txtPrecio.setText("");

                Toast.makeText(this,"Registro insertado correctamente",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this,"Error todos los campos deben ser diligenciados",Toast.LENGTH_LONG).show();
            }
        });

        btnBuscar.setOnClickListener(v -> {
            GestionSQLiteOpenHelper gestor = new GestionSQLiteOpenHelper(this, "bdProductos", null, 1);
            //Abrir la conexion en modo lectura o escritura
            SQLiteDatabase db = gestor.getWritableDatabase();
            //Datos digitados
            String cod = txtCod.getText().toString();

            //Consultar datos
            if (!cod.isEmpty()){
                //Generar cursor
                Cursor cr = db.rawQuery("SELECT NOMBRE,PRECIO FROM T_ARTICULOS WHERE CODIGO ="+cod,null);
                if (cr.moveToFirst()){
                    txtNombre.setText(cr.getString(0));
                    txtPrecio.setText(cr.getString(1));
                }else{
                    Toast.makeText(this,"No se encontraron datos",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}