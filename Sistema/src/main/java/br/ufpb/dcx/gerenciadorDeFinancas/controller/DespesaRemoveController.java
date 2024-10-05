package br.ufpb.dcx.gerenciadorDeFinancas.controller;

import br.ufpb.dcx.gerenciadorDeFinancas.sistema.*;
import br.ufpb.dcx.gerenciadorDeFinancas.exceptions.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DespesaRemoveController implements ActionListener {
    private SistemaGerenciadorFinancas financas;
    private JFrame janelaPrincipal;

    public DespesaRemoveController(SistemaGerenciadorFinancas financas, JFrame janela) {
        this.financas = financas;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String id = JOptionPane.showInputDialog(janelaPrincipal, "Informe o ID para remover:");
            CategoriaDespesa categoria = (CategoriaDespesa) JOptionPane.showInputDialog(janelaPrincipal, "Selecione a categoria para remover:", "Categoria", JOptionPane.QUESTION_MESSAGE, null, CategoriaDespesa.values(), CategoriaDespesa.values()[0]);
            String valorStr = JOptionPane.showInputDialog(janelaPrincipal, "Digite o valor da despesa à remover: ");
            Double valor = Double.parseDouble(valorStr);
            String descricao = JOptionPane.showInputDialog(janelaPrincipal, "Digite a Descrição da Despesa para remover:");
            String dataStr = JOptionPane.showInputDialog(janelaPrincipal, "Informe a data da Despesa para remover: Modelo = yyyy-MM-dd ");
            LocalDate data = LocalDate.parse(dataStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            financas.removerDespesa(new Despesa(id, categoria, valor, descricao, data));
            JOptionPane.showMessageDialog(janelaPrincipal, "Despesa removida com sucesso!");
        } catch (DespesaNaoExisteException ex) {
            JOptionPane.showMessageDialog(janelaPrincipal, ex.getMessage());
        }catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(janelaPrincipal, "Data Inválida. Modelo: (yyy-MM-dd)");
        }
    }
}
