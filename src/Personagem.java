public class Personagem {
    String nome;
    int energia;
    public Personagem(String nome,
    int energia ) {
        this.nome = nome;
        this.energia = energia;
    }
    
    void subtrairEnergia(int valor) {
        this.energia -= valor;
    }
    
}
