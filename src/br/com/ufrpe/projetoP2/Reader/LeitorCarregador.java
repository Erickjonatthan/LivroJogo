package br.com.ufrpe.projetoP2.Reader;
import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

import br.com.ufrpe.projetoP2.Models.Capitulo;
import br.com.ufrpe.projetoP2.Models.CapituloImagem;
import br.com.ufrpe.projetoP2.Models.Personagem;

public class LeitorCarregador {
    
    public HashMap<String, Personagem> lerPersonagens(String caminhoArquivo) {
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

    public HashMap<String, Capitulo> lerCapitulos(String caminho, HashMap<String,Personagem> personagensMap, Scanner scan){
        HashMap<String, Capitulo> capitulosMap = new HashMap<>();

        File arquivoCapitulos = new File(caminho);
        String nomeCapitulo = "";
        String textoCapitulo = "";
        String nomePersonagem = "";
        Double variacaoEnergia = 0.0;
        String capituloOrigem = "";
        String capituloDestino = "";
        String textoEscolha = "";


        try{
            Scanner scanCapitulos = new Scanner(arquivoCapitulos, "UTF-8");
            while(scanCapitulos.hasNextLine()){
                nomeCapitulo = scanCapitulos.nextLine();
                if(nomeCapitulo.startsWith("CAPITULO")){
                    String imagem = "";
                    if (nomeCapitulo.indexOf("_IMAGEM") > 0){
                        String linha = scanCapitulos.nextLine();
                        while (!linha.equalsIgnoreCase("IMAGEM_FIM")) {
                            imagem = imagem + linha + "\n";
                            linha = scanCapitulos.nextLine();
                        }
                    }
                    textoCapitulo = scanCapitulos.nextLine();
                    nomePersonagem = scanCapitulos.nextLine();
                    variacaoEnergia = Double.parseDouble(scanCapitulos.nextLine());
                    if (imagem.length() > 0){
                        CapituloImagem temp = new CapituloImagem(nomeCapitulo, textoCapitulo, personagensMap.get(nomePersonagem), variacaoEnergia, scan, imagem);
                        capitulosMap.put(nomeCapitulo, temp);
                    } else {
                        Capitulo temp = new Capitulo(nomeCapitulo, textoCapitulo,personagensMap.get(nomePersonagem), variacaoEnergia, scan );
                        capitulosMap.put(nomeCapitulo, temp);
                    }
                
                }
                else if(nomeCapitulo.equalsIgnoreCase("ESCOLHA")){
                    capituloOrigem = scanCapitulos.nextLine();
                    textoEscolha = scanCapitulos.nextLine();
                    capituloDestino = scanCapitulos.nextLine();
                    capitulosMap.get(capituloOrigem).setEscolha(textoEscolha, capitulosMap.get(capituloDestino));
                }
             
            }
            scanCapitulos.close();
        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo personagens.txt");
            e.printStackTrace();
        }

        return capitulosMap;

    }

    public Personagem getPersonagemTemp(HashMap<String, Personagem> personagens) {
        Personagem temp = new Personagem("", 0);
        temp.carregarArquivo();
        Personagem personagem = personagens.get(temp.getNome());
        personagem.setEnergia(temp.getEnergia());
        personagem.setProgresso(temp.getProgresso());
        return temp;
    }

}
