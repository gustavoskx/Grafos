package ListaDeAdjacenciaPonderada;

public class Vertice {
    private String valor;
    private boolean visitado;
    private Vertice pai;
    private double key;

    public Vertice(String valor) {
        this.valor = valor;
        this.visitado = false;
        this.pai = null;
        this.key = Double.POSITIVE_INFINITY;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public Vertice getPai() {
        return pai;
    }

    public void setPai(Vertice pai) {
        this.pai = pai;
    }

    public double getKey() {
        return key;
    }

    public void setKey(double key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return valor;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vertice vertice = (Vertice) obj;
        return valor.equals(vertice.valor);
    }

    @Override
    public int hashCode() {
        return valor.hashCode();
    }
}
