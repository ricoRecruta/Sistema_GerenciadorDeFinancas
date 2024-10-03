package br.ufpb.dcx.gerenciadorDeFinancas.sistema;

import br.ufpb.dcx.gerenciadorDeFinancas.exceptions.*;

import java.util.Collection;

public interface SistemaGerenciadorFinancas {
    public void cadastrarSalario(double salario);
    public void editarSalario(double novoSalario);

    public void cadastrarCompra(Despesas compra) throws CompraJaCadastradaException;
    public void editarCompra(Chave idCompra, CategoriaCompra novaCategoria, double novoValor, String novaDescricao) throws CompraNaoExisteException;
    public void removerCompra(Despesas compra) throws CompraNaoExisteException;
    public Collection<Despesas> pesquisarPorCategoria(CategoriaCompra categoria);

    public double exibirTotalGasto();
    public Collection<Despesas> comparacaoDeGastos(double gasto1, double gasto2);
}
