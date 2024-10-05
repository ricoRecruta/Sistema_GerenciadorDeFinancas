package br.ufpb.dcx.gerenciadorDeFinancas.gui;

import br.ufpb.dcx.gerenciadorDeFinancas.controller.ReceitaAddController;
import br.ufpb.dcx.gerenciadorDeFinancas.controller.ReceitaRemoveController;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.SistemaFinancas;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.SistemaGerenciadorFinancas;

import javax.swing.*;
import java.awt.*;

public class MinhasReceitasGUI extends JFrame {
    JLabel linha1, linha2;
    ImageIcon iconeCadastrtar = new ImageIcon("./Sistema/src/imgs/registro.png");
    ImageIcon iconePesquisar = new ImageIcon("./Sistema/src/imgs/lupa.png");
    ImageIcon iconeEditar = new ImageIcon("./Sistema/src/imgs/editar.png");
    ImageIcon iconeRemover = new ImageIcon("./Sistema/src/imgs/remover.png");
    ImageIcon iconeExiberReceita = new ImageIcon("./Sistema/src/imgs/gastomensalicon.png");


    //TODO: mudar depois esse método estáatico
    private static SistemaGerenciadorFinancas sistema;

    public MinhasReceitasGUI(){
        sistema = new SistemaFinancas();
        sistema.recuperarDados();

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
        getContentPane().setLayout(new FlowLayout());

        //TODO: falta adcionar a imagem

        //Botões
         JPanel painelDeBotoes = new JPanel();
         painelDeBotoes.setLayout(new FlowLayout());

         //Botão 1: Cadastrar
        JButton botaoCadastrarReceita = new JButton("Cadastrar receiat", iconeCadastrtar);
        //adcionando a ação do botão
        botaoCadastrarReceita.addActionListener( new ReceitaAddController(sistema,this));


        //Botão 2: Pesquisar
        JButton botaoPesquisarReceita = new JButton("Pesquisar receita", iconePesquisar);
        //adcionando a ação do botão
        botaoPesquisarReceita.addActionListener(new ReceitaAddController(sistema,this));

        //Botão 3: Editar
        JButton botaoEditarReceita = new JButton(" Editar receita", iconeEditar);
        //adcionando a ação do botão
        botaoEditarReceita.addActionListener(new ReceitaAddController(sistema,this));

        //Botão 4: Remover
        JButton botaoRemoverReceita = new JButton("Remover receita",iconeRemover);
        //adcionando a ação do botão
        //TODO: falta implementar a lógica do ReceitaRemoveController
        //botaoRemoverReceita.addActionListener(new ReceitaRemoveController(sistema,this));

        //Botão 5: Exibir

    }



}
