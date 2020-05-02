package com.sharode.Collections;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.sharode.Collections.SingleLinkedList.SingleLinkedList;

class SingleLinkedListTesting {
	
	private Random random = new Random();
	
	@Test
	@DisplayName("Test add single value to single linked list.")
	void SingleLinkedListTest_AddAndGet_001() {
		
		SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
		
		int randomInteger = random.nextInt();
		
		singleLinkedList.add(randomInteger);
		
		assertTrue(singleLinkedList.size() == 1 && singleLinkedList.get(0) == randomInteger);
	}
	
	@Test
	@DisplayName("Test add multiple values to single linked list.")
	void SingleLinkedListTest_AddAndGet_002() {
		
		SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
		
		int[] randomIntegers = {random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt()};
		
		for(int i = 0; i < randomIntegers.length; i++) {
			singleLinkedList.add(randomIntegers[i]);
		}
		
		for(int i = 0; i < randomIntegers.length; i++) {
			assertTrue(singleLinkedList.get(i) == randomIntegers[i]);
		}
		
		assertTrue(singleLinkedList.size() == 5);
	}
	
	@Test
	@DisplayName("Test add null value to single linked list.")
	void SingleLinkedListTest_AddAndGet_003() {
		
		SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
		
		singleLinkedList.add(null);
		
		assertTrue(singleLinkedList.size() == 0);
	}
	
	@Test
	@DisplayName("Test get value from empty single linked list.")
	void SingleLinkedListTest_AddAndGet_004() {
		
		SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
		
		boolean result = false;
		
		try {
			singleLinkedList.get(0);
		}
		catch (IndexOutOfBoundsException e) {
			result = true;
		}
		
		assertTrue(result);
	}
	
	@Test
	@DisplayName("Test get value outside the bounds of the single linked list.")
	void SingleLinkedListTest_AddAndGet_005() {
		
		SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
		
		boolean result = false;
		
		int[] randomIntegers = {random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt()};
		
		for(int i = 0; i < randomIntegers.length; i++) {
			singleLinkedList.add(randomIntegers[i]);
		}
		
		try {
			singleLinkedList.get(randomIntegers.length);
		}
		catch (IndexOutOfBoundsException e) {
			result = true;
		}
		
		assertTrue(result);
	}
	
	@Test
	@DisplayName("Test insert value into head of single linked list.")
	void SingleLinkedListTest_Insert_001() {
		
		SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
		
		int[] randomIntegers = {random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt()};
		int randomInteger = random.nextInt();
		
		for(int i = 0; i < randomIntegers.length; i++) {
			singleLinkedList.add(randomIntegers[i]);
		}
		
		singleLinkedList.insert(0, randomInteger);
		
		assertTrue(singleLinkedList.get(0) == randomInteger && singleLinkedList.size() == 6);
	}
	
	@Test
	@DisplayName("Test insert value into end of single linked list.")
	void SingleLinkedListTest_Insert_002() {
		
		SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
		
		int[] randomIntegers = {random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt()};
		int randomInteger = random.nextInt();
		
		for(int i = 0; i < randomIntegers.length; i++) {
			singleLinkedList.add(randomIntegers[i]);
		}
		
		singleLinkedList.insert(randomIntegers.length, randomInteger);
		
		assertTrue(singleLinkedList.get(randomIntegers.length) == randomInteger && singleLinkedList.size() == 6);
	}
	
	@Test
	@DisplayName("Test insert single value into single linked list.")
	void SingleLinkedListTest_Insert_003() {
		
		SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
		
		int[] randomIntegers = {random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt()};
		int randomInteger = random.nextInt();
		
		for(int i = 0; i < randomIntegers.length; i++) {
			singleLinkedList.add(randomIntegers[i]);
		}
		
		singleLinkedList.insert(3, randomInteger);
		
		assertTrue(singleLinkedList.get(3) == randomInteger && singleLinkedList.size() == 6);
	}
	
	@Test
	@DisplayName("Test insert multiple values into single linked list.")
	void SingleLinkedListTest_Insert_004() {
		
		SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
		
		int[] randomIntegersOne = {random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt()};
		int[] randomIntegersTwo = {random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt()};

		int[] concat = new int[randomIntegersOne.length * 2];
		int index = 0;
		for (int i = 0; i < randomIntegersOne.length; i++) {
		    concat[index++] = randomIntegersOne[i];
		    concat[index++] = randomIntegersTwo[i];
		}
		
		for(int i = 0; i < randomIntegersTwo.length; i++) {
			singleLinkedList.add(randomIntegersTwo[i]);
		}
		
		for(int i = 0; i < randomIntegersOne.length; i++) {
			singleLinkedList.insert((i * 2), randomIntegersOne[i]);
		}
		
		for(int i = 0; i < concat.length; i++) {
			assertTrue(singleLinkedList.get(i) == concat[i]);
		}
		
		assertTrue(singleLinkedList.size() == 10);
	}
	
	@Test
	@DisplayName("Test insert value into empty single linked list.")
	void SingleLinkedListTest_Insert_005() {
		
		SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
		
		int randomInteger = random.nextInt();
		
		singleLinkedList.insert(0, randomInteger);
		
		assertTrue(singleLinkedList.get(0) == randomInteger && singleLinkedList.size() == 1);
	}
	
	@Test
	@DisplayName("Test insert value outside bounds of the single linked list.")
	void SingleLinkedListTest_Insert_006() {
		
		SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
		
		boolean result = false;
		
		int[] randomIntegers = {random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt()};
		
		for(int i = 0; i < randomIntegers.length; i++) {
			singleLinkedList.add(randomIntegers[i]);
		}
		
		try {
			singleLinkedList.insert((randomIntegers.length + 1), random.nextInt());
		}
		catch (IndexOutOfBoundsException e) {
			result = true;
		}
		
		assertTrue(result);
	}
	
	@Test
	@DisplayName("Test remove value from head of single linked list.")
	void SingleLinkedListTest_Remove_001() {
		
		SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
		
		int[] randomIntegers = {random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt()};
		
		for(int i = 0; i < randomIntegers.length; i++) {
			singleLinkedList.add(randomIntegers[i]);
		}
		
		int randomInteger = singleLinkedList.remove(0);
		
		assertTrue(randomIntegers[0] == randomInteger && singleLinkedList.size() == 4);
	}
	
	@Test
	@DisplayName("Test remove value from end of single linked list.")
	void SingleLinkedListTest_Remove_002() {
		
		SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
		
		int[] randomIntegers = {random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt()};
		
		for(int i = 0; i < randomIntegers.length; i++) {
			singleLinkedList.add(randomIntegers[i]);
		}
		
		int randomInteger = singleLinkedList.remove((randomIntegers.length - 1));
		
		assertTrue(randomIntegers[4] == randomInteger && singleLinkedList.size() == 4);
	}
	
	@Test
	@DisplayName("Test remove value from single linked list.")
	void SingleLinkedListTest_Remove_003() {
		
		SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
		
		int[] randomIntegers = {random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt()};
		
		for(int i = 0; i < randomIntegers.length; i++) {
			singleLinkedList.add(randomIntegers[i]);
		}
		
		int randomInteger = singleLinkedList.remove(2);
		
		assertTrue(randomIntegers[2] == randomInteger && singleLinkedList.size() == 4);
	}
	
	@Test
	@DisplayName("Test remove value from single linked list.")
	void SingleLinkedListTest_Remove_004() {
		
		SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
		
		int[] randomIntegers = {random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt()};
		
		for(int i = 0; i < randomIntegers.length; i++) {
			singleLinkedList.add(randomIntegers[i]);
		}
		
		for(int i = 4; i >= 0; i--) {
			assertTrue(singleLinkedList.remove(i * 2) == randomIntegers[i * 2]);
		}
		
		assertTrue(singleLinkedList.size() == 5);
	}
	
	@Test
	@DisplayName("Test remove value from empty single linked list.")
	void SingleLinkedListTest_Remove_005() {
		
		SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
		
		boolean result = false;
		
		try {
			int randomInteger = singleLinkedList.remove(0);
		}
		catch (IndexOutOfBoundsException e) {
			result = true;
		}
		
		assertTrue(result);
	}
	
	@Test
	@DisplayName("Test remove value outside the bounds of the single linked list.")
	void SingleLinkedListTest_Remove_006() {
		
		SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
		
		boolean result = false;
		
		int[] randomIntegers = {random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt()};
		
		for(int i = 0; i < randomIntegers.length; i++) {
			singleLinkedList.add(randomIntegers[i]);
		}
		
		try {
			int randomInteger = singleLinkedList.remove(randomIntegers.length);
		}
		catch (IndexOutOfBoundsException e) {
			result = true;
		}
		
		assertTrue(result);
	}

	@Test
	@DisplayName("Test size of single linked list after default initialisation.")
	void SingleLinkedListTest_size_001() {
		
		SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
		
		assertTrue(singleLinkedList.size() == 0);
	}
	
	@Test
	@DisplayName("Test size of single linked list after passing value with constructor.")
	void SingleLinkedListTest_size_002() {
		
		SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>(5);
		
		assertTrue(singleLinkedList.size() == 1);
	}
	
	@Test
	@DisplayName("Test size of single linked list after add.")
	void SingleLinkedListTest_size_003() {
		
		SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
		
		int numberOfElements = 50;
		
		for(int i = 0; i < numberOfElements; i++) {
			singleLinkedList.add(random.nextInt());
		}
		
		assertTrue(singleLinkedList.size() == numberOfElements);
	}
	
	@Test
	@DisplayName("Test size of single linked list after remove.")
	void SingleLinkedListTest_size_004() {
		
		SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
		
		int numberOfElements = 50;
		
		for(int i = 0; i < numberOfElements; i++) {
			singleLinkedList.add(random.nextInt());
		}
		
		for(int i = 0; i < 25; i++) {
			singleLinkedList.remove(i);
		}
		
		assertTrue(singleLinkedList.size() == 25);
	}
	
	@Test
	@DisplayName("Test size of single linked list after insert.")
	void SingleLinkedListTest_size_005() {
		
		SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
		
		int numberOfElements = 10;
		
		for(int i = 0; i < numberOfElements; i++) {
			singleLinkedList.add(random.nextInt());
		}
		
		singleLinkedList.insert(10, random.nextInt());
		singleLinkedList.insert(0, random.nextInt());
		singleLinkedList.insert(5, random.nextInt());
		
		assertTrue(singleLinkedList.size() == 13);
	}
	
	@Test
	@DisplayName("Test size of single linked list after clear.")
	void SingleLinkedListTest_size_006() {
		
		SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
		
		int numberOfElements = 50;
		
		for(int i = 0; i < numberOfElements; i++) {
			singleLinkedList.add(random.nextInt());
		}
		
		singleLinkedList.clear();
		
		assertTrue(singleLinkedList.size() == 0);
	}
	
	@Test
	@DisplayName("Test get after clear single linked list.")
	void SingleLinkedListTest_Clear_001() {
		
		SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
		
		boolean result = false;
		
		int[] randomIntegers = {random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt()};
		
		for(int i = 0; i < randomIntegers.length; i++) {
			singleLinkedList.add(randomIntegers[i]);
		}
		
		singleLinkedList.clear();
		
		try {
			int randomInteger = singleLinkedList.get(0);
		}
		catch (IndexOutOfBoundsException e) {
			result = true;
		}
		
		assertTrue(result && singleLinkedList.size() == 0);
	}
	
	@Test
	@DisplayName("Test remove after clear single linked list.")
	void SingleLinkedListTest_Clear_002() {
		
		SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
		
		boolean result = false;
		
		int[] randomIntegers = {random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt()};
		
		for(int i = 0; i < randomIntegers.length; i++) {
			singleLinkedList.add(randomIntegers[i]);
		}
		
		singleLinkedList.clear();
		
		try {
			int randomInteger = singleLinkedList.remove(0);
		}
		catch (IndexOutOfBoundsException e) {
			result = true;
		}
		
		assertTrue(result && singleLinkedList.size() == 0);
	}
	
	@Test
	@DisplayName("Test add after clear single linked list.")
	void SingleLinkedListTest_Clear_003() {
		
		SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
		
		boolean result = false;
		
		int[] randomIntegers = {random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt()};
		
		for(int i = 0; i < randomIntegers.length; i++) {
			singleLinkedList.add(randomIntegers[i]);
		}
		
		singleLinkedList.clear();
		
		int randomInteger = random.nextInt();
		
		singleLinkedList.add(randomInteger);
		
		assertTrue(singleLinkedList.get(0) == randomInteger && singleLinkedList.size() == 1);
	}
	
	@Test
	@DisplayName("Test insert after clear single linked list.")
	void SingleLinkedListTest_Clear_004() {
		
		SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
		
		boolean result = false;
		
		int[] randomIntegers = {random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt()};
		
		for(int i = 0; i < randomIntegers.length; i++) {
			singleLinkedList.add(randomIntegers[i]);
		}
		
		singleLinkedList.clear();
		
		int randomInteger = random.nextInt();
		
		singleLinkedList.insert(0, randomInteger);
		
		assertTrue(singleLinkedList.get(0) == randomInteger && singleLinkedList.size() == 1);
	}
	
}
