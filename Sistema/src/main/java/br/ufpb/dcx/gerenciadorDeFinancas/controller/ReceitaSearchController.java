package br.ufpb.dcx.gerenciadorDeFinancas.controller;

import br.ufpb.dcx.gerenciadorDeFinancas.exceptions.ReceitaNaoExisteException;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.Receita;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.SistemaGerenciadorFinancas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReceitaSearchController implements ActionListener {
    private SistemaGerenciadorFinancas sistema;
    private String id;
    private JFrame janela;

    public ReceitaSearchController(SistemaGerenciadorFinancas sistema,  String id, JFrame janela){
        this.sistema = sistema;
        this.id = id;
        this.janela = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Receita receita = sistema.pesquisarReceitaPeloId(this.id);
            JOptionPane.showMessageDialog(janela,receita);

        }catch(ReceitaNaoExisteException ex){
            JOptionPane.showMessageDialog(janela, ex.getMessage());
        }
    }
}
