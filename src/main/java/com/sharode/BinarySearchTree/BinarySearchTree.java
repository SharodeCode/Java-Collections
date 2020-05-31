package com.sharode.BinarySearchTree;

public class BinarySearchTree<E extends Comparable<E>> {
	
	private BinarySearchTreeNode<E> root;
	
	public BinarySearchTree() {
		root = null;
	}
	
	//TODO: Handle adding duplicates
	
    /**
     * Adds data to tree.
     * 
     * @param	data - Data to be added to tree
     */
	public void add(E data) {
		
		if(data == null) {
			return;
		}
		
		if(root == null) {
			root = new BinarySearchTreeNode<E>(data);
		}
		else {
			root.insert(data);
		}
	}
	
    /**
     * Finds node in tree.
     * 
     * @param	data - Data to find in tree
     * @return	node if found, null if not found
     */
	public BinarySearchTreeNode<E> find(E data) {
		
		if(root == null) {
			return null;
		}
		
		if(root.get() == data){
			return root;
		}
		
		return root.find(data);
	}
	
    /**
     * Finds parent of node in tree.
     * 
     * @param	data - Data of child to find parent in tree
     * @return	parent of node if found, null if not found
     */
	public BinarySearchTreeNode<E> findParent(E data) {
		
		if(root == null || root.get() == data) {
			return null;
		}
		
		return root.findParent(data, null);
	}
	
    /**
     * Determine if tree contains node with same value as parameter.
     * 
     * @param	data - Data of node to find
     * @return	true if found, false if not
     */
	public boolean contains(E data) {
		if(root == null) {
			return false;
		}
		else {
			return (root.find(data) != null);
		}
	}
	
}
