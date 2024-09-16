package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button button; //variavel vaia

    EditText TextPeso;
    EditText TextAltura;

    TextView IMC;
    TextView sla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.ButtonClick);
        TextAltura = findViewById(R.id.TextAltura);
        TextPeso = findViewById(R.id.TextPeso);
        IMC = findViewById(R.id.IMC);
        sla = findViewById(R.id.sla);

        button.setText("Carcular");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Float resul;
                Float p = Float.valueOf(TextPeso.getText().toString());
                Float A = Float.valueOf(TextAltura.getText().toString());

                resul = p/(A*A);

                IMC.setText("Calculo: "+resul);
                if (resul <= 18.5){
                    sla.setText("Abaixo do peso");
                }
                else if(resul>18.5 && resul<24.9){
                    sla.setText("Peso normal");
                }
                else if(resul>25 && resul<29.9){
                    sla.setText("Sobrepeso");
                }
                else if(resul>30 && resul<34.9){
                    sla.setText("Obesidade Grau I");
                }
                else if(resul>35 && resul<39.9){
                    sla.setText("Obesidade Grau II");
                }
                else {
                    sla.setText("Obesidade Grau III");
                }
            }
         });
    }
    }