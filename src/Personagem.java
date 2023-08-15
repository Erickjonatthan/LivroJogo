public class Personagem {

    private String nome;
    private double energia;

    public Personagem(String nome,double energia) {
        this.nome = nome;
        if (energia < 0.0) {
            throw new EnergiaException("Não pode definir energia negativa!");
        }
        this.energia = energia;
        
    }
    public void subtrairEnergia(double valor) {    
        this.energia -= valor*this.energia; 
        if (this.energia < 0.0) {
            this.energia = 0.0;
        }
    }

    public String getNome() {
        return this.nome;
    }
    public double getEnergia() {
        return this.energia;
    }  
}
