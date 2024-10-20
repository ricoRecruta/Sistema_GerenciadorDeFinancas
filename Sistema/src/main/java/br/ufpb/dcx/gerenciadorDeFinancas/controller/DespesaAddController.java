package br.ufpb.dcx.gerenciadorDeFinancas.controller;

import br.ufpb.dcx.gerenciadorDeFinancas.exceptions.DespesaJaCadastradaException;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.CategoriaDespesa;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.Despesa;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.SistemaFinancas;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.SistemaGerenciadorFinancas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DespesaAddController implements ActionListener {

    private SistemaGerenciadorFinancas financas;
    private JFrame janelaPrincipal;
    private DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public DespesaAddController(SistemaGerenciadorFinancas financas, JFrame janela){
        this.financas = financas;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nome = JOptionPane.showInputDialog(janelaPrincipal,"Digite o novo nome da despesa");

        String id = JOptionPane.showInputDialog(janelaPrincipal, "Digite o ID da Despesa: " );
        CategoriaDespesa categoria = (CategoriaDespesa) JOptionPane.showInputDialog(janelaPrincipal,"Selecione a categoria:","Categoria", JOptionPane.QUESTION_MESSAGE, null, CategoriaDespesa.values(), CategoriaDespesa.values()[0]);
        String valorStr = JOptionPane.showInputDialog(janelaPrincipal,"Digite o valor da despesa: ");
        Double valor = Double.parseDouble(valorStr);
        String descricao = JOptionPane.showInputDialog(janelaPrincipal, "Digite a Descrição da Despesa:");
        String dataStr = JOptionPane.showInputDialog(janelaPrincipal, "Informe a data da Despesa: Modelo = dd/MM/yyyy ");
        LocalDate data = LocalDate.parse(dataStr, dataFormatter);
        Despesa novaDespesa = new Despesa(nome,id, categoria, valor, descricao, data);
        try {
            financas.cadastrarDespesa(novaDespesa);
            JOptionPane.showMessageDialog(janelaPrincipal, "Despesa cadastrada com Sucesso!");

            System.out.println(novaDespesa);

        }catch (DespesaJaCadastradaException ex){
            JOptionPane.showMessageDialog(janelaPrincipal,ex.getMessage());
        }catch (IllegalArgumentException ex){
            JOptionPane.showMessageDialog(janelaPrincipal, "Data Inválida. Modelo: (yyyy-MM-dd)");
        }


    }
}
