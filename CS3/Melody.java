import java.util.*;

public class Melody {
    private Queue<Note> notes;

    public Melody(Queue<Note> song) {
        this.notes = new LinkedList<>(song);
    }

    public double getTotalDuration() {
        return notes.stream()
                .mapToDouble(Note::getDuration)
                .sum();
    }

    public void changeTempo(double tempo) {
        notes.forEach(note -> note.setDuration(note.getDuration() * tempo));
    }

    public void reverse() {
        List<Note> reversedNotes = new ArrayList<>(notes);
        Collections.reverse(reversedNotes);
        notes = new LinkedList<>(reversedNotes);
    }

    public void append(Melody other) {
        notes.addAll(new LinkedList<>(other.getNotes()));
    }

    public void play() {
        Queue<Note> secondaryQueue = new LinkedList<>(notes);

        while (!secondaryQueue.isEmpty()) {
            Note note = secondaryQueue.poll();
            note.play();
            if (note.isRepeat()) {
                secondaryQueue.add(note);
            }
        }
    }

    public Queue<Note> getNotes() {
        return new LinkedList<>(notes);
    }

    @Override
    public String toString() {
        return notes.stream()
                .map(Note::toString)
                .reduce((note1, note2) -> note1 + "\n" + note2)
                .orElse("");
    }
}
