package com.sharode.Collections.SingleLinkedList;

public class SingleLinkedList<E>{

    private SingleLinkedNode<E> head;
    private SingleLinkedNode<E> tail;

    int size;
    
    public SingleLinkedList() {
        head = new SingleLinkedNode();
        tail = new SingleLinkedNode();

        size = 0;
    }

    public SingleLinkedList(E data) {
        head = new SingleLinkedNode<E>(data);
        tail = head;

        size = 1;
    }
    
    /**
     * Add an element to the tail of the linked list.
     * 
     * @param element
     * @return
     */
    public boolean add(E element) {
    	
    	if(element == null) {
    		return false;
    	}

        if(head.get() == null) {
            head = new SingleLinkedNode<E>(element);
            tail = head;

            size++;
        }
        else {
            tail = tail.add(element);

            size++;
        }
    	
    	return true;
    }

    /**
     * Retrieve element at specified index parameter.
     * 
     * @param index
     * @return
     */
    public E get(int index) {
    	
    	rangeCheck(index);

        SingleLinkedNode<E> current = head;
        
        for(int i = 0; i < index; i++) {

            current = current.getNext();

        }

    	return current.get();
    }

    /**
     * Insert element 1 index after the index specified.
     * 
     * @param index
     * @param Node
     * @return
     */
    public boolean insert(int index, E Node) {
    	
    	if(index != 0 && index != size) {
    		rangeCheck(index);
    	}
    	

        SingleLinkedNode<E> current = head;
        SingleLinkedNode<E> previous = null;

        SingleLinkedNode<E> newNode =  new SingleLinkedNode<E>(Node);

        if(index == 0) {

            newNode.setNext(head);
            head = newNode;

            size++;

            return true;

        }

        for(int i = 0; i < index; i++) {

            if (i == (index - 1)) {
                previous = current;
            }

            current = current.getNext();

        }

        newNode.setNext(current);
        previous.setNext(newNode);

        size++;
    	
    	return true;
    }

    /**
     * Remove element at specified index parameter.
     * 
     * @param index
     * @return
     */
    public E remove(int index) {
        
    	rangeCheck(index);
    	
        SingleLinkedNode<E> current = head;
        SingleLinkedNode<E> previous = null;
        E data = null;

        if(index == 0) {
        	data = current.get();
            head = current.getNext();
            current.setNext(null);
            size--;
        }
        else {

            for(int i = 0; i < size; i++) {

                if (i == index) {
                	
                	data = current.get();
                	
                	if(i == (size -1)) {
                		tail = previous;
                	}
                	
                    previous.setNext(current.getNext());

                    current.setNext(null);
                    size--;
                    break;
                }
  
                previous = current;
                current = current.getNext();

            }
        }

        return data;

    }

    /**
     * clears LinkedList, and resets the List to and empty state.
     */
    public void clear() {
        head.set(null);
        tail.set(null);
        size = 0;
    }

    /**
     * @return the size
     */
    public int size() {
        return size;
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
}

