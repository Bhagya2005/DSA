 // Return true if the list contains data, else false
 public boolean contains(int data) {
    Node temp = head;
    while (temp != null) {
        if (temp.data == data) {
            return true;
        }
        temp = temp.next;
    }
    return false;
}

  