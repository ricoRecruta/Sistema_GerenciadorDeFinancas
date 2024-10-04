package br.ufpb.dcx.gerenciadorDeFinancas.controller;

import br.ufpb.dcx.gerenciadorDeFinancas.exceptions.DespesaJaCadastradaException;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.CategoriaDespesa;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.Despesa;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.SistemaFinancas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DespesaAddController implements ActionListener {

    private SistemaFinancas financas;
    private JFrame janelaPrincipal;

    public DespesaAddController(SistemaFinancas financas, JFrame janela){
        this.financas = financas;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String id = JOptionPane.showInputDialog(janelaPrincipal, "Digite o ID da Despesa: " );
            CategoriaDespesa categoria = (CategoriaDespesa) JOptionPane.showInputDialog(janelaPrincipal,"Selecione a categoria:","Categoria", JOptionPane.QUESTION_MESSAGE, null, CategoriaDespesa.values(), CategoriaDespesa.values()[0]);
            String valorStr = JOptionPane.showInputDialog(janelaPrincipal,"Digite o valor da despesa: ");
            Double valor = Double.parseDouble(valorStr);
            String descricao = JOptionPane.showInputDialog(janelaPrincipal, "Digite a Descrição da Despesa:");
            String dataStr = JOptionPane.showInputDialog(janelaPrincipal, "Informe a data da Despesa: Modelo = yyy-MM-dd ");
            LocalDate data = LocalDate.parse(dataStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            Despesa novaDespesa = new Despesa(id, categoria, valor, descricao, data);

            financas.cadastrarDespesa(novaDespesa);
            JOptionPane.showMessageDialog(janelaPrincipal, "Despesa cadastrada com Sucesso!");

        }catch (DespesaJaCadastradaException ex){
            JOptionPane.showMessageDialog(janelaPrincipal,ex.getMessage());
        }catch (IllegalArgumentException ex){
            JOptionPane.showMessageDialog(janelaPrincipal, "Data Inválida. Modelo: (yyyy-MM-dd)");
        }


    }
}
