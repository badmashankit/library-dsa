/**
 * Copyright (C) 2017 Ankit Shukla, http://badmashankit.com
 * 
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.badmashankit.library;

import java.util.Iterator;

public class LinkedList<E> implements Iterable<E> {
	private Node head;
	private int size;

	public LinkedList() {
		head = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return head == null;
	}

	@SuppressWarnings("unchecked")
	public E get(int index) {
		checkRange(index);
		return (E) getNode(index).getData();
	}

	private Node getNode(int index) {
		Node ptr = head;
		while (index > 0 && ptr.getNext() != null) {
			index--;
			ptr = ptr.getNext();
		}
		return ptr;
	}

	public void add(E element) {
		Node node = new Node(element);
		size++;
		if (isEmpty())
			head = node;
		else {
			Node ptr = head;
			while (ptr.getNext() != null)
				ptr = ptr.getNext();
			ptr.setNext(node);
		}
	}

	public void add(int index, E element) {
		checkRange(index);
		size++;
		Node node = new Node(element);
		Node ptr = getNode(index - 1);
		node.setNext(ptr.getNext());
		ptr.setNext(node);
	}

	public void addFirst(E element) {
		if (isEmpty())
			add(element);
		else
			add(0, element);
	}

	public void addLast(E element) {
		add(element);
	}

	public void addAfter(E key, E element) {
		int index = indexOf(key);
		if (index == -1)
			throw new NoSuchElementException("Element : " + key);
		add(index + 1, element);
	}

	public void deleteFirst() {
		if (isEmpty())
			throw new EmptyLinkedListException();
		Node ptr = head.getNext();
		head.setNext(null);
		head = ptr;
		size--;
	}

	public void deleteLast() {
		if (isEmpty())
			throw new EmptyLinkedListException();
		if (size() == 1)
			deleteFirst();
		else {
			Node ptr = head;
			Node prev = null;
			while (ptr.getNext() != null) {
				prev = ptr;
				ptr = ptr.getNext();
			}
			prev.setNext(null);
			size--;
		}
	}

	public void delete(int index) {
		checkRange(index);
		Node ptr = getNode(index - 1);
		Node temp = ptr.getNext();
		ptr.setNext(temp.getNext());
		temp.setNext(null);
		size--;
	}

	public void delete(E key) {
		if (isEmpty())
			throw new EmptyLinkedListException();
		int index = indexOf(key);
		if (index == -1)
			throw new NoSuchElementException("Element : " + key);
		delete(index);
	}

	@SuppressWarnings("unchecked")
	public E findMid() {
		if (isEmpty())
			throw new EmptyLinkedListException();
		Node slow = head;
		Node fast = head;
		while (slow.getNext() != null && fast.getNext() != null && fast.getNext().getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		return (E) slow.getData();
	}

	public void reverse() {
		if (!isEmpty()) {
			Node prev = null;
			Node current = head;
			Node next = null;
			while (current != null) {
				next = current.getNext();
				current.setNext(prev);
				prev = current;
				current = next;
			}
			head = prev;
		}
	}

	public int indexOf(E element) {
		if (!isEmpty())
			return -1;
		int index = 0;
		if (element == null) {
			for (Node ptr = head; ptr != null; ptr = ptr.getNext()) {
				if (ptr.getData() == null)
					return index;
				index++;
			}
		} else {
			for (Node ptr = head; ptr != null; ptr = ptr.getNext()) {
				if (ptr.getData() == null)
					return index;
				index++;
			}
		}
		return -1;
	}

	public boolean contains(E element) {
		return indexOf(element) != -1;
	}

	public void checkRange(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Index : " + index + ", Size : " + size);
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			private int index = 0;

			@Override
			public boolean hasNext() {
				return index < size();
			}

			@Override
			public E next() {
				return get(index);
			}
		};
	}

	@Override
	public String toString() {
		if (isEmpty())
			return "[]";
		String str = "[";
		Node ptr = head;
		while (ptr != null && ptr.getNext() != null) {
			str += ptr.getData() + ", ";
			ptr = ptr.getNext();
		}
		str += ptr.getData() + "]";
		return str;
	}

	private class Node {
		private Object data;
		private Node next;

		public Node(Object data) {
			this.data = data;
		}

		public Object getData() {
			return data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
	}

	@SuppressWarnings("serial")
	private static class EmptyLinkedListException extends RuntimeException {
		public EmptyLinkedListException() {
			super();
		}
	}
}
