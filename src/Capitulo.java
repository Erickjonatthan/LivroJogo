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

    // private int escolher() {

    //     if (this.escolhas.size() > 0) {
        
    //             for (int i = 0; i < this.escolhas.size(); i++) {
    //                 if (.equalsIgnoreCase(this.escolhas.get(i).getTexto())) {
    //                     return i;
    //                 }
    //             }
              
    //         }
        
    //     return -1;
    // }



    public void setEscolha(String texto, Capitulo capitulo) {

        this.escolhas.add(new Escolha(texto, capitulo));


    }
    public void salvaProgresso(String proximaEscolha) {

            this.personagem.setProgresso(proximaEscolha);
            this.personagem.salvaArquivo();

        
    }


    public String getNome() {
        return this.nome;
    }

    public String getTexto() {
        return this.texto.replace("PLAYER", personagem.getNome());
    }

    public String getMsg(){
        personagem.subtrairEnergia(alteracaoEnergia);
        String msg = "";
        if (alteracaoEnergia != 0.0) {
            msg = "Sua energia foi alterada em: "
                    + String.format("%.0f", alteracaoEnergia * personagem.getEnergia());
        }
        if (escolhas.size() > 0) {
            msg = "Energia: " + String.format("%.0f", personagem.getEnergia());
        }
        return msg;
    }

    public ArrayList<Escolha> getEscolhas() {
        return this.escolhas;
    }

}
