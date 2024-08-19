import java.io.*;
import java.util.*;

public class HuffmanCompressor {
    static void compress(String filename) throws IOException {
        int[] counts = new int[257];
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        int ch;
        while ((ch = reader.read()) != -1) {
            counts[ch]++;
        }
        reader.close();
        counts[256] = 1;
        HuffmanTree tree = new HuffmanTree(counts);
        tree.write(filename + ".code");
        BitOutputStream out = new BitOutputStream(filename + ".short");
        tree.encode(out, filename);
    }

    static void expand(String codeFile, String fileName) throws IOException {
        HuffmanTree tree = new HuffmanTree(codeFile);
        BitInputStream in = new BitInputStream(fileName + ".short");
        tree.decode(in, fileName + ".new");
    }

    public static void main(String[] args) throws IOException {
        String inputFile = "happy hip hop.txt";
        compress(inputFile);
    }
}