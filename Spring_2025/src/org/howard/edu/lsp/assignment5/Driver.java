package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;

import assignment6.IntegerSet;

public class Driver {
	public static void main(String[] args) {
		IntegerSet set1 = new IntegerSet();
		String test1 = "";
		String test2 = null;
	    set1.add(1);
	    set1.add(2);
	    set1.add(3);
	    set1.add(4);
	    set1.add(5);
	    System.out.println("Set1 values: " + set1);
	    System.out.println("Set1 length: " + set1.length());
	    System.out.println("Set1 contains 9: " + set1.contains(9));
	    System.out.println("Adding 9 to set1...");
	    set1.add(9);
	    System.out.println("Adding 1 to set1...");
	    set1.add(1);
	    System.out.println("Set1 values: " + set1);
	    System.out.println("Set1 contains 9: " + set1.contains(9));
	    System.out.println("Removing 9 from set1...");
	    set1.remove(9);
	    System.out.println("Removing 10 from set1");
	    set1.remove(10);
	    System.out.println("Set1 values: " + set1);
	    System.out.println("Smallest: " + set1.smallest());
	    System.out.println("Largest: " + set1.largest());
	    System.out.println("Set1 equals set1: " + set1.equals(set1));
	    System.out.println("Set1 equals string: " + set1.equals(test1));
	    System.out.println("Set1 equals null: " + set1.equals(test2));
	    IntegerSet set2 = new IntegerSet();
	    set2.add(4);
	    set2.add(5);
	    set2.add(6);
	    set2.add(7);
	    set2.add(8);
	    System.out.println("Set2 values: " + set2);
	    System.out.println("Set1 equals set2: " + set1.equals(set2));
	    System.out.println("Set1 values: " + set1);
	    System.out.println("Set2 values: " + set2);
        IntegerSet unionTest = new IntegerSet(new ArrayList<>(set1.getSet()));
        unionTest.union(set2);
        System.out.println("After union, set1: " + unionTest);
        IntegerSet intersectTest = new IntegerSet(new ArrayList<>(set1.getSet()));
        intersectTest.intersect(set2);
        System.out.println("After intersection, set1: " + intersectTest);
        IntegerSet diffTest = new IntegerSet(new ArrayList<>(set1.getSet()));
        diffTest.diff(set2);
        System.out.println("After difference, set1: " + diffTest);
        IntegerSet complementTest = new IntegerSet(new ArrayList<>(set1.getSet()));
        complementTest.complement(set2);
        System.out.println("After complement, set1: " + complementTest);
        System.out.println("Set1 values: " + set1);
        System.out.println("Set1 is empty: " + set1.isEmpty());
        System.out.println("Clearing set1");
        set1.clear();
        System.out.println("Set1 values: " + set1);
        System.out.println("Set1 is empty: " + set1.isEmpty());
    }
	    
	    
	    
}
