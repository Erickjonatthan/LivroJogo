import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;

public class LivroJogoController {

    @FXML
    private Button botaoCarregar;

    @FXML
    private Label textoCapitulo;

    @FXML
    private ButtonBar campoEscolhas;

    @FXML
    void carregarJogo(ActionEvent event) {
        this.botaoCarregar.setVisible(false);

        Scanner scan = new Scanner(System.in, "UTF-8");
        LeitorCarregador leitorCarregador = new LeitorCarregador();
        HashMap<String, Personagem> personagens = leitorCarregador.lerPersonagens("rsc/personagens.txt");
        HashMap<String, Capitulo> capitulosMap = leitorCarregador.lerCapitulos("rsc/capitulos.txt", personagens, scan);
        File dados = new File("rsc/progresso.save");


        if (dados.exists()) {
            Personagem personagemTemp = leitorCarregador.getPersonagemTemp(personagens);
            Capitulo capituloTemp = capitulosMap.get(personagemTemp.getProgresso());
            mostrar(capituloTemp);

        } else {
           Capitulo raiz = capitulosMap.get("CAPITULO_IMAGEM 1");
           mostrar(raiz);

        }
    }

    private void mostrar(Capitulo capitulo){

        
        boolean isCapImagem = capitulo instanceof CapituloImagem;
        if(isCapImagem){
            CapituloImagem capituloImagem = (CapituloImagem) capitulo;
        
            this.textoCapitulo.setText(
                capituloImagem.getImagem() +
                capituloImagem.getTexto() +
                "\n\n" +
                capituloImagem.getMsg()

                );
        }
        else{
            this.textoCapitulo.setText(capitulo.getTexto());
        }
    
        for (Escolha escolha : capitulo.getEscolhas()) {
            Button botao = new Button(escolha.getTexto());
            this.campoEscolhas.getButtons().add(botao);
            
           botao.setOnAction(new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent event) {
                campoEscolhas.getButtons().clear();
                mostrar(escolha.getProximo());
                capitulo.salvaProgresso(escolha.getNextCapituloNome());
               }
           });
           

      
         }
    }

}
