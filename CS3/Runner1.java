import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        WordLadderSolver solver = new WordLadderSolver();
        solver.loadDictionary("dictionary.txt");

        processInputFile(solver, "input.txt");
    }

    private static void processInputFile(WordLadderSolver solver, String inputFileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ");
                List<String> wordLadder = solver.findWordLadder(words[0], words[1]);
                printWordLadderResult(words[0], words[1], wordLadder);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printWordLadderResult(String startWord, String endWord, List<String> wordLadder) {
        if (wordLadder != null) {
            System.out.print("Found a ladder! >>> [");
            for (int i = 0; i < wordLadder.size(); i++) {
                System.out.print(wordLadder.get(i));
                if (i < wordLadder.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        } else {
            System.out.println("No ladder between " + startWord + " and " + endWord);
        }
    }
}
