import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class LeitorCarregador {
    
    HashMap<String, Personagem> lerPersonagens(String caminhoArquivo) {
        HashMap<String, Personagem> personagensMap = new HashMap<>(); 
        
        File arquivoPersonagens = new File(caminhoArquivo);
        
        try {
            Scanner scanPersonagens = new Scanner(arquivoPersonagens, "UTF-8");
            
            while (scanPersonagens.hasNextLine()) {
                String linha = scanPersonagens.nextLine();
                String[] partes = linha.split(",");

                if (partes.length == 2) {
                    String nomePersonagem = partes[0];
                    double energiaPersonagem = Double.parseDouble(partes[1]);
                    personagensMap.put(nomePersonagem,  new Personagem(nomePersonagem, energiaPersonagem));
                    
                }
            }
            scanPersonagens.close();
        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo personagens.txt");
            e.printStackTrace();
        }
        


        return personagensMap;
    }

    HashMap<String, Capitulo> lerCapitulos(String caminho, HashMap<String,Personagem> personagensMap, Scanner scan){
        HashMap<String, Capitulo> capitulosMap = new HashMap<>();

        File arquivoCapitulos = new File(caminho);

        String nomeCapitulo = "";
        String textoCapitulo = "";
        String nomePersonagem = "";
        Double variacaoEnergia = 0.0;

        try{
            Scanner scanCapitulos = new Scanner(arquivoCapitulos, "UTF-8");
            while(scanCapitulos.hasNextLine()){
                nomeCapitulo = scanCapitulos.nextLine();
                if(nomeCapitulo.startsWith("CAPITULO")){
                    textoCapitulo = scanCapitulos.nextLine();
                    nomePersonagem = scanCapitulos.nextLine();
                    variacaoEnergia = Double.parseDouble(scanCapitulos.nextLine());
                    capitulosMap.put(nomeCapitulo, new Capitulo(nomeCapitulo, textoCapitulo,personagensMap.get(nomePersonagem), variacaoEnergia, scan ));
                }
             
            }
            scanCapitulos.close();
        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo personagens.txt");
            e.printStackTrace();
        }

        return capitulosMap;

    }
}
