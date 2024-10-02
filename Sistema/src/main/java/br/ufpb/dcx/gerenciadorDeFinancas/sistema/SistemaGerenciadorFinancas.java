package br.ufpb.dcx.gerenciadorDeFinancas.sistema;

import java.util.Collection;
public interface SistemaGerenciadorFinancas {
public void cadastrarSalario(double salario);
public Collection<Compra> pesquisarPorCategoria(categoriaCompra categoria);
public void cadastrarCompra(String descricao, double valor);
public void editarSalario(double novoSalario);
public double exibirTotalGasto();
public void removerCompra(String descricao);
public void editarCompra(String descricao,categoriaCompra novaCategoria, double novoValor);
public Collection<Compra> comparacaoDeGastos(double gasto1, double gasto2);
}
