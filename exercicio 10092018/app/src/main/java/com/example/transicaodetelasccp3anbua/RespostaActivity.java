package com.example.jorgesampaio.transicaodetelasccp3anbua;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class RespostaActivity  extends AppCompatActivity{
    private TextView textoTextView;

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("ciclodevida","RespostaActivity:onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ciclodevida","RespostaActivity:onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ciclodevida","RespostaActivity:onPause");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ciclodevida","RespostaActivity:onStart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ciclodevida","RespostaActivity:onDestroy");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ciclodevida","RespostaActivity:onResume");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resposta);
        Log.i("ciclodevida","RespostaActivity:onCreate");


        String mensagem = getIntent().getStringExtra("resposta");
        textoTextView = (TextView) findViewById(R.id.resposta);
        textoTextView.setText(mensagem);
    }
}
