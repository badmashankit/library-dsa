package com.badmashankit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.badmashankit.library.ArrayListTest;
import com.badmashankit.library.StackTest;

@RunWith(Suite.class)
@SuiteClasses({ ArrayListTest.class, StackTest.class })
public class AllTests {

}
