import java.util.ArrayList;
import java.util.Scanner;

public class Capitulo {

    protected String nome, texto;
    protected ArrayList<Escolha> escolhas;
    protected Personagem personagem;
    protected double alteracaoEnergia;
    protected Scanner scan;

    public Capitulo(String nome, String texto, Personagem personagem, double alteracaoEnergia, Scanner scan) {

        this.nome = nome;
        this.texto = texto;
        this.personagem = personagem;
        this.scan = scan;
        this.escolhas = new ArrayList<Escolha>();
        this.alteracaoEnergia = alteracaoEnergia;

    }

    private int escolher() {

        boolean continua = true;
        if (this.escolhas.size() > 0) {

            System.out.print("->Qual sua escolha? ");
            String textoDigitado = this.scan.nextLine();

            while (continua) {
                for (int i = 0; i < this.escolhas.size(); i++) {
                    if (textoDigitado.equalsIgnoreCase(this.escolhas.get(i).getTexto())) {
                        continua = false;
                        return i;
                    }
                }
                if (continua) {
                    System.out.println("\nNão entendi... Tente novamente:");
                    textoDigitado = this.scan.nextLine();
                }
            }
        }
        return -1;
    }

    protected void mostrar() {
        
        if (alteracaoEnergia != 0.0) {
            System.out.println("Sua energia foi alterada em: "
                    + String.format("%.0f", alteracaoEnergia * personagem.getEnergia()));
        }
        personagem.subtrairEnergia(alteracaoEnergia);

        System.out.println(this.nome);
        System.out.println(this.texto.replace("PLAYER", personagem.getNome()));
        
        for (Escolha escolha : escolhas) {
            System.out.println("- " + escolha.getTexto());
        }

        if (escolhas.size() > 0) {
            System.out.println("Energia: " + String.format("%.0f", personagem.getEnergia()));
        }
    }


    public void setEscolha(String texto, Capitulo capitulo) {

        this.escolhas.add(new Escolha(texto, capitulo));

    }

    public void executar() {

        mostrar();
        int id = escolher();
        if (id >= 0) {
            this.personagem.setProgresso(this.escolhas.get(id).getNextCapituloNome());
            this.personagem.salvaArquivo();
            this.escolhas.get(id).getProximo().executar();
        }

    }

    public String getNome() {
        return this.nome;
    }

    public String getTexto() {
        return this.texto;
    }

}
