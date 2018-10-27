package com.example.jorgesampaio.androidstudioprojects.servicedeskccp3anbua;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class ListaChamadosActivity extends AppCompatActivity {
    private ListView listView;
    private List<Chamado> chamados;
    private ChamadosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_chamados);
        listView = (ListView) findViewById(R.id.listView);
        chamados = new ArrayList<>();
        adapter = new ChamadosAdapter(chamados,this);
        listView.setAdapter(adapter);
        Intent intent = getIntent();
        String valor = intent.getStringExtra(MainActivity.NOME_FILA);
        chamados.addAll(buscaChamados(valor));
        adapter.notifyDataSetChanged();
        ListView.OnItemClickListener itemClickListener = // toca no item que esta na lista, e nao na lista.
                    new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Chamado oCaraQueFoiTocado = chamados.get(position);

//                            Toast.makeText(ListaChamadosActivity.this, oCaraQueFoiTocado, Toast.LENGTH_SHORT).show();
                            Intent detalhesIntent = new Intent(ListaChamadosActivity.this, DetalhesActivity.class);
                            detalhesIntent.putExtra("oCaraQueFoiTocado",oCaraQueFoiTocado);
                            startActivity(detalhesIntent);
                        }
                    };
        listView.setOnItemClickListener(itemClickListener);

    }


    public ArrayList<Chamado> geraListaChamados(){
        ArrayList<Chamado> lista = new ArrayList<>();
        lista.add(new Chamado ("Desktops", "Computador da secretária quebrado."));
        lista.add(new Chamado ("Telefonia:", "Telefone não funciona."));
        lista.add (new Chamado ("Redes:" ,"Manutenção no proxy."));
        lista.add(new Chamado ("Servidores:","Lentidão generalizada."));
        lista.add(new Chamado ("Novos Projetos:", "CRM"));
        lista.add(new Chamado ("Manutenção Sistema ERP:", "atualizar versão."));
        lista.add(new Chamado ("Novos Projetos:", "Rede MPLS"));
//        lista.add("Manutenção Sistema de Vendas: incluir pipeline.");
//        lista.add("Manutenção Sistema ERP: erro contábil");
//        lista.add("Novos Projetos: Gestão de Orçamento");
//        lista.add("Novos Projetos: Big Data");
//        lista.add("Manoel de Barros");
//        lista.add("Redes: Internet com lentidão");
//        lista.add("Novos Projetos: Chatbot");
//        lista.add("Desktops: troca de senha");
//        lista.add("Desktops: falha no Windows");
//        lista.add("Novos Projetos: ITIL V3");
//        lista.add("Telefonia: liberar celular");
//        lista.add("Telefonia: mover ramal");
//        lista.add("Redes: ponto com defeito");
//        lista.add("Novos Projetos: ferramenta EMM");
        return lista;
    }

    public ArrayList<Chamado> buscaChamados(String chave){
        ArrayList<Chamado> lista = geraListaChamados();
        if (chave == null || chave.length() == 0){
            return lista;
        } else {
            ArrayList<Chamado> subLista = new ArrayList<>();
            for(Chamado chamado:lista){
                if(chamado.getDescricao().toUpperCase().contains(chave.toUpperCase())){
                    subLista.add(chamado);
                }
            }
            return subLista;
        }
    }

}
