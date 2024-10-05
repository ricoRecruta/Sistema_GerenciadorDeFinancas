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

    public DespesaEditController(SistemaGerenciadorFinancas financas, JFrame janela) {
        this.financas = financas;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String id = JOptionPane.showInputDialog(janelaPrincipal, "Digite o ID da Despesa à ser editada: ");
            CategoriaDespesa categoria = (CategoriaDespesa) JOptionPane.showInputDialog(janelaPrincipal, "Selecione a nova categoria:", "Categoria", JOptionPane.QUESTION_MESSAGE, null, CategoriaDespesa.values(), CategoriaDespesa.values()[0]);
            String valorStr = JOptionPane.showInputDialog(janelaPrincipal, "Digite o novo valor da despesa: ");
            Double novoValor = Double.parseDouble(valorStr);
            String descricao = JOptionPane.showInputDialog(janelaPrincipal, "Digite a nova Descrição da Despesa:");
            String dataStr = JOptionPane.showInputDialog(janelaPrincipal, "Informe a  nova data da Despesa: Modelo = yyyy-MM-dd ");
            LocalDate data = LocalDate.parse(dataStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            financas.editarDespesa(id, categoria, novoValor, descricao, data);
            JOptionPane.showMessageDialog(janelaPrincipal, "Despesa editada com sucesso!");
        } catch (DespesaNaoExisteException ex) {
            JOptionPane.showMessageDialog(janelaPrincipal, ex.getMessage());
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(janelaPrincipal, "Data Inválida. Modelo: (yyy-MM-dd)");
        }
    }
}

