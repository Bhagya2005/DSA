public class SinglyLinkedList {
    class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node head;
    private int size;
    
    public SinglyLinkedList() {
        this.head = null;
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
    
    // Print the length of the list
    public void printLength() {
        System.out.println("Length of list: " + size);
    }
    
    // Insert a node at the beginning of the list
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }
    
    // Insert a node at the end of the list
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
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
            newNode.next = head;
            head = newNode;
        } else {
            Node temp = head;
            for (int i = 0; i < position - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
        size++;
    }
    
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
    
    // Remove a node matching the specified node from the list
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
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.insertAtBeginning(1);
        sll.insertAtEnd(2);
        sll.insertAtEnd(3);
        System.out.println(sll);  // Output: [1, 2, 3]
        sll.printFirstNode();  // Output: First node: 1
        sll.printLastNode();   // Output: Last node: 3
        sll.printLength();      // Output: Length of list: 3
        System.out.println(sll.findPosition(2));  // Output: 1
        System.out.println(sll.contains(2));  // Output: true
        System.out.println(sll.removeFromHead());  // Output: 1
        System.out.println(sll.removeFromEnd());   // Output: 3
        System.out.println(sll.removeNode(2));  // Output: true
        System.out.println(sll);  // Output: []
    }
}
