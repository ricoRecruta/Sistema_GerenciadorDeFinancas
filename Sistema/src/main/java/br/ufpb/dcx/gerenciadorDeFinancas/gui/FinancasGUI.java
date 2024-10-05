package br.ufpb.dcx.gerenciadorDeFinancas.gui;


import br.ufpb.dcx.gerenciadorDeFinancas.controller.*;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.SistemaFinancas;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.SistemaGerenciadorFinancas;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FinancasGUI extends JFrame {
    JLabel linha1, linha2;
    ImageIcon capaSmartFinance;
    private  static SistemaGerenciadorFinancas sistema;


    public FinancasGUI() {
        sistema = new SistemaFinancas();
        sistema.recuperarDados();


        setTitle("Sistema Gerenciador de Finanças");
        setSize(800, 600);
        setLocation(400, 100);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setLayout(new BorderLayout());

        linha1 = new JLabel("GERENCIADOR DE FINANÇAS", JLabel.CENTER);
        linha1.setFont(new Font("Agency FB", Font.BOLD, 30));
        getContentPane().add(linha1, BorderLayout.NORTH);

        String imagePath = "./Sistema/src/imgs/smartfinancephoto.png";
        try {
            BufferedImage img = ImageIO.read(new File(imagePath));
            capaSmartFinance = new ImageIcon(img);
            linha2 = new JLabel(capaSmartFinance, JLabel.CENTER);
        } catch (IOException e) {
            System.err.println("Erro ao carregar a imagem: " + e.getMessage());
            linha2 = new JLabel("Erro ao carregar a imagem", JLabel.CENTER);
        }

        JPanel painelCentral = new JPanel(new BorderLayout());
        painelCentral.setBackground(Color.LIGHT_GRAY);
        painelCentral.add(linha2, BorderLayout.CENTER);
        getContentPane().add(painelCentral, BorderLayout.CENTER);

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

        //Controllers
        DespesaAddController addcontroller = new DespesaAddController(sistema, this);
        itemAddDespesa.addActionListener(addcontroller);
        DespesaEditController editController = new DespesaEditController(sistema,this);
        itemEditDespesa.addActionListener(editController);

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

        //Esse painel central estava ficando por cima da Imagem. Coloquei a imagem por cima dele nas linhas 41 à 56
        /*JPanel painelCentral = new JPanel();
        painelCentral.setBackground(Color.LIGHT_GRAY);
        getContentPane().add(painelCentral, BorderLayout.CENTER);*/

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
