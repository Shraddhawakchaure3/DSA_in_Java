import java.util.*;
public class BFSGraph {
    static LinkedList<Integer>[] adj;
    static Queue<Integer> q;
    int V;
    BFSGraph(int V){
        this.V= V;
        adj=new LinkedList[V];
        for(int i=0;i<V;i++){
            adj[i]=new LinkedList<>();
        }
        q=new LinkedList<>();
    }
    public void  Edge(int V,int W)
    {
        adj[V].add(W);
    }
    public void BFS(int a) {
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
    public static void main(String[] args) {
        BFSGraph g=new BFSGraph(5);
        g.Edge(0,1);
        g.Edge(0,2);
        g.Edge(0,4);
        g.Edge(2,4);
        g.Edge(2,3);
        g.Edge(3,4);
        g.BFS(0);
    }
}