public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
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
