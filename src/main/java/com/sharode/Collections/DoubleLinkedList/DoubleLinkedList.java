package com.sharode.Collections.DoubleLinkedList;

import java.util.Arrays;

import com.sharode.Collections.DoubleLinkedList.DoubleLinkedNode;

public class DoubleLinkedList<E>{

	private DoubleLinkedNode<E> head;
	private DoubleLinkedNode<E> tail;

	int size;

	public DoubleLinkedList() {
		head = new DoubleLinkedNode<E>();
		tail = new DoubleLinkedNode<E>();

		size = 0;
	}

	public DoubleLinkedList(E data) {
		head = new DoubleLinkedNode<E>(data);
		tail = head;

		size = 1;
	}

    /**
     * Add an element to the end of the list.
     * 
     * @param	element - element to append to list
     * @return	true, if the add is successful.
     */
	public boolean add(E element) {
		
    	if(element == null) {
    		return false;
    	}

		if (head.get() == null) {
			head = new DoubleLinkedNode<E>(element);
			tail = head;

			size++;
		} else {
			tail = tail.add(element);

			size++;
		}

		return true;
	}

    /**
     * Retrieve element at specified index parameter.
     * 
     * @param	index - index of element to retrieve
     * @return	element at the specified position
     */
	public E get(int index) {

		rangeCheck(index);

		DoubleLinkedNode<E> current = elementAt(index);

		return current.get();
	}

    /**
     * Insert element 1 index after the index specified.
     * 
     * @param	index - index of element to insert after
     * @param	Node - node to insert into list
     * @return	true, if the node was successfully added.
     */
	public boolean insert(int index, E Node) {

    	if(index != 0 && index != size) {
    		rangeCheck(index);
    	}
		
		DoubleLinkedNode<E> newNode = new DoubleLinkedNode<E>(Node);
		DoubleLinkedNode<E> current = elementAt(index);
		
		if (index == 0) {
			
			newNode.setNext(head);
			head = newNode;

			size++;

			return true;
		}
		else if(index == size) {
			tail.setNext(newNode);
			newNode.setPrevious(tail);
			tail = newNode;
		}
		else {
			newNode.setNext(current);
			newNode.setPrevious(current.getPrevious());
			current.getPrevious().setNext(newNode);
			current.setPrevious(newNode);
		}
		
		size++;
		
		return true;
	}

	/**
	 * Remove element at specified index parameter.
	 * 
	 * @param	index - index of element to remove
	 * @return	value of node removed
	 */
	public E remove(int index) {

		rangeCheck(index);

		DoubleLinkedNode<E> current = elementAt(index);
		DoubleLinkedNode<E> previous = current.getPrevious();

		if (index == 0) {
			head = current.getNext();
			current.setNext(null);
			size--;
		} else {

			previous.setNext(current.getNext());

			if (current.getNext() != null) {
				current.getNext().setPrevious(previous);
			} else {
				tail = previous;
			}

			current.setNext(null);
			current.setPrevious(null);

			size--;

		}

		return current.get();
	}

	/**
	 * Returns node at the specified index.
	 * 
	 * @param	index - index of node to retrieve
	 * @return	node at the specified index
	 */
	public DoubleLinkedNode<E> elementAt(int index) {

    	if(index != 0 && index != size) {
    		rangeCheck(index);
    	}
    	
    	if(index == size) {
    		return tail;
    	}

		boolean direction = isUpper(index);

		DoubleLinkedNode<E> temp = direction ? tail : head;

		int limit = direction ? (size - 1) : 0;

		while (limit != index) {

			temp = getNext(direction, temp);

			limit = direction ? --limit : ++limit;
		}

		return temp;
	}

    /**
     * Clears DoubleLinkedList, and resets the List to and empty state.
     */
	public void clear() {

		head.set(null);
		tail.set(null);
		size = 0;
	}

	/**
	 * @return	the size of the list
	 */
	public int size() {
		return size;
	}

	/**
	 * Returns true if the index specified is in the upper half of the list.
	 * 
	 * @param	index - index of node to calculate
	 * @return	true if index is in the upper half of the list
	 */
	private boolean isUpper(int index) {

    	if(index != 0 && index != size) {
    		rangeCheck(index);
    	}

		boolean isUpper;

		if (index <= (size / 2)) {
			isUpper = false;
		} else {
			isUpper = true;
		}

		return isUpper;
	}

	private DoubleLinkedNode<E> getNext(DoubleLinkedNode<E> node) {
		return getNext(false, node);
	}

	/**
	 * Retrieves the next node in the list. This depends on which direction the list is being traversed, 
	 * which is indicated by the reverse parameter.
	 * 
	 * @param 	reverse - indicates if you want to get the previous node.
	 * @param 	node - the current node you wish to get the next of.
	 * @return	the next node in the list.
	 */
	private DoubleLinkedNode<E> getNext(boolean reverse, DoubleLinkedNode<E> node) {

		if (reverse == false) {
			node = node.getNext();
		} else {
			node = node.getPrevious();
		}

		return node;
	}

	private void rangeCheck(int index) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException(index + " is out of this arrays bounds. Array size: " + size);
		}
	}
}
