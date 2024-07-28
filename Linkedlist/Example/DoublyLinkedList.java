public class DoublyLinkedList {
    class Node {
        int data;
        Node next;
        Node prev;
        
        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    
    private Node head;
    private Node tail;
    private int size;
    
    public DoublyLinkedList() {
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
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }
    
    // Insert a node at the end of the list
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
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
            newNode.prev = temp;
            temp.next.prev = newNode;
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
            head.prev = null;
        }
        size--;
        return temp.data;
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
    
    // Example usage
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertAtBeginning(1);
        dll.insertAtEnd(2);
        dll.insertAtEnd(3);
        System.out.println(dll);  // Output: [1, 2, 3]
        dll.printFirstNode();  // Output: First node: 1
        dll.printLastNode();   // Output: Last node: 3
        dll.printLength();      // Output: Length of list: 3
        System.out.println(dll.findPosition(2));  // Output: 1
        System.out.println(dll.contains(2));  // Output: true
        System.out.println(dll.removeFromHead());  // Output: 1
        System.out.println(dll.removeFromEnd());   // Output: 3
        System.out.println(dll.removeNode(2));  // Output: true
        System.out.println(dll);  // Output: []
    }
}
