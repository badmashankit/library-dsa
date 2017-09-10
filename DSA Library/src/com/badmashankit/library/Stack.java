package com.badmashankit.library;

import java.util.Iterator;

import com.badmashankit.library.exceptions.EmptyStackException;

public class Stack<E> implements Iterable<E> {
	private Node top;
	private int size;

	public Stack() {
		top = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public void clear() {
		if (!isEmpty()) {
			Node ptr = top;
			while (ptr != null) {
				Node next = ptr.getNext();
				ptr.setNext(null);
				ptr.setData(null);
				ptr = next;
			}
			size = 0;
			top = null;
		}
	}

	@SuppressWarnings("unchecked")
	public E pop() {
		if (isEmpty())
			throw new EmptyStackException();
		E element = (E) top.getData();
		Node ptr = top;
		top = top.getNext();
		ptr.setNext(null);
		size--;
		return element;
	}

	public void push(E element) {
		Node node = new Node(element);
		if (isEmpty())
			top = node;
		else {
			node.setNext(top);
			top = node;
		}
		size++;
	}

	@SuppressWarnings("unchecked")
	public E peek() {
		if (isEmpty())
			throw new EmptyStackException();
		return (E) top.getData();
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			private Node ptr = top;

			@Override
			public boolean hasNext() {
				return ptr != null;
			}

			@SuppressWarnings("unchecked")
			@Override
			public E next() {
				E val = (E) ptr.getData();
				ptr = ptr.getNext();
				return val;
			}
		};
	}

	@SuppressWarnings("unchecked")
	public E[] getElements() {
		if (isEmpty())
			throw new EmptyStackException();
		E[] elements = (E[]) new Object[size];
		Node ptr = top;
		int index = 0;
		while (ptr != null) {
			elements[index++] = (E) ptr.getData();
			ptr = ptr.getNext();
		}
		return elements;
	}

	@Override
	public String toString() {
		if (isEmpty())
			return "[]";
		String str = "[";
		Node ptr = top;
		while (ptr != null && ptr.getNext() != null) {
			str += ptr.getData() + ", ";
			ptr = ptr.getNext();
		}
		str += ptr.getData() + "]";
		return str;
	}

	private class Node {
		Object data;
		Node next;

		public Node(Object data) {
			this.data = data;
		}

		public Object getData() {
			return data;
		}

		public Node getNext() {
			return next;
		}

		public void setData(Object data) {
			this.data = data;
		}

		public void setNext(Node next) {
			this.next = next;
		}
	}
}
