package com.example.jorgesampaio.androidstudioprojects.servicedeskccp3anbua;

import java.io.Serializable;

class Chamado implements Serializable {
    private String fila;
    private String descricao;
    public Chamado(String fila, String descricao) {
        this.fila = fila;
        this.descricao = descricao;

    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    @Override
    public String toString(){
        return String.format("(Fila:%s , descricao:%s)",fila,descricao);
    }
}
