package com.sharode.Collections;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.sharode.Collections.Queue.Queue;

class QueueTesting {
	
	private Random random = new Random();
	
	@Test
	@DisplayName("Test value after enqueue then dequeue.")
	void QueueTest_enqueueAndDequeue_001() {
		Queue<Integer> queue = new Queue<Integer>();
		
		int randomInteger = random.nextInt();
		
		queue.enqueue(randomInteger);
		
		assertTrue(queue.dequeue() == randomInteger);
	}
	
	@Test
	@DisplayName("Test multiple values using enqueue and dequeue.")
	void QueueTest_enqueueAndDequeue_002() {
		Queue<Integer> queue = new Queue<Integer>();
		
		int[] randomIntegers = {random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt()};
		
		for(int i = 0; i < randomIntegers.length; i++) {
			queue.enqueue(randomIntegers[i]);
		}
		
		for(int i = 0; i < randomIntegers.length; i++) {
			assertTrue(queue.dequeue() == randomIntegers[i]);
		}
	}
	
	@Test
	@DisplayName("Test multiple values after dequeuing values.")
	void QueueTest_enqueueAndDequeue_003() {
		Queue<Integer> queue = new Queue<Integer>();
		
		int[] randomIntegersOne = {random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt()};
		int[] randomIntegersTwo = {random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt()};
		
		for(int i = 0; i < randomIntegersOne.length; i++) {
			queue.enqueue(randomIntegersOne[i]);
		}
		
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		
		for(int i = 0; i < randomIntegersTwo.length; i++) {
			queue.enqueue(randomIntegersTwo[i]);
		}
		
		for(int i = 0; i < randomIntegersTwo.length; i++) {
			assertTrue(queue.dequeue() == randomIntegersTwo[i]);
		}
	}
	
	@Test
	@DisplayName("Test enqueue null value.")
	void QueueTest_enqueueAndDequeue_004() {
		Queue<Integer> queue = new Queue<Integer>();
		
		queue.enqueue(null);
		
		assertTrue(queue.size() == 0);
	}
	
	@Test
	@DisplayName("Test if isEmpty returns true on an initialised queue.")
	void QueueTest_isEmpty_001() {
		Queue<Integer> queue = new Queue<Integer>(); 
		assertTrue(queue.isEmpty());
	}
	
	@Test
	@DisplayName("Test if isEmpty returns false on a queue with one element.")
	void QueueTest_isEmpty_002() {
		Queue<Integer> queue = new Queue<Integer>();
		
		queue.enqueue(random.nextInt());
		
		assertFalse(queue.isEmpty());
	}
	
	@Test
	@DisplayName("Test if isEmpty returns true after enqueue and dequeue.")
	void QueueTest_isEmpty_003() {
		Queue<Integer> queue = new Queue<Integer>();
		
		queue.enqueue(random.nextInt());
		queue.dequeue();
		
		assertTrue(queue.isEmpty());
	}
	
	@Test
	@DisplayName("Test size of initial queue.")
	void QueueTest_size_001() {
		Queue<Integer> queue = new Queue<Integer>();
		
		assertTrue(queue.size() == 0);
	}
	
	@Test
	@DisplayName("Test size of queue after enqueuing a value.")
	void QueueTest_size_002() {
		Queue<Integer> queue = new Queue<Integer>();
		
		queue.enqueue(random.nextInt());
		
		assertTrue(queue.size() == 1);
	}
	
	@Test
	@DisplayName("Test size of queue after enqueuing and dequeuing values.")
	void QueueTest_size_003() {
		Queue<Integer> queue = new Queue<Integer>();
		
		queue.enqueue(random.nextInt());
		queue.enqueue(random.nextInt());
		queue.dequeue();
		queue.enqueue(random.nextInt());
		queue.dequeue();
		
		assertTrue(queue.size() == 1);
	}
	
	@Test
	@DisplayName("Test peek of initial queue.")
	void QueueTest_peek_001() {
		Queue<Integer> queue = new Queue<Integer>();
		
		assertTrue(queue.peek() == null);
	}
	
	@Test
	@DisplayName("Test peek after enqueuing value.")
	void QueueTest_peek_002() {
		Queue<Integer> queue = new Queue<Integer>();
		
		int testValue = random.nextInt();
		queue.enqueue(testValue);
		
		assertTrue(queue.peek() == testValue);
	}
	
	@Test
	@DisplayName("Test peek after dequeuing values.")
	void QueueTest_peek_003() {
		Queue<Integer> queue = new Queue<Integer>();
		
		int[] randomIntegers = {random.nextInt(), random.nextInt(), random.nextInt()};
		
		queue.enqueue(randomIntegers[0]);
		queue.enqueue(randomIntegers[1]);
		queue.enqueue(randomIntegers[2]);
		queue.dequeue();
		
		assertTrue(queue.peek() == randomIntegers[1]);
	}
}
