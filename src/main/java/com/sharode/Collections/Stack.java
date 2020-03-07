package com.sharode.Collections;

public class Stack<E> {
	
	private StackNode<E> head;
	
	public Stack() {
		head = null;
	}
	
	public Stack(E data) {
		head = new StackNode<E>(data);
	}
	
	public void push(E data) {
		
		StackNode<E> newNode = new StackNode<E>(data);
		
		if(head != null) {
			newNode.setNext(head);
		}
		
		head = new StackNode<E>(data);
	}
	
	public E pop() {
		
		E result;
		
		
		return head.get();
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
		
		public void setNext(StackNode<T> data) {
			nextNode = data;
		}
		
		public T get() {
			return data;
		}
	}

}
