package ex03;

public class Node {

    Transaction transaction;
    Node next;
    Node prev;

    Node(Node next, Node prev, Transaction transaction) {
        this.next = next;
        this.prev = prev;
        this.transaction = transaction;
    }
}
