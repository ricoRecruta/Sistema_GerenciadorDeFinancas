package br.ufpb.dcx.gerenciadorDeFinancas.sistema;


import br.ufpb.dcx.gerenciadorDeFinancas.exceptions.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;


public class SistemaFinancas implements SistemaGerenciadorFinancas {

    private Map<String, Despesa> despesas;
    private Map<String, Receita> receitas;
    private GravadorDeDados gravador = new GravadorDeDados();

    public SistemaFinancas() {
        this.despesas = new HashMap<>();
        this.receitas = new HashMap<>();
    }


    //MÉTODOS DE RECEITAS
    @Override
    public void cadastrarReceita(Receita receita) {
        this.receitas.put(receita.getIdReceita(), receita);
    }

    @Override
    public void editarValorReceita(String idReceita, double novaReceita) throws ReceitaNaoExisteException {
        if (this.receitas.containsKey(idReceita)) {
            Receita receita = this.receitas.get(idReceita);
            receita.setValor(novaReceita);
        } else {
            throw new ReceitaNaoExisteException("Receita com ID: " + idReceita + " não existente!");
        }
    }

    public void removerReceita(Receita receita) throws ReceitaNaoExisteException{
        if(this.receitas.containsValue(receita)){
            this.receitas.remove(receita);
        } else {
            throw new ReceitaNaoExisteException("Essa receita não existe ou não está cadastrada no sistema");
        }
    }

    public Receita pesquisarReceitaPeloId(String id) throws ReceitaNaoExisteException {
        if (!this.receitas.containsKey(id)) {
            throw new ReceitaNaoExisteException("Não existe receita com o id passado");
        } else {
            return this.receitas.get(id);
        }
    }


    //MÉTODOS DE DESPESAS
    @Override
    public void cadastrarDespesa(Despesa despesa) throws DespesaJaCadastradaException {
        for (Despesa a : this.despesas.values()) {
            if (a.equals(despesa)) {
                throw new DespesaJaCadastradaException("Compra com o ID " + despesa.getIdDespesa() + ", e Data " + despesa.getData() + " já cadastrada no sistema!");
            }
        }
        this.despesas.put(despesa.getIdDespesa(), despesa);
    }

    @Override
    public void editarDespesa(String idDespesa, CategoriaDespesa novaCategoria, double novoValor, String novaDescricao, LocalDate data) throws DespesaNaoExisteException {
        if (despesas.containsKey(idDespesa)) {
            Despesa compraExistente = despesas.get(idDespesa);
            compraExistente.setCategoriaDespesa(novaCategoria);
            compraExistente.setValorDespesa(novoValor);
            compraExistente.setDescricao(novaDescricao);
            compraExistente.setData(data);
            despesas.put(idDespesa, compraExistente);
        } else {
            throw new DespesaNaoExisteException("Compra com o ID " + idDespesa + " não encontrada no sistema.");
        }
    }

    @Override
    public void removerDespesa(Despesa despesa) throws DespesaNaoExisteException {
        String id = despesa.getIdDespesa();

        if (!despesas.containsKey(id)) {
            throw new DespesaNaoExisteException("A despesa com id: " + id + " não existe");
        }
        despesas.remove(id);

    }

    @Override
    public Collection<Despesa> pesquisarPorCategoria(CategoriaDespesa categoria) {
        Collection<Despesa> despesaPorCategoria = new ArrayList<>();

        for (Despesa c : this.despesas.values()) {
            if (c.getCategoriaDespesa() == categoria) {
                despesaPorCategoria.add(c);
            }
        }
        return despesaPorCategoria;
    }

    public Map<String, Despesa> getDespesas() {
        return despesas;
    }

    public Map<String, Receita> getReceitas() {
        return this.receitas;
    }


    //MÉTODOS DE EXIBIÇÃO
    /*@Override
    public double exibirTotalGasto() {
        double valorTotal = 0;
        for (Compra k: this.compras.values()){
            valorTotal = k.getValorCompra() + valorTotal;
        }
        return valorTotal;
    }*/

    @Override
    public double exibirTotalGasto() {
        return this.despesas.values().stream().mapToDouble(Despesa::getValorDespesa).sum();
    }

    @Override
    public double exibirReceitaTotalDoMes(LocalDate data) {
        return this.receitas.values().stream().filter(receitas -> receitas.getData().getMonth().equals(data.getMonth())).mapToDouble(Receita::getValor).sum();
    }

    @Override
    public double exibirTotalGastoDoMes(LocalDate data) {
        return this.despesas.values().stream().filter(despesas -> despesas.getData().getMonth().equals(data.getMonth())).mapToDouble(Despesa::getValorDespesa).sum();
    }

    @Override
    public String verificarSaldoDoMes(LocalDate data, int mes) { //Para ver se a pessoa ficou no débito
        double totalReceitas = exibirReceitaTotalDoMes(data.withMonth(mes));

        double totalDespesas = exibirTotalGastoDoMes(data.withMonth(mes));

        double saldo = totalReceitas - totalDespesas;

        if (saldo < 0) {
            return "Atenção! Seu saldo do mês " + mes + " foi negativo.\nSaldo = " + saldo;
        }
        return "Parabéns! Seu saldo do mês " + mes + " foi positivo.\n" + "Saldo = " + saldo;
    }


    //Métodos de recuperação e gravação de dados
    @Override
    public void salvarDados() {
        try {
            gravador.gravarDespesas(this.despesas);
            gravador.gravarReceitas(this.receitas);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void recuperarDados() {
        try {
            this.despesas = gravador.recuperarDadosDasDespesas();
            this.receitas = gravador.recuperarDadosDasReceitas();
        } catch (IOException e) {
            this.despesas = new HashMap<>();
            this.receitas = new HashMap<>();
            System.err.println(e.getMessage());
        }
    }

}
