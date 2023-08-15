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

        if (dados.exists()) {
            System.out.println("Você deseja carregar o progresso salvo? ");
            String resposta = scan.nextLine();
            if (resposta.equalsIgnoreCase("Sim")) {
                Personagem temp = new Personagem("", 0);
                temp.carregarArquivo();
                personagens.put(temp.getNome(), temp);
                capitulosMap.get(temp.getProgresso()).executar();
            } else {
                dados.delete();
                capitulosMap.get("CAPITULO 1").executar();
            }
        } else {
            capitulosMap.get("CAPITULO 1").executar();
        }

        System.out.println("Tentar novamente?");
        String resposta = scan.nextLine();
        if (resposta.equalsIgnoreCase("Sim"))
            main(args);
        scan.close();
        dados.delete();

    }

}
