package ListaDeAdjacencia;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class Graph {
    private HashMap<Node, LinkedList<Node>> map;

    public Graph() {
        map = new HashMap<Node, LinkedList<Node>>();
    }

    public void addEdge(Node value1, Node value2) {

        if (map.containsKey(value1)) {
            map.get(value1).add(value2);
        }else {
            LinkedList<Node> list = new LinkedList<Node>();
            list.add(value2);
            map.put(value1,list);
        }

        if (map.containsKey(value2)) {
            map.get(value2).add(value1);
        }else {
            LinkedList<Node> list = new LinkedList<Node>();
            list.add(value1);
            map.put(value2,list);
        }

    }

    public HashMap<Node, LinkedList<Node>> getMap(){
        return this.map;
    }

    public void printMap() {
        this.map.forEach((k, v) -> {
            System.out.print(k.getValue() + " -> [");
            printList(v);
        });
    }

    public void printList(LinkedList<Node> list) {
        list.forEach((n) -> {System.out.print(n.getValue());});
        System.out.println("]");
    }

    public void bfs(Node node){
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Node> vist = new ArrayList<>();

        queue.add(node);
        vist.add(node);

        while (!queue.isEmpty()) {

            Node w;
            w = queue.poll();
            w.setCor(true);

            for(Node z : map.get(w)) {
                if(!z.isCor()){
                    vist.add(z);
                    z.setCor(true);
                    queue.add(z);
                }
            }
        }

        System.out.print("Ordem de visita bfs: ");
        for(Node n : vist){
            System.out.print(n.getValue() + "->");
            System.out.print(n.isCor() + " ");
        }
        System.out.println();
    }

    private void dfs_visit(Node node, ArrayList<Node> visit) {
        for(Node v : map.get(node)){
            if(!v.isCor()){
                visit.add(v);
                v.setCor(true);
                dfs_visit(v, visit);
            }
        }
    }

    public void dfs(Node node){
        ArrayList<Node> vist = new ArrayList<>();
        vist.add(node);
        node.setCor(true);

        for(Node u : map.get(node)){
            if(!u.isCor()){
                vist.add(u);
                u.setCor(true);
                dfs_visit(u, vist);
            }
        }

        System.out.print("Ordem de visita dfs: ");
        for(Node v : vist){
            System.out.print(v.getValue() + "->");
            System.out.print(v.isCor() +  " ");
        }
        System.out.println();
    }

    public void pintarNodes(){
        for(Node v : getMap().keySet()){
            v.setCor(false);
        }
    }
}
