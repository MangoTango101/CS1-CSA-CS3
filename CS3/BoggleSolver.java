import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class BoggleSolver {
    private static Hashtable d;

    public BoggleSolver(String dictionaryName) {
        new File(dictionaryName);
        Scanner console = new Scanner(dictionaryName);
        d = new Hashtable();

        for(int x = 0; console.hasNext(); ++x) {
            d.put(x, console.next());
        }

    }

    public Iterable<String> getAllValidWords(BoggleBoard board) {
        new ArrayList();
        char[][] boarded = new char[board.rows()][board.cols()];

        for(int x = 0; x < board.rows(); ++x) {
            for(int y = 0; y < board.cols(); ++y) {
                boarded[x][y] = board.getLetter(x, y);
            }
        }

        return boggleSolver(boarded);
    }

    public String recursiveWordSearch(int x, int y, String word, boolean[][] visited, BoggleBoard b) {
        if (!visited[x][y]) {
            visited[x][y] = true;
            word = word + b.getLetter(x, y);
            if (d.contains(word)) {
                return word;
            }

            for(int row = x - 1; row <= x + 1 && row < b.rows(); ++row) {
                for(int col = y - 1; col <= y + 1 && col < b.cols(); ++col) {
                    if (row >= 0 && col >= 0 && !visited[row][col]) {
                        this.recursiveWordSearch(row, col, word, visited, b);
                    }
                }
            }
        }

        char var10000 = word.charAt(word.length() - 1);
        word = "" + var10000;
        visited[x][y] = false;
        return word;
    }

    public static List<String> boggleSolver(char[][] m) {
        if (m == null) {
            throw new NullPointerException("The matrix cannot be null");
        } else {
            List<String> validWords = new ArrayList();

            for(int i = 0; i < m.length; ++i) {
                for(int j = 0; j < m[0].length; ++j) {
                    solve(m, i, j, "" + m[i][j], validWords);
                }
            }

            return validWords;
        }
    }

    private static void solve(char[][] m, int i, int j, String prefix, List<String> validWords) {
        if (m != null && validWords != null) {
            for(int x = Math.max(0, i - 1); x < Math.min(m.length, i + 2); ++x) {
                for(int y = Math.max(0, j - 1); y < Math.min(m[0].length, j + 2); ++y) {
                    if (x != i || y != j) {
                        String word = prefix + m[x][y];
                        if (d.contains(word)) {
                            validWords.add(word);
                            solve(m, x, y, word, validWords);
                        }
                    }
                }
            }
        }

    }

    public int scoreOf(String word) {
        if (!d.contains(word)) {
            return 0;
        } else {
            int wordLength = word.length();
            if (word.contains("qu")) {
                ++wordLength;
            }

            switch (wordLength) {
                case 0:
                case 1:
                case 2:
                    return 0;
                case 3:
                case 4:
                    return 1;
                case 5:
                    return 2;
                case 6:
                    return 3;
                case 7:
                    return 5;
                default:
                    return 11;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("WORKING");
        String PATH = "./data/";
        BoggleBoard board = new BoggleBoard("board-q.txt");
        BoggleSolver solver = new BoggleSolver("dictionary-algs4.txt");
        int totalPoints = 0;

        String s;
        for(Iterator var5 = solver.getAllValidWords(board).iterator(); var5.hasNext(); totalPoints += solver.scoreOf(s)) {
            s = (String)var5.next();
            System.out.println(s + ", points = " + solver.scoreOf(s));
        }

        System.out.println("Score = " + totalPoints);
        new BoggleGame(4, 4);
    }
}