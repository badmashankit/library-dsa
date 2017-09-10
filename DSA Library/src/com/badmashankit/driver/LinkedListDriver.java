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

package com.badmashankit.driver;

import com.badmashankit.library.LinkedList;

public class LinkedListDriver {

	public static void main(String[] args) {
		LinkedList<Double> list = new LinkedList<>();
		for (int i = 0; i < 50; i++)
			list.add(2.0 * i);
		System.out.println("Initial List: " + list);
		list.add(3, 25.0);
		System.out.println("\nAfter adding 25.0 at index 3: " + list);
		System.out.println("\nElement at index 5: " + list.get(5));
		list.addAfter(26.0, 29.0);
		System.out.println("\nAfter adding 29.0 after 26.0: " + list);
		list.addFirst(102.0);
		System.out.println("\nAfter adding 102.0 at first position: " + list);
		list.delete(2);
		System.out.println("\nAfter removing element at index 2: " + list);
		System.out.println("\nisEmpty : " + list.isEmpty());
		System.out.println("\nSize of the List: " + list.size());
		System.out.println("\nList contains 29.0: " + list.contains(29.0));
		System.out.println("\nIndex of 96.0 in list: " + list.indexOf(96.0));
		System.out.println("\nMid value for the list: " + list.findMid());
		list.reverse();
		System.out.println("\nAfter reversing the list: " + list);
		System.out.print("\nTesting iterator: ");
		for (double d : list)
			System.out.print(d + "\t");
	}
}
