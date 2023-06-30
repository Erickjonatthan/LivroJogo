import java.util.Scanner;

public class Capitulo {

    private String nome, texto, escolha1, escolha2;
    private Personagem personagem;
    private int alteracaoEnergia;

   
    public Capitulo(Personagem personagem, int alteracaoEnergia, String nome ,String texto,String escolha1,String escolha2){
        this.personagem = personagem;
        this.alteracaoEnergia = alteracaoEnergia;
        this.nome = nome;
        this.texto = texto;
        this.escolha1 = escolha1;
        this.escolha2 = escolha2;
    }
 
   
    public void mostrar(){
        personagem.subtrairEnergia(alteracaoEnergia);
        if(alteracaoEnergia != 0){
            System.out.println("\n-ATENÇÃO: Foram gastos " + alteracaoEnergia + " pontos de energia ao escolher essa opção!");
    
        }
        
        
        System.out.println(this.nome);
        System.out.println(this.texto);

        if(alteracaoEnergia != 0 && escolha1 != null){
        personagem.exibirEnergia();
        }
        
        else if(alteracaoEnergia == 0){
        personagem.exibirEnergia();
            
        }
  
       
    }
   
    public int escolher(Scanner scan){
       
        int numEscolha = 0;
        System.out.print("-Qual sua escolha? ");
        
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
