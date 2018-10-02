package fr.umlv.labtwo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

@SuppressWarnings("static-method")
class SwitchTests {
  // pro requires the test class to finish with 'Tests'
  
  @Test
  void checkIntSwitch() {
	  
	  Switches s = new Switches() ;
	  
	  assertEquals(null, s.intSwitch(-1));
	  assertEquals("zero", s.intSwitch(0));
	  assertEquals("one", s.intSwitch(1));
	  assertEquals("a lot", s.intSwitch(2));
  }
  
  
}
