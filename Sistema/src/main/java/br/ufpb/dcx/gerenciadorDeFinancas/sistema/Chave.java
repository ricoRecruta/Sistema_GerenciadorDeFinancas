package br.ufpb.dcx.gerenciadorDeFinancas.sistema;

import java.util.Random;

public class Chave {
    private GeradorDeChave geradorDeChave;
    private String chave;

    public Chave() {
        geradorDeChave = new GeradorDeChave();
        this.chave = geradorDeChave.geradorDeChaveAlfaNumerico();
    }

    public String getChave() {
        return chave;
    }
}
