package com.example.jorgesampaio.transicaodetelasccp3anbua;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private EditText mensagemEditText;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ciclodevida","MainActivity:onDestroy");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ciclodevida","MainActivity:onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ciclodevida","MainActivity:onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("ciclodevida","MainActivity:onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ciclodevida","MainActivity:onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ciclodevida","MainActivity:onStop");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("ciclodevida","MainActivity:onCreate");
        setContentView(R.layout.activity_main);
        mensagemEditText = findViewById(R.id.mensagemEditText);
    }

    public void enviarMensagem (View view){
        Log.i("ciclodevida","MainActivity:entrou nesse metodo");
        String mensagem = mensagemEditText.getEditableText().toString();
        //Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, RespostaActivity.class);
        intent.putExtra("resposta",mensagem);
        startActivity(intent);
    }
}
