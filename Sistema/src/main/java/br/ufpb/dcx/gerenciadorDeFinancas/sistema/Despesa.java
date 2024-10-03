package br.ufpb.dcx.gerenciadorDeFinancas.sistema;

import java.time.LocalDate;

public class Despesa {
    private String idDespesa;
    private CategoriaDespesa categoriaCompra;
    private double valorDespesa;
    private String descricao;
    private LocalDate data;

//teste
    public Despesa(String idDespesa, CategoriaDespesa categoriaDespesa, double valorDespesa, String descricao, LocalDate data){
        this.idDespesa = idDespesa;
        this.categoriaCompra = categoriaDespesa;
        this.valorDespesa = valorDespesa;
        this.descricao = descricao;
         this.data = data;
    }

    public Despesa(){
        this("", CategoriaDespesa.OUTROS, 0.0, "",LocalDate.now());
    }

    public String getIdDespesa() {
        return idDespesa;
    }

    public void setIdDespesa(String novaIdDespesa) {
        this.idDespesa = novaIdDespesa;
    }

    public CategoriaDespesa getCategoriaCompra() {
        return categoriaCompra;
    }

    public void setCategoriaCompra(CategoriaDespesa categoriaDespesa) {
        this.categoriaCompra = categoriaDespesa;
    }

    public double getValorDespesa() {
        return valorDespesa;
    }

    public void setValorDespesa(double valorDespesa) {
        this.valorDespesa = valorDespesa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String toString(){
        return "[Despesa: "+this.categoriaCompra+
                "\nValor: "+this.valorDespesa +
                "\nDescrição: "+this.descricao+
                "\nID: "+this.idDespesa +"]";
    }
}
