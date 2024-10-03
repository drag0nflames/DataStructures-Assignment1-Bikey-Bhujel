package explorerqueue;

public class ExplorerQueue {
    private String[] queue;
    private int front;
    private int rear;
    private int size;
    private final int capacity;

    public ExplorerQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new String[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    // Enqueue new explorers
    public void enqueue(String explorerName) {
        if (isFull()) {
            System.out.println("The queue is full. Cannot enqueue " + explorerName);
            return;
        }
        rear = (rear + 1) % capacity; // Circular increment
        queue[rear] = explorerName;
        size++;
        System.out.println("Enqueued: " + explorerName);
    }

    // Dequeue explorers when they enter the temple
    public String dequeue() {
        if (isEmpty()) {
            System.out.println("The queue is empty. No explorers to dequeue.");
            return null;
        }
        String explorer = queue[front];
        front = (front + 1) % capacity; // Circular increment
        size--;
        System.out.println("Dequeued: " + explorer);
        return explorer;
    }

    // Display the next explorer in line
    public String peekNextExplorer() {
        if (isEmpty()) {
            System.out.println("The queue is empty. No explorers in line.");
            return null;
        }
        return queue[front];
    }

    // Check if the queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Print all explorers in the queue
    public void printQueue() {
        if (isEmpty()) {
            System.out.println("The queue is empty.");
            return;
        }

        System.out.println("Explorers in the queue:");
        for (int i = 0; i < size; i++) {
            System.out.println(queue[(front + i) % capacity]);
        }
    }

    // Main method to demonstrate functionality
    public static void main(String[] args) {
        ExplorerQueue queue = new ExplorerQueue(5);

        // Enqueue explorers
        queue.enqueue("Alice");
        queue.enqueue("Bob");
        queue.enqueue("Charlie");
        queue.enqueue("Diana");
        queue.enqueue("Eve");

        // Attempt to enqueue when the queue is full
        queue.enqueue("Frank");

        // Display the next explorer in line
        System.out.println("\nNext explorer in line: " + queue.peekNextExplorer());

        // Print all explorers in the queue
        queue.printQueue();

        // Dequeue an explorer
        System.out.println("\nDequeuing an explorer...");
        queue.dequeue();

        // Print all explorers after dequeuing
        queue.printQueue();

        // Dequeue until the queue is empty
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        // Attempt to dequeue when the queue is empty
        queue.dequeue();
    }
}
