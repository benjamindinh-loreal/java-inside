package fr.umlv.labthree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Stream;


import static fr.umlv.labthree.ExprSwitches.*;

public class Main {
  
  public static void main(String[] args) {
        
        assertEquals("zero", ExprSwitches.intSwitch(0));
		assertEquals("one", ExprSwitches.intSwitch(1));
		assertEquals("a lot", ExprSwitches.intSwitch(2));
		assertEquals("zero", ExprSwitches.intSwitch(3));
        
        assertEquals("zero", ExprSwitches.exprIntSwitch(0));
		assertEquals("one", ExprSwitches.exprIntSwitch(1));
		assertEquals("a lot", ExprSwitches.exprIntSwitch(2));
		assertEquals("zero", ExprSwitches.exprIntSwitch(3));
        
        assertEquals("zero", ExprSwitches.intSwitch2(0));
		assertEquals("one", ExprSwitches.intSwitch2(10));
		assertEquals("a lot", ExprSwitches.intSwitch2(100));
		assertEquals("zero", ExprSwitches.intSwitch2(3));
        
        assertEquals("zero", ExprSwitches.exprIntSwitch2(0));
		assertEquals("one", ExprSwitches.exprIntSwitch2(10));
		assertEquals("a lot", ExprSwitches.exprIntSwitch2(100));
		assertEquals("zero", ExprSwitches.exprIntSwitch2(3));
        
        assertEquals("zero", ExprSwitches.stringSwitch("foo"));
		assertEquals("one", ExprSwitches.stringSwitch("bar"));
		assertEquals("a lot", ExprSwitches.stringSwitch("baz"));
		assertEquals("zero", ExprSwitches.stringSwitch("viva zorg"));
      
        assertEquals("zero", ExprSwitches.exprStringSwitch("foo"));
		assertEquals("one", ExprSwitches.exprStringSwitch("bar"));
		assertEquals("a lot", ExprSwitches.exprStringSwitch("baz"));
		assertEquals("zero", ExprSwitches.exprStringSwitch("viva zorg"));
        
        assertEquals("zero", ExprSwitches.enumSwitch(ExprSwitches.Messages.DEBUG));
		assertEquals("one", ExprSwitches.enumSwitch(ExprSwitches.Messages.WARNING));
		assertEquals("a lot", ExprSwitches.enumSwitch(ExprSwitches.Messages.INFO));
		assertEquals("zero", ExprSwitches.enumSwitch(ExprSwitches.Messages.ERROR));
        
        assertEquals("zero", ExprSwitches.exprEnumSwitch(ExprSwitches.Messages.DEBUG));
		assertEquals("one", ExprSwitches.exprEnumSwitch(ExprSwitches.Messages.WARNING));
		assertEquals("a lot", ExprSwitches.exprEnumSwitch(ExprSwitches.Messages.INFO));
		assertEquals("zero", ExprSwitches.exprEnumSwitch(ExprSwitches.Messages.ERROR));
      
        
  }
}
