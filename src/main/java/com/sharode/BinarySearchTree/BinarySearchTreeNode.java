package com.sharode.BinarySearchTree;

public class BinarySearchTreeNode<E extends Comparable<E>> {
	
	private E data;
	
	protected BinarySearchTreeNode<E> lNode;
	protected BinarySearchTreeNode<E> rNode;
	
	BinarySearchTreeNode(E data) {
		this.data = data;
		lNode = null;
		rNode = null;
	}
	
	BinarySearchTreeNode(E data, BinarySearchTreeNode<E> left, BinarySearchTreeNode<E> right) {
		this.data = data;
		lNode = left;
		rNode = right;
	}
	
    /**
     * Traverse tree recursively until empty space is found, then new node is inserted.
     * 
     * @param	data - Data to be added to tree
     */
	public void insert(E data) {
		if(this.data.compareTo(data) < 0) {
			if(rNode != null) {
				rNode.insert(data);
			}
			else {
				rNode = new BinarySearchTreeNode<E>(data) ;
			}
		}
		else {
			if(lNode != null) {
				lNode.insert(data);
			}
			else {
				lNode = new BinarySearchTreeNode<E>(data) ;
			}
		}
	}
	
    /**
     * Traverse tree recursively searching for data parameter.
     * 
     * @param	data - Data to find in tree
     * @return	node if found, null if not found
     */
	public BinarySearchTreeNode<E> find(E data){
		int temp = this.data.compareTo(data);
		
		if(temp == 0) {
			return this;
		}
		
		if(temp < 0) {
			return (rNode == null) ? null : rNode.find(data);
		}
		else {
			return (lNode == null) ? null : lNode.find(data);
		}
	}
	
    /**
     * Traverse tree recursively searching for parent of data parameter.
     * 
     * @param	data - Data to find in tree
     * @return	parent of node if found, null if not found
     */
	public BinarySearchTreeNode<E> findParent(E data, BinarySearchTreeNode<E> parent){
		int temp = this.data.compareTo(data);
		
		if(temp == 0) {
			return parent;
		}
		
		if(temp < 0) {
			return (rNode == null) ? null : rNode.findParent(data, this);
		}
		else {
			return (lNode == null) ? null : lNode.findParent(data, this);
		}
	}
	
	/**
	 * @return	node data
	 */
	public E get() {
		return data;
	}
	
	/**
	 * @return	left node
	 */
	public BinarySearchTreeNode<E> getLNode() {
		return lNode;
	}

	
	/**
	 * @return	right node
	 */
	public BinarySearchTreeNode<E> getRNode() {
		return rNode;
	}


}
