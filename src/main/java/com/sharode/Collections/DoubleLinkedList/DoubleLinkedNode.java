package com.sharode.Collections.DoubleLinkedList;

import com.sharode.Collections.DoubleLinkedList.DoubleLinkedNode;

public class DoubleLinkedNode<E> {

	private DoubleLinkedNode<E> nextNode;
	private DoubleLinkedNode<E> previousNode;
	private E data;

	public DoubleLinkedNode() {
		data = null;
		nextNode = null;
		previousNode = null;
	}

	public DoubleLinkedNode(E data) {
		nextNode = null;
		previousNode = null;
		this.data = data;
	}
	
    public DoubleLinkedNode<E> add(E element) {

        nextNode = new DoubleLinkedNode<E>(element);
        nextNode.setPrevious(this);
    	
    	return nextNode;
    }
    
    public E get() {
    	return data;
    }
    
    public void set(E data) {
    	this.data = data;
    }
    
    public DoubleLinkedNode<E> getPrevious() {
    	return previousNode;
    }
    
    public void setPrevious(DoubleLinkedNode<E> newPrevious) {
    	previousNode = newPrevious;
    }
    
    public DoubleLinkedNode<E> getNext() {
    	return nextNode;
    }
    
    public void setNext(DoubleLinkedNode<E> newNext) {
    	nextNode = newNext;
    }

}
