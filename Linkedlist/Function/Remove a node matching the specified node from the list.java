public boolean removeNode(int data) {
    if (head == null) {
        return false;
    }
    
    if (head.data == data) {
        head = head.next;
        size--;
        return true;
    }
    
    Node temp = head;
    while (temp.next != null && temp.next.data != data) {
        temp = temp.next;
    }
    
    if (temp.next != null) {
        temp.next = temp.next.next;
        size--;
        return true;
    }
    
    return false;
}

    // Remove a node matching the specified node from the list
    public boolean removeNode(int data) {
        if (head == null) {
            return false;
        }
        
        if (head.data == data) {
            removeFromHead();
            return true;
        } else if (tail.data == data) {
            removeFromEnd();
            return true;
        } else {
            Node temp = head;
            while (temp != null && temp.data != data) {
                temp = temp.next;
            }
            if (temp != null) {
                temp.prev.next = temp.next;
                if (temp.next != null) {
                    temp.next.prev = temp.prev;
                }
                size--;
                return true;
            }
        }
        return false;
    }
    
        // Remove a node matching the specified node from the list
        public boolean removeNode(int data) {
            if (head == null) {
                return false;
            }
            
            if (head.data == data) {
                removeFromHead();
                return true;
            } else if (tail.data == data) {
                removeFromEnd();
                return true;
            } else {
                Node temp = head;
                Node prev = null;
                do {
                    if (temp.data == data) {
                        prev.next = temp.next;
                        size--;
                        return true;
                    }
                    prev = temp;
                    temp = temp.next;
                } while (temp != head);
            }
            return false;
        }