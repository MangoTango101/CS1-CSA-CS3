public class MyBST {
    private BSTNode root;

    public MyBST() {
        root = null;
    }

    public boolean contains(Integer n) {
        BSTNode current = root;
        while (current != null) {
            if (n.compareTo(current.val) == 0) {
                return true;
            } else if (n.compareTo(current.val) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }

    public void insert(Integer val) {
        root = insertRecursive(root, val);
    }

    private BSTNode insertRecursive(BSTNode root, Integer val) {
        if (root == null) {
            root = new BSTNode(val);
            return root;
        }
        return root;
    }

    public void delete(Integer val) {
        root = deleteRecursive(root, val);
    }

    private BSTNode deleteRecursive(BSTNode root, Integer val) {
        if (root == null) return root;

        if (val < root.val)
            root.left = deleteRecursive(root.left, val);
        else if (val > root.val)
            root.right = deleteRecursive(root.right, val);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.val = minValue(root.right);
            root.right = deleteRecursive(root.right, root.val);
        }

        return root;
    }

    private Integer minValue(BSTNode root) {
        Integer minv = root.val;
        while (root.left != null) {
            minv = root.left.val;
            root = root.left;
        }
        return minv;
    }

    public Integer getMin() {
        return minValue(root);
    }

    public Integer getMax() {
        BSTNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.val;
    }

    public int size() {
        return sizeRecursive(root);
    }

    private int sizeRecursive(BSTNode node) {
        if (node == null) return 0;
        else return(sizeRecursive(node.left) + 1 + sizeRecursive(node.right));
    }

    public void print() {
        printRecursive(root, 0);
    }

    private void printRecursive(BSTNode root, int space) {
        if (root == null) return;

        space += 10;
        printRecursive(root.right, space);
        System.out.print("\n");
        for (int i = 10; i < space; i++)
            System.out.print(" ");
        System.out.print(root.val + "\n");
        printRecursive(root.left, space);
    }

    public void inOrder() {
        inOrderRecursive(root);
    }

    private void inOrderRecursive(BSTNode root) {
        if (root != null) {
            inOrderRecursive(root.left);
            System.out.print(root.val + " ");
            inOrderRecursive(root.right);
        }
    }
}

