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

import com.badmashankit.library.Stack;

public class StackDriver {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < 10; i++)
			stack.push(2 * i);
		System.out.println("Initial Stack: " + stack);
		System.out.println("\nElement at the top: " + stack.peek());
		System.out.println("\nisEmpty: " + stack.isEmpty());
		System.out.println("\nPopping out an element: " + stack.pop());
		System.out.println("\nSize of the stack: " + stack.size());
		System.out.println("\nUsing iterator: ");
		for (int element : stack)
			System.out.print(element + "\t");
		stack.clear();
		System.out.println("\n\nStack after clear(): " + stack);
	}
}
