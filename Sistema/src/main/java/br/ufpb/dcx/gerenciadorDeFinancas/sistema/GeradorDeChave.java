package br.ufpb.dcx.gerenciadorDeFinancas.sistema;

import java.util.Random;

public class GeradorDeChave {
    private static final String ALFABETO_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String ALFABETO_UPPER = ALFABETO_LOWER.toUpperCase();
    private static final String NUMEROS = "1234567890";
    private static final String CONJUNTO_ALFANUMERICO = ALFABETO_LOWER + ALFABETO_UPPER + NUMEROS;
    private Random sort = new Random();

    public String geradorDeChaveAlfaNumerico() {
        int quantidadeDeCaracteresDaChave = 8;
        StringBuilder chave = new StringBuilder();

        for (int i = 0; i < quantidadeDeCaracteresDaChave; i++) {
            int indice = sort.nextInt(CONJUNTO_ALFANUMERICO.length());
            chave.append(CONJUNTO_ALFANUMERICO.charAt(indice));
        }
        return chave.toString();
    }


    public int chaveNumerica() {
        int quantidadeDeNumerosDaChave = 15;
        StringBuilder chave = new StringBuilder();

        for (int i = 0; i < quantidadeDeNumerosDaChave; i++) {
            int indice = sort.nextInt(10);
            chave.append(indice);
        }

        return Integer.parseInt(chave.toString());
    }
}
