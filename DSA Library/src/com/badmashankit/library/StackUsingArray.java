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

import com.badmashankit.library.exceptions.EmptyStackException;
import com.badmashankit.library.exceptions.StackOverflowException;

public class StackUsingArray<E> implements Iterable<E> {
	private Object[] elements;
	private int top;
	private int length;

	public StackUsingArray() {
		this(10);
	}

	public StackUsingArray(int length) {
		this.length = length;
		elements = new Object[length];
		top = -1;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public void clear() {
		if (!isEmpty()) {
			elements = new Object[length];
			top = -1;
		}
	}

	public int size() {
		return top + 1;
	}

	@SuppressWarnings("unchecked")
	public E pop() {
		if (isEmpty())
			throw new EmptyStackException();
		return (E) elements[top--];
	}

	public void push(E element) {
		if (top + 1 == length)
			throw new StackOverflowException();
		elements[++top] = element;
	}

	@SuppressWarnings("unchecked")
	public E peek() {
		if (isEmpty())
			throw new EmptyStackException();
		return (E) elements[top];
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			private int index = 0;

			@Override
			public boolean hasNext() {
				return index < size();
			}

			@SuppressWarnings("unchecked")
			@Override
			public E next() {
				return (E) elements[index++];
			}
		};
	}
	
	@SuppressWarnings("unchecked")
	public E[] getElements() {
		return (E[]) elements;
	}
	
	@Override
	public String toString() {
		if (isEmpty())
			return "[]";
		String str = "[";
		for (int i = 0; i < top; i++)
			str += elements[i] + ", ";
		str += elements[top] + "]";
		return str;
	}
}
