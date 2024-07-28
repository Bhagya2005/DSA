public class CircularLinkedList {
    class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node head;
    private Node tail;
    private int size;
    
    public CircularLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    // Print the first node
    public void printFirstNode() {
        if (head != null) {
            System.out.println("First node: " + head.data);
        } else {
            System.out.println("The list is empty.");
        }
    }
    
    // Print the last node
    public void printLastNode() {
        if (tail != null) {
            System.out.println("Last node: " + tail.data);
        } else {
            System.out.println("The list is empty.");
        }
    }
    
    // Print the length of the list
    public void printLength() {
        System.out.println("Length of list: " + size);
    }
    
    // Insert a node at the beginning of the list
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
        size++;
    }
    
    // Insert a node at the end of the list
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
        size++;
    }
    
    // Add a new value to the list at a given position
    public void insertAtPosition(int data, int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Position out of bounds");
        }
        
        Node newNode = new Node(data);
        if (position == 0) {
            insertAtBeginning(data);
        } else if (position == size) {
            insertAtEnd(data);
        } else {
            Node temp = head;
            for (int i = 0; i < position - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }
    }
    
    // Remove and return the node at the head of the list
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
            tail.next = head;
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
    
    // Return a string representation of this collection, in the form ["str1","str2",...]
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        if (head != null) {
            Node temp = head;
            do {
                result.append(temp.data);
                if (temp.next != head) {
                    result.append(", ");
                }
                temp = temp.next;
            } while (temp != head);
        }
        result.append("]");
        return result.toString();
    }
    
    // Find the position of the first value that is equal to a given value
    public int findPosition(int data) {
        Node temp = head;
        int position = 0;
        do {
            if (temp.data == data) {
                return position;
            }
            temp = temp.next;
            position++;
        } while (temp != head);
        return -1;
    }
    
    // Return true if the list contains data, else false
    public boolean contains(int data) {
        Node temp = head;
        do {
            if (temp.data == data) {
                return true;
            }
            temp = temp.next;
        } while (temp != head);
        return false;
    }
    
    // Example usage
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.insertAtBeginning(1);
        cll.insertAtEnd(2);
        cll.insertAtEnd(3);
        System.out.println(cll);  // Output: [1, 2, 3]
        cll.printFirstNode();  // Output: First node: 1
        cll.printLastNode();   // Output: Last node: 3
        cll.printLength();      // Output: Length of list: 3
        System.out.println(cll.findPosition(2));  // Output: 1
        System.out.println(cll.contains(2));  // Output: true
        System.out.println(cll.removeFromHead());  // Output: 1
        System.out.println(cll.removeFromEnd());   // Output: 3
        System.out.println(cll.removeNode(2));  // Output: true
        System.out.println(cll);  // Output: []
    }
}
