import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormPessoa2 extends JFrame {

    private JTextField txtNumero, txtNome, txtIdade;
    private JComboBox<String> cbSexo;
    private Pessoa pessoaAtual;

    public static void main(String[] args) {
        new FormPessoa2().setVisible(true);
    }

    public FormPessoa2() {
        setTitle("Semana 06 - Exercício 02");
        setSize(420, 260);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel painelEsq = new JPanel();
        painelEsq.setBounds(10, 10, 150, 170);
        painelEsq.setBackground(new Color(200,200,200));
        painelEsq.setLayout(null);
        add(painelEsq);

        JLabel lblNumero = new JLabel("Numero:");
        lblNumero.setBounds(10, 10, 80, 20);
        painelEsq.add(lblNumero);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(10, 50, 80, 20);
        painelEsq.add(lblNome);

        JLabel lblSexo = new JLabel("Sexo:");
        lblSexo.setBounds(10, 90, 80, 20);
        painelEsq.add(lblSexo);

        JLabel lblIdade = new JLabel("Idade:");
        lblIdade.setBounds(10, 130, 80, 20);
        painelEsq.add(lblIdade);

        txtNumero = new JTextField();
        txtNumero.setBounds(170, 10, 200, 20);
        txtNumero.setEnabled(false);
        add(txtNumero);

        txtNome = new JTextField();
        txtNome.setBounds(170, 50, 200, 20);
        add(txtNome);

        cbSexo = new JComboBox<>(new String[] { "M", "F" });
        cbSexo.setBounds(170, 90, 60, 20);
        add(cbSexo);

        txtIdade = new JTextField();
        txtIdade.setBounds(170, 130, 60, 20);
        add(txtIdade);

        JButton btnOk = new JButton("OK");
        btnOk.setBounds(10, 185, 90, 30);
        add(btnOk);

        JButton btnLimpar = new JButton("Limpar");
        btnLimpar.setBounds(110, 185, 90, 30);
        add(btnLimpar);

        JButton btnMostrar = new JButton("Mostrar");
        btnMostrar.setBounds(210, 185, 90, 30);
        add(btnMostrar);

        JButton btnSair = new JButton("Sair");
        btnSair.setBounds(310, 185, 90, 30);
        add(btnSair);

        // --- BOTÃO OK ---
        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (txtNome.getText().isEmpty() || txtIdade.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
                    return;
                }

                String nome = txtNome.getText();
                char sexo = cbSexo.getSelectedItem().toString().charAt(0);
                int idade;

                try {
                    idade = Integer.parseInt(txtIdade.getText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Idade inválida!");
                    return;
                }

                pessoaAtual = new Pessoa(nome, sexo, idade);
                txtNumero.setText(String.valueOf(pessoaAtual.getNumero()));

                JOptionPane.showMessageDialog(null, "Pessoa cadastrada!");
            }
        });

        btnLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtNome.setText("");
                txtIdade.setText("");
                cbSexo.setSelectedIndex(0);
                txtNome.requestFocus();
            }
        });

        btnMostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (pessoaAtual == null) {
                    JOptionPane.showMessageDialog(null, "Nenhuma pessoa cadastrada!");
                    return;
                }

                String msg = "Número: " + pessoaAtual.getNumero() +
                             "\nNome: " + pessoaAtual.getNome() +
                             "\nSexo: " + pessoaAtual.getSexo() +
                             "\nIdade: " + pessoaAtual.getIdade() +
                             "\nkp (contador): " + Pessoa.getKp();

                JOptionPane.showMessageDialog(null, msg);
            }
        });

        btnSair.addActionListener(e -> System.exit(0));
    }
}
