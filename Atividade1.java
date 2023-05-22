
public class Atividade1 {
    private Node head;
    private Node tail;

    public Atividade1() {
        this.head = null;
        this.tail = null;
    }

    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void concatenate(Atividade1 list) {
        if (list.head != null) {
            if (this.head == null) {
                this.head = list.head;
                this.tail = list.tail;
            } else {
                this.tail.next = list.head;
                list.head.prev = this.tail;
                this.tail = list.tail;
            }
        }
    }

    public Atividade1[] split() {
        Atividade1[] lists = new Atividade1[2];
        if (head == null || head.next == null) {
            lists[0] = this;
            lists[1] = new Atividade1();
            return lists;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        Node splitNode = slow.next;
        slow.next = null;

        lists[0] = this;
        lists[1] = new Atividade1();
        lists[1].head = splitNode;
        lists[1].tail = tail;

        tail = slow;
        return lists;
    }

    public void mergeSortedLists(Atividade1 list1, Atividade1 list2) {
        Node node1 = list1.head;
        Node node2 = list2.head;

        Atividade1 mergedList = new Atividade1();

        while (node1 != null && node2 != null) {
            if (node1.data <= node2.data) {
                mergedList.append(node1.data);
                node1 = node1.next;
            } else {
                mergedList.append(node2.data);
                node2 = node2.next;
            }
        }

        while (node1 != null) {
            mergedList.append(node1.data);
            node1 = node1.next;
        }

        while (node2 != null) {
            mergedList.append(node2.data);
            node2 = node2.next;
        }

        this.head = mergedList.head;
        this.tail = mergedList.tail;
    }

    public static void main(String[] args) {
        Atividade1 list1 = new Atividade1();
        list1.append(1);
        list1.append(3);
        list1.append(5);

        Atividade1 list2 = new Atividade1();
        list2.append(2);
        list2.append(4);
        list2.append(6);

        Atividade1 mergedList = new Atividade1();
        mergedList.mergeSortedLists(list1, list2);
        mergedList.display();
    }
}