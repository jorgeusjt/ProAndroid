package com.example.jorgesampaio.androidstudioprojects.buscalistaresultantedetalhe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;


/**
 Jorge Sampaio de Lima
 Ra: 81513901
 */


public class MainActivity extends AppCompatActivity {
    Spinner spinnerContinente;
    public static final String CHAVE_CONTINENTE = "txtContinente";
    String continente = "Todos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerContinente = (Spinner) findViewById(R.id.continentes);
        spinnerContinente.setOnItemSelectedListener(new PaisSelecionado());
    }

    public void listarPaises(View view){
        Intent intent = new Intent(this,ListaPaisesActivity.class);
        intent.putExtra(CHAVE_CONTINENTE,continente);
        startActivity(intent);
    }

    private class PaisSelecionado implements AdapterView.OnItemSelectedListener{
        @Override
        public void onItemSelected(AdapterView<?> parent,View view,int position,long id){
            continente = (String) parent.getItemAtPosition(position);
        }
        @Override
        public void onNothingSelected(AdapterView<?> parent){

        }

    }
}
