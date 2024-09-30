package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity2 extends AppCompatActivity {

    float resul;

    TextView IMC;
    TextView sla;

    ImageView image;


    @SuppressLint({"MissingInflatedId", "ResourceType", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        IMC = findViewById(R.id.IMC2);
        sla = findViewById(R.id.ResultadoF);
        image = findViewById(R.id.imageView);


                Bundle bundle = getIntent().getExtras();
                String x = bundle.getString("x");

                String y = bundle.getString("y");


                float p;
                p = Float.parseFloat(x);

                float A;
                A = Float.parseFloat(y);


                resul = p/(A*A);

                IMC.setText("Calculo: "+resul);

                if (resul <= 18.5){
                    sla.setText("Abaixo do peso");
                    image.setImageResource(R.drawable.abaixopeso);

                }
                else if(resul>18.5 && resul<24.9){
                    sla.setText("Peso normal");
                    image.setImageResource(R.drawable.normal);
                }
                else if(resul>25 && resul<29.9){
                    sla.setText("Sobrepeso");
                    image.setImageResource(R.drawable.sobrepeso);
                }
                else if(resul>30 && resul<34.9){
                    sla.setText("Obesidade Grau I");
                    image.setImageResource(R.drawable.obesidade1);
                }
                else if(resul>35 && resul<39.9){
                    sla.setText("Obesidade Grau II");
                    image.setImageResource(R.drawable.obesidade2);
                }
                else {
                    sla.setText("Obesidade Grau III");
                    image.setImageResource(R.drawable.obesidade3);
                }

            }


    }