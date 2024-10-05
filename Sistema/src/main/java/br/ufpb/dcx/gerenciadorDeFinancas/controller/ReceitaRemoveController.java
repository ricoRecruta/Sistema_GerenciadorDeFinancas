package br.ufpb.dcx.gerenciadorDeFinancas.controller;

import br.ufpb.dcx.gerenciadorDeFinancas.exceptions.ReceitaNaoExisteException;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.SistemaGerenciadorFinancas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReceitaRemoveController implements ActionListener {
    private SistemaGerenciadorFinancas sistema;
    private JFrame janela;

    public ReceitaRemoveController(SistemaGerenciadorFinancas sistema, JFrame janela){
        this.sistema = sistema;
        this.janela = janela;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
