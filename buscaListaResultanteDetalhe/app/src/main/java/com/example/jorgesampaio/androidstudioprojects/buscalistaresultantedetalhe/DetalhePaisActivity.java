package com.example.jorgesampaio.androidstudioprojects.buscalistaresultantedetalhe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/**
 Jorge Sampaio de Lima
 Ra: 81513901
 */


public class DetalhePaisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_pais);
        TextView txtPais = (TextView)findViewById(R.id.txtPais);
        Intent intent = getIntent();
        Pais pais = (Pais)intent.getSerializableExtra(ListaPaisesActivity.PAIS);
        txtPais.setText(pais.toString());
    }
}
