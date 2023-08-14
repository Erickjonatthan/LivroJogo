public class Personagem {

    private String nome;
    private double energia;

    public Personagem(String nome) {
        this.nome = nome;
    }
    public void subtrairEnergia(double valor) {    
        this.energia -= valor;
       
    }
    public void setEnergia(double valor) {
        if (valor < 0.0) {
            throw new EnergiaException("Não pode definir energia negativa!");
        }
        this.energia = valor;
    }
    public String getNome() {
        return this.nome;
    }
    public double getEnergia() {
        return this.energia;
    }  
}
