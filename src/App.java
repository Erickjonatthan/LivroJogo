import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
   
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in, "UTF-8");
        
        File personagens = new File("src/personagens.txt");
        Scanner scanPersonagens = null; 
        try {
                scanPersonagens = new Scanner(personagens, "UTF-8");
        } catch (Exception e) {
                System.out.println("Erro ao ler o arquivo personagens.txt");
                e.printStackTrace();
        }

        Map<Integer, Personagem> personagensMap = new HashMap<>();
        int idPersonagem = 1;

        while (scanPersonagens.hasNextLine()) {
                String linha = scanPersonagens.nextLine();
                String[] partes = linha.split(",");

                if (partes.length == 2) {
                        String nomePersonagem = partes[0];
                        double energiaPersonagem = Double.parseDouble(partes[1]);
                        
                        Personagem personagem = new Personagem(nomePersonagem);
                        personagem.setEnergia(energiaPersonagem);

                        personagensMap.put(idPersonagem, personagem);
                        idPersonagem++;
                }
        }
        scanPersonagens.close();        
        
        Personagem personagemPrincipal = personagensMap.get(1);
        
        File capitulos = new File("src/capitulos.txt");
        Scanner scanCapitulos = null;

        try{
                scanCapitulos = new Scanner(capitulos, "UTF-8");
        } catch (Exception e) {
                System.out.println("Erro ao ler o arquivo capitulos.txt");
                e.printStackTrace();
        }
        //faz um hashmap pelo nome dos capitulos
        Map<String, Capitulo> capitulosMap = new HashMap<>();
        while(scanCapitulos.hasNextLine()){
        }
        scanCapitulos.close();
        
   
        capitulosMap.get("CAPITULO 1").executar();
        System.out.println("Tentar novamente?");
        String resposta = scan.nextLine();
        if(resposta.equalsIgnoreCase("Sim")) main(args);
        scan.close();

    }
     
}
