package br.ufpb.dcx.gerenciadorDeFinancas.sistema;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Despesa implements Serializable{
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Despesa despesa = (Despesa) o;

        if (Double.compare(valorDespesa, despesa.valorDespesa) != 0) return false;
        if (categoriaDespesa != despesa.categoriaDespesa) return false;
        if (!Objects.equals(descricao, despesa.descricao)) return false;
        return Objects.equals(data, despesa.data);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = categoriaDespesa != null ? categoriaDespesa.hashCode() : 0;
        temp = Double.doubleToLongBits(valorDespesa);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }

    public String toString(){
        return "[Despesa: "+this.categoriaDespesa +
                "\nValor: "+this.valorDespesa +
                "\nDescrição: "+this.descricao+
                "\nData: "+this.data+
                "\nID: "+this.idDespesa +"]";
    }
}
