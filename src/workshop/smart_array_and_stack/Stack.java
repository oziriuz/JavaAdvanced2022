package workshop.smart_array_and_stack;

public class Stack {

    private static class Node {
        int element;
        private Node prev;

        private Node(int element) {
            this.element = element;
        }
    }

    private Node top;
    private int size;

    public void push(int element) {
        Node newNode = new Node(element);
        newNode.prev = top;
        top = newNode;
        size++;
    }
}
