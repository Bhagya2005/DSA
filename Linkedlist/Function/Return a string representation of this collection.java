// Return a string representation of this collection, in the form ["str1","str2",...]
@Override
public String toString() {
    StringBuilder result = new StringBuilder("[");
    Node temp = head;
    while (temp != null) {
        result.append(temp.data);
        if (temp.next != null) {
            result.append(", ");
        }
        temp = temp.next;
    }
    result.append("]");
    return result.toString();
}

    // Return a string representation of this collection for doubly and circular linkedlist, in the form ["str1","str2",...]
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node temp = head;
        while (temp != null) {
            result.append(temp.data);
            if (temp.next != null) {
                result.append(", ");
            }
            temp = temp.next;
        }
        result.append("]");
        return result.toString();
    }
    