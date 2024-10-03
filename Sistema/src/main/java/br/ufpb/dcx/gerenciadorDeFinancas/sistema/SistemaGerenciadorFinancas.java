package br.ufpb.dcx.gerenciadorDeFinancas.sistema;

import br.ufpb.dcx.gerenciadorDeFinancas.exceptions.*;

import java.util.Collection;

public interface SistemaGerenciadorFinancas {

    /**
     * Cadastra o salário do usuário.
     *
     * @param salario O valor do salário a ser cadastrado.
     */
    public void cadastrarSalario(double salario);

    /**
     * Edita o valor do salário do usuário.
     *
     * @param novoSalario O novo valor do salário a ser atualizado.
     */
    public void editarSalario(double novoSalario);

    /**
     * Cadastra uma nova compra no sistema.
     *
     * @param compra A compra a ser cadastrada.
     * @throws CompraJaCadastradaException Se já existir uma compra com o mesmo identificador.
     */
    public void cadastrarCompra(Despesa compra) throws CompraJaCadastradaException;
    /**
     * Edita uma compra existente no sistema, atualizando seus dados com os novos valores fornecidos.
     *
     * @param idCompra O ID da compra que será editada.
     * @param novaCategoria A nova categoria da compra.
     * @param novoValor O novo valor da compra.
     * @param novaDescricao A nova descrição da compra.
     * @throws CompraNaoExisteException Se a compra com o ID fornecido não estiver cadastrada no sistema.
     */
    public void editarCompra(String idCompra, CategoriaCompra novaCategoria, double novoValor, String novaDescricao) throws CompraNaoExisteException;

    /**
     * Remove uma compra do sistema com base no objeto de compra fornecido.
     *
     * @param compra A compra a ser removida.
     * @throws CompraNaoExisteException Se não houver uma compra com a descrição fornecida.
     */
    public void removerCompra(Despesa compra) throws CompraNaoExisteException;

    /**
     * Pesquisa e retorna uma coleção de compras filtradas por categoria.
     *
     * @param categoria A categoria de compra a ser filtrada.
     * @return Uma coleção de compras que pertencem à categoria especificada.
     */
    public Collection<Despesa> pesquisarPorCategoria(CategoriaCompra categoria);

    /**
     * Exibe o valor total gasto com as compras cadastradas.
     *
     * @return O valor total gasto.
     */
    public double exibirTotalGasto();

    /**
     * Compara os gastos de duas compras e retorna uma coleção de compras entre esses valores.
     *
     * @param gasto1 O primeiro valor de gasto para comparação.
     * @param gasto2 O segundo valor de gasto para comparação.
     * @return Uma coleção de compras cujos valores estão entre os gastos especificados.
     */
    public Collection<Despesa> comparacaoDeGastos(double gasto1, double gasto2);

}
