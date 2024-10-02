package br.ufpb.dcx.gerenciadorDeFinancas.sistema;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Record {
    public static final String ARQUIVO_COMPRAS = "arquivo_compras.dat";


    public HashMap<Chave, Compra> recuperaDadosCompras() throws IOException{
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARQUIVO_COMPRAS))){
            return (HashMap<Chave, Compra>) in.readObject();
        }catch (ClassNotFoundException e){
            throw new IOException(e);
        }
    }

    public void gravaCompras(Map<Chave, Compra> compras) throws IOException{
        try(ObjectOutputStream in = new ObjectOutputStream(new FileOutputStream(ARQUIVO_COMPRAS))){
            in.writeObject(compras);
        }
    }
}
