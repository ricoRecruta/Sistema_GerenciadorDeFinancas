package br.ufpb.dcx.gerenciadorDeFinancas.sistema;

import br.ufpb.dcx.gerenciadorDeFinancas.login.Conta;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaFinancas {
    private Map<Chave, Compra> compras;
    private Map<String, Conta> contas;

    public SistemaFinancas(){
        this.compras = new HashMap<>();
        this.contas = new HashMap<>();
    }
}
