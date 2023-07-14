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
    public int size(){
        return size;
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

        sll.insertFirst(5);
        sll.insertFirst(2);
        sll.insertFirst(12);
        sll.insertFirst(2);
        sll.insertFirst(12);
        sll.insertFirst(5);
        sll.insertFirst(5);
        sll.insertFirst(12);
        sll.insertFirst(1);
        sll.insertFirst(4);
        sll.insertFirst(12);

        System.out.println("\nLinked list before removing duplicates:");
        sll.print();
        sll.removeDuplicate();
        System.out.println("\nLinked list after removing duplicates:");
        sll.print();

        System.out.println("\nSize: " + sll.size());
    }

}
