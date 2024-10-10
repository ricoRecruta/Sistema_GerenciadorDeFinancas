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
import java.time.format.DateTimeFormatter;

public class ExibeRelatorioGUI extends JFrame {
    JLabel linha1, linha2;
    ImageIcon iconeGastos = new ImageIcon("./Sistema/src/imgs/gastosicon.png");
    ImageIcon iconeMensal = new ImageIcon("./Sistema/src/imgs/gastomensalicon.png");
    ImageIcon iconeReceita = new ImageIcon("./Sistema/src/imgs/receitaicon.png");
    private static SistemaGerenciadorFinancas sistema;
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private JTextField dataField;

    public ExibeRelatorioGUI() {
        sistema = new SistemaFinancas();
        sistema.recuperarDados();

        //Redimensionando os icones
        iconeGastos = new ImageIcon(iconeGastos.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        iconeMensal = new ImageIcon(iconeMensal.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        iconeReceita = new ImageIcon(iconeReceita.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));

        setTitle("Sistema Gerenciador de Finanças");
        setSize(800, 600);
        setLocation(400, 100);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        linha1 = new JLabel("DETALHAMENTO FINANCEIRO: ", JLabel.CENTER);
        linha1.setFont(new Font("Agency FB", Font.BOLD, 30));
        getContentPane().add(linha1, BorderLayout.NORTH);

        //TODO Imagem na linha 2

        //Botões
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout());

        // BTN1: EXIBIR TOTAL DE GASTOS
        JButton botaoTotalGastos = new JButton("Exibir total de Gastos", iconeGastos);
        botaoTotalGastos.setPreferredSize(new Dimension(200, 50));
        botaoTotalGastos.addActionListener(e -> {
            String data = JOptionPane.showInputDialog(this, "Data a ser pesquisada? (dd/MM/yyyy)");
            LocalDate dataCliente = LocalDate.parse(data, dateFormatter);
            double totalGastos = sistema.exibirTotalGastoDoMes(dataCliente);
            JOptionPane.showMessageDialog(this, "Total de gastos no mês: " + totalGastos);
        });

        // BTN2: EXIBIR SALDO POSITIVO/NEGATIVO MENSAL
        JButton botaoGastoMensal = new JButton("Exibir saldo mensal", iconeMensal);
        botaoGastoMensal.setPreferredSize(new Dimension(200, 50));
        botaoGastoMensal.addActionListener(e -> {
            LocalDate dataAtual = LocalDate.now();
            String saldoMensal = sistema.verificarSaldoDoMes(dataAtual, dataAtual.getMonthValue());
            JOptionPane.showMessageDialog(null, saldoMensal);
        });

        // BTN3: EXIBIR RECEITA
        JButton botaoReceita = new JButton("Exibir receita", iconeReceita);
        botaoReceita.setPreferredSize(new Dimension(200, 50));
        botaoReceita.addActionListener(e -> {
            LocalDate dataAtual = LocalDate.now();
            double receitaTotal = sistema.exibirReceitaTotalDoMes(dataAtual);
            JOptionPane.showMessageDialog(null, "Receita total do mês: " + receitaTotal);
        });

        painelBotoes.add(botaoTotalGastos);
        painelBotoes.add(botaoGastoMensal);
        painelBotoes.add(botaoReceita);
        getContentPane().add(painelBotoes, BorderLayout.CENTER);

        //Menu
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

        itemDespesas.addActionListener( e -> {
            GerenciarMinhasDespesasGui paginaDespesa = new GerenciarMinhasDespesasGui();
            dispose();
            paginaDespesa.setVisible(true);
        });
       itemReceitas.addActionListener(e -> {
           JFrame janela = new GerenciarMinhasReceitasGUI();
           dispose();
           janela.setVisible(true);
       });
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
