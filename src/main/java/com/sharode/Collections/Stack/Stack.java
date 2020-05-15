package com.sharode.Collections.Stack;

public class Stack<E> {
	
	private StackNode<E> head;
	private int size;
	
	public Stack() {
		head = null;
		size = 0;
	}
	
	/**
	 * Pushes data to the top of the stack.
	 * 
	 * @param 	data - data to push to stack.
	 */
	public void push(E data) {
		
		if(data == null) {
			return;
		}
		
		StackNode<E> newNode = new StackNode<E>(data);
		
		if(head != null) {
			newNode.setNext(head);
		}
		
		head = newNode;
		
		size++;
	}
	
	/**
	 * Pops and returns data from the top of the stack.
	 * 
	 * @return	data from the top of the stack
	 */
	public E pop() {
		
		E result = head.get();
		
		head = head.getNext();
		
		size--;
		
		return result;
	}
	
	/**
	 * Returns data from the top of the stack without popping.
	 * 
	 * @return	data from the top of the stack
	 */
	public E peek() {
		return head != null ? head.get() : null;
	}
	
	/**
	 * @return	size of stack
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Returns boolean indicating if stack is empty
	 * 
	 * @return	true, if stack is empty
	 */
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
		
		/**
		 * @return	next element in stack
		 */
		public StackNode<T> getNext() {
			return nextNode;
		}
		
		/**
		 * Sets the next node in the stack.
		 * 
		 * @param 	data - data to set node.
		 */
		public void setNext(StackNode<T> data) {
			nextNode = data;
		}
		
		/**
		 * @return	node data
		 */
		public T get() {
			return data;
		}
	}

}
