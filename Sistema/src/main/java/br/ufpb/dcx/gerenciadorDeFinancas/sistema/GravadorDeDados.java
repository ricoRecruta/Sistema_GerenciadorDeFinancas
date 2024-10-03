package br.ufpb.dcx.gerenciadorDeFinancas.sistema;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class GravadorDeDados {
    public static final String ARQUIVO_DESPESAS = "arquivo_despesas.dat";
    public static final String ARQUIVOS_RECEITAS = "lista_receitas.dat";


    public HashMap<Chave, Despesas> recuperaDadosDasDespesas() throws IOException{
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARQUIVO_DESPESAS))){
            return (HashMap<Chave, Despesas>) in.readObject();
        }catch (ClassNotFoundException e){
            throw new IOException(e);
        }
    }

    public void gravarDespesas(Map<Chave, Despesas> despesas) throws IOException{
        try(ObjectOutputStream in = new ObjectOutputStream(new FileOutputStream(ARQUIVO_DESPESAS))){
            in.writeObject(despesas);
        }
    }
    public HashMap<Chave, Receita> recuperaDadosDasRceitas() throws IOException{
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARQUIVOS_RECEITAS))){
            return (HashMap<Chave, Receita>) in.readObject();
        }catch (ClassNotFoundException e){
            throw new IOException(e);
        }
    }

    public void gravarReceitas(Map<Chave, Receita> receitas) throws IOException{
        try(ObjectOutputStream in = new ObjectOutputStream(new FileOutputStream(ARQUIVO_DESPESAS))){
            in.writeObject(receitas);
        }
    }



}
