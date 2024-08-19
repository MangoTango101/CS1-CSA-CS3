import java.util.Scanner;

public class Graph {
    public int V, E;
    public Vertex[] vertices;

    public Graph(Scanner scanner) {
        V = scanner.nextInt();
        E = scanner.nextInt();
        vertices = new Vertex[V];

        for (int i = 0; i < V; i++) {
            int id = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            vertices[id] = new Vertex(x, y, id);
        }

        for (int i = 0; i < E; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            vertices[from].edges.add(to);
        }
    }

    public double distance(int from, int to) {
        return vertices[from].calculateEuclideanDistanceTo(vertices[to]);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Vertex vertex : vertices) {
            sb.append(vertex.toString()).append("\n");
        }
        return sb.toString();
    }
}
