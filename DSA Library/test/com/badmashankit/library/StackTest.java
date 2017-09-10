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

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.badmashankit.library.exceptions.EmptyStackException;

public class StackTest {
	private Stack<Long> stack;

	@Before
	public void setUp() throws Exception {
		stack = new Stack<>();
	}
	
	@Test
	public void testPop() {
		stack.push(25L);
		stack.push(30L);
		stack.push(9L);
		assertEquals(Long.valueOf(9L), stack.pop());
		assertEquals(2, stack.size());
		assertEquals(Long.valueOf(30L), stack.pop());
		assertEquals(1, stack.size());
		assertEquals(Long.valueOf(25L), stack.pop());
		assertEquals(0, stack.size());
	}

	@Test(expected = EmptyStackException.class)
	public void testPopException() {
		stack.pop();
	}

	@Test
	public void testPush() {
		stack.push(25L);
		assertEquals(1, stack.size());
		stack.push(28L);
		assertEquals(2, stack.size());
		stack.push(15L);
		assertEquals(3, stack.size());
	}

	@Test
	public void testSize() {
		stack.push(25L);
		stack.push(28L);
		stack.push(15L);
		assertEquals(3, stack.size());
	}
	
	@Test
	public void testClear() {
		stack.push(25L);
		stack.push(28L);
		stack.push(15L);
		assertEquals(3, stack.size());
		stack.clear();
		assertEquals(0, stack.size());
	}
	
	@Test
	public void testPeek() {
		stack.push(25L);
		stack.push(28L);
		stack.push(15L);
		assertEquals(Long.valueOf(15L), stack.peek());
	}
	
	@Test
	public void testToString() {
		assertEquals("[]", stack.toString());
		stack.push(25L);
		stack.push(28L);
		stack.push(15L);
		assertEquals("[15, 28, 25]", stack.toString());
	}
	
	@Test
	public void testIsEmpty() {
		assertTrue(stack.isEmpty());
		stack.push(25L);
		assertFalse(stack.isEmpty());
	}
	
	@Test(expected = EmptyStackException.class)
	public void testPeekException() {
		stack.peek();
	}
	
	@Test
	public void testIterator() {
		stack.push(25L);
		stack.push(15L);
		stack.push(96L);
		stack.push(12L);
		long sum = 0L;
		for(long element : stack) {
			sum += element;
		}
		assertEquals(148L, sum);
	}
	
	@Test
	public void testEquals() {
		stack.push(25L);
		stack.push(15L);
		stack.push(null);
		stack.push(12L);
		assertEquals(stack, stack);
		Stack<Long> stack2 = new Stack<>();
		stack2.push(25L);
		stack2.push(15L);
		stack2.push(null);
		stack2.push(12L);
		assertEquals(stack, stack2);
		assertEquals(stack.hashCode(), stack2.hashCode());
		assertNotEquals(stack, new Object());
		assertNotEquals(stack, null);
		stack2 = new Stack<>();
		stack2.push(25L);
		stack2.push(null);
		stack2.push(null);
		stack2.push(12L);
		assertNotEquals(stack, stack2);
		stack2 = new Stack<>();
		stack2.push(25L);
		stack2.push(96L);
		stack2.push(null);
		stack2.push(12L);
		stack2.push(100L);
		assertNotEquals(stack, stack2);
		stack2 = new Stack<>();
		stack2.push(25L);
		stack2.push(96L);
		stack2.push(15L);
		stack2.push(12L);
		assertNotEquals(stack, stack2);
	}
}
