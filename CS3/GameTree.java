import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GameTree {
	private TreeNode root;
	private TreeNode current;

	// Inner class for TreeNodes
	private class TreeNode {
		String data;
		TreeNode left;
		TreeNode right;

		TreeNode(String data) {
			this.data = data;
		}
	}

	public GameTree(String fileName) {
		try {
			Scanner scanner = new Scanner(new File(fileName));
			root = buildTree(scanner);
			current = root;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private TreeNode buildTree(Scanner scanner) {
		if (!scanner.hasNextLine()) return null;

		String line = scanner.nextLine().trim();
		TreeNode node = new TreeNode(line);

		if (line.endsWith("?")) {
			node.left = buildTree(scanner);  // Yes answer subtree
			node.right = buildTree(scanner); // No answer subtree
		}

		return node;
	}

	public void add(String newQ, String newA) {
		if (current != null && !current.data.endsWith("?")) {
			TreeNode newQuestionNode = new TreeNode(newQ);
			newQuestionNode.left = new TreeNode(newA);
			newQuestionNode.right = current;

			// Replace current node with new question node
			replaceCurrentWithNewNode(newQuestionNode);
			current = root; // Reset current to root
		}
	}

	private void replaceCurrentWithNewNode(TreeNode newNode) {
		if (current == root) {
			root = newNode;
		} else {
			TreeNode parent = findParent(root, current);
			if (parent.left == current) {
				parent.left = newNode;
			} else {
				parent.right = newNode;
			}
		}
	}

	private TreeNode findParent(TreeNode node, TreeNode child) {
		if (node == null || node == child) return null;
		if (node.left == child || node.right == child) return node;
		TreeNode leftSearch = findParent(node.left, child);
		if (leftSearch != null) return leftSearch;
		return findParent(node.right, child);
	}

	public boolean foundAnswer() {
		return current != null && !current.data.endsWith("?");
	}

	public String getCurrent() {
		return current != null ? current.data : null;
	}

	public void playerSelected(Choice yesOrNo) {
		if (current != null && current.data.endsWith("?")) {
			current = yesOrNo == Choice.Yes ? current.left : current.right;
		}
	}

	public void reStart() {
		current = root;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		toStringHelper(root, "", builder);
		return builder.toString();
	}

	private void toStringHelper(TreeNode node, String prefix, StringBuilder builder) {
		if (node == null) return;
		toStringHelper(node.right, prefix + "- ", builder);
		builder.append(prefix).append(node.data).append("\n");
		toStringHelper(node.left, prefix + "- ", builder);
	}

	public void saveGame() {
		try {
			PrintWriter writer = new PrintWriter(new File("saved_game.txt"));
			saveGameHelper(root, writer);
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void saveGameHelper(TreeNode node, PrintWriter writer) {
		if (node == null) return;
		writer.println(node.data);
		saveGameHelper(node.left, writer);
		saveGameHelper(node.right, writer);
	}
}
