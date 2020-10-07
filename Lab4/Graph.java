public class Graph{
    private int[] p;
    public int[][] nodes;


    public Graph(int[] n_size) {

        p = new int[n_size.length];
        nodes = new int[n_size.length][];

        for (int i = 0; i < n_size.length; i++) {
            nodes[i] = new int[n_size[i]];
        }
    }

    public void addEdge(int v, int w){
        nodes[v][p[v]++] = w;
        nodes[w][p[w]++] = v;
    }

    public void addEdge_direction(int v, int w){
        nodes[v][p[v]++] = w;
    }

    public String toString(){
        String s = "Graph {\n";

        for (int i = 0; i < nodes.length; i++){
            s += i + ": {";
            for (int j = 0; j < nodes[i].length; j++) {
                s += nodes[i][j] + ",";
            }
            s += "}\n";
        }

        s += "}";

        return s;

    }
}
