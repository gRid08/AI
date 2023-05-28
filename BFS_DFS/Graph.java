
/* Implement depth first search algorithm and Breadth First Search algorithm, Use an undirected
graph and develop a recursive algorithm for searching all the vertices of a graph or tree data
structure.  */

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;


public class Graph {

  int v;
  int e;
  int[][] adj;
  Queue<Integer> q = new ArrayDeque<>();

  Graph(int v1, int e1) {
    this.v = v1;
    this.e = e1;
    adj = new int[v][v];
    for (int row = 0; row < v; row++) {
      adj[row] = new int[v];
      for (int col = 0; col < v; col++) {
        adj[row][col] = 0;
      }
    }
  }

  public void add_edge(int start, int end) {
    adj[start][end] = 1;
    adj[end][start] = 1;
  }

  public void DFS(int start, boolean[] visited) {
    System.out.print(start + " ");
    visited[start] = true;
    for (int i = 0; i < v; i++) {
      if ((adj[start][i] == 1) && (!visited[i])) {
        DFS(i, visited);
      }
    }
  }

  public void BFS_recursive(boolean[] visited) {
    if(q.isEmpty())
      return;

    int vis = q.remove();
    visited[vis] = true;
    System.out.print(vis + " ");



    for (int i = 0; i < v; i++) {
      if ((adj[vis][i] == 1) && (!visited[i])) {
        q.add(i);
        visited[i] = true;
      }
    }
    BFS_recursive(visited);

  }

  public void BFS(int start, boolean[] visited){
    q.add(start);

    BFS_recursive(visited);
  }

  public static void main(String[] args) {
    int v = 8;
    int e = 8;

    Graph graph = new Graph(v, e);
    graph.add_edge(0, 1);
    graph.add_edge(0, 2);
    graph.add_edge(1, 3);
    graph.add_edge(2, 4);
    graph.add_edge(2, 6);
    graph.add_edge(6, 7);
    graph.add_edge(3, 5);
    graph.add_edge(5, 4);

    boolean[] visited = new boolean[v];
    Arrays.fill(visited, false);
    Scanner sc = new Scanner(System.in);
    int ch;
    do{
      System.out.println("\n1.BFS\n2.DFS\n3.Exit");
      System.out.print("Enter choice: ");
      ch = sc.nextInt();
      switch (ch){
        case 1: graph.BFS(0, visited);
          Arrays.fill(visited, false);
          break;
        case 2: graph.DFS(0, visited);
          Arrays.fill(visited, false);
          break;
      }
    }while(ch!=3);
  }
}
