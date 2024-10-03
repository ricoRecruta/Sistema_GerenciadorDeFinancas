package br.ufpb.dcx.gerenciadorDeFinancas.sistema;

import br.ufpb.dcx.gerenciadorDeFinancas.login.Conta;
import br.ufpb.dcx.gerenciadorDeFinancas.exceptions.*;
import java.util.*;

/**
 * Classe que implementa a interface SistemaGerenciadorDeFinancas.
 * Permite cadastrar compras, salários, pesquisar compras por categoria,
 * editar e remover compras e exibir o total de gastos.
 */
public class SistemaFinancas implements SistemaGerenciadorFinancas {
    /** Mapa que armazena as compras, onde a chave é um identificador único da compra. */
    private Map<Chave, Compra> compras;

    /** Conta do usuário, que contém as informações financeiras como salário e pessoais do usuário. */
    private Conta conta;

    /**
     * Construtor da classe SistemaFinancas.
     *
     * @param conta A conta financeira do usuário.
     */
    public SistemaFinancas(Conta conta) {
        this.compras = new HashMap<>();
        this.conta = conta;

    }

    /**
     * Cadastra o salário do usuário.
     *
     * @param salario O valor do salário a ser cadastrado.
     */
    @Override
    public void cadastrarSalario(double salario) {
        conta.setSalario(salario);
    }

    /**
     * Edita o valor do salário do usuário.
     *
     * @param novoSalario O novo valor do salário a ser atualizado.
     */
    @Override
    public void editarSalario(double novoSalario) {
        this.conta.setSalario(novoSalario);
    }

    /**
     * Cadastra uma nova compra no sistema.
     *
     * @param compra A compra a ser cadastrada.
     * @throws CompraJaCadastradaException Se já existir uma compra com o mesmo identificador.
     */
    @Override
    public void cadastrarCompra(Compra compra) throws CompraJaCadastradaException {
        if (compras.containsKey(compra.getIdCompra())) {
            throw new CompraJaCadastradaException("Compra com o ID " + compra.getIdCompra() + "já cadastrada no sistema!");
        }
        this.compras.put(compra.getIdCompra(), compra);
    }

    /**
     * Edita uma compra existente no sistema, atualizando seus dados com os novos valores fornecidos.
     *
     * @param idCompra O ID da compra que será editada.
     * @param novaCategoria A nova categoria da compra.
     * @param novoValor O novo valor da compra.
     * @param novaDescricao A nova descrição da compra.
     * @throws CompraNaoExisteException Se a compra com o ID fornecido não estiver cadastrada no sistema.
     */
    @Override
    public void editarCompra(Chave idCompra, categoriaCompra novaCategoria, double novoValor, String novaDescricao) throws CompraNaoExisteException {
        if (compras.containsKey(idCompra)) {
            Compra compraExistente = compras.get(idCompra);
            compraExistente.setCategoriaCompra(novaCategoria);
            compraExistente.setValorCompra(novoValor);
            compraExistente.setDescricao(novaDescricao);

            compras.put(idCompra, compraExistente);
        } else {
            throw new CompraNaoExisteException("Compra com o ID " + idCompra + " não encontrada no sistema.");
        }
    }

    /**
     * Remove uma compra do sistema com base no objeto de compra fornecido.
     *
     * @param compra A compra a ser removida.
     * @throws CompraNaoExisteException Se não houver uma compra com a descrição fornecida.
     */
    @Override
    public void removerCompra(Compra compra) throws CompraNaoExisteException {
        //TODO
    }

    /**
     * Pesquisa e retorna uma coleção de compras filtradas por categoria.
     *
     * @param categoria A categoria de compra a ser filtrada.
     * @return Uma coleção de compras que pertencem à categoria especificada.
     */
    @Override
    public Collection<Compra> pesquisarPorCategoria(categoriaCompra categoria) {
        Collection<Compra> comprasPorCategoria = new ArrayList<>();

        for (Compra c : this.compras.values()) {
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

    /**
     * Exibe o valor total gasto com as compras cadastradas.
     *
     * @return O valor total gasto.
     */
    public double exibirTotalGasto() {
        return this.compras.values().stream().mapToDouble(Compra::getValorCompra).sum();
    }

    /**
     * Compara os gastos de duas compras e retorna uma coleção de compras entre esses valores.
     *
     * @param gasto1 O primeiro valor de gasto para comparação.
     * @param gasto2 O segundo valor de gasto para comparação.
     * @return Uma coleção de compras cujos valores estão entre os gastos especificados.
     */
    @Override
    public Collection<Compra> comparacaoDeGastos(double gasto1, double gasto2) {
        return null;
        //TODO;
    }
}
