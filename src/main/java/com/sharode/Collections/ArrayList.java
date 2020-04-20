package com.sharode.Collections;

import java.util.Arrays;

public class ArrayList<E> {
	
	private E[] data;
    private int capacity = 0;
    private int size = 0;
	
	private static final int INIT_CAPACITY = 10;
	
    public ArrayList() {
        this(INIT_CAPACITY);
    }

    public ArrayList(int initCapacity) {
        capacity = initCapacity;
        data = (E[]) new Comparable[capacity];
    }
	
    /**
     * Adds element specified in parameters to the end of the array.
     * 
     * @param element
     * @return true if element is added successfully.
     */
    public boolean add(E element) {

        capacityCheck(size + 1);
    	 
    	data[size++] = element;
    	
    	return true;
    }
    
    /**
     * Returns the element in the specified index place.
     * 
     * @param index
     * @return element in the index place inside the array.
     */
    public E get(int index) {
    	rangeCheck(index);
    	
    	return data[index];
    }
    
    /**
     * Changes the element in the array at the (index) place, to the element specified in the parameters.
     * 
     * @param index
     * @param element
     * @return The old element stored at the index.
     */
    public E set(int index, E element) {
    	rangeCheck(index);
    	
    	E oldElement = get(index);
    	data[index] = element;
    	
    	return oldElement;
    }
    /**
     * Checks to see if the index is out of bounds. If so, the array is resized.
     * 
     * @param index
     */
    private void capacityCheck(int index) {
    	
    	if(index > capacity) { 
    		
    		capacity += INIT_CAPACITY;
    		
    		data = Arrays.copyOf(data, capacity);
    	}
    }
    
    /**
     * Checks that the index referenced is inside the array bounds.
     * 
     * @param index
     */
    private void rangeCheck(int index) throws IndexOutOfBoundsException{
    	if (index >= size || index < 0) {
    		throw new IndexOutOfBoundsException(index + " is out of this arrays bounds. Array size: " + size);
    	}
    }
    
    /**
     * Returns the current maximum of the array
     * 
     * @return capacity
     */
    public int capacity() {
    	return capacity;
    }
    
	/**
	 * Returns the number of elements in the array
	 * 
	 * @return size
	 */
	public int size() {
		return size;
	}
	
    /**
     * Clears the array, also resets the size and capacity.
     */
    public void clear() {
        capacity = INIT_CAPACITY;
        size = 0;
        data = (E[]) new Comparable[capacity];
	}
    
	/**
	 * Returns current data as an array
	 * 
	 * @return data[]
	 */
    public E[] toArray() {
		return Arrays.copyOf(data, size);
	}
    
    /**
     * This method sweeps over the array, creating a string in array style e.g. [a, b, c]
     * 
     * @return String of all elements in array, with array styling.
     */
    public String toString() {
    	
    	if (size == 0) {
    		return "[]";
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	sb.append('[');
    	
    	for(int i = 0; i < size; i++) {
    		E temp = data[i];
    		sb.append(temp);
    		
    		if(!(i == (size - 1))) {
    			sb.append(", ");
    		}
    	}
    	
    	return sb.append(']').toString();
    }
}
