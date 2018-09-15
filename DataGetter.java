package com.example.guilherme.nac1q11;

import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class DataGetter extends AsyncTask<String,Void,String> {

    private TextView txtNome;
    private TextView txtSobrenome;
    private TextView txtMensagem;

    public DataGetter(TextView txtNome, TextView txtSobrenome, TextView txtMensagem) {
        this.txtNome = txtNome;
        this.txtSobrenome = txtSobrenome;
        this.txtMensagem = txtMensagem;

        txtMensagem.setText("Pesquisando...");
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected String doInBackground(String... strings) {

        String url = strings[0];
        String result = NetworkToolkit.doGet(url);


        return result;
    }

    @Override
    protected void onPostExecute(String s) {

        txtMensagem.setText("Encontrado!");

        try{
            JSONObject jsonResponse = new JSONObject(s);

            String firstName = jsonResponse.getString("title");
            String lastName = jsonResponse.getString("completed");

            txtNome.setText(firstName);
            txtSobrenome.setText(lastName);

        }
        catch(JSONException e){
            this.txtNome.setText("erroJSON");
        }
    }
}
