import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Personagem implements Serializable {

    private String nome;
    private double energia;
    private String progresso;

    public String getProgresso() {
        return progresso;
    }

    public void setProgresso(String progresso) {
        this.progresso = progresso;
    }

    public Personagem(String nome, double energia) {
        this.nome = nome;
        if (energia < 0.0) {
            throw new EnergiaException("Não pode definir energia negativa!");
        }
        this.energia = energia;

    }

    public void subtrairEnergia(double valor) {
        this.energia -= valor * this.energia;
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

    public void salvaArquivo() {
        try {
            FileOutputStream file = new FileOutputStream("rsc/progresso.save");
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(this);
            out.close();
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void carregarArquivo() {
        Personagem temp;
        try {
            FileInputStream file = new FileInputStream("rsc/progresso.save");
            ObjectInputStream in = new ObjectInputStream(file);
            temp = (Personagem) in.readObject();
            this.nome = temp.nome;
            this.energia = temp.energia;
            this.progresso = temp.progresso;
            in.close();
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
