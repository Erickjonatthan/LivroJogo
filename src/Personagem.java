public class Personagem {

    private String nome;
   

    private int energia;

    public Personagem(String nome,
            int energia) {
        this.nome = nome;
        this.energia = energia;
    }

    
    public void subtrairEnergia(int valor) {
        
        this.energia -= valor;
    }
    public void setEnergia(int valor){
        this.energia = valor;
    }
    
    public String getNome() {
        return nome;
    }
    public int getEnergia() {  
    return this.energia;
    }

}
