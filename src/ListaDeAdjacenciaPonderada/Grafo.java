package ListaDeAdjacenciaPonderada;

import java.util.*;

public class Grafo {
    private Map<Vertice, List<Aresta>> listaAdjacencia;

    public Grafo() {
        this.listaAdjacencia = new HashMap<>();
    }

    public void adicionarVertice(Vertice vertice) {
        if (!listaAdjacencia.containsKey(vertice)) {
            listaAdjacencia.put(vertice, new ArrayList<>());
        }
    }

    public void adicionarAresta(Vertice origem, Vertice destino, double peso) {
        // Adiciona os vértices se não existirem
        adicionarVertice(origem);
        adicionarVertice(destino);

        // Cria a aresta e adiciona à lista de adjacência (grafo não direcionado)
        Aresta aresta1 = new Aresta(origem, destino, peso);
        Aresta aresta2 = new Aresta(destino, origem, peso);

        listaAdjacencia.get(origem).add(aresta1);
        listaAdjacencia.get(destino).add(aresta2);
    }

    public List<Aresta> getArestas(Vertice vertice) {
        return listaAdjacencia.getOrDefault(vertice, new ArrayList<>());
    }

    public Set<Vertice> getVertices() {
        return listaAdjacencia.keySet();
    }

    public void imprimirGrafo() {
        for (Map.Entry<Vertice, List<Aresta>> entry : listaAdjacencia.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            for (Aresta aresta : entry.getValue()) {
                System.out.print("[" + aresta.getDestino() + ", peso: " + aresta.getPeso() + "] ");
            }
            System.out.println();
        }
    }

    // Algoritmo de Prim para encontrar a árvore geradora mínima
    public List<Aresta> arvoreMinimaPrim() {
        if (listaAdjacencia.isEmpty()) {
            return new ArrayList<>();
        }

        // Lista para armazenar as arestas da árvore geradora mínima
        List<Aresta> arvoreMinima = new ArrayList<>();

        // 1. Para cada vértice u ∈ V[G]
        for (Vertice u : listaAdjacencia.keySet()) {
            // 2. chave[u] = ∞
            u.setKey(Double.POSITIVE_INFINITY);
            // 3. pai[u] = nulo
            u.setPai(null);
        }

        // 4. chave[r] = 0 (r é o vértice raiz/inicial)
        Vertice r = listaAdjacencia.keySet().iterator().next();
        r.setKey(0);

        // 5. Q = V(G) // fila de prioridades com base na chave
        PriorityQueue<Vertice> Q = new PriorityQueue<>(
            (v1, v2) -> Double.compare(v1.getKey(), v2.getKey())
        );
        Q.addAll(listaAdjacencia.keySet());

        // 6. Enquanto Q ≠ ∅
        while (!Q.isEmpty()) {
            // 7. u = dequeue(Q)
            Vertice u = Q.poll();

            // Se o vértice tem um pai, adicionar a aresta à árvore mínima
            if (u.getPai() != null) {
                // Encontrar a aresta entre u e seu pai
                for (Aresta aresta : listaAdjacencia.get(u.getPai())) {
                    if (aresta.getDestino().equals(u)) {
                        arvoreMinima.add(aresta);
                        break;
                    }
                }
            }

            // 8. para cada vértice v ∈ Adj[u]
            for (Aresta aresta : listaAdjacencia.get(u)) {
                Vertice v = aresta.getDestino();
                double w = aresta.getPeso(); // w(u,v) é o peso da aresta

                // 9. se v ∈ Q e w(u,v) < chave[v]
                if (Q.contains(v) && w < v.getKey()) {
                    // 10. pai[v] = u
                    v.setPai(u);
                    // 11. chave[v] = w(u,v)
                    v.setKey(w);

                    // Atualizar a posição do vértice na fila de prioridade
                    // (Remover e adicionar novamente para atualizar a posição)
                    Q.remove(v);
                    Q.add(v);
                }
            }
        }

        return arvoreMinima;
    }

    // Método para imprimir a árvore geradora mínima
    public void imprimirArvoreMinima() {
        List<Aresta> arvoreMinima = arvoreMinimaPrim();

        if (arvoreMinima.isEmpty()) {
            System.out.println("O grafo está vazio ou não é conexo.");
            return;
        }

        System.out.println("Árvore Geradora Mínima (Algoritmo de Prim):");
        double pesoTotal = 0;

        for (Aresta aresta : arvoreMinima) {
            System.out.println(aresta);
            pesoTotal += aresta.getPeso();
        }

        System.out.println("Peso total da árvore: " + pesoTotal);
    }
}
