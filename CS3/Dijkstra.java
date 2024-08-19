import java.util.PriorityQueue;

public class Dijkstra {
    private Graph graph;

    public Dijkstra(Graph graph) {
        this.graph = graph;
    }

    public void dijkstra(int source) {
        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        graph.vertices[source].distance = 0;
        queue.add(graph.vertices[source]);

        while (!queue.isEmpty()) {
            Vertex u = queue.poll();
            if (!u.visited) {
                u.visited = true;
                for (int edge : u.edges) {
                    Vertex v = graph.vertices[edge];
                    double weight = graph.distance(u.ID, v.ID);
                    double distanceThroughU = u.distance + weight;
                    if (distanceThroughU < v.distance) {
                        v.distance = distanceThroughU;
                        queue.add(v);
                    }
                }
            }
        }
    }

    public double getDistance(int destination) {
        return graph.vertices[destination].distance;
    }
}
