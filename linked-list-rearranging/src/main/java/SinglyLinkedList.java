import java.util.HashSet;
import java.util.Set;

public class SinglyLinkedList {

    private final class Node{
        private int data;
        private Node next;

        @Override
        public String toString() {
            return " " + data + " ";
        }
    }

    private Node head;
    private Node tail;
    private int size;


    public void insertFirst(int data){
        Node newNode = new Node();

        newNode.data = data;
        newNode.next = head;
        head = newNode;

        if(tail == null)
            tail = newNode;
        size++;
    }
    public void rearrange(int n) {

        Node currentNode = head;
        head = currentNode;
        tail = currentNode;

        while (currentNode != null) {

            Node nextNode = currentNode.next;

            if (currentNode.data < n) {
                // insert node at the head
                currentNode.next = head;
                head = currentNode;
            } else {
                // insert node at the tail
                tail.next = currentNode;
                tail = currentNode;
            }
            currentNode = nextNode;
        }
        tail.next = null;
    }
    public void print() {

        System.out.println("\nHead (" + head + ") ----------> Last (" + tail + "):");

        Node currentNode = head;
        while (currentNode != null) {

            System.out.print(currentNode);
            currentNode = currentNode.next;
        }

        System.out.println();
    }



    public static void main(String[] args) {

        SinglyLinkedList sll = new SinglyLinkedList();

        sll.insertFirst(7);
        sll.insertFirst(2);
        sll.insertFirst(3);
        sll.insertFirst(4);
        sll.insertFirst(5);
        sll.insertFirst(1);

        sll.print();
        sll.rearrange(3);

        sll.print();
    }
}
