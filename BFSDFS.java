import java.util.*;

class Graph {
    private int V;
    private LinkedList<Integer>[] adjList;

    Graph(int V) {
        this.V = V;
        adjList = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    void addEdge(int src, int dest) {
        adjList[src].add(dest);
    }

    void BFS(int start) {
        boolean[] visited = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (int neighbor : adjList[vertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    void DFS(int start) {
        boolean[] visited = new boolean[V];
        DFSUtil(start, visited);
    }

    void DFSUtil(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int neighbor : adjList[vertex]) {
            if (!visited[neighbor]) {
                DFSUtil(neighbor, visited);
            }
        }
    }
}

public class BFSDFS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of nodes: ");
        int V = scanner.nextInt();
        Graph graph = new Graph(V);

        for (int i = 0; i < V; i++) {
            System.out.print("Enter the neighbors of node " + i + " (space-separated, -1 to stop): ");
            int neighbor = scanner.nextInt();
            while (neighbor != -1) {
                graph.addEdge(i, neighbor);
                neighbor = scanner.nextInt();
            }
        }

        System.out.print("Enter the starting node: ");
        int startNode = scanner.nextInt();

        System.out.println("\nBFS Traversal:");
        graph.BFS(startNode);

        System.out.println("\n\nDFS Traversal:");
        graph.DFS(startNode);

        scanner.close();
    }
}
