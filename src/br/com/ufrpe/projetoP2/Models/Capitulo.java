package br.com.ufrpe.projetoP2.Models;
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
        personagem.subtrairEnergia(alteracaoEnergia);
        return this.texto.replace("PLAYER", personagem.getNome()) + "\n\n" + getMsg() ;
    }

    public String getMsg(){
        
        String msg = "";
        if (escolhas.size() > 0) {
            msg = "Energia: " + String.format("%.0f", personagem.getEnergia());
        }
        return msg;
    }

    public ArrayList<Escolha> getEscolhas() {
        
        return this.escolhas;
    }

}
