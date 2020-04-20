package com.sharode.Collections;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.sharode.Collections.ArrayList;

class ArrayListTesting {
	
	private Random random = new Random();
	
	@Test
	@DisplayName("Test add  single value to ArrayList.")
	public void ArrayListTest_AddAndGet_001()
	{
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		
		int randomInteger = random.nextInt();
		
		arrayList.add(randomInteger);
		
		assertTrue(arrayList.get(0) == randomInteger);
	}
	
	@Test
	@DisplayName("Test add multiple values to ArrayList.")
	public void ArrayListTest_AddAndGet_002()
	{
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		
		int[] randomIntegers = {random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt()};
		
		for(int i = 0; i < randomIntegers.length; i++) {
			arrayList.add(randomIntegers[i]);
		}
		
		for(int i = 0; i < randomIntegers.length; i++) {
			assertTrue(arrayList.get(i) == randomIntegers[i]);
		}
	}
	
	@Test
	@DisplayName("Test add values  more than capacity to test resize of ArrayList.")
	public void ArrayListTest_AddAndGet_003()
	{
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		
		int[] randomIntegers = new int[(arrayList.capacity() + 1)];
		
		for(int i = 0; i < randomIntegers.length; i++) {
			randomIntegers[i] = random.nextInt();
			arrayList.add(randomIntegers[i]);
		}
		
		for(int i = 0; i < randomIntegers.length; i++) {
			assertTrue(arrayList.get(i) == randomIntegers[i]);
		}
	}
	
	@Test
	@DisplayName("Test get value that is outside of array bounds.")
	public void ArrayListTest_AddAndGet_004()
	{
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		
		boolean result = false;
		
		int randomInteger = random.nextInt();
		
		arrayList.add(randomInteger);
		 
		try {
			arrayList.get(1);
		}
		catch (IndexOutOfBoundsException e) {
			result = true;
		}
		
		assertTrue(result);
	}
	
	@Test
	@DisplayName("Test IndexOutOfBounds for set method.")
	public void ArrayListTest_Set_001()
	{
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		
		boolean result = false;
		
		int randomInteger = random.nextInt();
		
		arrayList.add(random.nextInt());
		
		try {
			arrayList.set(1, randomInteger);
		}
		catch (IndexOutOfBoundsException e) {
			result = true;
		}
		
	    assertTrue(result);
	}
	
	@Test
	@DisplayName("Test value using get, after add.")
	public void ArrayListTest_Set_002()
	{
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		
		int[] randomIntegersOne = {random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt()};
		int[] randomIntegersTwo = {random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt()};
		
		for(int i = 0; i < randomIntegersOne.length; i++) {
			arrayList.add(randomIntegersOne[i]);
		}
		
		for(int i = 0; i < randomIntegersTwo.length; i++) {
			arrayList.set(i, randomIntegersTwo[i]);
		}
		
		for(int i = 0; i < randomIntegersTwo.length; i++) {
			assertTrue(arrayList.get(i) == randomIntegersTwo[i]);
		}
	}
	
	@Test
	@DisplayName("Test default capacity.")
	public void ArrayListTest_Capacity_001()
	{
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		
		boolean result = false;
		
		result = arrayList.capacity() == 10 ? true : false;
		
	    assertTrue(result);
	}
	
	@Test
	@DisplayName("Test capacity on initialisation.")
	public void ArrayListTest_Capacity_002()
	{
		ArrayList<Integer> arrayList = new ArrayList<Integer>(47);
		
		boolean result = false;
		
		result = arrayList.capacity() == 47 ? true : false;
		
	    assertTrue(result);
	}
	
	@Test
	@DisplayName("Test capacity after exceeded.")
	public void ArrayListTest_Capacity_003()
	{
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		
		boolean result = false;
		
		int initCapacity = (arrayList.capacity() + 1);
		
		for(int i = 0; i < initCapacity; i++) {
			arrayList.add(random.nextInt());
		}
		
		result = arrayList.capacity() == 20 ? true : false;
		
	    assertTrue(result);
	}
	
	@Test
	@DisplayName("Test capacity after clear.")
	public void ArrayListTest_Capacity_004()
	{
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		
		boolean result = false;
		
		int initCapacity = (arrayList.capacity() + 1);
		
		for(int i = 0; i < initCapacity; i++) {
			arrayList.add(random.nextInt());
		}
		
		arrayList.clear();
		
		result = arrayList.capacity() == 10 ? true : false;
		
	    assertTrue(result);
	}
	
	@Test
	@DisplayName("Test default size.")
	public void ArrayListTest_Size_001()
	{
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		
		boolean result = false;
		
		result = arrayList.size() == 0 ? true : false;
		
	    assertTrue(result);
	}
	
	@Test
	@DisplayName("Test size after add.")
	public void ArrayListTest_Size_002()
	{
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		
		boolean result = false;
		
		arrayList.add(random.nextInt());
		
		result = arrayList.size() == 1 ? true : false;
		
	    assertTrue(result);
	}
	
	@Test
	@DisplayName("Test size after set.")
	public void ArrayListTest_Size_003()
	{
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		
		boolean result = false;
		
		arrayList.add(random.nextInt());
		arrayList.add(random.nextInt());
		arrayList.add(random.nextInt());
		
		arrayList.set(1, random.nextInt());
		
		result = arrayList.size() == 3 ? true : false;
		
	    assertTrue(result);
	}
	
	@Test
	@DisplayName("Test size after clear.")
	public void ArrayListTest_Size_004()
	{
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		
		boolean result = false;
		
		arrayList.add(random.nextInt());
		arrayList.add(random.nextInt());
		arrayList.add(random.nextInt());
		arrayList.clear();
		
		result = arrayList.size() == 0 ? true : false;
		
	    assertTrue(result);
	}
	
}
