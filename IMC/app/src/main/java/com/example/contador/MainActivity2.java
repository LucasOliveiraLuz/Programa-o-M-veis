package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity2 extends AppCompatActivity {

    float resul;

    TextView IMC;
    TextView sla;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        IMC = findViewById(R.id.IMC2);
        sla = findViewById(R.id.ResultadoF);


                Bundle bundle = getIntent().getExtras();
                String x = bundle.getString("x");
                TextView textview = findViewById(R.id.Peso);

                 String y = bundle.getString("y");
                TextView textview2 = findViewById(R.id.Altura);

                float p;
                p = Float.parseFloat(x);

                float A;
                A = Float.parseFloat(y);


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


    }