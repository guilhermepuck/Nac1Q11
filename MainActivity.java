package com.example.guilherme.nac1q11;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void executaConsulta(View view){

        String response;
        String url = "https://jsonplaceholder.typicode.com/todos/";

        EditText txtConsulta = findViewById(R.id.editTextPesquisa);
        url += txtConsulta.getText().toString();

        TextView txtNome = findViewById(R.id.txtNome);
        TextView txtSobrenome = findViewById(R.id.txtSobrenome);
        TextView txtMensagem = findViewById(R.id.viewMensagem);


        new DataGetter(txtNome,txtSobrenome,txtMensagem).execute(url);

    }
}