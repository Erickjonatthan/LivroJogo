import java.util.Scanner;

public class App {
   
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in, "UTF-8");
        boolean continua = true;
        Personagem Edward = new Personagem("Edward", 100);
        boolean verifica = false;

        Capitulo capitulo1 = new Capitulo();
        capitulo1.personagem = Edward;
        capitulo1.nome = "\n---------CAPITULO 1--------\n";
        capitulo1.texto = 
        "Seu nome é "+capitulo1.personagem.nome+" e Você é um investigador famoso por resolver casos difíceis." +       
        "\nUm dia, você é chamado para investigar o assassinato de uma mulher rica chamada Elizabeth." +
        "\nEla foi encontrada morta em sua mansão e a polícia não tem pistas sobre o assassino." +
        "\nVocê decide investigar o caso e vai até a mansão de Elizabeth." +
        "\nLá, você encontra um enigma escrito em um pedaço de papel." +
        "\nO enigma diz: - O assassino está mais perto do que você imagina!\n"+
        "\n-Tentar decifrar o enigma, Custo: 10 Energia\n"+
        "-Ir embora, Custo: 100 Energia\n";
        capitulo1.escolha1 = "Tentar decifrar o enigma";
        capitulo1.escolha2 = "Ir embora";


        Capitulo capitulo0101 = new Capitulo();
        capitulo0101.personagem = Edward;
        capitulo0101.alteracaoEnergia= 100;
        capitulo0101.nome = "\n---------CAPITULO 1.1--------\n";
        capitulo0101.texto =  
        "Você gastou "+capitulo0101.alteracaoEnergia+" de energia e decide que é muito difícil resolver o enigma e vai embora." +
        "\nA polícia fica desapontada, mas entende sua decisão." +
        "\nVocê não descobriu a verdade sobre o assassinato de Elizabeth.\n";
        capitulo0101.escolha1 = null;
        capitulo0101.escolha2 = null;

        
        Capitulo capitulo0102 = new Capitulo();
        capitulo0102.personagem = Edward;
        capitulo0102.alteracaoEnergia = 10;
        capitulo0102.nome = "\n---------CAPITULO 1.2--------\n";
        capitulo0102.texto=
        "Você gastou "+ capitulo0102.alteracaoEnergia+ " de energia para resolver o enigma e descobre que"+
        " ele aponta para um suspeito inesperado. \nÉ João, o mordomo de Elizabeth.\n"+
        "\n-Confrontar o suspeito diretamente,  Custo: 90 Energia\n"+
        "-Investigar mais para reunir provas,  Custo: 50 Energia\n";
        capitulo0102.escolha1 = "Confrontar o suspeito diretamente";
        capitulo0102.escolha2 = "Investigar mais para reunir provas";
        
        Capitulo capitulo010201 = new Capitulo();
        capitulo010201.personagem = Edward;
        capitulo010201.alteracaoEnergia = 90;
        capitulo010201.nome = "\n---------CAPITULO 1.2.1--------\n";
        capitulo010201.texto = 
        "Você gastou "+ capitulo010201.alteracaoEnergia+" de energia para confrontar o suspeito diretamente e tentar fazê-lo confessar."+
        "\nEle se chama João e é o mordomo de Elizabeth." +
        "\nEle nega tudo e se recusa a cooperar." +
        "\nVocê não tem provas suficientes para prendê-lo e ele sai impune.\n";
        capitulo010201.escolha1= null;
        capitulo010201.escolha2= null;


        Capitulo capitulo010202 = new Capitulo();
        capitulo010202.personagem = Edward;
        capitulo010202.alteracaoEnergia = 50;
        capitulo010202.nome = "\n---------CAPITULO 1.2.2--------\n";
        capitulo010202.texto = 
        "Você gastou " + capitulo010202.alteracaoEnergia+" de energia para investigar mais e reunir provas contra João..." +
        "\nÉ um trabalho difícil, mas no final você consegue reunir evidências suficientes para prendê-lo."+
        "\nDescobrindo que ele estava apaixonado por Elizabeth, mas ela não correspondia aos seus sentimentos."+
        "\nAlém disso, Elizabeth estava planejando demiti-lo e ele ficou com raiva."+
        "\nJoão é levado a julgamento e condenado pelo assassinato de Elizabeth.\n";
        capitulo010202.escolha1 = null;
        capitulo010202.escolha2 = null;


        Capitulo capituloFinal1 = new Capitulo();
        capituloFinal1.personagem = Edward;
        capituloFinal1.nome = "\n---------FINAL 1--------\n";
        capituloFinal1.texto = 
        "Você não resolveu o caso do assassinato de Elizabeth e volta para sua vida normal." +
        "\nHá outros casos para resolver e outras aventuras para viver.\n";
        capituloFinal1.escolha1 = null;
        capituloFinal1.escolha2 = null;

        Capitulo capituloFinal2 = new Capitulo();
        capituloFinal2.personagem = Edward;
        capituloFinal2.nome = "\n---------FINAL 2--------\n";
        capituloFinal2.texto = 
        "Você não conseguiu resolver o caso do assassinato de Elizabeth e João sai impune." +
        "\nVoltando para sua vida normal, mas fica com a sensação de que a justiça não foi feita.\n";
        capituloFinal2.escolha1 = null;
        capituloFinal2.escolha2 = null;

        Capitulo capituloFinal3 = new Capitulo();
        capituloFinal3.personagem = Edward;
        capituloFinal3.nome = "\n---------FINAL 3--------\n";
        capituloFinal3.texto = 
        "Você resolveu o caso do assassinato de Elizabeth e prendeu João, o culpado." +
        "\nA justiça foi feita e você é aclamado como um herói por todos.\n";
        capituloFinal3.escolha1 = null;
        capituloFinal3.escolha2 = null;
        
        //começo da história
        while (continua) {
            //toda vez que voltar para o inicio do while as variaveis recebem o valor inicial
            Edward.energia=100;
            int numEscolha = 0;


            if (verifica == false )  {

                capitulo1.mostrar();
                numEscolha = capitulo1.escolher(scan);

            }
            if (numEscolha == 1 || verifica == true ) {
                verifica = true;
                capitulo0102.mostrar();
                numEscolha = capitulo0102.escolher(scan);
              
                //inverti a ordem para não ficar padrão
                if (numEscolha == 2) {
                    capitulo010202.mostrar();
                    capituloFinal3.mostrar();
                    
                    
                    verifica=false;
                    continua = perguntaContinua(scan, continua);

                   
                } else if (numEscolha == 1) {
                    capitulo010201.mostrar();
                    capituloFinal2.mostrar();
                    
                    verifica=false;
                    continua = perguntaContinua(scan, continua);
                   
                } else {
                    msgErro();
                }
                
            } else if (numEscolha == 2) {

                capitulo0101.mostrar();
                capituloFinal1.mostrar();

                continua = perguntaContinua(scan, continua);
            } else {
                msgErro();
                
                
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
 
    private static boolean perguntaContinua(Scanner scan, boolean continua) {

        boolean naoEntendeu = true;

        while (naoEntendeu) {

            System.out.println("\nTentar novamente ou sair?");
            String respostaContinua = resposta(scan);
            if (respostaContinua.equalsIgnoreCase("sair")) {

                continua = false;
                naoEntendeu = false;
            }

            else if (respostaContinua.equalsIgnoreCase("tentar novamente")) {
                continua = true;
                naoEntendeu = false;

            } else {
                msgErro();
            }
        }
        return continua;
    }
}
