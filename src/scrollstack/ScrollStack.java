package scrollstack;

import java.util.Stack;

public class ScrollStack {
    private Stack<String> scrolls;

    public ScrollStack() {
        scrolls = new Stack<>();
    }

    // Push a new scroll onto the stack
    public void pushScroll(String scrollTitle) {
        scrolls.push(scrollTitle);
        System.out.println("Pushed scroll: " + scrollTitle);
    }

    // Pop the top scroll off the stack
    public String popScroll() {
        if (scrolls.isEmpty()) {
            System.out.println("The stack is empty. No scroll to pop.");
            return null;
        }
        String removedScroll = scrolls.pop();
        System.out.println("Popped scroll: " + removedScroll);
        return removedScroll;
    }

    // Peek at the top scroll without removing it
    public String peekScroll() {
        if (scrolls.isEmpty()) {
            System.out.println("The stack is empty. No scroll to peek.");
            return null;
        }
        return scrolls.peek();
    }

    // Check if a specific scroll title exists in the stack
    public boolean containsScroll(String scrollTitle) {
        return scrolls.contains(scrollTitle);
    }

    // Print all the scrolls in the stack
    public void printAllScrolls() {
        if (scrolls.isEmpty()) {
            System.out.println("The stack is empty. No scrolls to display.");
        } else {
            System.out.println("Scrolls in the stack:");
            for (String scroll : scrolls) {
                System.out.println(scroll);
            }
        }
    }

    // Main method to demonstrate functionality
    public static void main(String[] args) {
        ScrollStack stack = new ScrollStack();

        // Push scrolls onto the stack
        stack.pushScroll("Scroll of Wisdom");
        stack.pushScroll("Scroll of Fire");
        stack.pushScroll("Scroll of Water");
        stack.pushScroll("Scroll of Earth");

        // Peek at the top scroll
        System.out.println("\nPeeking at the top scroll:");
        System.out.println(stack.peekScroll());

        // Check if a specific scroll exists
        System.out.println("\nDoes the stack contain 'Scroll of Fire'? " + stack.containsScroll("Scroll of Fire"));

        // Print all scrolls
        System.out.println("\nPrinting all scrolls:");
        stack.printAllScrolls();

        // Pop a scroll off the stack
        System.out.println("\nPopping the top scroll:");
        stack.popScroll();

        // Print all scrolls after popping
        System.out.println("\nPrinting all scrolls after popping:");
        stack.printAllScrolls();
    }
}
