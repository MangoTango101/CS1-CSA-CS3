public class GuitarHero {

    private static final String KEYS = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    private static final double BASE_FREQUENCY = 440.0;
    private static final double FREQUENCY_MULTIPLIER = 1.05956;

    public static void main(String[] args) {

        GuitarString[] guitarStrings = new GuitarString[KEYS.length()];
        for (int i = 0; i < KEYS.length(); i++) {
            double frequency = BASE_FREQUENCY * Math.pow(FREQUENCY_MULTIPLIER, i - 24);
            guitarStrings[i] = new GuitarString(frequency);
        }

        while (true) {

            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int indexOfKey = KEYS.indexOf(key);
                if (indexOfKey != -1) {
                    guitarStrings[indexOfKey].pluck();
                }
            }

            double combinedSample = 0;
            for (GuitarString guitarString : guitarStrings) {
                combinedSample += guitarString.sample();
            }
            StdAudio.play(combinedSample);

            for (GuitarString guitarString : guitarStrings) {
                guitarString.tic();
            }
        }
    }
}
