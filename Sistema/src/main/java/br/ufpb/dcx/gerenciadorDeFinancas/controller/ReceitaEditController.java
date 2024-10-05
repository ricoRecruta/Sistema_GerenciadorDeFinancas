package br.ufpb.dcx.gerenciadorDeFinancas.controller;

import br.ufpb.dcx.gerenciadorDeFinancas.exceptions.ReceitaNaoExistenteException;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.Receita;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.SistemaGerenciadorFinancas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReceitaEditController implements ActionListener {
    private SistemaGerenciadorFinancas sistema;
    private Receita receita;
    public ReceitaEditController(SistemaGerenciadorFinancas sistema, Receita receita){
        this.sistema = sistema;
        this.receita = receita;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Double valorAMudar = Double.parseDouble(JOptionPane.showInputDialog(null,"Digite o valor que deseja colocar"));
        try {
            sistema.editarValorReceita(receita.getIdReceita(), valorAMudar);
        }catch(ReceitaNaoExistenteException ex){
            System.err.println(ex.getMessage());
        }

    }
}
