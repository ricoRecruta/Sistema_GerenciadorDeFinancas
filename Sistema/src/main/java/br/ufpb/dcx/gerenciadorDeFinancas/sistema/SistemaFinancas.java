package br.ufpb.dcx.gerenciadorDeFinancas.sistema;

import br.ufpb.dcx.gerenciadorDeFinancas.login.Conta;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.Compra;

import java.util.*;

public class SistemaFinancas implements SistemaGerenciadorFinancas{
    private Map<Chave, Compra> compras;
    private  Conta conta;

    public SistemaFinancas(Conta conta){
        this.compras = new HashMap<>();
        this.conta = conta;

    }

    @Override
    public void cadastrarSalario(double salario) {
        conta.setSalario(salario);
    }

    @Override
    public Collection<Compra> pesquisarPorCategoria(categoriaCompra categoria) {
        Collection <Compra> comprasPorCategoria = new ArrayList<>();

        for(Compra c: this.compras.values()){
            if(c.getCategoriaCompra() == categoria){
                comprasPorCategoria.add(c);
            }
        }

        return comprasPorCategoria;
    }

    @Override
    public void cadastrarCompra(Compra compra) {
        //TODO;
    }

    @Override
    public void editarSalario(double novoSalario) {
        this.conta.setSalario(novoSalario);
    }

    /*@Override
    public double exibirTotalGasto() {
        double valorTotal = 0;
        for (Compra k: this.compras.values()){
            valorTotal = k.getValorCompra() + valorTotal;
        }
        return valorTotal;
    }*/

    public double exibirTotalGasto(){
        return this.compras.values().stream().mapToDouble(Compra::getValorCompra).sum();
    }

    @Override
    public void removerCompra(String descricao) {
        //TODO;
    }

    @Override
    public void editarCompra(String descricao, categoriaCompra novaCategoria, double novoValor) {
        //TODO;
    }

    @Override
    public Collection<Compra> comparacaoDeGastos(double gasto1, double gasto2) {
        return null;
        //TODO;
    }
}
