import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class LivroJogoController {
    
    @FXML
    private AnchorPane buttonContainer;

    @FXML
    private Button botaoIniciar;

    @FXML
    private ButtonBar campoEscolhas;

    @FXML
    private Label textoCapitulo;

    @FXML
    private Label campoImagem;
    
    Scanner scan = new Scanner(System.in, "UTF-8");
    LeitorCarregador leitorCarregador = new LeitorCarregador();
    HashMap<String, Personagem> personagens = leitorCarregador.lerPersonagens("rsc/personagens.txt");
    HashMap<String, Capitulo> capitulosMap = leitorCarregador.lerCapitulos("rsc/capitulos.txt", personagens, scan);
    File dados = new File("rsc/progresso.save");

    @FXML
    void initialize() {
        criaBotao();
    }
    


    @FXML
    void iniciarNovoJogo(ActionEvent event) {
        desativaBotao();
        Capitulo raiz = capitulosMap.get("CAPITULO_IMAGEM 1");
        dados.delete();
        mostrar(raiz);
        
        
    }
    @FXML
    void carregarJogo(ActionEvent event) {
        desativaBotao();
        Personagem personagemTemp = leitorCarregador.getPersonagemTemp(personagens);
        Capitulo capituloTemp = capitulosMap.get(personagemTemp.getProgresso());
        mostrar(capituloTemp);
    }



    private void desativaBotao() {
        botaoIniciar.setVisible(false);
        buttonContainer.setVisible(false);
    }

    
    private void mostrar(Capitulo capitulo){

        
        boolean isCapImagem = capitulo instanceof CapituloImagem;
        if(isCapImagem){
            CapituloImagem capituloImagem = (CapituloImagem) capitulo;
            this.campoImagem.setText(capituloImagem.getImagem());
            this.textoCapitulo.setText(capituloImagem.getTexto());
        }
        else{
            this.textoCapitulo.setText(capitulo.getTexto());
        }
        
        for (Escolha escolha : capitulo.getEscolhas()) {
            Button botao = new Button(escolha.getTexto());
            botao.setPrefWidth(234);
            botao.setPrefHeight(40);
            botao.focusTraversableProperty().setValue(false);
            this.campoEscolhas.getButtons().add(botao);
            
           botao.setOnAction(new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent event) {
                   campoEscolhas.getButtons().clear();
                   campoImagem.setText("");
                mostrar(escolha.getProximo());
                capitulo.salvaProgresso(escolha.getNextCapituloNome());
               }
            });
        
        }
    }
   

    private void criaBotao() {
        if (dados.exists()) {
            Button botao = new Button("Continuar Jogo");
            botao.setPrefWidth(234); 
            botao.setPrefHeight(60);
            botao.focusTraversableProperty().setValue(false);
            botao.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    carregarJogo(event);
                }
            });
            this.buttonContainer.getChildren().add(botao);
            buttonContainer.requestLayout();
        }
        }
    
}
