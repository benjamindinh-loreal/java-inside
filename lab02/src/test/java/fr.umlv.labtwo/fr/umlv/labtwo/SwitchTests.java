package fr.umlv.labtwo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

@SuppressWarnings("static-method")
class SwitchTests {
  // pro requires the test class to finish with 'Tests'
  
  static class TestData{
	public TestData(int[] t, IntFunction object, String[] r) {
		i = t ;
		intF = object ;
	}
	  
	private int[] i ;
	private IntFunction intF ;
  }
	
  @Test
  void checkIntSwitch() {
	  
	  assertThrows(IllegalArgumentException.class, () -> Switches.intSwitch(-1));
	  assertEquals("zero", Switches.intSwitch(0));
	  assertEquals("one", Switches.intSwitch(1));
	  assertEquals("a lot", Switches.intSwitch(2));
  }
  
  @ParameterizedTest
  @MethodSource("testWithSimpleMethodSourceHavingNoValue")
  void testWithSimpleMethodSourceHavingNoValue(Map.Entry<IntFunction, V>()) {
	  assertThrows(IllegalArgumentException.class, () -> intF.apply(-1));
	  assertEquals("zero", intF.apply(0));
	  assertEquals("one", intF.apply(1));
	  assertEquals("a lot", intF.apply(2));
  }

  @SuppressWarnings("deprecation")
  static Stream<TestData> testWithSimpleMethodSourceHavingNoValue2() {
	  
	  ArrayList<TestData> al = new ArrayList<>() ;
	  
	  int t[] = new int[] {0,1,2,3} ;
	  
	  al.add(new TestData(t,Switches::intSwitch)) ;
	  al.add(new TestData(t,Switches::intSwitch2)) ;
	  
	  return al.stream() ;
    		  
  }
  
  
}
