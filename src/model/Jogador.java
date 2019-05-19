package model;

public class Jogador {
    public String nome = "";
    public String email = "";
    public String senha = "";
    public String dia = "";
    public String mes = "";
    public String ano = "";
    public String sexo = "";
    public String nomeLogin = "";
    public int pontos = 0;


    @Override
    public String toString() {
        return nome + "," + nomeLogin + "," + email + "," + senha + "," + dia + "," + mes + "," + ano + "," + sexo + "," + pontos;
    }
}
