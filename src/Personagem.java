public class Personagem {

    private String nome;
    private int energia;

    public Personagem(String nome) {
        this.nome = nome;
    }

    
    public void subtrairEnergia(int valor) {
        
        this.energia -= valor;
        if (this.energia < 0) {
            this.energia = 0;
        }

    }
    public void setEnergia(int valor) throws EnergiaNegativaException {
        if (valor < 0) {
            throw new EnergiaNegativaException("Energia não pode ser negativa!");
        }
        this.energia = valor;
    }
    
    public String getNome() {
        return this.nome;
    }
    public int getEnergia() {
        return this.energia;
    }

}
