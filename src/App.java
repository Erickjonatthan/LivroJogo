import java.util.Scanner;

 public class App {
    public static void main(String[] args) {
         
        Scanner scan = new Scanner(System.in);
        String decisao ="";
        boolean continua = true;
        int capitulo=1;
        
        while (continua) {
            
            if ( decisao=="" ||capitulo == 1 ) {
                cap01();  
                decisao = resposta(scan);
            }                
            if (decisao.equals("tentar decifrar o enigma") || capitulo==2) {
                cap0102();
                capitulo=2;
                decisao = resposta(scan);
                
                if (decisao.equals("investigar mais para reunir provas")) {
                    cap010202();
                    final3();

                    continua=false;
                }
                else if (decisao.equals("confrontar o suspeito")){
                    cap010201();
                    final2();
                    continua=false;
                }
                else{
                    msgErro();
                }
                
            }
            else if (decisao.equals("ir embora")){
                cap0101();
                final1();
                continua = false;
            }
            else{
                msgErro();
                decisao="";
            }
        }
        scan.close();    
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
        
    public static void cap01(){
        System.out.println("\n---------CAPITULO 1--------\n");
        System.out.println(
        "Você é um investigador famoso por resolver casos difíceis."+
        "\nUm dia, você é chamado para investigar o assassinato de uma mulher rica chamada Elizabeth."+
        "\nEla foi encontrada morta em sua mansão e a polícia não tem pistas sobre o assassino."+
        "\nVocê decide investigar o caso e vai até a mansão de Elizabeth."+
        "\nLá, você encontra um enigma escrito em um pedaço de papel."+
        "\nO enigma diz: - O assassino está mais perto do que você imagina!.");
        
        System.out.println(
            "\nDica: Você pode tentar decifrar o enigma ou decidir que é muito difícil e ir embora\n");
        pergunta();
    }
    
    
    public static void cap0101() {
        System.out.println("\n---------CAPITULO 1.1--------\n");
        System.out.println(
        "Você decide que é muito difícil resolver o enigma e vai embora."+
        "\nA polícia fica desapontada, mas entende sua decisão."+
        "\nVocê não descobriu a verdade sobre o assassinato de Elizabeth.");
    }
    
    public static void cap0102() {
        System.out.println("\n---------CAPITULO 1.2--------\n");
        System.out.println(
        "Você tenta resolver o enigma e descobre que ele aponta para um suspeito inesperado."+
        "\nÉ John, o mordomo de Elizabeth.");
        System.out.println(
        "\nDica: Você pode confrontar o suspeito diretamente e tenta fazê-lo confessar"+
        " ou investigar mais para reunir provas contra o suspeito\n");
        pergunta();
    }
    
    public static void cap010201() {
        System.out.println("\n---------CAPITULO 1.2.1--------\n");
        System.out.println(
        "Você confronta o suspeito diretamente e tenta fazê-lo confessar."+
        "\nEle se chama John e é o mordomo de Elizabeth."+
        "\nEle nega tudo e se recusa a cooperar."+
        "\nVocê não tem provas suficientes para prendê-lo e ele sai impune.");
    }
    
    public static void cap010202() {
        System.out.println("\n---------CAPITULO 1.2.2--------\n");
        System.out.println(
            "Você investiga mais e reúne provas contra John..."+
            "\nÉ um trabalho difícil, mas no final você consegue reunir evidências suficientes para prendê-lo."+
            "\nDescobrindo que ele estava apaixonado por Elizabeth, mas ela não correspondia aos seus sentimentos."+
            "\nAlém disso, Elizabeth estava planejando demiti-lo e ele ficou com raiva.");
            System.out.println("\nJohn é levado a julgamento e condenado pelo assassinato de Elizabeth");
        }
        
    public static void final1() {
        msgFim();
        System.out.println(
        "Você não resolveu o caso do assassinato de Elizabeth e volta para sua vida normal."+
        "\nHá outros casos para resolver e outras aventuras para viver.\n");
    }
    
    public static void final2() {
        msgFim();
        System.out.println(
        "Você não conseguiu resolver o caso do assassinato de Elizabeth e John sai impune."+
        "\nVoltando para sua vida normal, mas fica com a sensação de que a justiça não foi feita.\n");
    }
    
    public static void final3() {
        msgFim();
        System.out.println(
        "Você resolveu o caso do assassinato de Elizabeth e prendeu John, o culpado."+
        "\nA justiça foi feita e você é aclamado como um herói por todos.\n");
    }

    private static void pergunta() {
        System.out.println("O que você faz?");
    }
    private static void msgFim() {
            System.out.println("\n----------FINAL---------\n");
    }
}
