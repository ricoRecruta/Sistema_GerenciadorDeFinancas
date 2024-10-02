package br.ufpb.dcx.gerenciadorDeFinancas.login;




import br.ufpb.dcx.gerenciadorDeFinancas.exceptions.ContaJaExisteException;
import br.ufpb.dcx.gerenciadorDeFinancas.login.Conta;


import java.util.HashMap;

public class SistemaLogin {
    private HashMap<String, Conta> MapDeContas;

    public SistemaLogin() {
        MapDeContas = new HashMap<>();
    }

    public void cadastrarConta(String nome, String senha) throws ContaJaExisteException {
        if (MapDeContas.containsKey(nome)) {
            throw new ContaJaExisteException();
        } else {
            Conta conta = new Conta(nome, senha);
            MapDeContas.put(nome,conta);
        }
    }

    public boolean VerificarConta(){ return false;}

    public boolean ValidarConta(String nome, String senha){
        for(Conta c: MapDeContas.values()){
            if(c.verificarConta(nome,senha)){
                return true;
            }
        }
        return false;
    }

}

