import javax.swing.*;
import java.awt.event.*;

public class FormPessoa3 extends JFrame {

    private JTextField txtNumero, txtNome, txtIdade;
    private JTextField txtResultado;

    private JRadioButton rbM, rbF;
    private ButtonGroup grupoSexo;

    private Pessoa pessoaAtual;

    public FormPessoa3() {

        setTitle("Semana 06 - Exercício 03");
        setSize(400, 300);
        setLayout(null);
        setResizable(false);

        JLabel lblNumero = new JLabel("Numero:");
        lblNumero.setBounds(20, 20, 80, 20);
        add(lblNumero);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(20, 60, 80, 20);
        add(lblNome);

        JLabel lblSexo = new JLabel("Sexo:");
        lblSexo.setBounds(20, 100, 80, 20);
        add(lblSexo);

        JLabel lblIdade = new JLabel("Idade:");
        lblIdade.setBounds(20, 140, 80, 20);
        add(lblIdade);

        txtNumero = new JTextField();
        txtNumero.setBounds(120, 20, 80, 20);
        txtNumero.setEnabled(false);
        add(txtNumero);

        txtNome = new JTextField();
        txtNome.setBounds(120, 60, 200, 20);
        add(txtNome);

        rbM = new JRadioButton("M");
        rbM.setBounds(120, 100, 40, 20);

        rbF = new JRadioButton("F");
        rbF.setBounds(180, 100, 40, 20);

        grupoSexo = new ButtonGroup();
        grupoSexo.add(rbM);
        grupoSexo.add(rbF);

        add(rbM);
        add(rbF);

        txtIdade = new JTextField();
        txtIdade.setBounds(120, 140, 60, 20);
        add(txtIdade);


        JButton btnOK = new JButton("OK");
        btnOK.setBounds(20, 180, 80, 30);
        add(btnOK);

        JButton btnLimpar = new JButton("Limpar");
        btnLimpar.setBounds(110, 180, 80, 30);
        add(btnLimpar);

        JButton btnMostrar = new JButton("Mostrar");
        btnMostrar.setBounds(200, 180, 90, 30);
        add(btnMostrar);

        JButton btnSair = new JButton("Sair");
        btnSair.setBounds(300, 180, 70, 30);
        add(btnSair);

        txtResultado = new JTextField();
        txtResultado.setBounds(20, 220, 350, 25);
        txtResultado.setEditable(false);
        add(txtResultado);


        btnOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (txtNome.getText().isEmpty() || txtIdade.getText().isEmpty()
                        || (!rbM.isSelected() && !rbF.isSelected())) {

                    JOptionPane.showMessageDialog(null,
                            "Preencha todos os campos e selecione o sexo!");
                    return;
                }

                char sexo = rbM.isSelected() ? 'M' : 'F';
                String nome = txtNome.getText();
                int idade = Integer.parseInt(txtIdade.getText());

                pessoaAtual = new Pessoa(nome, sexo, idade);

                txtNumero.setText(String.valueOf(pessoaAtual.getNumero()));

                JOptionPane.showMessageDialog(null, "Pessoa cadastrada!");
            }
        });

        btnLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtNome.setText("");
                txtIdade.setText("");
                txtNumero.setText("");
                txtResultado.setText("");
                grupoSexo.clearSelection();   
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

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }


    public static void main(String[] args) {
        new FormPessoa3();
    }
}
