package com.sharode.Collections;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.sharode.Collections.DoubleLinkedList.DoubleLinkedList;

class DoubleLinkedListTesting {
	
	private Random random = new Random();
	
	@Test
	@DisplayName("Test add single value to double linked list.")
	void DoubleLinkedListTest_AddAndGet_001() {
		
		DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<Integer>();
		
		int randomInteger = random.nextInt();
		
		doubleLinkedList.add(randomInteger);
		
		assertTrue(doubleLinkedList.size() == 1 && doubleLinkedList.get(0) == randomInteger);
	}
	
	@Test
	@DisplayName("Test add multiple values to double linked list.")
	void DoubleLinkedListTest_AddAndGet_002() {
		
		DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<Integer>();
		
		int[] randomIntegers = {random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt()};
		
		for(int i = 0; i < randomIntegers.length; i++) {
			doubleLinkedList.add(randomIntegers[i]);
		}
		
		for(int i = 0; i < randomIntegers.length; i++) {
			assertTrue(doubleLinkedList.get(i) == randomIntegers[i]);
		}
		
		assertTrue(doubleLinkedList.size() == 5);
	}
	
	@Test
	@DisplayName("Test add null value to double linked list.")
	void DoubleLinkedListTest_AddAndGet_003() {
		
		DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<Integer>();
		
		doubleLinkedList.add(null);
		
		assertTrue(doubleLinkedList.size() == 0);
	}
	
	@Test
	@DisplayName("Test get value from empty double linked list.")
	void DoubleLinkedListTest_AddAndGet_004() {
		
		DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<Integer>();
		
		boolean result = false;
		
		try {
			doubleLinkedList.get(0);
		}
		catch (IndexOutOfBoundsException e) {
			result = true;
		}
		
		assertTrue(result);
	}
	
	@Test
	@DisplayName("Test get value outside the bounds of the double linked list.")
	void DoubleLinkedListTest_AddAndGet_005() {
		
		DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<Integer>();
		
		boolean result = false;
		
		int[] randomIntegers = {random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt()};
		
		for(int i = 0; i < randomIntegers.length; i++) {
			doubleLinkedList.add(randomIntegers[i]);
		}
		
		try {
			doubleLinkedList.get(randomIntegers.length);
		}
		catch (IndexOutOfBoundsException e) {
			result = true;
		}
		
		assertTrue(result);
	}
	
	@Test
	@DisplayName("Test insert value into head of double linked list.")
	void DoubleLinkedListTest_Insert_001() {
		
		DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<Integer>();
		
		int[] randomIntegers = {random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt()};
		int randomInteger = random.nextInt();
		
		for(int i = 0; i < randomIntegers.length; i++) {
			doubleLinkedList.add(randomIntegers[i]);
		}
		
		doubleLinkedList.insert(0, randomInteger);
		
		assertTrue(doubleLinkedList.get(0) == randomInteger && doubleLinkedList.size() == 6);
	}
	
	@Test
	@DisplayName("Test insert value into end of double linked list.")
	void DoubleLinkedListTest_Insert_002() {
		
		DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<Integer>();
		
		int[] randomIntegers = {random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt()};
		int randomInteger = random.nextInt();
		
		for(int i = 0; i < randomIntegers.length; i++) {
			doubleLinkedList.add(randomIntegers[i]);
		}
		
		doubleLinkedList.insert(randomIntegers.length, randomInteger);
		
		assertTrue(doubleLinkedList.get(randomIntegers.length) == randomInteger && doubleLinkedList.size() == 6);
	}
	
	@Test
	@DisplayName("Test insert single value into double linked list.")
	void DoubleLinkedListTest_Insert_003() {
		
		DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<Integer>();
		
		int[] randomIntegers = {random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt()};
		int randomInteger = random.nextInt();
		
		for(int i = 0; i < randomIntegers.length; i++) {
			doubleLinkedList.add(randomIntegers[i]);
		}
		
		doubleLinkedList.insert(3, randomInteger);
		
		assertTrue(doubleLinkedList.get(3) == randomInteger && doubleLinkedList.size() == 6);
	}
	
	@Test
	@DisplayName("Test insert multiple values into double linked list.")
	void DoubleLinkedListTest_Insert_004() {
		
		DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<Integer>();
		
		int[] randomIntegersOne = {random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt()};
		int[] randomIntegersTwo = {random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt()};

		int[] concat = new int[randomIntegersOne.length * 2];
		int index = 0;
		
		for (int i = 0; i < randomIntegersOne.length; i++) {
		    concat[index++] = randomIntegersOne[i];
		    concat[index++] = randomIntegersTwo[i];
		}
		
		for(int i = 0; i < randomIntegersTwo.length; i++) {
			doubleLinkedList.add(randomIntegersTwo[i]);
		}
		
		for(int i = 0; i < randomIntegersOne.length; i++) {
			doubleLinkedList.insert((i * 2), randomIntegersOne[i]);
		}
		
		for(int i = 0; i < concat.length; i++) {
			assertTrue(doubleLinkedList.get(i) == concat[i]);
		}
		
		assertTrue(doubleLinkedList.size() == 10);
	}
	
	@Test
	@DisplayName("Test insert value into empty double linked list.")
	void DoubleLinkedListTest_Insert_005() {
		
		DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<Integer>();
		
		int randomInteger = random.nextInt();
		
		doubleLinkedList.insert(0, randomInteger);
		
		assertTrue(doubleLinkedList.get(0) == randomInteger && doubleLinkedList.size() == 1);
	}
	
	@Test
	@DisplayName("Test insert value outside bounds of the double linked list.")
	void DoubleLinkedListTest_Insert_006() {
		
		DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<Integer>();
		
		boolean result = false;
		
		int[] randomIntegers = {random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt()};
		
		for(int i = 0; i < randomIntegers.length; i++) {
			doubleLinkedList.add(randomIntegers[i]);
		}
		
		try {
			doubleLinkedList.insert((randomIntegers.length + 1), random.nextInt());
		}
		catch (IndexOutOfBoundsException e) {
			result = true;
		}
		
		assertTrue(result);
	}
	
	@Test
	@DisplayName("Test remove value from head of double linked list.")
	void DoubleLinkedListTest_Remove_001() {
		
		DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<Integer>();
		
		int[] randomIntegers = {random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt()};
		
		for(int i = 0; i < randomIntegers.length; i++) {
			doubleLinkedList.add(randomIntegers[i]);
		}
		
		int randomInteger = doubleLinkedList.remove(0);
		
		assertTrue(randomIntegers[0] == randomInteger && doubleLinkedList.size() == 4);
	}
	
	@Test
	@DisplayName("Test remove value from end of double linked list.")
	void DoubleLinkedListTest_Remove_002() {
		
		DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<Integer>();
		
		int[] randomIntegers = {random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt()};
		
		for(int i = 0; i < randomIntegers.length; i++) {
			doubleLinkedList.add(randomIntegers[i]);
		}
		
		int randomInteger = doubleLinkedList.remove((randomIntegers.length - 1));
		
		assertTrue(randomIntegers[4] == randomInteger && doubleLinkedList.size() == 4);
	}
	
	@Test
	@DisplayName("Test remove value from double linked list.")
	void DoubleLinkedListTest_Remove_003() {
		
		DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<Integer>();
		
		int[] randomIntegers = {random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt()};
		
		for(int i = 0; i < randomIntegers.length; i++) {
			doubleLinkedList.add(randomIntegers[i]);
		}
		
		int randomInteger = doubleLinkedList.remove(2);
		
		assertTrue(randomIntegers[2] == randomInteger && doubleLinkedList.size() == 4);
	}
	
	@Test
	@DisplayName("Test remove value from double linked list.")
	void DoubleLinkedListTest_Remove_004() {
		
		DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<Integer>();
		
		int[] randomIntegers = {random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt()};
		
		for(int i = 0; i < randomIntegers.length; i++) {
			doubleLinkedList.add(randomIntegers[i]);
		}
		
		for(int i = 4; i >= 0; i--) {
			assertTrue(doubleLinkedList.remove(i * 2) == randomIntegers[i * 2]);
		}
		
		assertTrue(doubleLinkedList.size() == 5);
	}
	
	@Test
	@DisplayName("Test remove value from empty double linked list.")
	void DoubleLinkedListTest_Remove_005() {
		
		DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<Integer>();
		
		boolean result = false;
		
		try {
			int randomInteger = doubleLinkedList.remove(0);
		}
		catch (IndexOutOfBoundsException e) {
			result = true;
		}
		
		assertTrue(result);
	}
	
	@Test
	@DisplayName("Test remove value outside the bounds of the double linked list.")
	void DoubleLinkedListTest_Remove_006() {
		
		DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<Integer>();
		
		boolean result = false;
		
		int[] randomIntegers = {random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt()};
		
		for(int i = 0; i < randomIntegers.length; i++) {
			doubleLinkedList.add(randomIntegers[i]);
		}
		
		try {
			int randomInteger = doubleLinkedList.remove(randomIntegers.length);
		}
		catch (IndexOutOfBoundsException e) {
			result = true;
		}
		
		assertTrue(result);
	}

	@Test
	@DisplayName("Test size of double linked list after default initialisation.")
	void DoubleLinkedListTest_size_001() {
		
		DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<Integer>();
		
		assertTrue(doubleLinkedList.size() == 0);
	}
	
	@Test
	@DisplayName("Test size of double linked list after passing value with constructor.")
	void DoubleLinkedListTest_size_002() {
		
		DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<Integer>(5);
		
		assertTrue(doubleLinkedList.size() == 1);
	}
	
	@Test
	@DisplayName("Test size of double linked list after add.")
	void DoubleLinkedListTest_size_003() {
		
		DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<Integer>();
		
		int numberOfElements = 50;
		
		for(int i = 0; i < numberOfElements; i++) {
			doubleLinkedList.add(random.nextInt());
		}
		
		assertTrue(doubleLinkedList.size() == numberOfElements);
	}
	
	@Test
	@DisplayName("Test size of double linked list after remove.")
	void DoubleLinkedListTest_size_004() {
		
		DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<Integer>();
		
		int numberOfElements = 50;
		
		for(int i = 0; i < numberOfElements; i++) {
			doubleLinkedList.add(random.nextInt());
		}
		
		for(int i = 0; i < 25; i++) {
			doubleLinkedList.remove(i);
		}
		
		assertTrue(doubleLinkedList.size() == 25);
	}
	
	@Test
	@DisplayName("Test size of double linked list after insert.")
	void DoubleLinkedListTest_size_005() {
		
		DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<Integer>();
		
		int numberOfElements = 10;
		
		for(int i = 0; i < numberOfElements; i++) {
			doubleLinkedList.add(random.nextInt());
		}
		
		doubleLinkedList.insert(10, random.nextInt());
		doubleLinkedList.insert(0, random.nextInt());
		doubleLinkedList.insert(5, random.nextInt());
		
		assertTrue(doubleLinkedList.size() == 13);
	}
	
	@Test
	@DisplayName("Test size of double linked list after clear.")
	void DoubleLinkedListTest_size_006() {
		
		DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<Integer>();
		
		int numberOfElements = 50;
		
		for(int i = 0; i < numberOfElements; i++) {
			doubleLinkedList.add(random.nextInt());
		}
		
		doubleLinkedList.clear();
		
		assertTrue(doubleLinkedList.size() == 0);
	}
	
	@Test
	@DisplayName("Test get after clear double linked list.")
	void DoubleLinkedListTest_Clear_001() {
		
		DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<Integer>();
		
		boolean result = false;
		
		int[] randomIntegers = {random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt()};
		
		for(int i = 0; i < randomIntegers.length; i++) {
			doubleLinkedList.add(randomIntegers[i]);
		}
		
		doubleLinkedList.clear();
		
		try {
			int randomInteger = doubleLinkedList.get(0);
		}
		catch (IndexOutOfBoundsException e) {
			result = true;
		}
		
		assertTrue(result && doubleLinkedList.size() == 0);
	}
	
	@Test
	@DisplayName("Test remove after clear double linked list.")
	void DoubleLinkedListTest_Clear_002() {
		
		DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<Integer>();
		
		boolean result = false;
		
		int[] randomIntegers = {random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt()};
		
		for(int i = 0; i < randomIntegers.length; i++) {
			doubleLinkedList.add(randomIntegers[i]);
		}
		
		doubleLinkedList.clear();
		
		try {
			int randomInteger = doubleLinkedList.remove(0);
		}
		catch (IndexOutOfBoundsException e) {
			result = true;
		}
		
		assertTrue(result && doubleLinkedList.size() == 0);
	}
	
	@Test
	@DisplayName("Test add after clear double linked list.")
	void DoubleLinkedListTest_Clear_003() {
		
		DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<Integer>();
		
		boolean result = false;
		
		int[] randomIntegers = {random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt()};
		
		for(int i = 0; i < randomIntegers.length; i++) {
			doubleLinkedList.add(randomIntegers[i]);
		}
		
		doubleLinkedList.clear();
		
		int randomInteger = random.nextInt();
		
		doubleLinkedList.add(randomInteger);
		
		assertTrue(doubleLinkedList.get(0) == randomInteger && doubleLinkedList.size() == 1);
	}
	
	@Test
	@DisplayName("Test insert after clear double linked list.")
	void DoubleLinkedListTest_Clear_004() {
		
		DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<Integer>();
		
		boolean result = false;
		
		int[] randomIntegers = {random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt()};
		
		for(int i = 0; i < randomIntegers.length; i++) {
			doubleLinkedList.add(randomIntegers[i]);
		}
		
		doubleLinkedList.clear();
		
		int randomInteger = random.nextInt();
		
		doubleLinkedList.insert(0, randomInteger);
		
		assertTrue(doubleLinkedList.get(0) == randomInteger && doubleLinkedList.size() == 1);
	}
	
}
