import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in, "UTF-8");
        LeitorCarregador leitorCarregador = new LeitorCarregador();
        HashMap<String, Personagem> personagens = leitorCarregador.lerPersonagens("rsc/personagens.txt");
        HashMap<String, Capitulo> capitulosMap = leitorCarregador.lerCapitulos("rsc/capitulos.txt", personagens, scan);
        File dados = new File("rsc/progresso.save");
        Boolean carregaProgresso = leitorCarregador.lerProgresso(dados, scan);
        
        if (carregaProgresso) {
            Personagem temp = new Personagem("", 0);
            temp.carregarArquivo();
            Personagem personagem = personagens.get(temp.getNome());
            personagem.setEnergia(temp.getEnergia());
            personagem.setProgresso(temp.getProgresso());
            capitulosMap.get(temp.getProgresso()).executar();
        } else {
            if(dados.exists()){
                dados.delete();
            }
            capitulosMap.get("CAPITULO 1").executar();
        }
        
    
        System.out.println("Tentar novamente?");
        String resposta = scan.nextLine();
        
        if (resposta.equalsIgnoreCase("Sim")){
            dados.delete();
            main(args);
        }
        scan.close();
    }

}
