class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class Main {
    Node node;

    // Function to perform right rotation to convert BST to skewed tree
    public void rightRotate(Node root) {
        while (root != null) {
            if (root.left != null) {
                Node rightMost = root.left;
                while (rightMost.right != null) {
                    rightMost = rightMost.right;
                }

                rightMost.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }

    // Function to print the skewed tree in ascending order
    public void printSkewedTree(Node root) {
        while (root != null) {
            System.out.print(root.data + " ");
            root = root.right;
        }
    }

    public static void main(String[] args) {
        Main tree = new Main();
        tree.node = new Node(10);
        tree.node.left = new Node(55);
        tree.node.right = new Node(30);
        tree.node.left.left = new Node(30);
        tree.node.left.left.right = new Node(60);
        tree.node.right.left = new Node(30);

        // Convert the BST to a skewed tree
        tree.rightRotate(tree.node);

        // Print the skewed tree in ascending order
        tree.printSkewedTree(tree.node);
    }
}