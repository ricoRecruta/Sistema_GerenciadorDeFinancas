package br.ufpb.dcx.gerenciadorDeFinancas.sistema;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class GeradorDeChave {
    private static final String ALFABETO_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String ALFABETO_UPPER = ALFABETO_LOWER.toUpperCase();
    private static final String NUMEROS = "1234567890";
    private static final String CONJUNTO_ALFANUMERICO = ALFABETO_LOWER + ALFABETO_UPPER + NUMEROS;
    private Random sort = new Random();
    private long numeroDePossibilidades =  (long)Math.pow(CONJUNTO_ALFANUMERICO.length(),8);
    private long contador = 0;
    private ArrayList<String> listaDeTodasAsChaves = new ArrayList<>();

    public String geradorDeChaveAlfaNumerico() throws IOException {

            while(contador < numeroDePossibilidades) {
                int quantidadeDeCaracteresDaChave = 8;
                StringBuilder chave = new StringBuilder();
                String chaveTotaltemporaria = CONJUNTO_ALFANUMERICO;


                for (int i = 0; i < quantidadeDeCaracteresDaChave; i++) {
                    int indice = sort.nextInt(CONJUNTO_ALFANUMERICO.length());
                    chave.append(CONJUNTO_ALFANUMERICO.charAt(indice));
                }

                String chaveSorteada = chave.toString();


                if (listaDeTodasAsChaves.contains(chaveSorteada)) {
                    geradorDeChaveAlfaNumerico();
                } else {
                    listaDeTodasAsChaves.add(chaveSorteada);
                    contador++;
                    return chaveSorteada;
                }
            }
            throw new IOException("Não foi possivel gerar uma chave");
    }

}
