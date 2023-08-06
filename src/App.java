import java.util.Scanner;

public class App {
   
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in, "UTF-8");
        
        Personagem Edward = new Personagem("Edward");

        Capitulo capituloRaiz = new Capitulo(
        Edward,
        0,
        "\n---------CAPITULO 1--------\n",
        "Você é um investigador famoso por resolver casos difíceis." +
        "\nUm dia, você é chamado para investigar o assassinato de uma mulher rica chamada Elizabeth." +
        "\nEla foi encontrada morta em sua mansão e a polícia não tem pistas sobre o assassino." +
        "\nVocê decide investigar o caso e vai até a mansão de Elizabeth." +
        "\nLá, você encontra um enigma escrito em um pedaço de papel." +
        "\nO enigma diz: - O assassino está mais perto do que você imagina!\n",
        scan 
        );
       
        

        Capitulo capitulo0101 = new Capitulo(
        Edward,
        100,
        "\n---------CAPITULO 1.1--------\n",
        "Você decide que é muito difícil resolver o enigma e vai embora." +
        "\nA polícia fica desapontada, mas entende sua decisão." +
        "\nVocê não descobriu a verdade sobre o assassinato de Elizabeth.\n",
        scan);


        Capitulo capitulo0102 = new Capitulo(
        Edward,
                10,
                "\n---------CAPITULO 1.2--------\n",
         "Você descobre que o enigma aponta para um suspeito inesperado. É João, o mordomo de Elizabeth.\n",
                scan);

        Capitulo capitulo010201 = new Capitulo(
        Edward,
                90,
                "\n---------CAPITULO 1.2.1--------\n",
         "Você confronta o suspeito diretamente e tenta fazê-lo confessar." +
         "\nEle se chama João e é o mordomo de Elizabeth." +
         "\nEle nega tudo e se recusa a cooperar." +
         "\nVocê não tem provas suficientes para prendê-lo e ele sai impune.\n",
                scan);

        Capitulo capitulo010202 = new Capitulo(
        Edward,
                50,
                "\n---------CAPITULO 1.2.2--------\n",
        "Você investiga mais e reune provas contra João..." +
        "\nÉ um trabalho difícil, mas no final você consegue reunir evidências suficientes para prendê-lo."+
        "\nDescobrindo que ele estava apaixonado por Elizabeth, mas ela não correspondia aos seus sentimentos."+
        "\nAlém disso, Elizabeth estava planejando demiti-lo e ele ficou com raiva." +
        "\nJoão é levado a julgamento e condenado pelo assassinato de Elizabeth.\n",
                scan);

        Capitulo capituloFinal1 = new Capitulo(
         Edward,
          0,
     "\n---------FINAL 1--------\n",
          "Você não resolveu o caso do assassinato de Elizabeth e volta para sua vida normal." +
          "\nHá outros casos para resolver e outras aventuras para viver.\n",
          scan);

        Capitulo capituloFinal2 = new Capitulo(
          Edward,
          0,
          "\n---------FINAL 2--------\n",
          "Você não conseguiu resolver o caso do assassinato de Elizabeth e João sai impune." +
          "\nVoltando para sua vida normal, mas fica com a sensação de que a justiça não foi feita.\n",
          scan
          );
    
        Capitulo capituloFinal3 = new Capitulo(
            Edward,
          0,
     "\n---------FINAL 3--------\n",
          "Você resolveu o caso do assassinato de Elizabeth e prendeu João, o culpado." +
          "\nA justiça foi feita e você é aclamado como um herói por todos.\n",
          scan 
          );

          capituloRaiz.setEscolha("Tentar decifrar o enigma", capitulo0102);
          capituloRaiz.setEscolha("Ir embora", capitulo0101 );
          capitulo0101.setEscolha("Continuar", capituloFinal1);
          capitulo0102.setEscolha("Confrontar o suspeito diretamente", capitulo010201);
          capitulo0102.setEscolha("Investigar mais para reunir provas", capitulo010202);
          capitulo010201.setEscolha("Continuar", capituloFinal2);
          capitulo010202.setEscolha("Continuar", capituloFinal3);

          try {
            Edward.setEnergia(100);
          } catch (EnergiaException e) {
            System.out.println(e.getMessage());
            return;
          }

          capituloRaiz.executar();

          System.out.println("Tentar novamente?");
          String resposta = scan.nextLine();

          if(resposta.equalsIgnoreCase("Sim")) main(args);
            scan.close();

    }
     
}
