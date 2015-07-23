/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practisequestions;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Java has a Priority Queue. 
 * We can use Comparator Interface and override the compare method. 
 */

public class PriorityQueueExample{

    public static void main(String[] args) {
        
        Patient p1 = new Patient(1, "G");
        Patient p2 = new Patient(6, "C");
        Patient p3 = new Patient(2, "B");
        Patient p4 = new Patient(0, "F");

        PriorityQueue<Patient> patientQueue = new PriorityQueue<>(10, new Comparator<Patient>() {
            @Override
            public int compare(Patient patient1, Patient patient2) {
                return ((patient2.getPriority()).compareTo(patient1.getPriority()));    // Ascending order.
                // return ((patient1.getPriority()).compareTo(patient2.getPriority()));     // Descending order.
            }
        });
        
        patientQueue.add(p1);
        patientQueue.add(p2);
        patientQueue.add(p3);
        patientQueue.add(p4);
        
        while(true)
        {
            Patient eachPatient = patientQueue.poll();
            if(eachPatient!=null)
            System.out.print(eachPatient.name + " <-- ");
        }
    }
}