package br.ufpb.dcx.gerenciadorDeFinancas.sistema;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Receita {

    private String idReceita;
    private double valor;
    private LocalDate data;

    public Receita(String id, double valor, LocalDate data){
        this.idReceita = id;
        this.valor = valor;
        this.data = data;
    }
    public Receita(){
        this("",0,LocalDate.now());
    }

    public double getValor(){
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getIdReceita() {
        return idReceita;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String toString(){
        return "Receita: "+this.valor+
                "\nID: "+this.idReceita;
    }

}
