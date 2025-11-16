public class Pessoa {

    private static int kp = 0;  
    private int numero;          
    private String nome;
    private char sexo;
    private int idade;

    public Pessoa() {
        Pessoa.kp++;
        this.numero = kp;
    }

    public Pessoa(String nome, char sexo, int idade) {
        Pessoa.kp++;
        this.numero = kp;
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
    }

    public static int getKp() {
        return Pessoa.kp;
    }

    public int getNumero() {
        return this.numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
