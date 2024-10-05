package br.ufpb.dcx.gerenciadorDeFinancas.controller;

import br.ufpb.dcx.gerenciadorDeFinancas.exceptions.DespesaNaoExisteException;
import br.ufpb.dcx.gerenciadorDeFinancas.exceptions.ReceitaNaoExisteException;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.CategoriaDespesa;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.Despesa;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.Receita;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.SistemaGerenciadorFinancas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReceitaRemoveController implements ActionListener {
    private SistemaGerenciadorFinancas sistema;
    private JFrame janela;

    public ReceitaRemoveController(SistemaGerenciadorFinancas sistema, JFrame janela){
        this.sistema = sistema;
        this.janela = janela;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String id = JOptionPane.showInputDialog(janela, "Informe o ID para remover:");
            String valorStr = JOptionPane.showInputDialog(janela, "Digite o valor da receita à remover: ");
            double valor = Double.parseDouble(valorStr);
            String dataStr = JOptionPane.showInputDialog(janela, "Informe a data da receita para remover: Modelo = yyyy-MM-dd ");
            LocalDate data = LocalDate.parse(dataStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            sistema.removerReceita(new Receita(id, valor, data));
            JOptionPane.showMessageDialog(janela, "Receita removida com sucesso!");
        } catch (ReceitaNaoExisteException ex) {
            JOptionPane.showMessageDialog(janela, ex.getMessage());
        }catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(janela, "Data Inválida. Modelo: (yyy-MM-dd)");
        }
    }
}
