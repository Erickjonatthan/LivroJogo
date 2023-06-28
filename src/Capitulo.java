import java.util.Scanner;

public class Capitulo {
    String nome, texto, escolha1, escolha2;
    Personagem personagem;
    int alteracaoEnergia;

   
    void mostrar(){
        System.out.println(this.nome);
        System.out.println(this.texto);
       
    }

    int escolher(Scanner scan){

        personagem.subtrairEnergia(alteracaoEnergia);
        personagem.exibirEnergia();
        int numEscolha = 0;
        System.out.print("- ");
        
        String textoDigitado = scan.nextLine();
        if(textoDigitado.equalsIgnoreCase(this.escolha1)){
            numEscolha = 1;
        }
        else if(textoDigitado.equalsIgnoreCase(this.escolha2)){
            numEscolha = 2;
        }
        return numEscolha;
    }

}
