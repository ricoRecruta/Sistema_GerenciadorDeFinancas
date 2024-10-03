package br.ufpb.dcx.gerenciadorDeFinancas.sistema;

public class Receita {

    private String idReceita;
    private double valor;

    public Receita(String id, double valor){
        this.idReceita = id;
        this.valor = valor;
    }
    public Receita(){
        this("",0);
    }

    public double getValor(){
        return this.valor;
    }

    public String toString(){
        return "Receita: "+this.valor+
                "\nID: "+this.idReceita;
    }

}
