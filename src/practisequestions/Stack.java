/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practisequestions;

/**
 *
 * @author nikhil
 * Concept: Instead of adding and removing element from the end of the stack, add/remove it from the Beginning.
 * For example:
 * Push elements from the beginning: Set Head at first node. 
 * 1
 * 2 1
 * 3 2 1
 * 4 3 2 1
 * 5 4 3 2 1
 * 
 * To Pop elements, Since it's Last in First out, hence remove from the start and point the pointer to next element
 * It will be:
 * 5 4 3 2 1
 * 4 3 2 1
 * 3 2 1
 * 2 1
 * 1
 */
public class Stack {
    
    Node current;
    Node head;
    
    int count = 0;
    
    private class Node{
        int value;
        Node next;
        private Node(int value){
            this.value = value;
        }
        
        @Override
        public String toString()
        {
            return ("Node value= " + value);
        }
    }
    
    public void pushElement(int newVal)
    {
        Node newNode = new Node(newVal);
        
        if(head==null)
        {
            head = newNode;
            count++;
        }
        else
        {
            newNode.next = head;
            head= newNode;
            count++;
        }
    }
    
    public void showElements()
    {
        current = head;
        while(current!=null)
        {
            System.out.println(current.value);
            current = current.next;
        }
    }
    
    public Integer getSize()
    {
        return count;
    }
    
    public void popElement() 
    {
        if (head != null) 
        {
            head = head.next;
            count--;
        } 
        else 
        {
            System.out.println("Stack is Empty");
        }
    }
    
    public static void main(String[] args) {
        
        Stack newStack = new Stack();
        newStack.pushElement(1);
        newStack.pushElement(2);
        newStack.pushElement(3);
        newStack.pushElement(4);
        
        System.out.println("Elements of Stack are: ");
        newStack.showElements();
        
        System.out.println("Size of stack is : " + newStack.getSize());
        
        System.err.println("This is an ERROR message");
        
        newStack.popElement();
        newStack.popElement();
        
        System.out.println("Size of stack after pop is : " + newStack.getSize());
        
        System.out.println("Elements of Stack after pop are: ");
        newStack.showElements();
       
    }
}
