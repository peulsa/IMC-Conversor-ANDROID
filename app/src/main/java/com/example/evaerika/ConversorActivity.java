package com.example.evaerika;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ConversorActivity extends AppCompatActivity {

    EditText edtCantidadCLP;
    Button btnBTC, btnCNY, btnINR, btnHKD, btnAED, btnSAR;
    Button btnConvertir, btnVolver1;
    TextView txtResultado;
    String monedaSeleccionada = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversor);

        // Inicializar los componentes
        edtCantidadCLP = findViewById(R.id.edtCantidadCLP);
        btnBTC = findViewById(R.id.btnBTC);
        btnCNY = findViewById(R.id.btnCNY);
        btnINR = findViewById(R.id.btnINR);
        btnHKD = findViewById(R.id.btnHKD);
        btnAED = findViewById(R.id.btnAED);
        btnSAR = findViewById(R.id.btnSAR);
        btnConvertir = findViewById(R.id.btnConvertir);
        btnVolver1 = findViewById(R.id.btnVolver1);
        txtResultado = findViewById(R.id.txtResultado);

        // Configurar los botones para seleccionar la moneda
        btnBTC.setOnClickListener(v -> monedaSeleccionada = "BTC");
        btnCNY.setOnClickListener(v -> monedaSeleccionada = "CNY");
        btnINR.setOnClickListener(v -> monedaSeleccionada = "INR");
        btnHKD.setOnClickListener(v -> monedaSeleccionada = "HKD");
        btnAED.setOnClickListener(v -> monedaSeleccionada = "AED");
        btnSAR.setOnClickListener(v -> monedaSeleccionada = "SAR");

        // Configurar la acción del botón para realizar la conversión
        btnConvertir.setOnClickListener(v -> {
            String cantidadStr = edtCantidadCLP.getText().toString();
            if (!cantidadStr.isEmpty() && !monedaSeleccionada.isEmpty()) {
                double cantidadCLP = Double.parseDouble(cantidadStr);
                double resultado = convertirMoneda(cantidadCLP, monedaSeleccionada);
                txtResultado.setText("Resultado: " + String.format("%.2f", resultado));
            } else {
                txtResultado.setText("Ingrese una cantidad válida y seleccione una moneda");
            }
        });

        // Configurar la acción del botón "Volver"
        btnVolver1.setOnClickListener(v -> {
            Intent intent = new Intent(ConversorActivity.this, MainActivity.class);
            startActivity(intent);
            finish(); // Cierra ConversorActivity
        });
    }

    // Método para convertir CLP a la moneda seleccionada
    private double convertirMoneda(double cantidadCLP, String moneda) {
        double tasaCambio;
        switch (moneda) {
            case "BTC": // Bitcoin
                tasaCambio = 0.000023; // Ejemplo de tasa de cambio
                break;
            case "CNY": // Yuan Chino
                tasaCambio = 0.009; // Ejemplo de tasa de cambio
                break;
            case "INR": // Rupia India
                tasaCambio = 0.090; // Ejemplo de tasa de cambio
                break;
            case "HKD": // Dólar de Hong Kong
                tasaCambio = 0.0094; // Ejemplo de tasa de cambio
                break;
            case "AED": // Dirham de los Emiratos Árabes Unidos
                tasaCambio = 0.0044; // Ejemplo de tasa de cambio
                break;
            case "SAR": // Rial Saudí
                tasaCambio = 0.0045; // Ejemplo de tasa de cambio
                break;
            default:
                tasaCambio = 1.0; // Si no se encuentra la moneda, no se hace conversión
                break;
        }
        return cantidadCLP * tasaCambio;
    }
}
