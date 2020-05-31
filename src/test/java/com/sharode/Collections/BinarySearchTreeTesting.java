package com.sharode.Collections;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.sharode.BinarySearchTree.BinarySearchTree;
import com.sharode.BinarySearchTree.BinarySearchTreeNode;

public class BinarySearchTreeTesting {
	Random random = new Random();
	
	@Test
	@DisplayName("Test single node is inserted into tree.")
	void BinarySearchTreeTest_add_001() {
		
		BinarySearchTree<Integer> BST = new BinarySearchTree<Integer>();
		
		int randomInteger = random.nextInt();
		
		BST.add(randomInteger);
		
		BinarySearchTreeNode<Integer> result = BST.find(randomInteger);
		
		assertTrue(result.getLNode() == null && result.getRNode() == null && BST.contains(randomInteger) && BST.findParent(randomInteger) == null);
	}
	
	@Test
	@DisplayName("Test multiple nodes inserted in ascending order into tree.")
	void BinarySearchTreeTest_add_002() {
		
		BinarySearchTree<Integer> BST = new BinarySearchTree<Integer>();
		
		int[] randomIntegers = {random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt()};
		Arrays.sort(randomIntegers);
		
		for(int i = 0; i < randomIntegers.length; i++) {
			BST.add(randomIntegers[i]);
		}
		
		BinarySearchTreeNode<Integer> result = BST.find(randomIntegers[0]);
		
		for(int i = 0; i < randomIntegers.length; i++) {
			assertTrue(result.get() == randomIntegers[i]);
			result = result.getRNode();
		}
	}
	
	@Test
	@DisplayName("Test multiple nodes inserted in descending order into tree.")
	void BinarySearchTreeTest_add_003() {
		
		BinarySearchTree<Integer> BST = new BinarySearchTree<Integer>();
		
		Integer[] randomIntegers = {random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt()};
		Arrays.sort(randomIntegers, Collections.reverseOrder());
		
		for(int i = 0; i < randomIntegers.length; i++) {
			BST.add(randomIntegers[i]);
		}
		
		BinarySearchTreeNode<Integer> result = BST.find(randomIntegers[0]);
		
		for(int i = 0; i < randomIntegers.length; i++) {
			assertTrue(result.get() == randomIntegers[i]);
			result = result.getLNode();
		}
	}
	
	@Test
	@DisplayName("Test multiple nodes inserted into tree.")
	void BinarySearchTreeTest_add_004() {
		
		BinarySearchTree<Integer> BST = new BinarySearchTree<Integer>();
		
		Integer[] integers = {8, 3, 1, 6, 4, 7, 10, 14, 13};
		
		for(int i = 0; i < integers.length; i++) {
			BST.add(integers[i]);
		}
		
		BinarySearchTreeNode<Integer> result = BST.find(integers[0]);

		// Root Node
		assertTrue(result.getLNode().get() == 3 && result.getRNode().get() == 10 && BST.findParent(result.get()) == null);
		
		//Node with value 3
		assertTrue(result.getLNode().getLNode().get() == 1 && result.getLNode().getRNode().get() == 6 && BST.findParent(result.getLNode().get()).get() == 8);
		
		//Node with value 1
		assertTrue(result.getLNode().getLNode().getLNode() == null && result.getLNode().getLNode().getRNode() == null && BST.findParent(result.getLNode().getLNode().get()).get() == 3);
		
		//Node with value 6
		assertTrue(result.getLNode().getRNode().getLNode().get() == 4 && result.getLNode().getRNode().getRNode().get() == 7 && BST.findParent(result.getLNode().getRNode().get()).get() == 3);
		
		//Node with value 4
		assertTrue(result.getLNode().getRNode().getLNode().getLNode() == null && result.getLNode().getRNode().getLNode().getRNode() == null && BST.findParent(result.getLNode().getRNode().getLNode().get()).get() == 6);
		
		//Node with value 7
		assertTrue(result.getLNode().getRNode().getRNode().getLNode() == null && result.getLNode().getRNode().getRNode().getRNode() == null && BST.findParent(result.getLNode().getRNode().getRNode().get()).get() == 6);
		
		//Node with value 10
		assertTrue(result.getRNode().getLNode() == null && result.getRNode().getRNode().get() == 14 && BST.findParent(result.getRNode().get()).get() == 8);
		
		//Node with value 14
		assertTrue(result.getRNode().getRNode().getLNode().get() == 13 && result.getRNode().getRNode().getRNode() == null && BST.findParent(result.getRNode().getRNode().get()).get() == 10);
		
		//Node with value 13
		assertTrue(result.getRNode().getRNode().getLNode().getLNode() == null && result.getRNode().getRNode().getLNode().getRNode() == null && BST.findParent(result.getRNode().getRNode().getLNode().get()).get() == 14);
	}
	
	@Test
	@DisplayName("Test null inserted into tree.")
	void BinarySearchTreeTest_add_005() {
		
		BinarySearchTree<Integer> BST = new BinarySearchTree<Integer>();
		
		boolean result = true;
		
		int randomInteger = random.nextInt();
		
		try {
			BST.add(null);
			BST.add(randomInteger);
		}
		catch(NullPointerException e) {
			
			result = false;
		}
		
		assertTrue(result);
	}
	
	@Test
	@DisplayName("Test find root in tree.")
	void BinarySearchTreeTest_find_001() {
		
		BinarySearchTree<Integer> BST = new BinarySearchTree<Integer>();
		
		Integer[] randomIntegers = {random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt()};
		Integer root = 56;
		
		BST.add(root);
		
		for(int i = 0; i < randomIntegers.length; i++) {
			BST.add(randomIntegers[i]);
		}
		
		assertTrue(BST.find(root) != null && (BST.find(root).getLNode() != null && BST.find(root).getRNode() != null));
	}
	
	@Test
	@DisplayName("Test find on multiple integers in tree.")
	void BinarySearchTreeTest_find_002() {
		
		BinarySearchTree<Integer> BST = new BinarySearchTree<Integer>();
		
		Integer[] randomIntegers = {random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt()};
		
		for(int i = 0; i < randomIntegers.length; i++) {
			BST.add(randomIntegers[i]);
		}
		
		for(int i = 0; i < randomIntegers.length; i++) {
			assertTrue(BST.find(randomIntegers[i]) != null);
		}
	}
	
	@Test
	@DisplayName("Test find integer not in tree.")
	void BinarySearchTreeTest_find_003() {
		
		BinarySearchTree<Integer> BST = new BinarySearchTree<Integer>();
		
		Integer[] integers = {8, 3, 1, 6, 4, 7, 10, 14, 13};
		Integer notInTree = 56;
		
		for(int i = 0; i < integers.length; i++) {
			BST.add(integers[i]);
		}
		
		assertTrue(BST.find(notInTree) == null);
	}
	
	@Test
	@DisplayName("Test find on empty tree.")
	void BinarySearchTreeTest_find_004() {
		
		BinarySearchTree<Integer> BST = new BinarySearchTree<Integer>();
		
		Integer randomInteger = random.nextInt();
		
		assertTrue(BST.find(randomInteger) == null);
	}
	
	@Test
	@DisplayName("Test contains on multiple integers in tree.")
	void BinarySearchTreeTest_contains_001() {
		
		BinarySearchTree<Integer> BST = new BinarySearchTree<Integer>();
		
		Integer[] randomIntegers = {random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt()};
		
		for(int i = 0; i < randomIntegers.length; i++) {
			BST.add(randomIntegers[i]);
		}
		
		for(int i = 0; i < randomIntegers.length; i++) {
			assertTrue(BST.contains(randomIntegers[i]));
		}
	}
	
	@Test
	@DisplayName("Test contains on integer not in tree.")
	void BinarySearchTreeTest_contains_002() {
		
		BinarySearchTree<Integer> BST = new BinarySearchTree<Integer>();
		
		Integer[] integers = {8, 3, 1, 6, 4, 7, 10, 14, 13};
		Integer notInTree = 56;
		
		for(int i = 0; i < integers.length; i++) {
			BST.add(integers[i]);
		}
		
		assertTrue(!BST.contains(notInTree));
	}
	
	@Test
	@DisplayName("Test contains on empty tree.")
	void BinarySearchTreeTest_contains_003() {
		
		BinarySearchTree<Integer> BST = new BinarySearchTree<Integer>();
		
		Integer randomInteger = random.nextInt();
		
		assertTrue(!BST.contains(randomInteger));
	}

}
