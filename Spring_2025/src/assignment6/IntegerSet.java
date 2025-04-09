package assignment6;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


public class IntegerSet {
	private List<Integer> set = new ArrayList<Integer>();

	/**
	 * Default IntegerSet constructor
	 */
	public IntegerSet() {
		
	}
	
	/**
	 * IntegerSet constructor with a passed set
	 * @param set	Integer ArrayList to be passed into this.set
	 */
	public IntegerSet(ArrayList<Integer> set) {
			this.set = set;
	}
	
	/**
	 * Clears this.set
	 */
	public void clear() {
		this.set.clear();
	};

	/**
	 * Returns the length of this.set
	 * @return the int value of this.set's length
	 */
	public int length() {
		return this.set.size();
	};


	/**
	 * Determines if the two passed sets have the same values
	 * Referenced: https://www.geeksforgeeks.org/java-program-to-compare-two-objects/
	 * @return true if the object passed shares values with this.object
	 * @return false if the object passed is null or not an IntegerSet object
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		
		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		IntegerSet newSet = (IntegerSet)o;
		return this.set.equals(newSet.set);
	}; 

	/**
	 * Determines if the passed value is in this.set
	 * @param value	int value to be found in this.set
	 * @return true if value is in this.set
	 * @return false if value is not in this.set
	 */
	public boolean contains(int value) {
		return this.set.contains(value);
	};
	
	
	/**
	 * Finds the largest value in this.set
	 * References: https://stackoverflow.com/questions/12788182/finding-the-largest-value-in-an-arraylist
	 * @return max	Largest value in this.set
	 */
	public int largest()  {
		int max = Collections.max(this.set);
		return max;
	};
	
	/**
	 * Finds the smallest value in this.set
	 * @return min	Smallest value in this.set
	 */
	public int smallest()  {
		int min = Collections.min(this.set);
		return min;
	};

	
	/**
	 * Adds a value to this.set if the value is not already present
	 * @param item	int value to add
	 */
	public void add(int item) {
		if (!this.set.contains(item)) {
			this.set.add(item);
		}
	};

	/**
	 * Removes a value from this.set if the value is present
	 * @param item	int value to be removed
	 */
	public void remove(int item) {
		if (this.set.contains(item)) {
			int index = this.set.indexOf(item);
			this.set.remove(index);
		}
	}; 

	/**
	 * Updates this.set to be the union of itself and the set of the passed IntegerSet, the union being the combination of the sets
	 * References: https://stackoverflow.com/questions/9917787/merging-two-arraylists-into-a-new-arraylist-with-no-duplicates-and-in-order-in
	 * @param intSetb	IntegerList to be added
	 */
	public void union(IntegerSet intSetb) {
		this.set.removeAll(intSetb.set);
		this.set.addAll(intSetb.set);
	};

	
	/**
	 * Updates this.set to be the intersection of itself and the set of the passed IntegerSet, the intersection being all integers that are shared between the sets
	 * References: https://stackoverflow.com/questions/5283047/intersection-and-union-of-arraylists-in-java
	 * @param intSetb	IntegerSet to be compared
	 */
	public void intersect(IntegerSet intSetb) {
		var newList = new ArrayList<Integer>();
		for (int i : this.set) {
			if(intSetb.contains(i)) {
				newList.add(i);
			}
		}
		this.set = newList;
	}; 

	/**
	 * Updates this.set to be the difference between itself and the set of the passed IntegerSet, the difference being the values in this.set that are not in the passed set
	 * @param intSetb	IntegerSet to be compared
	 */
	public void diff(IntegerSet intSetb) {
		for (int i : intSetb.set) {
			if (this.set.contains(i)) {
				this.set.remove(this.set.indexOf(i));
			}
		}
	};

	/**
	 * Updates this.set to be the complement of itself and the set of the passed IntegerSet, the complement being the values of the passed set not in this.set
	 * @param intSetb	IntegerSet to be compared
	 */
	public void complement(IntegerSet intSetb) {
		var newList = new ArrayList<>(intSetb.set);
		newList.removeAll(this.set);
		this.set = newList;
	}

	/**
	 * Determines whether this.set is empty
	 * @return true if this.set is empty
	 * @return false if this.set is not empty
	 */
	public boolean isEmpty() {
		return this.set.isEmpty();
	}; 
	
	/**
	 * Getter for this.set
	 * @return	this.set
	 */
	public List<Integer> getSet(){
		return this.set;
	}


	/**
	 * String representation of the IntegerSet object
	 * @return	set.toString()
	 */
	@Override
	public String toString() {
		return set.toString();
		};

}