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
    private void rearrange(int i) {
        Node currentNode = head;
        head = currentNode;
        tail = currentNode;

        while (currentNode != null){
            Node newNode = currentNode.next;

            if(currentNode.data < i){
                // insert node at the head
                currentNode.next = head;
                head = currentNode;
            }else{
                // insert node at the tail
                tail.next = currentNode;
                tail = currentNode;
            }
            currentNode = newNode;
        }
        tail.next = null;
    }
    public void removeDuplicate(){
        Set<Integer> set = new HashSet<>();

        Node currentNode = head;
        Node prevNode = null;

        while (currentNode != null){
            if(set.contains(currentNode.data)){
                prevNode.next = currentNode.next;
                if(currentNode == tail){
                    tail = prevNode;
                }
                size--;
            }else{
                set.add(currentNode.data);
                prevNode = currentNode;
            }
            currentNode = currentNode.next;
        }
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

        sll.insertFirst(11);
        sll.insertFirst(10);
        sll.insertFirst(9);
        sll.insertFirst(8);
        sll.insertFirst(8);
        sll.insertFirst(8);
        sll.insertFirst(7);
        sll.insertFirst(6);
        sll.insertFirst(5);
        sll.insertFirst(4);
        sll.insertFirst(-3);
        sll.insertFirst(2);
        sll.insertFirst(1);
        sll.insertFirst(11);
        sll.insertFirst(90);

        sll.print();

        sll.removeDuplicate();

        sll.print();

        sll.rearrange(7);

        sll.print();
    }
}
