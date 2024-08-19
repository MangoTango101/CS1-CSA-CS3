import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    char ch;
    int freq;
    Node left, right;

    Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }

    public int compareTo(Node n) {
        return this.freq - n.freq;
    }

    public String toString() {
        return (ch == '*') ? freq + "" : ch + "";
    }
}

public class HuffmanTree {
    Node root;
    Map<Character, String> codes = new HashMap<>();

    HuffmanTree(int[] counts) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (char ch = 0; ch < counts.length; ch++) {
            if (counts[ch] > 0) {
                pq.add(new Node(ch, counts[ch]));
            }
        }

        if (pq.size() == 1) {
            root = pq.poll();
            return;
        }

        pq.add(new Node('*', 1));
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            Node parent = new Node('*', left.freq + right.freq);
            parent.left = left;
            parent.right = right;
            pq.add(parent);
        }
        root = pq.poll();
        buildCodes(root, "");
    }

    private void buildCodes(Node node, String code) {
        if (node.left == null && node.right == null) {
            codes.put(node.ch, code);
            return;
        }
        buildCodes(node.left, code + "0");
        buildCodes(node.right, code + "1");
    }

    void write(String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for (Character ch : codes.keySet()) {
            writer.write(((int) ch) + "\n");
            writer.write(codes.get(ch) + "\n");
        }
        writer.close();
    }

    void encode(BitOutputStream out, String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        int ch;
        while ((ch = reader.read()) != -1) {
            String code = codes.get((char) ch);
            for (int i = 0; i < code.length(); i++) {
                out.writeBit(code.charAt(i) - '0');
            }
        }
        reader.close();
        String endCode = codes.get('*');
        for (int i = 0; i < endCode.length(); i++) {
            out.writeBit(endCode.charAt(i) - '0');
        }
        out.close();
    }

    HuffmanTree(String codeFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(codeFile));
        String line;
        while ((line = reader.readLine()) != null) {
            int ch = Integer.parseInt(line);
            String code = reader.readLine();
            codes.put((char) ch, code);
        }
        reader.close();
        buildTree();
    }

    private void buildTree() {
        Node temp = null;
        for (Character ch : codes.keySet()) {
            String code = codes.get(ch);
            Node curr = null;
            if (temp == null) {
                temp = new Node('*', 0);
                curr = temp;
            } else {
                curr = temp;
            }
            for (int i = 0; i < code.length(); i++) {
                if (code.charAt(i) == '0') {
                    if (curr.left == null) {
                        curr.left = new Node('*', 0);
                    }
                    curr = curr.left;
                } else {
                    if (curr.right == null) {
                        curr.right = new Node('*', 0);
                    }
                    curr = curr.right;
                }
                if (i == code.length() - 1) {
                    curr.ch = ch;
                }
            }
        }
        root = temp;
    }

    void decode(BitInputStream in, String outFile) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
        Node curr = root;
        int bit;
        while ((bit = in.readBit()) != -1) {
            if (bit == 0) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
            if (curr.left == null && curr.right == null) {
                if (curr.ch == '*') {
                    break;
                }
                writer.write(curr.ch);
                curr = root;
            }
        }
        writer.close();
        in.close();
    }
}
