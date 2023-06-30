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
    public void modificaEnergia(int valor){
        this.energia = valor;
    }
    public String returnNome(){
        return this.nome;
    }
    public void exibirEnergia() {  
    System.out.println("Sua energia é de: " + this.energia);
    }

}
