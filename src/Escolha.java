public class Escolha {

    private String texto;
    private Capitulo proximo;

    public Capitulo getProximo() {
        return proximo;
    }
    public void setProximo(Capitulo proximo) {  
        this.proximo = proximo;
    }
    public void setTexto(String texto) {
        this.texto = texto;
    }
    public String getTexto() {
        return texto;
    }
    Escolha(String texto, Capitulo proximo){
        this.texto = texto;
        this.proximo = proximo;
    }
}
