package com.example.android_resource;

import java.util.ArrayList;
import java.util.List;




public class DadosApp {

    private List<Receita> listaReceitas;
    private int passo;


    // singleton
    public DadosApp(int posicao) {

        listaReceitas = new ArrayList<>();
        listaReceitas.add(new Receita(posicao));
        passo = 1;



    }


    public String getTextoPassoReceita() {

        return listaReceitas.get(passo - 1).getTexto();
    }

    public void avancar() {
        if (passo < listaReceitas.size())
            passo++;

    }

    public void retroceder() {
        if (passo > 1)
            passo--;
    }

    public void marcarFeito() {
        listaReceitas.get(passo - 1).marcarFeito();
    }


}
