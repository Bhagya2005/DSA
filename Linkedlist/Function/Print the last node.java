// Print the last node  for singly Linked list
    public void printLastNode() {
        if (head != null) {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            System.out.println("Last node: " + temp.data);
        } else {
            System.out.println("The list is empty.");
        }
    }
    // Print the last node Doubly and Circular Linkedlist
    public void printLastNode() {
        if (tail != null) {
            System.out.println("Last node: " + tail.data);
        } else {
            System.out.println("The list is empty.");
        }
    }
    