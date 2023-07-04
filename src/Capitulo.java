import java.util.Scanner;

public class Capitulo {

    private String nome, texto;
    private String[] escolhas;
    private Personagem personagem;
    private int alteracaoEnergia;
    private Scanner scan;    
   
    public Capitulo(Personagem personagem, int alteracaoEnergia, String nome, String texto, String[] escolhas, Scanner scan){
        this.personagem = personagem;
        this.alteracaoEnergia = alteracaoEnergia;
        this.nome = nome;
        this.texto = texto;
        this.escolhas= escolhas;
        this.scan = scan;
    }
 
   
    public void mostrar(){


        personagem.subtrairEnergia(alteracaoEnergia);

        if(alteracaoEnergia != 0){
 
            System.out.println("\n-ATENÇÃO: "+personagem.getNome()+" gastou "+alteracaoEnergia+" pontos de energia ao escolher essa opção!");
    
        }
        
        
        
        System.out.println(this.nome);
        System.out.println(this.texto);

        if(alteracaoEnergia != 0 && escolhas.length != 0){

            System.out.println("Sua energia é de: " +personagem.getEnergia());

        }

       
        else if(alteracaoEnergia == 0){

            System.out.println("Sua energia é de: " +personagem.getEnergia());
            
        }
  
       
    }
   
    public int escolher(){

        boolean continua = true;

        System.out.print("-Qual sua escolha? ");
        String textoDigitado = this.scan.nextLine();

        int numEscolha = -1;
        int index = 0;

        while (continua) {
            for (String escolha : this.escolhas) {
                if (textoDigitado.equalsIgnoreCase(escolha)) {
                    numEscolha = index;
                    continua = false;
                    break;
                }
                index++;
            }
            if (continua) {
                System.out.println("\nNão entendi... Tente novamente:");
                textoDigitado = this.scan.nextLine();
            }
        }
        return numEscolha;
}
}

