package br.usjt.pipoca;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.gson.Gson;
import br.usjt.pipoca.API.ResponseGenero;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Object generoSelect;
    private int generoSelectId;
    private Spinner spinnerGeneros;
    private List<Genero> spinnerArrayGenero;
    private ArrayAdapter<Genero> adapterSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerGeneros = (Spinner)findViewById(R.id.list_genres_spinner);
        spinnerGeneros.setOnItemSelectedListener(new FilmeSelecionado());

        WebServiceGeneros getGeneros = new WebServiceGeneros();
        getGeneros.execute("");
    }

    public void listaFilme(View v){

        Genero gen = (Genero) generoSelect;
        generoSelectId = gen.getId();

        Intent intent = new Intent(MainActivity.this, Lista_Filmes.class);
        intent.putExtra("generoSelectId", String.valueOf(generoSelectId));
        startActivity(intent);
    }

    private class FilmeSelecionado implements AdapterView.OnItemSelectedListener{

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
            generoSelect = parent.getItemAtPosition(pos).toString();
        }

        public void onNothingSelected(AdapterView<?> parent){

        }
    }




    private class WebServiceGeneros extends AsyncTask<String,Void,String> {
        @Override
        protected String doInBackground(String... cidade) {
            try {

                URL url = new URL(getApplicationContext().getString(R.string.uri_genres));
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                InputStream stream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
                String linha = null;
                StringBuilder stringBuilder = new StringBuilder("");
                while ((linha = reader.readLine()) != null) {
                    stringBuilder.append(linha);
                }
                String json = stringBuilder.toString();
                return json;
            } catch(Exception e){
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String json) {
            try {

                Gson gson = new Gson();
                ResponseGenero responseGenero = gson.fromJson(json, ResponseGenero.class);
                spinnerArrayGenero = responseGenero.getGenres();

                adapterSpinner = new ArrayAdapter<Genero>(
                        getApplicationContext(),
                        android.R.layout.simple_spinner_item,
                        spinnerArrayGenero
                );
                spinnerGeneros.setAdapter(adapterSpinner);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
