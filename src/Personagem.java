public class Personagem {

    String nome;
    int energia;

    public Personagem(String nome,
            int energia) {
        this.nome = nome;
        this.energia = energia;
    }

    int subtrairEnergia(int valor) {
        this.energia -= valor;
        if (energia == 0) {
            System.out.println("Opa! Acabou sua energia! ");
        }
        return valor;
    }

    void exibirEnergia(boolean fim) {
        if (fim) {
            System.out.println("Sua energia final é de: " + this.energia);
        } else {
            System.out.println("Sua energia é de: " + this.energia);
        }

    }

}
