package ListaDeAdjacencia;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Graph grafo = new Graph();
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        grafo.addEdge(nodeA, nodeB);
        grafo.addEdge(nodeB, nodeC);
        grafo.addEdge(nodeA, nodeC);
        grafo.printMap();
    }
}