import java.util.Queue;
import java.util.*;
public class DFS_Graph{
    static LinkedList<Integer>[]adj;
    static Stack<Integer> s;
    int D;
    DFS_Graph(int D){
        this.D= D;
        adj=new LinkedList[D];
        for(int i=0;i<D;i++){
            adj[i]=new LinkedList<>();
        }
        s=new Stack<>();

    }
    public void  Edge(int D,int W)
    {
        adj[D].add(W);
    }

    public void DFS(int a){
        int x;
        boolean[] nodes = new boolean[D];
        nodes[a] = true;
        s.push(a);
        while (s.size() != 0) {
            a = s.pop();
            System.out.print(a + " ");


            for (int i = 0; i < adj[a].size(); i++) {
                x = adj[a].get(i);
                if (!nodes[x]) {
                    nodes[x] = true;
                    s.add(x);
                }
            }
        }
    }

    public static void main(String[] args) {
        DFS_Graph g=new DFS_Graph(5);
        g.Edge(0,1);
        g.Edge(0,2);
        g.Edge(0,4);
        g.Edge(2,4);
        g.Edge(2,3);
        g.Edge(3,4);
        System.out.println("Element in DFS is as follow:");
        g.DFS(0);


    }

}