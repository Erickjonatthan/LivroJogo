import java.util.Scanner;

public class CapituloImagem extends Capitulo {

    private String imagem;

    public CapituloImagem(String nome, String texto, Personagem personagem, double alteracaoEnergia, Scanner scan, String imagem) {

        super(nome, texto, personagem, alteracaoEnergia, scan);
        this.imagem = imagem;

    }

    @Override
    protected void mostrar(){
        System.out.println("\n"+ this.imagem);
        super.mostrar();
    }
    
}
