package br.ufpb.dcx.gerenciadorDeFinancas.controller;

import br.ufpb.dcx.gerenciadorDeFinancas.exceptions.ReceitaNaoExisteException;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.Receita;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.SistemaGerenciadorFinancas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReceitaEditController implements ActionListener {
    private SistemaGerenciadorFinancas sistema;
    private JFrame janela;
    private Receita receita;

    public ReceitaEditController(SistemaGerenciadorFinancas sistema, JFrame janela) {
        this.sistema = sistema;
        this.janela = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String id = JOptionPane.showInputDialog(janela,"Digite o id a ser encontrado");
        double valorEditado = Double.parseDouble(JOptionPane.showInputDialog(janela, "Digite o novo valor:"));
        try {
            this.receita = sistema.pesquisarReceitaPeloId(id);
            sistema.editarValorReceita(receita.getIdReceita(), valorEditado);
        } catch (ReceitaNaoExisteException ex) {
            JOptionPane.showMessageDialog(janela, ex.getMessage());
        }

    }
}
