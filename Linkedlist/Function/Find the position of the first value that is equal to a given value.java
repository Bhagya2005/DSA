// Find the position of the first value that is equal to a given value



public int findPosition(int data) {
    Node temp = head;
    int position = 0;
    while (temp != null) {
        if (temp.data == data) {
            return position;
        }
        temp = temp.next;
        position++;
    }
    return -1;
}

   
    // Find the position of the first value that is equal to a given value for Doubly and circular linkedlist
    public int findPosition(int data) {
        Node temp = head;
        int position = 0;
        while (temp != null) {
            if (temp.data == data) {
                return position;
            }
            temp = temp.next;
            position++;
        }
        return -1;
    }
 