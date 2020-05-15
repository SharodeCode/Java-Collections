package com.sharode.Collections.Queue;

public class Queue<E> {
	
	private QueueNode<E> front;
	private QueueNode<E> back;
	
	private int size;
	
	public Queue() {
		front = null;
		back = null;
		
		size = 0;
	}
	
    /**
     * Add an element to the end of the queue.
     * 
     * @param	data - data to add to queue
     */
	public void enqueue(E data) {
		
		if(data == null) {
			return;
		}
		
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
	
    /**
     * Return element at the front of the queue, and dequeue from queue.
     * 
     * @return	data from front of queue
     */
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
	
    /**
     * Return element at the front of the queue, without dequeue.
     * 
     * @return	data from front of queue
     */
	public E peek() {
		return front != null ? front.get() : null;
	}
	
	/**
	 * @return	size of queue
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Returns boolean indicating if queue is empty
	 * 
	 * @return	true, if queue is empty
	 */
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
		
		/**
		 * @return	previous element in queue
		 */
		public QueueNode<T> getPrevious() {
			return previousNode;
		}
		
		/**
		 * Sets the previous node in the queue.
		 * 
		 * @param 	data - previous node in queue.
		 */
		public void setPrevious(QueueNode<T> data) {
			previousNode = data;
		}
		
		/**
		 * @return	node data
		 */
		public T get() {
			return data;
		}
	}

}
