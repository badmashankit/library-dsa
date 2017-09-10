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

	@Test(expected = EmptyStackException.class)
	public void testPopException() {
		stack.pop();
	}

}
