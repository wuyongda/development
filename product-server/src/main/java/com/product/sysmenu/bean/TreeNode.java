package com.product.sysmenu.bean;

import java.util.ArrayList;
import java.util.List;


public class TreeNode<T> {

	private T node; // 父节点
	
	private List<TreeNode<T>> children = new ArrayList<TreeNode<T>>(); // 孩子节点

	/**
	 * 添加孩子节点
	 * @param t
	 */
	public void addChildren(TreeNode<T> t){
		children.add(t);
	}
	public T getNode() {
		return node;
	}

	public void setNode(T node) {
		this.node = node;
	}

	public List<TreeNode<T>> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode<T>> children) {
		this.children = children;
	}
	
	
}
