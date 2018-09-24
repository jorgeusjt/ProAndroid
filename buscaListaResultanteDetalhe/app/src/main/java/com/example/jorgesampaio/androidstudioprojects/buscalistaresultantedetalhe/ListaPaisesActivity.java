package com.example.jorgesampaio.androidstudioprojects.buscalistaresultantedetalhe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 Jorge Sampaio de Lima
 Ra: 81513901
 */


public class ListaPaisesActivity extends AppCompatActivity {
    public static final String PAIS = "pais";


    ArrayList<String> nomes;
    ArrayList<Pais> paises;
    Activity atividade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_paises);
        atividade = this;
        Intent intent = getIntent();
        String continente = intent.getStringExtra(MainActivity.CHAVE_CONTINENTE);
        paises = Data.listarPaises(continente);
        nomes = Data.listarNomes(paises);

        ListView listView = (ListView) findViewById(R.id.lista_paises);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,nomes);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent,View view,
                                    int position,long id){
                Intent intent = new Intent(atividade,DetalhePaisActivity.class);
                intent.putExtra(PAIS,paises.get(position));
                startActivity(intent);
            }
        });

    }

}
