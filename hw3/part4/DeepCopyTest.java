package part4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DeepCopyTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        // new Employee objects
        Employee Cameron = new Employee(06,"Cameron");
        Employee Nethen = new Employee(52,"Nethen");
        Employee Winfield = new Employee(12,"Winfield");

        // Employee ArrayList and add objects
        ArrayList<Employee> firstList = new ArrayList<>();
        firstList.add(Nethen);
        firstList.add(Cameron);
        firstList.add(Winfield);
        
        // second Employee ArrayList 
        ArrayList<Employee> secondList = new ArrayList<>();
        
        Iterator<Employee> employeeIterator = firstList.iterator();
        while(employeeIterator.hasNext()) {
            secondList.add((Employee) employeeIterator.next().clone());
        }
        
        Collections.sort(secondList, new EmployeeSort());
        
        System.out.println("Original list: " + firstList + "\n");
        
        System.out.println("Cloned list sorted by name: " + secondList);
        
        System.out.println("\nChanged name of index 2 from Winfield -> Joanna \n");
        secondList.get(2).setName("Joanna");
        
        Collections.sort(secondList, new EmployeeSort());
        System.out.println("New sorted cloned list: " + secondList);    
    }
    
}
