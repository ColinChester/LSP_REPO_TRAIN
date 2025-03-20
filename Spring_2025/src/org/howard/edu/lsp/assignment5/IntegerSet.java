package assignment5;

import java.util.List;

public class IntegerSet {
	// TODO Store the set elements in an ArrayList.
	private List<Integer> set = new ArrayList<Integer>();

	// TODO Default Constructor
	public IntegerSet() {
		
	}

	// TODO Constructor if you want to pass in already initialized
	public IntegerSet(ArrayList<Integer> set) {
			this.set = set;
	}

	// TODO Clears the internal representation of the set. 5 pts.
	public void clear() {…};

	// TODO Returns the length of the set. 5 pts.
	public int length() {…};

	/* TODO
	 * Returns true if the 2 sets are equal, false otherwise;
	 * Two sets are equal if they contain all of the same values in ANY order.  This overrides
	 * the equal method from the Object class. 10 pts.
	*/
	public boolean equals(Object o) {…}; 

	// TODO Returns true if the set contains the value, otherwise false. 5 pts.
	public boolean contains(int value) {…};
	
	// TODO Returns the largest item in the set. 5 pts.
	public int largest()  {…};
	
	// TODO Returns the smallest item in the set. 5 pts.
	public int smallest()  {…};

	// TODO Adds an item to the set or does nothing it already there. 5 pts.	
	public void add(int item) {…};

	// TODO Removes an item from the set or does nothing if not there. 5 pts.
	public void remove(int item) {…}; 

	// TODO Set union. 11 pts.
	public void union(IntegerSet intSetb) {…};

	// TODO Set intersection, all elements in s1 and s2. 12 pts.
	public void intersect(IntegerSet intSetb) {…}; 

	// TODO Set difference, i.e., s1 – s2. 12 pts.
	public void diff(IntegerSet intSetb);

	// TODO Set complement, all elements not in s1. 11 pts.
	public void complement(IntegerSet intSetb) {…}

	// TODO Returns true if the set is empty, false otherwise. 5 pts.
	boolean isEmpty(); 

	// TODO Return String representation of your set.  This overrides the equal method from the Object class. 5 pts.
	public String toString() {
		set.toString();
		};

}