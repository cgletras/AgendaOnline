package model;

public class Contato {
    public String nome = "";
    public String nota1 = "";
    public String nota2 = "";
    
    @Override
    public String toString() {
        return nome + "," + nota1 + "," + nota2;
    }
}
