package ListaDeAdjacenciaPonderada;

public class Main {
    public static void main(String[] args) {
        // Criar um grafo ponderado
        Grafo grafo = new Grafo();
        
        // Criar vértices
        Vertice a = new Vertice("A");
        Vertice b = new Vertice("B");
        Vertice c = new Vertice("C");
        Vertice d = new Vertice("D");
        Vertice e = new Vertice("E");
        
        // Adicionar arestas com pesos
        grafo.adicionarAresta(a, b, 2.0);
        grafo.adicionarAresta(a, c, 3.0);
        grafo.adicionarAresta(b, c, 1.0);
        grafo.adicionarAresta(b, d, 1.5);
        grafo.adicionarAresta(c, d, 2.0);
        grafo.adicionarAresta(c, e, 4.0);
        grafo.adicionarAresta(d, e, 3.0);
        
        // Imprimir o grafo
        System.out.println("Grafo Ponderado (Lista de Adjacência):");
        grafo.imprimirGrafo();
        
        // Encontrar e imprimir a árvore geradora mínima usando o algoritmo de Prim
        System.out.println("\nExecutando o algoritmo de Prim para encontrar a árvore geradora mínima:");
        grafo.imprimirArvoreMinima();
        
        // Exemplo de grafo maior para testar o algoritmo de Prim
        System.out.println("\n\nExemplo com um grafo maior:");
        Grafo grafoMaior = new Grafo();
        
        Vertice v1 = new Vertice("1");
        Vertice v2 = new Vertice("2");
        Vertice v3 = new Vertice("3");
        Vertice v4 = new Vertice("4");
        Vertice v5 = new Vertice("5");
        Vertice v6 = new Vertice("6");
        
        grafoMaior.adicionarAresta(v1, v2, 6.0);
        grafoMaior.adicionarAresta(v1, v3, 1.0);
        grafoMaior.adicionarAresta(v1, v4, 5.0);
        grafoMaior.adicionarAresta(v2, v3, 5.0);
        grafoMaior.adicionarAresta(v2, v5, 3.0);
        grafoMaior.adicionarAresta(v3, v4, 5.0);
        grafoMaior.adicionarAresta(v3, v5, 6.0);
        grafoMaior.adicionarAresta(v3, v6, 4.0);
        grafoMaior.adicionarAresta(v4, v6, 2.0);
        grafoMaior.adicionarAresta(v5, v6, 6.0);
        
        grafoMaior.imprimirGrafo();
        grafoMaior.imprimirArvoreMinima();
    }
}