package com.sharode.Collections;

public class Stack<E> {
	
	private StackNode<E> head;
	private int size;
	
	public Stack() {
		head = null;
		size = 0;
	}
	
	public void push(E data) {
		
		StackNode<E> newNode = new StackNode<E>(data);
		
		if(head != null) {
			newNode.setNext(head);
		}
		
		head = newNode;
		
		size++;
	}
	
	public E pop() {
		
		E result = head.get();
		
		head = head.getNext();
		
		size--;
		
		return result;
	}
	
	public E peek() {
		return head != null ? head.get() : null;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		boolean result = false;
		
		if(head == null) {
			result = true;
		}
		
		return result;
	}
	
	private class StackNode<T> {
		
		T data;
		
		StackNode<T> nextNode;
		
		StackNode(T data) {
			this.data = data;
			nextNode = null;
		}
		
		public StackNode<T> getNext() {
			return nextNode;
		}
		
		public void setNext(StackNode<T> data) {
			nextNode = data;
		}
		
		public T get() {
			return data;
		}
	}

}
