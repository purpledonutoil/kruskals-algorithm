import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GraphIntegrationTest {

    @Test
    void shouldCalculateCorrectCostForFile1() {
        String path = getClass()
                .getClassLoader()
                .getResource("path/pr3.hrn")
                .getPath();
        Graph graph = new Graph(path);

        graph.findSpanningTree();

        assertEquals(16695, graph.getCost());
    }

    @Test
    void shouldCalculateCorrectCostForFile2() {
        String path = getClass()
                .getClassLoader()
                .getResource("path/SR.hrn")
                .getPath();
        Graph graph = new Graph(path);

        graph.findSpanningTree();

        assertEquals(123, graph.getCost());
    }

    @Test
    void shouldCalculateCorrectCostForFile3() {
        String path = getClass()
                .getClassLoader()
                .getResource("path/TEST_mini.hrn")
                .getPath();
        Graph graph = new Graph(path);

        graph.findSpanningTree();

        assertEquals(52078064, graph.getCost());
    }
}