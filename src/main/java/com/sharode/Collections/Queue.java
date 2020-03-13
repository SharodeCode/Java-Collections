package com.sharode.Collections;

public class Queue<E> {
	
	private QueueNode<E> front;
	private QueueNode<E> back;
	
	private int size;
	
	public Queue() {
		front = null;
		back = null;
		
		size = 0;
	}
	
	public void enqueue(E data) {
		
		QueueNode<E> newNode = new QueueNode<E>(data);
		
		if(front == null) {
			front = newNode;
			back = newNode;
		}
		else {
			back.setPrevious(newNode);
			back = newNode;
		}
		
		size++;
	}
	
	public E dequeue() {
		
		E result;
		
		if(front.getPrevious() == null) {
			result = front.get();
			front = null;
			back = null;
		}
		else {
			result = front.get();
			front = front.getPrevious();
		}
		
		
		size--;
		
		return result;
	}
	
	public E peek() {
		return front != null ? front.get() : null;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		boolean result = false;
		
		if(front == null) {
			result = true;
		}
		
		return result;
	}
	
	private class QueueNode<T> {
		
		private T data;
		
		private QueueNode<T> previousNode;
		
		QueueNode(T data) {
			this.data = data;
			previousNode = null;
		}
		
		public QueueNode<T> getPrevious() {
			return previousNode;
		}
		
		public void setPrevious(QueueNode<T> data) {
			previousNode = data;
		}
		
		public T get() {
			return data;
		}
	}

}
