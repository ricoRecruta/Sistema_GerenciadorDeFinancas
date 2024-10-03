package br.ufpb.dcx.gerenciadorDeFinancas.exceptions;

public class DespesaNaoExisteException extends Exception{
    public DespesaNaoExisteException(String msg){
        super(msg);
    }
}
