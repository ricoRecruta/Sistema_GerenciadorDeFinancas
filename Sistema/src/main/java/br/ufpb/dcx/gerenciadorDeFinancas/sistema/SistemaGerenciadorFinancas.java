package br.ufpb.dcx.gerenciadorDeFinancas.sistema;

import br.ufpb.dcx.gerenciadorDeFinancas.exceptions.*;

import java.util.Collection;

public interface SistemaGerenciadorFinancas {
    public void cadastrarSalario(double salario);
    public void editarSalario(double novoSalario);

    public void cadastrarCompra(Compra compra) throws CompraJaCadastradaException;
    public void editarCompra(Chave idCompra, categoriaCompra novaCategoria, double novoValor, String novaDescricao) throws CompraNaoExisteException;
    public void removerCompra(Compra compra) throws CompraNaoExisteException;
    public Collection<Compra> pesquisarPorCategoria(categoriaCompra categoria);

    public double exibirTotalGasto();
    public Collection<Compra> comparacaoDeGastos(double gasto1, double gasto2);
}
