import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormPessoa extends JFrame {

    private JTextField txtNumero, txtNome, txtSexo, txtIdade;
    private Pessoa pessoaAtual;

    public FormPessoa() {

        setTitle("Semana 06 - Exercício 01");
        setSize(430, 260);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JPanel painelEsq = new JPanel();
        painelEsq.setBackground(new Color(200, 200, 200));
        painelEsq.setLayout(null);
        painelEsq.setBounds(0, 0, 150, 200);
        add(painelEsq);

        JLabel lblNumero = new JLabel("Numero:");
        lblNumero.setBounds(10, 20, 100, 20);
        painelEsq.add(lblNumero);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(10, 60, 100, 20);
        painelEsq.add(lblNome);

        JLabel lblSexo = new JLabel("Sexo:");
        lblSexo.setBounds(10, 100, 100, 20);
        painelEsq.add(lblSexo);

        JLabel lblIdade = new JLabel("Idade:");
        lblIdade.setBounds(10, 140, 100, 20);
        painelEsq.add(lblIdade);

        txtNumero = new JTextField();
        txtNumero.setBounds(160, 20, 200, 20);
        txtNumero.setEnabled(false);
        add(txtNumero);

        txtNome = new JTextField();
        txtNome.setBounds(160, 60, 200, 20);
        add(txtNome);

        txtSexo = new JTextField();
        txtSexo.setBounds(160, 100, 200, 20);
        add(txtSexo);

        txtIdade = new JTextField();
        txtIdade.setBounds(160, 140, 200, 20);
        add(txtIdade);

        // Botões
        JButton btnOK = new JButton("OK");
        btnOK.setBounds(20, 200, 80, 25);
        add(btnOK);

        JButton btnLimpar = new JButton("Limpar");
        btnLimpar.setBounds(120, 200, 80, 25);
        add(btnLimpar);

        JButton btnMostrar = new JButton("Mostrar");
        btnMostrar.setBounds(220, 200, 90, 25);
        add(btnMostrar);

        JButton btnSair = new JButton("Sair");
        btnSair.setBounds(330, 200, 70, 25);
        add(btnSair);


        // ---------- BOTÃO OK ----------
        btnOK.addActionListener(e -> {

            String nome = txtNome.getText();
            String sexoStr = txtSexo.getText().toUpperCase();
            String idadeStr = txtIdade.getText();

            if (nome.isEmpty() || sexoStr.isEmpty() || idadeStr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
                return;
            }

            if (!sexoStr.equals("M") && !sexoStr.equals("F")) {
                JOptionPane.showMessageDialog(null, "Sexo deve ser 'M' ou 'F'.");
                return;
            }

            int idade;
            try {
                idade = Integer.parseInt(idadeStr);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Idade deve ser numérica!");
                return;
            }

            pessoaAtual = new Pessoa(nome, sexoStr.charAt(0), idade);
            txtNumero.setText(String.valueOf(pessoaAtual.getNumero()));

            JOptionPane.showMessageDialog(null, "Pessoa cadastrada!");
        });


        btnLimpar.addActionListener(e -> {
            txtNome.setText("");
            txtSexo.setText("");
            txtIdade.setText("");
            txtNumero.setText("");
            txtNome.requestFocus();
        });


        btnMostrar.addActionListener(e -> {
            if (pessoaAtual == null) {
                JOptionPane.showMessageDialog(null, "Nenhuma pessoa cadastrada!");
                return;
            }

            JOptionPane.showMessageDialog(null,
                "Número: " + pessoaAtual.getNumero() +
                "\nNome: " + pessoaAtual.getNome() +
                "\nSexo: " + pessoaAtual.getSexo() +
                "\nIdade: " + pessoaAtual.getIdade() +
                "\nkp (contador): " + pessoaAtual.getKp()
            );
        });

        btnSair.addActionListener(e -> dispose());

        setVisible(true);
    }


    public static void main(String[] args) {
        new FormPessoa();
    }
}
