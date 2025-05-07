package ListaDeAdjacencia;

public class Node {
    private String value;
    private boolean cor;


    public Node(String value) {
        this.value = value;
        this.cor = false;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isCor(){
        return cor;
    }

    public void setCor(boolean cor){
        this.cor = cor;
    }
}
