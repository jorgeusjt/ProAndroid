package com.example.jorgesampaio.androidstudioprojects.servicedeskccp3anbua;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


public class ChamadosAdapter extends ArrayAdapter <Chamado>{

    private List<Chamado> chamados;
    private Context context;
    public ChamadosAdapter(List<Chamado> chamados, Context context){
        super(context,-1,chamados);
        this.chamados = chamados;
        this.context = context;
    }

    @Override
    public int getCount() {
        return chamados.size();
    }

    @Override
    public Chamado getItem(int position) {
        return chamados.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View viewQueTalvezExista, ViewGroup parent) {
        Chamado deInteresse = chamados.get(position);
        TextView filaDoItemTextView;
        TextView descricaoDoItemTextView;
        ViewHolder vh;
        if(viewQueTalvezExista == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            viewQueTalvezExista = inflater.inflate(R.layout.list_item,parent,false);
            filaDoItemTextView =  viewQueTalvezExista.findViewById(R.id.filaDoItemTextView);
            descricaoDoItemTextView =  viewQueTalvezExista.findViewById(R.id.descricaoDoItemTextView);
            vh = new ViewHolder();
            vh.filaDoItemTextView = filaDoItemTextView;
            vh.descricaoDoItemTextView = descricaoDoItemTextView;
            viewQueTalvezExista.setTag(vh);
        }
        vh =(ViewHolder) viewQueTalvezExista.getTag();
        vh.filaDoItemTextView.setText(deInteresse.getFila());
        vh.descricaoDoItemTextView.setText(deInteresse.getDescricao());
        return viewQueTalvezExista;
    }
    private  class ViewHolder{
        TextView filaDoItemTextView;
        TextView descricaoDoItemTextView;
    }
}
