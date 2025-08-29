import java.util.*;

public class BFS {
    static LinkedList<Integer>[] adj;
    static Queue<Integer> q;
    int V;

    // Constructor to initialize graph
    BFS(int V) {
        this.V = V;
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
        q = new LinkedList<>();
    }

    // Method to add an edge
    public void Edge(int V, int W) {
        adj[V].add(W);
    }

    // BFS method starting from a given node
    public void BFS(int a) { // a = start node
        int x;
        boolean[] nodes = new boolean[V];
        nodes[a] = true;
        q.add(a);

        while (q.size() != 0) {
            a = q.poll();
            System.out.print(a + " ");
            for (int i = 0; i < adj[a].size(); i++) {
                x = adj[a].get(i);
                if (!nodes[x]) {
                    nodes[x] = true;
                    q.add(x);
                }
            }
        }
    }

    // Main method to take user input and run BFS
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking the number of vertices as input
        System.out.print("Enter the number of vertices: ");
        int V = sc.nextInt();

        // Creating graph with V vertices
        BFS g = new BFS(V);

        // Taking the number of edges as input
        System.out.print("Enter the number of edges: ");
        int E = sc.nextInt();

        // Taking edges as input from the user
        System.out.println("Enter the edges (start and end of each edge): ");
        for (int i = 0; i < E; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            g.Edge(start, end); // Adding each edge to the graph
        }

        // Taking the starting node for BFS as input
        System.out.print("Enter the starting node for BFS: ");
        int startNode = sc.nextInt();

        // Performing BFS from the given starting node
        System.out.println("BFS traversal starting from node " + startNode + ":");
        g.BFS(startNode);
    }
}
