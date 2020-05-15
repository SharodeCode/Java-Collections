package com.sharode.Collections;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.sharode.Collections.Stack.Stack;

class StackTesting {
	
	Random random = new Random();
	
	@Test
	@DisplayName("Test value after push and pop.")
	void StackTest_pushAndPop_001() {
		
		Stack<Integer> stack = new Stack<Integer>();
		
		int randomInteger = random.nextInt();
		
		stack.push(randomInteger);
		
		assertTrue(stack.pop() == randomInteger);
	}
	
	@Test
	@DisplayName("Test multiple values after push and pop.")
	void StackTest_pushAndPop_002() {

		Stack<Integer> stack = new Stack<Integer>();
		
		int[] randomIntegers = {random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt()};
		
		for(int i = 0; i < randomIntegers.length; i++) {
			stack.push(randomIntegers[i]);
		}
		
		for(int i = (randomIntegers.length - 1); i >= 0; i--) {
			assertTrue(stack.pop() == randomIntegers[i]);
		}
	}
	
	@Test
	@DisplayName("Test multiple values after addind and removing values.")
	void StackTest_pushAndPop_003() {

		Stack<Integer> stack = new Stack<Integer>();
		
		int[] randomIntegers = {random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt()};
		
		for(int i = 0; i < randomIntegers.length; i++) {
			stack.push(randomIntegers[i]);
		}
		
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		
		for(int i = 0; i < randomIntegers.length; i++) {
			stack.push(randomIntegers[i]);
		}
		
		for(int i = (randomIntegers.length - 1); i >= 0; i--) {
			assertTrue(stack.pop() == randomIntegers[i]);
		}
	}
	
	@Test
	@DisplayName("Test push null value.")
	void StackTest_pushAndPop_004() {
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(null);
		
		assertTrue(stack.size() == 0);
	}
	
	@Test
	@DisplayName("Test if isEmpty returns true on an empty initialised stack.")
	void StackTest_isEmpty_001() {
		Stack<Integer> stack = new Stack<Integer>(); 
		assertTrue(stack.isEmpty());
	}
	
	@Test
	@DisplayName("Test if isEmpty returns false on a stack with one element.")
	void StackTest_isEmpty_002() {
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(5);
		
		assertFalse(stack.isEmpty());
	}
	
	@Test
	@DisplayName("Test if isEmpty returns true after a push and pop call.")
	void StackTest_isEmpty_003() {
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(5);
		stack.pop();
		
		assertTrue(stack.isEmpty());
	}
	
	@Test
	@DisplayName("Test size of initial stack.")
	void StackTest_size_001() {
		Stack<Integer> stack = new Stack<Integer>();
		
		assertTrue(stack.size() == 0);
	}
	
	@Test
	@DisplayName("Test size of stack after pushing a value.")
	void StackTest_size_002() {
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(5);
		
		assertTrue(stack.size() == 1);
	}
	
	@Test
	@DisplayName("Test size of stack after pushing then popping a value.")
	void StackTest_size_003() {
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(5);
		stack.pop();
		
		assertTrue(stack.size() == 0);
	}
	
	@Test
	@DisplayName("Test peek of initial stack.")
	void StackTest_peek_001() {
		Stack<Integer> stack = new Stack<Integer>();
		
		assertTrue(stack.peek() == null);
	}
	
	@Test
	@DisplayName("Test peek after pushing value to stack.")
	void StackTest_peek_002() {

		Stack<Integer> stack = new Stack<Integer>();
		
		int testValue = random.nextInt();
		stack.push(testValue);
		
		assertTrue(stack.peek() == testValue);
	}
	
	@Test
	@DisplayName("Test peek after popping values from stack.")
	void StackTest_peek_003() {

		Stack<Integer> stack = new Stack<Integer>();
		
		int[] randomIntegers = {random.nextInt(), random.nextInt(), random.nextInt()};
		
		stack.push(randomIntegers[0]);
		stack.push(randomIntegers[1]);
		stack.push(randomIntegers[2]);
		stack.pop();
		
		assertTrue(stack.peek() == randomIntegers[1]);
	}
	
}
