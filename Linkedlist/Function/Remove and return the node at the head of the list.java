 // Remove and return the node at the head of the list
 public int removeFromHead() {
    if (head == null) {
        return -1;
    }
    Node temp = head;
    head = head.next;
    size--;
    return temp.data;
}

 // Remove and return the node at the head of the list for Doubly and circular
 public int removeFromHead() {
    if (head == null) {
        return -1;
    }
    Node temp = head;
    if (head == tail) {
        head = null;
        tail = null;
    } else {
        head = head.next;
        head.prev = null;
    }
    size--;
    return temp.data;
}
