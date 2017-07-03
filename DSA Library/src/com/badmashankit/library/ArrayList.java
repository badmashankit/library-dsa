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

public class ArrayList<E> implements Iterable<E> {

	private Object[] elements;

	// Keeps track of the length of the internal array used
	private int length;

	// Keeps track of no. of elements in the list
	private int size;

	public ArrayList() {
		this(10);
	}

	public ArrayList(int length) {
		this.length = length;
		elements = new Object[length];
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}
	
	public void clear() {
		if(!isEmpty()) {
			length = 0;
			elements = new Object[length];
			size = 0;
		}
	}

	@SuppressWarnings("unchecked")
	public E get(int index) throws IndexOutOfBoundsException {
		checkRange(index);
		return (E) elements[index];
	}

	public int size() {
		return size;
	}

	public void add(E element) {
		doubleArrayIfOverflow(size + 1);
		elements[size++] = element;
	}

	public void add(int index, E element) throws IndexOutOfBoundsException {
		checkRange(index);
		doubleArrayIfOverflow(size + 1);
		for (int i = size; i > index; i--)
			elements[i] = elements[i - 1];
		elements[index] = element;
		size++;
	}

	public void remove(int index) throws IndexOutOfBoundsException {
		checkRange(index);
		if (index < size - 1) {
			// Shift elements to left by 1
			for (int i = index; i < size - 1; i++)
				elements[i] = elements[i + 1];
		}
		elements[size--] = null; // Decrease size by 1
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
				return get(index++);
			}
		};
	}
	
	@SuppressWarnings("unchecked")
	public E[] getElements() {
		return (E[]) elements;
	}

	@Override
	public String toString() {
		String str = "[";
		for (int i = 0; i < size - 1; i++)
			str += elements[i] + ", ";
		str += elements[size - 1] + "]";
		return str;
	}

	// This method doubles the size of array everytime the required size is
	// greater than the current size
	private void doubleArrayIfOverflow(int required) {
		if (required > length) {
			length *= 2;
			Object[] copy = new Object[length];
			for (int i = 0; i < size; i++)
				copy[i] = elements[i];
			elements = copy;
		}
	}

	// This method checks if the index is within the range of 0 to size - 1
	// (inclusive)
	private void checkRange(int index) {
		if (index >= size || index < 0)
			throw new IndexOutOfBoundsException("Index: " + index + ", Size : " + size);
	}
}
