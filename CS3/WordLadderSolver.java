import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordLadderSolver {

    private Set<String> dictionary;

    public WordLadderSolver() {
        this.dictionary = new HashSet<>();
    }

    public void loadDictionary(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                this.dictionary.add(line.toLowerCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> findWordLadder(String startWord, String endWord) {
        startWord = startWord.toLowerCase();
        endWord = endWord.toLowerCase();

        Queue<List<String>> laddersQueue = initializeQueueWithStartWord(startWord);
        Set<String> usedWords = new HashSet<>(Collections.singletonList(startWord));

        while (!laddersQueue.isEmpty()) {
            List<String> currentLadder = laddersQueue.poll();
            String lastWordInCurrentLadder = getLastWordFromLadder(currentLadder);

            if (lastWordInCurrentLadder.equals(endWord)) {
                return currentLadder;
            }

            for (String adjacentWord : getAdjacentWords(lastWordInCurrentLadder)) {
                if (isWordValidForLadder(adjacentWord, usedWords)) {
                    laddersQueue.offer(createNewLadder(currentLadder, adjacentWord));
                    usedWords.add(adjacentWord);
                }
            }
        }

        return null;
    }

    private Queue<List<String>> initializeQueueWithStartWord(String startWord) {
        Queue<List<String>> laddersQueue = new LinkedList<>();
        laddersQueue.offer(new ArrayList<>(Collections.singletonList(startWord)));
        return laddersQueue;
    }

    private String getLastWordFromLadder(List<String> ladder) {
        return ladder.get(ladder.size() - 1);
    }

    private List<String> getAdjacentWords(String word) {
        List<String> adjacentWords = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (c != word.charAt(i)) {
                    StringBuilder modifiedWord = new StringBuilder(word);
                    modifiedWord.setCharAt(i, c);
                    adjacentWords.add(modifiedWord.toString());
                }
            }
        }

        return adjacentWords;
    }

    private boolean isWordValidForLadder(String word, Set<String> usedWords) {
        return !usedWords.contains(word) && this.dictionary.contains(word);
    }

    private List<String> createNewLadder(List<String> currentLadder, String newWord) {
        List<String> newLadder = new ArrayList<>(currentLadder);
        newLadder.add(newWord);
        return newLadder;
    }
}
