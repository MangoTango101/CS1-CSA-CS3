import java.util.List;
import java.util.ArrayList;

public class Vertex implements Comparable<Vertex> {
    public int x, y, ID;
    public List<Integer> edges;
    public boolean visited;
    public double distance;

    public Vertex(int x, int y, int ID) {
        this.x = x;
        this.y = y;
        this.ID = ID;
        this.edges = new ArrayList<>();
        this.visited = false;
        this.distance = Double.POSITIVE_INFINITY;
    }

    public double calculateEuclideanDistanceTo(Vertex other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }

    @Override
    public String toString() {
        return "Vertex{" + "ID=" + ID + ", x=" + x + ", y=" + y + ", distance=" + distance + '}';
    }

    @Override
    public int compareTo(Vertex other) {
        return Double.compare(this.distance, other.distance);
    }
}
