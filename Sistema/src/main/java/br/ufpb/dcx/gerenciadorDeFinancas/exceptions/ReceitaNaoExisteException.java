package br.ufpb.dcx.gerenciadorDeFinancas.exceptions;

public class ReceitaNaoExisteException extends Exception{
    public ReceitaNaoExisteException(String msg){
        super(msg);
    }
}
