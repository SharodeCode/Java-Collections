package com.sharode.Collections.SingleLinkedList;

public class SingleLinkedNode<E>{

    private SingleLinkedNode<E> nextNode;
    private E data;
    
    public SingleLinkedNode() {
        data = null;
        nextNode = null;
    }

    public SingleLinkedNode(E data) {
        nextNode = null;
        this.data = data;
    }

    public SingleLinkedNode<E> add(E element) {

        nextNode = new SingleLinkedNode<E>(element);
    	
    	return nextNode;
    }

    public E get() {
    	return data;
    }
    
    public void set(E data) {
    	this.data = data;
    }

    public void setNext(SingleLinkedNode<E> newNext) {
    	nextNode = newNext;
    }

    public SingleLinkedNode<E> getNext() {
    	return nextNode;
    }
}