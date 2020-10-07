import java.util.Arrays;

public class BreadthFirstPaths
{
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

   public BreadthFirstPaths(Graph G, int s){
       marked = new boolean[G.nodes.length];
       edgeTo = new int[G.nodes.length];
       this.s = s;
       bfs(G, s);
   }

   public void bfs(Graph G, int s){
       marked[s]= true;
       int v=0;
       int[] arr = new int[G.nodes.length];
       arr[0] = s;
       int size = 1;
       while(size!=0 && size<G.nodes.length){
           v = arr[size-1];
           size--;
           for(int w:G.nodes[v]) {
               if(!marked[w]) {
                   edgeTo[w] = v;
                   marked[w] = true;
                   arr[size] = w;
                   size++;
               }
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
