import java.util.ArrayList;
import java.util.Scanner;
public class Capitulo {

    private String nome, texto;
    private ArrayList<Escolha> escolhas;
    private Personagem personagem;
    private double alteracaoEnergia;
    private Scanner scan;    
    
    public Capitulo(Personagem personagem, double alteracaoEnergia, String nome, String texto, Scanner scan){
        this.personagem = personagem;
        this.alteracaoEnergia = alteracaoEnergia;
        this.nome = nome;
        this.texto = texto;
        this.scan = scan;
        this.escolhas = new ArrayList<Escolha>();
    }
    private int escolher(){
    
        boolean continua = true;
        if (this.escolhas.size() > 0) {
            
            System.out.print("-Qual sua escolha? ");
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

    private void mostrar(){
        
        personagem.subtrairEnergia(alteracaoEnergia);
        
        if(alteracaoEnergia != 0){
            //exibe a alteração de energia arredondado
            System.out.println("Sua energia foi alterada em: " +String.format("%.0f", alteracaoEnergia));
         }
         
         System.out.println(this.nome);
         System.out.println(this.texto);
         for (Escolha escolha : escolhas) {
             System.out.println("- "+ escolha.getTexto());
         }
    
         
         if(alteracaoEnergia != 0 && escolhas.size() != 0){
                System.out.println("Sua energia é de: " +String.format("%.0f", personagem.getEnergia()));
         }

         if(alteracaoEnergia == 0){    
                System.out.println("Sua energia é de: " +String.format("%.0f", personagem.getEnergia()));
         }
     }
 
    public void setEscolha(String texto, Capitulo capitulo){
        
        this.escolhas.add(new Escolha(texto, capitulo));

    }
   
    public void executar(){

            mostrar();
            int id = escolher();
            if(id >= 0 ){
                
                this.escolhas.get(id).getProximo().executar();
            }

    }

}

