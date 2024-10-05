package br.ufpb.dcx.gerenciadorDeFinancas.controller;

import br.ufpb.dcx.gerenciadorDeFinancas.sistema.CategoriaDespesa;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.Despesa;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.SistemaFinancas;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.SistemaGerenciadorFinancas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class DespesaSearchController implements ActionListener {

    private SistemaGerenciadorFinancas financas;
    private JFrame janelaPrincipal;

    public DespesaSearchController(SistemaGerenciadorFinancas financas, JFrame janela){
        this.financas = financas;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CategoriaDespesa categoria = (CategoriaDespesa) JOptionPane.showInputDialog(janelaPrincipal,"Selecione a categoria","Categoria", JOptionPane.QUESTION_MESSAGE, null, CategoriaDespesa.values(), CategoriaDespesa.values()[0]);
        Collection<Despesa> despesasEncontradas = financas.pesquisarPorCategoria(categoria);

        if (despesasEncontradas.isEmpty()){
            JOptionPane.showMessageDialog(janelaPrincipal, "Nenhuma despesa foi encontrada para a categoria: " + categoria);
        }else {
            JOptionPane.showMessageDialog(janelaPrincipal,"Despesa(s) encontrada(s) com sucesso!");
        }


    }
}
