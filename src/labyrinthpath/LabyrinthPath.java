package labyrinthpath;

public class LabyrinthPath {
    // Inner Node class for linked list
    private static class Node {
        String location;
        Node next;

        Node(String location) {
            this.location = location;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    // Add a new location to the path (at the end of the linked list)
    public void addLocation(String location) {
        Node newNode = new Node(location);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Remove the last visited location
    public void removeLastLocation() {
        if (head == null) {
            System.out.println("The path is empty. Nothing to remove.");
            return;
        }

        if (head == tail) {
            // Only one element in the list
            System.out.println("Removing last location: " + head.location);
            head = null;
            tail = null;
            return;
        }

        // Find the second last node
        Node current = head;
        while (current.next != tail) {
            current = current.next;
        }

        System.out.println("Removing last location: " + tail.location);
        current.next = null;
        tail = current;
    }

    // Check if the path contains a loop (trap)
    public boolean containsLoop() {
        if (head == null) return false;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true; // Loop detected
            }
        }

        return false; // No loop detected
    }

    // Print the entire path
    public void printPath() {
        if (head == null) {
            System.out.println("The path is empty.");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.location + " -> ");
            current = current.next;
        }
        System.out.println("End");
    }

    // Main method to demonstrate functionality
    public static void main(String[] args) {
        LabyrinthPath path = new LabyrinthPath();

        // Adding locations to the path
        path.addLocation("Entrance");
        path.addLocation("Hallway");
        path.addLocation("Chamber of Secrets");
        path.addLocation("Mystic Garden");

        // Print the entire path
        System.out.println("Current Path:");
        path.printPath();

        // Removing the last visited location
        System.out.println("\nRemoving last location:");
        path.removeLastLocation();
        path.printPath();

        // Checking for a loop
        System.out.println("\nDoes the path contain a loop? " + path.containsLoop());

        // Creating a loop manually for testing purposes
        System.out.println("\nCreating a loop for testing...");
        path.tail.next = path.head.next; // Creating a loop

        System.out.println("Does the path contain a loop? " + path.containsLoop());
    }
}

