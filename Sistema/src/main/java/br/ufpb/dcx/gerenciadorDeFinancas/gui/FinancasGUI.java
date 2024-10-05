package br.ufpb.dcx.gerenciadorDeFinancas.gui;


import br.ufpb.dcx.gerenciadorDeFinancas.controller.*;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.SistemaFinancas;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.SistemaGerenciadorFinancas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class FinancasGUI extends JFrame {
    JLabel linha1, linha2, linha3;
    ImageIcon capaSmartFinance = new ImageIcon("./img/smartfinance.png");
    private  static SistemaGerenciadorFinancas sistema;


    public FinancasGUI() {
        sistema = new SistemaFinancas();
        sistema.recuperarDados();


        setTitle("Sistema Gerenciador de Finanças");
        setSize(800, 600);
        setLocation(400, 100);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setLayout(new BorderLayout());

        linha1 = new JLabel("SMART FINANCE", JLabel.CENTER);
        linha1.setFont(new Font("Agency FB", Font.BOLD, 30));
        getContentPane().add(linha1, BorderLayout.NORTH);

        linha2 = new JLabel(capaSmartFinance, JLabel.CENTER);
        getContentPane().add(linha2, BorderLayout.CENTER);

        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout());

        JButton btnDespesas = new JButton("Gerenciar minhas despesas");
        JButton btnReceita = new JButton("Gerenciar minha receita");
        JButton btnRelatorios = new JButton("Exibir relatórios");

        painelBotoes.add(btnReceita);
        painelBotoes.add(btnDespesas);
        painelBotoes.add(btnRelatorios);

        getContentPane().add(painelBotoes, BorderLayout.SOUTH);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setPreferredSize(new Dimension(1000, 40));


        // Menu "Gerenciar Despesas"
        JMenu menuDespesas = new JMenu("DESPESAS");
        JMenuItem itemAddDespesa = new JMenuItem("Cadastrar Despesa");
        JMenuItem itemEditDespesa = new JMenuItem("Editar Despesa");
        JMenuItem itemRemoveDespesa = new JMenuItem("Remover Despesa");
        JMenuItem itemSearchDespesa = new JMenuItem("Buscar Despesa");
        menuDespesas.add(itemAddDespesa);
        menuDespesas.add(itemEditDespesa);
        menuDespesas.add(itemRemoveDespesa);
        menuDespesas.add(itemSearchDespesa);

        // Menu "Gerenciar Receitas"
        JMenu menuReceitas = new JMenu("RECEITAS");
        JMenuItem itemAddReceita = new JMenuItem("Cadastrar Receita");
        JMenuItem itemEditReceita = new JMenuItem("Editar Receita");
        JMenuItem itemRemoveReceita = new JMenuItem("Remover Receita");
        JMenuItem itemSearchReceita = new JMenuItem("Buscar Receita");
        JMenuItem itemViewReceita = new JMenuItem("Exibir Receita Mensal");
        menuReceitas.add(itemAddReceita);
        menuReceitas.add(itemEditReceita);
        menuReceitas.add(itemRemoveReceita);
        menuReceitas.add(itemSearchReceita);
        menuReceitas.add(itemViewReceita);

        //Menu "Exibir gastos"
        JMenu menuExibirGastos = new JMenu("EXIBIR GASTOS");
        JMenuItem itemExibirTotalGasto = new JMenuItem("Exibir Gasto Mensal");
        JMenuItem itemExibirGastoMensal = new JMenuItem("Exibir Total Gasto");
        JMenuItem itemExibirSaldoMes = new JMenuItem("Exibir Saldo Mensal");
        menuExibirGastos.add(itemExibirGastoMensal);
        menuExibirGastos.add(itemExibirTotalGasto);
        menuExibirGastos.add(itemExibirSaldoMes);

        menuBar.add(menuDespesas);
        menuBar.add(menuReceitas);
        menuBar.add(menuExibirGastos);


        setJMenuBar(menuBar);


        JPanel painelCentral = new JPanel();
        painelCentral.setBackground(Color.LIGHT_GRAY);
        getContentPane().add(painelCentral, BorderLayout.CENTER);

        itemAddDespesa.addActionListener(new DespesaAddController(sistema,this));
        itemRemoveDespesa.addActionListener(new DespesaRemoveController(sistema));
        //itemSearchDespesa.addActionListener(new DespesaSearchController(sistema));

        /*itemAddReceita.addActionListener(new ReceitaAddController(sistema));
        itemRemoveReceita.addActionListener(new ReceitaRemoveController(sistema));
        itemSearchReceita.addActionListener(new ReceitaSearchController(sistema));*/
    }

    public static void main(String[] args) {
        JFrame janela = new FinancasGUI();
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
