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
    private int nthToLastIterative(int n) {
        Node firstRunner = head;
        Node secondRunner = head;

        // firstRunner goes in the nth position
        for(int i = 0; i < n; i++){
            if(firstRunner == null)
                throw new IllegalArgumentException(
                        "The given n index is out of bounds");
            firstRunner = firstRunner.next;
        }
        // secondRunner run as long as runner1 is not null
        // basically, when runner1 cannot run further (is null),
        // secondRunner will be placed on the nth to last node

        while (firstRunner != null){
            firstRunner = firstRunner.next;
            secondRunner = secondRunner.next;
        }
        return secondRunner.data;
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
        sll.insertFirst(7);
        sll.insertFirst(6);
        sll.insertFirst(5);
        sll.insertFirst(4);
        sll.insertFirst(3);
        sll.insertFirst(2);
        sll.insertFirst(1);

        sll.print();

        int n = 1;
        int resultIterative = sll.nthToLastIterative(n);

        System.out.println("\nIterative: The " + n + "th to last node has the value: " + resultIterative);

    }
}
