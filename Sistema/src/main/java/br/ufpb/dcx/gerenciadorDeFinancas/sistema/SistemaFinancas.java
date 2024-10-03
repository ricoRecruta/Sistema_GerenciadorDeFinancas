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
    private Map<String, Despesa> despesas;
    private Map<String, Receita> receitas;

    /** Conta do usuário, que contém as informações financeiras como salário e pessoais do usuário. */
    private double salario;

    /**
     * Construtor da classe SistemaFinancas.
     *
     * @param
     */
    public SistemaFinancas() {
        this.despesas = new HashMap<>();


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
    public void cadastrarDespesa(Despesa despesa) throws DespesaJaCadastradaException {
        for (Despesa a: this.despesas.values()){
            if (despesas.containsKey(despesa.getIdDespesa()) && a.getData() == despesa.getData()){
                throw new DespesaJaCadastradaException("Compra com o ID " + despesa.getIdDespesa() + "já cadastrada no sistema!");
            }else {
                this.despesas.put(despesa.getIdDespesa(), despesa);
            }
        }
    }


    @Override
    public void editarDespesa(String idDespesa, CategoriaDespesa novaCategoria, double novoValor, String novaDescricao) throws DespesaNaoExisteException {
        if (despesas.containsKey(idDespesa)) {
            Despesa compraExistente = despesas.get(idDespesa);
            compraExistente.setCategoriaDespesa(novaCategoria);
            compraExistente.setValorDespesa(novoValor);
            compraExistente.setDescricao(novaDescricao);

            despesas.put(idDespesa, compraExistente);
        } else {
            throw new DespesaNaoExisteException("Compra com o ID " + idDespesa + " não encontrada no sistema.");
        }
    }


    @Override
    public void removerDespesa(Despesa despesa) throws DespesaNaoExisteException {
        //TODO
    }


    @Override
    public Collection<Despesa> pesquisarPorCategoria(CategoriaDespesa categoria) {
        Collection<Despesa> comprasPorCategoria = new ArrayList<>();

        for (Despesa c : this.despesas.values()) {
            if (c.getCategoriaDespesa() == categoria) {
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
        return this.despesas.values().stream().mapToDouble(Despesa::getValorDespesa).sum();
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
