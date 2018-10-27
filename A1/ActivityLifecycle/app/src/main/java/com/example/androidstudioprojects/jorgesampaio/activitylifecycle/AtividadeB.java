package com.example.jorgesampaio.androidstudioprojects.activitylifecycle;

/*Jorge sampaio RA: 81513901*/
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AtividadeB extends AppCompatActivity {

    private EditText atividadeB;
    private EditText statusAtividadeB;
    private String dadosatividadeA;
    private EditText dadosAtividadeB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.atividade_b);
        Log.i("ciclodevida", "AtividadeB:onCreate");

        dadosatividadeA = getIntent().getStringExtra("atividadesA");

        dadosAtividadeB = findViewById(R.id.atividadeB);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ciclodevida", "AtividadeB:onStart");


    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ciclodevida", "AtividadeB:onResume");
        String status = ("Atividade B: Resumed \n Atividade A:Paused");
        statusAtividadeB = (EditText) findViewById(R.id.statusAtividadeB);
        statusAtividadeB.setText(status);

        String mensagem = (" B.onResume()\n B.onStart()\n B.onCreate \n");
        atividadeB = (EditText) findViewById(R.id.atividadeB);
        atividadeB.setText(mensagem + dadosatividadeA);

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ciclodevida", "AtividadeB:onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ciclodevida", "AtividadeB:onPause");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ciclodevida", "AtividadeB:onDestroy");
    }

    protected void onRestart() {
        super.onRestart();
        Log.i("ciclodevida", "AtividadeB:onRestart");
    }


    public void iniciarAtividade_BC(View view) {
        Log.i("ciclodevida", "AtividadeB:entrou nesse metodo");

        String dadosAtividades = dadosAtividadeB.getEditableText().toString();

        Intent intent = new Intent(this, AtividadeC.class);
        intent.putExtra("atividadesB", dadosAtividades);
        startActivity(intent);
    }
}