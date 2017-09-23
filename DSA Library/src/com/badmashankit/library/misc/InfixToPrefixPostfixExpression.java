/*
 *  Copyright (C) 2017 Ankit Shukla, http://badmashankit.com
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

package com.badmashankit.library.misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.badmashankit.library.Stack;

public class InfixToPrefixPostfixExpression {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the infix expression: ");
		String infix = "( " + br.readLine().trim() + " )";
		// Sample input: b * b - 4 * a * c
		// Sample output:
		// Postfix: b b * 4 a * c * -
		// Prefix: - * b b * 4 * a c
		try {
			String postfix = infixToPostfix(infix);
			String prefix = infixToPrefix(infix);
			System.out.println("Postfix: " + postfix.trim());
			System.out.println("Prefix:  " + prefix.trim());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private static String operators = "+-*/^";

	private static String infixToPrefix(String infix) {
		StringBuilder sb = new StringBuilder(infix);
		sb = sb.reverse();
		infix = sb.toString();
		String[] P = infix.split(" ");
		for (int i = 0; i < P.length; i++) {
			if (P[i].charAt(0) == '(')
				P[i] = ")";
			else if (P[i].charAt(0) == ')')
				P[i] = "(";
		}
		infix = String.join(" ", P);
		sb = new StringBuilder(infixToPostfix(infix));
		return sb.reverse().toString();
	}

	private static String infixToPostfix(String infix) {
		StringBuilder sb = new StringBuilder();
		String[] P = infix.split(" ");
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < P.length; i++) {
			if (operators.contains(P[i])) {
				while (!stack.isEmpty() && getPrecedence(stack.peek()) >= getPrecedence(P[i].charAt(0)))
					sb.append(" " + stack.pop());
				stack.push(P[i].charAt(0));
			} else if (P[i].charAt(0) == '(')
				stack.push(P[i].charAt(0));
			else if (P[i].charAt(0) == ')') {
				while (!stack.isEmpty() && stack.peek() != '(')
					sb.append(" " + stack.pop());
				stack.pop();
			} else
				sb.append(" " + P[i]);
		}
		while (!stack.isEmpty()) {
			if (stack.peek() != '(')
				sb.append(" " + stack.pop());
			else
				return "Invalid Expression";
		}
		return sb.toString().replaceAll("( )+", " ");
	}

	private static int getPrecedence(char operator) {
		int precedence = -1;
		switch (operator) {
		case '^':
			precedence = 3;
			break;
		case '/':
		case '*':
			precedence = 2;
			break;
		case '+':
		case '-':
			precedence = 1;
			break;
		default:
			break;
		}
		return precedence;
	}
}
