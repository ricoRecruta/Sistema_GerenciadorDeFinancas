package br.ufpb.dcx.gerenciadorDeFinancas.gui;

import br.ufpb.dcx.gerenciadorDeFinancas.controller.*;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.SistemaFinancas;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.SistemaGerenciadorFinancas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.time.LocalDate;

public class ExibeRelatorioGUI extends JFrame {
    JLabel linha1, linha2;
    private  static SistemaGerenciadorFinancas sistema;

    public ExibeRelatorioGUI(){
        sistema = new SistemaFinancas();
        sistema.recuperarDados();

        setTitle("Sistema Gerenciador de Finanças");
        setSize(800, 600);
        setLocation(400, 100);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new FlowLayout());

        linha1 = new JLabel("RELATÓRIOS FINANCEIROS", JLabel.CENTER);
        linha1.setFont(new Font("Agency FB", Font.BOLD, 30));
        getContentPane().add(linha1, BorderLayout.NORTH);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setPreferredSize(new Dimension(1000, 40));
        JMenu menuExibirGastos = new JMenu("MENU");

        JMenuItem itemPaginaInicial = new JMenuItem("Página Inicial");
        JMenuItem itemDespesas = new JMenuItem("Gerência de Despesas");
        JMenuItem itemReceitas = new JMenuItem("Gerência de Receitas");

        menuExibirGastos.add(itemPaginaInicial);
        menuExibirGastos.add(itemDespesas);
        menuExibirGastos.add(itemReceitas);

        menuBar.add(menuExibirGastos);
        setJMenuBar(menuBar);

        itemPaginaInicial.addActionListener(new PaginaInicialController(this));

        // Botão 1: Exibir total de gastos
        JButton botaoTotalGastos = new JButton("Exibir total de Gastos");
        botaoTotalGastos.addActionListener(e -> {
            LocalDate dataAtual = LocalDate.now();
            double totalGastos = sistema.exibirTotalGastoDoMes(dataAtual);
            JOptionPane.showMessageDialog(null, "Total de gastos no mês: " + totalGastos);
        });

        // Botão 2: Exibir gasto mensal
        JButton botaoGastoMensal = new JButton("Exibir gasto mensal");
        botaoGastoMensal.addActionListener(e -> {
            LocalDate dataAtual = LocalDate.now();
            String saldoMensal = sistema.verificarSaldoDoMes(dataAtual, dataAtual.getMonthValue());
            JOptionPane.showMessageDialog(null, saldoMensal);
        });

        // Botão 3: Exibir receita
        JButton botaoReceita = new JButton("Exibir receita");
        botaoReceita.addActionListener(e -> {
            LocalDate dataAtual = LocalDate.now();
            double receitaTotal = sistema.exibirReceitaTotalDoMes(dataAtual);
            JOptionPane.showMessageDialog(null, "Receita total do mês: " + receitaTotal);
        });

        // Adicionando botões à interface
        getContentPane().add(botaoTotalGastos);
        getContentPane().add(botaoGastoMensal);
        getContentPane().add(botaoReceita);
    }
    public static void main(String[] args) {
        JFrame janela = new ExibeRelatorioGUI();
        janela.setVisible(true);
        WindowListener fechadorDeJanelaPrincipal = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                sistema.salvarDados();
                System.exit(0);
            }
        };
        janela.addWindowListener(fechadorDeJanelaPrincipal);
    }
}
