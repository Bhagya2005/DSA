  // Remove the value at a given position
  public int removeAtPosition(int position) {
    if (position < 0 || position >= size) {
        throw new IndexOutOfBoundsException("Position out of bounds");
    }
    
    if (position == 0) {
        int data = head.data;
        head = head.next;
        size--;
        return data;
    }
    
    Node temp = head;
    for (int i = 0; i < position - 1; i++) {
        temp = temp.next;
    }
    
    int data = temp.next.data;
    temp.next = temp.next.next;
    size--;
    return data;
}

 // Remove the value at a given position
 public int removeAtPosition(int position) {
    if (position < 0 || position >= size) {
        throw new IndexOutOfBoundsException("Position out of bounds");
    }
    
    if (position == 0) {
        return removeFromHead();
    } else if (position == size - 1) {
        return removeFromEnd();
    } else {
        Node temp = head;
        for (int i = 0; i < position; i++) {
            temp = temp.next;
        }
        temp.prev.next = temp.next;
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
        size--;
        return temp.data;
    }
}

    // Remove the value at a given position
    public int removeAtPosition(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Position out of bounds");
        }
        
        if (position == 0) {
            return removeFromHead();
        } else if (position == size - 1) {
            return removeFromEnd();
        } else {
            Node temp = head;
            for (int i = 0; i < position - 1; i++) {
                temp = temp.next;
            }
            int data = temp.next.data;
            temp.next = temp.next.next;
            size--;
            return data;
        }
    }
    