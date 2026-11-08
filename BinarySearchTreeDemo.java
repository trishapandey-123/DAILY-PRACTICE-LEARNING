public class BinarySearchTreeDemo {

    // Node representing each element in the tree
    static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    private Node root;

    public BinarySearchTreeDemo() {
        root = null;
    }

    // Insert a key into the BST
    public void insert(int key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node current, int key) {
        // If the tree/subtree is empty, return a new node
        if (current == null) {
            return new Node(key);
        }

        // Traverse left or right based on the key value
        if (key < current.key) {
            current.left = insertRec(current.left, key);
        } else if (key > current.key) {
            current.right = insertRec(current.right, key);
        }

        return current;
    }

    // Search for a key in the BST
    public boolean search(int key) {
        return searchRec(root, key);
    }

    private boolean searchRec(Node current, int key) {
        if (current == null) {
            return false;
        }
        if (current.key == key) {
            return true;
        }

        return key < current.key 
            ? searchRec(current.left, key) 
            : searchRec(current.right, key);
    }

    // In-order traversal: Left -> Root -> Right (produces sorted output)
    public void inOrder() {
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node current) {
        if (current != null) {
            inOrderRec(current.left);
            System.out.print(current.key + " ");
            inOrderRec(current.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTreeDemo bst = new BinarySearchTreeDemo();

        // Inserting elements
        int[] values = {50, 30, 20, 40, 70, 60, 80};
        for (int val : values) {
            bst.insert(val);
        }

        System.out.print("In-order Traversal (Sorted): ");
        bst.inOrder(); // 20 30 40 50 60 70 80

        // Searching elements
        System.out.println("Search 40: " + (bst.search(40) ? "Found" : "Not Found")); // Found
        System.out.println("Search 99: " + (bst.search(99) ? "Found" : "Not Found")); // Not Found
    }
}
