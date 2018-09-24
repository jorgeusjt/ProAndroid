package com.example.jorgesampaio.androidstudioprojects.activitylifecycle;
/*Jorge sampaio RA: 81513901*/
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText statusAtividadeA;
    private EditText atividadeA;
    private EditText dadosAtividade;

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
        statusAtividadeA = (EditText) findViewById(R.id.statusAtividadeA);
        String status =  ("Atividade A: Resumed");
        statusAtividadeA.setText(status);

        String mensagem = (" A.onResume()\n A.onStart()\n A.onCreate \n");
        atividadeA= (EditText) findViewById(R.id.atividadeA);
        atividadeA.setText(mensagem);
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
        dadosAtividade = findViewById(R.id.atividadeA);
    }


    public void iniciarAtividade_AB(View view){
        Log.i("ciclodevida","MainActivity:entrou nesse metodo");
        String dadosAtividades = dadosAtividade.getEditableText().toString();
        Intent intent = new Intent(this, AtividadeB.class);
        intent.putExtra("atividadesA",dadosAtividades);
        startActivity(intent);

    }


    public void dialog(View view){

    }
}

