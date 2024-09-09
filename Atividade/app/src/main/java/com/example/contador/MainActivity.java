package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button button; //variavel vaia
    TextView text;

    Random Sorteio = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.teste);

        button = findViewById(R.id.ButtonClick);
        button.setText("click");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText("Sorteio: "+Sorteio.nextInt(500));
            }
         });
    }
    }