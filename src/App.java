import java.util.Scanner;

public class App {
   
    //cria os personagens
   static Personagem Joao = new Personagem("João", 110);
   static Personagem Edward = new Personagem("Edward", 100);
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in, "UTF-8");
        String decisao = "";
        boolean continua = true;
        int capitulo = 1;



        while (continua) {

            if (decisao == "" && capitulo == 1) {
                cap01();
                decisao = resposta(scan);
            }
            if (decisao.equalsIgnoreCase("tentar decifrar o enigma") || capitulo == 2) {
                cap0102();
                //subtrai 10 de energia
                Edward.subtrairEnergia(10);
                capitulo = 2;
                decisao = resposta(scan);

                if (decisao.equalsIgnoreCase("investigar mais para reunir provas")) {
                    cap010202();
                    // subtrai 50 de energia
                    Edward.subtrairEnergia(50);
                    final3();
                    continua = false;
                } else if (decisao.equalsIgnoreCase("confrontar o suspeito diretamente")) {
                    cap010201();
                    // subtrai 90 de energia
                    Edward.subtrairEnergia(90);
                    final2();
                    continua = false;
                } else {
                    msgErro();
                }

            } else if (decisao.equalsIgnoreCase("ir embora")) {
                cap0101();
                Edward.subtrairEnergia(100);
                final1();
                continua = false;
            } else {
                msgErro();
                decisao = "";
            }
        }
        scan.close();
    }
    
    public static void cap01() {
        System.out.println("\n---------CAPITULO 1--------\n");
        System.out.println(
                "Seu nome é "+Edward.nome+" e Você é um investigador famoso por resolver casos difíceis." +
                        "\nUm dia, você é chamado para investigar o assassinato de uma mulher rica chamada Elizabeth." +
                        "\nEla foi encontrada morta em sua mansão e a polícia não tem pistas sobre o assassino." +
                        "\nVocê decide investigar o caso e vai até a mansão de Elizabeth." +
                        "\nLá, você encontra um enigma escrito em um pedaço de papel." +
                        "\nO enigma diz: - O assassino está mais perto do que você imagina!.\n");
                        pergunta();
        System.out.println("-Tentar decifrar o enigma");
        System.out.println("-Ir embora (decidir que é muito difícil)\n");
        
    }

    public static void cap0101() {
        System.out.println("\n---------CAPITULO 1.1--------\n");
        System.out.println(
            "Você decide que é muito difícil resolver o enigma e vai embora." +
                        "\nA polícia fica desapontada, mas entende sua decisão." +
                        "\nVocê não descobriu a verdade sobre o assassinato de Elizabeth.");
    }

    public static void cap0102() {
        System.out.println("\n---------CAPITULO 1.2--------\n");
        System.out.println(
                "Você tenta resolver o enigma e descobre que ele aponta para um suspeito inesperado." +
                        "\nÉ "+Joao.nome+" , o mordomo de Elizabeth.");
        pergunta();
        System.out.println("-Confrontar o suspeito diretamente (tentar fazê-lo confessar)");
        System.out.println("-Investigar mais para reunir provas\n");
        
    }
    
    public static void cap010201() {
        System.out.println("\n---------CAPITULO 1.2.1--------\n");
        System.out.println(
            "Você confronta o suspeito diretamente e tenta fazê-lo confessar." +
            "\nEle se chama "+Joao.nome+" e é o mordomo de Elizabeth." +
            "\nEle nega tudo e se recusa a cooperar." +
            "\nVocê não tem provas suficientes para prendê-lo e ele sai impune.");
        }

        public static void cap010202() {
            System.out.println("\n---------CAPITULO 1.2.2--------\n");
        System.out.println(
                "Você investiga mais e reúne provas contra "+Joao.nome+"..." +
                "\nÉ um trabalho difícil, mas no final você consegue reunir evidências suficientes para prendê-lo."+
                "\nDescobrindo que ele estava apaixonado por Elizabeth, mas ela não correspondia aos seus sentimentos."+
                "\nAlém disso, Elizabeth estava planejando demiti-lo e ele ficou com raiva.");
        System.out.println("\n"+Joao.nome+" é levado a julgamento e condenado pelo assassinato de Elizabeth");
    }

    public static void final1() {
        msgFim();
        System.out.println(
            "Você não resolveu o caso do assassinato de Elizabeth e volta para sua vida normal." +
            "\nHá outros casos para resolver e outras aventuras para viver.\n");
    }

    public static void final2() {
        msgFim();
        System.out.println(
                "Você não conseguiu resolver o caso do assassinato de Elizabeth e "+Joao.nome+" sai impune." +
                        "\nVoltando para sua vida normal, mas fica com a sensação de que a justiça não foi feita.\n");
                    }

                    public static void final3() {
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
}
