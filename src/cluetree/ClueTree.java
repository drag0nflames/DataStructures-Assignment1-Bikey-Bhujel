package cluetree;

public class ClueTree {
    // Inner Node class for binary tree
    private static class Node {
        String clue;
        Node left;
        Node right;

        Node(String clue) {
            this.clue = clue;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    // Insert a new clue into the binary tree
    public void insert(String clue) {
        root = insertRec(root, clue);
    }

    private Node insertRec(Node root, String clue) {
        if (root == null) {
            root = new Node(clue);
            return root;
        }
        if (clue.compareTo(root.clue) < 0) {
            root.left = insertRec(root.left, clue);
        } else if (clue.compareTo(root.clue) > 0) {
            root.right = insertRec(root.right, clue);
        }
        return root;
    }

    // Perform in-order traversal
    public void inOrderTraversal() {
        System.out.print("In-order traversal: ");
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.clue + " ");
            inOrderRec(root.right);
        }
    }

    // Perform pre-order traversal
    public void preOrderTraversal() {
        System.out.print("Pre-order traversal: ");
        preOrderRec(root);
        System.out.println();
    }

    private void preOrderRec(Node root) {
        if (root != null) {
            System.out.print(root.clue + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    // Perform post-order traversal
    public void postOrderTraversal() {
        System.out.print("Post-order traversal: ");
        postOrderRec(root);
        System.out.println();
    }

    private void postOrderRec(Node root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(root.clue + " ");
        }
    }

    // Find a specific clue in the tree
    public boolean findClue(String clue) {
        return findClueRec(root, clue);
    }

    private boolean findClueRec(Node root, String clue) {
        if (root == null) {
            return false;
        }
        if (root.clue.equals(clue)) {
            return true; // Clue found
        }
        return clue.compareTo(root.clue) < 0 ? findClueRec(root.left, clue) : findClueRec(root.right, clue);
    }

    // Count the total number of clues in the tree
    public int countClues() {
        return countCluesRec(root);
    }

    private int countCluesRec(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + countCluesRec(root.left) + countCluesRec(root.right);
    }

    // Main method to demonstrate functionality
    public static void main(String[] args) {
        ClueTree clueTree = new ClueTree();

        // Inserting clues
        clueTree.insert("Ancient Map");
        clueTree.insert("Golden Idol");
        clueTree.insert("Mysterious Key");
        clueTree.insert("Hidden Passage");
        clueTree.insert("Secret Chamber");

        // Perform traversals
        clueTree.inOrderTraversal();
        clueTree.preOrderTraversal();
        clueTree.postOrderTraversal();

        // Find a specific clue
        String clueToFind = "Golden Idol";
        System.out.println("\nFinding clue: " + clueToFind + " -> " + (clueTree.findClue(clueToFind) ? "Found" : "Not Found"));

        // Count total clues
        System.out.println("Total clues in the tree: " + clueTree.countClues());
    }
}
