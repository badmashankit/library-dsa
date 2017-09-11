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

public class ArrayListTest {
	private ArrayList<String> list;

	@Before
	public void setUp() {
		list = new ArrayList<>();
	}

	@Test
	public void testAdd() {
		for (int i = 1; i <= 40; i++) {
			list.add("Something " + i);
			assertEquals(i, list.size());
		}
	}

	@Test
	public void testSize() {
		list.add("ABC");
		list.add("DEF");
		list.add("GHI");
		assertEquals(3, list.size());
	}

	@Test
	public void testClear() {
		list.add("ABC");
		list.add("DEF");
		list.add("GHI");
		assertEquals(3, list.size());
		list.clear();
		assertEquals(0, list.size());
	}

	@Test
	public void testToString() {
		assertEquals("[]", list.toString());
		list.add("ABC");
		list.add("DEF");
		list.add("GHI");
		assertEquals("[ABC, DEF, GHI]", list.toString());
	}

	@Test
	public void testIsEmpty() {
		assertTrue(list.isEmpty());
		list.add("Something");
		assertFalse(list.isEmpty());
	}

	@Test
	public void testIterator() {
		list.add("ABC");
		list.add("DEF");
		list.add("GHI");
		String str = "";
		for(String value : list)
			str += value;
		assertEquals("ABCDEFGHI", str);
	}
	
	@Test
	public void testGet() {
		list.add("ABC");
		list.add("DEF");
		list.add("GHI");
		assertEquals("DEF", list.get(1));
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetException() {
		list.get(0);
	}
	
	@Test
	public void testAddIndex() {
		list.add("ABC");
		list.add("DEF");
		list.add("GHI");
		list.add(2, "XYZ");
		assertEquals(4, list.size());
		list.add(2, "OTP");
		assertEquals(5, list.size());
		assertEquals("[ABC, DEF, OTP, XYZ, GHI]", list.toString());
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testAddIndexException() {
		list.add(6, "ABC");
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveException() {
		list.remove(5);
	}
	
	@Test
	public void testRemove() {
		list.add("ABC");
		list.add("DEF");
		list.add("GHI");
		assertEquals(3, list.size());
		list.remove(1);
		assertEquals(2, list.size());
		assertEquals("[ABC, GHI]", list.toString());
	}
}
