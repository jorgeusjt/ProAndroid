package com.example.jorgesampaio.androidstudioprojects.servicedeskccp3anbua;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class DetalhesActivity extends AppCompatActivity {
    private TextView nomeFilaTextView;
    private TextView descricaoChamadoTextView;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);
         nomeFilaTextView =
                 findViewById(R.id.nomeFilaTextView);
         descricaoChamadoTextView =
                 findViewById(R.id.descricaoChamadoTextView);

         Intent intent = getIntent();
         Chamado oCaraQueFoiTocado = (Chamado) intent.getSerializableExtra("oCaraQueFoiTocado");
//         String [] partes = oCaraQueFoiTocado.split(":");
         nomeFilaTextView.setText(oCaraQueFoiTocado.getFila().trim());
         descricaoChamadoTextView.setText(oCaraQueFoiTocado.getDescricao().trim());
    }
}
