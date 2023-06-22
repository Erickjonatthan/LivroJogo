public class Personagem {
    String nome;
    int energia;
    public Personagem(String nome,
    int energia ) {
        this.nome = nome;
        this.energia = energia;
    }
    
    int subtrairEnergia(int valor) {
        this.energia -= valor;
        if(energia==0){
            System.out.println("Opa! Acabou sua energia! ");
        }
        return valor;
    }
    
}
