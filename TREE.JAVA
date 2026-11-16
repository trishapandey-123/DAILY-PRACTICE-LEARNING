import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeDemo {

    // Node class representing each vertex in the tree
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    // 1. Pre-order Traversal (Root -> Left -> Right)
    public void preOrder(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // 2. In-order Traversal (Left -> Root -> Right)
    public void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    // 3. Post-order Traversal (Left -> Right -> Root)
    public void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    // 4. Level-order Traversal (Breadth-First Search using a Queue)
    public void levelOrder(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    // 5. Calculate maximum height/depth of the tree
    public int getHeight(Node node) {
        if (node == null) return 0;
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // 6. Count total number of nodes
    public int countNodes(Node node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    public static void main(String[] args) {
        BinaryTreeDemo tree = new BinaryTreeDemo();

        /* Constructing the following Binary Tree:
                  1
                /   \
               2     3
              / \   / \
             4   5 6   7
        */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.print("Pre-order Traversal:   ");
        tree.preOrder(tree.root);   // 1 2 4 5 3 6 7
        System.out.println();

        System.out.print("In-order Traversal:    ");
        tree.inOrder(tree.root);    // 4 2 5 1 6 3 7
        System.out.println();

        System.out.print("Post-order Traversal:  ");
        tree.postOrder(tree.root);  // 4 5 2 6 7 3 1
        System.out.println();

        System.out.print("Level-order Traversal: ");
        tree.levelOrder(tree.root); // 1 2 3 4 5 6 7
        System.out.println();

        System.out.println("Tree Height: " + tree.getHeight(tree.root));   // 3
        System.out.println("Total Nodes: " + tree.countNodes(tree.root));  // 7
    }
}
