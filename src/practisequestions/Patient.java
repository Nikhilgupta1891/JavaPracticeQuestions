/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practisequestions;

/**
 *
 * @author nikhil
 */
public class Patient {
    
    int priority;
    String name;
    
    public Patient(int priority, String name)
    {
        this.priority = priority;
        this.name = name;
    }
    
    @Override
    public String toString()
    {
        return "Patient " + name + " has priority " + priority;
    }
    
    public Integer getPriority()
    {
        return priority;
    }    
}
