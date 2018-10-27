package br.usjt.pipoca;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    public static final String CHAVE_GENERO = "textGenero";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void listaFilme(View v){
        Intent intent = new Intent(MainActivity.this, Lista_Filmes.class);
        startActivity(intent);
    }

}