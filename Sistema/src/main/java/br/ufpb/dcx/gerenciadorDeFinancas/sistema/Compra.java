package br.ufpb.dcx.gerenciadorDeFinancas.sistema;

public class Compra {
    private Chave idCompra;
    private  categoriaCompra categoriaCompra;
    private double valorCompra;
    private String descricao;

    public Compra(categoriaCompra categoriaCompra, double valorCompra, String descricao){
        this.idCompra = new Chave();
        this.categoriaCompra = categoriaCompra;
        this.valorCompra = valorCompra;
        this.descricao = descricao;
    }

    public Compra(){
        this(categoriaCompra.OUTROS, 0.0, "");
    }

    public Chave getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Chave idCompra) {
        this.idCompra = idCompra;
    }

    public br.ufpb.dcx.gerenciadorDeFinancas.sistema.categoriaCompra getCategoriaCompra() {
        return categoriaCompra;
    }

    public void setCategoriaCompra(br.ufpb.dcx.gerenciadorDeFinancas.sistema.categoriaCompra categoriaCompra) {
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
}
