import java.util.Scanner;

public class App {
   
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in, "ISO-8859-1");
        boolean continua = true;
        Personagem Joao = new Personagem("João", 110);
        Personagem Edward = new Personagem("Edward", 100);
        boolean verifica = false;
        
        while (continua) {
            //toda vez que voltar para o inicio do while as variaveis recebem o valor inicial
            String decisao = "";
            int capitulo = 1;
            Edward.energia = 100;
            Joao.energia = 110;
            if (decisao == "" && capitulo == 1 && verifica == false )  {
                cap01(Edward);
                decisao = resposta(scan);
            }
            if (decisao.equalsIgnoreCase("tentar decifrar o enigma") || verifica==true) {
                verifica =true;
                cap0102(Joao,Edward);
                
                decisao = resposta(scan);

                if (decisao.equalsIgnoreCase("investigar mais para reunir provas")) {
                    cap010202(Joao,Edward);
                    final3(Joao);
                    verifica=false;
                    continua = perguntaContinua(scan, continua);

                  
                   
                } else if (decisao.equalsIgnoreCase("confrontar o suspeito diretamente")) {
                    cap010201(Joao,Edward); 
                    final2(Joao);
                    verifica=false;
                    continua = perguntaContinua(scan, continua);
                   
                } else {
                    msgErro();
                }
                
            } else if (decisao.equalsIgnoreCase("ir embora")) {
                cap0101(Edward);
                final1();
                continua = perguntaContinua(scan, continua);
            } else {
                msgErro();
                
                
            }
        }
        scan.close();
    }

    private static boolean perguntaContinua(Scanner scan, boolean continua) {

        boolean naoEntendeu = true;

        while(naoEntendeu){
            
        System.out.println("Tentar novamente ou sair?");
        String respostaContinua = resposta(scan);
        if (respostaContinua.equalsIgnoreCase("sair")) {

            continua = false;
            naoEntendeu= false;
        }

        else if(respostaContinua.equalsIgnoreCase("tentar novamente")){
            continua= true;
            naoEntendeu=false;
            
        }
        else{
            msgErro();
        }
    }
        return continua;
    }
    
    public static void cap01(Personagem Edward) {
        System.out.println("\n---------CAPITULO 1--------\n");
        System.out.println(
                "Seu nome é "+Edward.nome+" e Você é um investigador famoso por resolver casos difíceis." +
                        "\nUm dia, você é chamado para investigar o assassinato de uma mulher rica chamada Elizabeth." +
                        "\nEla foi encontrada morta em sua mansão e a polícia não tem pistas sobre o assassino." +
                        "\nVocê decide investigar o caso e vai até a mansão de Elizabeth." +
                        "\nLá, você encontra um enigma escrito em um pedaço de papel." +
                        "\nO enigma diz: - O assassino está mais perto do que você imagina!.\n");
                        pergunta();
        System.out.println("-Tentar decifrar o enigma, Custo: 10 Energia");
        System.out.println("-Ir embora, Custo: 100 Energia\n");
        exibirEnergia(Edward);
    }

    
    public static void cap0101(Personagem Edward) {
        // subtrai 100 de energia
        int valorGasto = Edward.subtrairEnergia(100);
        System.out.println("\n---------CAPITULO 1.1--------\n");
        System.out.println(
            "Você gastou "+valorGasto+" de energia e decide que é muito difícil resolver o enigma e vai embora." +
            "\nA polícia fica desapontada, mas entende sua decisão." +
            "\nVocê não descobriu a verdade sobre o assassinato de Elizabeth.\n");            
    }
    
    public static void cap0102(Personagem Joao, Personagem Edward) {
        // subtrai 10 de energia
        int valorGasto = Edward.subtrairEnergia(10);
        System.out.println("\n---------CAPITULO 1.2--------\n");
        System.out.println(
            "Você gastou "+ valorGasto +" de energia para resolver o enigma e descobre que ele aponta para um suspeito inesperado." +
                        "\nÉ "+Joao.nome+" , o mordomo de Elizabeth.\n");
                        pergunta();
                        System.out.println("-Confrontar o suspeito diretamente,  Custo: 90 Energia");
                        System.out.println("-Investigar mais para reunir provas,  Custo: 50 Energia\n");
        exibirEnergia(Edward);
        
    }
    
    public static void cap010201(Personagem Joao,Personagem Edward) {
        // subtrai 90 de energia
        int valorGasto = Edward.subtrairEnergia(90);
        System.out.println("\n---------CAPITULO 1.2.1--------\n");
        System.out.println(
            "Você gastou "+ valorGasto +" de energia para confrontar o suspeito diretamente e tentar fazê-lo confessar." +
            "\nEle se chama "+Joao.nome+" e é o mordomo de Elizabeth." +
            "\nEle nega tudo e se recusa a cooperar." +
            "\nVocê não tem provas suficientes para prendê-lo e ele sai impune.;\n");
            
        }

    public static void cap010202(Personagem Joao, Personagem Edward) {
        // subtrai 50 de energia
        int valorGasto = Edward.subtrairEnergia(50);
        System.out.println("\n---------CAPITULO 1.2.2--------\n");
        System.out.println(
            "Você gastou "+valorGasto+" de energia para investigar mais e reunir provas contra "+Joao.nome+"..." +
            "\nÉ um trabalho difícil, mas no final você consegue reunir evidências suficientes para prendê-lo."+
                "\nDescobrindo que ele estava apaixonado por Elizabeth, mas ela não correspondia aos seus sentimentos."+
                "\nAlém disso, Elizabeth estava planejando demiti-lo e ele ficou com raiva.");
                System.out.println("\n"+Joao.nome+" é levado a julgamento e condenado pelo assassinato de Elizabeth.\n");
                
            }

    public static void final1() {
        msgFim();
        System.out.println(
        "Você não resolveu o caso do assassinato de Elizabeth e volta para sua vida normal." +
            "\nHá outros casos para resolver e outras aventuras para viver.\n");
       
        }
        
    public static void final2(Personagem Joao) {
        msgFim();
        System.out.println(
            "Você não conseguiu resolver o caso do assassinato de Elizabeth e "+Joao.nome+" sai impune." +
            "\nVoltando para sua vida normal, mas fica com a sensação de que a justiça não foi feita.\n");
        
        }
        
    public static void final3(Personagem Joao) {
        msgFim();
        System.out.println(
            "Você resolveu o caso do assassinato de Elizabeth e prendeu "+Joao.nome+", o culpado." +
            "\nA justiça foi feita e você é aclamado como um herói por todos.\n");
        
        }
        
        
    private static String resposta(Scanner scan) {
        String decisao;
        System.out.print("- ");
        decisao = scan.nextLine();
        return decisao;
    }
        
    private static void msgErro() {
        System.out.println("\nNão entendi... Tente novamente:\n");
    }
    private static void pergunta() {
        System.out.println("O que você faz?");
    }
    
    private static void msgFim() {
        System.out.println("\n----------FINAL---------\n");
    }
    private static void exibirEnergia(Personagem Edward) {
    
        System.out.println("Sua energia é: "+Edward.energia);
    
    }
}
