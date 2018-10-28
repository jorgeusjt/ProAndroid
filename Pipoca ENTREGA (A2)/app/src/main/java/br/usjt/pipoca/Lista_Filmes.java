package br.usjt.pipoca;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import br.usjt.pipoca.API.ResponseFilme;
import br.usjt.pipoca.API.ResponseResult;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Lista_Filmes extends AppCompatActivity {

    List<Filme> filmesList;
    private FilmeAdpter adapter;
    private ListView filmeListView;
    public static final String FILME = "filme";
    private Activity atividade;
    private String generoSelect;
    private String generoSelectId;
    private Genero  genero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_filmes);
        atividade = this;
        Intent intent = getIntent();
        generoSelect = intent.getStringExtra("generoSelect");
        generoSelectId = intent.getStringExtra("generoSelectId");
        genero = new Genero(Integer.parseInt(generoSelectId), generoSelect);

        filmesList = new ArrayList<>();
        filmeListView = findViewById(R.id.listFilmeListView);



        WebServiceListFilmes listFilmes = new WebServiceListFilmes();
        listFilmes.execute(genero.getId());

        filmeListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id){
                Intent intent = new Intent(atividade,DetalhesFilme.class);
                intent.putExtra("filme",filmesList.get(position));
                startActivity(intent);
            }
        });
    }


    private class WebServiceListFilmes extends AsyncTask<Integer,Void,String> {

        @Override
        protected String doInBackground(Integer... idGenero) {
            try {
                String uri = getApplicationContext().getString(R.string.uri_listFilmes) + idGenero[0]+"";
                URL url = new URL(uri);
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
//
            try {

                Gson gson = new Gson();
                ResponseFilme responseFilme = gson.fromJson(json, ResponseFilme.class);
                List<ResponseResult> responseResults = responseFilme.getResults();
                for (ResponseResult r: responseResults){
                    Filme filme = new Filme(
                            r.getId(),
                            r.getTitle(),
                            r.getOverview(),
                            r.getPopularity(),
                            r.getRelease_date(),
                            r.getPoster_path(),
                            r.getDirector(),
                            genero);
                    filmesList.add(filme);
                }

                adapter = new FilmeAdpter(getApplicationContext(),filmesList);

                filmeListView.setAdapter(adapter);


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
