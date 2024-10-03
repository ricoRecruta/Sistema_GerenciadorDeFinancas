package br.ufpb.dcx.gerenciadorDeFinancas.sistema;


import br.ufpb.dcx.gerenciadorDeFinancas.exceptions.*;
import java.util.*;

/**
 * Classe que implementa a interface SistemaGerenciadorDeFinancas.
 * Permite cadastrar compras, salários, pesquisar compras por categoria,
 * editar e remover compras e exibir o total de gastos.
 */
public class SistemaFinancas implements SistemaGerenciadorFinancas {
    /** Mapa que armazena as compras, onde a chave é um identificador único da compra. */
    private Map<String, Despesa> compras;
    private Map<String, Receita> receitas;

    /** Conta do usuário, que contém as informações financeiras como salário e pessoais do usuário. */
    private double salario;

    /**
     * Construtor da classe SistemaFinancas.
     *
     * @param
     */
    public SistemaFinancas() {
        this.compras = new HashMap<>();


    }


    @Override
    public void cadastrarSalario(double salario) {
        this.salario = salario;
    }


    @Override
    public void editarSalario(double novoSalario) {
        this.salario = novoSalario;
    }


    @Override
    public void cadastrarCompra(Despesa compra) throws CompraJaCadastradaException {
        if (compras.containsKey(compra.getIdCompra())) {
            throw new CompraJaCadastradaException("Compra com o ID " + compra.getIdCompra() + "já cadastrada no sistema!");
        }
        this.compras.put(compra.getIdCompra(), compra);
    }


    @Override
    public void editarCompra(String idCompra, CategoriaCompra novaCategoria, double novoValor, String novaDescricao) throws CompraNaoExisteException {
        if (compras.containsKey(idCompra)) {
            Despesa compraExistente = compras.get(idCompra);
            compraExistente.setCategoriaCompra(novaCategoria);
            compraExistente.setValorCompra(novoValor);
            compraExistente.setDescricao(novaDescricao);

            compras.put(idCompra, compraExistente);
        } else {
            throw new CompraNaoExisteException("Compra com o ID " + idCompra + " não encontrada no sistema.");
        }
    }


    @Override
    public void removerCompra(Despesa compra) throws CompraNaoExisteException {
        //TODO
    }


    @Override
    public Collection<Despesa> pesquisarPorCategoria(CategoriaCompra categoria) {
        Collection<Despesa> comprasPorCategoria = new ArrayList<>();

        for (Despesa c : this.compras.values()) {
            if (c.getCategoriaCompra() == categoria) {
                comprasPorCategoria.add(c);
            }
        }
        return comprasPorCategoria;
    }

    /*@Override
    public double exibirTotalGasto() {
        double valorTotal = 0;
        for (Compra k: this.compras.values()){
            valorTotal = k.getValorCompra() + valorTotal;
        }
        return valorTotal;
    }*/


    public double exibirTotalGasto() {
        return this.compras.values().stream().mapToDouble(Despesa::getValorCompra).sum();
    }


    @Override
    public Collection<Despesa> comparacaoDeGastos(double gasto1, double gasto2) {
        return null;
        //TODO;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
