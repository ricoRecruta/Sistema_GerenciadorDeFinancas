package br.ufpb.dcx.gerenciadorDeFinancas.gui;


import br.ufpb.dcx.gerenciadorDeFinancas.sistema.SistemaFinancas;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.SistemaGerenciadorFinancas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class FinancasGUI extends JFrame {

    SistemaGerenciadorFinancas sistema;
    public FinancasGUI() {
        sistema = new SistemaFinancas();
        JLabel linha1;

        setTitle("Financias");
        setSize(800, 600);
        setLocation(400, 100);
        setResizable(false);
        getContentPane().setBackground(Color.white);
        linha1 = new JLabel("Financias Gui", JLabel.CENTER);
        linha1.setForeground(Color.black);
        linha1.setFont(new Font("Serif", Font.BOLD, 24));

        getContentPane().setLayout(new GridLayout(3, 1));

        getContentPane().add(linha1);

    }


//    public static void main(String[] args) {
//        JFrame janela = new FinancasGUI();
//        janela.setVisible(true);
//        WindowListener fechadorDeJanelaPrincipal = new WindowAdapter() {
//            public void windowClosing(WindowEvent e) {
//                System.exit(0);
//            }
//        };
//        janela.addWindowListener(fechadorDeJanelaPrincipal);
//    }

}
