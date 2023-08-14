import java.util.HashMap;
import java.util.Scanner;

public class App {
   
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in, "UTF-8");
        
        LeitorCarregador leitorCarregador = new LeitorCarregador();
        HashMap<String, Personagem> personagens= leitorCarregador.lerPersonagens("rsc/personagens.txt");
        
     
        
        HashMap<String, Capitulo> capitulosMap = leitorCarregador.lerCapitulos("rsc/capitulos.txt", personagens, scan);
        

   
        capitulosMap.get("CAPITULO 1").executar();
        System.out.println("Tentar novamente?");
        String resposta = scan.nextLine();
        if(resposta.equalsIgnoreCase("Sim")) main(args);
        scan.close();

    }
     
}
