package com.sharode.Collections;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StackTesting {

	@Test
	void StackTest_isEmpty_001() {
		Stack<Integer> stack = new Stack<Integer>(); 
		assertTrue(stack.isEmpty());
	}
	
	@Test
	void StackTest_isEmpty_002() {
		Stack<Integer> stack = new Stack<Integer>(5);
		assertFalse(stack.isEmpty());
	}

}
