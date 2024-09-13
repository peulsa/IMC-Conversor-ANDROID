package com.example.evaerika;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.activity.ComponentActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends ComponentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configuración para el manejo de insets (espacios para la barra de estado y navegación)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializar el botón
        Button botonImc = findViewById(R.id.botonImc);

        // Configurar el OnClickListener para el botón
        botonImc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un inicio de solicitud para abrir a ImcActivity
                Intent intent = new Intent(MainActivity.this, ImcActivity.class);
                startActivity(intent);
            }
        });

        // Inicializar el botón de Conversor
        Button botonConversor = findViewById(R.id.botonConversor);
        botonConversor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para abrir ConversorActivity
                Intent intent = new Intent(MainActivity.this, ConversorActivity.class);
                startActivity(intent);
            }
        });
    }
}
