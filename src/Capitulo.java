import java.util.Scanner;

public class Capitulo {

    private String nome, texto, escolha1, escolha2;
    private Personagem personagem;
    private int alteracaoEnergia;
    private Scanner scan;    
   
    public Capitulo(Personagem personagem, int alteracaoEnergia, String nome, String texto,String escolha1,String escolha2, Scanner scan){
        this.personagem = personagem;
        this.alteracaoEnergia = alteracaoEnergia;
        this.nome = nome;
        this.texto = texto;
        this.escolha1 = escolha1;
        this.escolha2 = escolha2;
        this.scan = scan;
    }
 
   
    public void mostrar(){
        System.out.println("Nome do Personagem: " + personagem.getNome());
        personagem.subtrairEnergia(alteracaoEnergia);
        if(alteracaoEnergia != 0){
            System.out.println("\n-ATENÇÃO: Foram gastos " + alteracaoEnergia + " pontos de energia ao escolher essa opção!");
    
        }
        
        
        System.out.println(this.nome);
        System.out.println(this.texto);

        if(alteracaoEnergia != 0 && escolha1 != null){
        System.out.println("Sua energia é de: " +personagem.getEnergia());
        }
        
        else if(alteracaoEnergia == 0){
        System.out.println("Sua energia é de: " + personagem.getEnergia());
            
        }
  
       
    }
   
    public int escolher(){
        boolean continua = true;
        int numEscolha = 0;
        System.out.print("-Qual sua escolha? ");
        String textoDigitado = this.scan.nextLine();

        while (continua) {
        if(textoDigitado.equalsIgnoreCase(this.escolha1)){
            numEscolha = 1;
            continua = false;
        }
        else if(textoDigitado.equalsIgnoreCase(this.escolha2)){
            numEscolha = 2;
            continua = false;
        }
        else{

            System.out.println("\nNão entendi... Tente novamente:");
            textoDigitado = this.scan.nextLine();
            
        }
    }
    return numEscolha;
    }

}
