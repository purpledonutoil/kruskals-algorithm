import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        String path1 = Objects.requireNonNull(Main.class
                        .getClassLoader()
                        .getResource("path/TEST_mini.hrn"))
                .getPath();
        String path2 = Objects.requireNonNull(Main.class
                        .getClassLoader()
                        .getResource("path/pr3.hrn"))
                .getPath();
        String path3 = Objects.requireNonNull(Main.class
                        .getClassLoader()
                        .getResource("path/SR.hrn"))
                .getPath();
        Graph graph = new Graph(path2);
        graph.findSpanningTree();
        graph.print();
    }
}
