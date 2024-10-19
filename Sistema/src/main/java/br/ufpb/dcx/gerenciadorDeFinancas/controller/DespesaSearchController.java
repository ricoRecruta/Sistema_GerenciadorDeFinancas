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
    //TODO: modificar o DespesaSearchController para que o usuário passe o id da Despesa e ele retorne a Despesa desejada
    public DespesaSearchController(SistemaGerenciadorFinancas financas, JFrame janela){
        this.financas = financas;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CategoriaDespesa categoria = (CategoriaDespesa) JOptionPane.showInputDialog(janelaPrincipal,"Selecione a categoria","Categoria", JOptionPane.QUESTION_MESSAGE, null, CategoriaDespesa.values(), CategoriaDespesa.values()[0]);
        Collection<Despesa> despesasEncontradas = financas.pesquisarPorCategoria(categoria);
        StringBuilder despesaFinal = new StringBuilder();
        if (despesasEncontradas.isEmpty()){
            JOptionPane.showMessageDialog(janelaPrincipal, "Nenhuma despesa foi encontrada para a categoria: " + categoria);
        }else {
            for(Despesa de: despesasEncontradas){
                despesaFinal.append(de.toString()+"\n");
            }
            JOptionPane.showMessageDialog(janelaPrincipal,"Despesa(s) encontrada(s) com sucesso!");
            JOptionPane.showMessageDialog(janelaPrincipal, despesaFinal.toString());


        }


    }
}
