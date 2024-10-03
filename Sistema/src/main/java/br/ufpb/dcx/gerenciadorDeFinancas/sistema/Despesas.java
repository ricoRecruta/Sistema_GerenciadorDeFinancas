package br.ufpb.dcx.gerenciadorDeFinancas.sistema;

import java.text.SimpleDateFormat;

public class Despesas {
    private Chave idReceita;
    private CategoriaCompra categoriaCompra;
    private double valorCompra;
    private String descricao;
//teste
    public Despesas(CategoriaCompra categoriaCompra, double valorCompra, String descricao){
        this.idReceita = new Chave();
        this.categoriaCompra = categoriaCompra;
        this.valorCompra = valorCompra;
        this.descricao = descricao;
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yy");
    }

    public Despesas(){
        this(CategoriaCompra.OUTROS, 0.0, "");
    }

    public Chave getIdCompra() {
        return idReceita;
    }

    public void setIdCompra(Chave idCompra) {
        this.idReceita = idCompra;
    }

    public CategoriaCompra getCategoriaCompra() {
        return categoriaCompra;
    }

    public void setCategoriaCompra(CategoriaCompra categoriaCompra) {
        this.categoriaCompra = categoriaCompra;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String toString(){
        return "[Compra: "+this.categoriaCompra+
                "\nValor: "+this.valorCompra+
                "\nDescrição: "+this.descricao+
                "\nID: "+this.idReceita +"]";
    }
}
