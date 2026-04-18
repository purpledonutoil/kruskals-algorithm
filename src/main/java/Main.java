public class Main {
    public static void main(String[] args) {
        String filename1 = "src/main/resources/path/pr3.hrn";
        String filename2 = "src/main/resources/path/SR.hrn";
        String filename3 = "src/main/resources/path/TEST_mini.hrn";
        Graph graph = new Graph(filename3);
        graph.findSpanningTree();
        graph.print();
    }
}
