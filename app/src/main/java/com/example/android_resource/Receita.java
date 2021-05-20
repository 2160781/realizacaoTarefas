package com.example.android_resource;

import java.util.ArrayList;
import java.util.List;

public class Receita {

    private List<PassoReceita> listaPassos;
    private int posicao;
    private int total_passos;

    public Receita(){

        listaPassos = new ArrayList<>();
        listaPassos.add(new PassoReceita("1. Passo --> Preparação de ingredientes", ""));
        listaPassos.add(new PassoReceita("2. Passo --> Mistura de ingredientes", ""));
        listaPassos.add(new PassoReceita("4. Passo --> Coloque o bolo no forno", ""));
        listaPassos.add(new PassoReceita("5. Passo --> Finalizar o bolo", ""));

        posicao = 1;
        total_passos = listaPassos.size();


    }

    public String getTexto() {
        return listaPassos.get(posicao - 1).getTexto();
    }

    public void retroceder() {
        if (posicao > 1)
            posicao--;
    }

    public void marcarFeito() {

        listaPassos.get(posicao - 1).setFeito(true);
    }


}
