  // Remove and return the node at the end of the list
  public int removeFromEnd() {
    if (head == null) {
        return -1;
    }
    if (head.next == null) {
        int data = head.data;
        head = null;
        size--;
        return data;
    }
    
    Node temp = head;
    while (temp.next.next != null) {
        temp = temp.next;
    }
    int data = temp.next.data;
    temp.next = null;
    size--;
    return data;
}

    // Remove and return the node at the end of the list
    public int removeFromEnd() {
        if (tail == null) {
            return -1;
        }
        Node temp = tail;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return temp.data;
    }

       // Remove and return the node at the end of the list
       public int removeFromEnd() {
        if (head == null) {
            return -1;
        }
        if (head == tail) {
            int data = head.data;
            head = null;
            tail = null;
            size--;
            return data;
        }
        
        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        int data = tail.data;
        tail = temp;
        tail.next = head;
        size--;
        return data;
    }