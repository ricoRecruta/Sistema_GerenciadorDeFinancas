package br.ufpb.dcx.gerenciadorDeFinancas.sistema;

public class Receita {

    private Chave idReceita;
    private double valor;

    public Receita(double valor){
        this.idReceita = new Chave();
        this.valor = valor;
    }
    public Receita(){
        this(0.0);
    }

    public double getValor(){
        return this.valor;
    }

    public String toString(){
        return "Receita: "+this.valor+
                "\nID: "+this.idReceita;
    }

}
