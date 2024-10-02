package br.ufpb.dcx.gerenciadorDeFinancas.exceptions;

public class ContaJaExisteException extends Exception{
    public ContaJaExisteException(){
        super("Uma conta com esse nome já existe, crie outro nick");
    }
}
