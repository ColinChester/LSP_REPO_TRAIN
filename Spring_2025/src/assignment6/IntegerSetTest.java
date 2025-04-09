package assignment6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class IntegerSetTest {

    @Test
    @DisplayName("Clear set and check if empty")
    public void testClearAndIsEmpty() {
        IntegerSet intSet = new IntegerSet();
        intSet.add(1);
        intSet.add(2);
        intSet.clear();
        assertTrue(intSet.isEmpty(), "The set should be empty");
    }

    @Test
    @DisplayName("Length returns correct size")
    public void testLength() {
        IntegerSet intSet = new IntegerSet();
        assertEquals(0, intSet.length(), "Empty set should have length 0");
        intSet.add(5);
        intSet.add(10);
        assertEquals(2, intSet.length(), "Set should have length 2 after adding two values");
    }

    @Test
    @DisplayName("Check equality of sets")
    public void testEquals() {
        IntegerSet set1 = new IntegerSet(new ArrayList<>(Arrays.asList(1, 2, 3)));
        IntegerSet set2 = new IntegerSet(new ArrayList<>(Arrays.asList(1, 2, 3)));
        IntegerSet set3 = new IntegerSet(new ArrayList<>(Arrays.asList(3, 2, 1)));
        IntegerSet set4 = new IntegerSet(new ArrayList<>(Arrays.asList(1, 2)));

        assertTrue(set1.equals(set2), "Sets with the same elements in the same order should be equal");
        assertFalse(set1.equals(set4), "Sets with different elements shouldn't be equal");
        assertFalse(set1.equals(null), "A set shouldn't be equal to null");
        assertFalse(set1.equals(""), "A set shouldn't be equal to an object of a different type");
    }

    @Test
    @DisplayName("Check if set contains value")
    public void testContains() {
        IntegerSet intSet = new IntegerSet();
        intSet.add(7);
        intSet.add(15);
        assertTrue(intSet.contains(7), "The set should contain 7");
        assertFalse(intSet.contains(10), "The set shouldn't contain 10");
    }

    @Test
    @DisplayName("Find largest and smallest in set")
    public void testLargestAndSmallest() {
        IntegerSet intSet = new IntegerSet();
        intSet.add(3);
        intSet.add(10);
        intSet.add(7);
        assertEquals(10, intSet.largest(), "The largest element should be 10");
        assertEquals(3, intSet.smallest(), "The smallest element should be 3");

        intSet.clear();
        assertThrows(NoSuchElementException.class, intSet::largest, "Calling largest() on an empty set should throw NoSuchElementException");
        assertThrows(NoSuchElementException.class, intSet::smallest, "Calling smallest() on an empty set should throw NoSuchElementException");
    }

    @Test
    @DisplayName("Add elements to set")
    public void testAdd() {
        IntegerSet intSet = new IntegerSet();
        intSet.add(1);
        intSet.add(1);
        assertEquals(1, intSet.length(), "Adding a duplicate shouldn't increase the set's size");
        intSet.add(2);
        assertTrue(intSet.contains(2), "The set should contain 2 after adding it");
    }

    @Test
    @DisplayName("Remove elements from set")
    public void testRemove() {
        IntegerSet intSet = new IntegerSet();
        intSet.add(1);
        intSet.add(2);
        intSet.remove(1);
        assertFalse(intSet.contains(1), "Element 1 should be removed");
        intSet.remove(3);
        assertEquals(1, intSet.length(), "Removing a element that isn't in the set shouldn't affect size");
    }

    @Test
    @DisplayName("Union of two sets")
    public void testUnion() {
        IntegerSet setA = new IntegerSet(new ArrayList<>(Arrays.asList(1, 2, 3)));
        IntegerSet setB = new IntegerSet(new ArrayList<>(Arrays.asList(3, 4, 5)));
        setA.union(setB);

        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        assertEquals(5, setA.length(), "Union should have 5 values.");
        for (int val : expected) {
            assertTrue(setA.contains(val), "Union should have " + val + ".");
        }
    }

    @Test
    @DisplayName("Intersection of two sets")
    public void testIntersect() {
        IntegerSet setA = new IntegerSet(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
        IntegerSet setB = new IntegerSet(new ArrayList<>(Arrays.asList(3, 4, 5, 6)));
        setA.intersect(setB);

        List<Integer> expected = new ArrayList<>(Arrays.asList(3, 4));
        assertEquals(expected.size(), setA.length(), "Intersection should have 2 values");
        for (int val : expected) {
            assertTrue(setA.contains(val), "Intersection should have " + val);
        }
    }

    @Test
    @DisplayName("Difference of two sets")
    public void testDiff() {
        IntegerSet setA = new IntegerSet(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
        IntegerSet setB = new IntegerSet(new ArrayList<>(Arrays.asList(3, 4, 5, 6)));
        setA.diff(setB);

        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2));
        assertEquals(expected.size(), setA.length(), "Difference should have 2 values");
        for (int val : expected) {
            assertTrue(setA.contains(val), "Difference should have " + val);
        }
    }

    @Test
    @DisplayName("Complement of two sets")
    public void testComplement() {
        IntegerSet setA = new IntegerSet(new ArrayList<>(Arrays.asList(1, 2, 3)));
        IntegerSet setB = new IntegerSet(new ArrayList<>(Arrays.asList(2, 3, 4, 5)));
        setA.complement(setB);

        List<Integer> expected = new ArrayList<>(Arrays.asList(4, 5));
        assertEquals(expected.size(), setA.length(), "Complement should have 2 elements");
        for (int val : expected) {
            assertTrue(setA.contains(val), "Complement should contain " + val);
        }
    }

    @Test
    @DisplayName("toString() and getSet() outputs")
    public void testToStringAndGetSet() {
        IntegerSet intSet = new IntegerSet();
        intSet.add(10);
        intSet.add(20);

        String str = intSet.toString();
        assertTrue(str.contains("10") && str.contains("20"), "toString() should include the values in the set");

        List<Integer> internalSet = intSet.getSet();
        assertEquals(2, internalSet.size(), "getSet() should contain 2 elements.");
        assertTrue(internalSet.contains(10) && internalSet.contains(20), "getSet() should have 10 and 20");
    }
}
