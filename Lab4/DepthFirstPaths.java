import java.util.Arrays;

public class DepthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public DepthFirstPaths(Graph G, int s){
        marked = new boolean[G.nodes.length];
        edgeTo = new int[G.nodes.length];
        this.s = s;
        dfs(G, s);
    }

    public void dfs(Graph G, int v){
        marked[v] = true;
        for (int w : G.nodes[v]){
            if(!marked[w]) {
                dfs(G, w);
                edgeTo[w]=v;
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public int[] pathTo(int v){
        if (!hasPathTo(v))
            return null;

        int[] path = new int[marked.length];
        int p = 0;

        for (int x = v; x != s; x = edgeTo[x])
            path[p++] = x;
        path[p++] = s;

        return Arrays.copyOf(path, p);
    }
}
