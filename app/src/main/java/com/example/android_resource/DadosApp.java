package com.example.android_resource;

import java.util.ArrayList;
import java.util.List;




public class DadosApp {

    private List<Receita> listaReceitas;
    private int posicao;


    // singleton
    public DadosApp() {

        listaReceitas = new ArrayList<>();
        listaReceitas.add(new Receita());
        posicao = 1;



    }


    public String getTextoPassoReceita() {

        return listaReceitas.get(posicao - 1).getTexto();
    }

    public void avancar() {
        if (posicao < listaReceitas.size())
            posicao++;

    }

    public void retroceder() {
        if (posicao > 1)
            posicao--;
    }

    public void marcarFeito() {
        listaReceitas.get(posicao - 1).marcarFeito();
    }


}
