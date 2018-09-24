package br.com.jorgesampaio.transicaodetelasccp3anbua;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mensagemEditText;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ciclodevida", "MainActivity:onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("ciclodevida", "MainActivity:onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ciclodevida", "MainActivity:onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ciclodevida", "MainActivity:onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ciclodevida", "MainActivity:onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ciclodevida", "MainActivity:onStart");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("ciclodevida", "MainActivity:onCreate");
        mensagemEditText = findViewById(R.id.mensagemEditText);
    }

    public void enviarMensagem (View view){
        String mensagem = mensagemEditText.getEditableText().toString();
        //Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, RespostaActivity.class);
        intent.putExtra("resposta",mensagem);
        startActivity(intent);
    }
}
