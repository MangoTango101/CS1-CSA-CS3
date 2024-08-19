import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Maze {
    private int row, col;
    private Square[][] maze;
    private Square start, end;

    public Maze() {
    }

    public boolean loadMaze(String fileName) {
        Scanner scanner;
        try {
            scanner = new Scanner(new File(fileName));
        } catch (Exception e) {
            System.out.println("File not found. Please check the file path.");
            return false;
        }

        row = scanner.nextInt();
        col = scanner.nextInt();
        initializeMaze(scanner);

        return true;
    }

    private void initializeMaze(Scanner scanner) {
        maze = new Square[row][col];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                int type = scanner.nextInt();
                maze[r][c] = new Square(r, c, type);

                if (type == 2) {
                    start = maze[r][c];
                } else if (type == 3) {
                    end = maze[r][c];
                }
            }
        }
    }

    public List<Square> getNeighbors(Square square) {
        List<Square> neighbors = new ArrayList<>();
        int r = square.getRow();
        int c = square.getCol();

        addNeighborIfValid(neighbors, r + 1, c);
        addNeighborIfValid(neighbors, r - 1, c);
        addNeighborIfValid(neighbors, r, c + 1);
        addNeighborIfValid(neighbors, r, c - 1);

        return neighbors;
    }

    private void addNeighborIfValid(List<Square> neighbors, int r, int c) {
        if (isValidPosition(r, c) && maze[r][c].getType() != 1) {
            neighbors.add(maze[r][c]);
        }
    }

    private boolean isValidPosition(int r, int c) {
        return r >= 0 && r < row && c >= 0 && c < col;
    }

    public Square getStart() {
        return start;
    }

    public Square getEnd() {
        return end;
    }

    public void reset() {
        for (Square[] rowArray : maze) {
            for (Square square : rowArray) {
                square.setStatus(' ');
            }
        }
    }

    public Square getSquare(int r, int c) {
        return maze[r][c];
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Square[] rowArray : maze) {
            for (Square square : rowArray) {
                stringBuilder.append(square).append(" ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
