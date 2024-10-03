package br.ufpb.dcx.gerenciadorDeFinancas.sistema;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class GravadorDeDados {
    public static final String ARQUIVO_DESPESAS = "arquivo_despesas.dat";
    public static final String ARQUIVOS_RECEITAS = "lista_receitas.dat";


    public HashMap<String, Despesa> recuperarDadosDasDespesas() throws IOException{
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARQUIVO_DESPESAS))){
            return (HashMap<String, Despesa>) in.readObject();
        }catch (ClassNotFoundException e){
            throw new IOException(e);
        }
    }

    public void gravarDespesas(Map<String, Despesa> despesas) throws IOException{
        try(ObjectOutputStream in = new ObjectOutputStream(new FileOutputStream(ARQUIVO_DESPESAS))){
            in.writeObject(despesas);
        }
    }
    public HashMap<String, Receita> recuperarDadosDasReceitas() throws IOException{
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARQUIVOS_RECEITAS))){
            return (HashMap<String, Receita>) in.readObject();
        }catch (ClassNotFoundException e){
            throw new IOException(e);
        }
    }

    public void gravarReceitas(Map<String, Receita> receitas) throws IOException{
        try(ObjectOutputStream in = new ObjectOutputStream(new FileOutputStream(ARQUIVO_DESPESAS))){
            in.writeObject(receitas);
        }
    }



}
