import java.util.*;

public class BinaryMaze {
    public static void main(String[] args) {
        int[][] maze = new int[][] {
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1},
                {0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
        };
        findPath(maze);
    }

    public static int findPath(int[][] maze) {
        int rows = maze.length;
        int cols = maze[0].length;
        maze[rows - 1][cols - 1] = 9;
        Point end = getBFS(0, 0, maze);
        int length = 1;

        while (end != null && end.parent != null) {
            end = end.parent;
            length++;
        }
        System.out.println(length);
        return length;
    }

    private static class Point {
        int row;
        int col;
        Point parent;

        public Point(int row, int col, Point parent) {
            this.row = row;
            this.col = col;
            this.parent = parent;
        }
    }

    public static Queue<Point> queue = new LinkedList<>();

    public static Point getBFS(int startRow, int startCol, int[][] maze) {
        queue.add(new Point(startRow, startCol, null));

        while (!queue.isEmpty()) {
            Point current = queue.remove();

            if (maze[current.row][current.col] == 9) {
                return current;
            }

            if (free(current.row + 1, current.col, maze)) {
                maze[current.row][current.col] = -1;
                Point next = new Point(current.row + 1, current.col, current);
                queue.add(next);
            }

            if (free(current.row - 1, current.col, maze)) {
                maze[current.row][current.col] = -1;
                Point next = new Point(current.row - 1, current.col, current);
                queue.add(next);
            }

            if (free(current.row, current.col + 1, maze)) {
                maze[current.row][current.col] = -1;
                Point next = new Point(current.row, current.col + 1, current);
                queue.add(next);
            }

            if (free(current.row, current.col - 1, maze)) {
                maze[current.row][current.col] = -1;
                Point next = new Point(current.row, current.col - 1, current);
                queue.add(next);
            }
        }
        return null;
    }

    public static boolean free(int row, int col, int[][] maze) {
        int rows = maze.length;
        int cols = maze[0].length;
        return row >= 0 && row < rows && col >= 0 && col < cols && (maze[row][col] == 0 || maze[row][col] == 9);
    }
}
