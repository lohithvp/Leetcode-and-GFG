class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }

}

class MyLinkedList {

    Node head;
    int size;

    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public int get(int index) {
        if (index >= size || head == null)
            return -1;
        int cnt = 0;
        Node temp = head;
        while (temp != null) {
            if (cnt == index)
                return temp.data;
            cnt++;
            temp = temp.next;
        }
        return -1;
    }

    public void addAtHead(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addAtTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        size++;
    }

    public void addAtIndex(int index, int data) {
        Node newNode = new Node(data);
        if (index > size)
            return;
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node temp = head;
            int cnt = 1;
            while (cnt < index && temp.next != null) {
                temp = temp.next;
                cnt++;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
        size++;
    }

    public void deleteAtIndex(int index) {
        if (head == null || index >= size)
            return;

        int cnt = 0;
        Node temp = head;
        if (index == 0) {
            head = head.next;
            size--;
            return;
        }
        while (temp.next != null && cnt < index - 1) {
            cnt++;
            temp = temp.next;
        }
        Node nodeTodelete = temp.next;
        temp.next = nodeTodelete.next;
        nodeTodelete.next = null;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */