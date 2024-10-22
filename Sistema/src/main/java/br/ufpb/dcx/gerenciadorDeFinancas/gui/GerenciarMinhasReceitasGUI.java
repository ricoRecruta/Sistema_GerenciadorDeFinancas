package br.ufpb.dcx.gerenciadorDeFinancas.gui;

import br.ufpb.dcx.gerenciadorDeFinancas.controller.*;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.SistemaFinancas;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.SistemaGerenciadorFinancas;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GerenciarMinhasReceitasGUI extends JFrame {
    JLabel linha1, linha2;
    ImageIcon iconeCadastrtar = new ImageIcon("./Sistema/src/imgs/registro.png");
    ImageIcon iconePesquisar = new ImageIcon("./Sistema/src/imgs/lupa.png");
    ImageIcon iconeEditar = new ImageIcon("./Sistema/src/imgs/editar.png");
    ImageIcon iconeRemover = new ImageIcon("./Sistema/src/imgs/remover.png");
    ImageIcon iconeExiberReceita = new ImageIcon("./Sistema/src/imgs/gastomensalicon.png");
    ImageIcon capaReceitas = new ImageIcon("./Sistema/src/imgs/capagerenciadereceitas.png");

    private SistemaGerenciadorFinancas sistema;

    public GerenciarMinhasReceitasGUI(SistemaGerenciadorFinancas sistema) {
        this.sistema = sistema;

        //redimensionando o tamanho dos icones
        iconeCadastrtar = new ImageIcon(iconeCadastrtar.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH));
        iconePesquisar = new ImageIcon(iconePesquisar.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH));
        iconeEditar = new ImageIcon(iconeEditar.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH));
        iconeRemover = new ImageIcon(iconeRemover.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH));
        iconeExiberReceita = new ImageIcon(iconeExiberReceita.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH));

        setTitle("Sistema Gerenciador de Finanças");
        setSize(800,600);
        setLocation(400,100);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());


        linha1 = new JLabel("GESTÃO DE FINANÇAS", JLabel.CENTER);
        linha1.setFont(new Font("Agency FB", Font.BOLD, 30));
        getContentPane().add(linha1, BorderLayout.NORTH);


        //Botões
         JPanel painelDeBotoes = new JPanel();
         painelDeBotoes.setLayout(new FlowLayout());

         //Botão 1: Cadastrar
        JButton botaoCadastrarReceita = new JButton("Cadastrar receita", iconeCadastrtar);
        //adcionando a ação do botão
        botaoCadastrarReceita.addActionListener( new ReceitaAddController(sistema,this));

        //Botão 2: Pesquisar
        JButton botaoPesquisarReceita = new JButton("Pesquisar receita", iconePesquisar);
        botaoPesquisarReceita.addActionListener(new ReceitaSearchController(sistema, this));

        //Botão 3: Editar
        JButton botaoEditarReceita = new JButton(" Editar receita", iconeEditar);
        botaoEditarReceita.addActionListener(new ReceitaEditController(sistema, this));

        //Botão 4: Remover
        JButton botaoRemoverReceita = new JButton("Remover receita",iconeRemover);
        botaoRemoverReceita.addActionListener(new ReceitaRemoveController(sistema,this));

        //Botão 5: Exibir
        JButton botaoExibirReceitas = new JButton("Exibir receitas", iconeExiberReceita);
        //adcioando a ação do botão
        botaoExibirReceitas.addActionListener(e -> {

            String dataString = JOptionPane.showInputDialog(this, "Escreva a data a ser exibida o mês \n Data: dd/MM/yyyy");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate data = LocalDate.parse(dataString, formatter);

            JOptionPane.showMessageDialog(this,"A receita total desse mês foi\n" +
                    sistema.exibirReceitaTotalDoMes(data)+" R$");

        });

        painelDeBotoes.add(botaoCadastrarReceita);
        painelDeBotoes.add(botaoPesquisarReceita);
        painelDeBotoes.add(botaoEditarReceita);
        painelDeBotoes.add(botaoRemoverReceita);
        painelDeBotoes.add(botaoExibirReceitas);
        getContentPane().add(painelDeBotoes,BorderLayout.CENTER);


        //Menu
        JMenuBar menuBar = new JMenuBar();
        menuBar.setPreferredSize(new Dimension(1000,40));
        JMenu menuReceitas = new JMenu("MENU");
        JMenuItem itemPaginaInicial = new JMenuItem("Pagina Inicial");
        JMenuItem itemDespesas = new JMenuItem("Gerência de Despesas");
        JMenuItem itemExibirReceita = new JMenuItem("Exibir Relatório");
        menuReceitas.add(itemPaginaInicial);
        menuReceitas.add(itemDespesas);
        menuReceitas.add(itemExibirReceita);

        menuBar.add(menuReceitas);
        setJMenuBar(menuBar);

        //lógica para ir para a página inicial do sistema
        itemPaginaInicial.addActionListener( new PaginaInicialController(this));

        //Lógica para ir para a pagina de despesas.
        itemDespesas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame janela = new GerenciarMinhasDespesasGui(sistema);
                dispose();
                janela.setVisible(true);
            }
        });

        //lógica para ir para a página de exibirRelatório
        itemExibirReceita.addActionListener(e -> {
            JFrame janela = new ExibeRelatorioGUI(this.sistema);
            dispose();
            janela.setVisible(true);
        });

    }

    public static void main(String[] args){
        SistemaGerenciadorFinancas sistema = new SistemaFinancas();
        sistema.recuperarDados();
        JFrame janelaPrincipal = new GerenciarMinhasReceitasGUI(sistema);
        janelaPrincipal.setVisible(true);
        WindowListener fechadorDeJanelaPrincipal = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                sistema.salvarDados();
                System.exit(0);
            }
        };
        janelaPrincipal.addWindowListener(fechadorDeJanelaPrincipal);

    }



}
