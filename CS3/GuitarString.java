public class GuitarString {
    private static final int SAMPLING_RATE = 44100;
    private static final double DECAY_FACTOR = 0.996;

    private RingBuffer buffer;
    private int ticCounter;

    public GuitarString(double frequency) {
        int capacity = (int) Math.ceil(SAMPLING_RATE / frequency);
        buffer = new RingBuffer(capacity);
        for (int i = 0; i < capacity; i++) {
            buffer.enqueue(0.0);
        }
    }

    public GuitarString(double[] init) {
        buffer = new RingBuffer(init.length);
        for (double v : init) {
            buffer.enqueue(v);
        }
    }

    public void pluck() {
        int length = buffer.size();
        for (int i = 0; i < length; i++) {
            buffer.dequeue();
        }
        for (int i = 0; i < length; i++) {
            buffer.enqueue(Math.random() - 0.5);
        }
    }

    public void tic() {
        double firstSample = buffer.dequeue();
        double nextSample = buffer.peek();
        double newSample = DECAY_FACTOR * 0.5 * (firstSample + nextSample);
        buffer.enqueue(newSample);
        ticCounter++;
    }

    public double sample() {
        if (buffer.isEmpty()) {
            return 0.0;
        }
        return buffer.peek();
    }

    public int time() {
        return ticCounter;
    }

    public static void main(String[] args) {
        int N = 25;
        double[] samples = {.2, .4, .5, .3, -.2, .4, .3, .0, -.1, -.3};
        GuitarString testString = new GuitarString(samples);
        for (int i = 0; i < N; i++) {
            int t = testString.time();
            double sample = testString.sample();
            System.out.printf("%6d %8.4f\n", t, sample);
            testString.tic();
        }
    }
}
