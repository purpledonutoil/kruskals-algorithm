import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Graph {
    private final String fileName;
    private final List<int[]> list;
    private final Map<Integer, Integer> k;
    private final List<int[]> result;
    private final Map<Integer, List<Integer>> groups;
    private final int MAX_COUNT;
    private int cost;

    public Graph(String fileName) {
        this.fileName = fileName;
        this.list = new ArrayList<>();
        this.k = new HashMap<>();
        this.result = new ArrayList<>();
        this.readFile();
        this.MAX_COUNT = k.size() - 1;
        this.cost = 0;

        this.groups = new HashMap<>();

        for (Map.Entry<Integer, Integer> entry : k.entrySet()) {
            int vertex = entry.getKey();
            groups.computeIfAbsent(vertex, v -> new ArrayList<>()).add(vertex);
        }
    }

    public int getCost() {
        return cost;
    }


    public void findSpanningTree() {
        Comparator<int[]> comp = Comparator.comparing(arr -> arr[2]);
        list.sort(comp);
        int count = 0;

        while (count != MAX_COUNT && !list.isEmpty()) {
            int[] edge = list.removeLast();

            int u = edge[0];
            int v = edge[1];
            int c = edge[2];

            int ku = k.get(u);
            int kv = k.get(v);

            if (ku != kv) {
                count++;
                this.cost += c;
                result.add(new int[]{u, v});

                int kmin = Math.min(ku, kv);
                int kmax = Math.max(ku, kv);

                for (Integer key : groups.get(k.get(kmax))) {
                    k.put(key, kmin);
                }
                groups.get(kmin).addAll(groups.get(kmax));
                groups.remove(kmax);
            }
        }
    }

    public void readFile() {
        int u, v, c;

        try {
            Scanner sc = new Scanner(new FileInputStream(fileName));

            while (sc.hasNext()) {
                u = sc.nextInt();
                v = sc.nextInt();
                c = sc.nextInt();

                list.add(new int[]{u, v, c});

                k.put(u, u);
                k.put(v, v);


            }

            sc.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void print() {
        System.out.print("(");
        if (result != null) {
            for (int[] vertices : result) {
                System.out.print("{" + vertices[0] + ", " + vertices[1] + "}");
                if (vertices != result.getLast()) {
                    System.out.print(", ");
                }
            }
        }
        System.out.println(")");
        System.out.println("Price: " + cost);
    }
}
