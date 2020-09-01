package com.example.mayor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtNombre, txtEdad;
    Button btnAccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = findViewById(R.id.txtNombre);
        txtEdad = findViewById(R.id.txtEdad);
        btnAccion = findViewById(R.id.btnAccion);

        btnAccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtNombre.getText().toString().equals(""))
                {
                    txtNombre.setError(getText(R.string.nombreVacio));
                }

                try
                {
                    if (Integer.parseInt(txtEdad.getText().toString()) > 0 && Integer.parseInt(txtEdad.getText().toString()) < 120)
                    {
                        verificarEdad(Integer.parseInt(txtEdad.getText().toString()), txtNombre.getText().toString());
                    }else
                    {
                        txtEdad.setError(getText(R.string.fueraDeRango).toString());
                    }
                } catch (Exception e)
                {
                    txtEdad.setError(getText(R.string.error).toString());
                }
            }
        });
    }

    private void verificarEdad(int edad, String nombre)
    {
        if(edad > 17)
        {
            Toast.makeText(getApplicationContext(),nombre + " " + getText(R.string.mensajeMayor).toString(), Toast.LENGTH_LONG).show();
        } else
        {
            Toast.makeText(getApplicationContext(),nombre + " " + getText(R.string.mensajeMenor).toString(), Toast.LENGTH_LONG).show();
        }
    }

}