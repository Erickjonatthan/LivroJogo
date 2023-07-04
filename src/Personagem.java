public class Personagem {

    private String nome;
    private int energia;

    public Personagem(String nome) {
        this.nome = nome;
    }

    
    public void subtrairEnergia(int valor) {
        
        this.energia -= valor;

    }
    public void setEnergia(int valor){
        this.energia = valor;
    }
    
    public String getNome() {
        return this.nome;
    }
    public int getEnergia() {
        return this.energia;
    }

}
