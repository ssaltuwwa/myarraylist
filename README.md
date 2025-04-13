Custom Data Structures in Java
📘 Overview
This project implements fundamental data structures in Java without utilizing the standard java.util.* collections, except for Iterator. The goal is to understand and build core data structures from scratch.
Implemented Structures:
Physical Data Structures:
MyArrayList – Array-based list implementation.
MyLinkedList – Doubly linked list implementation.
Logical Data Structures:
MyStack – Stack built upon MyArrayList.
MyQueue – Queue built upon MyLinkedList.
MyMinHeap – Min-heap built upon MyArrayList.

Each class includes its own test cases within the same file for ease of testing and demonstration.

📁 Project Structure
src/
├── MyList.java         # Interface defining list operations
├── MyArrayList.java    # ArrayList implementation with tests
├── MyLinkedList.java   # LinkedList implementation with tests
├── MyStack.java        # Stack implementation with tests
├── MyQueue.java        # Queue implementation with tests
└── MyMinHeap.java      # MinHeap implementation with tests
🛠 Usage
Clone the Repository:

git clone https://github.com/yourusername/CustomDataStructures.git
Navigate to the Project Directory:

cd CustomDataStructures
Compile and Run:

Open each .java file in your preferred IDE (e.g., IntelliJ IDEA).

Run the main method located at the bottom of each file to execute tests.

✅ Features
Dynamic Resizing: MyArrayList automatically resizes when capacity is exceeded.
Doubly Linked: MyLinkedList supports bidirectional traversal.
Stack Operations: MyStack supports typical stack operations like push, pop, and peek.
Queue Operations: MyQueue supports typical queue operations like enqueue, dequeue, and peek.
Heap Operations: MyMinHeap supports insert, extractMin, and peekMin operations, maintaining the min-heap property.

