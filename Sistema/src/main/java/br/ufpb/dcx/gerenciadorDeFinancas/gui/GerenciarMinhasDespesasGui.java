package br.ufpb.dcx.gerenciadorDeFinancas.gui;

import br.ufpb.dcx.gerenciadorDeFinancas.controller.*;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.SistemaFinancas;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.SistemaGerenciadorFinancas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GerenciarMinhasDespesasGui extends JFrame {
    JLabel linha1, linha2;
    ImageIcon iconeCadastrar = new ImageIcon("./Sistema/src/imgs/registro.png");
    ImageIcon iconePesquisar = new ImageIcon("./Sistema/src/imgs/lupa.png");
    ImageIcon iconeEditar = new ImageIcon("./Sistema/src/imgs/editar.png");
    ImageIcon iconeRemover = new ImageIcon("./Sistema/src/imgs/remover.png");

    // TODO: mudar depois isso
    private static SistemaGerenciadorFinancas sistema;

    public GerenciarMinhasDespesasGui() {
        sistema = new SistemaFinancas();
        sistema.recuperarDados();

        //redimensionando o tamanho dos icones
        iconeCadastrar = new ImageIcon(iconeCadastrar.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        iconePesquisar = new ImageIcon(iconePesquisar.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        iconeRemover = new ImageIcon(iconeRemover.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        iconeEditar = new ImageIcon(iconeEditar.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));

        setTitle("Sistema Gerenciador de Finanças");
        setSize(800, 600);
        setLocation(400, 100);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        linha1 = new JLabel("CONTROLE DE GASTOS", JLabel.CENTER);
        linha1.setFont(new Font("Agency FB", Font.BOLD, 30));
        getContentPane().add(linha1, BorderLayout.NORTH);

        //TODO: Falta adcionar a imagem

        //Botões
        JPanel painelDeBotoes = new JPanel();
        painelDeBotoes.setLayout(new FlowLayout());

        //Botão 1: Cadastrar
        JButton botaoCadastrarDespesa = new JButton("Cadastrar despesa", iconeCadastrar);
        botaoCadastrarDespesa.setPreferredSize(new Dimension(200, 50));

        //ação do botão para cadastrar
        //TODO: verificar de passar a instancia correta do sistema
        botaoCadastrarDespesa.addActionListener(new DespesaAddController(this.sistema, this));


        //Botão 2: Editar
        JButton botaoEditarDespesa = new JButton("Editar despesa", iconeEditar);
        botaoEditarDespesa.setPreferredSize(new Dimension(200, 50));
        //TODO: verificar a implementação da lógica pesquisar
        botaoEditarDespesa.addActionListener(new DespesaEditController(this.sistema, this));


        //Botão 3: Remover
        JButton botaoRemoverDespesa = new JButton("Remover despesa", iconeRemover);
        botaoRemoverDespesa.setPreferredSize(new Dimension(200, 50));
        //TODO: verificar a instancia do sistema e a lógica
        botaoRemoverDespesa.addActionListener(new DespesaRemoveController(this.sistema, this));


        //Botão 4: Pesquisar

        JButton botaoPesquisarDespesa = new JButton("Pesquisar despesa", iconePesquisar);
        botaoPesquisarDespesa.setPreferredSize(new Dimension(200, 50));
        //TODO: verificar a instância do sistema
        botaoPesquisarDespesa.addActionListener(new DespesaSearchController(this.sistema, this));

        painelDeBotoes.add(botaoCadastrarDespesa);
        painelDeBotoes.add(botaoEditarDespesa);
        painelDeBotoes.add(botaoRemoverDespesa);
        painelDeBotoes.add(botaoPesquisarDespesa);
        getContentPane().add(painelDeBotoes, BorderLayout.CENTER);

        //Menu

        JMenuBar menuBar = new JMenuBar();
        menuBar.setPreferredSize(new Dimension(1000, 40));
        JMenu menuDeDespesas = new JMenu("MENU");
        JMenuItem itemPaginaInicial = new JMenuItem("Página Inicial");
        JMenuItem itemExibirRelatorio = new JMenuItem("Exibir Relatório");
        JMenuItem itemReceita = new JMenuItem("Gerência de Receitas");
        menuDeDespesas.add(itemPaginaInicial);
        menuDeDespesas.add(itemExibirRelatorio);
        menuDeDespesas.add(itemReceita);

        menuBar.add(menuDeDespesas);
        setJMenuBar(menuBar);

        //Lógica para a Pagina Inicial do sistema
        itemPaginaInicial.addActionListener(new PaginaInicialController(this));

        //TODO implementar o restante das jenalas

        //Lógica para ir para MinhasReceitasGUI
        itemReceita.addActionListener(e -> {
            JFrame janela = new GerenciarMinhasReceitasGUI();
            dispose();
            janela.setVisible(true);
        });

        //Lõgica para ExibirRelatorioGUI
        itemExibirRelatorio.addActionListener(e ->{
            ExibeRelatorioGUI paginaRelatorio = new ExibeRelatorioGUI();
            dispose();
            paginaRelatorio.setVisible(true);
        });

    }

    public static void main(String[] args) {
        JFrame janela = new GerenciarMinhasDespesasGui();
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


