public class LinkedListDemo {

    // Node class representing each element in the list
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    // 1. Insert at the end - O(n)
    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // 2. Insert at the beginning - O(1)
    public void prepend(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // 3. Delete the first occurrence of a value - O(n)
    public void deleteByValue(int value) {
        if (head == null) return;

        // If head holds the value to delete
        if (head.data == value) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != value) {
            current = current.next;
        }

        // Value found
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    // 4. Search for a value - O(n)
    public boolean contains(int value) {
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // 5. Print all nodes in the list
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedListDemo list = new LinkedListDemo();

        // Adding elements
        list.append(10);
        list.append(20);
        list.append(30);
        list.prepend(5);

        System.out.print("Current list: ");
        list.printList(); // 5 -> 10 -> 20 -> 30 -> null

        // Searching
        System.out.println("Contains 20? " + list.contains(20)); // true
        System.out.println("Contains 99? " + list.contains(99)); // false

        // Deleting
        list.deleteByValue(20);
        System.out.print("After deleting 20: ");
        list.printList(); // 5 -> 10 -> 30 -> null

        list.deleteByValue(5);
        System.out.print("After deleting 5: ");
        list.printList(); // 10 -> 30 -> null
    }
}
