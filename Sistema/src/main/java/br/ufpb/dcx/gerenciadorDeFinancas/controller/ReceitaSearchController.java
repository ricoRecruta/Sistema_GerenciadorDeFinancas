package br.ufpb.dcx.gerenciadorDeFinancas.controller;

import br.ufpb.dcx.gerenciadorDeFinancas.exceptions.ReceitaNaoExistenteException;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.Receita;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.SistemaGerenciadorFinancas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReceitaSearchController implements ActionListener {
    private SistemaGerenciadorFinancas sistema;
    private String id;
    public ReceitaSearchController(SistemaGerenciadorFinancas sistema,  String id){
        this.sistema = sistema;
        this.id = id;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Receita receita = sistema.pesquisarReceitaPeloId(this.id);
            //TODO: passar a janela ainda.
            JOptionPane.showMessageDialog(null,receita);

        }catch(ReceitaNaoExistenteException ex){
            System.err.println(ex.getMessage());
        }
    }
}
