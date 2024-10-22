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

public class SmartFinanceGUI extends JFrame {
    JLabel linha1, linha2;
    ImageIcon capaSmartFinance;
    private SistemaGerenciadorFinancas sistema;


    public SmartFinanceGUI() {
        this.sistema = new SistemaFinancas();
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

        String imagePath = "./Sistema/src/imgs/smartfinance.png";
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

        btnDespesas.addActionListener(e -> {
             GerenciarMinhasDespesasGui despesasGUI = new GerenciarMinhasDespesasGui(sistema);
             dispose();
            despesasGUI.setVisible(true);
        });

        btnReceita.addActionListener(e -> {
             GerenciarMinhasReceitasGUI receitasGUI = new GerenciarMinhasReceitasGUI(sistema);
             dispose();
             receitasGUI.setVisible(true);
        });

        btnRelatorios.addActionListener(e -> {
            ExibeRelatorioGUI relatoriosGUI = new ExibeRelatorioGUI(sistema);
            dispose();
            relatoriosGUI.setVisible(true);
        });

        painelBotoes.add(btnReceita);
        painelBotoes.add(btnDespesas);
        painelBotoes.add(btnRelatorios);

        getContentPane().add(painelBotoes, BorderLayout.SOUTH);


    }
    public SistemaGerenciadorFinancas getSistema(){
        return sistema;
    }

    public static void main(String[] args) {
        SmartFinanceGUI janela = new SmartFinanceGUI();
        janela.setVisible(true);
        SistemaGerenciadorFinancas sistema = janela.getSistema();
        WindowListener fechadorDeJanelaPrincipal = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                sistema.salvarDados();
                System.exit(0);
            }
        };
        janela.addWindowListener(fechadorDeJanelaPrincipal);
    }

}
