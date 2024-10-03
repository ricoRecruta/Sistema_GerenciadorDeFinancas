package br.ufpb.dcx.gerenciadorDeFinancas.sistema;

import java.time.LocalDate;

public class Despesa {
    private String idDespesa;
    private CategoriaDespesa categoriaDespesa;
    private double valorDespesa;
    private String descricao;
    private LocalDate data;

//teste
    public Despesa(String idDespesa, CategoriaDespesa categoriaDespesa, double valorDespesa, String descricao, LocalDate data){
        this.idDespesa = idDespesa;
        this.categoriaDespesa = categoriaDespesa;
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

    public CategoriaDespesa getCategoriaDespesa() {
        return categoriaDespesa;
    }

    public void setCategoriaDespesa(CategoriaDespesa categoriaDespesa) {
        this.categoriaDespesa = categoriaDespesa;
    }

    public double getValorDespesa() {
        return valorDespesa;
    }

    public void setValorDespesa(double valorDespesa) {
        this.valorDespesa = valorDespesa;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String toString(){
        return "[Despesa: "+this.categoriaDespesa +
                "\nValor: "+this.valorDespesa +
                "\nDescrição: "+this.descricao+
                "\nData: "+this.data+
                "\nID: "+this.idDespesa +"]";
    }
}
