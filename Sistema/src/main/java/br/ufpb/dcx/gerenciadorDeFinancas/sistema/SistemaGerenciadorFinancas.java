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
     * Cadastra uma nova despesa no sistema.
     *
     * @param despesa A despesa a ser cadastrada.
     * @throws DespesaJaCadastradaException Se já existir uma despesa com o mesmo identificador.
     */
    public void cadastrarDespesa(Despesa despesa) throws DespesaJaCadastradaException;
    /**
     * Edita uma compra existente no sistema, atualizando seus dados com os novos valores fornecidos.
     *
     * @param idDespesa O ID da despesa que será editada.
     * @param novaCategoria A nova categoria da despesa.
     * @param novoValor O novo valor da despesa.
     * @param novaDescricao A nova descrição da despesa.
     * @throws DespesaNaoExisteException Se a despesa com o ID fornecido não estiver cadastrada no sistema.
     */
    public void editarDespesa(String idDespesa, CategoriaDespesa novaCategoria, double novoValor, String novaDescricao) throws DespesaNaoExisteException;

    /**
     * Remove uma despesa do sistema com base no objeto de despesa fornecido.
     *
     * @param despesa A despesa a ser removida.
     * @throws DespesaNaoExisteException Se não houver uma despesa com a descrição fornecida.
     */
    public void removerDespesa(Despesa despesa) throws DespesaNaoExisteException;

    /**
     * Pesquisa e retorna uma coleção de despesas filtradas por categoria.
     *
     * @param categoria A categoria de despesas a ser filtrada.
     * @return Uma coleção de despesas que pertencem à categoria especificada.
     */
    public Collection<Despesa> pesquisarPorCategoria(CategoriaDespesa categoria);

    /**
     * Exibe o valor total gasto com as despesas cadastradas.
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
