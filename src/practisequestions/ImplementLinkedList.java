/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practisequestions;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author nikhil
 */
public class ImplementLinkedList {

    private Node head;
    private Node current;
    
    static Map<Integer, Integer> hashmapForCountOccourances = new HashMap<>();

    private void createHashMapUsingLinkedList(ImplementLinkedList listCreated) {

        head = listCreated.head;
        current = head;

        while (current != null) {
            if (!hashmapForCountOccourances.containsKey(current.value)) {
                hashmapForCountOccourances.put(current.value, 1);
            } else {
                hashmapForCountOccourances.put(current.value, hashmapForCountOccourances.get(current.value) + 1);
            }
            current = current.next;
        }
    }

    private class Node {

        int value;
        Node next;

        Node(int data) {
            value = data;
        }
    }

    public void add(int value) {
        if (head == null) {
            Node newNode = new Node(value);
            head = newNode;
        } else {
            current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(value);
        }
    }
    
    public void addValuesInHashMap(int value)
    {
        if(hashmapForCountOccourances.containsKey(value))
        {
            hashmapForCountOccourances.put(value, hashmapForCountOccourances.get(value)+1);
        }
        else
        {
            hashmapForCountOccourances.put(value, 1);
        }
    }

    public int countOccourancesUsingNormalIteration(int valueToFind) {
        int count = 0;
        if (head == null) {
            return 0;
        } else {
            current = head;
            while (current != null) {
                if (current.value == valueToFind) {
                    count++;
                }
                current = current.next;
            }
            return count;
        }
    }
    
    public Integer countOccourancesUsingHashTable(int valuesToFind)
    {
        int count = 0;
        for(Integer eachValue: hashmapForCountOccourances.keySet())
        {
            if(eachValue==valuesToFind)
            {
                count = hashmapForCountOccourances.get(eachValue);
            }
        }
        return count;
    }

    //ALWAYS OVER-RIDE toString TO DISPLAY CONTENTS.
    @Override
    public String toString() {
        current = head;
        while (current != null) {
           // System.out.println(current.value);
            current = current.next;
        }
        return "";
    }

    public static void main(String[] args) {
        ImplementLinkedList listCreated = new ImplementLinkedList();

        listCreated.add(11);
        listCreated.add(11);
        listCreated.add(39);
        listCreated.add(11);

        //Display contents
        listCreated.toString();
        
        //Count of occourances
        System.out.println("count Occourances Using Normal Iteration " + listCreated.countOccourancesUsingNormalIteration(11));
        
        listCreated.addValuesInHashMap(11);
        listCreated.addValuesInHashMap(11);
        listCreated.addValuesInHashMap(39);
        listCreated.addValuesInHashMap(11);

        //Display contents
        listCreated.toString();
        
        //Count of occourances
        System.out.println("count Occourances Using HashTable" + listCreated.countOccourancesUsingHashTable(11));
        
        hashmapForCountOccourances.clear();
        listCreated.createHashMapUsingLinkedList(listCreated);
        
        //Count of occourances
        System.out.println("count Occourances Using HashTable" + listCreated.countOccourancesUsingHashTable(11));
        
    }
}

