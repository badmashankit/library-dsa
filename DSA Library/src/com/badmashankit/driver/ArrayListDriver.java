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

import com.badmashankit.library.ArrayList;

public class ArrayListDriver {

	public static void main(String[] args) {
		ArrayList<Double> list = new ArrayList<>();

		for (int i = 0; i < 50; i++) {
			list.add(2.0 * i);
		}

		System.out.println("Initial List: " + list);

		list.add(3, 25.0);
		System.out.println("\nAfter adding 25 at index 3: " + list);

		System.out.println("\nElement at index 5 : " + list.get(5));

		list.remove(2);
		System.out.println("\nAfter removing element at index 2: " + list);

		System.out.println("\nisEmpty : " + list.isEmpty());

		System.out.println("\nSize of the List : " + list.size());
	}
}
