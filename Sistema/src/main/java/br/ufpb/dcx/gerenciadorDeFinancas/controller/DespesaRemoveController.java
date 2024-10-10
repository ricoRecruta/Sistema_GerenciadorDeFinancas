package br.ufpb.dcx.gerenciadorDeFinancas.controller;

import br.ufpb.dcx.gerenciadorDeFinancas.sistema.*;
import br.ufpb.dcx.gerenciadorDeFinancas.exceptions.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DespesaRemoveController implements ActionListener {
    private SistemaGerenciadorFinancas sistema;
    private JFrame janelaPrincipal;

    public DespesaRemoveController(SistemaGerenciadorFinancas sistema, JFrame janela) {
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String id = JOptionPane.showInputDialog(janelaPrincipal, "Informe o ID para remover:");
        try {
            Despesa remocao = sistema.pesquisarDespesaPeloId(id);
            sistema.removerDespesa(remocao);
            JOptionPane.showMessageDialog(janelaPrincipal, "Despesa removida com sucesso!");
        } catch (DespesaNaoExisteException ex) {
            JOptionPane.showMessageDialog(janelaPrincipal, ex.getMessage());
        }catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(janelaPrincipal, "Data Inválida. Modelo: (yyy-MM-dd)");
        }
    }
}
