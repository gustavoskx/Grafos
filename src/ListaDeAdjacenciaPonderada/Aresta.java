package ListaDeAdjacenciaPonderada;

public class Aresta implements Comparable<Aresta> {
    private Vertice origem;
    private Vertice destino;
    private double peso;

    public Aresta(Vertice origem, Vertice destino, double peso) {
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
    }

    public Vertice getOrigem() {
        return origem;
    }

    public void setOrigem(Vertice origem) {
        this.origem = origem;
    }

    public Vertice getDestino() {
        return destino;
    }

    public void setDestino(Vertice destino) {
        this.destino = destino;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public int compareTo(Aresta outraAresta) {
        return Double.compare(this.peso, outraAresta.peso);
    }

    @Override
    public String toString() {
        return origem + " -> " + destino + " (peso: " + peso + ")";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Aresta aresta = (Aresta) obj;
        return Double.compare(aresta.peso, peso) == 0 &&
                origem.equals(aresta.origem) &&
                destino.equals(aresta.destino);
    }
    
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + origem.hashCode();
        result = 31 * result + destino.hashCode();
        long temp = Double.doubleToLongBits(peso);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}