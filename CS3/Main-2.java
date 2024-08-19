import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(new File("grid10x10.txt"))) {
            Graph graph = new Graph(input);
            Dijkstra dijkstra = new Dijkstra(graph);
            int source = input.nextInt();
            int destination = input.nextInt();
            dijkstra.dijkstra(source);
            double distance = dijkstra.getDistance(destination);
            System.out.println("Shortest path from " + source + " to " + destination + " is " + distance);
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
