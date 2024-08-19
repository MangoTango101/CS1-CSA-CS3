import java.util.*;

public class ChildsPlay {
    static ArrayList<Integer>[] graph, reversed;
    static int[] visited, components;
    static Vector<Integer> order = new Vector<>();

    static void dfs1(int vertex) {
        visited[vertex] = 1;
        for (int neighbor : graph[vertex]) {
            if (visited[neighbor] == 0) {
                dfs1(neighbor);
            }
        }
        order.add(vertex);
    }

    static void dfs2(int vertex, int number) {
        components[vertex] = number;
        for (int neighbor : reversed[vertex]) {
            if (components[neighbor] == -1) {
                dfs2(neighbor, number);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vertices = scanner.nextInt();
        int edges = scanner.nextInt();

        graph = new ArrayList[vertices + 1];
        reversed = new ArrayList[vertices + 1];
        for (int i = 0; i <= vertices; i++) {
            graph[i] = new ArrayList<>();
            reversed[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            graph[source].add(destination);
            reversed[destination].add(source);
        }

        visited = new int[vertices + 1];
        components = new int[vertices + 1];
        Arrays.fill(components, -1);

        for (int i = 1; i <= vertices; i++) {
            if (visited[i] == 0) {
                dfs1(i);
            }
        }

        int count = 0;
        for (int i = vertices; i >= 1; i--) {
            int vertex = order.get(vertices - i);
            if (components[vertex] == -1) {
                dfs2(vertex, count++);
            }
        }

        boolean[] source = new boolean[count];
        Arrays.fill(source, true);

        for (int i = 1; i < graph.length; i++) {
            for (int neighbor : graph[i]) {
                if (components[i] != components[neighbor]) {
                    source[components[neighbor]] = false;
                }
            }
        }

        int sources = 0;
        for (boolean isSource : source) {
            if (isSource) {
                sources++;
            }
        }

        System.out.println(sources);
        scanner.close();
    }
}
