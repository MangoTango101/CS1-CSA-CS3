import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BoggleSolver {
    private HashSet<String> dict;

    public BoggleSolver(String name) {
        dict = new HashSet<>();
        try (Scanner sc = new Scanner(new File(name))) {
            while (sc.hasNext()) {
                dict.add(sc.next().toUpperCase());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Iterable<String> getAllValidWords(BoggleBoard b) {
        Set<String> valid = new HashSet<>();
        for (int i = 0; i < b.rows(); i++) {
            for (int j = 0; j < b.cols(); j++) {
                boolean[][] v = new boolean[b.rows()][b.cols()];
                search(b, i, j, v, "", valid);
            }
        }
        return valid;
    }

    private void search(BoggleBoard b, int i, int j, boolean[][] v, String p, Set<String> valid) {
        if (i < 0 || j < 0 || i >= b.rows() || j >= b.cols() || v[i][j])
            return;

        char l = b.getLetter(i, j);
        String w = p + (l == 'Q' ? "QU" : l);

        if (w.length() > 2 && dict.contains(w)) {
            valid.add(w);
        }

        v[i][j] = true;
        for (int di = -1; di <= 1; di++) {
            for (int dj = -1; dj <= 1; dj++) {
                if (di != 0 || dj != 0) {
                    search(b, i + di, j + dj, v, w, valid);
                }
            }
        }
        v[i][j] = false;
    }

    public int scoreOf(String w) {
        if (!dict.contains(w)) return 0;

        switch (w.length()) {
            case 0:
            case 1:
            case 2: return 0;
            case 3:
            case 4: return 1;
            case 5: return 2;
            case 6: return 3;
            case 7: return 5;
            default: return 11;
        }
    }

    public static void main(String[] args) {
        final String P = "./data/";
        BoggleBoard b = new BoggleBoard(P + "board-q.txt");
        BoggleSolver s = new BoggleSolver(P + "dictionary-algs4.txt");

        int total = 0;

        for (String str : s.getAllValidWords(b)) {
            System.out.println(str + ", points = " + s.scoreOf(str));
            total += s.scoreOf(str);
        }

        System.out.println("Score = " + total);
    }
}
