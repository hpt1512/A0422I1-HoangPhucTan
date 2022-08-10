package maptree;

public class MyLinkedList<E> {
    private Node head;
    private int numNodes;

    public MyLinkedList(){
        head = null;
        numNodes = 0;
    }

    public void add(int index, E element) {
        if (numNodes <= index || index < 0 ) {
            throw new ArrayIndexOutOfBoundsException("Index khong hop le");
        }

        if (index == 0) {
            addFirst(element);
            return;
        }

        Node newNode = new Node(element);
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        numNodes++;
    }

    public void addFirst(E element) {
        Node newNode = new Node(element);
        numNodes++;
        newNode.next = head;
        head = newNode;
    }

    public void addLast(E element) {
        Node temp = head;
        for (int i = 0; i < numNodes - 1; i++)
            temp = temp.next;
        Node newNode = new Node(element);
        temp.next = newNode;
        numNodes++;
    }

    public E remove(int index) {
        if (numNodes <= index || index < 0 ) {
            throw new ArrayIndexOutOfBoundsException("Index khong hop le");
        }
        Node temp = head;
        if (index == 0) {
            head = temp.next;
            numNodes--;
            return (E) temp.getData();
        }

        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        E value = (E) temp.next.getData();
        temp.next = temp.next.next;
        numNodes--;
        return value;
    }

    class Node {
        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
