package br.ufpb.dcx.gerenciadorDeFinancas.controller;

import br.ufpb.dcx.gerenciadorDeFinancas.exceptions.DespesaNaoExisteException;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.CategoriaDespesa;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.Despesa;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.SistemaFinancas;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.SistemaGerenciadorFinancas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DespesaEditController implements ActionListener {

    private SistemaGerenciadorFinancas financas;
    private JFrame janelaPrincipal;
    private DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public DespesaEditController(SistemaGerenciadorFinancas financas, JFrame janela) {
        this.financas = financas;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String id = JOptionPane.showInputDialog(janelaPrincipal, "Digite o ID da Despesa à ser editada: ");
        try {
            Despesa despesaEditar = financas.pesquisarDespesaPeloId(id);
            String opcao = JOptionPane.showInputDialog(janelaPrincipal,"Que dado você deseja editar?\n\nDigite a opção correta: \n1.Nome\n2.Categoria\n3.Valor\n4.Descrição\n5.Data");
            switch (opcao){
                case "1":
                    String nome = JOptionPane.showInputDialog(janelaPrincipal,"Digite o novo nome da despesa");
                    financas.editarDespesa(nome, despesaEditar.getIdDespesa(),despesaEditar.getCategoriaDespesa(), despesaEditar.getValorDespesa(), despesaEditar.getDescricao(),despesaEditar.getData());
                    break;
                case "2":
                    CategoriaDespesa categoria = (CategoriaDespesa) JOptionPane.showInputDialog(janelaPrincipal, "Selecione a nova categoria:", "Categoria", JOptionPane.QUESTION_MESSAGE, null, CategoriaDespesa.values(), CategoriaDespesa.values()[0]);
                    financas.editarDespesa(despesaEditar.getNome(), despesaEditar.getIdDespesa(), categoria, despesaEditar.getValorDespesa(), despesaEditar.getDescricao(), despesaEditar.getData());
                    break;
                case "3":
                    Double novoValor = Double.parseDouble(JOptionPane.showInputDialog(janelaPrincipal,"Digite o novo valor da despesa"));
                    financas.editarDespesa(despesaEditar.getNome(), despesaEditar.getIdDespesa(),despesaEditar.getCategoriaDespesa(), novoValor, despesaEditar.getDescricao(),despesaEditar.getData());
                    break;
                case "4":
                    String descricao = JOptionPane.showInputDialog(janelaPrincipal,"Digite a nova nome descrição");
                    financas.editarDespesa(despesaEditar.getNome(), descricao, despesaEditar.getCategoriaDespesa(), despesaEditar.getValorDespesa() ,descricao, despesaEditar.getData());
                    break;
                case "5":

                    String dataStr = JOptionPane.showInputDialog(janelaPrincipal, "Informe a  nova data da Despesa: Modelo = dd/MM/yyyy");
                    LocalDate novaData = LocalDate.parse(dataStr, dataFormatter);
                    //LocalDate data = LocalDate.parse(dataStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    financas.editarDespesa(despesaEditar.getNome(), despesaEditar.getIdDespesa(), despesaEditar.getCategoriaDespesa(),despesaEditar.getValorDespesa(), despesaEditar.getDescricao(), novaData);
                    break;
            }
            JOptionPane.showMessageDialog(janelaPrincipal, "Despesa editada com sucesso!");
        } catch (DespesaNaoExisteException ex) {
            JOptionPane.showMessageDialog(janelaPrincipal, ex.getMessage());
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(janelaPrincipal, "Data Inválida. Modelo: (yyy-MM-dd)");
        }
    }
}

