public class LinkedList {
    Node head;

    public void insert(Patient patient) {
        Node node = new Node(patient);
        //node.data = data;
        node.next = null;

        if(head == null) {
            head = node;
        } else {
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }
    }

    public void show() {
        Node node = head;

        while (node.next != null) {
            System.out.println(node.patient.getFirstName() + " " + node.patient.getSurName());
            node = node.next;
        }
        System.out.println(node.patient.getFirstName() + " " + node.patient.getSurName());
    }

    public void reverseList() {
        Node current = head;
        Node prev = null;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }
    //Reference from https://www.geeksforgeeks.org/reverse-a-linked-list/
}
