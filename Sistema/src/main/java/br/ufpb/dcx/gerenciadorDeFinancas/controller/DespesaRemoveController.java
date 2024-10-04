package br.ufpb.dcx.gerenciadorDeFinancas.controller;

import br.ufpb.dcx.gerenciadorDeFinancas.sistema.*;
import br.ufpb.dcx.gerenciadorDeFinancas.exceptions.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DespesaRemoveController implements ActionListener {
    private SistemaGerenciadorFinancas sistema;

    public DespesaRemoveController(SistemaGerenciadorFinancas sistema) {
        this.sistema = sistema;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String id = JOptionPane.showInputDialog(null, "Informe o ID para remover:");

        try {
            sistema.removerDespesa(new Despesa(id, null, 0.0, null, null));
            JOptionPane.showMessageDialog(null, "Despesa removida com sucesso!");
        } catch (DespesaNaoExisteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }


}
