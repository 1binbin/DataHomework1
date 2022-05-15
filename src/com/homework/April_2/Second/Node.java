package com.homework.April_2.Second;

public class Node<T> {
	private T data;
	public Node<T> next;
	public Node() {
		data = null;
		next = null;
	}
	public Node(T x, Node<T> next) {
		this.data = x;
		this.next = next;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}
}
