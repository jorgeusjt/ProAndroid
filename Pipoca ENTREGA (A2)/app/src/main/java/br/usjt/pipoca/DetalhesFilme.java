package br.usjt.pipoca;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class DetalhesFilme extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_filme);

        Intent intent = getIntent();
        Filme oCaraQueFoiTocado = (Filme) intent.getSerializableExtra("filmeSelecionado");

    }
}
