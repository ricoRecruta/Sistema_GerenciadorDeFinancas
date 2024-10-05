package br.ufpb.dcx.gerenciadorDeFinancas.controller;

import br.ufpb.dcx.gerenciadorDeFinancas.gui.FinancasGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaginaInicialController implements ActionListener {
    private JFrame frameAtual;

    public PaginaInicialController(JFrame frameAtual) {
        this.frameAtual = frameAtual;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // Fecha a janela atual
        frameAtual.dispose();

        // Abre a nova janela da classe FinancasGUI
        JFrame financasGUI = new FinancasGUI();
        financasGUI.setVisible(true);
    }
}
