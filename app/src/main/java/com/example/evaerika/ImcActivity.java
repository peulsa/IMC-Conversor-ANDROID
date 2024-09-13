package com.example.evaerika;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ImcActivity extends AppCompatActivity {

    EditText txtKilos, txtAltura;
    Button btnCalcularImc;
    Button btnVolver;
    TextView txtResultado, txtClasificacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        // Inicializar los componentes
        txtKilos = findViewById(R.id.txtKilos);
        txtAltura = findViewById(R.id.txtAltura);
        btnCalcularImc = findViewById(R.id.btnCalcularImc);
        btnVolver = findViewById(R.id.btnVolver); // Inicializar btnVolver
        txtResultado = findViewById(R.id.txtResultado);
        txtClasificacion = findViewById(R.id.txtClasificacion);

        // Configurar la acción del botón para calcular el IMC
        btnCalcularImc.setOnClickListener(v -> {
            // Obtener los valores de los campos de texto
            String kilosStr = txtKilos.getText().toString();
            String alturaStr = txtAltura.getText().toString();

            if (!kilosStr.isEmpty() && !alturaStr.isEmpty()) {
                // Convertir valores a números
                double peso = Double.parseDouble(kilosStr);
                double altura = Double.parseDouble(alturaStr);

                // Calcular el IMC
                double imc = peso / (altura * altura);

                // Determinar la clasificación del IMC
                String clasificacion;
                if (imc < 18.5) {
                    clasificacion = "Bajo peso";
                } else if (imc < 24.9) {
                    clasificacion = "Normal";
                } else if (imc < 29.9) {
                    clasificacion = "Sobrepeso";
                } else if (imc < 34.9) {
                    clasificacion = "Obesidad Grado 1";
                } else if (imc < 39.9) {
                    clasificacion = "Obesidad Grado 2";
                } else { // Para IMC 40.0 o más
                    clasificacion = "Obesidad Grado 3";
                }


                // Mostrar el resultado y la clasificación en los TextView
                txtResultado.setText("Tu IMC es: " + String.format("%.2f", imc));
                txtClasificacion.setText("Clasificación: " + clasificacion);
            } else {
                // Mostrar un mensaje si faltan datos
                Toast.makeText(ImcActivity.this, "Por favor, ingresa ambos valores", Toast.LENGTH_SHORT).show();
            }
        });

        // Configurar la acción del botón "Volver"
        btnVolver.setOnClickListener(v -> {
            Intent intent = new Intent(ImcActivity.this, MainActivity.class);
            startActivity(intent);
            finish(); // Cierra ImcActivity
        });
    }
}
