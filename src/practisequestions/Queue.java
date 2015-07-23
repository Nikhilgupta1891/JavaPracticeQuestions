/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practisequestions;

/**
 *
 * @author nikhil
 * Concept: Instead of adding and removing element from the end of the queue, add/remove it from the Beginning.
 * For example:
 * Push elements from the beginning: Set Head at first node. 
 * 1
 * 1 2
 * 1 2 3
 * 1 2 3 4
 * 
 * To Pop elements, Since it's Last in First out, hence remove from the start and point the pointer to next element
 * It will be:
 * 1 2 3 4
 * 2 3 4
 * 3 4
 * 4
 */
public class Queue {

    Node head;
    Node current;

    int count = 0;

    private void pushElement(int newVal) {

        Node newNode = new Node(newVal);
        if (head == null) {
            head = newNode;
            current = head;
            count++;
        } else {
            current.next = newNode;
            current = current.next;
            count++;
        }
    }

    private void showElements() {
        current = head;
        if (current == null) {
            System.out.println("The Queue is empty");
        } else {
            while (current != null) {
                System.out.println(current.value);
                current = current.next;
            }
        }

    }

    private Integer getSize() {
        return count;
    }

    private void popElement() {
        head = head.next;
        count--;
    }

    private class Node {

        int value;
        Node next;

        private Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return ("Value of node: " + value);
        }
    }

    public static void main(String[] args) {

        Queue newQueue = new Queue();
        newQueue.pushElement(1);
        newQueue.pushElement(2);
        newQueue.pushElement(3);
        newQueue.pushElement(4);

        System.out.println("Elements of Queue are: ");
        newQueue.showElements();

        System.out.println("Size of Queue is : " + newQueue.getSize());

        System.out.println("Popping an element");
        newQueue.popElement();

        System.out.println("Popping an element");
        newQueue.popElement();

        System.out.println("Size of stack after pop is : " + newQueue.getSize());

        System.out.println("Elements of Queue after pop are: ");
        newQueue.showElements();
    }
}
