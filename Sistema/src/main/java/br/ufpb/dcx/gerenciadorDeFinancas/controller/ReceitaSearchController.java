package br.ufpb.dcx.gerenciadorDeFinancas.controller;

import br.ufpb.dcx.gerenciadorDeFinancas.exceptions.ReceitaNaoExisteException;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.Receita;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.SistemaGerenciadorFinancas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReceitaSearchController implements ActionListener {
    private SistemaGerenciadorFinancas sistema;
    private JFrame janela;

    public ReceitaSearchController(SistemaGerenciadorFinancas sistema, JFrame janela){
        this.sistema = sistema;
        this.janela = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String id = JOptionPane.showInputDialog(janela,"Digite o id:");
            Receita receita = sistema.pesquisarReceitaPeloId(id);
            JOptionPane.showMessageDialog(janela,receita);
        }catch(ReceitaNaoExisteException ex){
            JOptionPane.showMessageDialog(janela, ex.getMessage());
        }
    }
}
