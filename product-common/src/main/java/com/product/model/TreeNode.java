package com.product.model;

import java.util.ArrayList;
import java.util.List;


public class TreeNode<T> {

	private boolean checked; // 勾选状态 
	
	private T node; // 父节点
	
	private List<TreeNode<T>> children = new ArrayList<TreeNode<T>>(); // 孩子节点

	/**
	 * 添加孩子节点
	 * @param t
	 */
	public void addChildren(TreeNode<T> t){
		children.add(t);
	}
	
	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
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
