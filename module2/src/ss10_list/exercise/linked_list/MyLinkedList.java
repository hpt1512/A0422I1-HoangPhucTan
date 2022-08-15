package ss10_list.exercise.linked_list;

public class MyLinkedList<E> {
    public class Node {
        private Node next;
        private Object data;

        public Node(E data) {
            this.data = data;
            next = null;
        }

        public Object getData() {
            return data;
        }
    }

    private Node head;
    private int numNodes = 0;

    public MyLinkedList(E element) {
        head = new Node(element);
    }

    public void add(int index, E element) {
        Node temp = head;
        int i = 0;
        while(i < index - 1) {
            temp = temp.next;
            i++;
        }
        Node holder = temp.next;
        temp.next = (Node)element;
        ((Node)element).next = holder;
        numNodes++;
    }

    public void addFirst(E element) {
        Node temp = head;
        head = (Node)element;
        head.next = temp;
        numNodes++;
    }

    public void addLast(E element) {
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = (Node)element;
        numNodes++;
    }

    public E remove(int index) {
        Node temp = head;
        int i = 0;
        while(i < index - 1) {
            temp = temp.next;
            i++;
        }
        temp.next = temp.next.next;
        numNodes--;
        return (E)temp;
    }

    public boolean contains(E o) {
        Node temp = head;
        while (temp.next != null) {
            if (temp.data.equals(o)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public boolean remove(Object e) {
        Node temp = head;
        if (contains((E)e)) {
            int index = 0;
            int i = 0;
            while(!temp.next.equals(e)) {
                temp = temp.next;
                index++;
            }
            temp = head;
            while(i < index - 1) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            numNodes--;
            return true;
        }
        return false;
    }

    public int size() {
        return numNodes;
    }

    public E clone() {
        Node cloneHead = new Node((E)head);
        Node temp = head;
        Node tempClone = cloneHead;
        while(temp.next != null) {
            tempClone.next = new Node((E)temp.next);
            temp = temp.next;
            tempClone = tempClone.next;
        }
        return (E)cloneHead;
    }
}
