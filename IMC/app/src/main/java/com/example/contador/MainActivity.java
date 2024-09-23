package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.ButtonClick);
        TextAltura = findViewById(R.id.TextAltura);
        TextPeso = findViewById(R.id.TextPeso);

        button.setText("Calcular");
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(), MainActivity2.class);
                i.putExtra("x",TextPeso.getText().toString());
                i.putExtra("y",TextAltura.getText().toString());
                startActivity(i);

            }
         });
    }
    }