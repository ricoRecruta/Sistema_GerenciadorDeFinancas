package br.ufpb.dcx.gerenciadorDeFinancas.controller;

import br.ufpb.dcx.gerenciadorDeFinancas.sistema.CategoriaDespesa;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.Receita;
import br.ufpb.dcx.gerenciadorDeFinancas.sistema.SistemaGerenciadorFinancas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;

public class ReceitaAddController implements ActionListener {
    private SistemaGerenciadorFinancas sistema;
    private JFrame janelaPrincipal;

    public ReceitaAddController(SistemaGerenciadorFinancas sistema, JFrame janela){
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }




    public static class InterfaceCadastraReceitaGUI extends JFrame {
        private SistemaGerenciadorFinancas sistemaD;
        private JTextField valorField;
        private JTextField dataField;
        private JButton salvarButton;
        private JLabel resultadoLabel;
        private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        private JFrame janelaPrincipal;
        public InterfaceCadastraReceitaGUI(SistemaGerenciadorFinancas sistema, JFrame janelaPrincipal) {
            this.janelaPrincipal = janelaPrincipal;
            this.sistemaD = sistema;
            setTitle("Cadastra Receita");
            setSize(800, 600);
            setLocation(400, 100);
            setResizable(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            getContentPane().setLayout(new BorderLayout());

            JLabel linha1 = new JLabel("CADASTRE SUA RECEITA", JLabel.CENTER);
            linha1.setFont(new Font("Arial", Font.BOLD, 30));
            getContentPane().add(linha1, BorderLayout.NORTH);

            JPanel mainPanel = new JPanel(new GridBagLayout());
            mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10); // Espaçamento entre componentes
            gbc.fill = GridBagConstraints.HORIZONTAL;

            gbc.gridx = 0;
            gbc.gridy = 0;
            mainPanel.add(new JLabel("Valor:"), gbc);

            gbc.gridx = 1;
            valorField = new JTextField(20);
            mainPanel.add(valorField, gbc);

            gbc.gridx = 0;
            gbc.gridy = 1;
            mainPanel.add(new JLabel("Data (dd/MM/yyyy):"), gbc);

            gbc.gridx = 1;
            dataField = new JTextField(20);
            mainPanel.add(dataField, gbc);

            gbc.gridx = 1;
            gbc.gridy = 2;
            salvarButton = new JButton("Salvar");
            mainPanel.add(salvarButton, gbc);

            gbc.gridx = 1;
            gbc.gridy = 3;
            resultadoLabel = new JLabel("");
            mainPanel.add(resultadoLabel, gbc);

            getContentPane().add(mainPanel, BorderLayout.CENTER);

            salvarButton.addActionListener(e -> {
                try {
                    double valor = Double.parseDouble(valorField.getText());
                    LocalDate data = LocalDate.parse(dataField.getText(), dateFormatter);

                    Receita receita = new Receita("",valor, data);
                    sistema.cadastrarReceita(receita);


                    System.out.println(receita);

                    dispose();
                    janelaPrincipal.setVisible(true);
                } catch (NumberFormatException ex) {
                    resultadoLabel.setText("Valor inválido!");
                } catch (DateTimeParseException ex) {
                    resultadoLabel.setText("Data inválida! Use o formato dd/MM/yyyy.");
                }
            });
        }

        public void main(String[] args) {
            SwingUtilities.invokeLater(() -> new InterfaceCadastraReceitaGUI(this.sistemaD,this.janelaPrincipal).setVisible(true));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        InterfaceCadastraReceitaGUI janelaSecundaria = new InterfaceCadastraReceitaGUI (this.sistema,this.janelaPrincipal);
        janelaSecundaria.setVisible(true);
    }
}
