package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase database;
    EditText edNome,edEmail,edDtnsc;
    Button button;

    ListView listview;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edNome = findViewById(R.id.edNome);
        edEmail = findViewById(R.id.edEmail);
        edDtnsc = findViewById(R.id.edDtnsc);
        button = findViewById(R.id.btCadastra);
        listview = findViewById(R.id.listView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = edNome.getText().toString();
                String email = edEmail.getText().toString();

                ContentValues cv = new ContentValues();
                cv.put("nome",nome);
                cv.put("email",email);
                long status=database.insert("pessoas", null,cv);

                if (status>0){
                    Toast.makeText(getApplicationContext(), "Usuário inserido com sucesso", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Erro na inserção", Toast.LENGTH_SHORT).show();
                }
                carregarListagem();
                limparCampos();
            }
        });

        database = openOrCreateDatabase("meudt", MODE_PRIVATE,null);
        database.execSQL("CREATE TABLE IF NOT EXISTS pessoa (id iNTEGER PRIMARY KEY AUTOINCREMENT,nome varchar, email varchar, dtnsc DATE)");
    }
    public void carregarListagem(){
        Cursor cursor = database.rawQuery("SELECT * FROM pessoas ",null);
        cursor.moveToFirst();
        ArrayList<String> nomes = new ArrayList<>();
        while (!cursor.isAfterLast()){
            nomes.add(cursor.getString(1));
            cursor.moveToNext();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,android.R.layout.simple_list_item_1,
                android.R.id.text1,
                nomes);
        listview.setAdapter(adapter);
        cursor.close();
    }
    public void limparCampos() {
        edNome.setText("");
        edEmail.setText("");
        edDtnsc.setText("");
    }
}