import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class lab1 {

    static void printPath(int[] path, ST<Integer, String> names) {
        String s = "Path: ";

        for (int i: path) {

            s += names.get(i) + ", ";

        }
        System.out.println(s);

    }


    public static void main(String[] args) {

        FileInputStream file= null;
        try {
            file = new FileInputStream("test.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
        Scanner sc=new Scanner(file);

        int[] nodes = new int[100];
        ST<String, Integer> numbers = new ST<>(100);
        ST<Integer, String> names = new ST<>(100);
        int n = 0;

        while(sc.hasNextLine())
        {
            String[] line = sc.nextLine().split(" ");

            if (!numbers.contains(line[0]))  {
                numbers.put(line[0], n);
                names.put(n, line[0]);
                n++;
            }

            if (!numbers.contains(line[1]))  {
                numbers.put(line[1], n);
                names.put(n, line[1]);
                n++;
            }
            nodes[numbers.get(line[0])]++;
            nodes[numbers.get(line[1])]++;
        }

        sc.close();

        nodes = Arrays.copyOf(nodes, numbers.size());

        file= null;
        try {
            file = new FileInputStream("test.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
        sc=new Scanner(file);

        Graph graph = new Graph(nodes);

        while(sc.hasNextLine()) {
            String[] line = sc.nextLine().split(" ");
            int v = numbers.get(line[0]);
            int w = numbers.get(line[1]);

            graph.addEdge(v, w);

        }

        sc.close();

        System.out.println(graph.toString());



       DepthFirstPaths rs = new DepthFirstPaths(graph, numbers.get("AL"));
       int y = numbers.get("NY");

        if(rs.hasPathTo(y)) {
            printPath(rs.pathTo(y), names);
        } else {
            System.out.println("no path between");
        }
    }
}
